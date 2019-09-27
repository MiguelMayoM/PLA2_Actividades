package PLA2_Actividades;

import java.util.Scanner;

class Programa {
  static void impln(String... args) {for (String arg : args) {System.out.print(arg);}System.out.print("\n");}
  static void imp(String... args) {for (String arg : args) {System.out.print(arg);}}
  
  static Scanner scnEntrada = new Scanner(System.in);
  
  public static void main (String[] args) {
    boolean bolSalir = false, bolValida = false;
    String strEleccion;
    do {
      Actividades.CabeceraGeneral();
      do {
        imp("Elija una opción: ");
        /*Para no obligar a poner la "s" mayúscula...*/
        strEleccion = scnEntrada.nextLine().trim().toUpperCase();
        impln("");
               
        switch(strEleccion){
          case "1":
            bolValida = true;
            /*Iniciamos dos jugadores para probar la actividad 1*/
            Actividades.Actividad1(Actividades.DosJugadores());
            break;
          case "2":
            bolValida = true;
            Actividades.Actividad2(Actividades.DosJugadores());
            break;
          case "3":
            bolValida = true;
            Actividades.Actividad3_Mus();
            break;
          case "4":
            bolValida = true;
            Actividades.Actividad4_Poker();
            break; 
          case "S":
            bolValida = true;
            bolSalir = true;
            break;
          default:
            impln("Opcion no válida.");
        }
      } while(!bolValida);
      
      if(!strEleccion.equals("S")){
        impln("Pulse Enter para volver al Menú Inicial.");
      }else{
        break;
      }
      scnEntrada.nextLine();
    } while(!bolSalir);
  }
}
