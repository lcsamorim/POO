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

class Topic {

    int capacidade;
    int preferencial;
    ArrayList<Passageiro> cadeiras;
    ArrayList<Passageiro> passcomum;
    ArrayList<Passageiro> totalcadeiras;

    public Topic(int capacidade, int preferencial) {
        this.capacidade = capacidade;
        this.preferencial = preferencial;
        cadeiras = new ArrayList<Passageiro>();
        passcomum = new ArrayList<Passageiro>();
        totalcadeiras = new ArrayList<Passageiro>();
        for (int i = 1; i <= preferencial; i++) {
            cadeiras.add(null);
            totalcadeiras.add(null);
        }
        for (int i = 1; i <= capacidade - preferencial; i++) {
            passcomum.add(null);
            totalcadeiras.add(null);
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

    public void embarcar(int pos, Passageiro passageiro) {

        for (Passageiro pass : totalcadeiras) {
            if (pass != null && passageiro.getId().equals(pass.id)) {
                System.out.println("Passageiro já está na topic");
                return;
            }
        }
        if (passageiro.getIdade() >= 60) {
            for (Passageiro pass : cadeiras) {
                if (pass == null) {
                    cadeiras.set(pos, passageiro);
                    totalcadeiras.set(pos, passageiro);
                    return;
                }
                pos += 1;
                if (cadeiras.size() == pos) {
                    pos = 0;
                    if (pass != null) {
                        for (Passageiro verif : passcomum) {
                            if (verif == null) {
                                passcomum.set(pos, passageiro);
                                totalcadeiras.set(pos, passageiro);
                                return;
                            }
                            pos += 1;
                        }
                    }
                    if (cadeiras.size() == this.preferencial) {
                        System.out.println("Topic lotada");
                        return;
                    }
                }
            }
        } else {
            for (Passageiro pass : passcomum) {
                if (pass == null) {
                    passcomum.set(pos, passageiro);
                    totalcadeiras.set(pos, passageiro);
                    return;
                }
                pos += 1;
                if (passcomum.size() == pos) {
                    pos = 0;
                    if (pass != null) {
                        for (Passageiro verif : cadeiras) {
                            if (verif == null) {
                                cadeiras.set(pos, passageiro);
                                totalcadeiras.set(pos, passageiro);
                                return;
                            }
                            pos += 1;

                        }
                    }
                    if (passcomum.size() == this.capacidade - this.preferencial) {
                        System.out.println("Topic lotada");
                        return;
                    }
                }
            }
        }
    }

    public void remover(String id) {

        for (int i = 0; i < this.cadeiras.size(); i++) {
            Passageiro pass = this.cadeiras.get(i);
            if (pass != null) {
                if (pass.getId().equals(id)) {
                    this.cadeiras.set(i, null);
                    return;
                }
            }
        }
        for (int i = 0; i < this.passcomum.size(); i++) {
            Passageiro pass = this.passcomum.get(i);
            if (pass != null) {
                if (pass.getId().equals(id)) {
                    this.passcomum.set(i, null);
                    return;
                }
            }
        }
        System.out.println("Passageiro não está na topic");
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
                    int aux = 0;
                    topic.embarcar(aux, new Passageiro((vet[1]), Integer.parseInt(vet[2])));
                    aux += 1;
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
