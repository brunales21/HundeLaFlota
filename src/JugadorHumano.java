import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class JugadorHumano extends Jugador {
    private Scanner sc = new Scanner(System.in);

    public JugadorHumano(Barco[] barcos) {
        super(barcos);
    }

    @Override
    public void colocarBarcos() {
        String rspt = "";
        int letra;
        int num;
        int contador = 0;
        for (var barco : getBarcos()) {
            contador++;
            getTablero().showTablero();
            barco.mostrarBarco();
            do {
                rspt = sc.nextLine();
                while (rspt.equals("")) {
                    GameManager.limpiarConsola();
                    getTablero().showTablero();
                    barco.rotarBarco();
                    barco.mostrarBarco();
                    rspt = sc.nextLine();
                }
                System.out.println(Color.RESET+"COLOCA EL BARCO "+contador);
                String posicion = rspt.replace(" ", "").toUpperCase();
                letra = posicion.charAt(0)-'A';
                num = posicion.charAt(1)-'0';
            } while (!colocarBarco(barco, letra, num));

        }
    }

    @Override
    public void lanzarBomba(Jugador jugador) {
        String posicion = sc.nextLine().replaceAll(" ", "").toUpperCase();
        int letra = posicion.charAt(0)-'A';
        int num = posicion.charAt(1)-'0';
        Casilla casillaAfectada = jugador.getTablero().getCasillas()[letra][num];
        casillaAfectada.select();
        if (casillaAfectada.isPdb() && casillaAfectada.getPdb().getBarco().isHundido()) {
            casillaAfectada.getPdb().getBarco().setBarcoToHundido();
        }
    }
}
