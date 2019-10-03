/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package s09e01;

import java.util.Scanner;
 */
/**
 *
 * @author Lucas Amorim
 */
/*
class Conta{
    protected int id;
    protected float saldo;
    protected String idCliente;
    protected String type;
    
    Conta(int id, String idCliente){
        this.id = id;
        this.idCliente = idCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public void sacar(float saque){
        if(saque <= this.saldo){
            this.saldo =  this.saldo - saque;
            System.out.println("Saque realizado com sucesso");
        }else{
            System.out.println("Valor digitado é maior que o saldo!");
        }
    }
    public void depositar(float deposito){
        this.saldo = deposito + this.saldo;
    }
    public void transferir(Conta conta, float transferencia){
        if(transferencia <= this.saldo){
            this.saldo = this.saldo - transferencia;
        }
    }
    public void atualizacaoMensal(){
    
    }
}
class Cliente{
    protected String usuario;
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
class ContaCorrente extends Conta{
    protected float tarifaMensal = 20;
    public ContaCorrente(int id, String idCliente) {
        super(id, idCliente);
    }

    @Override
    public void atualizacaoMensal() {
        super.atualizacaoMensal(); 
    }
}
class ContaPoupanca extends Conta{
    protected float rendimento;
    public ContaPoupanca(int id, String idCliente) {
        super(id, idCliente);
    }
    @Override
    public void atualizacaoMensal() {
        super.atualizacaoMensal(); 
    }
}

public class Controladora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conta conta = new Conta();
        while (true){
            String linha = scanner.nextLine();
            String vet[] = linha.split(" ");
            switch(vet[0]){
                case "addCli":
                    
            }
        }
    }
}
*/