package PLA2_Actividades;

class Espanyola extends Baraja {
  /*La baraja española consta de los palos 'espadas', 'bastos', 'oros' y 'copas'.
  Las cartas van desde el 1 al 7 y las figuras Sota, Caballo y Rey. */   
  enum Palos{
    BASTOS("Bastos"),COPAS("Copas"), ESPADAS("Espadas"), OROS("Oros");
    private final String palo;
    Palos(String strPalo){
      palo = strPalo;
    }
    public String getP() {return palo;}
  }  
  enum Nombres{
    AS("As",1), DOS("2",2), TRES("3",3), CUATRO("4", 4), CINCO("5", 5), SEIS("6", 6),
    SIETE("7", 7), SOTA("Sota", 10), CABALLO("Caballo",10), REY("Rey", 10);
    private final String nombre;
    private final int valor;
  
    private Nombres(String strNombre, int intValor) {
      nombre = strNombre;
      valor = intValor;
    }
    public String getN() {return nombre;}
    public int getV() {return valor;}
  }  

  Espanyola() {
    /*Constructor sin parámetros que nos creará por primera vez la baraja de
      cartas llamando al método reiniciar*/
    reiniciar();
  }
  
  @Override  
  void reiniciar() {
    /*borrar el arraylist de cartas si estuviera lleno*/
    if (!cartas.isEmpty()) cartas.clear();
  
    /*Crear una baraja espanyola (40 cartas). Para crearlas tendremos que crear
      tantas instancias de la clase cartas como sea necesaria, teniendo en
      cuenta que el valor de las cartas es el número para las cartas que van del
      1 al 7 y de 10 para las cartas Sota, Caballo y Rey.(Pista: dos bucles anidados)
    */
    for(Espanyola.Palos p : Espanyola.Palos.values()) {
      for(Nombres n : Nombres.values()) {
        Carta c = new Carta(p.palo, n.nombre, n.valor);
        cartas.add(c);
      }
    }
  }
  
  @Override
  int cartasxPalo() {
    return Nombres.values().length;
  }
}
