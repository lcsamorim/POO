/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s03e01;

/**
 *
 * @author Lucas Amorim
 */
class Ventilador {
	boolean estaLigado;
	int velocidade;
	boolean estaGirando;
	
	
	void ligar () {
            System.out.println("Ligando o ventilador");
            estaLigado=true;
	}
	void desligar (){
            System.out.println("Desligando o ventilador");
            estaLigado=false;
        }
	void girar (){
            if(estaLigado){
                estaGirando=true;
            }
        }
	void pararDeGirar (){
            if(estaLigado && estaGirando){
                estaGirando=false;
            }
        }
	void aumentarVelocidade (){
        }
	void diminuirVelocidade (){
        
        }
	
	void showStatus() {
		System.out.println("Ligado: " + estaLigado + 
						   ", vel: " + 	velocidade + 
						   ", girando: " + estaGirando);
	}
    }







