/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrela.de.davi;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import javax.swing.JPanel;

/**
 *
 * @author creuma
 */
public class PainelEstrelaDeDavi extends JPanel implements Runnable {
    
    private int angulo = 0;
    Thread thread;
    
    public PainelEstrelaDeDavi()
    {
        new Thread(this).start();   
    }        
    
     public void paintComponent(Graphics g){

     super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        paintStar(g2D);
        
     }
     
     private void paintStar(Graphics2D g2d)
     {
     
         int x1Points [] = {100,20,180};
         int y1Points [] = {100,180,180};
         int x2Points[] = {30,180,90};
         int y2Points [] = {120,120,210};
        
         AffineTransform atf = new AffineTransform();
         atf.rotate(Math.toRadians(angulo),210, 210);
         atf.translate(100, 50);
         g2d.setTransform(atf);
         
         GeneralPath estrela = new GeneralPath();
         // Triângulo de cima
         estrela.moveTo(x1Points[0],y1Points[0]);
         
         for(int i=1; i< x1Points.length;i++)
            estrela.lineTo(x1Points[i], y1Points[i]);

         estrela.closePath();
         g2d.setPaint(Color.blue);
         g2d.draw(estrela);
         
         // Triângulo de baixo
         estrela.moveTo(x2Points[0],y2Points[0]);
         
         for(int i=1; i< x2Points.length;i++)
            estrela.lineTo(x2Points[i], y2Points[i]);

         estrela.closePath();
         g2d.setPaint(Color.blue);
         g2d.draw(estrela);
     }        

     
    @Override
    public void run() {
       
         while (true) {
            try {
                
               angulo+=5;
                repaint();
                Thread.sleep(150);
            } catch (InterruptedException ex) {
                System.out.println("Erro!");
            }
        }
    }
             
    
}
