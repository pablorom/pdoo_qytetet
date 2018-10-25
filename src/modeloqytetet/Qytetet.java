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
public class Qytetet {

    //Variable estatica unica instancia de tipo Qytetet
    private static final Qytetet unico_qytetet = new Qytetet();
    //Variables
    private static final ArrayList<Sorpresa> mazo = new ArrayList();
    private Tablero tablero;//por la realcion con tablero
    //Practica 2. Variables del diagrama clases
    private static final ArrayList<Jugador> jugadores = new ArrayList(); //por la realcion con jugador
    Sorpresa carta_actual; //por la relacion entre Qytetet y Sorpresa (0 o 1)
    Jugador jugador_actual; //por la realcion con jugador
    public static final int MAX_JUGADORES = 4;;
    static int num_sorpresas = 10;
    public static int num_casillas = 20;
    static int precio_libertad = 200;
    static int saldo_salida = 1000;
    Dado dado = Dado.getInstance();
    int valor_dado;
    //Constructor privado de Singleton
    private Qytetet(){
        inicializarTablero(); //llama al constructor de tablero
    }
    //Metodo estatico para crear instancia de la clase Singleton
    public static Qytetet getInstance(){
        return unico_qytetet; 
    }
    
    ArrayList<Sorpresa> getMazo() {
        return mazo;
    }
    
    Tablero getTablero(){
        return tablero;
    }
    
    //Creamos las sorpresas
    void inicializarCartasSorpresa(){
        //Esta sorpresa te manda a la casilla 9 (que es la carcel)
        mazo.add(new Sorpresa("Te toca pasar un tiempo entre rejas. Que no se te caiga el jabon en las duchas.", tablero.getCarcel().getNumeroCasilla(), TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("¿Podrías decirme cuanto es 7-6? Exacto, retrocede a la casilla numero 1.", 1, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("La liga antisuperstición te envía de viaje al número 13.", 13, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Eh, tu. Si, tu. Suelta la pasta ahora mismo! No es nada personal…", -200, TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("¡Enhorabuena! Parece que te toca cobrar. Coge el dinero, es todo tuyo.", 100, TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Tener propiedades mola, pero ahora te toca pagar por ellas. ¿A que ahora no mola tanto, eh?", -200, TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa("¡Wow, menuda bonificacion por tus propiedades! Parece que es tu dia de suerte.", 300, TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa("Te toca hacer un poco de colecta. Asi es, coge un poco de dinero de cada jugador.", 200, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("Vaya, vaya… Parece que cada jugador te exige una suma de tu dinero. No seas avaro.", -100, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("Toca salir del talego. Pasara un tiempo hasta que vuelvas a la carcel. ¿O no?", 0, TipoSorpresa.SALIRCARCEL)); 
    }
    
    private void inicializarTablero(){
        tablero = new Tablero(); //En el cosntructor se llama a inicializar
    }
    
    //Practica 2. Metodos del diagrama clases
    void actuarSiEnCasillaEdificable(){}
    void actuarSiEnCasillaNoEdificable(){}
    public void aplicarSorpresa(){}
    public boolean cancelarHipoteca(int numeroCasilla){return false;}
    public boolean comprarTituloPropiedad(){return false;}
    public boolean edificarCasa(int numeroCasilla){return false;}
    public boolean edificarHotel(int numeroCasilla){return false;}
    private void encarcelarJugador(){}
    
    public Sorpresa getCartaActual(){
        return carta_actual;
    }
    
    Dado getDado(){
        return Dado.getInstance();
    }
    
    Jugador getJugadorActual(){
        return jugador_actual;
    }
    
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
    
    public int getValorDado(){
        return valor_dado;
    }
    
    public void hipotecarPropiedad(int numeroCasilla){}
    
    void inicializarJugadores (ArrayList<String> nombres){
        for(String j: nombres){
            jugadores.add(new Jugador(j));
        }
    }
    
    public void inicializarJuego(ArrayList<String> nombres){
        inicializarJugadores(nombres);
        inicializarCartasSorpresa();
        inicializarTablero();
        // Baraja el mazo de cartas usando el metodo shuffle 
        // de la clase Collections que funciona como wrapper de mazo
        Collections.shuffle(mazo);
    }
    /*
    public boolean intentarSalirCarcel(MetodoSalirCarcel metodo){
        boolean libre;

        if (metodo == MetodoSalirCarcel.TIRANDODADO)
          libre = dado.nextNumber() > 5;
        else
          libre = jugador_actual.pagarLibertad(-precio_libertad);

        if (libre)
          jugador_actual.setEncarcelado(false);

        return libre;
    }
    */
    
    public void jugar(){}
    
    void mover(int numCasillaDestino){}
    
    /*
    public Casilla obtenerCasillaJugadorActual(){}
    
    public ArraryList<Casilla> obtenerCasillasTablero(){}
    
    public int obtenerPropiedadesJugador(){}
    
    public int obtenerPropiedadesJugadorSegunEstadoHipoteca(boolean estadoHipoteca){}
    */
    public void obtenerRanking(){}
    /*
    public int obtenerSaldoJugadorActual(){}
    
    private void salidaJugadores() {        
        for(Jugador j: jugadores){
            j.setCasillaActual(tablero.obtenerCasillaNumero(0));
            j.modificarSaldo(SALDO_SALIDA);
        }

        int i = new Random().nextInt(jugadores.size());
        jugadorActual = jugadores.get(i);
    }
    */
    
    private void setCartaActual(Sorpresa carta){
        carta_actual = carta;
    }
    
    public void siguienteJugador(){}
    /*
    int tirarDado(){}
    
    public boolean venderPropiedad(int numero_casilla){}
    */
}
