package prup3;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class DISPARO extends Thread {
    

    static JLabel disparo;
    Rectangle rctl;
    JUEGO vtn;

    public DISPARO(JUEGO vtn, Rectangle rctl) {

       
        this.vtn = vtn;
        this.rctl = rctl;    
        disparo = new JLabel();       
        disparo.setBounds(rctl.x+25, rctl.y, 30, 30);     
        disparo.setVisible(true);
            
        ImageIcon img = new ImageIcon("bala.png");
        Image nuevo = img.getImage().getScaledInstance(disparo.getWidth(), disparo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon render = new ImageIcon(nuevo);
        disparo.setIcon(render);
        
        this.vtn.add(disparo);
        this.vtn.repaint();          
    }
    
    public void run(){

        int posx = disparo.getX();
        try{
            while(true){
                sleep(50);
                posx += 25;
                disparo.setLocation(posx, rctl.y);
                //System.out.println(disparo.getY());
              
             /*  if ((disparo.getX()+5 > ENEMIGO.enemigo1.getX()&& disparo.getX()-5 < ENEMIGO.enemigo1.getX())
                        && (disparo.getY()+15 > ENEMIGO.enemigo1.getY() && disparo.getY()-15 < ENEMIGO.enemigo1.getY())){
                    vtn.remove(disparo);
               this.stop();
                    
                }else*/
                    
                    if(posx >= vtn.getWidth()-2){
                    vtn.remove(disparo);                
                    this.stop();
                }

            vtn.repaint();
                
            }
        }catch(Exception e){
            
        }
    }
    
    
    
}
