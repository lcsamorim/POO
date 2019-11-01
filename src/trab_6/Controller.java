/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab_6;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Lucas Amorim
 */
class Repositorio <T>{
    Map<String, T> dados;
    public Repositorio(){
        dados = new TreeMap<String, T>();
    }
    public void add(String key, T data){
        T t = dados.get(key);
        if(t == null){
            dados.put(key, data);
        }else{
            throw new RuntimeException(key + " já existe");
        }
    }
    public void del(String key, T data){
        T t = dados.get(key);
        if(t == null){
            dados.remove(key, data);
        }
        else{
            throw new RuntimeException(key + " não existe");
        }
    }
    public T get(String key){
        T t = dados.get(key);
        if(t == null){
            throw new RuntimeException(key + " não encontrado");
        }
        return t;
    }
    public ArrayList<T> getAll(){
        ArrayList<T> out = new ArrayList<T>();
        for(String key : dados.keySet()){
            out.add(dados.get(key));
        }
        return out;
    }
}
class Escola{
    Repositorio<Aluno> alunos;
    Repositorio<Disciplina> disciplinas;
    public Escola(){
        alunos = new Repositorio<Aluno>();
        disciplinas = new Repositorio<Disciplina>();
    }

    @Override
    public String toString() {
        return "" + alunos.getAll();
    }
    
}
class Aluno{
    private String id;
    Repositorio<Disciplina> disciplinas;
    public Aluno(String id){
        this.id = id;
        disciplinas = new Repositorio<Disciplina>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String out = id + "[ ";
        for(Disciplina disc : disciplinas.getAll()){
            out += disc + " ";
        }
        return out + " ]";
    }
    
}
class Disciplina{
    private String nomeDisciplina;
    Repositorio<Aluno> alunos;
    public Disciplina(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
        alunos = new Repositorio<Aluno>();
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    @Override
    public String toString() {
        /*String out = "[ ";
        for (Aluno alu : alunos.getAll()){
            out += alu + " ";
        }*/
        String out=nomeDisciplina;
        return out;
    }
    
}
public class Controller {
    public static void main(String[] args) {
        Escola escola = new Escola();
        Scanner scanner = new Scanner(System.in);
        while(true){
            String line = scanner.nextLine();
            String vet[] = line.split(" ");
            switch(vet[0]){
                case "nwalu":
                    escola.alunos.add(vet[1], new Aluno(vet[1]));
                    break;
                case "nwdis":
                    escola.disciplinas.add(vet[1], new Disciplina(vet[1]));
                    break;
                case "la":
                    System.out.println(escola);
                    break;
                case "mat":
                    escola.alunos.get(vet[1]).disciplinas.add(vet[2], new Disciplina(vet[2]));
            }
        }
    }
}
