package HundirLaFlota;
import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;

public class Partida {
    private Tablero tableroJugador1;
    private Tablero tableroJugador2;
    private Scanner scanner;
    private int puntosJugador1;
    private int puntosJugador2;
    private LocalDate fechaPartida = LocalDate.now();

    public Partida(Tablero tableroJugador1, Tablero tableroJugador2, Scanner scanner) {
        this.tableroJugador1 = tableroJugador1;
        this.tableroJugador2 = tableroJugador2;
        this.scanner = scanner;
        this.puntosJugador1 = 0;
        this.puntosJugador2 = 0;
    }

    public void comenzarPartida() {
        System.out.println("=====================================================");
        System.out.println("=                Comienza la partida                =");
        System.out.println("=====================================================");
        // Bucle de turnos
        while (!finDelJuego()) {
            // Turno del Jugador 1
            System.out.println("Turno del Jugador 1");
            realizarAtaques(tableroJugador1, tableroJugador2);
            if (finDelJuego()) break;

            // Turno del Jugador 2
            System.out.println("Turno del Jugador 2");
            realizarAtaques(tableroJugador2, tableroJugador1);
        }
        calcularEstadisticas();
    }

    private void realizarAtaques(Tablero tableroAtacante, Tablero tableroDefensor) {
        Scanner scanner = new Scanner(System.in);
    
        while (true) {
            // Solicitar coordenadas al jugador para realizar el ataque
            System.out.println("Introduce la coordenada del eje Y para el ataque (número):");
            int y = scanner.nextInt() - 1;
            System.out.println("Introduce la coordenada del eje X para el ataque (letra):");
            char xChar = scanner.next().toUpperCase().charAt(0);
            int x = xChar - 'A';
    
            // Verificar si las coordenadas son válidas
            if (y >= 0 && y < tableroDefensor.getFilas() && x >= 0 && x < tableroDefensor.getColumnas()) {
                // Realizar el ataque en el tablero del oponente
                char resultadoAtaque = tableroDefensor.realizarAtaque(y, x);
    
                // Verificar si el ataque hundió un barco
                if (resultadoAtaque != '~') {
                    // Comprobar si el barco hundido
                    if (tableroDefensor.barcoHundido(resultadoAtaque)) {
                        System.out.println("¡Has hundido un barco!");
                    } else {
                        System.out.println("¡Has golpeado un barco!");
                    }
                } else {
                    System.out.println("¡Agua! El ataque no ha alcanzado ningún barco.");
                }
                // Mostrar el tablero actualizado para el atacante
                tableroDefensor.mostrarTableroParaAtacante();
    
                break;
            } else {
                System.out.println("Coordenadas inválidas. Inténtalo de nuevo.");
            }
        }
    }
    
    private boolean finDelJuego() {
        int maxGolpes = 24; // Número de X totales posibles en el tablero, sumando todos los barcos ysus casillas
    
        // Contar los golpes en los dos tableros tableros
        int golpesJugador1 = tableroJugador1.contarGolpes();
        int golpesJugador2 = tableroJugador2.contarGolpes();
    
        if (golpesJugador1 >= maxGolpes) {
            System.out.println("¡El Jugador 2 ha ganado! Jugador 1 eres un pringao, no vales ni pa un juego de consola.");
            return true;
        } else if (golpesJugador2 >= maxGolpes) {
            System.out.println("¡El Jugador 1 ha ganado! Jugador 2 eres un pedazo de manco, tu patria está decepcionada.");
            return true;
        }
    
        return false;
    }

    public void calcularEstadisticas() {
        int barcosTocadosJugador1 = tableroJugador2.contarGolpes(); // jugador 1 ataca a jugador2
        int barcosTocadosJugador2 = tableroJugador1.contarGolpes(); // viceversa
        int aguaTocadaJugador1 = (tableroJugador2.getFilas() * tableroJugador2.getColumnas()) - barcosTocadosJugador1 - tableroJugador2.contarAguas();
        int aguaTocadaJugador2 = (tableroJugador1.getFilas() * tableroJugador1.getColumnas()) - barcosTocadosJugador2 - tableroJugador1.contarAguas();

        try {
            File ficheroEstadisticas = new File("Estadisticas.txt");
            if (ficheroEstadisticas.createNewFile()) {
                FileWriter escribir = new FileWriter(ficheroEstadisticas);
                // esto se escribe en el fichero
                    escribir.write("===============================================");
                    escribir.write("======|          ESTADISTICAS           |======");
                    escribir.write("===============================================");
                    escribir.write("| - JUGADOR 1:");
                    escribir.write("|        + BARCOS TOCADOS -->" + barcosTocadosJugador1);
                    escribir.write("|        +   AGUA TOCADA     -->" + aguaTocadaJugador1);
                    escribir.write("|        + PUNTUACION FINAL  -->" + puntosJugador1);
                    escribir.write("===============================================");
                    escribir.write("| - JUGADOR 2:");
                    escribir.write("|        + BARCOS TOCADOS    -->" + barcosTocadosJugador2);
                    escribir.write("|        +   AGUA TOCADA     -->" + aguaTocadaJugador2);
                    escribir.write("|        + PUNTUACION FINAL  -->" + puntosJugador2);
                    escribir.write("===============================================");
                    escribir.write("| - Fecha de la partida: " + fechaPartida);
                    escribir.write("===============================================");
                // esto es para consola
                    System.out.println("===============================================");
                    System.out.println("======|          ESTADISTICAS           |======");
                    System.out.println("===============================================");
                    System.out.println("| - JUGADOR 1:");
                    System.out.println("|        + BARCOS TOCADOS -->" + barcosTocadosJugador1);
                    System.out.println("|        +   AGUA TOCADA     -->" + aguaTocadaJugador1);
                    System.out.println("|        + PUNTUACION FINAL  -->" + puntosJugador1);
                    System.out.println("===============================================");
                    System.out.println("| - JUGADOR 2:");
                    System.out.println("|        + BARCOS TOCADOS    -->" + barcosTocadosJugador2);
                    System.out.println("|        +   AGUA TOCADA     -->" + aguaTocadaJugador2);
                    System.out.println("|        + PUNTUACION FINAL  -->" + puntosJugador2);
                    System.out.println("===============================================");
                    System.out.println("| - Fecha de la partida: " + fechaPartida);
                    System.out.println("===============================================");
                escribir.close();
            } else {
                System.out.println("No se ha podido crear el fichero de estadísticas");
            }
        } catch (IOException e) {
            System.out.println("Sucedió algo inesperado :/, intentalo mas tarde");
        }
    }
}
