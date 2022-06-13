import java.util.Random;

public class Dado {
    private int valor;

    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }

    public Dado() {
        this.valor = valor;
    }
    static public int generacionValorDado(){
        Random r=new Random();
        return (r.nextInt(6)+1);
    }
}
