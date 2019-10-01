/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s08e01;

/**
 *
 * @author Lucas Amorim
 */
class Funcionario {

    protected String nome;
    protected String cpf;
    protected double salario;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    public double getBonificacao(){
        return this.salario*0.10;
    }

    @Override
    public String toString() {
        return "Funcionário " + this.nome;
    }
    
}

class Gerente extends Funcionario {

    private int senha;
    private int numFuncGerenciados;

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public int getNumFuncGerenciados() {
        return numFuncGerenciados;
    }

    public void setNumFuncGerenciados(int numFuncGerenciados) {
        this.numFuncGerenciados = numFuncGerenciados;
    }
    public double getBonificacao(){
        return super.getBonificacao() + 1000;
    }
    public boolean autenticar(int senha) {
        if (this.senha == senha) {
            System.out.println("Acesso permitido!");
            return true;
        } else {
            System.out.println("Acesso negado!");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Gerente: " + super.toString();
    }
    
}

public class Controller {

    public static void main(String[] args) {
        Gerente gerente = new Gerente();
        Funcionario funcionario = new Funcionario();
        gerente.setNome("João da Silva");
        gerente.setSenha(4231);
        
        gerente.autenticar(4231);
        gerente.setSalario(5000.0);
        System.out.println(gerente.getBonificacao());
        System.out.println(gerente);
        funcionario.setNome("Alberto");
        System.out.println(funcionario);
        

    }
}
