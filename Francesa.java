package PLA2_Actividades;

public class Francesa extends Baraja {
  /*La baraja Francesa consta de los palos 'picas', 'tréboles', 'diamantes' y
  'corazones'. Las cartas van desde el 1 al 10 y las figuras J, Q y K.*/  
  enum Palos{
    CORAZONES("Corazones"),DIAMANTES("Diamantes"), PICAS("Picas"), TREBOLES("Tréboles");
    private final String palo;
  
    Palos(String strPalo) {
      palo = strPalo;
    } 
    public String getP() {return palo;}
  }
  /*Utilizo también enum para poner juntos el nombre y valor de la carta*/
  enum Nombres{
    AS("As",1), DOS("2",2), TRES("3",3), CUATRO("4", 4), CINCO("5", 5),
    SEIS("6", 6), SIETE("7", 7), OCHO("8", 8), NUEVE("9", 9), DIEZ("10", 10),
    J("Jack", 10), Q("Queen",10), K("King", 10);
    final String nombre;final int valor;
   
    Nombres(String strNombre, int intValor) {
      nombre = strNombre;
      valor = intValor;
    }
    public String getN() {return nombre;}
    public int getV() {return valor;}
  }

  Francesa() {
    /*Constructor sin parámetros que nos creará por primera vez la baraja de
      cartas llamando al método reiniciar*/
    reiniciar();
  }
  
  @Override  
  void reiniciar() {
    /*borrar el arraylist de cartas si estuviera lleno*/
    if (!cartas.isEmpty()) cartas.clear();
  
    /*crear una baraja francesa (52 cartas). Para crearlas tendremos que crear
      tantas instancias de la clase cartas como sea necesaria, teniendo en
      cuenta que el valor de las cartas es el número para las cartas que van del
      1 al 10 y de 10 para las cartas J, Q y K. (Pista: dos bucles anidados)*/
    for(Francesa.Palos p : Francesa.Palos.values()) {
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
