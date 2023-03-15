public class GameManager {
    private final int MAX_JUGADORES = 2;
    private Jugador jugadorAcutal;
    private Jugador[] jugadores = new Jugador[MAX_JUGADORES];
    private int cantidadJugadores;

    public void initTableros() {
        for (int i = 0; i < jugadores.length; i++) {
            for (int j = 0; j < Tablero.WIDTH; j++) {
                for (int k = 0; k < Tablero.HEIGHT; k++) {
                    jugadores[i].getTablero().getCasillas()[j][k] = new Casilla();
                }
            }
        }
    }

    public void addPlayer(Jugador jugador) {
        if (cantidadJugadores < MAX_JUGADORES) {
            jugadores[cantidadJugadores] = jugador;
            cantidadJugadores++;
        }
    }

    public void mostrarTableros() {
        limpiarConsola();
        for (int i = 0; i < jugadores.length; i++) {
            jugadores[i].getTablero().showTablero();
            System.out.println(Color.RESET + "Barcos disponibles: " + jugadores[i].getCantidadDeBarcos());
            if (i == jugadores.length - 1) {
                return;
            }
            System.out.println(Color.WHITE_BOLD_BRIGHT + "-----------------------");
        }
    }


    public static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

