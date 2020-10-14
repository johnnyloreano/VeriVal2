import java.util.Date;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Alocacao> alocacoes = new ArrayList<Alocacao>();
    public static void main(String[] args){

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
