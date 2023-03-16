public class Casilla {
    private boolean selected = false;
    private SuperString skin = new SuperString("  ", Color.BLACK_BOLD, Color.BLUE_BACKGROUND_BRIGHT);
    private ParteDeBarco pdb;

    public Casilla(ParteDeBarco pdb) {
        this.pdb = pdb;
    }

    public Casilla() {

    }

    public Casilla(String simbolo, String color) {
        this.skin.setSimbolo(simbolo);
        this.skin.setColor(color);
    }

    public boolean isDamaged() {
        return selected;
    }
    public boolean isPdb() {
        return pdb != null;
    }

    public void select() {
        this.selected = true;
        this.skin.setBackgroundColor(Color.BLUE_BACKGROUND_BRIGHT);

        if (isPdb()) {
            this.pdb.damage();
        }
    }

    public boolean isSelected() {
        return selected;
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
        if (!isPdb() || getPdb().isHidden()) {
            return skin.toString();
        }
        return this.pdb.toString();
    }
}
