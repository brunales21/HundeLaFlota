public abstract class Jugador {
    private Tablero tablero = new Tablero();
    private Barco[] barcos;

    public Jugador(Barco[] barcos) {
        this.barcos = barcos;
    }
    protected boolean colocarBarco(Barco barco, int x, int y) {
        if (!fitsInTablero(barco, x, y)) {
            return false;
        }
        for (var parte : barco.getPartes()) {
            getTablero().getCasillas()[parte.getX()+x][parte.getY()+y].setPdb(parte);
        }
        return true;
    }

    public boolean isInTablero(int x, int y) {
        return x >= 0 && y < Tablero.height && x < Tablero.width && y >= 0;
    }

    public boolean fitsInTablero(Barco barco, int x, int y) {
        for (var partes: barco.getPartes()) {
            if (!isInTablero(x + partes.getX(), y + partes.getY()) || tablero.getCasillas()[partes.getX() + x][partes.getY() + y].isPdb()) {
                return false;
            }
        }
        return true;
    }

    public abstract void colocarBarcos();

    public abstract void lanzarBomba(Jugador jugador);

    public Tablero getTablero() {
        return tablero;
    }

    public Barco[] getBarcos() {
        return barcos;
    }

    public void setBarcos(Barco[] barcos) {
        this.barcos = barcos;
    }
    public int getCantidadDeBarcos() {
        int contador = 0;
        for (Barco barco: getBarcos()) {
            if (!barco.isHundido()) {
                contador++;
            }
        }
        return contador;
    }
}
