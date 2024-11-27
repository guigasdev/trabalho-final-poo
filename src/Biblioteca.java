import exceptions.LivroNaoEncontradoException;
import models.*;

import java.util.Scanner;

public class Biblioteca {

    private services.Biblioteca biblioteca;
    private Scanner scanner;

    public Biblioteca() {
        biblioteca = new services.Biblioteca("livros.txt");
        scanner = new Scanner(System.in);
    }

    public void abrirConsole() {
        while (true) {
            System.out.println("\n--- Biblioteca ---");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Emprestar Livro");
            System.out.println("4. Buscar Livro");
            System.out.println("5. Criar Usuário");
            System.out.println("6. Listar Usuários");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarLivro();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    emprestarLivro();
                    break;
                case 4:
                    buscarLivro();
                    break;
                case 5:
                    criarUsuario();
                    break;
                case 6:
                    listarUsuarios();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
    private void criarUsuario() {
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a idade do usuário: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Escolha o tipo de usuário:");
        System.out.println("1. Aluno");
        System.out.println("2. Professor");
        System.out.print("Opção: ");
        int tipoUsuario = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario = null;

        if (tipoUsuario == 1) {
            System.out.print("Digite a matrícula do aluno: ");
            String matricula = scanner.nextLine();
            usuario = new UsuarioAluno(nome, matricula);
        } else if (tipoUsuario == 2) {
            System.out.print("Digite a matrícula do professor: ");
            String matricula = scanner.nextLine();
            usuario = new UsuarioProfessor(nome, matricula);
        } else {
            System.out.println("Opção de tipo de usuário inválida!");
            return;
        }

        // Salvar o usuário no arquivo
        usuarios.add(usuario);
        salvarUsuarios();

        System.out.println("Usuário criado com sucesso!");
        usuario.exibir();
    }

    private void adicionarLivro() {
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite o autor do livro: ");
        String autor = scanner.nextLine();

        System.out.println("Selecione o tipo do livro (1 - Físico, 2 - Digital): ");
        System.out.print("Opção: ");
        int tipoOpcao = scanner.nextInt();
        scanner.nextLine();

        Livro livro = null;
        if (tipoOpcao == 1) {
            livro = new LivroFisico(titulo, autor);
        } else if (tipoOpcao == 2) {
            livro = new LivroDigital(titulo, autor);
        } else {
            System.out.println("Opção de tipo inválida!");
            return;
        }

        biblioteca.adicionarLivro(livro);
        System.out.println("Livro adicionado com sucesso!");
    }

    private void listarLivros() {
        System.out.println("\n--- Lista de Livros ---");
        StringBuilder livros = new StringBuilder();
        for (Livro livro : biblioteca.listarLivros()) {
            livros.append(livro.getTitulo()).append(" - ")
                    .append(livro.getAutor()).append(" - ")
                    .append(livro.getTipo()).append("\n");
        }
        if (livros.length() == 0) {
            System.out.println("Nenhum livro encontrado.");
        } else {
            System.out.println(livros.toString());
        }
    }

    private void emprestarLivro() {
        System.out.print("Digite o título do livro para emprestar: ");
        String titulo = scanner.nextLine();

        try {
            biblioteca.emprestarLivro(titulo);
            System.out.println("Livro emprestado com sucesso!");
        } catch (LivroNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void buscarLivro() {
        System.out.print("Digite o nome do livro: ");
        String criterio = scanner.nextLine();
        biblioteca.buscar(criterio);
    }
    private void criarUsuario() {
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a idade do usuário: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Escolha o tipo de usuário:");
        System.out.println("1. Aluno");
        System.out.println("2. Professor");
        System.out.print("Opção: ");
        int tipoUsuario = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario = null;

        if (tipoUsuario == 1) {
            System.out.print("Digite a matrícula do aluno: ");
            String matricula = scanner.nextLine();
            usuario = new UsuarioAluno(nome, matricula);
        } else if (tipoUsuario == 2) {
            System.out.print("Digite a matrícula do professor: ");
            String matricula = scanner.nextLine();
            usuario = new UsuarioProfessor(nome, matricula);
        } else {
            System.out.println("Opção de tipo de usuário inválida!");
            return;
        }

        System.out.println("Usuário criado com sucesso!");
        usuario.exibir();
    }

    public static void main(String[] args) {
        Biblioteca app = new Biblioteca();
        app.abrirConsole();
    }
}
