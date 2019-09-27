package PLA2_Actividades;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Actividades {
  static void impln(String... args) {for (String arg : args) {System.out.print(arg);}System.out.print("\n");}
  static void imp(String... args) {for (String arg : args) {System.out.print(arg);}}
  static String abc(int intN) {return Integer.toString(intN);}
  
  final static String CABGENERAL = "Actividades PLA 2\n";
  final static String[] STRMENUS = {"Clases básicas\n",
                                    "Jerarquía de Barajas\n",
                                    "Creación de juegos y prueba de clases: MUS\n",
                                    "Creación de juegos y prueba de clases: POKER\n"};
  static String Subraya(int intLongitud, String strCaracter) {
    return new String(new char[intLongitud]).replace("\0", strCaracter);
  }
  static void CabeceraGeneral() {
    impln(CABGENERAL, Subraya(CABGENERAL.length(),"="));
            
    for(int i = 0; i < STRMENUS.length; i++){imp(abc(i+1), ". ", STRMENUS[i]);}
    impln("S. Salir\n");
    Subraya(CABGENERAL.length(),"=");
  } 
  static void Cabecera(int intEleccion) {
    impln(abc(intEleccion), ". ", STRMENUS[intEleccion - 1], Subraya(STRMENUS[intEleccion - 1].length() + 2,"="));
  }
  
  static Scanner scnEntrada = new Scanner(System.in);
  
  /****************************************************************************/
  /****************************************************************************/
  static Jugador[] DosJugadores() { //throws Exception {
    /*Jugadores de la partida. El primer dato lo pido por input para probar el
      throw Exception, que nunca antes lo había usado*/
    //imp("Introduzca su nombre: ");
    //String strNombre = scnEntrada.nextLine().trim();
    Jugador jdr1 = null;
    try{jdr1 = new Jugador("Miguel");} //strNombre);
    catch(Exception e){e.printStackTrace();}
    impln("El jugador ", jdr1.getNombre(), " se ha unido a la partida");
    
    Jugador jdr2 = null;
    try{jdr2 = new Jugador("Desconocido");}
    catch(Exception e){e.printStackTrace();}
    
    impln("Otro jugador se ha unido a la partida, cuyo nombre es: \"",
      jdr2.getNombre(), "\"\n");
    
    return new Jugador[] {jdr1, jdr2}; 
  }

  static void Actividad1(Jugador[] jugadores) {
    Cabecera(1);
    Jugador jdr1 = jugadores[0];
    //Jugador jdr2 = jugadores[1];
    
    /*Entrega de cartas al jugador 1. Uso las cartas de baraja española. Se puede
      definir la carta con los enums respectivos a la baraja deseada, o, como
      haremos después para abreviar, directamente con dos String y un int. Pero
      esta manera primera es menos propensa a errores en este caso que los valores
      se dan a mano. Cuando se crea la baraja recorriendo un bucle de lo que sea
      enum o simple array, no hay problema*/
    Carta crtRepartida = new Carta(Espanyola.Palos.OROS.getP(),
                                   Espanyola.Nombres.SIETE.getN(),
                                   Espanyola.Nombres.SIETE.getV());
    jdr1.darCarta(crtRepartida);
    
    impln("El jugador ", jdr1.getNombre(), " ha recibido la carta \"", crtRepartida.toString(), "\"");
    imp("Y recibe otras 3 cartas más, ");
   
    jdr1.darCarta(new Carta("Copas", "Sota", 10));
    Carta[] crtMasCartas = new Carta[]{new Carta("Espadas", "As", 1),
                                       new Carta("Bastos", "Rey", 10)};
    for (Carta c : crtMasCartas) {
      jdr1.darCarta(c);
    
    }
    impln("de forma que, en conjunto, dispone de las cartas: \n", jdr1.juego(), "\n");
    
    /*Cambio de jugador*/
    imp("El jugador ", jdr1.getNombre(), " abandona momentáneamente el juego ");
    /*No se puede hacer jdr1.setNombre("Miguel2").getNombre() porque, para ello,
      el setter debería devolver el objeto, pero no retorna nada (void)*/
    
    /*Aquí no va a haber error porque lo pongo yo a mano, si fuera introducido
      por el usuario, haría un bucle do-while hasta que el nombre introducido
      fuera correcto*/
    try{jdr1.setNombre("Miguel2");}
    catch(Exception e){e.printStackTrace();}
    
    impln("y su lugar es ocupado por el jugador ", jdr1.getNombre());
    
    /*Elimina dos cartas y se le dan dos nuevas. MUCHO OJO CON ESTO, PORQUE AL
      ELIMINAR UNA CARTA QUE NO SEA LA ÚLTIMA, HACE CAMBIAR LOS ÍNDICES DE TODAS
      LAS QUE VIENEN DETRÁS. La solución de buscar la carta por Nombre y Palo, que
      uso más abajo, resolvería este problema.*/
    impln("A este jugador no le gustan las cartas que ocupan la primera y tercera "
        + "posiciones, así que se desprende de las cartas: \n\"",
        jdr1.retirarCarta(0).toString(), "\" y \"", jdr1.retirarCarta(1).toString(), "\"\n");
    crtRepartida = new Carta("Oros", "4", 4);
    jdr1.darCarta(crtRepartida);
    imp("Y en su lugar recibe las cartas \"", crtRepartida.toString(), "\" y \"");
    Carta crtRepartida2 = new Carta("Copas", "3", 3);
    jdr1.darCarta(crtRepartida2);
    impln(crtRepartida2.toString(), "\"");

    impln("El juego de ", jdr1.getNombre(), " es actualmente: \n", jdr1.juego(), "\n");
    
    /*Problema con una carta, que al ser vieja no se veía bien*/
    imp("Ha habido un problema, las cartas son viejas y en una de ellas se ha"
      + " borrado parte de la figura\n"
      + "La carta repartida como \"", crtRepartida.toString(), "\"");
      
    /*Sé que la carta añadida es la penúltima, pero como no puedo acceder directamente
      al ArrayList de cartas ni tengo un contador de las mismas, puedo no saber
      directament el índice que ocupa cierta carta para poder removerla, así que
      lo que voy a hacer es hallarla en el String juego, haciendo un split por ","
      y hallando el palo y valor dentro de el*/
    String[] arrCartas = jdr1.juego().split(",");
    int intIndiceEliminar = -1;
    /*Tenemos en cuenta que la carta a Eliminar es crtRepartida*/
    for(String s : arrCartas) {
      intIndiceEliminar++;
      if (s.matches(crtRepartida.toString())) break;
    }
    /*Saldrá del bucle cuando encuentre coincidencia, entonces usamos
      retirarCarta() con el índice encontrado*/
    Carta crtCambiar = jdr1.retirarCarta(intIndiceEliminar);
    /*Cambiamos los valores a la carta y la añadimos correctamente*/
    crtCambiar.setNombre("5");
    crtCambiar.setValor(5);
    jdr1.darCarta(crtCambiar);
    impln(" es en realidad la carta \"", crtCambiar.toString(), "\"\n");
    
    impln("Una vez aclarada la equivocación, se actualiza el juego de ", jdr1.getNombre(),
          ", que es:\n", jdr1.juego(), "\n");
    impln("La partida sigue su curso sin problemas ...\n");
  }
  
  static void Actividad2(Jugador[] jugadores) {
    Cabecera(2);
    Jugador jdr1 = jugadores[0];
    Jugador jdr2 = jugadores[1];
    
    Espanyola barEspanyola = new Espanyola();
    impln("Para comenzar el juego, se muestra que la baraja está completa sin cartas repetidas:");
    
    //String strPalo = "";
    /*Enseñar la cartas que estén todas para no hacer trampas*/
    //for (Carta c : barEspanyola.cartas) {
    //  if (!strPalo.equals(c.getPalo())) {
    //    imp("\n", c.toString());
    //    strPalo = c.getPalo();
    //  } else {
    //  imp(", ", c.toString());
    //  }
    //}
    barEspanyola.mostrarCartasBaraja();
  
    impln("Se barajan las cartas y alguien ajeno comprueba que lo están:");
    barEspanyola.barajar();
    barEspanyola.mostrarCartasBaraja();
    
    impln("Se reparte una carta a cada jugador para ver quien saca la más alta y designar el que va primero:");
    /*Hemos de realizar esta operación hasta que uno de los dos saque una carta
      más alta que el otro.*/
    int intValorJ1, intValorJ2, intRepartidas = 0;
    do {
      jdr1.darCarta(barEspanyola.repartir());
      jdr2.darCarta(barEspanyola.repartir());
      intRepartidas += 2;
  
      imp("El jugador ", jdr1.getNombre(), " ha recibido la carta ", jdr1.juego().toString().replaceAll("[\\[](.+)[\\]]","\"$1\""));
      /*La retiramos para leerla y por si tenemos que volver a pedir carta, que
        el juego vuelva a ser sólo una. Hago dos cosas de una vez y así no tengo
        que guardar el valor de la carta en una variable*/
      intValorJ1 = jdr1.retirarCarta(0).getValor();
      impln(abc(intValorJ1).replaceAll("^(.+)$"," ($1 puntos)"));
      
      imp("El jugador ", jdr2.getNombre(), " ha recibido la carta ", jdr2.juego().toString().replaceAll("[\\[](.+)[\\]]","\"$1\""));
      intValorJ2 = jdr2.retirarCarta(0).getValor();        
      impln(abc(intValorJ2).replaceAll("^(.+)$"," ($1 puntos)"));
      
      int intComp = Integer.compare(intValorJ2, intValorJ1);
      if (intComp == 0) {
        impln("Los dos jugadores obtienen el mismo valor (", abc(intValorJ1),
              "puntos) y se vuelve a repartir una carta a cada uno\n");
        /*El bucle continua*/
      } else {
        impln("El jugador ", jugadores[(intComp + 1) / 2].getNombre(), " ha obtenido la carta más alta\n");
        break;
      }
    }while(true);
    
    impln("Después de haber repartido ", abc(intRepartidas), " cartas, en el mazacote quedan ",
          abc(barEspanyola.cartas.size()), ". Las mostramos: ");
    barEspanyola.mostrarCartasBaraja();
    
    barEspanyola.reiniciar();
    impln("Reintroducimos las cartas y reiniciamos la baraja:");
    barEspanyola.mostrarCartasBaraja();
    impln("Resulta que íbamos a jugar a póker, así que hemos de cambiar de baraja a una Francesa.");
    
    Francesa barFrancesa = new Francesa(); 
    barFrancesa.mostrarCartasBaraja();
    impln("Las barajamos:");
    barFrancesa.barajar();
    barFrancesa.mostrarCartasBaraja();
    impln("El juego sigue su curso...");
    impln();
  }
  
  static void Actividad3_Mus() {
    Cabecera(3);
    /*Creo primero la instancia del juego Mus para usar directamente su ArrayList
      interior para guardar los jugadores*/
    Mus juegoMus = new Mus();
 
    impln("Introduzca el nombre de 4 jugadores:");
    int intI = 1;
    String strJugador;
    do {
      imp("Jugador ", abc(intI), ": ");
      /*Otras veces verifico aquí los datos introducidos, ahora lo voy a hacer
        en el método que añade el jugador. De hecho, addJugador lo he de llamar
        pasándole como parámetro ya un objeto jugador, por lo cual la verificación
        no la va a producir addJugador sino Jugador*/
      strJugador = scnEntrada.nextLine();
      /*Para mí sería mucho más fácil verificar aquí que la cadea entrada por el
        usuario es no nula y repetir el proceso hasta que sea correcta, pero ahora
        he probado a hacerlo diferente, lanzando una excepción tanto en el
        constructor como en el setter y recogiéndola aquí en un try-catch para
        que el programa no se detenga*/
      try {
        juegoMus.addJugador(new Jugador(strJugador));
        /*Si todo es correcto incrementamos el contador para el siguiente jugador*/
        intI++;
      } catch(Exception e) {
        //e.printStackTrace();
        imp(e.toString().replace("java.lang.Exception: ",""));
      }
    }while (juegoMus.getJugadores().size() < 4);
    
    impln("\nJuego de Mus inicializado con los 4 siguientes jugadores: ");
    impln(juegoMus.TXTJugadores());
    
    impln("La baraja se mezcla y las cartas quedan en las posiciones:");
    juegoMus.getJuegoBaraja().barajar();
    juegoMus.getJuegoBaraja().mostrarCartasBaraja();
    
    impln("Se reparten 4 cartas a cada jugador de forma cíclica. "
        + "Al final del reparto, cada jugador tiene las cartas:");
    
    for (int i=0; i<=4; i++) {
      for(Jugador j : juegoMus.getJugadores()) {
        j.darCarta(juegoMus.getJuegoBaraja().repartir());
      } 
    }
    for(Jugador j : juegoMus.getJugadores()) {
      impln("Cartas de ", j.getNombre(), ": ", j.juego());
    }
    
    impln("\nEl juego continúa su curso ...\n");
  }
  
  static void Actividad4_Poker() {
    Cabecera(4);
    
    int intI = 0, intNumJugadores = 0;
    String strJugador;
    /*Creo el ArrayList donde introduzco los jugadores*/
    ArrayList<Jugador> aLstJugadores = new ArrayList(0);    
    /*Creo la variable del juego Poker, el IDE me pide inicializarla a null*/
		Poker juegoPoker = null;
    
    boolean blnExcepcion = false;
    /*Para no hacer este bloque "do" tan largo, se podría hacer un método e ir
      llamándolo hasta que consigamos construir el juego Poker correcto*/
    do {
      intI = 1;
      aLstJugadores.clear();
      imp("¿Cuántos jugadores quiere en la partida (2 como mínimo y 5 como máximo)?: ");
      intNumJugadores = CompruebaEntero(scnEntrada.nextLine()); 
			impln("\nIntroduzca sus nombres");
      do {
				imp("Jugador ", abc(intI), ": ");
				/*Otras veces verifico aquí los datos introducidos, ahora lo voy a hacer
					en el método que añade el jugador. De hecho, addJugador lo he de llamar
					pasándole como parámetro ya un objeto jugador, por lo cual la verificación
					no la va a producir addJugador sino Jugador*/
				strJugador = scnEntrada.nextLine();
				/*Para mí sería mucho más fácil verificar aquí que la cadea entrada por el
					usuario es no nula y repetir el proceso hasta que sea correcta, pero ahora
					he probado a hacerlo diferente, lanzando una excepción tanto en el
					constructor como en el setter y recogiéndola aquí en un try-catch para
					que el programa no se detenga*/
				try {
					Jugador jdrNuevo = new Jugador(strJugador);
					/*Si todo es correcto incrementamos el contador para el siguiente jugador
						y añadimos el jugador al aLstJugadores*/
					intI++;
					aLstJugadores.add(jdrNuevo);
				} catch(Exception e) {
					//e.printStackTrace();
					imp(e.toString().replace("java.lang.Exception: ",""));
				}
			}while (aLstJugadores.size() < intNumJugadores);
			
			try{
				juegoPoker = new Poker(aLstJugadores);
        blnExcepcion = false;
			}catch(Exception e){
        blnExcepcion = true;
				imp(e.toString().replace("java.lang.Exception: ",""));
        impln("Vuelva a probar.");
			}
    }while (blnExcepcion != false);
          
    impln("\nJuego de Poker inicializado con los ", abc(intNumJugadores), " siguientes jugadores: ");
    impln(juegoPoker.TXTJugadores());
    
    impln("La baraja se mezcla y las cartas quedan en las posiciones");
    juegoPoker.getJuegoBaraja().barajar();
    juegoPoker.getJuegoBaraja().mostrarCartasBaraja();
    
    impln("Se reparten 5 cartas a cada jugador de forma cíclica. "
        + "Al final del reparto, cada jugador tiene las cartas:");
    
    for (int i=0; i<=5; i++) {
      for(Jugador j : juegoPoker.getJugadores()) {
        j.darCarta(juegoPoker.getJuegoBaraja().repartir());
      } 
    }
    for(Jugador j : juegoPoker.getJugadores()) {
      impln("Cartas de ", j.getNombre(), ": ", j.juego());
    }
    
    impln("\nEl juego continúa su curso ...\n");
    
  }
  
  static int CompruebaEntero(String strEntrada) {
    int intEntero = 0;
    do {
      try {
        intEntero = Integer.parseInt(strEntrada);
        break;
      } catch (Exception e) {
        imp("No ha escrito un número entero. Vuelva a probar: ");
        strEntrada = scnEntrada.nextLine().trim();
      }
    }while(true);
    return intEntero;
  }
}

