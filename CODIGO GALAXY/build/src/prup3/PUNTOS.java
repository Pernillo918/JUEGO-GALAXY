
package prup3;


public class PUNTOS {
    
    //ATRIBUTOS 
    private String nombre;
    private String puntos;

    
    //CONSTRUCTOR INICIALIZADO 
    public PUNTOS(){
        this.nombre="";
        this.puntos="";
        
    }
    
    //CONSTRUCTOR 

    public PUNTOS(String nombre, String puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }
    
    
    
}