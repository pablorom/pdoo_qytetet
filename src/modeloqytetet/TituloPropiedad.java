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
public class TituloPropiedad {
    private String nombre;
    private boolean hipotecada = false;
    private int precioCompra;
    private int alquilerBase;
    private float factorRevalorizacion;
    private int hipotecaBase;
    private int precioEdificar;
    private int numHoteles = 0, numCasas = 0;
    
    public TituloPropiedad(String nuevo_nombre, int precio_comp, int alq_base, float factor_revalorizacion, int hip_base, int prec_edif){
        nombre = nuevo_nombre;
        precioCompra = precio_comp;
        alquilerBase = alq_base;
        factorRevalorizacion = factor_revalorizacion;
        hipotecaBase = hip_base;
        precioEdificar = prec_edif;
    }
    
    String getNombre(){
        return this.nombre;
    }
    
    boolean getHipotecada(){
        return this.hipotecada;
    }
    
    int getPrecioCompra(){
        return this.precioCompra;
    }
    
    int getAlquilerBase(){
        return this.alquilerBase;
    }
    
    float getFactorRevalorizacion(){
        return this.factorRevalorizacion;
    }
    
    int getHipotecaBase(){
        return this.hipotecaBase;
    }
    
    int getPrecioEdificar(){
        return this.precioEdificar;
    }
    
    int getNumHoteles(){
        return this.numHoteles;
    }
    
    int getNumCasas(){
        return this.numCasas;
    }
    
    void setHipotecada(boolean hipot){
        hipotecada = hipot;
    }
    
    @Override
    public String toString() {
        return "Casilla {" + "Nombre: " + nombre + "\n " +
                "Hipotecada: " + (hipotecada ? "Si" : "No") + "\n" + 
                "Alquiler base: " + alquilerBase + "\n" +
                "Factor revalorizacion: " + factorRevalorizacion + "\n" +
                "Hipoteca base: " + hipotecaBase + "\n" +
                "Precio edificar: " + precioEdificar +"}";
    }
}
