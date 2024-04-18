//para añadir ya no usaremos el ObjectOutputStream sino el AñadirContenido(); que
//tiene todo del ObjectOutputStream menos el metodo writeStreamHeader() que lo que hacia
//era poner una cabecera diferente y me lanzaba el error.
package archivosBinarios;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AñadirContenido extends ObjectOutputStream{

    public AñadirContenido(OutputStream out) throws IOException {
        super(out);
    }

    public AñadirContenido() throws IOException, SecurityException {
    }
    
    @Override
    public void writeStreamHeader() throws IOException{
        reset();
    }
}
