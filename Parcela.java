public class Parcela {
    private double valorBase;
    private int mes;

    public Parcela(double valorBase, int mes) {
        this.valorBase = valorBase;
        this.mes = mes;
    }

    public double getValorBase() {
        return valorBase;
    }

    public int getMes() {
        return mes;
    }

    @Override
    public String toString() {
        double valorComJuros = valorBase * (1 + 0.01 * mes);
        return String.format("Parcela %d: R$ %.2f", mes, valorComJuros);
    }
}