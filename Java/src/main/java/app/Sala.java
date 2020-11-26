package app;

import main.Main;

public class Sala {
    private String nome;
    private SalaTipo tipo;
    private int tempoMinimoReservaH;//tempo minimo que a sala deve ser locada para permitir a locacao (em horas)
    private static double custoPorHPequena = 400.0;//custo por hora de salas pequenas
    private static double custoPorHGrande = 650.0;//custo por hora de salas grandes
    private static double custoporHAltoRisco = 1200.0;//custo por hora de salas de alto-risco

    public Sala(String nome, SalaTipo tipo){
        if(tipo == SalaTipo.PEQUENA){
            this.nome = nome;
            this.tipo = tipo;
            tempoMinimoReservaH=2;
        }
        else if(tipo== SalaTipo.GRANDE){
            this.nome = nome;
            this.tipo = tipo;
            tempoMinimoReservaH=2;
        }
        else if(tipo == SalaTipo.ALTO_RISCO){
            this.nome = nome;
            this.tipo = tipo;
            tempoMinimoReservaH=3;
        }
        else{
            System.out.println("Tipo nao existente!");
        }
    }

    public String getNome(){
        return this.nome;
    }

    public SalaTipo getTipo(){
        return this.tipo;
    }   
    
    public double getCustoPorH(){
        if(tipo == SalaTipo.PEQUENA){
            return custoPorHPequena;
        }
        else if(tipo == SalaTipo.GRANDE){
            return custoPorHGrande;
        }
        else if(tipo == SalaTipo.ALTO_RISCO){
            return custoporHAltoRisco;
        }
        return 0.0;
    }

    public int getTempoMinimoReservaH(){
        return this.tempoMinimoReservaH;
    }

    public static void setCustoPorHPequena(double valor){
        if(valor>0){
            custoPorHPequena = valor;
            Main.atualizaAlocacoes();
        }
        else System.out.println("Valor inválido!");
    }
    public static void setCustoPorHGrande(double valor){
        if(valor>0){
            custoPorHGrande = valor;
            Main.atualizaAlocacoes();
        }
        else System.out.println("Valor inválido!");
    }
    public static void setCustoPorHAltoRisco(double valor){
        if(valor>0){
            custoporHAltoRisco = valor;
            Main.atualizaAlocacoes();
        }
        else System.out.println("Valor inválido!");
    }

    @Override
    public String toString(){
        return "Nome: "+this.nome+"     Tipo: "+this.tipo+"     Custo por hora: "+this.getCustoPorH();
    }
}
