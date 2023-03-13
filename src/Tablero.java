public class Tablero {
    public final static int width = 10;
    public final static int height = 10;
    private Casilla[][] casillas = new Casilla[width][height];


    public void showTablero() {
        char[] letras = getLetras();
        int[] numeros = getNumeros();
        System.out.print(" ");
        for (int i = 0; i < 10; i++) {
            System.out.print(Color.RESET+" "+numeros[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(Color.RESET+letras[i]);
            for (int j = 0; j < casillas.length; j++) {
                System.out.print(" "+casillas[i][j]);
            }
            System.out.println();
        }
    }

    private static char[] getLetras() {
        char[] abecedario = new char[26];
        for (int i = 0; i < abecedario.length; i++) {
            abecedario[i] = (char)('A' + i);
        }
        return abecedario;
    }

    private static int[] getNumeros() {
        int[] numeros = new int[10];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i;
        }
        return numeros;
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;
    }
}
