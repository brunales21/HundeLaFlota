import java.util.Random;

public class JugadorBot extends Jugador {
    private final Random random = new Random();

    public JugadorBot(Barco[] barcos) {
        super(barcos);
    }

    @Override
    public void colocarBarcos() {
        int posicionX;
        int posicionY;
        for (var barco : getBarcos()) {
            do {
                posicionX = random.nextInt(10);
                posicionY = random.nextInt(10);
            } while (!colocarBarco(barco, posicionX, posicionY));
        }
    }


    @Override
    public void lanzarBomba(Jugador jugador) {
        int posicionX = random.nextInt(10);
        int posicionY = random.nextInt(10);
        jugador.getTablero().getCasillas()[posicionX][posicionY].select();
    }
}
