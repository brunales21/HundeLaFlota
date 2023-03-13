public class ParteDeBarco {
    private Barco barco;
    private boolean damaged = false;
    private final int x;
    private final int y;


    public ParteDeBarco(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void damage() {
        damaged = true;

    }

    public boolean isDamaged() {
        return damaged;
    }

    public Barco getBarco() {
        return barco;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }
}
