package aluno;

public class Aluno {
    public String nome;
    public String email;
    public String matricula;

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = gerarEmail(nome);
    }

    private String gerarEmail(String nome) {
        String[] nomes = nome.split(" ");
        return nomes[0].toLowerCase() + "." + nomes[nomes.length - 1].toLowerCase() + "@ufn.edu.br";
    }

    @Override
    public String toString() {
        return "Aluno{" + "nome='" + nome + '\'' + ", email='" + email + '\'' + ", matricula='" + matricula + '\'' + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Aluno aluno = (Aluno) obj;
        return matricula.equals(aluno.matricula);
    }

    @Override
    public int hashCode() {
        return matricula.hashCode();
    }
}
