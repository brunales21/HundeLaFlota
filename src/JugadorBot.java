import java.util.Random;

public class JugadorBot extends Jugador {
    private final Random random = new Random();

    public JugadorBot(Barco[] barcos) {
        super(barcos);
        super.setNombre(Color.RED+"ROBOTS NAVY");
    }

    @Override
    public void colocarBarcos() {
        int posicionX;
        int posicionY;
        for (var barco : getBarcos()) {
            for (int i = 0; i <= random.nextInt(4); i++) {
                barco.rotarBarco();
            }
            do {
                posicionX = random.nextInt(10);
                posicionY = random.nextInt(10);
            } while (!colocarBarco(barco, true, posicionX, posicionY));
        }
        System.out.println("barcos bot colocados");
    }


    @Override
    public void lanzarBomba(Jugador jugador) {
        tiros++;
        int posicionX, posicionY;
        Casilla casillaAfectada;
        do {
            posicionX = random.nextInt(10);
            posicionY = random.nextInt(10);
            casillaAfectada = jugador.getTablero().getCasillas()[posicionX][posicionY];
        } while (casillaAfectada.isSelected());
        casillaAfectada.select();
        if (casillaAfectada.isPdb() && casillaAfectada.getPdb().getBarco().isHundido()) {
            casillaAfectada.getPdb().getBarco().setBarcoToHundido();
        }
    }


}
