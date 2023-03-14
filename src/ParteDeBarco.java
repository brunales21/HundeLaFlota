public class ParteDeBarco {
    private Barco barco;
    private SuperString skin;
    private boolean damaged = false;
    private int x;
    private int y;


    public ParteDeBarco(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
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

    public SuperString getSkin() {
        return skin;
    }

    public void setSkin(SuperString skin) {
        this.skin = skin;
    }
}