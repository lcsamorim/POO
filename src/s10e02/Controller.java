/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s10e02;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Lucas Amorim
 */
class Repositorio<T> {

    Map<String, T> dados;

    public Repositorio() {
        dados = new TreeMap<String, T>();
    }

    public void add(String key, T data) {
        T t = dados.get(key);
        if (t == null) {
            dados.put(key, data);
        } else {
            throw new RuntimeException(key + " já existe");
        }
    }

    public void del(String key) {
        T t = dados.get(key);
        if (t != null) {
            dados.remove(key);
        } else {
            throw new RuntimeException(key + " não existe");
        }
    }

    public T get(String key) {
        T t = dados.get(key);
        if (t == null) {
            throw new RuntimeException(key + " não encontrado");
        }
        return t;
    }

    public ArrayList<T> getAll() {
        ArrayList<T> out = new ArrayList<T>();
        for (String key : dados.keySet()) {
            out.add(dados.get(key));
        }
        return out;
    }
}

class Cliente {

    private String clienteId;
    private String nome;
    private double saldo;

    public Cliente(String clienteId, String nome) {
        this.clienteId = clienteId;
        this.nome = nome;
    }
    

    @Override
    public String toString() {
        return "" + this.clienteId + ": " + this.nome + ": " + this.saldo;
    }

    class Transcacao {
        private int idTransacao;
        String idCliente;
        double valor;
    }
    public void historico(){
        
    }
}

class Agiota {

    Repositorio<Cliente> clientes;
    private double saldo;

    Agiota() {
    }

    Agiota(double saldo) {
        this.saldo = saldo;
        clientes = new Repositorio<Cliente>();
    }
    public void emprestar(String key, double valor){
        
        for(String chave : clientes.dados.keySet()){
            if(chave.equals(key)){
                this.saldo = this.saldo-valor;
                
            }
        }
    }
    @Override
    public String toString() {
        String out = "";
        for (Cliente cli : clientes.getAll()) {
            out += cli + "\n";

        }

        return out;
    }

}

public class Controller {

    public static void main(String[] args) {
        Agiota agiota = new Agiota();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String line = scanner.nextLine();
                String vet[] = line.split(" ");
                switch (vet[0]) {
                    case "init":
                        agiota = new Agiota(Double.parseDouble(vet[1]));
                        break;
                    case "addCli":
                        agiota.clientes.add(vet[1], new Cliente(vet[1], vet[2]));
                        break;
                    case "resumo":
                        System.out.print(agiota);
                        break;
                    case "emprestar":
                        agiota.emprestar(vet[1], Double.parseDouble(vet[2]));
                        break;
                    default:
                        System.out.println("Comando inválido");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
