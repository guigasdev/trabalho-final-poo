package models;

import exceptions.LivroNaoEncontradoException;
import interfaces.Emprestavel;
import interfaces.Exibivel;
import interfaces.Reservavel;

public abstract class Livro implements Emprestavel, Exibivel, Reservavel {
    private String titulo;
    private String autor;
    private String tipo;

    public Livro(String titulo, String autor, String tipo) {
        this.titulo = titulo;
        this.autor = autor;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public void exibir() {
        System.out.println("Título: " + titulo + ", Autor: " + autor + ", Tipo: " + tipo);
    }

    @Override
    public void reservar() {
        System.out.println("Livro '" + titulo + "' reservado.");
    }
}
