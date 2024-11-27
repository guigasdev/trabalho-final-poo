package interfaces;

import exceptions.LivroNaoEncontradoException;

public interface Emprestavel {
    void emprestar() throws LivroNaoEncontradoException;
}
