package com.algaworks.arquivos.fragmentador;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import static java.nio.file.StandardOpenOption.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FragmentadorDeArquivo {

    private static final Logger logger = LoggerFactory.getLogger(FragmentadorDeArquivo.class);

    private final Path arquivo;
    private final int tamanhoFragmento;

    public FragmentadorDeArquivo(Path arquivo, int tamanhoFragmento) {
        Objects.requireNonNull(arquivo);
        if (tamanhoFragmento < 1) {
            throw new IllegalArgumentException("Tamanho do fragmento deve ser a partir de 1 byte");
        }

        this.arquivo = arquivo;
        this.tamanhoFragmento = tamanhoFragmento;

        if (this.tamanhoFragmento < (1024 * 100)) {

            logger.warn("Tamanho dos fragmentos muito pequeno. Considere aumentar para no mínimo 100kb");
//           System.out.println("WARN: Tamanho dos fragmentos muito pequeno. Considere aumentar para no mínimo 100kb");
        }
    }

    public void fragmentar() throws IOException {
        logger.info("Fragmentação invocada para arquivo original" + arquivo
                + " com fragmentos de até " + tamanhoFragmento + " bytes");
//        System.out.println("DEBUG: Fragmentação invocada para arquivo original " + arquivo
//                + " com fragmentos de até " + tamanhoFragmento + " bytes");
        ByteBuffer buffer = ByteBuffer.allocate(tamanhoFragmento);
        try (var canalLeitura = Files.newByteChannel(arquivo, READ)) {
            int numeroFragmento = 1;

            while (canalLeitura.read(buffer) > 0) {

                    logger.trace("Lendo buffer de fragmento " + numeroFragmento);
//                System.out.println("TRACE: Lendo buffer de fragmento " + numeroFragmento);
                buffer.flip();
                Path arquivoFragmento = criarArquivoFragmento(numeroFragmento++);
                escreverFragmento(arquivoFragmento, buffer);
                buffer.clear();
            }
        }
    }

    private Path criarArquivoFragmento(int numeroFragmento) {
        return Path.of(arquivo.toAbsolutePath().toString() + "." + numeroFragmento);
    }

    private void escreverFragmento(Path arquivoFragmento, ByteBuffer buffer) throws IOException {
        logger.trace("Escrevendo fragmento em " + arquivoFragmento.getFileName());

//        System.out.println("TRACE: Escrevendo fragmento em " + arquivoFragmento.getFileName());
        try (var canalEscrita = Files.newByteChannel(arquivoFragmento, CREATE_NEW, WRITE)) {
            canalEscrita.write(buffer);
        }
    }

}
