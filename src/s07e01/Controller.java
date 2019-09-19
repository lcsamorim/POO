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
public class Controller {

    class Cliente {

        String nome;
        int fone;

        public Cliente() {
        }

        public Cliente(String nome, int fone) {
            this.nome = nome;
            this.fone = fone;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getFone() {
            return fone;
        }

        public void setFone(int fone) {
            this.fone = fone;
        }

    }
    class Sala{
        int capacidade;
        ArrayList<Cliente> cadeiras;

        public Sala() {
        }

        public Sala(int capacidade, ArrayList<Cliente> cadeiras) {
            this.capacidade = capacidade;
            this.cadeiras = cadeiras;
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
        public String toString(){
            return "" + this.capacidade + this.getCadeiras();
        }
    }
    public static void main(String[] args) {
        
    }
}
