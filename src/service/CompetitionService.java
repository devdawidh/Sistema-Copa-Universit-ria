package service;

import entity.selecao.Selecao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompetitionService {

    private final TimeService timeService;

    public static class Partida {
        public final Selecao mandante;
        public final Selecao visitante;
        public int golsMandante = -1;
        public int golsVisitante = -1;

        public Partida(Selecao mandante, Selecao visitante) {
            this.mandante = mandante;
            this.visitante = visitante;
        }

        public boolean foiJogada() {
            return golsMandante >= 0 && golsVisitante >= 0;
        }

        @Override
        public String toString() {
            if (foiJogada()) {
                return mandante.getName() + " " + golsMandante
                        + " x " + golsVisitante + " " + visitante.getName();
            }
            return mandante.getName() + " x " + visitante.getName();
        }
    }

    private final List<Partida> partidas = new ArrayList<>();

    public CompetitionService(TimeService timeService) {
        this.timeService = timeService;
    }


    public String gerarPartidas() {
        if (timeService.listaDeTimes.size() < 5) {
            return "Cadastre as 5 seleções antes de gerar as partidas.";
        }

        partidas.clear();

        List<Selecao> times = timeService.listaDeTimes;

        for (int i = 0; i < times.size(); i++) {
            for (int j = 0; j < times.size(); j++) {
                if (i != j) {
                    // Jogo de ida: i x j  |  jogo de volta: j x i
                    partidas.add(new Partida(times.get(i), times.get(j)));
                }
            }
        }

        return "20 partidas geradas com sucesso!";
    }

    public void listarPartidas() {
        if (partidas.isEmpty()) {
            System.out.println("Nenhuma partida gerada ainda.");
            return;
        }
        System.out.println("\n=== Partidas da Competição ===");
        for (int i = 0; i < partidas.size(); i++) {
            System.out.printf("Partida %02d: %s%n", i + 1, partidas.get(i));
        }
    }

    public String registrarResultado(int numeroPartida, int golsMandante, int golsVisitante) {
        if (numeroPartida < 1 || numeroPartida > partidas.size()) {
            return "Número de partida inválido.";
        }
        Partida p = partidas.get(numeroPartida - 1);
        p.golsMandante = golsMandante;
        p.golsVisitante = golsVisitante;

        atualizarPontuacao(p);
        return "Resultado registrado: " + p;
    }

    private void atualizarPontuacao(Partida p) {
        if (p.golsMandante > p.golsVisitante) {
            p.mandante.setPontos(p.mandante.getPontos() + 3);
        } else if (p.golsMandante < p.golsVisitante) {
            p.visitante.setPontos(p.visitante.getPontos() + 3);
        } else {
            p.mandante.setPontos(p.mandante.getPontos() + 1);
            p.visitante.setPontos(p.visitante.getPontos() + 1);
        }
    }

    public void exibirClassificacao() {
        List<Selecao> ranking = new ArrayList<>(timeService.listaDeTimes);
        ranking.sort((a, b) -> b.getPontos() - a.getPontos());

        System.out.println("\n=== Classificação ===");
        System.out.printf("%-5s %-20s %-5s%n", "Pos.", "Seleção", "Pts");
        System.out.println("-".repeat(35));
        for (int i = 0; i < ranking.size(); i++) {
            System.out.printf("%-5d %-20s %-5d%n",
                    i + 1, ranking.get(i).getName(), ranking.get(i).getPontos());
        }
    }

    public void registrarResultadosInterativo() {
        Scanner sc = new Scanner(System.in);
        listarPartidas();

        System.out.println("\nDigite o número da partida para registrar (0 para sair):");
        int escolha = sc.nextInt();

        while (escolha != 0) {
            System.out.print("Gols do mandante: ");
            int gM = sc.nextInt();
            System.out.print("Gols do visitante: ");
            int gV = sc.nextInt();

            System.out.println(registrarResultado(escolha, gM, gV));

            listarPartidas();
            System.out.println("\nDigite o número da partida para registrar (0 para sair):");
            escolha = sc.nextInt();
        }
    }
}