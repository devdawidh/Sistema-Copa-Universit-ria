package service;

import entity.selecao.Selecao;

import java.util.ArrayList;
import java.util.Scanner;

public class TimeService {
    ArrayList<Selecao> listaDeTimes = new ArrayList<>();

    public String cadastrarSelecoes(){
        Scanner sc = new Scanner(System.in);
        String name;
        System.out.println("Cadastro de Selecao");
            System.out.println("Nome do Time 1");
            name = sc.nextLine();
            Selecao time1 = new Selecao(name, 0, null);
            listaDeTimes.add(time1);
            System.out.println("Nome do Time 2");
            name = sc.nextLine();
            Selecao time2 = new Selecao(name, 0, null);
            listaDeTimes.add(time2);
            System.out.println("Nome do Time 3");
            name = sc.nextLine();
            Selecao time3 = new Selecao(name, 0, null);
            listaDeTimes.add(time3);
            System.out.println("Nome do Time 4");
            name = sc.nextLine();
            Selecao time4 = new Selecao(name, 0, null);
            listaDeTimes.add(time4);
            System.out.println("Nome do Time 5");
            name = sc.nextLine();
            Selecao time5 = new Selecao(name, 0, null);
            listaDeTimes.add(time5);
        return "Times adicionados com sucesso";
    }

    public String verNomeSelecao(int escolha){
        Selecao selecao = findSelecao(escolha);
        if(selecao != null){
           return selecao.getName();
        }else{
            return "Invalido";
        }
    }

    public int verNumIncricaoSelecao(String name){
        int posicao = -1;
        for(int i = 0; i < listaDeTimes.size(); i++){
            if(listaDeTimes.get(i).getName().equalsIgnoreCase(name)){
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

    public Selecao findSelecao(int escolha){
        switch (escolha){
            case 1:
                return listaDeTimes.get(0);
            case 2:
                return listaDeTimes.get(1);
            case 3:
                return listaDeTimes.get(2);
            case 4:
                return listaDeTimes.get(3);
            case 5:
                return listaDeTimes.get(4);
            default:
                return null;
        }
    }

    public int verGolsSelecao(String name){
        int posicao = -1;
        for(int i = 0; i < listaDeTimes.size(); i++){
            if(listaDeTimes.get(i).getName().equalsIgnoreCase(name)){
                posicao = i;
                break;
            }
        }
        if(posicao != -1){
            int totalGols = 0;
            for(int i = 0; i < listaDeTimes.get(posicao).getJogadores().size(); i++){
                totalGols += listaDeTimes.get(posicao).getJogadores().get(posicao).getGols();
            }
            return totalGols;
        }else {
            return -1;
        }
    }

}
