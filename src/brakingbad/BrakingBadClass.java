/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brakingbad;

import javax.swing.JFrame;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_P;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Emilio
 */
public class BrakingBadClass extends JFrame implements KeyListener, MouseListener, Runnable {

    // valores numericos
    private final int posInicialTiro = 400; // empieza en posicion 100 
    private final int xPanelOrigin = 40;
    private final int yPanelOrigin = 400;
    private int caidas;
    private int vidas;
    private int score;
    private int cantBloques;

// strings
    private String[] arr;
    private final String nombreArchivo = "guardar.txt";
    public static String estado;

// boleanos
    private boolean pausa;      // bool que checa si se pauso
    private boolean clicked;    // checador que checa si se movio el objeto con tecl
    private boolean chocado;
    private boolean instrucciones;
    private boolean sonido;
    private boolean inicio;

//floating
    private long tiempoActual;  // tiempo actual
    private long tiempoAire;
    private long tMensaje;

    // images
    private Image dbImage;	// Imagen a proyectar	
    private Graphics dbg;	// Objeto grafico

    private Image fotoD1;
    private Image fotoD2;
    private Image fotoD3;
    private Image fotoD4;
    private Image fotoD5;
    private Image introImagen;
    private Image bloque1;

    private Image fotoB1;
    private Image fotoB2;
    private Image fotoB3;
    private Image fotoB4;
    private Image fotoB5;
    private Image fotoB6;
    private Image fotoB7;
    private Image fotoB8;
    private Image fotoB9;
    private Image fotoB10;
    private Image fotoB11;
    private Image fotoB12;
    private Image fotoB13;
    private Image fotoB14;
    private Image fotoB15;
    private Image fotoB16;
    private Image fotoB17;
    private Image fotoB18;
    private Image fotoB19;
    private Image fotoB20;
    private Image fotoB21;
    private Image fotoB22;
    private Image fotoB23;
    private Image fotoB24;
    private Image fotoB25;
    private Image fotoB26;
    private Image fotoB27;
    private Image fotoB28;
    private Image fotoB29;
    private Image fotoB30;
    private Image fotoB31;
    private Image fotoB32;
    private Image fotoB33;
    private Image fotoB34;
    private Image fotoB35;
    private Image fotoB36;

    private Image gameOver;
    private Image fotoCarro;
    private Image tableroInstrucciones;
    private Image pausaImagen;
    private Image background;
    private ImageIcon heart;

    private ImageIcon nuevoJuego;
    private ImageIcon cargar;
    private ImageIcon highscores;
    private ImageIcon creditos;

// animaciones
    private Animacion anim;
    private Animacion animCanasta;
    private Animacion animP;
    private Animacion animBloque;
    private Animacion animaciones[];

    private Animacion animB1;
    private Animacion animB2;
    private Animacion animB3;
    private Animacion animB4;
    private Animacion animB5;
    private Animacion animB6;
    private Animacion animB7;
    private Animacion animB8;
    private Animacion animB9;
    private Animacion animB10;
    private Animacion animB11;
    private Animacion animB12;
    private Animacion animB13;
    private Animacion animB14;
    private Animacion animB15;
    private Animacion animB16;
    private Animacion animB17;
    private Animacion animB18;
    private Animacion animB19;
    private Animacion animB20;
    private Animacion animB21;
    private Animacion animB22;
    private Animacion animB23;
    private Animacion animB24;
    private Animacion animB25;
    private Animacion animB26;
    private Animacion animB27;
    private Animacion animB28;
    private Animacion animB29;
    private Animacion animB30;
    private Animacion animB31;
    private Animacion animB32;
    private Animacion animB33;
    private Animacion animB34;
    private Animacion animB35;
    private Animacion animB36;

// sounds
    private SoundClip intro; // sonido cuando la pelota choca con canasta
    private SoundClip choqueBloque; // sonido si choca con el suelo
    private SoundClip choqueSuelo; // sonido si choca con el suelo

    // objetos
    private Pelota pelota;
    private Barra canasta;


    private LinkedList<Bloques> listaBloques;
    private boolean perdio;

    /**
     * Se crea un objeto de la misma clase
     */
    public BrakingBadClass() {
        init();
        start();
    }

