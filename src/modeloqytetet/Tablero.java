package modeloqytetet;

import java.util.ArrayList;

/**
 * 
 * @author Pablo Robles 
 */
public class Tablero {
    private ArrayList<Casilla> casillas;
    private Casilla carcel;
    
    public Tablero(){
        inicializar();
    }
    
    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }
    
    public Casilla getCarcel(){
        return this.carcel;
    }
    
    @Override
    public String toString(){
        return casillas.toString();
    }
    
    private void inicializar(){
        casillas = new ArrayList();
        
        //String nuevo_nombre, 
        //int precio_comp, 500-1000
        //int alq_base, 50-100
        //float factor_revalorizacion, 10-20%
        //int hip_base, 150-1000
        //int prec_edif 250-750
        TituloPropiedad tituloP1 = new TituloPropiedad("Edificio lujoso", 1000, 100, (float)0.2, 600, 400);
        TituloPropiedad tituloP2 = new TituloPropiedad("Edificio de viviendas familiares", 500, 60, (float)0.15, 200, 300);
        TituloPropiedad tituloP3 = new TituloPropiedad("Parking 1", 600, 100, (float) 0.15, 400, 250);
        TituloPropiedad tituloP4 = new TituloPropiedad("Chalet", 1000, 100, (float)0.2, 600, 400);
        TituloPropiedad tituloP5 = new TituloPropiedad("Granja", 600, 100, (float) 0.15, 400, 250);
        TituloPropiedad tituloP6 = new TituloPropiedad("Apartamentos Acomodados", 700, 90, (float) 0.1, 400, 300);
        TituloPropiedad tituloP7 = new TituloPropiedad("Campo de golf", 1000, 100, (float)0.2, 600, 400);
        TituloPropiedad tituloP8 = new TituloPropiedad("Parque placentero", 800, 100, (float) 0.2, 300, 250);
        TituloPropiedad tituloP9 = new TituloPropiedad("Pisos picados", 800, 80, (float)0.2, 600, 400);
        TituloPropiedad tituloP10 = new TituloPropiedad("Centro comercial",1000, 100, (float)0.2, 600, 400);
       
        //Parking
        Casilla C15 = new Casilla(15, TipoCasilla.PARKING, tituloP3);
        //Sorpresas 4, 7, 12
        Casilla C4 = new Casilla(4, TipoCasilla.SORPRESA);
        Casilla C7 = new Casilla(7, TipoCasilla.SORPRESA);
        Casilla C12 = new Casilla(12, TipoCasilla.SORPRESA);
        //Juez
        Casilla C6 = new Casilla(6, TipoCasilla.JUEZ);
        //Impuesto
        Casilla C16 = new Casilla(7, TipoCasilla.IMPUESTO);
        //Calle
        Casilla C1 = new Casilla(1, TipoCasilla.CALLE, tituloP2);
        Casilla C2 = new Casilla(2, TipoCasilla.CALLE, tituloP4);
        Casilla C3 = new Casilla(3, TipoCasilla.CALLE, tituloP5);
        Casilla C5 = new Casilla(5, TipoCasilla.CALLE, tituloP6);
        Casilla C8 = new Casilla(8, TipoCasilla.CALLE, tituloP7);
        Casilla C10 = new Casilla(10, TipoCasilla.CALLE, tituloP8);
        Casilla C11 = new Casilla(11, TipoCasilla.CALLE, tituloP9);
        Casilla C13 = new Casilla(13, TipoCasilla.CALLE, tituloP10);
        Casilla C14 = new Casilla(14, TipoCasilla.CALLE, tituloP4);
        Casilla C17 = new Casilla(17, TipoCasilla.CALLE, tituloP9);
        Casilla C18 = new Casilla(18, TipoCasilla.CALLE, tituloP2);
        Casilla C19 = new Casilla(19, TipoCasilla.CALLE, tituloP1);
        //Salida
        Casilla C0 = new Casilla(0, TipoCasilla.SALIDA);
        //Carcel
        Casilla C9 = new Casilla(9, TipoCasilla.CARCEL);
        //Añadimos las casillas al arraylist
        casillas.add(C0);
        casillas.add(C1);
        casillas.add(C2);
        casillas.add(C4);
        casillas.add(C5);
        casillas.add(C6);
        casillas.add(C7);
        casillas.add(C8);
        casillas.add(C9);
        casillas.add(C10);
        casillas.add(C11);
        casillas.add(C12);
        casillas.add(C13);
        casillas.add(C14);
        casillas.add(C15);
        casillas.add(C16);
        casillas.add(C17);
        casillas.add(C18);
        casillas.add(C19);
        //Inicializamos carcel a casilla 9
        carcel = C9;
    }
}
