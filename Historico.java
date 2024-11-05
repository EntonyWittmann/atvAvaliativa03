public class Historico {
    public String placa;
    public float horarioEntrada;
    public float horarioSaida;
    public float valorPago;

    public Historico(String placa, float horarioEntrada, float horarioSaida, float valorPago) {
        this.placa = placa;
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
        this.valorPago = valorPago;
    }

    @Override
    public String toString() {
        return "Historico{" +
                "placa='" + placa + '\'' +
                ", horarioEntrada=" + horarioEntrada +
                ", horarioSaida=" + horarioSaida +
                ", valorPago=" + valorPago +
                '}';
    }
}
