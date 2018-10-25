package modeloqytetet;

import java.util.*;

/** @author Pablo Robles */

public class Jugador {
  private boolean encarcelado = false;
  protected int saldo = 7500;
  protected Sorpresa cartaLibertad;//por la relacion con sorpresa
  protected Casilla casillaActual = new Casilla(0, TipoCasilla.SALIDA);//por la relacion con casilla 
  protected final ArrayList<TituloPropiedad> propiedades;// por la relación con TituloPropiedad
  private final String nombre;
  
  //Constructor con nombre
  Jugador(String nombre) {
    this.nombre = nombre;
    propiedades = new ArrayList<>();
  }
  //Constructor copia
  Jugador(Jugador jugador) {
    encarcelado = jugador.encarcelado;
    nombre = jugador.nombre;
    saldo = jugador.saldo;
    propiedades = new ArrayList<>(jugador.propiedades);
    cartaLibertad = jugador.cartaLibertad;
    casillaActual = jugador.casillaActual;
  }
 
  public ArrayList<TituloPropiedad> getPropiedades() {
    return propiedades;
  } 
  //Setter
  void setCartaLibertad(Sorpresa carta) {
    cartaLibertad = carta;
  }

  void setCasillaActual(Casilla casilla) {
    casillaActual = casilla;
  }

  void setEncarcelado(boolean encarcelado) {
    this.encarcelado = encarcelado;
  }

  public boolean tengoPropiedades() {
    return !propiedades.isEmpty();
  }

  public boolean bancarrota() {
    return saldo <= 0;
  }

  //Metodos Practica 2 diagrama clases
  /*
  boolean cancelarHipoteca(TituloPropiedad titulo){}
  
  boolean comprarTituloPropiedad(){}
  
  int cuantasCasasHotelesTengo() {}
  
  boolean deboPagarAlquiler(){}
  */
  Sorpresa devolverCartaLibertad() {
    Sorpresa c = cartaLibertad;
    cartaLibertad = null;
    return c;
  }
  /*
  boolean edificarCasa(TituloPropiedad titulo){}
  
  boolean edificarHotel(TituloPropiedad titulo){}
  
  void eliminarDeMisPropiedades(TituloPropiedad titulo) {}

  boolean esDeMiPropiedad(TituloPropiedad titulo) {}
  
  boolean estoyEnCalleLibre(){}
  */
  //getter
  public Sorpresa getCartaLibertad() {
    return cartaLibertad;
  }
  
  public Casilla getCasillaActual() {
    return casillaActual;
  }

  public boolean getEncarcelado() {
    return encarcelado;
  }

  public String getNombre() {
    return nombre;
  }
  
  //public TituloPropiedad getPropiedades(){}
  
  public int getSaldo() {
    return saldo;
  }
  
  //boolean hipotecarPropiedad(Titulo titulo_propiedad){}
  
  void irACarcel(Casilla casilla) {
    encarcelado = true;
    casillaActual = casilla;
  }
  
  void modificarSaldo(int cantidad) {
    saldo += cantidad;
  }
  /*
  int obtenerCapital() {}
  
  ArrayList<TituloPropiedad> obtenerPropiedades(boolean hipotecada) {}
  */
  protected void pagarAlquiler(int cantidad) {
    modificarSaldo(-cantidad);
  }
  
  protected void pagarImpuesto(int cantidad) {
    modificarSaldo(-cantidad);
  }
  
  boolean pagarLibertad(int cantidad) {
    if (tengoSaldo(cantidad)) {
      modificarSaldo(cantidad);
      return true;
    }

    return false;
  }
  
  boolean tengoCartaLibertad() {
    return cartaLibertad != null;
  }
  
  private boolean tengoSaldo(int cantidad) {
    return saldo >= cantidad;
  }
  
  void venderPropiedad(Casilla casilla) {}

  @Override
  public String toString() {
    return "JUGADOR:\n" + crearStringAtributos();
  }

  protected String crearStringAtributos() {
    return String.format("Nombre: %s\n", nombre) + String.format("Saldo %d\n", saldo)
        + String.format("¿Carta libertad?: %b\n", cartaLibertad != null)
        + String.format("¿Encarcelado?: %b\n", encarcelado)
        + String.format("Casilla actual: %d\n", casillaActual.getNumeroCasilla())
        + String.format("Propiedades:\n%s",
              propiedades.stream()
                .map(TituloPropiedad::toString)
                .reduce("", (s, p) -> s + "-------------------------\n" + p));
  }
}