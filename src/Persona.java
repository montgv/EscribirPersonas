import java.io.Serializable; 

public class Persona implements Serializable{ 
    private String nombre; 
    private int edad; 
    
    public Persona(String nombre,int edad) {
        this.nombre = nombre; 
        this.edad = edad; 
    }

    public Persona() { 
        this.nombre = null; 
    }

    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setEdad(int edad) {this.edad = edad;} 

    public String getNombre() {return this.nombre;}//devuelve nombre
    public int getEdad() {return this.edad;} //devuelve edad 
}