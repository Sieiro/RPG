package Model;
import java.util.ArrayList;
public class Mochila {
    ArrayList<Item> itens = new ArrayList<Item>();
    private Mochila instancia;
    public static Mochila getInstancia() {
    	if(instancia == null) {
    		instancia = new Mochila();
    		return instancia
    	}
    	else
    		return instancia;

    }
}
