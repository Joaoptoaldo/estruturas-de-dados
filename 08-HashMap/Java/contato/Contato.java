package contato;

public class Contato {
    public String nome;
    public String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Contato{" + "nome='" + nome + '\'' + ", telefone='" + telefone + '\'' + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contato contato = (Contato) obj;
        return nome.equals(contato.nome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }
}
