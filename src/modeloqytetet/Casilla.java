/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author Pablo
 */
public class Casilla {
    private int numeroCasilla;
    private int coste;
    private TipoCasilla tipo;
    private TituloPropiedad titulo;
    
    //casilla tipo calle
    public Casilla(int numeroCasilla, TipoCasilla tipo, TituloPropiedad titulo){
        this.numeroCasilla = numeroCasilla;
        this.tipo = tipo;
        this.coste = titulo.getPrecioCompra();
        this.setTitulo(titulo);
    }
    
    //casilla de otro tipo
    public Casilla(int numeroCasilla, TipoCasilla tipo){
        this.numeroCasilla = numeroCasilla;
        this.tipo = tipo;
        this.coste = 0;
    }
    
    public int getNumeroCasilla(){
        return this.numeroCasilla;
    }
    public int getCoste(){
        return this.coste;
    }

    public TipoCasilla getTipo(){
        return this.tipo;
    }
    public TituloPropiedad getTitulo(){
        return this.titulo;
    }

    private void setTitulo(TituloPropiedad titulo){
        this.titulo = titulo;
    }
    
    @Override
    public String toString(){
        return "Información casilla Nº " + numeroCasilla +
                ":\n Título de propiedad:" + (titulo != null ? "\n" + titulo : "  Sin título")+
                "\n Tipo de casilla: " + tipo + "\n";
    }
    
}
