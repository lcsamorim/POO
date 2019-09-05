/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s05e01;

/**
 *
 * @author Lucas Amorim
 */
public class Controler {
    public static void main(String[] args) {
        Conta c1 = new Conta("Lucas", 10, 200);
        Conta c2 = new Conta("David", 40, 50);
        Conta c3 = new Conta("Junin", 120, 150);
        c1.setTitular("Ué");
        c1.sacar(7);
        c1.depositar(197);
        c2.depositar(10);
        System.out.println("Identificador: " + c1.getIdentificador());
        System.out.println("Titular: " + c1.getTitular());
        System.out.println("Saldo: " + c1.getSaldo());
        System.out.println("Saldo: " + c1.getSaldo());
        System.out.println("Identificador: " + c2.getIdentificador());
        System.out.println("Titular: " + c2.getTitular());
        System.out.println("Saldo: " + c2.getSaldo());
        System.out.println("Identificador: " + c3.getIdentificador());
        System.out.println("Titular: " + c3.getTitular());
        System.out.println("Saldo: " + c3.getSaldo());
        
    }
}
