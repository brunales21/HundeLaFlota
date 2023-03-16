public class GameManager {
    private final int MAX_JUGADORES = 2;
    private Jugador jugadorAcutal;
    private Jugador[] jugadores = new Jugador[MAX_JUGADORES];
    private int cantidadJugadores;

    public void initTableros() {
        boolean flag = false;
        for (int i = 0; i < jugadores.length; i++) {
            for (int j = 0; j < Tablero.WIDTH; j++) {
                flag = !flag;
                for (int k = 0; k < Tablero.HEIGHT; k++) {
                    jugadores[i].getTablero().getCasillas()[j][k] = new Casilla();
                    if (jugadores[i].getClass().getName().equals(JugadorHumano.class.getName())) {
                        if (flag) {
                            jugadores[i].getTablero().getCasillas()[j][k].getSkin().setBackgroundColor(Color.BLUE_BACKGROUND);
                        } else {
                            jugadores[i].getTablero().getCasillas()[j][k].getSkin().setBackgroundColor(Color.BLUE_BACKGROUND);
                        }
                    } else {
                        if (flag) {
                            jugadores[i].getTablero().getCasillas()[j][k].getSkin().setBackgroundColor(Color.WHITE_BACKGROUND);
                        } else {
                            jugadores[i].getTablero().getCasillas()[j][k].getSkin().setBackgroundColor(Color.WHITE_BACKGROUND_BRIGHT);
                        }
                    }

                    System.out.print(jugadores[i].getTablero().getCasillas()[j][k]);
                    flag = !flag;
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
            System.out.println(Color.RESET + "Barcos disponibles: " + jugadores[i].getCantidadBarcosFlotando());
            if (i == jugadores.length - 1) {
                return;
            }
            System.out.println(Color.WHITE_BOLD_BRIGHT + "-----------------------");
        }
    }

    public void mostrarResultados() {
        mostrarTableros();
        saltosDeLinea(1);
        for (Jugador jugador: jugadores) {
            if (!jugador.lost()) {
                System.out.println(Color.GREEN+"Ganador: "+Color.RESET+jugador.getNombre());
            }
            if (jugador.lost()) {
                System.out.println(Color.RED+"Perdedor: "+Color.RESET+jugador.getNombre());
            }
        }
    }

    public void saltosDeLinea(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println();
        }
    }

    public static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

