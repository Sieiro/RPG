package Controller;
public class Armadilha extends Evento {
    public Armadilha(int opt) {
        super(opt, "Armadilha encontrada (opt " + opt + ")");
        List<String> lista = new ArrayList<>();
        lista.add("Continuar");
        setOpcoes(lista);
    }
    
    // retira pontos de vida do jogador
    public void continuar(Pessoa pessoa) {
        //
        pessoa.setVida(pessoa.getVida() - 10);
        this.setMensagem("Você perde vida!");
        this.setFimEvento(true);
    }
}
