import java.util.Scanner;

public class GestaoEstacionamento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Capacidade diária de atendimento (4 veículos)
        int capacidade = 4;

        // Variáveis para o relatório final
        double totalArrecadado = 0;
        int totalConvencionais = 0;
        int totalEletricos = 0;
        int totalDiarias = 0;

        // Laço 'for' para processar o atendimento de cada veículo
        for (int i = 1; i <= capacidade; i++) {
            System.out.println("\n--- ATENDIMENTO DO VEÍCULO " + i + " DE " + capacidade + " ---");

            System.out.print("Informe o tempo de permanência (em horas inteiras): ");
            int horas = scanner.nextInt();

            System.out.print("Informe o tipo do veículo (1 - Convencional | 2 - Elétrico): ");
            int tipoVeiculo = scanner.nextInt();

            // Validação de Entrada (if/else)
            if (horas <= 0 || (tipoVeiculo != 1 && tipoVeiculo != 2)) {
                System.out.println("Entrada inválida! O tempo de permanência deve ser > 0 e o tipo deve ser 1 ou 2.");
                System.out.println("Repetindo a leitura para este veículo...");
                i--; // Decrementa para repetir a leitura do veículo atual
            }

            // 1. Cálculo do valor base pelas horas (Tabela de Tarifas)
            double valorCobrado = 0.0;

            if (horas == 1) {
                valorCobrado = 10.00; // Até 1 hora: R$ 10,00
            } else if (horas >= 2 && horas <= 3) {
                // De 2 a 3 horas: R$ 10,00 + R$ 5,00 por hora adicional
                valorCobrado = 10.00 + (horas - 1) * 5.00;
            } else {
                // Acima de 3 horas: Diária fixa de R$ 30,00
                valorCobrado = 30.00;
                totalDiarias++; // Contabiliza veículos com diária
            }

            // 2. Aplicação do desconto e contagem usando SWITCH pelo tipo do veículo
            switch (tipoVeiculo) {
                case 1:
                    // Veículo Convencional: sem desconto
                    totalConvencionais++;
                    break;

                case 2:
                    // Veículo Elétrico: 20% de desconto pelo incentivo ecológico
                    valorCobrado *= 0.80;
                    totalEletricos++;
                    break;
            }

            // Soma ao total arrecadado no expediente
            totalArrecadado += valorCobrado;

            System.out.printf("Valor a pagar por este veículo: R$ %.2f\n", valorCobrado);
        }

        // Relatório Consolidado ao final do expediente
        System.out.println("\n==========================================");
        System.out.println("        RELATÓRIO DE FECHAMENTO           ");
        System.out.println("==========================================");
        System.out.println("Total de veículos atendidos: " + capacidade);
        System.out.printf("Total arrecadado no expediente: R$ %.2f\n", totalArrecadado);
        System.out.println("Quantidade de veículos convencionais: " + totalConvencionais);
        System.out.println("Quantidade de veículos elétricos: " + totalEletricos);
        System.out.println("Veículos que utilizaram tarifa diária (> 3h): " + totalDiarias);
        System.out.println("==========================================");

        scanner.close();
    }
}
