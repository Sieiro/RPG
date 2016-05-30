package Controller;


/**
 * Write a description of class Mecanica here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mecanica
{
    // instance variables - replace the example below with your own
    private static Pessoa jogador; // jogador atual
    private static boolean vivo; // se o jogador esta vivo ou não
    private static int tempoAtual; // tempo atual (em minutos)
    // private static int diasPassados; // dias passados no jogo
    private static Evento EventoAtual;
    
    // inicia as variaveis básicas do ambiente
    public Mecanica(Pessoa pessoa) {
        this.jogador = pessoa;
        this.vivo = true;
        this.tempoAtual = 0;
    }
    
    // inicia um evento com um numero aleatorio
    public static String iniciarEvento(int opt) {
        //
    }
    
    // opera o evento com um numero escolhido pelo usuario
    public static String operarEvento(int opt) {
        //
    }
    
    // pode encontrar um evento
    public static boolean Explorar() {
        //
    }
    
    public static boolean dormir() {
        //
    }
    
    public static boolean ascenderFogueira() {
        //
    }
}
