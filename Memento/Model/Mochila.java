package Model;
import java.util.*;
public class Mochila {
    List<Item> itens = new ArrayList<Item>();
    private static Mochila instancia;
    
    private Mochila() {}
    
    public static Mochila getInstancia() {
    	if(instancia == null) {
    		instancia = new Mochila();
    	}
    	return instancia;

    }
    
    public void add(Item item) {
        itens.add(item);
    }
}
