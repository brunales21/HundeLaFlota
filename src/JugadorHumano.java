import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class JugadorHumano extends Jugador {
    private Scanner sc = new Scanner(System.in);

    public JugadorHumano(Barco[] barcos) {
        super(barcos);
        super.setNombre(sc.nextLine());
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
            //System.out.println(Color.RESET+"COLOCA EL BARCO "+contador);
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
                String posicion = rspt.replace(" ", "").toUpperCase();
                letra = posicion.charAt(0)-'A';
                num = posicion.charAt(1)-'0';

            } while (!colocarBarco(barco, false, letra, num));

        }
    }

    @Override
    public void lanzarBomba(Jugador jugador) {
        String posicion = "";
        Casilla casillaAfectada;
        int letra;
        int num;
        do {
            posicion = sc.nextLine().replaceAll(" ", "").toUpperCase();
            letra = posicion.charAt(0)-'A';
            num = posicion.charAt(1)-'0';
            casillaAfectada = jugador.getTablero().getCasillas()[letra][num];
            if (casillaAfectada.isSelected()) {
                System.out.println("Esta casilla ya esta usada.");
            }
        } while (casillaAfectada.isSelected() || letra>10 || letra<0 || num<0 || num>10);
        casillaAfectada.select();
        if (casillaAfectada.isPdb() && casillaAfectada.getPdb().getBarco().isHundido()) {
            casillaAfectada.getPdb().getBarco().setBarcoToHundido();
        }
    }

    public Scanner getSc() {
        return sc;
    }
}
