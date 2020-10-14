import java.util.Date;

public class Alocacao {
    private Medico responsavel;
    private Sala sala;
    private Date inicio;
    private Date fim;
    private double custo;
    private static final int MINH = 6;//hora da qual nao se pode alocar salas antes
    private static final int MAXH = 22;//hora da qual nao se pode alocar salas depois.

    public Alocacao(Medico responsavel, Sala sala, Date inicio, Date fim){
        if(checaMesmoDia(inicio,fim) && checaHorarioMinMax(inicio,fim) && checaTempoMinimo(sala, inicio, fim) && Main.horarioDisponivel(sala,inicio,fim)){
            /*se as datas de inicio e fim respeitam as regras de serem do mesmo dia, nao ser antes das 6,
            nao ser depois das 22 e respeitam o limite de tempo minimo a ser locado, cria o objeto*/
            this.responsavel = responsavel;
            this.sala = sala;
            this.inicio = inicio;
            this.fim = fim;
            custo = calcultaCusto();     
        }
        else{
            System.out.println("Datas ou horarios invalidos");
        }
    }

    private boolean checaHorarioMinMax(Date inicio, Date fim){
        /**Metodo que checa se a data de inicio e fim respeitam os limites de hora min e max
         * @param Date inicio, data do inicio da locacao
         * @param Date fim, data do fim da locacao
         * @return boolean, indica se os horarios respeitam as horas limites
         */
        return (inicio.getHours()>=MINH && inicio.getHours()<=MAXH) && (fim.getHours()>=MINH && fim.getHours()<=MAXH);
    }

    private boolean checaMesmoDia(Date inicio, Date fim){
        /**Metodo que checa se o ano, mes e dia da data de locacao (inicio e fim) sao os mesmos, o que deve ser verdade
         * para respeitar a regra de so deixar locar entre 6h e 22h.
         * @param Date inicio, data do inicio da locacao
         * @param Date fim, data do fim da locacao
         * @return boolean, indica se as datas possuem o mesmo ano, mes e dia
         */
        return inicio.getYear()==fim.getYear() && inicio.getMonth()==fim.getMonth() && inicio.getDay()==fim.getDay();
    }

    private boolean checaTempoMinimo(Sala sala, Date inicio, Date fim){
        /**Metodo que checa se a locacao respeita o limite de tempo minimo para locacoes de acordo com o seu tipo
         * de sala.
         * @param Date inicio, data do inicio da locacao
         * @param Date fim, data do fim da locacao
         * @param Sala sala, sala a ser locada
         * @return boolean, indica se a locacao respeita o tempo minimo
         */
        //converte os horarios para minutos e faz a comparacao de maior igual.
        int inicioMinutos = inicio.getHours()*60 + inicio.getMinutes();
        int fimMinutos = fim.getHours()*60 + fim.getMinutes();
        int duracaoMinimaMinutos = sala.getTempoMinimoReservaH()*60;
        return fimMinutos-inicioMinutos >= duracaoMinimaMinutos;
    }

    public Medico getResponsavel(){
        return this.responsavel;
    }
    public Sala getSala(){
        return this.sala;
    }
    public Date getInicio(){
        return this.inicio;
    }
    public Date getFim(){
        return this.fim;
    }
    private double calcultaCusto(){
        int inicioMinutos = inicio.getHours()*60 + inicio.getMinutes();
        int fimMinutos = fim.getHours()*60 + fim.getMinutes();
        return ((fimMinutos-inicioMinutos)/60.0) * sala.getCustoPorH();
    }
    public double getCusto(){
        return custo;
    }
    public void alteraCusto(){
        custo=calcultaCusto();
    }
}
