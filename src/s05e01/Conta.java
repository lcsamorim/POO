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

public class Conta {
    private String titular;
    private double saldo;
    private int numero;
    private double limite;
    static int identificador=0;
    public Conta(String titular, double saldo, double limite){
        this.titular = titular;
        this.saldo = saldo;
        this.numero = identificador;
        this.limite = limite;
    }
    public Conta(){
        this.titular = null;
        this.saldo = 0;
        this.limite = 0;
        this.numero = identificador;
        System.out.println("Não tem nome");
    }
    
    public void sacar(double valor){
        if(valor>saldo){
            System.out.println("Você não tem dinheiro suficiente");
        }else{
            this.saldo = this.saldo - valor;
        }
    }
    public void depositar(double valor){
        if(valor+this.saldo>this.limite){
            System.out.println("Erro! limite da conta ultrapassado!");
        }else{
            this.saldo = this.saldo+valor;
        }
        
        
    }
    public double getSaldo(){
        return this.saldo;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    public String getTitular(){
        return this.titular;
    }
    public void setTitular(String titular){
        this.titular = titular;
    }
    public int getIdentificador(){
        this.identificador +=1;
        return Conta.identificador;
    }

}
