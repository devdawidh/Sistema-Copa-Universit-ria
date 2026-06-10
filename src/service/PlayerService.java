package service;

import entity.player.Player;
import entity.selecao.Selecao;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerService {
    private TimeService timeService;
    ArrayList<Player> listaDeJogador = new ArrayList<>();

    public PlayerService(TimeService timeService) {
        this.timeService = timeService;
    }

    public String cadastrarJodores(int selecao){
        Selecao myTeam = timeService.findSelecao(selecao);
        Scanner sc = new Scanner(System.in);
        String name;
        System.out.println("Cadastro de Jogadores");
        System.out.println("Nome do Jogador 1");
        name = sc.nextLine();
        Player Jogador1 = new Player(name, 0, myTeam);
        listaDeJogador.add(Jogador1);
        System.out.println("Nome do Jogador 2");
        name = sc.nextLine();
        Player Jogador2 = new Player(name, 0, myTeam);
        listaDeJogador.add(Jogador2);
        System.out.println("Nome do Jogador 3");
        name = sc.nextLine();
        Player Jogador3 = new Player(name, 0, myTeam);
        listaDeJogador.add(Jogador3);
        System.out.println("Nome do Jogador 4");
        name = sc.nextLine();
        Player Jogador4 = new Player(name, 0, myTeam);
        listaDeJogador.add(Jogador4);
        System.out.println("Nome do Jogador 5");
        name = sc.nextLine();
        Player Jogador5 = new Player(name, 0, myTeam);
        listaDeJogador.add(Jogador5);
        System.out.println("Nome do Jogador 6");
        name = sc.nextLine();
        Player Jogador6 = new Player(name, 0, myTeam);
        listaDeJogador.add(Jogador6);
        System.out.println("Nome do Jogador 7");
        name = sc.nextLine();
        Player Jogador7 = new Player(name, 0, myTeam);
        listaDeJogador.add(Jogador7);
        System.out.println("Nome do Jogador 8");
        name = sc.nextLine();
        Player Jogador8 = new Player(name, 0, myTeam);
        listaDeJogador.add(Jogador8);
        System.out.println("Nome do Jogador 9");
        name = sc.nextLine();
        Player Jogador9 = new Player(name, 0, myTeam);
        listaDeJogador.add(Jogador9);
        System.out.println("Nome do Jogador 10");
        name = sc.nextLine();
        Player Jogador10 = new Player(name, 0, myTeam);
        listaDeJogador.add(Jogador10);
        System.out.println("Nome do Jogador 11");
        name = sc.nextLine();
        Player Jogador11 = new Player(name, 0, myTeam);
        listaDeJogador.add(Jogador11);
        myTeam.setJogadores(listaDeJogador);
        return "Jogadors adicionados com sucesso";
    }

    public String verNomeJogador(int selecao, int numeroDoJogador){
        Selecao myTeam = timeService.findSelecao(selecao);
        return myTeam.getJogadores().get(numeroDoJogador-1).getName();
    }

    public int verNumIncricaoJogar(String nameJogador, String nameSelecao){
        Selecao selecao = timeService.findSelecao(timeService.verNumIncricaoSelecao(nameSelecao));
        int posicao = -1;
        for(int i = 0; i < selecao.getJogadores().size(); i++){
            if(selecao.getJogadores().get(i).getName().equalsIgnoreCase(nameJogador)){
                posicao = i;
                break;
            }
        }
        if(posicao != -1){
            return posicao;
        }else {
            return -1;
        }
    }

    public int verGolsJogador(String nameJogador, String nameSelecao){
        Selecao selecao = timeService.findSelecao(timeService.verNumIncricaoSelecao(nameSelecao));
        int posicao = -1;
        for(int i = 0; i < selecao.getJogadores().size(); i++){
            if(selecao.getJogadores().get(i).getName().equalsIgnoreCase(nameJogador)){
                posicao = i;
                break;
            }
        }
        if(posicao != -1){
            return selecao.getJogadores().get(posicao).getGols();
        }else {
            return -1;
        }
    }
}
