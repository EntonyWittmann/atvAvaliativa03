public class Veiculos {
    public String placa;
    public String modelo;
    public String tamanho;

    public Veiculos(String placa, String modelo, String tamanho) {
        this.placa = placa;
        this.modelo = modelo;
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Veiculos{" +
                "placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", tamanho='" + tamanho + '\'' +
                '}';
    }
}
