
package prup3;

import static java.lang.Thread.sleep;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ENEMIGO5 extends Thread {
    
    JUEGO vtn;
     JLabel enemigo;
     
    
    public ENEMIGO5(JUEGO vtn,JLabel enemigo){
        this.vtn = vtn;
        this.enemigo=enemigo;
        
        ImageIcon ic1 = new ImageIcon("en.gif");
        enemigo.setIcon(ic1);
        enemigo.setVisible(true);
        this.vtn.add(enemigo);
        this.vtn.repaint();
        
    }
    
    
    public void run(){
        
        while(true){
            try{
                sleep(1000);
               enemigo.setLocation(enemigo.getLocation().x-10,enemigo.getLocation().y);
                
                
             muertePOrAlienigna();

                
            }catch (Exception e) {
                
        }
            
          
            
            
        }
    }
    
    
    	public void muertePOrAlienigna() {

         if ((DISPARO.disparo.getX()+5 >= enemigo.getX() && DISPARO.disparo.getX() >= enemigo.getX()-5)
                && (enemigo.getY()+15> DISPARO.disparo.getY()&& enemigo.getY()-15 < DISPARO.disparo.getY())) {
             vtn.remove(enemigo);
             vtn.remove(DISPARO.disparo);
             this.vtn.repaint();
             
            ENEMIGO.puntaje=ENEMIGO.puntaje+10;
         
             OBPUNTOS.conversion= String.valueOf(ENEMIGO.puntaje);
             
             
             
             
             stop();
             
                        
            }
          
              
        
        } 
    
    
}
