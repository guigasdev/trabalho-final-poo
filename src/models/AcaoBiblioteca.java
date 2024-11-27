package models;

public abstract class AcaoBiblioteca {
    private String descricao;

    public AcaoBiblioteca(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract void executar();
}
