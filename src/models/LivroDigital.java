package models;

import exceptions.LivroNaoEncontradoException;

public class LivroDigital extends Livro {
    public LivroDigital(String titulo, String autor) {
        super(titulo, autor, "Digital");
    }

    @Override
    public void emprestar() throws LivroNaoEncontradoException {
    }

    @Override
    public void exibir() {
        System.out.println("Título: " + getTitulo() + ", Autor: " + getAutor() + ", Tipo: " + getTipo());
    }
}
