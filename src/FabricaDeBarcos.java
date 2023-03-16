public class FabricaDeBarcos {

    public Barco[] getNewBarcos() {
        // Creamos la forma del cuadrado
        Barco cuadrado = new Barco(new SuperString("O ", Color.YELLOW), new ParteDeBarco[]{new ParteDeBarco(new SuperString("  ", Color.YELLOW, Color.YELLOW_BACKGROUND), 0, 0), new ParteDeBarco(new SuperString("  ", Color.YELLOW, Color.YELLOW_BACKGROUND), 0, 1), new ParteDeBarco(new SuperString("  ", Color.YELLOW, Color.YELLOW_BACKGROUND), 1, 0), new ParteDeBarco(new SuperString("  ", Color.YELLOW, Color.YELLOW_BACKGROUND), 1, 1)});
        Barco barcoL = new Barco(new SuperString("O ", Color.GREEN), new ParteDeBarco[]{new ParteDeBarco(new SuperString("  ", Color.GREEN, Color.GREEN_BACKGROUND), 0, 0), new ParteDeBarco(new SuperString("  ", Color.GREEN, Color.GREEN_BACKGROUND), 1, 0), new ParteDeBarco(new SuperString("  ", Color.GREEN, Color.GREEN_BACKGROUND), 2, 0), new ParteDeBarco(new SuperString("  ", Color.GREEN, Color.GREEN_BACKGROUND), 2, 1)});
        Barco z = new Barco(new SuperString("O ", Color.WHITE), new ParteDeBarco[]{new ParteDeBarco(new SuperString("  ", Color.WHITE, Color.BLACK_BACKGROUND_BRIGHT), 0, 0), new ParteDeBarco(new SuperString("  ", Color.WHITE, Color.BLACK_BACKGROUND_BRIGHT), 0, 1), new ParteDeBarco(new SuperString("  ", Color.WHITE, Color.BLACK_BACKGROUND_BRIGHT), 1, 1), new ParteDeBarco(new SuperString("  ", Color.WHITE, Color.BLACK_BACKGROUND_BRIGHT), 1, 2)});
        Barco barcoBarra = new Barco(new SuperString("O ", Color.CYAN), new ParteDeBarco[]{new ParteDeBarco(new SuperString("  ", Color.CYAN, Color.CYAN_BACKGROUND), 0, 0), new ParteDeBarco(new SuperString("  ", Color.CYAN, Color.CYAN_BACKGROUND), 0, 1), new ParteDeBarco(new SuperString("  ", Color.CYAN, Color.CYAN_BACKGROUND), 0, 2), new ParteDeBarco(new SuperString("  ", Color.CYAN, Color.CYAN_BACKGROUND), 0, 3)});
        Barco barcoT = new Barco(new SuperString("O ", Color.PURPLE), new ParteDeBarco[]{new ParteDeBarco(new SuperString("  ", Color.PURPLE, Color.PURPLE_BACKGROUND), 0, 0), new ParteDeBarco(new SuperString("  ", Color.PURPLE, Color.PURPLE_BACKGROUND), 1, -1), new ParteDeBarco(new SuperString("  ", Color.PURPLE, Color.PURPLE_BACKGROUND), 1, 0), new ParteDeBarco(new SuperString("  ", Color.PURPLE, Color.PURPLE_BACKGROUND), 1, 1)});
        return new Barco[]{cuadrado, barcoBarra, barcoT, barcoL, z};
    }
}

