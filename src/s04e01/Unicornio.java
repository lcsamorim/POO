/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s04e01;

import java.util.Scanner;

/**
 *
 * @author Lucas Amorim
 */
public class Unicornio {
    boolean estaVoando;
    int nPass = 0;
    int nPassMax = 3;
    int carinhometro;
    int carinhometroMax;
    int km;
    
    void voar(int distanciaEmKm){
        if(nPass>=1){
            estaVoando = true;
            System.out.println("Voandooo!");
        }else {
            System.out.println("Não voou sozinho"); 
        }
    }
    void pousar(){
        if(estaVoando){
            estaVoando=false;
            System.out.println("Desceeeendooooo");  
        }else {
            System.out.println("Já está no chão");
        }
        
    }
    void subir(){
        if(nPass<=nPassMax){
            nPass++;
        }else {
            System.out.println("Tem gente demais! Ninguém mais subiu");
        }
    }
    void status(){
        System.out.println("Está voando: " + estaVoando);
    }
            /*desempenho de 10 km por carinho
            precisa de pelo menos um passageiro
            se não tiver carinho suficiente reclame
    subir(int qtd)
    não sobe além do máximo
    darAmor(qtd)
            aumenta carinhometro
    brigar(int qtd)
    */
    public static void main(String[] args) {
        Unicornio uni = new Unicornio();
        uni.nPassMax=2;
        uni.carinhometroMax=10;
        Scanner scanner = new Scanner (System.in);
        String line;
        while (true){
            line = scanner.nextLine();
            String[] vet = line.split(" ");
            switch (vet[0]){
                case "voar":
                    uni.voar(Integer.parseInt(vet[1]));
                    break;
                case "show":
                    uni.status();
                    break;
                case "pousar":
                    uni.pousar();
                    break;
                case "subir":
                    uni.subir();
                    break;
            }
        }
    }
}
