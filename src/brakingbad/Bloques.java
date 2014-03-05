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

public class Bloques extends Base{
    
    private char tipo;
    private ImageIcon imagen[];
    private Animacion animacionFinal;
    private int posBloqueX;
    private int posBloqueY;
    private int vidas;
    
    
    public Bloques (char tipo, int posX, int posY, Animacion anim, int numBloque) {
        super (posX,posY,anim);
        this.tipo = tipo;
        
        if (tipo == 'F') {
            vidas = 3;
        } 
        else if (tipo == 'D') {
            vidas = 1;
        }
        crearImagenes(numBloque);
        
    }
    
    /**
     * Método que crea las imagenes dependiendo del tipo de bloque que es
     * tipo == F: Bloque tiene 3 vidas
     * tipo == D: Bloque tiene 1 vida
     * @param numBloque 
     */
     private void crearImagenes(int numBloque) {
        
         if (tipo == 'F') { 
             for (int i = 0; i < 3; i++) {
                  imagen[i] = new ImageIcon ("Images/" + i + numBloque+ ".png");
              }
          }
         else if (tipo == 'D') {
             imagen[0] = new ImageIcon ("Images/" + numBloque + ".png");
         }  
    }
     
     /**
      * Si el <code>Bloque</code> es golpeado por la <code>Pelota</code> , disminuye <I>vida</I>
      */
     private void quitaVida () {
         vidas--;
     }
     
     /**
      * Si el la <code>Pelota</code> consigue un powerUp de vida, aumenta <I>vida</I>
      */
     private void aumentaVida() {
         vidas++;
     }
    
}
