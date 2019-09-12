package s06e01;

import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Lucas Amorim
 */
public class TesteArray {
    public static void showArray(ArrayList<Integer> array){
        for (Integer elem : array){
            System.out.print(elem + " ");
        }
        System.out.print("\n");
    }
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        lista.add(4);
        lista.add(7);
        lista.add(8);
        lista.add(25);
        showArray(lista);
        lista.set(1,44);
        showArray(lista);
        lista.remove(0);
        showArray(lista);
        for (int i=0; i<lista.size(); i++){
            lista.set(i, lista.get(i)+1);
        }
        showArray(lista);
        
    }
}
