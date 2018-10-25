package modeloqytetet;

import java.util.*;
/**
 *
 * @author Pablo Robles
 */
public class Dado {
    private static final Dado dado = new Dado();
    
    //Variables
    private int valor;
    
    private Dado(){}
    //Metodo
    int tirar(){
        Random num = new Random();
        return num.nextInt(6)+1;
    }
    public int getValor(){
        return dado.valor;
    }
    
    public static Dado getInstance(){
        return dado;
    }
}
