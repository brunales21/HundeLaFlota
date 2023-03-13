public class Casilla {
    private boolean selected = false;
    private SuperString skin = new SuperString("~~", Color.BLUE_BOLD_BRIGHT);;
    private ParteDeBarco pdb;

    public Casilla(ParteDeBarco pdb) {
        this.pdb = pdb;
    }

    public Casilla() {

    }

    public boolean isDamaged() {
        return selected;
    }
    public boolean isPdb() {
        return pdb != null;
    }

    public void select() {
        this.selected = true;
        this.skin.setColor(Color.RED);
        if (pdb != null) {
            this.pdb.damage();

        }
    }

    public SuperString getSkin() {
        return skin;
    }

    public void setSkin(SuperString skin) {
        this.skin = skin;
    }

    public ParteDeBarco getPdb() {
        return pdb;
    }

    public void setPdb(ParteDeBarco pdb) {
        this.pdb = pdb;
    }

    @Override
    public String toString() {
        return pdb != null ? pdb.getBarco().getSkin().toString() : skin.toString();
    }
}
