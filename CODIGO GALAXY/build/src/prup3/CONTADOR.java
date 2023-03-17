package prup3;

public class CONTADOR extends Thread {

    int segundos;
    int minutos;

    JUEGO vtn;

    public CONTADOR(JUEGO vtn) {

        segundos = 30;
        minutos = 1;
        this.vtn = vtn;
    }

    public void run() {
        while (true) {
            try {

                vtn.CTIEMPO.setText(minutos + ":" + segundos);
                // SLEEP DE UN MINUTO
                sleep(1000);
                segundos--;
                if (segundos == 0) {
                    segundos = 60;
                    minutos--;
                }

                if (minutos == 0 && segundos == 0) {
                    GUARDADO next = new GUARDADO();
                    next.setVisible(true);
                    INICIO.partida.dispose();
                    stop();

                }

            } catch (Exception e) {
            }

        }
    }

}