    /**
     * Se inicializan las variables en el metodo <I>Init</>
     * Se inicializa el tamaño del applet en 1000x500
     *
     */
    void init() {

        setTitle("Breaking Bad: The Game");
        addKeyListener(this);
        addMouseListener(this);
        setSize(1200, 760);

        Base.setW(getWidth());
        Base.setH(getHeight());
        Pelota.nivel = 1;

        listaBloques = new LinkedList();

        vidas = 3;
        score = 0;

        chocado = false;
        instrucciones = false;
        sonido = true;
        inicio = false;

        intro = new SoundClip("Mono/break intro.mp3");
        choqueBloque = new SoundClip("Mono/exp.wav");

        fotoD1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/d1.png"));
        fotoD2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/d2.png"));
        fotoD3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/d3.png"));
        fotoD4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/d4.png"));
        fotoD5 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/d5.png"));

        // crea las imagenes de los bloques
        fotoB1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/001-H.png"));
        fotoB2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/002-He.png"));
        fotoB3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/003-Li.png"));
        fotoB4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/004-Be.png"));
        fotoB5 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/005-B.png"));
        fotoB6 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/006-C.png"));
        fotoB7 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/007-N.png"));
        fotoB8 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/008-O.png"));
        fotoB9 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/009-F.png"));
        fotoB10 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/010-Ne.png"));
        fotoB11 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/011-Na.png"));
        fotoB12 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/012-Mg.png"));
        fotoB13 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/013-Al.png"));
        fotoB14 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/014-Si.png"));
        fotoB15 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/015-P.png"));
        fotoB16 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/016-S.png"));
        fotoB17 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/017-Cl.png"));
        fotoB18 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/018-Ar.png"));
        fotoB19 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/019-K.png"));
        fotoB20 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/020-Ca.png"));
        fotoB21 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/021-Sc.png"));
        fotoB22 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/022-Ti.png"));
        fotoB23 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/023-V.png"));
        fotoB24 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/024-Cr.png"));
        fotoB25 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/025-Mn.png"));
        fotoB26 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/026-Fe.png"));
        fotoB27 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/027-Co.png"));
        fotoB28 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/028-Ni.png"));
        fotoB29 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/029-Cu.png"));
        fotoB30 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/030-Zn.png"));
        fotoB31 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/031-Ga.png"));
        fotoB32 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/032-Ge.png"));
        fotoB33 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/033-As.png"));
        fotoB34 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/034-Se.png"));
        fotoB35 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/035-Br.png"));
        fotoB36 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/056-Ba.png"));

        // crea una animacion para cada bloque
        animB1 = new Animacion();
        animB1.sumaCuadro(fotoB1, tMensaje);
        animB2 = new Animacion();
        animB2.sumaCuadro(fotoB2, tMensaje);
        animB3 = new Animacion();
        animB3.sumaCuadro(fotoB3, tMensaje);
        animB4 = new Animacion();
        animB4.sumaCuadro(fotoB4, tMensaje);
        animB5 = new Animacion();
        animB5.sumaCuadro(fotoB5, tMensaje);
        animB6 = new Animacion();
        animB6.sumaCuadro(fotoB6, tMensaje);
        animB7 = new Animacion();
        animB7.sumaCuadro(fotoB7, tMensaje);
        animB8 = new Animacion();
        animB8.sumaCuadro(fotoB8, tMensaje);
        animB9 = new Animacion();
        animB9.sumaCuadro(fotoB9, tMensaje);
        animB10 = new Animacion();
        animB10.sumaCuadro(fotoB10, tMensaje);
        animB11 = new Animacion();
        animB11.sumaCuadro(fotoB11, tMensaje);
        animB12 = new Animacion();
        animB12.sumaCuadro(fotoB12, tMensaje);
        animB13 = new Animacion();
        animB13.sumaCuadro(fotoB13, tMensaje);
        animB14 = new Animacion();
        animB14.sumaCuadro(fotoB14, tMensaje);
        animB15 = new Animacion();
        animB15.sumaCuadro(fotoB15, tMensaje);
        animB16 = new Animacion();
        animB16.sumaCuadro(fotoB16, tMensaje);
        animB17 = new Animacion();
        animB17.sumaCuadro(fotoB17, tMensaje);
        animB18 = new Animacion();
        animB18.sumaCuadro(fotoB18, tMensaje);
        animB19 = new Animacion();
        animB19.sumaCuadro(fotoB19, tMensaje);
        animB20 = new Animacion();
        animB20.sumaCuadro(fotoB20, tMensaje);
        animB21 = new Animacion();
        animB21.sumaCuadro(fotoB21, tMensaje);
        animB22 = new Animacion();
        animB22.sumaCuadro(fotoB22, tMensaje);
        animB23 = new Animacion();
        animB23.sumaCuadro(fotoB23, tMensaje);
        animB24 = new Animacion();
        animB24.sumaCuadro(fotoB24, tMensaje);
        animB25 = new Animacion();
        animB25.sumaCuadro(fotoB25, tMensaje);
        animB26 = new Animacion();
        animB26.sumaCuadro(fotoB26, tMensaje);
        animB27 = new Animacion();
        animB27.sumaCuadro(fotoB27, tMensaje);
        animB28 = new Animacion();
        animB28.sumaCuadro(fotoB28, tMensaje);
        animB29 = new Animacion();
        animB29.sumaCuadro(fotoB29, tMensaje);
        animB30 = new Animacion();
        animB30.sumaCuadro(fotoB30, tMensaje);
        animB31 = new Animacion();
        animB31.sumaCuadro(fotoB31, tMensaje);
        animB32 = new Animacion();
        animB32.sumaCuadro(fotoB32, tMensaje);
        animB33 = new Animacion();
        animB33.sumaCuadro(fotoB33, tMensaje);
        animB34 = new Animacion();
        animB34.sumaCuadro(fotoB34, tMensaje);
        animB35 = new Animacion();
        animB35.sumaCuadro(fotoB35, tMensaje);
        animB36 = new Animacion();
        animB36.sumaCuadro(fotoB36, tMensaje);

        cantBloques = 36;
        listaBloques.add(new Bloques(350, 50, animB1));
        listaBloques.add(new Bloques(430, 50, animB2));
        listaBloques.add(new Bloques(500, 50, animB3));
        listaBloques.add(new Bloques(580, 50, animB4));
        listaBloques.add(new Bloques(660, 50, animB5));
        listaBloques.add(new Bloques(740, 50, animB6));
        listaBloques.add(new Bloques(820, 50, animB7));
        listaBloques.add(new Bloques(900, 50, animB8));
        listaBloques.add(new Bloques(980, 50, animB9));
        listaBloques.add(new Bloques(1060, 50, animB10));

        listaBloques.add(new Bloques(350, 150, animB11));
        listaBloques.add(new Bloques(430, 150, animB12));
        listaBloques.add(new Bloques(500, 150, animB13));
        listaBloques.add(new Bloques(580, 150, animB14));
        listaBloques.add(new Bloques(660, 150, animB15));
        listaBloques.add(new Bloques(740, 150, animB16));
        listaBloques.add(new Bloques(820, 150, animB17));
        listaBloques.add(new Bloques(900, 150, animB18));
        listaBloques.add(new Bloques(980, 150, animB19));
        listaBloques.add(new Bloques(1060, 150, animB20));

        listaBloques.add(new Bloques(350, 250, animB21));
        listaBloques.add(new Bloques(430, 250, animB22));
        listaBloques.add(new Bloques(500, 250, animB23));
        listaBloques.add(new Bloques(580, 250, animB24));
        listaBloques.add(new Bloques(660, 250, animB25));
        listaBloques.add(new Bloques(740, 250, animB26));
        listaBloques.add(new Bloques(820, 250, animB27));
        listaBloques.add(new Bloques(900, 250, animB28));
        listaBloques.add(new Bloques(980, 250, animB29));
        listaBloques.add(new Bloques(1060, 250, animB30));

        listaBloques.add(new Bloques(350, 350, animB33));
        listaBloques.add(new Bloques(430, 350, animB34));
        listaBloques.add(new Bloques(500, 350, animB35));
        listaBloques.add(new Bloques(740, 350, animB36));
        listaBloques.add(new Bloques(980, 350, animB32));
        listaBloques.add(new Bloques(1060, 350, animB31));

        heart = new ImageIcon("Mono/heart.png");

        gameOver = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/Gameover.png"));
        introImagen = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/Breakintro.gif"));
        pausaImagen = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/pause.png"));

        fotoCarro = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/bar.png"));

        background = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/background.png"));
        tableroInstrucciones = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Mono/instruccionesTiroParabolico.jpg"));

        animCanasta = new Animacion();
        animP = new Animacion();
        animBloque = new Animacion();

        animCanasta.sumaCuadro(fotoCarro, 700);

        animP.sumaCuadro(fotoD1, 100);
        animP.sumaCuadro(fotoD2, 100);
        animP.sumaCuadro(fotoD3, 100);
        animP.sumaCuadro(fotoD4, 100);
        animP.sumaCuadro(fotoD5, 100);

        canasta = new Barra(getWidth() / 2 - new ImageIcon(fotoCarro).getIconWidth() / 2 + 20, 680, animCanasta);
        pelota = new Pelota(getWidth() / 2 - new ImageIcon(fotoD1).getIconWidth() / 2 + 20, 660, animP);
    }

