package s03e01;

public class Controller{
    public static void main(String[] args) {
    Ventilador arno = new Ventilador();
    
    arno.aumentarVelocidade();
    arno.aumentarVelocidade();
    arno.aumentarVelocidade();
    arno.aumentarVelocidade();
    arno.girar();
    arno.showStatus();
    }
}