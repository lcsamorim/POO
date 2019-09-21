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
class Cliente {

    String nome;
    String fone;

    public Cliente() {
    }

    public Cliente(String nome, String fone) {
        this.nome = nome;
        this.fone = fone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    @Override
    public String toString() {
        return "" + this.nome + ":" + this.fone;
    }

    void add(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

class Sala {

    int capacidade;
    ArrayList<Cliente> cadeiras;

    public Sala() {
    }

    public Sala(int capacidade) {
        this.capacidade = capacidade;
        cadeiras = new ArrayList<Cliente>();
        for (int i=0; i < this.capacidade; i++){
            cadeiras.add(null);
        }
        
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public ArrayList<Cliente> getCadeiras() {
        return cadeiras;
    }

    public void setCadeiras(ArrayList<Cliente> cadeiras) {
        this.cadeiras = cadeiras;
    }
    
    public void adicionar(int pos, Cliente cliente){
        if(pos >= this.capacidade || pos < 0){
            System.out.println("Posição inválida");
            return;
        }
        if(cadeiras.get(pos) != null){
            System.out.println("Cadeira ocupada");
            return;
        }
        for (Cliente outro : cadeiras){
            if(outro!= null && cliente.getNome().equals(outro.getNome())){
                System.out.println("Você já está no cinema");
                return;
            }
        }
        cadeiras.set(pos, cliente);
    }
    public void remover(int pos){
        cadeiras.set(pos, null);
    }
    
    @Override
    public String toString() {
        String out = "[";
        for(Cliente cliente : this.cadeiras){
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

public class Controller {

    public static void main(String[] args) {
        Sala s = new Sala(5);
        s.adicionar(3, new Cliente("lucas", "33"));
        s.adicionar(3, new Cliente("aa", "33"));
        s.adicionar(4, new Cliente("aa", "33"));
        s.adicionar(2, new Cliente("aa", "33"));
        s.remover(3);
        System.out.println(s);

    }
}
