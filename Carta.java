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
