package PLA2_Actividades;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Baraja {
  protected ArrayList<Carta> cartas = new ArrayList<Carta>(0);
  
  void barajar() {
    Collections.shuffle(cartas);
    /*He leído que este Shuffle utiliza una implementación del algoritmo de
      Fisher-Yates. Esta versión se llama de Durstendfeld y lo que hace, es:
      -Empieza por el final de la colección, selecciona el último elemento,
        genera un número aleatorio entero entre 1 y el tamaño de la colección, e
        intercambia el elemento que se encuentra en esa posición con el último.
      -Ahora tomamos el siguiente elemento, el (N-1)-ésimo, y se genera un número
        aleatorio entre 1 y esta posición. Como en el paso anterior, se permuta
        el elemento que ocupa la posición N-1 con la resultante del número entero
        aleatorio hallado. 
      -Este proceso se lleva a cabo hasta el elemento 2º, que se intercambia con
        el primero.
      -Así, el tiempo empleado en ordenar la seria es de O(N).
     */
  }
  
  Carta repartir() {
    return cartas.remove(0);
  }
  
  abstract void reiniciar();
  
  /*Esto se lo añado yo. No es necesario para nada obligatorio de lo que se pide
    en el ejercicio, sino para una función por la que muestro por pantalla las
    cartas en renglones, y quiero pasarle sólo la baraja y no el entero (10 o 12),
    que lo calcule a partir del tipo de baraja. Y la función vale para una baraja
    cualquiera, tipo baraja, sin especificar Espanyola o Francesa, y por eso pongo
    la función aquí abstracta para que valga para cualquiera de los dos casos*/
  abstract int cartasxPalo();
  
  /*Para imprimir las cartas de la baraja por renglones en función del número de
    cartas de la baraja, de forma que cuando sea una baraja reinciada, se muestre
    cada palo en una línea diferente*/
  void mostrarCartasBaraja() {
    int intContador = 0;
    int intPorLinea = cartasxPalo();
    
    for (Carta c : cartas) {
      intContador++;
      if (intContador != cartas.size()) {
        System.out.print(c.toString() + ", ");
        if (intContador%intPorLinea == 0) {System.out.println();}
      } else {
        System.out.println(c.toString() + "\n");
      } 
    }
  }  
  
  
  
  
}