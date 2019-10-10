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
class Agencia {

    private ArrayList<Cliente> clientes;
    private ArrayList<Conta> contas;

    Agencia() {
        clientes = new ArrayList<Cliente>();
        contas = new ArrayList<Conta>();

    }

    public void addCli(String nome) {
        for (Cliente c : clientes) {
            if (c.getNome().equals(nome)) {
                System.out.println("Cliente já existe");
                return;
            }
        }
        Cliente cliente = new Cliente(nome);
        Conta corrente = new ContaCorrente(nome);
        Conta poupanca = new ContaPoupanca(nome);
        this.clientes.add(cliente);
        cliente.addConta(corrente);
        cliente.addConta(poupanca);
        this.contas.add(corrente);
        this.contas.add(poupanca);
    }
    
    public void show() {
        for (Conta c : contas) {
            System.out.println(c.getId() + ":" + c.getNome() + ":" + c.getSaldo() + ":" + c.getTipo());
        }
    }
    public void deposito(int indice, double valor){
        for (Conta c : contas){
            if(indice == c.getId()){
                c.setSaldo(valor);
                return;
            }
        }
        System.out.println("Conta inexistente");
    }
    public boolean saque(int indice, double valor){
        for (Conta c : contas){
            if(valor <= c.getSaldo() && indice == c.getId()){
                c.setSaldo(c.getSaldo()-valor);
                return true;
            }
            else if(valor > c.getSaldo() && indice == c.getId()){
                System.out.println("O valor digitado é maior que o saldo");
                return false;
            }
        }
        System.out.println("Conta inexistente");
        return false;
    }
    public void transf(int indice1, int indice2, double valor){
        if(this.saque(indice1, valor)){
            this.deposito(indice2, valor);
        }
    }
    public void update(){
        for (Conta c : contas){
            if(c.getTipo().equals("CC")){
                c.setSaldo(c.getSaldo()-20);
            }
            else{
                c.setSaldo(c.getSaldo()+(c.getSaldo()*0.01));
            }
        }
    }
    
}

abstract class Conta {
    static int auxId = 0; 
    private int id = 0;
    private String nome;
    private double saldo;
    private String tipo;

    Conta(String nome, double saldo, String tipo) {
        this.nome = nome;
        this.saldo = saldo;
        this.tipo = tipo;
    }

    Conta() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getAuxId() {
        return auxId;
    }

    public static void setAuxId(int auxId) {
        Conta.auxId = auxId;
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

}

class ContaCorrente extends Conta {

    public ContaCorrente(String nome) {
        this.setId(auxId);
        this.setNome(nome);
        this.setSaldo(getSaldo());
        this.setTipo("CC");
        auxId++;
    }
}

class ContaPoupanca extends Conta {

    public ContaPoupanca(String nome) {
        this.setId(auxId);
        this.setNome(nome);
        this.setSaldo(getSaldo());
        this.setTipo("CP");
        auxId++;

    }

}

class Cliente {

    private String nome;
    private ArrayList<Conta> contas;

    Cliente(String nome) {
        this.nome = nome;
        contas = new ArrayList<Conta>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addConta(Conta conta) {
        this.contas.add(conta);

    }
}

public class Controller {

    public static void main(String[] args) {
        Agencia agencia = new Agencia();
        Scanner scan = new Scanner(System.in);
        while (true) {
            String lista = scan.nextLine();
            String vet[] = lista.split(" ");
            switch (vet[0]) {
                case "addCli":
                    agencia.addCli(vet[1]);
                    break;
                case "deposito":
                    agencia.deposito(Integer.parseInt(vet[1]), Integer.parseInt(vet[2]));
                    break;
                case "saque":
                    agencia.saque(Integer.parseInt(vet[1]), Integer.parseInt(vet[2]));
                    break;
                case "show":
                    agencia.show();
                    break;
                case "transf":
                    agencia.transf(Integer.parseInt(vet[1]), Integer.parseInt(vet[2]), Integer.parseInt(vet[3]));
                    break;
                case "update":
                    agencia.update();
                    break;
                case "end":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Comando inválido!");
                    break;
            }
        }
    }
}
