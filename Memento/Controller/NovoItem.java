package Controller;
import Model.*;
public class NovoItem extends Evento {
    private Item item;
    
    public NovoItem(int opt) {
        super(opt, "Item encontrado! (opt " + opt + ")");
        this.item = new Item("Poção");
        List<String> lista = new ArrayList<>();
        lista.add("Pegar Item");
        lista.add("Descartar Item");
        this.setOpcoes(lista);
    }
    
    // pega o item
    public void pegarItem(Pessoa pessoa) {
        //
        pessoa.getMochila().add(this.item);
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
