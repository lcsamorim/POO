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
    ArrayList<Passageiro> cadeiraspreferenciais;
    ArrayList<Passageiro> cadeirascomuns;
    ArrayList<Passageiro> totalcadeiras;

    public Topic(int capacidade, int preferencial) {
        this.capacidade = capacidade;
        this.preferencial = preferencial;
        cadeiraspreferenciais = new ArrayList<Passageiro>();
        cadeirascomuns = new ArrayList<Passageiro>();
        totalcadeiras = new ArrayList<Passageiro>();
        for (int i = 1; i <= preferencial; i++) {
            cadeiraspreferenciais.add(null);
            totalcadeiras.add(null);
        }
        for (int i = 1; i <= capacidade - preferencial; i++) {
            cadeirascomuns.add(null);
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
            for (Passageiro pass : cadeiraspreferenciais) {
                if (pass == null) {
                    cadeiraspreferenciais.set(pos, passageiro);
                    totalcadeiras.set(pos, passageiro);
                    return;
                }
                pos += 1;
                if (cadeiraspreferenciais.size() == pos) {
                    pos = 0;
                    if (pass != null) {
                        for (Passageiro verif : cadeirascomuns) {
                            if (verif == null) {
                                cadeirascomuns.set(pos, passageiro);
                                totalcadeiras.set(pos, passageiro);
                                return;
                            }
                            pos += 1;
                        }
                    }
                    if (cadeiraspreferenciais.size() == this.preferencial) {
                        System.out.println("Topic lotada");
                        return;
                    }
                }
            }
        } else {
            for (Passageiro pass : cadeirascomuns) {
                if (pass == null) {
                    cadeirascomuns.set(pos, passageiro);
                    totalcadeiras.set(pos, passageiro);
                    return;
                }
                pos += 1;
                if (cadeirascomuns.size() == pos) {
                    pos = 0;
                    if (pass != null) {
                        for (Passageiro verif : cadeiraspreferenciais) {
                            if (verif == null) {
                                cadeiraspreferenciais.set(pos, passageiro);
                                totalcadeiras.set(pos, passageiro);
                                return;
                            }
                            pos += 1;

                        }
                    }
                    if (cadeirascomuns.size() == this.capacidade - this.preferencial) {
                        System.out.println("Topic lotada");
                        return;
                    }
                }
            }
        }
    }

    public void remover(String id) {

        for (int i = 0; i < this.cadeiraspreferenciais.size(); i++) {
            Passageiro pass = this.cadeiraspreferenciais.get(i);
            if (pass != null) {
                if (pass.getId().equals(id)) {
                    this.cadeiraspreferenciais.set(i, null);
                    return;
                }
            }
        }
        for (int i = 0; i < this.cadeirascomuns.size(); i++) {
            Passageiro pass = this.cadeirascomuns.get(i);
            if (pass != null) {
                if (pass.getId().equals(id)) {
                    this.cadeirascomuns.set(i, null);
                    return;
                }
            }
        }
        System.out.println("Passageiro não está na topic");
    }

    @Override
    public String toString() {
        String out = "[ ";
        for (Passageiro passageiro : this.cadeiraspreferenciais) {
            if (capacidade >= preferencial) {
                if (passageiro != null) {
                    out += "@" + passageiro;
                } else {
                    out += "@ ";
                }
            }
        }
        for (Passageiro passageiro : this.cadeirascomuns) {
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
