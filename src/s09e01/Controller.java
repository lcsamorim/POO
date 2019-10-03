/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s09e01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lucas Amorim
 */
class Agencia{
    ArrayList<Cliente> clientes;
    Agencia(){
        clientes = new ArrayList<Cliente>();
    }
}
class Conta{
    private int id;
    private double saldo;
    private String tipo;
    Conta(int id, double saldo, String tipo){
        this.id = 0;
        this.saldo = 0;
        this.tipo = tipo;
    }
}
class ContaCorrente extends Conta{
    public ContaCorrente(int id, double saldo, String tipo) {
        super(id, saldo, tipo);
    }
}
class ContaPoupanca extends Conta{
    public ContaPoupanca(int id, double saldo, String tipo) {
        super(id, saldo, tipo);
    }

}
class Cliente{
    private String nome;
    ArrayList<Conta> contas;
    Cliente(String nome){
        this.nome = nome;
        contas = new ArrayList<Conta>();
    }
}

public class Controller {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String lista = scan.nextLine();
        
        while (true){
            switch ()
        }
    }
}
