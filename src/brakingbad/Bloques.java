/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brakingbad;

import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author Emilio
 */
public class Bloques extends Base {

    private char tipo;
    private ImageIcon imagen[];
    private Animacion animacionFinal;
    private int posBloqueX;
    private int posBloqueY;
    private int vidas;

    public Bloques(int posX, int posY, Animacion anim) {
        super(posX, posY, anim);

    }

    /**
     * Si el <code>Bloque</code> es golpeado por la <code>Pelota</code> ,
     * disminuye <I>vida</I>
     */
    private void quitaVida() {
        vidas--;
    }

    /**
     * Si el la <code>Pelota</code> consigue un powerUp de vida, aumenta
     * <I>vida</I>
     */
    private void aumentaVida() {
        vidas++;
    }

}
