package Controller;
public class NenhumEvento{
    private String[] opcoes = {"Continuar"};
    
    public NenhumEvento(int opt) {
        super(opt, "Não aconteceu nada enquanto selecionava a opção" + opt);
    }
    
    // continua...
    public void continuar() {
        //
    }
    
    // pega as opções
    public String[] getOpcoes() {
        return this.opcoes;
    }
}
