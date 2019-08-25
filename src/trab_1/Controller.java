/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab_1;

import java.util.Scanner;

class ControleTV {
    boolean estaLigada=false, estaGravando=false;
    int quantCanais=30;
    int canalPreferido;
    int canalAtual=1;
    void selecionarCanal(int canal){
        if(estaLigada){
            canalAtual=canal;
        }else{
            System.out.println("A TV está desligada");
        }
        
    }
    void addCanalPreferido(int canal){
        if(estaLigada){
            if(canal<=quantCanais && canal>0){
                canalPreferido = canal;
                System.out.println("Canal preferido adicionado!");
            }
            else{
                System.out.println("Canal escolhido não existe!");
            }
        }
        else{
            System.out.println("A TV está desligada");
        }
    }
    void chamarCanalPreferido(){
        if(estaLigada){
            if(canalAtual==canalPreferido){
                System.out.println("Você já está em seu canal preferido!");
            }
            else if(canalPreferido!=0){
                canalAtual = canalPreferido;
                System.out.println("Você está no seu canal preferido!");
            }
            else{
                System.out.println("Você não cadastrou seu canal preferido!");
            }
        }else{
            System.out.println("A TV está desligada");
        }
    }
    void ligarTV(){
        if(estaLigada==false){
            estaLigada=true;
            System.out.println("TV ligada");
        }else{
            System.out.println("A TV já está ligada");
        }
    }
    void desligarTV(){
        if(estaLigada==true){
            estaLigada=false;
            System.out.println("TV desligada");
        }else{
             System.out.println("A TV já está desligada");
        }
    }
    void avancarCanal(){
        if(estaLigada==true){
            canalAtual++;
            System.out.println("Você avançou um canal");
            if(canalAtual>30){
                canalAtual=1;
            }
        }
        else{
            System.out.println("A TV está desligada"); 
        }
    }
    void voltarCanal(){
        if(estaLigada==true){
            canalAtual--;
            System.out.println("Você regressou um canal");
            if(canalAtual<1){
                canalAtual=quantCanais;
            }
        }
        else{
            System.out.println("A TV está desligada");
        }
    }
    void iniciarGravar(){
        if(estaLigada==true){
            if(estaGravando==false){
                estaGravando=true;
                System.out.println("A gravação do programa começou!");
            }
        }else{
            System.out.println("A TV está desligada");
        }
    }
    void pararGravar(){
        if(estaLigada==true){
            if(estaGravando==true){
                estaGravando=false;
                System.out.println("Gravação finalizada");
            }
            else{
                System.out.println("A gravação não foi iniciada");
            }
        }
        else{
            System.out.println("A TV está desligada");
        }
    }
    void status(){
        System.out.println("Está ligada: " + estaLigada +"; Canal atual: " + canalAtual +
                "; Canal preferido: " + canalPreferido);
    }
}

/**
 *
 * @author Lucas Amorim
 */
public class Controller {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControleTV ctv = new ControleTV();
        System.out.println("ligar ; desligar ; ir para cp (Canal Preferido) ;"
            + "add cp (Digitar número do canal) gravar ; parar gravar ; "
            + "proximo (canal) ; voltar (canal) ; selecionar (canal); status");
        
        while (true){
            String line = scanner.nextLine();
            String vet[] = line.split(" ");
            if(line.equals("ligar")){
                ctv.ligarTV();
            }
            else if(line.equals("desligar")){
                if(ctv.estaGravando==true){
                    System.out.println("Não é possível desligar. Gravação em andamento!");
                }
                else{
                    ctv.desligarTV();
                    break;
                }
            }
            else if (vet[0].equals("add") && vet[1].equals("cp")){
                ctv.addCanalPreferido(Integer.parseInt(vet[2]));
            }
            else if (line.equals("ir para cp")){
                ctv.chamarCanalPreferido();
            }
            else if (line.equals("gravar")){
                ctv.iniciarGravar();
            }
            else if (line.equals("parar gravar")){
                ctv.pararGravar();
            }
            else if(line.equals("proximo")){
                ctv.avancarCanal();
            }
            else if(line.equals("voltar")){
                ctv.voltarCanal();
            }
            else if(vet[0].equals("selecionar")){
                ctv.selecionarCanal(Integer.parseInt(vet[1]));
            }
            else if(line.equals("status")){
                ctv.status();
            }
            else{
                System.out.println("Comando inválido!");
            }
        }
    }
}
