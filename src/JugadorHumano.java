import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class JugadorHumano extends Jugador {
    private Scanner sc = new Scanner(System.in);

    public JugadorHumano(Barco[] barcos) {
        super(barcos);
    }

    @Override
    public void colocarBarcos() {
        GameManager.limpiarConsola();
        String rspt = "";
        int letra;
        int num;
        int contador = 0;
        for (var barco : getBarcos()) {
            GameManager.limpiarConsola();
            contador++;
            getTablero().showTablero();
            System.out.println(Color.RESET+"COLOCA EL BARCO "+contador);
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
                String posicion = rspt.replace(" ", "").toUpperCase();
                letra = posicion.charAt(0)-'A';
                num = posicion.charAt(1)-'0';
            } while (!colocarBarco(barco, letra, num));

        }
    }

    @Override
    public void lanzarBomba(Jugador jugador) {
        String posicion = "";
        int letra;
        int num;
        do {
            posicion = sc.nextLine().replaceAll(" ", "").toUpperCase();
            letra = posicion.charAt(0)-'A';
            num = posicion.charAt(1)-'0';
        } while (letra>10 || letra<0 || num<0 || num>10);
        Casilla casillaAfectada = jugador.getTablero().getCasillas()[letra][num];
        casillaAfectada.select();
        System.out.println("casilla selected");
        if (casillaAfectada.isPdb() && casillaAfectada.getPdb().getBarco().isHundido()) {
            casillaAfectada.getPdb().getBarco().setBarcoToHundido();
        }
    }
}
