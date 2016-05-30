package Controller;
import Model.*;
import java.util.ArrayList;
public class NovoItem extends Evento {
    private Item item;
    
    public NovoItem(int opt) {
        super(opt, "Item encontrado! (opt " + opt + ")");
        this.item = new Consumivel("Poção.", "Recupera vida.");
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("Pegar Item");
        lista.add("Descartar Item");
        this.setOpcoes(lista);
    }
    
    // pega o item
    public void pegarItem(Pessoa pessoa) {
        //
        Mochila.getInstancia().add(this.item);
        this.setFimEvento(true);
        this.setMensagem("Você conseguiu: " + item.getNome());
    }
    
    // descarta o item
    public void descartarItem() {
        //
        this.setFimEvento(true);
        this.setMensagem("Você descartou o item.");
    }
}