    /**
     * Metodo <I>start</I> sobrescrito de la clase <code>Applet</code>.<P>
     * En este metodo se crea e inicializa el hilo para la animacion este metodo
     * es llamado despues del init o cuando el usuario visita otra pagina y
     * luego regresa a la pagina en donde esta este <code>Applet</code>
     *
     */
    public void start() {
        //Crea el thread
        Thread hilo = new Thread(this);
        //Inicializa el thread
        hilo.start();
    }

    public void restart() {

        cantBloques = 36;
        listaBloques.add(new Bloques(350, 50, animB1));
        listaBloques.add(new Bloques(430, 50, animB2));
        listaBloques.add(new Bloques(500, 50, animB3));
        listaBloques.add(new Bloques(580, 50, animB4));
        listaBloques.add(new Bloques(660, 50, animB5));
        listaBloques.add(new Bloques(740, 50, animB6));
        listaBloques.add(new Bloques(820, 50, animB7));
        listaBloques.add(new Bloques(900, 50, animB8));
        listaBloques.add(new Bloques(980, 50, animB9));
        listaBloques.add(new Bloques(1060, 50, animB10));

        listaBloques.add(new Bloques(350, 150, animB11));
        listaBloques.add(new Bloques(430, 150, animB12));
        listaBloques.add(new Bloques(500, 150, animB13));
        listaBloques.add(new Bloques(580, 150, animB14));
        listaBloques.add(new Bloques(660, 150, animB15));
        listaBloques.add(new Bloques(740, 150, animB16));
        listaBloques.add(new Bloques(820, 150, animB17));
        listaBloques.add(new Bloques(900, 150, animB18));
        listaBloques.add(new Bloques(980, 150, animB19));
        listaBloques.add(new Bloques(1060, 150, animB20));

        listaBloques.add(new Bloques(350, 250, animB21));
        listaBloques.add(new Bloques(430, 250, animB22));
        listaBloques.add(new Bloques(500, 250, animB23));
        listaBloques.add(new Bloques(580, 250, animB24));
        listaBloques.add(new Bloques(660, 250, animB25));
        listaBloques.add(new Bloques(740, 250, animB26));
        listaBloques.add(new Bloques(820, 250, animB27));
        listaBloques.add(new Bloques(900, 250, animB28));
        listaBloques.add(new Bloques(980, 250, animB29));
        listaBloques.add(new Bloques(1060, 250, animB30));

        listaBloques.add(new Bloques(350, 350, animB33));
        listaBloques.add(new Bloques(430, 350, animB34));
        listaBloques.add(new Bloques(500, 350, animB35));
        listaBloques.add(new Bloques(740, 350, animB36));
        listaBloques.add(new Bloques(980, 350, animB32));
        listaBloques.add(new Bloques(1060, 350, animB31));
    }

