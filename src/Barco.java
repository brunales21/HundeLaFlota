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
/*
    public int getWidth() {
        int maxW = 0;
        for (ParteDeBarco parte: partes) {
            if (parte.getX()>maxW) {
                maxW = parte.getX();
            }
        }
        return maxW;
    }

    public int getHeight() {
        int maxH = 0;
        for (ParteDeBarco parte: partes) {
            if (parte.getY()>maxH) {
                maxH = parte.getY();
            }
        }
        return maxH;
    }

 */

    public void mostrarBarco() {
        Casilla[][] tBarco = new Casilla[8][20];
        for (int i = 0; i < tBarco.length; i++) {
            for (int j = 0; j < tBarco[i].length; j++) {
                tBarco[i][j] = new Casilla("o ", Color.RESET);
            }
        }
        for (int p = 0; p<partes.length; p++) {
            if (p == 0) {
                tBarco[3+this.partes[p].getX()][7+this.partes[p].getY()].setPdb(partes[p]);
            }
            tBarco[3+this.partes[p].getX()][7+this.partes[p].getY()].setPdb(partes[p]);
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
        this.skin.setColor(Color.RED_BOLD_BRIGHT);
    }

    public SuperString getSkin() {
        return skin;
    }

    public boolean isHundido() {
        return partes.length == getPdbHundidasCount();
    }

    public boolean isHundido2() {
        for (ParteDeBarco parte: partes) {
            if (!parte.isDamaged()) {
                return false;
            }
        }
        return true;
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
