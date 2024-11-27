package models;

public class UsuarioProfessor extends Usuario {
    public UsuarioProfessor(String nome, String matricula) {
        super(nome, matricula);
    }

    @Override
    public void exibir() {
        System.out.println("Professor: " + getNome() + " - Matrícula: " + getMatricula());
    }
}
