package models;

import exceptions.LivroNaoEncontradoException;

public class LivroFisico extends Livro {
    public LivroFisico(String titulo, String autor) {
        super(titulo, autor, "Físico");
    }

    @Override
    public void emprestar() throws LivroNaoEncontradoException {
    }

    @Override
    public void exibir() {
        System.out.println("Título: " + getTitulo() + ", Autor: " + getAutor() + ", Tipo: " + getTipo());
    }
}
