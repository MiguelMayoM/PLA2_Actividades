package PLA2_Actividades;

import java.util.ArrayList;

class Jugador {
  private String nombre;
  private final ArrayList<Carta> cartas;
  
  /*Al constructor sólo se le pasa el nombre del jugador, pero el ArrayList de
    cartas también se inicializa*/

  /*El throws Exception aborta el programa y me da el mensaje que ahí pongo para
    así localizar el error rápido, imagino... pero para eso al compilar ya da
    también el nombre de la clase y número de la línea que provoca el error, de
    forma que se localiza fácilmente...Vale, lo que voy a hacer es llamar al
    constructor desde un try catch y recoger la excepción que se pueda dar
    aquí*/
  Jugador(String strNombre) throws Exception {
    //if (strNombre.equals("")) throw new Exception("Nombre vacío. Vuelva a probar\n");
    nombre = compruebaNombre(strNombre);
    /*Y además hay que poner también "throws Exception" en la línea del método
      que llama a este otro: "static void Actividad1() throws Exception {"
      en la clase Actividades.java*/
    //nombre = strNombre;
    cartas = new ArrayList(0);
  }

  /*Setter y getter para la variable privada nombre*/
  void setNombre(String strNombre) throws Exception{
    nombre = compruebaNombre(strNombre);
    //nombre = strNombre;
  }
  /*Si quisiera poder cambiar el nombre del jugador y pedirlo en la misma línea,
    debería implementar el setNombre de tal forma que recibiera y devolviera
    el objeto, para poder concatenar a continuación el getNombre, en la forma:
    jugador1.setNombre(jugador1, "Miguel2").getNombre();
      Jugador setNombre(Jugador jdr, String strNombre) {
        nombre = strNombre;
        return jdr;
      }  
  */
  String getNombre() {
    return this.nombre;
  }
  
  /*Añadir el la carta pasada como parámetro al ArrayList de las cartas del
    Jugador. No deja de ser un "setter", que mantiene elementos antiguos a la
    vez que añade uno nuevo*/
  void darCarta(Carta carta) {
    cartas.add(carta);
  }
  
  /*Nos devuelve la carta retirada al tiempo que se elimina del ArrayList. Sería
    también un "setter", ya que mantiene los elementos que no elimina,
    complementando al "setter" anterior de añadimiento*/
  Carta retirarCarta(int indice) {
    return cartas.remove(indice);
  }
  
  /*Devolver cadena con las cartas entre corchetes, e.g. [1 de bastos, 5 de oros]
    Es la versión "conjunta" del toString de cada carta individual*/
  String juego() {
    String strJuego = "[";
    for (Carta c: cartas) {
      strJuego += c.toString() + ",";
    }
    return strJuego.replaceAll("(.)$","") + "]";
  }
  
  static String compruebaNombre(String strNombre) throws Exception {
    if (strNombre.equals("")) {
      throw new Exception("Nombre vacío. Vuelva a probar\n");
    }
    return strNombre;
  }
}