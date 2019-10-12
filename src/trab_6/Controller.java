/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab_6;

import java.util.ArrayList;
import java.util.Scanner;
class Escola{
    protected ArrayList<Disciplina> disciplinas;
    protected ArrayList<Aluno> alunos;
    Escola(){
        disciplinas = new ArrayList<Disciplina>();
        alunos = new ArrayList<Aluno>();
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }
    public void addDisciplina(String nomeDisciplina){
        for (Disciplina disc : disciplinas){
            if(disc.equals(nomeDisciplina)){
                System.out.println("Disciplina já existe");
                return;
            }
        }
        Disciplina disciplina = new Disciplina(nomeDisciplina);
        //Aluno aluno = new Aluno(nomeDisciplina);
        //this.alunos.add(aluno);
        //disciplina.addDiscNoAluno(aluno);
        this.disciplinas.add(disciplina);
        
    }
    public void addAluno(String nomeAluno){
        for (Aluno aluno : alunos){
            if(aluno.equals(nomeAluno)){
                System.out.println("Aluno já existe");
                return;
            }
        }
        Aluno aluno = new Aluno(nomeAluno);
        // disciplina = new Disciplina(nomeAluno);
        //this.disciplinas.add(disciplina);
        //disciplina.addAlunoNaDisc(disciplina);
        this.alunos.add(aluno);
    }

    @Override
    public String toString() {
        String out = "";
        String out1="Alunos:\n";
        int aux = 0;
        String out2="\nDisciplinas:\n";
        int aux2 = 0;
        for(Aluno nomeAlunos : alunos){
            if(alunos != null){
                
                for(int i=0; i < aux; i++){
                    out1 += "\n";
                    break;
                }
                out1 += nomeAlunos.getNome() + "[]";
                aux+=1;
            }
        }
        out+=out1;
        for(Disciplina nomeDisciplinas : disciplinas){
            if(disciplinas != null){
                for(int i=0; i < aux2; i++){
                    out2 += "\n";
                    break;
                }
                out2 += nomeDisciplinas.getNomeDisciplina()+ "[]";
                aux2+=1;
            }
        }
        out+=out2;
        return out;
        
    }
    
}
class Aluno extends Escola{
    private String nome;
    
    Aluno(String nome){
        this.nome = nome;
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
class Disciplina extends Escola{
    private String nomeDisciplina;
    Disciplina(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public void addDiscNoAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    void addAlunoNaDisc(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }
}
public class Controller {
    public static void main(String[] args) {
        Escola escola = new Escola();
        Scanner scanner = new Scanner(System.in);
        while(true){
            String line = scanner.nextLine();
            String[] vet = line.split(" ");
            switch(vet[0]){
                case "nwalu":
                    int aux = vet.length;
                    for(int i=1; i<aux; i++){
                        escola.addAluno(vet[i]);
                    }
                    break;
                case "nwdis":
                    int aux2 = vet.length;
                    for(int i=1; i<aux2; i++){
                        escola.addDisciplina(vet[i]);
                    }
                    break;
                case "show":
                    System.out.println(escola);
                    break;
            }
            
        }
    }
    
    
}
