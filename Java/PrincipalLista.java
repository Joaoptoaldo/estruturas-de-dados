package Java;
    
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class PrincipalLista {
    public static void main(String[] args) {
        ArrayList<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno(nome: "João Silva"));
        alunos.add(new Aluno(nome: "João Pedro"));
        alunos.add(new Aluno(nome: "João A"));
        alunos.add(new Aluno(nome: "João P"));
    }
}

