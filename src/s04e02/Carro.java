/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s04e02;

/**
 *
 * @author Lucas Amorim
 */
public class Carro {
    boolean estaLigado;
    int numPass;
    Motor motorCarro;
    String cor;
    public Carro(int numPass, Motor m, String cor){
        this.numPass = numPass;
        this.motorCarro = m;
        this.cor = cor;
    }
    
    void ligar(){
        if(motorCarro!=null){
            estaLigado=true;
        }else{
            System.out.println("Não tem motor");
        }
    }
    void andar(){
        if(estaLigado){
            System.out.println("Vruuuuuummm!");
        }else{
            System.out.println("Ligue o carro seu safado");
        }
    }
    public static void main(String[] args) {
        Motor m = new Motor(500);
        Carro c = new Carro(5,m, "red");
        c.ligar();
        c.andar();
        System.out.println(c.cor);
    }
}
