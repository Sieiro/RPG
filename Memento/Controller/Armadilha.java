package Controller;
public class Armadilha extends Evento {
    private String[] opcoes = {"Continuar"};
    
    public Armadilha(int opt) {
        super(opt, "Você encontrou uma armadilha enquanto selecionava a opção" + opt);
    }
    
    // retira pontos de vida do jogador
    public void continuar(Pessoa pessoa) {
        //
    }
    
    // pega as opções
    public String[] getOpcoes() {
        return this.opcoes;
    }
}
