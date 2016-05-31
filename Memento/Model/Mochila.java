package Model;
import java.util.*;
public class Mochila {
    public static List<Item> itens = new ArrayList<Item>();
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
    
    public void remove(Item item) {
        int i = 0;
        for(Item it : itens) {
            if(it == item) break;
            else i++;
        }
        itens.remove(i);
    }
    
    public int getDanoQuantidade() {
        // não implementado
        return 0;
    }
    
    public int getItemQuantidade() {
        // não implementado
        return 0;
    }
}
