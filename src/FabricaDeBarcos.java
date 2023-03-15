public class FabricaDeBarcos {

    public Barco[] getNewBarcos() {
        // Creamos la forma del cuadrado
        Barco cuadrado = new Barco(new SuperString("O ", Color.YELLOW), new ParteDeBarco[]{new ParteDeBarco(new SuperString("# ", Color.YELLOW), 0, 0), new ParteDeBarco(new SuperString("# ", Color.YELLOW), 0, 1), new ParteDeBarco(new SuperString("# ", Color.YELLOW), 1, 0), new ParteDeBarco(new SuperString("# ", Color.YELLOW), 1, 1)});
        Barco barcoL = new Barco(new SuperString("O ", Color.GREEN), new ParteDeBarco[]{new ParteDeBarco(new SuperString("# ", Color.GREEN), 0, 0), new ParteDeBarco(new SuperString("# ", Color.GREEN), 1, 0), new ParteDeBarco(new SuperString("# ", Color.GREEN), 2, 0), new ParteDeBarco(new SuperString("# ", Color.GREEN), 2, 1)});
        Barco barcoLInvertida = new Barco(new SuperString("O ", Color.WHITE), new ParteDeBarco[]{new ParteDeBarco(new SuperString("# ", Color.WHITE), 0, 0), new ParteDeBarco(new SuperString("# ", Color.WHITE), 1, 0), new ParteDeBarco(new SuperString("# ", Color.WHITE), 2, 0), new ParteDeBarco(new SuperString("# ", Color.WHITE), 2, -1)});
        Barco barcoBarra = new Barco(new SuperString("O ", Color.CYAN), new ParteDeBarco[]{new ParteDeBarco(new SuperString("# ", Color.CYAN), 0, 0), new ParteDeBarco(new SuperString("# ", Color.CYAN), 0, 1), new ParteDeBarco(new SuperString("# ", Color.CYAN), 0, 2), new ParteDeBarco(new SuperString("# ", Color.CYAN), 0, 3)});
        Barco barcoT = new Barco(new SuperString("O ", Color.PURPLE), new ParteDeBarco[]{new ParteDeBarco(new SuperString("# ", Color.PURPLE), 0, 0), new ParteDeBarco(new SuperString("# ", Color.PURPLE), 1, -1), new ParteDeBarco(new SuperString("# ", Color.PURPLE), 1, 0), new ParteDeBarco(new SuperString("# ", Color.PURPLE), 1, 1)});
        return new Barco[]{cuadrado, barcoBarra, barcoT, barcoL, barcoLInvertida};
    }
}

