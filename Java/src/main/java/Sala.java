public class Sala {
    private String nome;
    private String tipo;
    private int tempoMinimoReservaH;//tempo minimo que a sala deve ser locada para permitir a locacao (em horas)
    private static double custoPorHPequena = 400.0;//custo por hora de salas pequenas
    private static double custoPorHGrande = 650.0;//custo por hora de salas grandes
    private static double custoporHAltoRisco = 1200.0;//custo por hora de salas de alto-risco

    public Sala(String nome, String tipo){
        if(tipo.equalsIgnoreCase("pequena")){
            this.nome = nome;
            this.tipo = tipo;
            tempoMinimoReservaH=2;
        }
        else if(tipo.equalsIgnoreCase("grande")){
            this.nome = nome;
            this.tipo = tipo;
            tempoMinimoReservaH=2;
        }
        else if(tipo.equalsIgnoreCase("alto-risco")){
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

    public String getTipo(){
        return this.tipo;
    }   
    
    public double getCustoPorH(){
        if(tipo.equalsIgnoreCase("pequena")){
            return custoPorHPequena;
        }
        else if(tipo.equalsIgnoreCase("grande")){
            return custoPorHGrande;
        }
        else if(tipo.equalsIgnoreCase("alto-risco")){
            return custoporHAltoRisco;
        }
        return 0.0;
    }

    public int getTempoMinimoReservaH(){
        return this.tempoMinimoReservaH;
    }

    public void setCustoPorHPequena(double valor){
        if(valor>0){
            custoPorHPequena = valor;
            Main.atualizaAlocacoes();
        }
        else System.out.println("Valor inválido!");
    }
    public void setCustoPorHGrande(double valor){
        if(valor>0){
            custoPorHGrande = valor;
            Main.atualizaAlocacoes();
        }
        else System.out.println("Valor inválido!");
    }
    public void setCustoPorHAltoRisco(double valor){
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
