/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab_9;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;

class Repositorio<T> {

    Map<String, T> dados;

    public Repositorio() {
        //this.nametype = nametype;
        this.dados = new LinkedHashMap<>();
    }

    public void add(String key, T t) {
        if (dados.get(key) == null) {
            dados.put(key, t);
        } else {
            throw new RuntimeException(key + " já existe");
        }
    }

    public T get(String key) {
        if (dados.get(key) != null) {
            return dados.get(key);
        } else {
            throw new RuntimeException(key + " não existe");
        }
    }

    public void del(String key) {
        if (dados.get(key) != null) {
            dados.remove(key);
        } else {
            throw new RuntimeException(" não existe");
        }
    }

    public ArrayList<T> getAll() {
        ArrayList<T> out = new ArrayList<T>();
        for (String key : dados.keySet()) {
            out.add(dados.get(key));
        }
        return out;
    }
    /*
    @Override
    public String toString() {
        String out = "";

        for (String k : dados.keySet()) {
            out += dados.get(k);
        }
        out += "";
        return out;
    }*/
}

class Whatsapp {

    Repositorio<Usuario> usuarios;
    Repositorio<Grupo> grupos;
    int aux = 0;
    
    Whatsapp() {
        this.usuarios = new Repositorio<>();
        this.grupos = new Repositorio<>();
    }

    public void listarUsuarios() {
        String out = "[ ";
        for (Usuario u : usuarios.getAll()) {
            out += u.getNome() + " ";
        }
        out += "]";
        System.out.println(out);
    }

    public void invite(String convidador, String convidado, String grupo) {
        if (grupos.get(grupo).usuarios.get(convidador) != null) {
            grupos.get(grupo).addConvidado(usuarios.get(convidado));
        }
    }

    public void zap(String nome, String nomeGrupo, String msg) {
        
        usuarios.get(nome).grupos.get(nomeGrupo).mensagens.add(aux, new Mensagem(usuarios.get(nome), msg));
        usuarios.get(nome).grupos.get(nomeGrupo).notificacoes.add(aux, new Notificacao(grupos.get(nomeGrupo)));
        //aux++;
    }
    public void ler(String nome, String nomeGrupo){
        System.out.println(usuarios.get(nome).grupos.get(nomeGrupo).mensagens);
        usuarios.get(nome).grupos.get(nomeGrupo).cont=0;
        
    }

    public String toString() {
        String out = "[ ";
        for (Grupo g : grupos.getAll()) {
            out += g.getNomeGrupo();
        }
        out += "]";
        return out;
    }

}

class Usuario {

    String nome;
    Repositorio<Grupo> grupos;

    Usuario(String nome) {
        this.nome = nome;
        grupos = new Repositorio<>();
    }

    public String getNome() {
        return nome;
    }

    public String chats() {
        String out = "[ ";
        for (Grupo g : grupos.getAll()) {
            out += g.getNomeGrupo() + " ";
        }
        out += "]";
        return out;
    }
    @Override
    public String toString() {
        String out = "[ ";
        for (Grupo g : grupos.getAll()) {
            out += g.getNomeGrupo() +"("+ g.cont +")";
        }
        out += " ]";
        return out;
    }
}

class Grupo {
    int cont=0;
    String nomeGrupo;
    Repositorio<Usuario> usuarios;
    ArrayList<Mensagem> mensagens;
    ArrayList<Notificacao> notificacoes;
    Grupo(String nomeGrupo, Usuario usuario) {
        this.nomeGrupo = nomeGrupo;
        this.usuarios = new Repositorio<>();
        this.usuarios.add(usuario.getNome(), usuario);
        usuario.grupos.add(nomeGrupo, this);
        this.mensagens = new ArrayList<>();
        this.notificacoes = new ArrayList<>();
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void addConvidado(Usuario usuario) {
        usuarios.add(usuario.getNome(), usuario);
        usuario.grupos.add(nomeGrupo, this);
    }
    
    @Override
    public String toString() {
        String out = "[ ";
        for (Usuario u : usuarios.getAll()) {
            out += u.getNome() + " ";
        }
        out += "]";
        return out;
    }
}

class Mensagem {

    Usuario usuario;
    String texto;

    public Mensagem(Usuario usuario, String texto) {
        this.usuario = usuario;
        this.texto = texto;
    }

    public Usuario getNomeUsuario() {
        return usuario;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public String toString() {
        String out;
        out = "[" + usuario.getNome() + ": " + texto + "]";
        return out;
    }
}
class Notificacao {

    Grupo grupo;
    int contNaoLidas;

    public Notificacao(Grupo grupo) {
        this.grupo = grupo;
    }

    public Grupo getNomeGrupo() {
        return grupo;
    }

    @Override
    public String toString() {
        String out;
        out = "[" + grupo.getNomeGrupo() + ": " + contNaoLidas + "]";
        return out;
    }
}
public class Controller {

    public static void main(String[] args) {
        Whatsapp whatsapp = new Whatsapp();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            String vet[] = line.split(" ");
            switch (vet[0]) {
                case "addUser":
                    whatsapp.usuarios.add(vet[1], new Usuario(vet[1]));
                    break;
                case "allUsers":
                    whatsapp.listarUsuarios();
                    break;
                case "newChat":
                    whatsapp.grupos.add(vet[2], new Grupo(vet[2], whatsapp.usuarios.get(vet[1])));
                    break;
                case "chats":
                    System.out.println(whatsapp.usuarios.get(vet[1]).chats());
                    break;
                case "invite":
                    whatsapp.invite(vet[1], vet[2], vet[3]);
                    break;
                case "users":
                    System.out.println(whatsapp.grupos.get(vet[1]));
                    break;
                case "leave":
                    whatsapp.grupos.get(vet[2]).usuarios.del(vet[1]);
                    whatsapp.usuarios.get(vet[1]).grupos.del(vet[2]);
                    break;
                case "zap":
                    for (int i = 4; i < vet.length; i++) {
                        vet[3] += " " + vet[i];
                    }
                    whatsapp.zap(vet[1], vet[2], vet[3]);
                    whatsapp.usuarios.get(vet[1]).grupos.get(vet[2]).cont+=1;
                    break;
                case "ler":
                    whatsapp.ler(vet[1], vet[2]);
                    break;
                case "notify":
                    System.out.println(whatsapp.usuarios.get(vet[1]));
                    break;
                case "end":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Comando inválido!");
            }
        }
    }
}
