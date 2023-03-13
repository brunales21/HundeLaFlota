public class FabricaDeBarcos {

    public Barco[] getNewBarcos() {
        // Creamos la forma del cuadrado
        Barco cuadrado = new Barco(new SuperString("##", Color.YELLOW_BOLD_BRIGHT), new ParteDeBarco[]{new ParteDeBarco(0, 0), new ParteDeBarco(0, 1), new ParteDeBarco(1, 0), new ParteDeBarco(1, 1)});
        Barco barcoL = new Barco(new SuperString("##", Color.GREEN_BOLD_BRIGHT), new ParteDeBarco[]{new ParteDeBarco(0, 0), new ParteDeBarco(0, 1), new ParteDeBarco(0, 2), new ParteDeBarco(1, 2)});
        Barco barcoLInvertida = new Barco(new SuperString("##", Color.WHITE_BOLD_BRIGHT), new ParteDeBarco[]{new ParteDeBarco(0, 0), new ParteDeBarco(1, 0), new ParteDeBarco(1, 1), new ParteDeBarco(1, 2)});
        Barco barcoBarra = new Barco(new SuperString("##", Color.CYAN_BOLD_BRIGHT), new ParteDeBarco[]{new ParteDeBarco(0, 0), new ParteDeBarco(0, 1), new ParteDeBarco(0, 2), new ParteDeBarco(0, 3)});
        Barco barcoT = new Barco(new SuperString("##", Color.PURPLE_BOLD_BRIGHT), new ParteDeBarco[]{new ParteDeBarco(0, 1), new ParteDeBarco(1, 0), new ParteDeBarco(1, 1), new ParteDeBarco(1, 2)});
        return new Barco[]{cuadrado, barcoBarra, barcoT, barcoL, barcoLInvertida};
    }
}

//, new Barco(l, new SuperString("##", Color.PURPLE_BOLD_BRIGHT)), new Barco(lInvertida, new SuperString("##", Color.GREEN_BOLD_BRIGHT)), new Barco(barra, new SuperString("##", Color.YELLOW_BOLD_BRIGHT)), new Barco(t, new SuperString("##", Color.WHITE_BOLD_BRIGHT))