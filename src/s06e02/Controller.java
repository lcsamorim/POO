package s06e02;

import java.util.ArrayList;

class Nota {

    double nota;

    public Nota(double nota) {
        this.nota = nota;
    }

    public double getNota() {
        return this.nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String toString() {
        return "" + this.nota;
    }
}

class Aluno {

    int matricula;
    String nome;
    ArrayList<Nota> notas;

    public Aluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        this.notas = new ArrayList<Nota>();
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Nota> getNota() {
        return notas;
    }

    public void addNota(double nota) {
        this.notas.add(new Nota(nota));
    }

    public void setNota(int index, double nota) {
        this.notas.set(index, new Nota(nota));
    }

    public void rmNota(int index) {
        this.notas.remove(index);
    }

    public String toString() {
        return "" + this.nome + ":" + this.getNota();
    }
}

public class Controller {

    public static void main(String[] args) {
        Aluno aluno1 = new Aluno(1, "Lucas");
        Aluno aluno2 = new Aluno(2, "Oxe");
        aluno1.addNota(7);
        aluno1.addNota(9);
        aluno2.addNota(6);
        aluno2.addNota(10);
        System.out.println(aluno1);
        System.out.println(aluno2);
        aluno1.rmNota(0);
        aluno2.setNota(0, 2);
        System.out.println(aluno1);
        System.out.print(aluno2);
    }
}
