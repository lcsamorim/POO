/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s08e01;

class Conta {

    private int id;
    private String nome;
    private double saldo;
    private String tipo;

    Conta(String nome, double saldo, String tipo) {
        this.nome = nome;
        this.saldo = saldo;
        this.tipo = tipo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void update(){
    
    }
    @Override
    public String toString() {
        return "" + this.id + ":" + this.nome + ":" + this.saldo + ":" + this.tipo;
        
    }
    
}

class ContaCorrente extends Conta {

    public ContaCorrente(String nome, double saldo, String tipo) {
        super(nome, saldo, tipo);
    }
    
}

class ContaPoupanca extends Conta {

    public ContaPoupanca( String nome, double saldo, String tipo) {
        super(nome, saldo, tipo);
    }
    
}

public class AtvCaelum {

    public static void main(String[] args) {
        Conta c = new Conta("Lucas", 12, "CP");
        c.update();
        System.out.println(c);
        
    }
}
