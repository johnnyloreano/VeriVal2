package main;

import app.Alocacao;
import app.Medico;
import app.Sala;
import app.SalaTipo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class Main {
    private static ArrayList<Alocacao> alocacoes = new ArrayList<Alocacao>();
    private static ArrayList<Medico> medicos = new ArrayList<Medico>();
    private static ArrayList<Sala> salas = new ArrayList<Sala>();
    private static Scanner in = new Scanner(System.in);
    private static boolean dataValida;//boolean para checar se a data inserida foi valida durante as interacoes com o usuario
    public static void main(String[] args){
        //mockando salas, medicos e alocacoes
        mockandoDados();
        //interface com usuario
        while(true){
            mostraOpcoes();
            int input = inputInt(0,8,"Escolha uma opcao de 0 a 8.");
            if(input==1) trataOpcao1();
            else if(input==2) trataOpcao2();
            else if(input==3) trataOpcao3();
            else if(input==4) trataOpcao4();
            else if(input==5) trataOpcao5();
            else if(input==6) trataOpcao6();
            else if(input==7) trataOpcao7();
            else if(input==8) trataOpcao8();
            else if(input==0) {
                System.out.println("Finalizando programa...");
                System.exit(0);
                break;
            }
        }
    }

    private static void trataOpcao1(){
        //mostra a lista de medicos cadastrados
        System.out.println(medicos);
        triggerVoltarParaOMenu();
    }

    private static void trataOpcao2(){
        //mostra a lista de salas por tipo
        int input = inputInt(1, 3, "Escolha o tipo de sala: 1- pequena;  2-grande;  3- alto-risco");
        SalaTipo escolha = null;
        if(input==1) escolha = SalaTipo.PEQUENA;
        else if(input==2) escolha = SalaTipo.GRANDE;
        else if(input==3) escolha = SalaTipo.ALTO_RISCO;
        for(Sala s:salas) {
            if(s.getTipo() == (escolha)) System.out.println(s);
        }
        triggerVoltarParaOMenu();
    }

    private static void trataOpcao3(){
        //mostrar alocacoes presentes em um intervalo de tempo determinado pelo usuario
        dataValida = true;//se uma das datas for invalida vira false e volta para o menu.
        //coletar data inicial e final do usuario.
        System.out.println("Insira a data inicial para a busca (aaaa/mm/dd/hh/mm):");
        Calendar i=escolheData(in.nextLine());

        System.out.println("Insira a data final para a busca (aaaa/mm/dd/hh/mm):");
        Calendar f = escolheData(in.nextLine());

        if(dataValida){
            for(Alocacao a:alocacoes){
                /*Se o inicio da alocacao for depois do inicio da busca ou se o fim da alocacao for
                antes do fim da busca ou se o inicio for igual ao inicio da alocao ou se o fim
                for igual ao fim da alocacao. Significa que os dois intervalos de tempo se sobrepoem pelo
                menos parcialmente, ou seja os dois coexistem, entao a alocacao esta no intervalo de tempo
                desejado pelo usuario e deve ser printada.*/
                if(checaCoincideHorario(a,i,f)) System.out.println(a);
            }
        }
        triggerVoltarParaOMenu();
    }

    private static void trataOpcao4(){
        //mostrar cada medico e seus respectivos gastos.
        double[] gastos = new double[medicos.size()];
        for(Alocacao a:alocacoes){
            if(a.getFim().before(new GregorianCalendar())){
                //se a locacao foi no passado, representa um gasto, entao achar o medico e atribuir o custo
                for(int i = 0;i<medicos.size();i++){
                    if(a.getResponsavel().getCrm().equalsIgnoreCase(medicos.get(i).getCrm())){
                        gastos[i] += a.getCusto();
                    }
                }
            }
        }
        System.out.println("Gastos por medico: ");
        for(int i = 0;i<medicos.size();i++){
            System.out.println("app.Medico: "+medicos.get(i).getNome()+"   gastos: "+gastos[i]);
        }
        triggerVoltarParaOMenu();
    }

    private static void trataOpcao5(){
        //mostrar cada sala e seus respectivos custos
        double[] gastos = new double[salas.size()];
        for(Alocacao a:alocacoes){
            if(a.getFim().before(new GregorianCalendar())){
                //se a locacao foi no passado, representa um gasto, entao achar a sala e atribuir o custo
                for(int i = 0;i<salas.size();i++){
                    if(a.getSala().getNome().equalsIgnoreCase(salas.get(i).getNome())){
                        gastos[i] += a.getCusto();
                    }
                }
            }
        }
        System.out.println("Gastos por sala: ");
        for(int i = 0;i<salas.size();i++){
            System.out.println("app.Medico: "+salas.get(i).getNome()+"   gastos: "+gastos[i]);
        }
        triggerVoltarParaOMenu();
    }

    private static void trataOpcao6(){
        //usuario reservando uma sala
        System.out.println("Escolha o medico responsavel: ");
        int medicoEscolha = escolheMedico();
        System.out.println("Escolha a sala desejada:");
        int salaEscolha = escolheSala();
        dataValida = true;
        System.out.println("Escolha a data de inicio (aaaa/mm/dd/hh/mm): ");
        Calendar i = escolheData(in.nextLine());
        System.out.println("Escolha a data de termino (aaaa/mm/dd/hh/mm): ");
        Calendar f = escolheData(in.nextLine());
        try{
            alocacoes.add(new Alocacao(medicos.get(medicoEscolha),salas.get(salaEscolha),i,f));
            System.out.println("Reserva feita com sucesso.");
        }
        catch(IllegalArgumentException e){
            System.out.println("A reserva nao pode ser criada porque o horario esta indisponivel ou o medico nao tem permissao para este tipo de sala.");
        }
        triggerVoltarParaOMenu();
    }

    private static void trataOpcao7(){
        //excluir uma reserva (somente futuro)
        //exibir opcoes
        for(int i = 0;i<alocacoes.size();i++){
            System.out.println(i+": \\/\\/\\/\\/\\/"+alocacoes.get(i));
        }
        int escolha = inputInt(0, alocacoes.size()-1, "Escolha uma reserva da lista de alocacoes acima, para ser deletada (inserindo o numero): ");
        if(alocacoes.get(escolha).getInicio().after(new GregorianCalendar())){
            //se o inicio da alocacao for depois de agora, ela eh uma reserva e pode ser deletada.
            alocacoes.remove(escolha);
            System.out.println("Reserva removida com sucesso.");
        }
        else{
            System.out.println("Esta alocacao ja aconteceu ou esta em andamento, e por isso nao pode ser deletada.");
        }
        triggerVoltarParaOMenu();
    }

    private static void trataOpcao8(){
        int escolha = inputInt(1, 3, "Escolha o tipo de sala para alterar o custo por hora: 1- pequena;  2-  grande;  3- alto-risco");
        double novoCusto = inputDouble(0.0, Double.MAX_VALUE, "Insira o novo custo: ");
        if(escolha==1)Sala.setCustoPorHPequena(novoCusto);
        else if(escolha==2)Sala.setCustoPorHGrande(novoCusto);
        else if(escolha==3)Sala.setCustoPorHAltoRisco(novoCusto);
        triggerVoltarParaOMenu();
    }

    private static boolean checaCoincideHorario(Alocacao a, Calendar i, Calendar f){
        /*retorna true se a alocacao 'a' estiver completa ou parcialmente dentro do intervalo de tempo de i a f
        ou se o intervalo de tempo de i a f estiver completa ou parcialmente dentro do intervalo de tempo da
        alocacao 'a'.
        */
         return (((a.getInicio().after(i) && a.getInicio().before(f)) || (a.getFim().before(f) && a.getFim().after(i)) ||
                 a.getInicio().equals(i) || a.getFim().equals(f)) ||
                 (i.after(a.getInicio()) && i.before(a.getFim()) || (f.before(a.getFim()) && f.after(a.getInicio()))));
    }

    private static double inputDouble(double min, double max, String msg){
        double ret=0;
        do{
            System.out.println(msg);
            try{
                ret = Double.parseDouble(in.nextLine());
            }
            catch(Exception e){
                System.out.println("O sistema esperava um double, mas o usuario passou outro tipo.");
                ret=min-1;
            }

        }while(ret<min || ret>max);
        return ret;
    }

    private static int escolheMedico(){
        for(int i = 0;i<medicos.size();i++){
            System.out.println(i+": "+medicos.get(i));
        }
        return inputInt(0, medicos.size()-1, "Insira o numero do medico: ");
    }

    private static int escolheSala(){
        for(int i = 0;i<salas.size();i++){
            System.out.println(i+": "+salas.get(i));
        }
        return inputInt(0, salas.size()-1, "Insira o numero da sala: ");
    }

    private static Calendar escolheData(String data){
        System.out.println(data);
        Calendar d = Calendar.getInstance();
        try{
            d = criarData(Integer.parseInt(data.substring(0,4)),Integer.parseInt(data.substring(5,7)),
            Integer.parseInt(data.substring(8,10)),Integer.parseInt(data.substring(11,13)),
            Integer.parseInt(data.substring(14,16)));
        }
        catch(Exception e){
            System.out.println("Data invalida");
            dataValida=false;
        }
        return d;
    }

    private static void triggerVoltarParaOMenu(){
        /*Espera o usuario inserir qualquer coisa para voltaro ao menu. Isto serve para nao printar
        o menu enquanto o usuario esta lendo a informacao que pediu.*/
        System.out.println("Insira algo como input para retornar ao menu. (qualquer coisa)");
    }

    private static void mostraOpcoes(){
        //exibir as opcoes que o usuario tem
        System.out.println("**********************************************************************************************************************************");
        System.out.println("1- Visualizar lista de medicos.");
        System.out.println("2- Visualizar lista de salas.");
        System.out.println("3- Visualizar lista de alocacoes.");
        System.out.println("4- Visualizar relatorio de gastos por medico.");
        System.out.println("5- Visualizar relatorio de gastos por sala.");
        System.out.println("6- Reservar sala.");
        System.out.println("7- Excluir reserva.");
        System.out.println("8- Alterar custo por hora de algum tipo de sala.");
        System.out.println("0- Finalizar programa.");
        System.out.println("**********************************************************************************************************************************");
    }

    private static void mockandoDados(){
        //mocando as 10 salas e 5 medicos obrigatorios, e mais algumas alocacoes.
        salas.add(new Sala("alpha",SalaTipo.ALTO_RISCO));
        salas.add(new Sala("beta",SalaTipo.GRANDE));
        salas.add(new Sala("celta",SalaTipo.PEQUENA));
        salas.add(new Sala("delta",SalaTipo.ALTO_RISCO));
        salas.add(new Sala("echo",SalaTipo.GRANDE));
        salas.add(new Sala("foxtrot",SalaTipo.PEQUENA));
        salas.add(new Sala("golf",SalaTipo.ALTO_RISCO));
        salas.add(new Sala("hotel",SalaTipo.GRANDE));
        salas.add(new Sala("india",SalaTipo.PEQUENA));
        salas.add(new Sala("juliet",SalaTipo.ALTO_RISCO));
        medicos.add(new Medico("25500","Luis Roberto","Dermatologista"));
        medicos.add(new Medico("110723","Julia Huberts","Neurologista"));
        medicos.add(new Medico("15050","Adao Rubens","Cirurgiao cardiovascular"));
        medicos.add(new Medico("27328","Marina Souza","Ortopedista"));
        medicos.add(new Medico("3852","Rogerio Almeida","Gastroenterologista"));
        alocacoes.add(new Alocacao(medicos.get(4),salas.get(8),criarData(2020,10,7,9,45),criarData(2020,10,7,15,50)));
        alocacoes.add(new Alocacao(medicos.get(0),salas.get(2),criarData(2020,10,30,9,15),criarData(2020,10,30,12,00)));
        alocacoes.add(new Alocacao(medicos.get(3),salas.get(0),criarData(2020,11,12,8,45),criarData(2020,11,12,12,35)));
        alocacoes.add(new Alocacao(medicos.get(2),salas.get(0),criarData(2020,5,12,8,45),criarData(2020,5,12,15,35)));
        alocacoes.add(new Alocacao(medicos.get(4),salas.get(2),criarData(2020,11,15,16,45),criarData(2020,11,15,19,35)));
        alocacoes.add(new Alocacao(medicos.get(0),salas.get(5),criarData(2020,12,16,13,00),criarData(2020,12,16,17,35)));
        alocacoes.add(new Alocacao(medicos.get(2),salas.get(6),criarData(2020,2,2,8,10),criarData(2020,2,2,12,00)));
        alocacoes.add(new Alocacao(medicos.get(0),salas.get(5),criarData(2020,12,18,13,00),criarData(2020,12,18,18,35)));
        alocacoes.add(new Alocacao(medicos.get(3),salas.get(6),criarData(2020,5,12,17,35),criarData(2020,5,12,20,40)));
        alocacoes.add(new Alocacao(medicos.get(1),salas.get(0),criarData(2020,11,14,10,00),criarData(2020,11,14,22,00)));
    }

    private static int inputInt(int min, int max, String msg){
        int ret=0;
        do{
            System.out.println(msg);
            try{
                ret = Integer.parseInt(in.nextLine());
            }
            catch(Exception e){
                System.out.println("O sistema esperava um inteiro, mas o usuario passou outro tipo.");
                ret=min-1;
            }

        }while(ret<min || ret>max);
        return ret;
    }

    public static Calendar criarData(int y, int m, int d, int h, int mi){
        Calendar newCalendar = Calendar.getInstance();
        newCalendar.set(y,m + 1,d,h,mi);
        //metodo para consertar o construtor de Date, que adiciona 1900 ao ano e considera mes de 0 a 11.
        return newCalendar;
    }

    public static boolean horarioDisponivel(Sala sala, Medico responsavel, Calendar inicio, Calendar fim){
        for (Alocacao a:alocacoes){
            if(sala.getNome().equalsIgnoreCase(a.getSala().getNome()) ||
                responsavel.getCrm().equalsIgnoreCase(a.getResponsavel().getCrm())){
                //se for a mesma sala ou se for o mesmo medico
                if(a.getInicio().get(Calendar.YEAR)==inicio.get(Calendar.YEAR) && a.getInicio().get(Calendar.MONTH)==inicio.get(Calendar.MONTH) &&
                a.getInicio().get(Calendar.DAY_OF_MONTH)==inicio.get(Calendar.DAY_OF_MONTH)){
                    //se for no mesmo dia
                    if(checaCoincideHorario(a, inicio, fim)) return false;
                }
            }
        }
        return true;
    }

    public static void atualizaAlocacoes(){
        //metodo para atualizar o custo de todas as alocacoes, chamado sempre que o usuario seta um novo custo por hora
        for(Alocacao a:alocacoes){
            if(a.getInicio().after(new GregorianCalendar())){
                //se o inicio da alocacao, for depois de agora ela eh uma reserva e deve ter o custo alterado
                a.alteraCusto();
            }
        }
    }
}
