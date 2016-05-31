package Controller;
import Model.*;
import java.util.ArrayList;
public class NovoItem extends Evento {
    private Item item;
    
    public NovoItem(int opt) {
        super(opt, "");
        this.item = new Consumivel("Poção.", "Recupera vida.");
        setMensagem("Item encontrado: " + item.getNome() + "!");
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("Pegar Item");
        lista.add("Descartar Item");
        this.setOpcoes(lista);
    }
    
    // pega o item
    public void pegarItem() {
        //
        //Mochila.getInstancia().add(this.item);
        Pessoa pessoa = Mecanica.getInstancia().getJogador();
        int vidaAnterior = pessoa.getVida();
        pessoa.setVida(pessoa.getVida() + Mecanica.getInstancia().gerarNumero(20,50));
        if(pessoa instanceof Mago && pessoa.getVida() > 250) {
            pessoa.setVida(250);
        }
        else if(pessoa instanceof Cavaleiro && pessoa.getVida() > 300) {
            pessoa.setVida(300);
        }
        this.setFimEvento(true);
        this.setMensagem("Você conseguiu: " + item.getNome() + " e a usou recuperando: " + (pessoa.getVida() - vidaAnterior) + "(" + pessoa.getVida() + ")");
    }
    
    // descarta o item
    public void descartarItem() {
        //
        this.setFimEvento(true);
        this.setMensagem("Você descartou o item.");
    }
}
