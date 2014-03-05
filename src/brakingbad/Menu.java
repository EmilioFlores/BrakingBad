/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brakingbad;


import java.awt.*;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

/**
 *
 * @author Emilio
 */
public class Menu implements MouseListener {
    
    public Rectangle newGame = new Rectangle(200,200,200,200);
    public String nuevoJuego = "Nuevo Juego";
    public String cargar = "Cargar";
    public String altosPuntuajes = "Highscores";
    public String creditos = "Creditos";
    
    public ImageIcon menuIcon = new ImageIcon ("Images/brakingBricks.png");
    
    public void paintMenu (Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        g.setFont( new Font ("Comic Sans MS", Font.PLAIN, 30));
        g.setColor (Color.decode("279162"));
        g.drawString(nuevoJuego, Base.getW()/2, 200);
        g2.draw(newGame);
        g2.fill(newGame);
        
        g.drawString(cargar, Base.getW()/2, 250);
        
        g.drawString(altosPuntuajes, Base.getW()/2, 300);
       
        g.drawString(creditos, Base.getW()/2, 350);
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
           System.out.println("no entro");
           System.out.println(e.getLocationOnScreen());
        if (newGame.contains(e.getLocationOnScreen())) {
            BrakingBadClass.estado = "juego";  
            System.out.println("hola");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
      }

    @Override
    public void mouseReleased(MouseEvent e) {
          }

    @Override
    public void mouseEntered(MouseEvent e) {
     }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}