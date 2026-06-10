import service.CompetitionService;
import service.PlayerService;
import service.TimeService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TimeService timeService = new TimeService();
        PlayerService playerService = new PlayerService(timeService);
        CompetitionService competitionService = new CompetitionService(timeService);

        System.out.println(timeService.cadastrarSelecoes());

        for (int i = 1; i <= 5; i++) {
            System.out.println("\nCadastrando jogadores da Seleção " + timeService.verNomeSelecao(i));
            System.out.println(playerService.cadastrarJodores(i));
        }

        System.out.println(competitionService.gerarPartidas());

        boolean rodando = true;
        while (rodando) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Registrar resultados das partidas");
            System.out.println("2 - Listar partidas");
            System.out.println("3 - Exibir classificacao");
            System.out.println("4 - Ver gols de um jogador");
            System.out.println("5 - Ver gols de uma selecao");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    competitionService.registrarResultadosInterativo();
                    break;
                case 2:
                    competitionService.listarPartidas();
                    break;
                case 3:
                    competitionService.exibirClassificacao();
                    break;
                case 4:
                    System.out.print("Nome do jogador: ");
                    String nomeJogador = sc.nextLine();
                    System.out.print("Nome da selecao: ");
                    String nomeSelecao = sc.nextLine();
                    int gols = playerService.verGolsJogador(nomeJogador, nomeSelecao);
                    System.out.println(gols >= 0 ? nomeJogador + " tem " + gols + " gol(s)." : "Jogador nao encontrado.");
                    break;
                case 5:
                    System.out.print("Nome da selecao: ");
                    String selecao = sc.nextLine();
                    int golsSelecao = timeService.verGolsSelecao(selecao);
                    System.out.println(golsSelecao >= 0 ? selecao + " tem " + golsSelecao + " gol(s) no total." : "Selecao nao encontrada.");
                    break;
                case 0:
                    rodando = false;
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        }

        sc.close();
    }
}