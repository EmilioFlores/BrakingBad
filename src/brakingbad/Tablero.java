/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brakingbad;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Emilio
 */
public class Tablero {
    
    private Bloques[] blockes;
    private Animacion background;
    private int posX;
    private int posY;
    private static int W;
    private static int H;
    
    
    
    
    /**
     * Método que regresa la posicion de X del tablero
     * @return 
     */
    public int getPosX() {
        return posX;
    }
    
    /**
     * Método que asigna la posicion x del tablero
     * @param x 
     */
    public void setPosX(int x) {
        posX = x;
    }
    
     /** 
     * Método que regresa la <code> Animacion </code> del objeto
     * @return Anim
     */
    public Animacion getAnimacion () {
        return this.background;
    }
    
    /**
     * Método que regresa el ancho del objeto
     * @return int ancho 
     */
    public int getAncho () {
        return new ImageIcon(this.background.getImagen()).getIconWidth();
    }
    
    /**
     * Método que regresa el alto del objeto
     * @return int alto
     */
    public int getAlto() {
        return new ImageIcon (this.background.getImagen()).getIconHeight();
    }
    
     public Rectangle getPerimetro(){
		return new Rectangle((int) getPosX(),(int) getPosY(),getAncho(),getAlto());
    }
   
    /**
     * Método que asigna el tamaño estatico del applet
     * @param w 
     */
    public static void setW(int w) {
        W = w;
    }
    
  /**
   * Método que me regresa el tamaño estatico de mi applet
   * @return W que es el width
   */
    public static int getW() {
        return W;
    }
    
      /**
     * Método que asigna la variable estatica del applet del tamaño
     * @param h 
     */
    public static void setH(int h) {
        H = h;
    }
    
   /**
    * Método que regresa la variable estatica del applet 
    * @return H que es el <I> Height </I>
    */
    public static int getH() {
        return H;
    }
    
    /**
     * Método que actualiza las <I>Animaciones</I> del applet
     * @param tiempo 
     */
    public void actualiza(long tiempo) {
        background.actualiza(tiempo);
    }
        
    
    /**
     * Método que regresa la posicion y del tablero
     * @return 
     */
    public int getPosY() {
        return posY;
    }
    
    
    /**
     * Método que asigna la posicion y del tablero
     * @param y 
     */
    public void setPosY(int y) {
        posY = y;
    }
    
    
    
}
