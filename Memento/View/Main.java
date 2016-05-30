package View;
import Controller.*;
import Model.*;

public class Main {
    private static Mecanica mecanica;
    private static int opt;
    private static String arg;

    public Main() {

    }

    public static void main() {
        imprimir(" - Memento - v1.0.a");
        imprimir("Digite qual classe deverá ser (1) Mago (2) Cavaleiro: ");
        this.opt = Keyboard.readInt();
        Pessoa pessoa;
        if(opt == 1) pessoa = new Mago();
        else if(opt == 2) pessoa = new Cavaleiro();
        imprimir("Digite seu nome: ");
        this.arg = Keyboard.readString();
        pessoa.setNome(arg);
        this.mecanica = Mecanica.getInstancia(pessoa);
        mecanica.iniciarEvento(new EventoPadrao(0));
        run();
    }

    public static void run() {
        while(mecanica.temEventos()) {
            int i=1;
            imprimir("Digite sua opção:");
            List<String> opcoes = mecanica.getOpcoes();
            for(String str : opcoes) {
                imprimir("" + i + ". " + str);
            }
            imprimir("");
            opt = Keyboard.readInt();
            mecanica.operarEvento(opt);
            imprimir(mecanica.getMessage());
        }
    }

    public void imprimir(String msg) {
        System.out.println(msg);
    }
}
