public class SuperString {
    private String simbolo;
    private String color;

    public SuperString(String simbolo, String color) {
        this.simbolo = simbolo;
        this.color = color;
    }

    public void setColorToNotBold() {
        StringBuilder sb = new StringBuilder(color);
        sb.replace(2, 3, "0");

        this.color = sb.toString();
    }

    public void setColorToBold() {
        StringBuilder sb = new StringBuilder(color);
        sb.replace(2, 3, "1");

        this.color = sb.toString();
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
