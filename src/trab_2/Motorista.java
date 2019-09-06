/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab_2;

/**
 *
 * @author Lucas Amorim
 */
public class Motorista {
    boolean estaAcordado;
    boolean saude;
    boolean felicidade;
    int salario;
    boolean devidoSalario;
    /*public Motorista(boolean estaAcordado, boolean saude, boolean felicidade, int salario){
        this.estaAcordado = estaAcordado;
        this.saude = saude;
        this.felicidade = felicidade;
        this.salario = salario;
    }*/
    public Motorista(){
        this.estaAcordado = false;
        this.saude = false;
        this.felicidade = false;
        this.salario = 0;
        this.devidoSalario = false;
        
    }
    public void salarioDevido(){
        if(this.salario<4600){
            this.devidoSalario = false;
        }else{
            this.devidoSalario = true;
        }
    }
    public void status(){
        System.out.println("O motorista está acordado: " + this.estaAcordado);
        System.out.println("O motorista está saudável: " + this.saude);
        System.out.println("O motorista está feliz: " + this.felicidade);
        System.out.println("O motorista foi pago devidamente: " + this.devidoSalario);
    }

    public boolean isEstaAcordado() {
        return estaAcordado;
    }

    public void setEstaAcordado(boolean estaAcordado) {
        this.estaAcordado = estaAcordado;
    }

    public boolean isSaude() {
        return saude;
    }

    public void setSaude(boolean saude) {
        this.saude = saude;
    }

    public boolean isFelicidade() {
        return felicidade;
    }

    public void setFelicidade(boolean felicidade) {
        this.felicidade = felicidade;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public boolean isDevidoSalario() {
        return devidoSalario;
    }

    public void setDevidoSalario(boolean devidoSalario) {
        this.devidoSalario = devidoSalario;
    }
    
}
