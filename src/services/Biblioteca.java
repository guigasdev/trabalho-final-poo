package services;

import exceptions.LivroNaoEncontradoException;
import interfaces.Buscavel;
import interfaces.Relatavel;
import models.Livro;
import models.LivroFisico;
import models.LivroDigital;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca implements Buscavel, Relatavel {
    private String caminhoArquivo;
    private List<Livro> livros;

    public Biblioteca(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
        this.livros = new ArrayList<>();
        carregarLivros();
    }

    private void carregarLivros() {
        try {
            String conteudo = ArquivoUtil.lerArquivo(caminhoArquivo);
            if (!conteudo.isEmpty()) {
                String[] linhas = conteudo.split("\n");
                for (String linha : linhas) {
                    String[] dados = linha.split(" - ");
                    if (dados.length == 3) {
                        String titulo = dados[0].trim();
                        String autor = dados[1].trim();
                        String tipo = dados[2].trim();
                        if (tipo.equals("Físico")) {
                            livros.add(new LivroFisico(titulo, autor));
                        } else if (tipo.equals("Digital")) {
                            livros.add(new LivroDigital(titulo, autor));
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar os livros: " + e.getMessage());
        }
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        salvarLivros();
    }

    public List<Livro> listarLivros() {
        return new ArrayList<>(livros);
    }

    public void emprestarLivro(String titulo) throws LivroNaoEncontradoException {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livros.remove(livro);
                salvarLivros();
                return;
            }
        }
        throw new LivroNaoEncontradoException("Livro " + titulo + "não encontrado!");
    }

    @Override
    public void buscar(String criterio) {
        List<Livro> resultados = livros.stream()
                .filter(livro -> livro.getTitulo().toLowerCase().contains(criterio.toLowerCase()))
                .collect(Collectors.toList());
        if (resultados.isEmpty()) {
            System.out.println("Nenhum livro encontrado para o critério: " + criterio);
        } else {
            resultados.forEach(Livro::exibir);
        }
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("Relatório de Livros na Biblioteca:");
        listarLivros().forEach(Livro::exibir);
    }

    private void salvarLivros() {
        try {
            StringBuilder conteudo = new StringBuilder();
            for (Livro livro : livros) {
                conteudo.append(livro.getTitulo()).append(" - ")
                        .append(livro.getAutor()).append(" - ")
                        .append(livro.getTipo()).append("\n");
            }
            ArquivoUtil.escreverArquivo(caminhoArquivo, conteudo.toString().trim());
        } catch (IOException e) {
            System.out.println("Erro ao salvar os livros: " + e.getMessage());
        }
    }
}
