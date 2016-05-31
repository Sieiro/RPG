package Controller;
import Model.*;
import java.util.ArrayList;
public class DiminuirSanidade extends Evento{
    public DiminuirSanidade(int opt) {
        super(opt, "");
        setMensagem(gerarLugar());
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Continuar");
        setOpcoes(lista);
    }
    
    public void continuar() {
        Pessoa pessoa = Mecanica.getInstancia().getJogador();
        pessoa.setSanidade(pessoa.getSanidade() - Mecanica.getInstancia().gerarNumero(25, 50));
        this.setMensagem("Você continou então sua vida...");
        this.setFimEvento(true);
    }
    
    public String gerarLugar() {
        int chance = Mecanica.getInstancia().gerarNumero(1,4);
        switch(chance) {
            case 1:
                return "Foi encontrado ruinas de uma casa que aparentava ter sido insendiada.";
            case 2:
                return "Encontrado ruinas de uma cidade antiga";
            case 3:
                return "Avistado pegadas de um animal desconhecido";
            default:
                return "Encontrado pedaços de roupa, rasgadas e sujas, pelo caminho.";
        }
    }
}
