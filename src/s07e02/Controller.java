/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s07e02;

import java.util.ArrayList;

/**
 *
 * @author Lucas Amorim
 */
class Pokemon{
    private String name;
    protected int life;
    public String ataque;
    public Pokemon(String name){
        this.name = name;
        this.life = 10;
        this.ataque = "Ataque normal";
    }

    @Override
    public String toString() {
        return "nome: " + this.name + "\nvida: " + this.life + " " + this.ataque;
    }
    
}
class PokemonAgua extends Pokemon{
    public PokemonAgua(String name){
        super(name + " of water");
        
    }
    
    public void Atacar(){
        this.ataque = "Ataque de agua! Water Gun!";
        System.out.println("O pokemon de agua atacou");
    } 
    
}
public class Controller {
    public static void main(String[] args) {
        ArrayList<Pokemon> listaPokemons = new ArrayList<Pokemon>();
        listaPokemons.add(new Pokemon("gabiru"));
        listaPokemons.add(new PokemonAgua("ratazana"));
        for(Pokemon pokemon : listaPokemons){
            System.out.println(pokemon);
        }
    }
    
    
}
