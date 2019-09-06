/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab_2;

import java.util.Scanner;

/**
 *
 * @author Lucas Amorim
 */
public class Controller {
    public static void main(String[] args) {
        Motorista mot = new Motorista();
        Onibus oni = new Onibus(mot, 105);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Você deve solucionar os problemas do motorista:");
        System.out.println("pagar a partir 4600; dar 'bomdia'; acordar; medicar");
        while (true){
            String line = scanner.nextLine();
            String[] vet = line.split(" ");
            switch(vet[0]){
                case "status":
                    mot.status();
                    break;
                case "acordar":
                    mot.setEstaAcordado(true);
                    break;
                case "medicar":
                    mot.setSaude(true);
                    break;
                case "bomdia":
                    mot.setFelicidade(true);
                    break;
                case "pagar":
                    mot.setSalario(Integer.parseInt(vet[1]));
                    mot.salarioDevido();
                    
                    break;
                }
            
            if(mot.isEstaAcordado() && mot.isSaude() && mot.isFelicidade() && mot.isDevidoSalario()){
                System.out.println("Busão chegou:");
                System.out.println("Você pode: ligar; desligar; subir(), expremer; botaoPorta; ir; parar; status");
                while(true){ 
                    String line2 = scanner.nextLine();
                    String[] vet2 = line2.split(" ");
                        switch (vet2[0]){
                            case "ligar":
                                oni.ligar();
                                break;
                            case "desligar":
                                oni.desligar();
                                break;
                            case "subir":
                                if(oni.isPortaAberta() && !oni.isEstaAndando()){
                                    if(oni.getCapacidade()< Integer.parseInt((vet2[1]))+oni.getContAlunos()){
                                        oni.setContAlunos(oni.getCapacidade());
                                        System.out.println("Número de vagas excedido");
                                    
                                    }else{
                                        oni.setContAlunos(Integer.parseInt((vet2[1]))+oni.getContAlunos());
                                    }
                                }else{
                                    System.out.println("A porta está fechada e/ou o ônibus está em movimento");
                                }
                                break;
                            case "espremer":
                                System.out.println("Cabe mais duas pessoas");
                                oni.setCapacidade(oni.getCapacidade()+2);
                                break;
                            case "botaoPorta":
                                oni.botaoPorta();
                                break;
                            case "ir":
                                oni.setEstaAndando(true);
                                break;
                            case "parar":
                                oni.setEstaAndando(false);
                                break;
                            case "status":
                                System.out.println("Está ligado: " + oni.isEstaLigado());
                                System.out.println("Porta aberta: " + oni.isPortaAberta());
                                System.out.println("Está andando: " + oni.isEstaAndando());
                                System.out.println("Capacidade: " + oni.getCapacidade());
                                System.out.println("Quantidade de alunos: " + oni.getContAlunos());
                                break;
                        }
                    }
            }else{
                System.out.println("Você ainda não resolveu os problemas do motorista");
            }
        }
    }
}
