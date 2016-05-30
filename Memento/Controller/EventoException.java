package Controller;

public class EventoException extends Exception {
  public EventoException() { super(); }
  public EventoException(String message) { super(message); }
  public EventoException(String message, Throwable cause) { super(message, cause); }
  public EventoException(Throwable cause) { super(cause); }
}
