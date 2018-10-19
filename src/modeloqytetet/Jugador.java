package modeloqytetet;

import java.util.*;

/** @author Pablo Robles */

public class Jugador {
  private boolean encarcelado = false;
  protected int saldo = 7500;
  protected Sorpresa cartaLibertad;
  protected Casilla casillaActual;
  protected final ArrayList<TituloPropiedad> propiedades;
  private final String nombre;
  
  //Constructor con nombre
  public Jugador(String nombre) {
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
  
  public int getSaldo() {
    return saldo;
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

  boolean comprarTituloPropiedad(){}

  Sorpresa devolverCartaLibertad() {
    Sorpresa c = cartaLibertad;
    cartaLibertad = null;
    return c;
  }
  
  void pagarCobrarPorCasaYHotel(int cantidad) {
    modificarSaldo(cantidad * cuantasCasasHotelesTengo());
  }

  boolean puedoEdificarCasa(Calle casilla) {
    return esDeMiPropiedad(casilla) && tengoSaldo(casilla.getPrecioEdificar());
  }

  boolean puedoEdificarHotel(Calle casilla) {
    return esDeMiPropiedad(casilla) && tengoSaldo(casilla.getPrecioEdificar());
  }

  boolean puedoHipotecar(Calle casilla) {
    return esDeMiPropiedad(casilla);
  }

  boolean puedoVenderPropiedad(Calle casilla) {
    return !casilla.estaHipotecada() && esDeMiPropiedad(casilla);
  }
 
  int cuantasCasasHotelesTengo() {}

  void eliminarDeMisPropiedades(TituloPropiedad titulo) {}

  boolean esDeMiPropiedad(TituloPropiedad titulo) {}
  
  //Metodos Practica 2 diagrama clases
  boolean hipotecarPropiedad(Titulo titulo_propiedad){}
  
  void irACarcel(Casilla casilla) {
    encarcelado = true;
    casillaActual = casilla;
  }
  
  void modificarSaldo(int cantidad) {
    saldo += cantidad;
  }
  
  int obtenerCapital() {}
  
  ArrayList<TituloPropiedad> obtenerPropiedades(boolean hipotecada) {}

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
  
  void venderPropiedad(Calle casilla) {}

  @Override
  public String toString() {
    return "JUGADOR:\n" + crearStringAtributos();
  }

  protected String crearStringAtributos() {
    return String.format("Nombre: %s\n", nombre) + String.format("Saldo %d\n", saldo)
        + String.format("Carta libertad?: %b\n", cartaLibertad != null)
        + String.format("Encarcelado?: %b\n", encarcelado)
        + String.format("Casilla actual: %d\n", casillaActual.numeroCasilla)
        + String.format("Propiedades:\n%s",
              propiedades.stream()
                .map(TituloPropiedad::toString)
                .reduce("", (s, p) -> s + "-------------------------\n" + p));
  }
}