    /**
     * Metodo stop sobrescrito de la clase Applet. En este metodo se pueden
     * tomar acciones para cuando se termina de usar el Applet. Usualmente
     * cuando el usuario sale de la pagina en donde esta este Applet.
     */
    public void stop() {

    }

    /**
     * Metodo destroy sobrescrito de la clase Applet. En este metodo se toman
     * las acciones necesarias para cuando el Applet ya no va a ser usado.
     * Usualmente cuando el usuario cierra el navegador.
     */
    public void destroy() {

    }

    /**
     * Metodo <I>run</I> sobrescrito de la clase <code>Thread</code>.<P>
     * En este metodo se ejecuta el hilo, checa si pauso el juego, actualiza
     * llama al metodo checaColision, finalmente se repinta el
     * <code>Applet</code> y luego manda a dormir el hilo.
     *
     */
    public void run() {

        //Guarda el tiempo actual del sistema
        tiempoActual = System.currentTimeMillis();

        //Ciclo principal del Applet. Actualiza y despliega en pantalla la animación hasta que el Applet sea cerrado
        while (true) {
            if (!pausa && !instrucciones) {
                actualiza();
                checaColision();
            }

            repaint();

            //Hace una pausa de 200 milisegundos
            try {
                Thread.sleep(60);
            } catch (InterruptedException ex) {
                // no hace nada
            }
        }

    }

