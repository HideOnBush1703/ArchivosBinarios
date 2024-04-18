
package archivosBinarios;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArchivosBinarios {
    
    private void escribirBinario(){
        try {
            FileOutputStream archivo = new FileOutputStream("personas.bin");
            ObjectOutputStream escritura = new ObjectOutputStream(archivo); //ojo aca la nueva clase
            
            Persona persona1 = new Persona("Josue", 20);
            Persona persona2 = new Persona("Luis", 19);
            Persona persona3 = new Persona("Andre", 21);
            
            //escribimos objetos sobre el archivo binario
            //writeInt, writeFloat, ojo con eso
            escritura.writeObject(persona1);
            escritura.writeObject(persona2);
            escritura.writeObject(persona3);
            
            escritura.close();//cerramos el archivo binario
        
        } catch (FileNotFoundException ex) {
            System.err.println("Error, "+ex);
        } catch (IOException ex) {
            System.err.println("Error, "+ex);
        }
    }
    
    private void leerBinario(){
        Persona objetoPersona;
        
        try {
            FileInputStream archivo = new FileInputStream("personas.bin");
            ObjectInputStream lectura = new ObjectInputStream(archivo);
            
            while(true){//recorremos el archivo binario(mi archivo binario cuenta con objetos)
                objetoPersona=(Persona) lectura.readObject();//me retorna un objeto de tipo object
                objetoPersona.mostrarDatos();                //y lo convertimos a objeto de tipo persona
            
            }   
            
        }catch(EOFException ex){
            return;//finalizó de leer todo el archivo binario
        } catch (FileNotFoundException ex) {
            System.err.println("Error, "+ex);
        } catch (IOException ex) {
            System.err.println("Error, "+ex);    
        } catch (ClassNotFoundException ex) {
            System.err.println("Error, "+ex);
        }
    }
    
    private void añadirBinario(){
        try {
            FileOutputStream archivo = new FileOutputStream("personas.bin",true); //el true indica añadir, mirar API y mirar el constructor
            AñadirContenido escritura = new AñadirContenido(archivo);
            
            Persona persona1 = new Persona("Juan", 17);
            Persona persona2 = new Persona("Luz", 24);
            
            
            //escribimos objetos sobre el archivo binario
            //writeInt, writeFloat, ojo con eso
            escritura.writeObject(persona1);
            escritura.writeObject(persona2);
            
            
            escritura.close();//cerramos el archivo binario
        
        } catch (FileNotFoundException ex) {
            System.err.println("Error, "+ex);
        } catch (IOException ex) {
            System.err.println("Error, "+ex);
        }
    }
    
    public static void main(String[] args) {
        ArchivosBinarios archivosB = new ArchivosBinarios();
        
        //archivosB.escribirBinario();
        archivosB.añadirBinario();
        archivosB.leerBinario();
    }
}
