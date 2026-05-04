package BoardGame;

public class Descuento {

    // Atributos
    private double valor;
    private boolean usado;

    // Constructor
    public Descuento(double valor) {
        this.valor = valor;
        this.usado = false; 
    }


    public double aplicarDescuento(double totalCompra) {

        if (usado) {
            System.out.println("El descuento ya fue usado");
            return totalCompra;
        }

        double totalFinal = totalCompra - valor;

        if (totalFinal < 0) {
            totalFinal = 0;
        }

        usar(); 

        return totalFinal;
    }

    public void usar() {
        this.usado = true;
    }

    public boolean estaUsado() {
        return usado;
    }


    public double getValor() {
        return this.valor;
    }


    public boolean esValido() {
        return !usado;
    }
}
