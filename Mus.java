package PLA2_Actividades;

import java.util.ArrayList;

/*Igual que con las barajas Espanyola y Francesa creamos una clase abstracta 
  Baraja para poner propiedades y métodos comunes a ambas, aquí he hecho lo
  propio para poner el array de jugadores como protected para que sea heredable
  y también he puesto métodos comunes. Uno es el addJugador(), que estaría actuando
  como "setter".Y, si quiero obtener la lista de jugadores, ya que he puesto
  esta propiedad protected, también he puesto un getter, que ahora sí es propiamente
  un getter.
*/
public class Mus extends Juegos{
  /*Las hago protected en una superclase abstracta Juegos, donde he metido código
    que se repite, de la misma forma que se hizo con la clase abstracta Baraja*/
  //private Espanyola musBaraja;
  //private ArrayList<Jugador> jugadores = new ArrayList(0);
  
  Mus() {
    juegoBaraja = new Espanyola();
  }
  
  //Espanyola getmusBaraja() {
  //  return juegoBaraja;
  //}
  
  //void addJugador(Jugador j) {
  //  jugadores.add(j);
  //}

  /*Voy a crear un getter también, ya que hice la propiedad privada, aunque no lo
    usaré. Iba a usarlo para sacar una cadena de texto con todos los jugadores*/
  //ArrayList<Jugador> getJugadores() {
  //  return jugadores;
  //}  
}