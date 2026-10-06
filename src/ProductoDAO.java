import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class ProductoDAO implements ProductoDAOLocal{

    private File fichero;

    public ProductoDAO(String ruta){
        this.fichero=new File(ruta);
    }

    @Override
    public void guardarTodos(List<Producto> productos) {
        Producto p1= new Producto(1, "Chocolate", 4.5);
        Producto p2= new Producto(2, "Turron", 6.5);
        Producto p3= new Producto(3, "Caramelos", 2.5);
        Producto p4= new Producto(3, "Bombones", 3.5);
        List<Producto> productos1 = List.of(p1, p2, p3, p4);
        File file = new File("ProductosBinario.txt");
        
        try (FileOutputStream streamFichero= new FileOutputStream(file);
            ObjectOutputStream writerOos= new ObjectOutputStream(streamFichero); 
        ) {
            //Escribiendo los objectos en el fichero
            for (Producto producto : productos1) {
                writerOos.writeObject(producto);
            }


        } catch (Exception e) {
        }
    }

    @Override
    public List<Producto> listarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodos'");
    }

    
}
