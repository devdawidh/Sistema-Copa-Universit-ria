package entity.selecao;

import entity.player.Player;

import java.util.List;

public class Selecao {
    private String name;
    private int pontos;
    private List<Player> jogadores;

    public Selecao(String name, int pontos, List<Player> jogadores){
        this.name = name;
        this.pontos = pontos;
        this.jogadores = jogadores;
    }

    public int getPontos() {
        return pontos;
    }

    public String getName() {
        return name;
    }

    public List<Player> getJogadores() {
        return jogadores;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void setJogadores(List<Player> jogadores) {
        this.jogadores = jogadores;
    }
}
