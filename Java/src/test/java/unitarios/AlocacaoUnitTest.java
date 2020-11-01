import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.*;

public class AlocacaoUnitTest {
    private static Date inicio, fim;
    private static Medico medico;
    private static Sala sala;
    private static Alocacao alocacao;

    @Test
    public void checaMedicoTipoSala() {
        Medico cirurgiao = new Medico("123", "Testanderson", "cirurgiao cardiovascular");
        Medico neurologista = new Medico("456", "Testanderson", "neurologista");
        Medico dermatologista = new Medico("789", "Testanderson", "dermatologista");

        Sala pequena = new Sala("pequena", "pequena");
        Sala grande = new Sala("grande", "grande");
        Sala altoRisco = new Sala("alto-risco", "alto-risco");

        // Válidas.
        assertTrue("Dermatologista / Pequena", Alocacao.checaMedicoTipoSala(dermatologista,pequena));
        assertTrue("Cirurgião / Grande", Alocacao.checaMedicoTipoSala(cirurgiao,grande));
        assertTrue("Cirurgião / Alto-Risco", Alocacao.checaMedicoTipoSala(cirurgiao,altoRisco));
        assertTrue("Neurologista / Grande", Alocacao.checaMedicoTipoSala(neurologista,grande));
        assertTrue("Neurologista / Alto-Risco", Alocacao.checaMedicoTipoSala(neurologista,altoRisco));

        // Inválidas
        assertFalse("Neurologista / Pequena", Alocacao.checaMedicoTipoSala(neurologista,pequena));
        assertFalse("Cirurgião / Pequena", Alocacao.checaMedicoTipoSala(cirurgiao,pequena));
        assertFalse("Dermatologista / Grande", Alocacao.checaMedicoTipoSala(dermatologista,grande));
        assertFalse("Dermatologista / Alto-Risco", Alocacao.checaMedicoTipoSala(dermatologista,altoRisco));
    }

    @Test
    public void checaHorarioMinMax(){
        inicio = new Date(20,12,10,06,00);
        fim = new Date(20,12,10,22,00);

        assertTrue("Limites", Alocacao.checaHorarioMinMax(inicio, fim));

        inicio.setHours(7);
        fim.setHours(21);
        assertTrue("Horario válido", Alocacao.checaHorarioMinMax(inicio, fim));

        inicio.setHours(5);
        fim.setHours(22);
        assertFalse("Hora inicial inválida", Alocacao.checaHorarioMinMax(inicio, fim));

        inicio.setHours(5);
        inicio.setMinutes(55);
        fim.setHours(22);
        assertFalse("Hora inicial inválida por minutos", Alocacao.checaHorarioMinMax(inicio, fim));

        inicio.setHours(6);
        inicio.setMinutes(0);
        fim.setHours(23);
        assertFalse("Hora final inválida", Alocacao.checaHorarioMinMax(inicio, fim));

        inicio.setHours(6);
        fim.setHours(22);
        fim.setMinutes(15);
        assertFalse("Hora final inválida por minutos", Alocacao.checaHorarioMinMax(inicio, fim));
    }

    @Test
    public void checaMesmoDia() {
        inicio = new Date(20,5,10,06,00);
        fim = new Date(20,5,10,22,00);

        assertTrue("Mesmo dia", Alocacao.checaMesmoDia(inicio,fim));

        inicio.setDate(11);
        assertFalse("Dia Diferente", Alocacao.checaMesmoDia(inicio,fim));

        inicio.setDate(10);
        inicio.setMonth(6);
        assertFalse("Mês Diferente", Alocacao.checaMesmoDia(inicio,fim));

        inicio.setMonth(5);
        inicio.setYear(21);
        assertFalse("Ano Diferente", Alocacao.checaMesmoDia(inicio,fim));
    }

    @Test
    public void checaTempoMinimo() {
        Sala pequena = new Sala("pequena", "pequena");
        Sala grande = new Sala("grande", "grande");
        Sala altoRisco = new Sala("alto-risco", "alto-risco");

        int tempoPequena = pequena.getTempoMinimoReservaH();
        int tempoGrande = grande.getTempoMinimoReservaH();
        int tempoAltoRisco = altoRisco.getTempoMinimoReservaH();

        inicio = new Date(20,5,10,06,30);
        fim = new Date(20,5,10,21,30);

        //Limites
        fim.setHours(inicio.getHours() + tempoPequena);
        assertTrue("Limite sala pequena", Alocacao.checaTempoMinimo(pequena, inicio, fim));

        fim.setHours(inicio.getHours() + tempoGrande);
        assertTrue("Limite sala grande", Alocacao.checaTempoMinimo(grande, inicio, fim));

        fim.setHours(inicio.getHours() + tempoAltoRisco);
        assertTrue("Limite sala alto-risco", Alocacao.checaTempoMinimo(altoRisco, inicio, fim));

        // Válidos
        inicio.setHours(6);
        inicio.setMinutes(59);
        fim.setHours(inicio.getHours() + tempoPequena + 2);
        assertTrue("Sala pequena OK", Alocacao.checaTempoMinimo(pequena, inicio, fim));

        // Inválidos
        inicio.setHours(6);
        inicio.setMinutes(00);
        fim.setHours(inicio.getHours() + tempoPequena - 1);
        fim.setMinutes(59);
        assertFalse("1 Minuto a menos", Alocacao.checaTempoMinimo(pequena, inicio, fim));
    }

    @Test
    public void toStringTest1() {
        medico=new Medico("482604","Marie Curie","neurologista");
        sala = new Sala("gama", "alto-risco");
        inicio = new Date(2020, 12, 10, 15, 35);
        fim = new Date(2020, 12, 10, 19, 20);
        alocacao = new Alocacao(medico, sala, inicio, fim);

        assertEquals("ALOCACAO:" + "\n Medico responsavel: " + medico+"\n Sala: " + sala
                + "\n Data de inicio: " + inicio + "\n Data de termino: "+fim,alocacao.toString());
    }

    @Test
    public void toStringTest2() {
        medico=new Medico("573820","Karine Francisco","dermatologista");
        sala = new Sala("gama", "pequena");
        inicio = new Date(2020, 12, 10, 15, 35);
        fim = new Date(2020, 12, 10, 19, 20);
        alocacao = new Alocacao(medico, sala, inicio, fim);

        assertEquals("ALOCACAO:" + "\n Medico responsavel: " + medico+"\n Sala: " + sala
                + "\n Data de inicio: " + inicio + "\n Data de termino: "+fim,alocacao.toString());
    }

    @Test
    public void toStringTest3() {
        medico=new Medico("573820","Bruna Ferreira","cirurgiao cardiovascular");
        sala = new Sala("gama", "alto-risco");
        inicio = new Date(2020, 12, 10, 15, 35);
        fim = new Date(2020, 12, 10, 19, 20);
        alocacao = new Alocacao(medico, sala, inicio, fim);

        assertEquals("ALOCACAO:" + "\n Medico responsavel: " + medico+"\n Sala: " + sala
                + "\n Data de inicio: " + inicio + "\n Data de termino: "+fim,alocacao.toString());
    }

}