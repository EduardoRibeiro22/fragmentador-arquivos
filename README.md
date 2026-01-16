# 📌 Projeto Java – Logging com SLF4J e Logback

## 📖 Descrição

Este projeto é uma aplicação desenvolvida **inteiramente em Java**, cujo principal objetivo é **estudar, aplicar e refatorar mecanismos de logging**, evoluindo desde a API clássica `java.logging` até o uso profissional do **SLF4J em conjunto com o Logback**.

Ao longo dos commits, o projeto passou por melhorias estruturais, organização do versionamento e substituição gradual de abordagens antigas por **boas práticas utilizadas no mercado**.

---

## 🧭 Evolução do Projeto (baseado nos commits)

* **Primeiro commit – Projeto original**
  Estrutura inicial da aplicação Java.

* **Ajustes de versionamento**
  Configuração correta do `.gitignore`, remoção de arquivos de IDE e correção de versionamento indevido.

* **Refatoração com API clássica de logging**
  Uso inicial da API `java.logging` para entendimento dos conceitos básicos de log.

* **Introdução do SLF4J**
  Adoção da API SLF4J para desacoplar o código da implementação de logging.

* **Integração com Logback**
  Substituição da implementação padrão por **Logback**, com configuração via `logback.xml`.

* **Versão final**
  Código refatorado, logging configurado corretamente e projeto estabilizado.

---

## 🛠️ Tecnologias Utilizadas

* **Java**
* **Maven**
* **SLF4J** (API de logging)
* **Logback** (implementação de logging)
* **Git / GitHub**

---

## 🧩 Arquitetura de Logging

* O código utiliza **SLF4J** como API
* O **Logback** é responsável pela implementação
* A configuração de logs é feita através do arquivo:

```
src/main/resources/logback.xml
```

### Funcionalidades de log:

* Saída no **console**
* Saída em **arquivo**
* Formatação personalizada
* Níveis de log configuráveis (`TRACE`, `DEBUG`, `INFO`, `WARN`, `ERROR`)

---

## ▶️ Como Executar

1. Clone o repositório:

```bash
git clone <url-do-repositorio>
```

2. Acesse o diretório do projeto:

```bash
cd nome-do-projeto
```

3. Compile e execute com Maven:

```bash
mvn clean install
mvn exec:java
```

---

## 🎯 Objetivo Educacional

Este projeto tem caráter **educacional**, com foco em:

* Entender a diferença entre **API e implementação**
* Aplicar **boas práticas de logging em Java**
* Aprender organização de projetos Maven
* Evoluir código através de commits claros e progressivos

---

## 👤 Autor

**Eduardo Ribeiro**
Projeto desenvolvido para fins de estudo em Java e boas práticas de desenvolvimento.

---

## 📄 Licença

Este projeto é de uso livre para fins de estudo.
