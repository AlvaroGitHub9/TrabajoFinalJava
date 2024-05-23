///////////////////////////////////////////
//                                       //
//  Autor: Álvaro Ortiz Martín-Palanco   //
//                                       //
///////////////////////////////////////////

package HundirLaFlota;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCasillas = 0;

        Tablero bienvenida = new Tablero(0, 0);
        bienvenida.darBienvenida();

        // tablero del jugador 1 
        Tablero tableroJugador1 = new Tablero(numCasillas, numCasillas);

     System.out.println("                          ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓██████▓▒░ ░▒▓██████▓▒░░▒▓███████▓▒░ ░▒▓██████▓▒░░▒▓███████▓▒░          ░▒▓█▓▒░ \r\n" + //
                        "                          ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓████▓▒░ \r\n" + //
                        "                          ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░         ░▒▓█▓▒░ \r\n" + //
                        "                          ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒▒▓███▓▒░▒▓████████▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓███████▓▒░          ░▒▓█▓▒░ \r\n" + //
                        "                   ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░         ░▒▓█▓▒░ \r\n" + //
                        "                   ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░         ░▒▓█▓▒░ \r\n" + //
                        "                    ░▒▓██████▓▒░ ░▒▓██████▓▒░ ░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓███████▓▒░ ░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░         ░▒▓█▓▒░ \r\n" + //
                        "                                                                                                             ");
            tableroJugador1.mostrarReglas(scanner);

            numCasillas = tableroJugador1.crearTablero(scanner); // con esto hacemos que la inicializacion del primer tablero elimine que la variable igualada a 0 se actualice y coja los valores por teclado
        tableroJugador1 = new Tablero(numCasillas, numCasillas); // aquí ya cogeria los valores de teclado y no la asignacion a 0 como antes
        tableroJugador1.mostrarTablero();

        tableroJugador1.colocarBarcos(scanner, 1);
        tableroJugador1.limpiarTerminal();

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        // tablero del jugador 2
        Tablero tableroJugador2 = new Tablero(numCasillas, numCasillas);

     System.out.println("                          ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓██████▓▒░ ░▒▓██████▓▒░░▒▓███████▓▒░ ░▒▓██████▓▒░░▒▓███████▓▒░       ░▒▓███████▓▒░  \r\n" + //
                        "                          ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░             ░▒▓█▓▒░ \r\n" + //
                        "                          ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░             ░▒▓█▓▒░ \r\n" + //
                        "                          ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒▒▓███▓▒░▒▓████████▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓███████▓▒░        ░▒▓██████▓▒░  \r\n" + //
                        "                   ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░        \r\n" + //
                        "                   ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░        \r\n" + //
                        "                    ░▒▓██████▓▒░ ░▒▓██████▓▒░ ░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓███████▓▒░ ░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░      ░▒▓████████▓▒░ \r\n" + //
                        "                                                                                                                 ");
            tableroJugador1.mostrarReglas(scanner);

            numCasillas = tableroJugador1.crearTablero(scanner);
        tableroJugador2 = new Tablero(numCasillas, numCasillas);
        tableroJugador2.mostrarTablero();

        tableroJugador2.colocarBarcos(scanner, 2);
        tableroJugador2.limpiarTerminal();

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        Partida partida = new Partida(tableroJugador1, tableroJugador2, scanner);

        partida.comenzarPartida(); // Este metodo ya contiene al final las estadisticas por lo quue seria el ultimo ya 
    }
}