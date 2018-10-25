/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
