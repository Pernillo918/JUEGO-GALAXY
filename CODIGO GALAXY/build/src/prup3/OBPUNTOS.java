
package prup3;

import javax.swing.JLabel;


public class OBPUNTOS extends Thread {
    
   
    JUEGO vtn;
    JLabel puntuacion;
   static  String conversion;
    
    public OBPUNTOS(JUEGO vtn){
        this.vtn=vtn;
       
       conversion = "0";
        
    
       
    }
    
    
    public void run(){
      try {
            while (true) {
             
            vtn.CPUNTOS.setText(conversion);
            sleep(60);
               
         
                
     
              
            }
        } catch (Exception e) {

        }
    }
    
    
    
    
}
