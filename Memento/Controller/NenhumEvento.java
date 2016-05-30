package Controller;
public class NenhumEvento extends Evento {
    public NenhumEvento(int opt) {
        super(opt, "Nenhum Evento encontrado... (opt " + opt + ")");
        List<String> lista = new ArrayList<>();
        lista.add("Continuar");
        setOpcoes(lista);
    }
    
    // retira pontos de vida do jogador
    public void continuar() {
        //
        this.setMensagem("Você continou então sua vida...");
        this.setFimEvento(true);
    }
}
