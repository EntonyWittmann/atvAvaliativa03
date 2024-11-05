public class Estacionamento {
    public int numero;
    public Veiculos veiculos;
    public Vagas vagas;

    public Estacionamento(int numero, Veiculos veiculos, Vagas vagas) {
        this.numero = numero;
        this.veiculos = veiculos;
        this.vagas = vagas;
    }

    @Override
    public String toString() {
        return "Estacionamento{" +
                "numero=" + numero +
                ", veiculos=" + veiculos +
                ", vagas=" + vagas +
                '}';
    }
}
