package modeloqytetet;

/**
 *
 * @author Pablo Robles
 */
public class Casilla {
    private int numeroCasilla;
    private int coste;
    private TipoCasilla tipo;//Si es CALLE tendrá asociado un TituloPropiedad
    private TituloPropiedad titulo;// por la relacion con TituloPropiedad
    
    //casilla tipo calle
    // No es esencial incluir TipoCasilla en este constructor puesto que siempre será CALLE
    Casilla(int numeroCasilla, TipoCasilla tipo, TituloPropiedad titulo){
        this.numeroCasilla = numeroCasilla;
        this.tipo = tipo;
        this.coste = titulo.getPrecioCompra();
        this.setTitulo(titulo);
    }
    
    //casilla de otro tipo
    Casilla(int numeroCasilla, TipoCasilla tipo){
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
    
    //Metodos Practica 2 diagrama clases
    /*
    TituloPropiedad asignarPropietario(Jugador jugador){}
    
    int pagarAlquiler(){}
    
    boolean propietarioEncarcelado(){}
    
    boolean soyEdificable(){}
    
    boolean tengoPropietario(){}
    */
}
