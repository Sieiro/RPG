package Controller;
import java.util.Random;
import Model.*;
public class Mecanica{
    private static Pessoa jogador; // jogador atual
    private static boolean vivo; // se o jogador esta vivo ou não
    private static int tempoAtual; // tempo atual (em minutos)
    private static Evento eventoAtual; // evento atual, se tiver um evento
    Random rand;
    
    // inicia as variaveis básicas do ambiente
    public Mecanica(Pessoa pessoa){
        this.jogador = pessoa;
        this.vivo = true;
        this.tempoAtual = 0;
    }
    
    // inicia um evento com um numero da ação previa feita
    public  Evento iniciarEvento(int opt){
        //
        this.eventoAtual = gerarEvento(opt);
        return this.eventoAtual;
    }
    
    // opera o evento com um numero escolhido pelo usuario
    public static Evento operarEvento(int opt){
        //
    }
    
    // pode encontrar um evento
    public static boolean explorar(){
        //
    }
    
    // pode encontrar um evento
    public static boolean dormir(){
        //
    }
    
    // pode encontrar um evento
    public static boolean ascenderFogueira(){
        //
    }
    
    // gera o evento com base na opção selecionada
    public static Evento gerarEvento(int opt){
        // opt (1) Checar info (2) dormir (3) ascender fogueira (4) explorar (5) Sair do jogo
        int chance = gerarNumero(0, 100);
        switch(opt) {
            case 1:
                // checar info
                return new Info();
            case 2:
                // dormir
                if(chance < 10)
                    return new Batalha(opt);
                if(chance < 40)
                    return new DiminuirSanidade(opt);
                return new NennhumEvento(opt); // não aconteceu nada
            case 3:
                // ascender fogueira
                if(chance < 10)
                    return new Batalha(opt);
                if(chance < 40)
                    return new DiminuirSanidade(opt);
                return new NennhumEvento(opt); // não aconteceu nada
            case 4:
                // explorar
                if(chance < 15)
                    return new Batalha(opt);
                if(chance < 30)
                    return new Armadilha(opt);
                if(chance < 45)
                    return new NovoItem(opt);
                if(chance < 60)
                    return new DiminuirSanidade(opt);
                return new NennhumEvento(opt); // não aconteceu nada
            case 5:
                return new Sair();
        }
    }
    
    
    public static int gerarNumero(int min, int max){
        return rand.nextInt((max - min) + 1) + min;
    }
    // 
}
