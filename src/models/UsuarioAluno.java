package models;

public class UsuarioAluno extends Usuario {
    public UsuarioAluno(String nome, String matricula) {
        super(nome, matricula);
    }

    @Override
    public void exibir() {
        System.out.println("Aluno: " + getNome() + " - Matrícula: " + getMatricula());
    }
}
