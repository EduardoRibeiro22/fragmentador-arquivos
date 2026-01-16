package com.algaworks.arquivos;

import com.algaworks.arquivos.fragmentador.FragmentadorDeArquivo;

import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {
    public static final Logger logger = Logger.getLogger(Principal.class.getName());

    public static void main(String[] args) {
        try {
            logger.info("Iniciando programa de fragmentação...");
//            System.out.println("INFO: Iniciando programa de fragmentação...");
            var fragmentador = new FragmentadorDeArquivo(
                    Path.of("fotos/picanha.jpg"),
                    1024 * 50);
            fragmentador.fragmentar();
            logger.info("Fragmentação concluída com sucesso! ");
//            System.out.println("INFO: Fragmentação concluída com sucesso!");
        } catch (Exception e) {
            logger.log(Level.SEVERE,"Erro fragmentando arquivo");
//            System.out.println("Erro fragmentando arquivo");
            e.printStackTrace();
        }
    }

}
