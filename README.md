# Biblioteca Virtual e Física - Sistema de Gerenciamento  

Este projeto consiste em um sistema simples de gerenciamento de biblioteca, implementado em Java. Ele permite a manipulação de livros físicos e digitais, além de incluir funcionalidades de busca, empréstimo, reserva e geração de relatórios. O sistema também gerencia usuários (alunos e professores) e utiliza arquivos `.txt` para persistência de dados.

---

## **Índice**  
- [Descrição do Projeto](#descrição-do-projeto)  
- [Funcionalidades](#funcionalidades)  
- [Estrutura do Projeto](#estrutura-do-projeto)  
- [Tecnologias Utilizadas](#tecnologias-utilizadas)  
- [Como Executar o Projeto](#como-executar-o-projeto)  
- [Exemplo de Uso](#exemplo-de-uso)  
- [Contribuição](#contribuição)  

---

## **Descrição do Projeto**  

O objetivo principal deste projeto é fornecer uma interface para gerenciamento de uma biblioteca que contemple diferentes tipos de livros (físicos e digitais) e usuários (alunos e professores). O sistema possui funcionalidades básicas de uma biblioteca, como adicionar, emprestar e listar livros, bem como persistir os dados em arquivos para garantir que informações sejam mantidas entre as execuções do programa.  

---

## **Funcionalidades**

### **Livros**
1. **Adicionar livros**:  
   - Permite adicionar livros físicos e digitais.  
2. **Listar livros**:  
   - Exibe todos os livros cadastrados.  
3. **Buscar livros**:  
   - Permite buscar livros por critérios como título.  
4. **Emprestar livros**:  
   - Registra o empréstimo de livros físicos e digitais.  
5. **Reservar livros**:  
   - Adiciona uma funcionalidade de reserva de livros.  
6. **Relatórios**:  
   - Gera um relatório detalhado de todos os livros cadastrados.  

### **Usuários**
1. **Cadastrar usuários**:  
   - Alunos e professores podem ser cadastrados no sistema.  
2. **Exibir informações**:  
   - Exibe os dados cadastrados de cada usuário.  

### **Persistência de Dados**  
O sistema utiliza a classe `ArquivoUtil` para leitura e gravação de arquivos `.txt`, garantindo que os livros cadastrados sejam salvos entre as sessões.  

---

## **Estrutura do Projeto**  

A estrutura de pastas e classes está organizada da seguinte forma:  

```
src/  
├── exceptions/  
│   ├── LivroNaoEncontradoException.java  
│   ├── UsuarioNaoEncontradoException.java  
│  
├── interfaces/  
│   ├── Buscavel.java  
│   ├── Emprestavel.java  
│   ├── Exibivel.java  
│   ├── Relatavel.java  
│   ├── Reservavel.java  
│  
├── models/  
│   ├── AcaoBiblioteca.java  
│   ├── Livro.java  
│   ├── LivroFisico.java  
│   ├── LivroDigital.java  
│   ├── Usuario.java  
│   ├── UsuarioAluno.java  
│   ├── UsuarioProfessor.java  
│  
├── services/  
│   ├── ArquivoUtil.java  
│   ├── Biblioteca.java  
│  
└── Main.java  
```  

---

## **Tecnologias Utilizadas**  

- **Linguagem**: Java 8 ou superior  
- **Persistência**: Arquivos `.txt`  
- **Paradigma**: Programação Orientada a Objetos (POO)  
- **Design**: Interface e abstração para modularidade  

---

## **Como Executar o Projeto**

1. **Pré-requisitos:**  
   - Ter o Java JDK 8 ou superior instalado.  
   - Um editor ou IDE, como IntelliJ IDEA ou Eclipse.  

2. **Passos para execução:**  
   - Clone o repositório:  
     ```bash  
     git clone <URL_DO_REPOSITORIO>  
     cd biblioteca  
     ```  
   - Compile o código:  
     ```bash  
     javac -d bin src/**/*.java  
     ```  
   - Execute a aplicação:  
     ```bash  
     java -cp bin Main  
     ```  

---

