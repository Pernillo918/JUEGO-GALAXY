package prup3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JUEGO extends JFrame {

    //OBJETOS PUBLICOS
    static JLabel nave;
    JLabel CTIEMPO, CPUNTOS;
    static Clip  clip2;

    //ETIQUETAS DE ENEMIGOS 
    static JLabel enemigo1, en2, en3, en4, en5, en6, en7, en8, en9, en10;
    static JLabel en11, en12, en13, en14, en15, en16, en17, en18, en19, en20;
    static JLabel en21, en22, en23, en24, en25, en26, en27, en28, en29, en30;
    static JLabel en31, en32, en33, en34, en35, en36, en37, en38, en39, en40;
    static JLabel en41, en42, en43, en44, en45, en46, en47, en48, en49, en50;

    int x, y;

    //ENEMIGOS
    static ENEMIGO n1, n2, n3, n4, n5, n6, n7, n8, n9, n10;
    static ENEMIGO2 n11, n12, n13, n14, n15, n16, n17, n18, n19, n20;
    static ENEMIGO3 n21, n22, n23, n24, n25, n26, n27, n28, n29, n30;
    static ENEMIGO4 n31, n32, n33, n34, n35, n36, n37, n38, n39, n40;
    static ENEMIGO5 n41, n42, n43, n44, n45, n46, n47, n48, n49, n50;

    /*   static ENEMIGO2 p1;
    static ENEMIGO3 p2;
    static ENEMIGO4 p3;
    static ENEMIGO5 p4;
    static ENEMIGO6 p5;
    static ENEMIGO7 p6;
    static ENEMIGO8 p7;
     */
    //HILOS
    static CONTADOR tiempo;
    static OBPUNTOS puntaje;

    public JUEGO() {

        this.setTitle("JUEGO");
        this.setBounds(0, 0, 760, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        //NAVCITA 
        nave = new JLabel();
        nave.setBounds(20, 240, 30, 30);
        nave.setVisible(true);
        ImageIcon img34 = new ImageIcon("nave.png");
        Image nuevo = img34.getImage().getScaledInstance(nave.getWidth(), nave.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon render = new ImageIcon(nuevo);
        nave.setIcon(render);
        this.add(nave);

     

        //MOVIMIENTO DE LA NAVE
        this.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        //HILO DE LOS PUNTOS
        CPUNTOS = new JLabel("PUNTOS");
        CPUNTOS.setBounds(150, 30, 70, 30);
        CPUNTOS.setVisible(true);
        CPUNTOS.setFont(new Font("Consolas", Font.PLAIN, 15));
        CPUNTOS.setForeground(Color.yellow);
        this.add(CPUNTOS);

        puntaje = new OBPUNTOS(this);
        puntaje.start();

        //HILO DE CRONOMETRO
        CTIEMPO = new JLabel("TIEMPO");
        CTIEMPO.setBounds(480, 30, 90, 50);
        CTIEMPO.setVisible(true);
        CTIEMPO.setFont(new Font("Consolas", Font.PLAIN, 15));
        CTIEMPO.setForeground(Color.yellow);
        this.add(CTIEMPO);

        tiempo = new CONTADOR(this);
        tiempo.start();

        generarEnemigos();

        //DECORACIONES DEL APARTADO DE PUNTOS
        JLabel moneda = new JLabel();
        moneda.setBounds(90, 10, 60, 60);
        moneda.setVisible(true);
        ImageIcon ico4 = new ImageIcon(getClass().getResource("/IMAGENES/MONEDA.png"));
        moneda.setIcon(ico4);
        this.add(moneda);

        JLabel puntos = new JLabel("PUNTOS");
        puntos.setBounds(150, 10, 70, 30);
        puntos.setVisible(true);
        puntos.setFont(new Font("Consolas", Font.PLAIN, 15));
        puntos.setForeground(Color.BLACK);
        this.add(puntos);

        JLabel vel = new JLabel("VELOCIDAD");
        vel.setBounds(270, 10, 100, 30);
        vel.setVisible(true);
        vel.setFont(new Font("Consolas", Font.PLAIN, 15));
        vel.setForeground(Color.BLACK);
        this.add(vel);

        JLabel medidor = new JLabel("X 1.0");
        medidor.setBounds(270, 30, 100, 30);
        medidor.setVisible(true);
        medidor.setFont(new Font("Consolas", Font.PLAIN, 15));
        medidor.setForeground(Color.BLACK);
        this.add(medidor);

        JLabel reloj = new JLabel();
        reloj.setBounds(410, 2, 70, 70);
        reloj.setVisible(true);
        ImageIcon ico5 = new ImageIcon(getClass().getResource("/IMAGENES/reloj.png"));
        reloj.setIcon(ico5);
        this.add(reloj);

        JLabel tiempo = new JLabel("TIEMPO");
        tiempo.setBounds(480, 10, 100, 30);
        tiempo.setVisible(true);
        tiempo.setFont(new Font("Consolas", Font.PLAIN, 15));
        tiempo.setForeground(Color.BLACK);
        this.add(tiempo);

        //PARA EL FONDO DEL AREA DE JUEGO 
        JLabel fondo = new JLabel();
        fondo.setVisible(true);
        fondo.setBounds(0, 80, 640, 490);
        ImageIcon ico = new ImageIcon(getClass().getResource("/IMAGENES/fondo.jpg"));
        ImageIcon img = new ImageIcon(
                ico.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
        fondo.setIcon(img);
        // this.add(fondo);

        //FONDO DEL APARTADO DE MARCADOR
        JLabel fondo2 = new JLabel();
        fondo2.setVisible(true);
        fondo2.setBounds(0, 0, 750, 80);
        ImageIcon ico3 = new ImageIcon(getClass().getResource("/IMAGENES/f2.jpg"));
        fondo2.setIcon(ico3);
        this.add(fondo2);

        /////////////////////////////////////////////////////////
        this.revalidate();
        this.repaint();
        this.setFocusable(true);

    }

    private void formKeyPressed(java.awt.event.KeyEvent evt) {

        x = nave.getX();
        y = nave.getY();
        //System.out.println(nave.getLocation());

        switch (evt.getExtendedKeyCode()) {

            case KeyEvent.VK_UP:

                if (nave.getY() >= 90) {
                    nave.setLocation(x, y - 5);
                }

                break;
            case KeyEvent.VK_DOWN:
                if (nave.getY() <= 575) {
                    nave.setLocation(x, y + 5);
                }
                break;
            case KeyEvent.VK_ESCAPE:
               
                PAUSA pausa = new PAUSA();
                pausa.setVisible(true);
                tiempo.suspend();
                n1.suspend();
                n2.suspend();
                n3.suspend();
                n4.suspend();
                n5.suspend();
                n6.suspend();
                n7.suspend();
                n8.suspend();
                //seugnda fila
                n11.suspend();
                n12.suspend();
                n13.suspend();
                n14.suspend();
                n15.suspend();
                n16.suspend();
                n17.suspend();
                n18.suspend();
                //tercera fila
                n21.suspend();
                n22.suspend();
                n23.suspend();
                n24.suspend();
                n25.suspend();
                n26.suspend();
                n27.suspend();
                n28.suspend();
                //cuarta fila 
                n31.suspend();
                n32.suspend();
                n33.suspend();
                n34.suspend();
                n35.suspend();
                n36.suspend();
                n37.suspend();
                n38.suspend();
                //quinta fila
                n41.suspend();
                n42.suspend();
                n43.suspend();
                n44.suspend();
                n45.suspend();
                n46.suspend();
                n47.suspend();
                n48.suspend();

                break;
            case KeyEvent.VK_SPACE:
                DISPARO disparo = new DISPARO(this, nave.getBounds());
                disparo.start();
                //sonido
                String sonido = "efecto.wav";
                ReproducirSonido2(sonido);

        }

    }

    public void generarEnemigos() {

        //ENEMIGOS FILAS 1
        enemigo1 = new JLabel();
        enemigo1.setBounds(410, 80, 30, 30);
        enemigo1.setVisible(false);
        this.add(enemigo1);
        n1 = new ENEMIGO(this, enemigo1);
        n1.start();

        en2 = new JLabel();
        en2.setBounds(410, 150, 30, 30);
        en2.setVisible(false);
        this.add(en2);
        n2 = new ENEMIGO(this, en2);
        n2.start();

        en3 = new JLabel();
        en3.setBounds(410, 220, 30, 30);
        en3.setVisible(false);
        this.add(en3);
        n3 = new ENEMIGO(this, en3);
        n3.start();

        en4 = new JLabel();
        en4.setBounds(410, 290, 30, 30);
        en4.setVisible(false);
        this.add(en4);
        n4 = new ENEMIGO(this, en4);
        n4.start();

        en5 = new JLabel();
        en5.setBounds(410, 360, 30, 30);
        en5.setVisible(false);
        this.add(en5);
        n5 = new ENEMIGO(this, en5);
        n5.start();

        en6 = new JLabel();
        en6.setBounds(410, 430, 30, 30);
        en6.setVisible(false);
        this.add(en6);
        n6 = new ENEMIGO(this, en6);
        n6.start();

        en7 = new JLabel();
        en7.setBounds(410, 500, 30, 30);
        en7.setVisible(false);
        this.add(en7);
        n7 = new ENEMIGO(this, en7);
        n7.start();

        en8 = new JLabel();
        en8.setBounds(410, 570, 30, 30);
        en8.setVisible(false);
        this.add(en8);
        n8 = new ENEMIGO(this, en8);
        n8.start();

        //FILA 2
        en9 = new JLabel();
        en9.setBounds(485, 80, 30, 30);
        en9.setVisible(false);
        this.add(en9);
        n11 = new ENEMIGO2(this, en9);
        n11.start();

        en10 = new JLabel();
        en10.setBounds(485, 150, 30, 30);
        en10.setVisible(false);
        this.add(en10);
        n12 = new ENEMIGO2(this, en10);
        n12.start();

        en11 = new JLabel();
        en11.setBounds(485, 220, 30, 30);
        en11.setVisible(false);
        this.add(en11);
        n13 = new ENEMIGO2(this, en11);
        n13.start();

        en12 = new JLabel();
        en12.setBounds(485, 290, 30, 30);
        en12.setVisible(false);
        this.add(en12);
        n14 = new ENEMIGO2(this, en12);
        n14.start();

        en13 = new JLabel();
        en13.setBounds(485, 360, 30, 30);
        en13.setVisible(false);
        this.add(en13);
        n15 = new ENEMIGO2(this, en13);
        n15.start();

        en14 = new JLabel();
        en14.setBounds(485, 430, 30, 30);
        en14.setVisible(false);
        this.add(en14);
        n16 = new ENEMIGO2(this, en14);
        n16.start();

        en15 = new JLabel();
        en15.setBounds(485, 500, 30, 30);
        en15.setVisible(false);
        this.add(en15);
        n17 = new ENEMIGO2(this, en15);
        n17.start();

        en16 = new JLabel();
        en16.setBounds(485, 570, 30, 30);
        en16.setVisible(false);
        this.add(en16);
        n18 = new ENEMIGO2(this, en16);
        n18.start();

        //FILA3 
        en17 = new JLabel();
        en17.setBounds(560, 80, 30, 30);
        en17.setVisible(false);
        this.add(en17);
        n21 = new ENEMIGO3(this, en17);
        n21.start();

        en18 = new JLabel();
        en18.setBounds(560, 150, 30, 30);
        en18.setVisible(false);
        this.add(en18);
        n22 = new ENEMIGO3(this, en18);
        n22.start();

        en19 = new JLabel();
        en19.setBounds(560, 220, 30, 30);
        en19.setVisible(false);
        this.add(en19);
        n23 = new ENEMIGO3(this, en19);
        n23.start();

        en20 = new JLabel();
        en20.setBounds(560, 290, 30, 30);
        en20.setVisible(false);
        this.add(en20);
        n24 = new ENEMIGO3(this, en20);
        n24.start();

        en21 = new JLabel();
        en21.setBounds(560, 360, 30, 30);
        en21.setVisible(false);
        this.add(en21);
        n25 = new ENEMIGO3(this, en21);
        n25.start();

        en22 = new JLabel();
        en22.setBounds(560, 430, 30, 30);
        en22.setVisible(false);
        this.add(en22);
        n26 = new ENEMIGO3(this, en22);
        n26.start();

        en23 = new JLabel();
        en23.setBounds(560, 500, 30, 30);
        en23.setVisible(false);
        this.add(en23);
        n27 = new ENEMIGO3(this, en23);
        n27.start();

        en24 = new JLabel();
        en24.setBounds(560, 570, 30, 30);
        en24.setVisible(false);
        this.add(en24);
        n28 = new ENEMIGO3(this, en24);
        n28.start();

        //FILA4 
        en25 = new JLabel();
        en25.setBounds(635, 80, 30, 30);
        en25.setVisible(false);
        this.add(en25);
        n31 = new ENEMIGO4(this, en25);
        n31.start();

        en26 = new JLabel();
        en26.setBounds(635, 150, 30, 30);
        en26.setVisible(false);
        this.add(en26);
        n32 = new ENEMIGO4(this, en26);
        n32.start();

        en27 = new JLabel();
        en27.setBounds(635, 220, 30, 30);
        en27.setVisible(false);
        this.add(en27);
        n33 = new ENEMIGO4(this, en27);
        n33.start();

        en28 = new JLabel();
        en28.setBounds(635, 290, 30, 30);
        en28.setVisible(false);
        this.add(en28);
        n34 = new ENEMIGO4(this, en28);
        n34.start();

        en29 = new JLabel();
        en29.setBounds(635, 360, 30, 30);
        en29.setVisible(false);
        this.add(en29);
        n35 = new ENEMIGO4(this, en29);
        n35.start();

        en30 = new JLabel();
        en30.setBounds(635, 430, 30, 30);
        en30.setVisible(false);
        this.add(en22);
        n36 = new ENEMIGO4(this, en30);
        n36.start();

        en31 = new JLabel();
        en31.setBounds(635, 500, 30, 30);
        en31.setVisible(false);
        this.add(en31);
        n37 = new ENEMIGO4(this, en31);
        n37.start();

        en32 = new JLabel();
        en32.setBounds(635, 570, 30, 30);
        en32.setVisible(false);
        this.add(en32);
        n38 = new ENEMIGO4(this, en32);
        n38.start();

        //FILA5 
        en33 = new JLabel();
        en33.setBounds(710, 80, 30, 30);
        en33.setVisible(false);
        this.add(en33);
        n41 = new ENEMIGO5(this, en33);
        n41.start();

        en34 = new JLabel();
        en34.setBounds(710, 150, 30, 30);
        en34.setVisible(false);
        this.add(en34);
        n42 = new ENEMIGO5(this, en34);
        n42.start();

        en35 = new JLabel();
        en35.setBounds(710, 220, 30, 30);
        en35.setVisible(false);
        this.add(en35);
        n43 = new ENEMIGO5(this, en35);
        n43.start();

        en36 = new JLabel();
        en36.setBounds(710, 290, 30, 30);
        en36.setVisible(false);
        this.add(en36);
        n44 = new ENEMIGO5(this, en36);
        n44.start();

        en37 = new JLabel();
        en37.setBounds(710, 360, 30, 30);
        en37.setVisible(false);
        this.add(en37);
        n45 = new ENEMIGO5(this, en37);
        n45.start();

        en38 = new JLabel();
        en38.setBounds(710, 430, 30, 30);
        en38.setVisible(false);
        this.add(en38);
        n46 = new ENEMIGO5(this, en38);
        n46.start();

        en39 = new JLabel();
        en39.setBounds(710, 500, 30, 30);
        en39.setVisible(false);
        this.add(en39);
        n47 = new ENEMIGO5(this, en39);
        n47.start();

        en40 = new JLabel();
        en40.setBounds(710, 570, 30, 30);
        en40.setVisible(false);
        this.add(en40);
        n48 = new ENEMIGO5(this, en40);
        n48.start();

    }

   

    public static void ReproducirSonido2(String nombreSonido) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
            clip2 = AudioSystem.getClip();
            clip2.open(audioInputStream);
            clip2.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido.");
        }
    }

}
