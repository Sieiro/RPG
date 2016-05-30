package Model;
import java.util.*;
public class Mochila {
    List<Item> itens = new ArrayList<Item>();
    private Mochila instancia;
    public static Mochila getInstancia() {
    	if(instancia == null) {
    		instancia = new Mochila();
    		return instancia;
    	}
    	else
    		return instancia;

    }
    
    public void add(Item item) {
        itens.add(item);
    }
}
