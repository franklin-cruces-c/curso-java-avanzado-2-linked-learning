import javax.xml.transform.stream.StreamSource;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ListaDeLaCompra {

    private ArrayList<String> lista;
    private String archivo;


    public ListaDeLaCompra(String filename) throws IOException {
        cargarLista(filename);
        archivo = filename;
    }

    private void cargarLista(String filename) throws IOException {
        lista = new ArrayList<>(Files.readAllLines(Paths.get(filename)));
    }

    public String obtenerElemento(int indice) throws PositionException {
        if (indice <= lista.size()) {
            return lista.get(indice);
        } else {
           // return "elemento no encontrado";
            //Lanzamos la excepcion para que la maneje quien llama el metodo
            throw new PositionException("Posición fuera de los limites de la lista");
        }
    }
    public void insertarElemento(String elemento) throws IOException {

        FileWriter fstream = new FileWriter(archivo, true);
        // No hay garantia de que se ejecute el finally por ejemplo
        // no se ejecuta si se interrumpe un hilo o se cierra la maquina virtual de java
        // para asegurar que los recursos se cierren se utiliza el try con recursos
        try (BufferedWriter out = new BufferedWriter(fstream)){

            //incluso con un return el bloque finally se ejecuta
//            if(true){
//                return;
//            }
            //out.close();
            //BufferedWriter out = new BufferedWriter(fstream);
            out.write("\n" + elemento);
            cargarLista(archivo);
            System.out.println("Ejecutado bloque try por completo");
        }catch (IOException e){
            e.printStackTrace();
            throw e;
        }
        /*
        finally {
            System.out.println("Ejecutado bloque finally");
            if(out != null) {
                out.close();
            }
        }

         */
    }
}
