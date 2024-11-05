import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static float horarioFinal = 0;
    static float valor = 0;
    static List<Vagas> vagas = new ArrayList<>();
    static List<Veiculos> veiculos = new ArrayList<>();
    static List<Estacionamento> estacionamentos = new ArrayList<>();
    static List<Historico> historicos = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("Seja bem vindo! escolha a opção que deseja:");
        System.out.println("1. Cadastrar vagas.\n2. Cadastrar veiculo.\n3. Ocupar uma vaga.\n4. Saida de veiculo.\n5. Gerar um relatorio.\n6. Mostrar historico.\n7. Sair.");
        int escolha = sc.nextInt();
        switch (escolha) {
            case 1:
                cadastrarVaga();
                break;
            case 2:
                cadastrarVeiculo();
                break;
            case 3:
                ocuparVaga();
                break;
            case 4:
                saidaDeVeiculos();
                break;
            case 5:
                gerarRelatorio();
                break;
            case 6:
                mostrarHistorico();
                break;
            case 7:
                System.out.println("Saindo do sistema!");
                break;
        }
    }

    public static void cadastrarVaga() {
        boolean disponivel;
        String tamanho;
        System.out.println("Vamos cadastrar uma vaga!");
        System.out.println("Digite o numero da vaga:");
        int numeroVaga = sc.nextInt();
        System.out.println("Digite o tamanho da vaga\n1. Para pequena.\n2. Para media.\n3. Para grande.");
        int tamanhoVaga = sc.nextInt();
        switch (tamanhoVaga) {
            case 1: tamanho = "pequeno";
            break;
            case 2: tamanho = "medio";
            break;
            case 3: tamanho = "grande";
            break;
            default: System.out.println("Tamanho invalido! Tente novamente.");
            return;
        }
        System.out.println("Esta vaga esta disponivel?\n1. Para sim.\n2. Para não.");
        int escolha = sc.nextInt();
        if (escolha == 1) {
            disponivel = true;

            Vagas vaga = new Vagas(numeroVaga, tamanho, disponivel);
            vagas.add(vaga);
        }
        else if (escolha == 2) {
            disponivel = false;

            Vagas vaga = new Vagas(numeroVaga, tamanho, disponivel);
            vagas.add(vaga);
        }

        menu();
    }

    public static void cadastrarVeiculo() {
        String tamanho;
        System.out.println("Vamos cadastrar uma veiculo!");
        System.out.println("Digite a placa do veiculo:");
        String placa = sc.next();
        System.out.println("Digite o modelo do veiculo:");
        String modelo = sc.next();
        System.out.println("Digite o tamanho do veiculo:\n1. Para pequeno\n2. Para medio\n3. Para grande.");
        int tamanhoVeiculo = sc.nextInt();
        switch (tamanhoVeiculo) {
            case 1: tamanho = "pequeno";
                break;
            case 2: tamanho = "medio";
                break;
            case 3: tamanho = "grande";
                break;
            default: System.out.println("Tamanho invalido! Tente novamente.");
                return;
        }

        Veiculos veiculo = new Veiculos(placa, modelo, tamanho);
        veiculos.add(veiculo);

        menu();
    }

    public static void ocuparVaga() {
        int numero = 0;
        Veiculos veiculoSelecionado = null;
        Vagas vagasOcupadas = null;
        boolean deuCerto = false;

        System.out.println("Vamos ocupar uma vaga!");
        System.out.println("Digite a placa do seu veiculo:");
        mostrarVeiculo();
        String placa = sc.next();
        while (!deuCerto) {
            for (Veiculos veiculo : veiculos) {
                if (Objects.equals(placa, veiculo.placa)) {
                    veiculoSelecionado = veiculo;
                    deuCerto = true;
                }
            }
        }
        System.out.println("Digite o numero da vaga que deseja ocupar:");
        for (Vagas vaga: vagas) {
            if (Objects.equals(vaga.tamanho, veiculoSelecionado.tamanho)) {
                System.out.println(vaga);
            }
        }
        int vagaSelecionada = sc.nextInt();
        deuCerto = false;
        while (!deuCerto) {
            for (Vagas vaga: vagas) {
                if ((vagaSelecionada == vaga.numVagas) && (veiculoSelecionado.tamanho.equals(vaga.tamanho))){
                    vagasOcupadas = vaga;
                    deuCerto = true;
                }
            }
            if (vagasOcupadas == null){
                System.out.println("Tamanho de vaga incompativel!");
            }
        }
        System.out.println("Digite o horario de entrada do veiculo:");
        float horarioEntrada = sc.nextFloat();
        System.out.println("Digite o horario de saida do veiculo:");
        float horarioSaida = sc.nextFloat();
        horarioFinal = horarioSaida - horarioEntrada;
        if (horarioFinal <= 1) {
            valor = 5;
        }
        else if ((horarioFinal > 1) && (horarioFinal <= 3)) {
            valor = 10;
        }
        else if (horarioFinal > 3) {
            valor = 15;
        }

        Historico historico = new Historico(veiculoSelecionado.placa, horarioEntrada, horarioSaida, valor);
        historicos.add(historico);
        Estacionamento estacionamento = new Estacionamento(numero, veiculoSelecionado, vagasOcupadas);
        estacionamentos.add(estacionamento);

        menu();
    }

    public static void saidaDeVeiculos() {
        boolean deuCerto = false;
        System.out.println("Digite o placa do veiculo:");
        mostrarVeiculo();
        String placa = sc.next();
        System.out.println("Digite o horario de saida do veiculo:");
        float horarioSaida = sc.nextFloat();
        while (!deuCerto) {
            for (Historico historico : historicos) {
                if (horarioSaida != historico.horarioSaida) {
                    System.out.println("Erro! Horario de Saida incompativel, digite o mesmo horario de saida do cadastro!");
                } else if (horarioSaida == historico.horarioSaida) {
                    deuCerto = true;
                }
            }
        }
        for (Estacionamento estacionamento : estacionamentos) {
            if (Objects.equals(placa, estacionamento.veiculos.placa)) {
                for (Vagas vaga : vagas) {
                    vaga.disponibilidade = true;
                }
            }
        }
        System.out.println("O tempo total de permanencia foi de:" + horarioFinal);
        System.out.println("O valor total foi de:" + valor);
        System.out.println("Tudo certo! Boa viagem!");

        menu();
    }

    public static void gerarRelatorio() {
        System.out.println("Vagas ocupadas:");
        if (estacionamentos.isEmpty()) {
            System.out.println("Nenhuma vaga esta ocupada!");
            menu();
        }
        for (Estacionamento estacionamento : estacionamentos) {
            if (estacionamento.vagas.disponibilidade != false) {
                System.out.println("Numero da vaga:" + estacionamento.vagas.numVagas + "\nTamanho da vaga:" + estacionamento.vagas.tamanho + "Placa do veiculo:" + estacionamento.veiculos.placa);
            }
        }
        menu();
    }

    public static void mostrarHistorico() {
        for (Historico historico: historicos){
            System.out.println(historico);
        }
        menu();
    }


    public static void mostrarVeiculo() {
        for (Veiculos veiculo: veiculos) {
            System.out.println(veiculo.toString());
        }
    }
}
