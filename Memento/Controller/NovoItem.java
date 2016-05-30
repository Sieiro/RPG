package Controller;
public class NovoItem extends Evento {
    private String[] opcoes = {"Pegar Item", "Descartar Item"};
    
    public NovoItem(int opt) {
        super(opt, "Você encontrou um item enquanto selecionava a opção" + opt);
    }
    
    // pega o item
    public void pegarItem(Pessoa pessoa) {
        //
    }
    
    // descarta o item
    public void descartarItem() {
        //
    }
    
    public String[] getOpcoes() {
        return this.opcoes;
    }
}
