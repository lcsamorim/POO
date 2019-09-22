/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab_4;

import java.util.ArrayList;
import java.util.Scanner;

class Passageiro {

    String id;
    int idade;

    public Passageiro(String id, int idade) {
        this.id = id;
        this.idade = idade;
    }

    public Passageiro() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "" + this.id + ":" + this.idade + " ";
    }

}

class Topic extends Passageiro {

    int capacidade;
    int preferencial;
    ArrayList<Passageiro> cadeiras;
    ArrayList<Passageiro> passcomum;

    public Topic(int capacidade, int preferencial) {
        this.capacidade = capacidade;
        this.preferencial = preferencial;
        cadeiras = new ArrayList<Passageiro>();
        passcomum = new ArrayList<Passageiro>();
        for (int i = 1; i <= preferencial; i++) {
            cadeiras.add(null);
        }
        for (int i = 1; i <= capacidade - preferencial; i++) {
            passcomum.add(null);
        }
    }

    public Topic() {
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getPreferencial() {
        return preferencial;
    }

    public void setPreferencial(int preferencial) {
        this.preferencial = preferencial;
    }


    public void embarcarPref(int pos, Passageiro passageiro) {
        for (Passageiro pass : cadeiras) {
            if(pass == null){
                cadeiras.set(pos, passageiro);
                return;
            }pos+=1;
            if(cadeiras.size()==pos && passcomum.size() == this.capacidade-this.preferencial){
                System.out.println("Topic lotada");
            }
        }
        
        
        
    }

    public void embarcarNorm(int pos, Passageiro passageiro) {
        for (Passageiro pass : passcomum) {
            if(pass == null){
                passcomum.set(pos, passageiro);
                return;
            }pos+=1;
            if(passcomum.size()==pos){
                System.out.println("Topic lotada");
            }
        }
    }

    public void remover(String id) {
        for (int i = 0; i < this.cadeiras.size(); i++) {
            Passageiro passageiro = this.cadeiras.get(i);
            if (passageiro != null && passageiro.getId().equals(id)) {
                this.cadeiras.set(i, null);
            }
        }
        for (int i = 0; i < this.passcomum.size(); i++) {
            Passageiro passageiro = this.passcomum.get(i);
            if (passageiro != null && passageiro.getId().equals(id)) {
                this.passcomum.set(i, null);
            }
        }
    }

    @Override
    public String toString() {
        String out = "[ ";
        for (Passageiro passageiro : this.cadeiras) {
            if (capacidade >= preferencial) {
                if (passageiro != null) {
                    out += "@" + passageiro;
                } else {
                    out += "@ ";
                }
            }
        }
        for (Passageiro passageiro : this.passcomum) {
            if (capacidade >= preferencial) {
                if (passageiro != null) {
                    out += "=" + passageiro;
                } else {
                    out += "= ";
                }
            }

        }
        out += "]";
        return out;
    }

}

public class Controller {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Topic topic = new Topic(0, 0);

        while (true) {
            String line = scan.nextLine();
            String vet[] = line.split(" ");
            switch (vet[0]) {
                case "init":
                    topic = new Topic(Integer.parseInt(vet[1]), Integer.parseInt(vet[2]));
                    break;
                case "show":
                    System.out.println(topic);
                    break;
                case "in":
                    int aux=0;
                    if (Integer.parseInt(vet[2]) >= 60) {
                        topic.embarcarPref(aux,new Passageiro((vet[1]), Integer.parseInt(vet[2])));
                        aux+=1;
                    } else {
                        topic.embarcarNorm(aux,new Passageiro((vet[1]), Integer.parseInt(vet[2])));
                        aux+=1;
                    }

                    break;
                case "out":
                    topic.remover(vet[1]);
                    break;
                case "end":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Comando inválido!");
                    break;
            }

        }

    }
}
