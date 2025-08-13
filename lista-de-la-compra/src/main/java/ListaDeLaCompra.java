import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ListaDeLaCompra {

    private ArrayList<String> lista;

    public ListaDeLaCompra(String filename) {

        cargarLista(filename);
    }

    private void cargarLista(String filename) {
        try {
            lista = new ArrayList<>(Files.readAllLines(Paths.get(filename)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String obtenerElemento(int indice) {
        if(indice <= lista.size()) {
            return lista.get(indice);
        }else {
            return "elemento no encontrado";
        }
    }
}
