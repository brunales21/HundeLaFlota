public class Main {
    public static void main(String[] args) {
/*
        System.out.println("                                                    _  _\n" +
                "                                                   ' \\/ '\n" +
                "   _  _                        <|\n" +
                "    \\/              __'__     __'__      __'__\n" +
                "                   /    /    /    /     /    /\n" +
                "                  /\\____\\    \\____\\     \\____\\               _  _\n" +
                "                 / ___!___   ___!___    ___!___               \\/\n" +
                "               // (      (  (      (   (      (\n" +
                "             / /   \\______\\  \\______\\   \\______\\\n" +
                "           /  /   ____!_____ ___!______ ____!_____\n" +
                "         /   /   /         //         //         /\n" +
                "      /    /   |         ||         ||         |\n" +
                "     /_____/     \\         \\\\         \\\\         \\\n" +
                "           \\      \\_________\\\\_________\\\\_________\\\n" +
                "            \\         |          |         |\n" +
                "             \\________!__________!_________!________/\n" +
                "              \\|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_/|\n" +
                "               \\    _______________                /\n" +
                "^^^%%%^%^^^%^%%^\\_\"/_)/_)_/_)__)/_)/)/)_)_\"_'_\"_//)/)/)/)%%%^^^%^^%%%%^\n" +
                "^!!^^\"!%%!^^^!^^^!!^^^%%%%%!!!!^^^%%^^^!!%%%%^^^!!!!!!%%%^^^^%^^%%%^^^!\n");
*/


        GameManager gm = new GameManager();
        FabricaDeBarcos fb = new FabricaDeBarcos();

        Jugador jh = new JugadorHumano(fb.getNewBarcos());
        Jugador jb = new JugadorBot(fb.getNewBarcos());

        gm.addPlayer(jh);
        gm.addPlayer(jb);

        gm.initTableros();
        jb.colocarBarcos();
        //jh.colocarBarcos();
        gm.mostrarTableros();

        do {
            jh.lanzarBomba(jb);
            gm.mostrarTableros();
        } while (true);





    }
}