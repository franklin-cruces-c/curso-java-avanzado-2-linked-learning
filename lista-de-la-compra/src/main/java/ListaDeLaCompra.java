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

    public String obtenerElemento(int indice) {
        if (indice <= lista.size()) {
            return lista.get(indice);
        } else {
            return "elemento no encontrado";
        }
    }
    public void insertarElemento(String elemento) throws IOException {
        BufferedWriter out = null;
        try {
            FileWriter fstream = new FileWriter(archivo, true);
            out = new BufferedWriter(fstream);
            
            out.write("\n" + elemento);
            cargarLista(archivo);
            System.out.println("Ejecutado bloque try por completo");
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Ejecutado bloque catch");
        }
        finally {
            System.out.println("Ejecutado bloque finally");
            if(out != null) {
                out.close();
            }
        }
    }
}