    /**
     * Metodo usado para checar la colision del objeto bueno con algún objeto
     * malo de la lista de malos, checa si algun malo choco con el <code>Applet
     * </code> por la parte inferior.
     */
    public void checaColision() {

        if (canasta.getPosX() + canasta.getAncho() > getWidth()) {
            canasta.setPosX(getWidth() - canasta.getAncho());
        }
        if (canasta.getPosX() < 220) {
            canasta.setPosX(220);
        }

        if (pelota.getPosX() <= 250) {

            pelota.setVelX(-pelota.getVelX());

        } else if (pelota.getPosX() + pelota.getAncho() + 10 >= getWidth()) {
            pelota.setVelX(-pelota.getVelX());

        } else if (pelota.getPosY() - 40 <= 0) {
            pelota.setVelY(-pelota.getVelY());
        }

        if (pelota.intersectaCentro(canasta)) {
            pelota.setVelY(-pelota.getVelY());

            if (pelota.getPosX() - canasta.getPosX() <= 66) {

                pelota.setVelX((pelota.getPosX() - canasta.getPosX() - 66) + 20);
            } else {
                pelota.setVelX((pelota.getPosX() - canasta.getPosX()) - 66);
            }
        }

        for (Bloques bloque : listaBloques) {
            if (bloque.intersecta(pelota)) {
                choqueBloque.play();
                cantBloques--;
                if (pelota.hitUp(bloque)) {
                    pelota.setVelY(-pelota.getVelY());

                } else if (pelota.hitDown(bloque)) {
                    pelota.setVelY(-pelota.getVelY());

                } else if (pelota.hitLeft(bloque)) {
                    pelota.setVelX(-pelota.getVelX());

                } else if (pelota.hitRight(bloque)) {
                    pelota.setVelX(-pelota.getVelX());

                }

                listaBloques.remove(bloque);
                score++;

                break;
            }
        }

        if (pelota.getPosY() + pelota.getAlto() >= getHeight()) {
            pelota.volverInicio();
            Pelota.nivel += .3;
            canasta.volverInicio();
            inicio = false;
            vidas--;
        }

    }

    /**
     * El método actualiza() del <code>Applet</code> que actualiza las
     * posiciones de el objeto bueno, los objetos malos y da los tiempos para
     * cada segmento de animacion.
     */
    public void actualiza() {

        if (inicio) {
            long tiempoTranscurrido = System.currentTimeMillis() - tiempoActual;

            pelota.avanza();

            if (canasta.getMoveLeft()) {
                canasta.setPosX(canasta.getPosX() - 15);
            }
            if (canasta.getMoveRight()) {
                canasta.setPosX(canasta.getPosX() + 15);
            }

            if (pelota.getMovimiento()) {
                pelota.actualiza(tiempoTranscurrido);

            }

        }
    }

    /**
     * Metodo <I>update</I> sobrescrito de la clase <code>Applet</code>,
     * heredado de la clase Container.<P>
     * En este metodo lo que hace es actualizar el contenedor
     *
     * @param g es el <code>objeto grafico</code> usado para dibujar.
     */
    public void paint(Graphics g) {
        // Inicializan el DoubleBuffer

        dbImage = createImage(this.getSize().width, this.getSize().height);
        dbg = dbImage.getGraphics();

        // Actualiza la imagen de fondo.
        dbg.setColor(getBackground());
        dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);

        // Actualiza el Foreground.
        dbg.setColor(getForeground());
        paint1(dbg);

