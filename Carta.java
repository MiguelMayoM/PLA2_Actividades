package PLA2_Actividades;

class Carta{
  private String palo;
  private String nombre;
  private int valor;
  
  Carta(String strPalo, String strNombre, int intValue) {
    palo = strPalo;
    nombre = strNombre;
    valor = intValue;
  }
  
  /*SI LA CARTA FUERA INMUTABLE ESTO DEBERÍA DAR ERROR Y NO LO DA!!!
      ASÍ PUES NO SÉ SI A NIVEL EJECUCIÓN DE PROGRAMA TIENE ALGÚN VALOR EL HABER USADO ENUM??????*/  
  /*LOS SETTERS DEBERÍAN DE DAR ERROR????, O NO PORQUE ESTOY DESVINCULANDO LOS
    VALORES QUE LES PASO A ESTOS CONSTRUCTORES CON LAS CONSTANTES DE DONDE HE
    COGIDO ESOS STRINGS, NO LO SÉ*/
  void setPalo (String strPalo){
    palo = strPalo;
  }
  String getPalo() {
    return palo;
  }
  
  void setNombre(String strNombre) {
    nombre = strNombre;
  }
  String getNombre() {
    return nombre;
  }
  
  void setValor(int intValor) {
    valor = intValor;
  }
  int getValor() {
    return valor;
  }
  
  @Override
  public String toString() {
    return this.getNombre() + " de " + palo;
  }
}