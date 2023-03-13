public class SuperString {
    private String simbolo;
    private String color;

    public SuperString(String simbolo, String color) {
        this.simbolo = simbolo;
        this.color = color;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color+simbolo;
    }
}
