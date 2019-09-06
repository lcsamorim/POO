/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab_2;

/**
 *
 * @author Lucas Amorim
 */
public class Onibus {
    Motorista motorista;
    private boolean estaLigado = true, estaAndando = false;
    public int contAlunos;
    public int capacidade;
    private boolean portaAberta = false;
    public Onibus(Motorista motorista, int capacidade){
        this.motorista = motorista;
        this.capacidade = capacidade;
    }
    public void ligar(){
        if(motorista!=null){
            System.out.println("Já está ligado");
        }else{
            System.out.println("Não tem motorista!");
            this.estaLigado = true;
        }
    }
    public void desligar(){
        if(motorista!=null){
            System.out.println("Desligando o busão!");
            this.estaLigado = false;
        }else{
            System.out.println("Já está desligado");
        }
    }
    public void botaoPorta(){
        if (this.estaLigado){
            if(this.portaAberta){
                System.out.println("Fechando a porta");
                this.portaAberta = false;
            }else{
                System.out.println("Abrindo a porta");
                this.portaAberta = true;
            }
        }else{
            System.out.println("O ônibus está desligado!");
        }
    }
   
    
    

    public boolean isEstaLigado() {
        return this.estaLigado;
    }

    public void setEstaLigado(boolean estaLigado) {
        this.estaLigado = estaLigado;
    }

    public boolean isEstaAndando() {
        return estaAndando;
    }

    public void setEstaAndando(boolean estaAndando) {
        this.estaAndando = estaAndando;
    }

    public int getContAlunos() {
        return contAlunos;
    }

    public void setContAlunos(int contAlunos) {
        this.contAlunos = contAlunos;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isPortaAberta() {
        return portaAberta;
    }

    public void setPortaAberta(boolean portaAberta) {
        this.portaAberta = portaAberta;
    }
    
}
