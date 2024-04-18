
package archivosBinarios;

import java.io.Serializable;

public class Persona implements Serializable{ //interfaz sin metodos abstractos, 
                                              //le decimos que todos los objetos 
                                              //de la clase persona se conviertan en un flujo de bytes.
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public void mostrarDatos(){
        System.out.println("Nombre: "+nombre);
        System.out.println("Edad: "+edad);
        System.out.println("");
    }
    
}
