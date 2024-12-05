public class Veiculo {
    String placa;
    String marca;
    String modelo;
    double valor;

    public Veiculo(String placa, String marca, String modelo, double valor) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.valor = valor;
    }

    
    public String toString() {
        return "Placa: " + placa + ", Marca: " + marca + ", Modelo: " + modelo + ", Valor: R$ " + valor;
    }
}