/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s10e01;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Lucas Amorim
 */
public class Controller {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        
        map.put("fiat", "vermelho");
        
        while (true){
            String line = scanner.nextLine();
            String[] vet = line.split(" ");
            switch(vet[0]){
                case "add":
                    map.put(vet[1], vet[2]);
                    break;
                case "read":
                    for (Map.Entry<String, String> matriz : map.entrySet()){
                        System.out.println(matriz.getKey() +" "+ matriz.getValue());
                    }
                    break;
                case "del":
                    map.remove(vet[1], vet[2]);
                    break;
                case "update":
                    for (Map.Entry<String, String> matriz : map.entrySet()){
                        if(vet[1].equals(matriz.getKey())){
                            map.put(vet[1], vet[2]);
                        }
                    }
                break;
                case "end":
                    System.exit(0);
                    break;
            }
        }
        
    }
}
