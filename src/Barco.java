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
