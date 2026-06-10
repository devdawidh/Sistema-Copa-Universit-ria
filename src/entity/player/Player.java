package entity.player;

import entity.selecao.Selecao;

public class Player {

    private String name;
    private int gols;
    private Selecao myTeam;

    public Player(String name, int gols, Selecao myTeam){
        this.name = name;
        this.gols = gols;
        this.myTeam = myTeam;
    }

    public String getName() {
        return name;
    }

    public int getGols() {
        return gols;
    }

    public Selecao getMyTeam() {
        return myTeam;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

    public void setMyTeam(Selecao myTeam) {
        this.myTeam = myTeam;
    }
}
