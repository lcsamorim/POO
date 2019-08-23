/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s03e02;

import java.util.Scanner;

class Peixe{
    int barriga,maxBarriga;
    
    void alimentar(){
        barriga++;
        if(barriga<=maxBarriga){
            System.out.println("Seu peixe foi alimentado");
        }
        
    }
    void passarTempo(){
        barriga--;
        if(barriga<=0){
            System.out.println("Afee");
        }
    }
    void status(){
        if(barriga>0){
            System.out.println("Vivo e com "+ barriga + " alimentos");
        }
    }
}




/**
 *
 * @author Lucas Amorim
 */
public class TesteScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Peixe dory = new Peixe();
        dory.maxBarriga=10;
        System.out.println("feed ; wait ; show");
        while (true){
            String line = scanner.nextLine();
            String vet[] = line.split(" ");
            if(vet[0].equals("feed")){
                dory.alimentar(Integer.parseInt(vet[1]));
                if(dory.barriga>dory.maxBarriga){
                    System.out.println("Seu peixe comeu demais e morreu");
                    break;
                }
            }
            else if(vet[0].equals("wait")){
                dory.passarTempo();
                if(dory.barriga<0){
                    System.out.println("Seu peixe morreu de fome");
                    break;
                } 
            }
            else if(vet[0].equals("show")){
                dory.status();
            }
            else if(vet[0].equals("end")){
                break;
            }
        }
    }
}
