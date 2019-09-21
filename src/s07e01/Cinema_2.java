/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s07e01;

import java.util.ArrayList;

/**
 *
 * @author Lucas Amorim
 */
class Cliente_2{
    String nome;
    String fone;
    public Cliente_2(String nome, String fone){
        this.nome = nome;
        this.fone = fone;
    }
    public Cliente_2(){
    }
    public String getNome(){
        return nome;
    }
    public String getFone(){
        return fone;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setFone(String fone){
        this.fone = fone;
    }
    public String toString(){
        return this.nome + ":" + this.fone;
    }
    
}
class Sala_2{
    int capacidade;
    ArrayList<Cliente_2> cadeiras;
    public Sala_2(int capacidade){
        cadeiras = new ArrayList<Cliente_2>();
        this.capacidade = capacidade;
        for (int i=0; i <= capacidade;i++){
            cadeiras.add(null);
        }
    }
    public Sala_2(){
    }
    public void adicionar(int pos, Cliente_2 cliente){
        if(pos < 0 || pos >= this.capacidade){
            System.out.println("Cadeira inválida");
            return;
        }
        if(cadeiras.get(pos) != null){
            System.out.println("Cadeira ocupada!");
            return;
        }
        for(Cliente_2 other : cadeiras){
            if(other!=null && other.getNome().equals(cliente.getNome())){
                System.out.println("Você já está no cinema");
                return;
            }
        }
        cadeiras.set(pos, cliente);
    }
    public void remover(int pos){
        cadeiras.set(pos, null);
        System.out.println("Cliente removido com sucesso!");
    }
    public String toString(){
        String out = "[";
        for (Cliente_2 cliente : cadeiras){
            if(cliente != null){
                out += cliente + " ";
            }
            else{
                out += " - ";
            }
        }
        out += "]";
        return out;
    }
}
public class Cinema_2 {
    public static void main(String[] args) {
        Sala_2 sala1 = new Sala_2(8);
        sala1.adicionar(2, new Cliente_2("Lucas", "9911"));
        sala1.adicionar(5, new Cliente_2("É ué", "9911"));
        sala1.adicionar(5, new Cliente_2("hmm", "9911"));
        System.out.println(sala1);
        sala1.remover(2);
        System.out.println(sala1);
    }
}
