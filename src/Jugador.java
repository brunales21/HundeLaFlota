public abstract class Jugador {
    private String nombre;
    private Tablero tablero = new Tablero();
    private Barco[] barcos;

    public Jugador(Barco[] barcos) {
        this.barcos = barcos;
    }
    protected boolean colocarBarco(Barco barco, boolean isHidden, int x, int y) {
        if (!fitsInTablero(barco, x, y)) {
            return false;
        }
        for (var parte : barco.getPartes()) {
            if (parte.getX()==0 && parte.getY()==0) {
                //parte.getSkin().setBackgroundColorToNormal();
                parte.getSkin().setBackgroundColorToBright();
            }
            getTablero().getCasillas()[parte.getX()+x][parte.getY()+y].setPdb(parte);
            getTablero().getCasillas()[parte.getX()+x][parte.getY()+y].getPdb().setVisibility(isHidden);

        }
        return true;
    }

    public boolean lost() {
        for (Barco barco: barcos) {
            if (!barco.isHundido()) {
                return false;
            }
        }
        return true;
    }
    public boolean isInTablero(int x, int y) {
        if (x >= 0 && y < Tablero.HEIGHT && x < Tablero.WIDTH && y >= 0) {
            return true;
        }
        System.out.println("Posicion no valida. Fuera del tablero");
        return false;
    }

    public boolean fitsInTablero(Barco barco, int x, int y) {
        for (var partes: barco.getPartes()) {
            if (!isInTablero(x + partes.getX(), y + partes.getY())) {
                return false;
            }
            if (tablero.getCasillas()[partes.getX() + x][partes.getY() + y].isPdb()) {
                System.out.println("Posicion no valida. Se superpone con otro barco");
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
    public int getCantidadBarcosFlotando() {
        int contador = 0;
        for (Barco barco: getBarcos()) {
            if (!barco.isHundido()) {
                contador++;
            }
        }
        return contador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