        // Dibuja la imagen actualizada
        g.drawImage(dbImage, 0, 0, this);
    }

    /**
     * Metodo <I>paint</I> sobrescrito de la clase <code>Applet</code>, heredado
     * de la clase Container.<P>
     * En este metodo se dibuja la imagen con la posicion actualizada, ademas
     * que cuando la imagen es cargada te despliega una advertencia. ph
     *
     * @param g es el <code>objeto grafico</code> usado para dibujar.
     */
    public void paint1(Graphics g) {

        //g.drawImage(introImagen, 0, 0, this);
        g.drawImage(background, 8, 30, this);
        g.setFont(new Font("Serif", Font.BOLD, 34));
        g.drawString("Score: " + score, 44, 195);
        g.setColor(Color.red);
        g.drawString("Vidas: " + vidas, 44, 250);
        if (cantBloques == 0) {
            perdio = true;
        }
        if (canasta != null) {
            if (!perdio) {
                
                

                g.drawImage(canasta.animacion.getImagen(), (int) canasta.getPosX(), (int) canasta.getPosY(), this);
                g.drawImage(pelota.animacion.getImagen(), (int) pelota.getPosX(), (int) pelota.getPosY(), this);

                if (instrucciones) {

                    g.drawImage(tableroInstrucciones, getWidth() / 2 - new ImageIcon(tableroInstrucciones).getIconWidth() / 2,
                            getHeight() / 2 - new ImageIcon(tableroInstrucciones).getIconHeight() / 2, this);    // Tablero de instrucciones
                }

                if (vidas == 0) {
                    perdio = true;

                    g.drawImage(gameOver, 0, 0, this);

                }

                for (Bloques bloque : listaBloques) {

                    g.drawImage(bloque.animacion.getImagen(), (int) bloque.getPosX(), (int) bloque.getPosY(), this);

                }

            } else {
                g.drawImage(gameOver, 8, 30, this);
            }

        }
        if (pausa) {
            g.drawImage(pausaImagen, getWidth() / 2 - new ImageIcon(pausaImagen).getIconWidth() / 2, getHeight() / 2 - new ImageIcon(pausaImagen).getIconHeight() / 2, this);
        }

    }

    /**
     * Método para grabar archivo que envia todas las variables del juego dentro
     * de un string, el cual es guardado con el nombre <code> NombreArchivo
     * </code>
     *
     * @throws IOException
     */
    public void grabaArchivo() throws IOException {

        PrintWriter fileOut = new PrintWriter(new FileWriter(nombreArchivo));
        fileOut.println(score + " " + caidas + " " + vidas + " " + pelota.getDatos()
                + " " + clicked + " " + chocado + " " + pausa + " " + instrucciones + " " + sonido + " "
                + canasta.getPosX());
        fileOut.close();
    }

    /**
     * Método que lee el <code> nombreArchivo</code> que contiene una linea con
     * todos los valores utilizados en el juego para volverse a cargar
     *
     * @throws IOException
     */
    public void leeArchivo() throws IOException {

        BufferedReader fileIn;
        try {
            fileIn = new BufferedReader(new FileReader(nombreArchivo));

            String dato = fileIn.readLine();

            arr = dato.split(" ");

            score = Integer.parseInt(arr[0]);
            caidas = Integer.parseInt(arr[1]);
            vidas = Integer.parseInt(arr[2]);
            pelota.setPosX(Double.parseDouble(arr[5]));
            pelota.setPosY(Double.parseDouble(arr[6]));
            pelota.setDatos(arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9]);
            clicked = Boolean.parseBoolean(arr[10]);
            chocado = Boolean.parseBoolean(arr[11]);
            pausa = Boolean.parseBoolean(arr[12]);
            instrucciones = Boolean.parseBoolean(arr[13]);
            sonido = Boolean.parseBoolean(arr[14]);
            canasta.setPosX(Double.parseDouble(arr[15]));

            fileIn.close();
        } catch (FileNotFoundException e) {
        }

    }

    /**
     * Método que identifica si se movio hacia algun lado la canasta
     *
     * @param e
     */
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {

            canasta.setMoveLeft(false);

        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

            canasta.setMoveRight(false);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Metodo <I>keyPressed</I> sobrescrito de la interface
     * <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al presionar cualquier la
     * tecla.
     *
     * @param e es el <code>evento</code> generado al presionar las teclas.
     */
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {

            canasta.setMoveLeft(true);

        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

            canasta.setMoveRight(true);

        } else if (e.getKeyCode() == KeyEvent.VK_P) {

            if (!pausa) {

                pausa = true;
                pelota.pausa();

            } else {

                pausa = false;
                pelota.despausa();

            }
        } else if (e.getKeyCode() == KeyEvent.VK_I) {

            if (!instrucciones) {
                instrucciones = true;
                pelota.pausa();

            } else {

                instrucciones = false;
                pelota.despausa();

            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {

            sonido = !sonido;

        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (!inicio) { // si el juego no ha empezado
                pelota.empieza();
                inicio = true;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_N) {
            if (perdio) {
                restart();
                vidas = 3;
                pelota.volverInicio();
                canasta.volverInicio();
                perdio = false;
            }
        }

    }

    public void mousePressed(MouseEvent e) {

    }

    /**
     * Si se preciono el mouse sobre el objeto granada
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
