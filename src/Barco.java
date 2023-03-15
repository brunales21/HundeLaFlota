import java.util.function.IntFunction;

public class Barco {
    private final ParteDeBarco[] partes;
    private final SuperString skin;
    private boolean isHundido = false;


    public Barco(SuperString skin, ParteDeBarco[] partes) {
        this.partes = partes;
        this.skin = skin;
        for (var parte: partes) {
            parte.setBarco(this);
        }
    }

    public void mostrarBarco() {
        Casilla[][] tBarco = new Casilla[8][20];
        for (int i = 0; i < tBarco.length; i++) {
            for (int j = 0; j < tBarco[i].length; j++) {
                tBarco[i][j] = new Casilla("  ", Color.RESET);
            }
        }
        for (int p = 0; p<partes.length; p++) {
            tBarco[4+this.partes[p].getX()][4+this.partes[p].getY()].setPdb(partes[p]);
        }
        for (int i = 0; i < tBarco.length; i++) {
            for (int j = 0; j < tBarco[i].length; j++) {
                System.out.print(tBarco[i][j]);
            }
            System.out.println();
        }
    }

    public Barco rotarBarco() {
        for (ParteDeBarco parte: partes) {
            if (parte.getX()==0&&parte.getY()==0) {
                parte.getSkin().setColorToBold();
                parte.getSkin().setSimbolo("X ");
            }
            int aux = parte.getX();
            parte.setX(parte.getY());
            parte.setY(-aux);
        }
        return this;
    }

    public ParteDeBarco[] getPartes() {
        return partes;
    }
    public void setBarcoToHundido() {
        this.isHundido = true;
        this.skin.setColor(Color.PURPLE);
    }

    public SuperString getSkin() {
        return skin;
    }

    public boolean isHundido() {
        return partes.length == getPdbHundidasCount();
    }



    public int getPdbHundidasCount() {
        int count = 0;
        for (var parte : partes) {
            if (parte.isDamaged()) {
                count++;
            }
        }
        return count;
    }


}
