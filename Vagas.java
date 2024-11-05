public class Vagas {
    public int numVagas;
    public String tamanho;
    public boolean disponibilidade;

    public Vagas(int numVagas, String tamanho, boolean disponibilidade) {
        this.numVagas = numVagas;
        this.tamanho = tamanho;
        this.disponibilidade = disponibilidade;
    }

    @Override
    public String toString() {
        return "Vagas{" +
                "numVagas=" + numVagas +
                ", tamanho='" + tamanho + '\'' +
                ", disponibilidade=" + disponibilidade +
                '}';
    }
}
