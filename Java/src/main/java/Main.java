import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Alocacao> alocacoes = new ArrayList<Alocacao>();
    private static ArrayList<Medico> medicos = new ArrayList<Medico>();
    private static ArrayList<Sala> salas = new ArrayList<Sala>();
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        //mockando salas, medicos e alocacoes
        mockandoDados();
        //interface com usuario
        while(true){
            System.out.println("1- Visualizar lista de medicos.");
            System.out.println("2- Visualizar lista de salas.");
            System.out.println("3- Visualizar lista de alocacoes.");
            System.out.println("4- Visualizar relatorio de gastos por medico.");
            System.out.println("5- Visualizar relatorio de gastos por sala.");
            System.out.println("6- Reservar sala.");
            System.out.println("7- Excluir reserva.");
            System.out.println("8- Alterar custo por hora de algum tipo de sala.");
            System.out.println("0- Finalizar programa.");
            int input = inputInt(1,8,"Escolha uma opcao de 1 a 8.");
            if(input==1){
                linhaDivisoria();
                System.out.println(medicos);
                System.out.println("Insira algo como input para retornar ao menu. (qualquer coisa)");
                String espera = in.next();
            }
            else if(input==2){
                linhaDivisoria();
                System.out.println(salas);
                System.out.println("Insira algo como input para retornar ao menu. (qualquer coisa)");
                String espera = in.next();
            }
            else if(input==3){
                
            }
            else if(input==4){
                linhaDivisoria();
                double[] gastos = new double[medicos.size()];
                for(Alocacao a:alocacoes){
                    if(a.getFim().before(new Date())){
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
                    System.out.println("Medico: "+medicos.get(i).getNome()+"   gastos: "+gastos[i]);
                }
            }
            else if(input==5){
                
            }
            else if(input==6){
                
            }
            else if(input==7){
                
            }
            else if(input==8){
            
            }
            else if(input==0){
                System.out.println("Finalizando programa...");
                System.exit(0);
            }
        }
    }

    public static void linhaDivisoria(){
        //so pra deixar a interface com o usuario melhor de se ver, ao separar cada menu.
        System.out.println("**********************************************************************************************************************************");
    }

    public static void mockandoDados(){
        //mocando as 10 salas e 5 medicos obrigatorios, e mais algumas alocacoes.
        salas.add(new Sala("alpha","alto-risco"));
        salas.add(new Sala("beta","grande"));
        salas.add(new Sala("celta","pequena"));
        salas.add(new Sala("delta","alto-risco"));
        salas.add(new Sala("echo","grande"));
        salas.add(new Sala("foxtrot","pequena"));
        salas.add(new Sala("golf","alto-risco"));
        salas.add(new Sala("hotel","grande"));
        salas.add(new Sala("india","pequena"));
        salas.add(new Sala("juliet","alto-risco"));
        medicos.add(new Medico("25500","Luis Roberto","Dermatologista"));
        medicos.add(new Medico("110723","Julia Huberts","Neurologista"));
        medicos.add(new Medico("15050","Adao Rubens","Cirurgiao cardiovascular"));
        medicos.add(new Medico("27328","Marina Souza","Ortopedista"));
        medicos.add(new Medico("3852","Rogerio Almeida","Gastroenterologista"));
        alocacoes.add(new Alocacao(medicos.get(4),salas.get(8),new Date(2020,10,7,9,45),new Date(2020,10,7,15,50)));
        alocacoes.add(new Alocacao(medicos.get(0),salas.get(2),new Date(2020,10,30,9,15),new Date(2020,10,30,12,00)));
        alocacoes.add(new Alocacao(medicos.get(3),salas.get(0),new Date(2020,11,12,8,45),new Date(2020,11,12,10,35)));
        alocacoes.add(new Alocacao(medicos.get(2),salas.get(0),new Date(2020,11,12,8,45),new Date(2020,11,12,10,35)));
        alocacoes.add(new Alocacao(medicos.get(4),salas.get(2),new Date(2020,11,15,16,45),new Date(2020,11,15,19,35)));
        alocacoes.add(new Alocacao(medicos.get(0),salas.get(5),new Date(2020,12,16,13,00),new Date(2020,12,16,17,35)));
        alocacoes.add(new Alocacao(medicos.get(0),salas.get(6),new Date(2020,2,2,8,10),new Date(2020,2,2,12,00)));
        alocacoes.add(new Alocacao(medicos.get(0),salas.get(5),new Date(2020,12,18,13,00),new Date(2020,12,18,18,35)));
        alocacoes.add(new Alocacao(medicos.get(3),salas.get(6),new Date(2020,5,12,17,35),new Date(2020,5,12,20,40)));
        alocacoes.add(new Alocacao(medicos.get(1),salas.get(0),new Date(2020,11,14,10,00),new Date(2020,11,14,22,00)));
    }

    public static int inputInt(int min, int max, String msg){
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

    public static boolean horarioDisponivel(Sala sala, Date inicio, Date fim){
        int mainInicio = inicio.getHours()*60 + inicio.getMinutes();
        int mainFim = fim.getHours()*60 + fim.getMinutes();
        for (Alocacao a:alocacoes){
            if(sala.getNome().equalsIgnoreCase(a.getSala().getNome())){
                //se for a mesma sala
                if(a.getInicio().getYear()==inicio.getYear() && a.getInicio().getMonth()==inicio.getMonth() && 
                a.getInicio().getDay()==inicio.getDay()){
                    //se for no mesmo dia
                    int aInicio = a.getInicio().getHours()*60 + a.getInicio().getMinutes();
                    int aFim = a.getFim().getHours()*60 + a.getFim().getMinutes();
                    if(mainInicio<aFim && mainInicio>aInicio){
                        /*se o inicio pretendido for menor que algum fim, e maior que o inicio desse fim
                         significa que o horario esta indisponivel pois o inicio do horario pretendido
                         ocupa o fim de algum horario ja registrado*/
                         return false;
                    }
                    if(mainFim>aInicio && mainFim<aFim){
                        /*se o fim pretendido for maior que algum inicio, e menor que o fim desse inicio
                        significa que o fim do horario pretendido ocupa algum horario ja registrado */
                        return false;
                    }
                    if(mainInicio==aInicio || mainFim==aFim){
                        //significa que queremos ocupar a sala em um momento em que ja esta ocupada
                        return false;
                    }

                }
            }
        }
        return true;
    }

    public static void atualizaAlocacoes(){
        //metodo para atualizar o custo de todas as alocacoes, chamado sempre que o usuario seta um novo custo por hora
        for(Alocacao a:alocacoes){
            if(a.getInicio().after(new Date())){
                //se o inicio da alocacao, for depois de agora ela eh uma reserva e deve ter o custo alterado
                a.alteraCusto();
            }
        }
    }
}
