package brakingbad;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author daniel rodriguez
 * @author Emilio Flores
 */
public class Barra extends Base {

    private boolean moveRight;
    private boolean moveLeft;
    private double xInicial;
    private double yInicial;

    /**
     * Método constructor de la clase Canasta
     *
     * @param posX posicion X del objeto
     * @param posY posicion Y del objeto
     * @param animacion Animacion
     */
    public Barra(int posX, int posY, Animacion animacion) {
        super(posX, posY, animacion);
        moveRight = false;
        moveLeft = false;
        xInicial = posX;
        yInicial = posY;
    }

    public void volverInicio() {

        setPosX(xInicial);
        setPosY(yInicial);

    }

    /**
     * Método que activa la direccion donde se movio el objeto
     *
     * @param b booleano
     */
    public void setMoveRight(boolean b) {
        moveRight = b;
    }

    /**
     * Método que me regresa un booleano si se movio hacia la derecha la canasta
     *
     * @return boolean
     */
    public boolean getMoveRight() {
        return moveRight;
    }

    /**
     * Método que activa la direccion donde se movio el objeto
     *
     * @param b booleano
     */
    public void setMoveLeft(boolean b) {
        moveLeft = b;
    }

    /**
     * Método que regresa un booleano si se movio hacia la izquierda la canasta
     *
     * @return boolean
     */
    public boolean getMoveLeft() {
        return moveLeft;
    }
}
