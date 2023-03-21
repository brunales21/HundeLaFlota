import java.util.Scanner;

public class GameManager {
    private final int MAX_JUGADORES = 2;
    private Jugador jugadorAcutal;
    private Jugador[] jugadores = new Jugador[MAX_JUGADORES];
    private Scanner sc = new Scanner(System.in);

    private int cantidadJugadores;


    public void mostrarTitulo() {
        System.out.println(Color.GREEN_BRIGHT+"\n" +
                "   __ __             __      __       _____     __      \n" +
                "  / // /_ _____  ___/ /__   / /__ _  / _/ /__  / /____ _\n" +
                " / _  / // / _ \\/ _  / -_) / / _ `/ / _/ / _ \\/ __/ _ `/\n" +
                "/_//_/\\_,_/_//_/\\_,_/\\__/ /_/\\_,_/ /_//_/\\___/\\__/\\_,_/ \n" +
                "                                                        \n");

        saltosDeLinea(2);
    }
    public void getInstrucciones() {
        for (int i = 8; i > 0; i--) {
            mostrarTitulo();
            System.out.println(Color.BLUE_BOLD_BRIGHT+"A continuacion, coloca tus barcos");
            System.out.println("Puedes usar "+Color.WHITE_UNDERLINED+"ENTER"+Color.RESET+Color.BLUE_BOLD_BRIGHT+" para rotar los barcos");
            saltosDeLinea(2);
            System.out.println("La partida empieza en "+i);
            sleep(1);
            limpiarConsola();
        }


    }

    public void initGame() {
        mostrarTitulo();
        for (Jugador jugador: jugadores) {
            if (jugador.getClass().getName().equals("JugadorHumano")) {
                System.out.print("\t"+"Introduce el nombre de tu FLOTA: ");
                jugador.setNombre(sc.nextLine());
                limpiarConsola();
            }
        }
        getInstrucciones();
    }



    public void initTableros() {
        boolean flag = false;
        for (int i = 0; i < jugadores.length; i++) {
            for (int j = 0; j < Tablero.WIDTH; j++) {
                flag = !flag;
                for (int k = 0; k < Tablero.HEIGHT; k++) {
                    jugadores[i].getTablero().getCasillas()[j][k] = new Casilla();
                    if (jugadores[i].getClass().getName().equals(JugadorHumano.class.getName())) {
                        jugadores[i].getTablero().getCasillas()[j][k].getSkin().setBackgroundColor(Color.BLUE_BACKGROUND);
                        jugadores[i].getTablero().getCasillas()[j][k].getSkin().setSimbolo("~ ");
                    } else {
                        if (flag) {
                            jugadores[i].getTablero().getCasillas()[j][k].getSkin().setBackgroundColor(Color.WHITE_BACKGROUND);
                        } else {
                            jugadores[i].getTablero().getCasillas()[j][k].getSkin().setBackgroundColor(Color.WHITE_BACKGROUND_BRIGHT);
                        }
                    }
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
            System.out.println(Color.RESET+"Flota de "+jugadores[i].getNombre());
            jugadores[i].getTablero().showTablero();
            int barcos = jugadores[i].getCantidadBarcosFlotando();
            if (barcos > 2) {
                System.out.println(Color.GREEN_BRIGHT + "Barcos: " + jugadores[i].getCantidadBarcosFlotando());
            } else {
                System.out.println(Color.GREEN_BRIGHT + "Barcos: " + Color.RED+jugadores[i].getCantidadBarcosFlotando());

            }
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
                System.out.println(Color.GREEN+"Flota ganadora: "+Color.RESET+jugador.getNombre());
                System.out.println("Bombas lanzadas: "+jugador.getTiros());
            }
            if (jugador.lost()) {
                System.out.println(Color.RED+"Flota perdedora: "+Color.RESET+jugador.getNombre());
                System.out.println("Bombas lanzadas: "+jugador.getTiros());
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

    public static void sleep(int n) {
        try {
            Thread.sleep(n* 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static final String RESPUESTAS_POSITIVAS = "YSys";
    private static final String RESPUESTAS_NEGATIVAS = "Nn";


    //Esta funcion simplemente devuelve verdadero o falso en funcion del input (si recibe una s/y devuelve verdadero, si no falso)
    public boolean seguirJugando() {

        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.println(Color.WHITE_BOLD_BRIGHT+"DESEA JUGAR OTRA PARTIDA? (y/n)");
            input = scanner.nextLine();
        } while (RESPUESTAS_POSITIVAS.indexOf(input.charAt(0)) == -1 && RESPUESTAS_NEGATIVAS.indexOf(input.charAt(0)) == -1);

        if (RESPUESTAS_POSITIVAS.indexOf(input.charAt(0)) != -1) {
            return true;
        }
        return false;
    }
}

