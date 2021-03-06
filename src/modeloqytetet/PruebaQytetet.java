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
public class PruebaQytetet {
    
    private static Qytetet juego = Qytetet.getInstance(); //se inicializa tablero y sus casillas
    
    //Practica 2: Metodo para leer numero de jugadores y sus nombres
    private static final Scanner in = new Scanner(System.in);
    
    static ArrayList<String> getNombreJugadores(){
        ArrayList<String> lista_nombres = new ArrayList();
        int num_jugadores = 0;
        String nom = "";
        
        System.out.println("Introduzca el numero de jugadores");
        num_jugadores = in.nextInt();
        in.nextLine();
        //Pregunta los nombres de los num_jugadores
        for(int i=0; i<num_jugadores; i++){
            System.out.println("Introduzca el nombre de Jugador"+(i+1)+": ");
            nom = in.nextLine();
            lista_nombres.add(nom);
        }
        
        return lista_nombres;
    }
    
    private static ArrayList<Sorpresa> sorpresasPositivas(){
        ArrayList<Sorpresa> mazoPositivo = new ArrayList();
        for(Sorpresa s: juego.getMazo())
            if(s.getValor() > 0)
                mazoPositivo.add(s);
        return mazoPositivo;
    }
    
    private static ArrayList<Sorpresa> sorpresasIrACasilla(){
        ArrayList<Sorpresa> mazoCasillas = new ArrayList();
        for(Sorpresa s: juego.getMazo())
            if(s.getTipo().equals(TipoSorpresa.IRACASILLA))
                mazoCasillas.add(s);
        return mazoCasillas;
    }
    
    private static ArrayList<Sorpresa> sorpresasDeTipo(TipoSorpresa un_tipo){
        ArrayList<Sorpresa> mazoTipo = new ArrayList();
        for(Sorpresa s: juego.getMazo())
            if(s.getTipo().equals(un_tipo))
                mazoTipo.add(s);
        return mazoTipo;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        juego.inicializarCartasSorpresa();
        //Muestra contenido del mazo
        System.out.println("MAZO -----------");
        System.out.println(juego.getMazo().toString());
        
        //Tres metodos sesion 1
        /*
        System.out.println(sorpresasPositivas().toString());
        System.out.println(sorpresasIrACasilla().toString());
        System.out.println(sorpresasDeTipo(TipoSorpresa.PORCASAHOTEL).toString());  
        */
        System.out.println("CASILLAS -----------");
        System.out.println(juego.getTablero().toString());
        
        //Pedimos numero de jugadores y nombres
        ArrayList<String> nombres = new ArrayList();
        
        nombres = getNombreJugadores();
        
        System.out.println("Nombres de los jugadores ----------");
        for(String n: nombres){
            System.out.println(n); 
        } 
        juego.inicializarJugadores(nombres);
        
        System.out.println("Info de los jugadores ----------"); 
        for(Jugador j: juego.getJugadores()){
            System.out.println(j.toString()); 
        }
        
    }
    
}
