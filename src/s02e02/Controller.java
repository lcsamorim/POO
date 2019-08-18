/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s02e02;

/*
-QuantVelocidades
-EstaLigado
-Ligar()
-Desligar()
-AumentarVelocidade()
-DiminuirVelocidade()*/
class Ventilador{
    int quantVelocidades;
    boolean estaLigado;
    
    void Ligar(){
        if(estaLigado){
            System.out.println("Já está ligado");
        }else{
            estaLigado = true;
            System.out.println("Ventilador ligado!");
        }
    }
    void  Desligar(){
        if(!estaLigado){
            System.out.println("Já está desligado");
        }else{
            if(quantVelocidades<=1){
            estaLigado = false;
            System.out.println("Ventilador desligado!");
            }else{
                System.out.println("Você deve deixar o ventilador na velocidade mínima para desligar");
            }
        }
    }
    void AumentarVelocidade(){
        if(estaLigado){
            quantVelocidades+=1;
            if(quantVelocidades>3){
                System.out.println("O ventilador já está no máximo");
                quantVelocidades=3;
            }
            System.out.println("Ventilador está na velocidade " + quantVelocidades);
        }else{
            System.out.println("Ventilador desligado!");
        }
    }

    void DiminuirVelocidade(){
        if(estaLigado){
            quantVelocidades-=1;
            if(quantVelocidades<1){
                System.out.println("O ventilador já está no mínimo");
                quantVelocidades=1;
            }
            System.out.println("Ventilador está na velocidade " + quantVelocidades);
        }else{
            System.out.println("Ventilador desligado!");
    }
    }
}
/**
 *
 * @author Lucas Amorim
 */
public class Controller {
    public static void main(String[] args) {
        Ventilador v1 = new Ventilador();
        v1.Ligar();
        v1.AumentarVelocidade();
        v1.AumentarVelocidade();
        v1.AumentarVelocidade();
        v1.AumentarVelocidade();
        v1.Desligar();
        v1.DiminuirVelocidade();
        v1.DiminuirVelocidade();
        v1.DiminuirVelocidade();
        v1.Ligar();
        v1.Desligar();
        
    }
}
