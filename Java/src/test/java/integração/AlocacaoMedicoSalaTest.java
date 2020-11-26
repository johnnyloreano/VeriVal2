package integração;

import app.Alocacao;
import app.Medico;
import app.Sala;
import app.SalaTipo;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.*;

//import static org.junit.Assert.*;

public class AlocacaoMedicoSalaTest {
    private static GregorianCalendar inicio;
    private static GregorianCalendar fim;
    private static Medico medico;
    private static Sala sala;
    private static Alocacao alocacao;

    @Test
    public void checaMedicoTipoSalaTest1() {
        medico=new Medico("482604","Marie Curie","neurologista");
        sala = new Sala("gama", SalaTipo.ALTO_RISCO);
        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest2() {
        medico=new Medico("482604","Marie Curie","neurologista");
        sala = new Sala("gama", SalaTipo.PEQUENA);
        assertFalse(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest3() {
        medico=new Medico("482604","Marie Curie","neurologista");
        sala = new Sala("gama", SalaTipo.ALTO_RISCO);
        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest4() {
        medico=new Medico("482604","Marie Curie","cirurgiao cardiovascular");
        sala = new Sala("gama", SalaTipo.ALTO_RISCO);
        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest5() {
        medico=new Medico("482604","Marie Curie","cirurgiao cardiovascular");
        sala = new Sala("gama", SalaTipo.GRANDE);
        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest6() {
        medico=new Medico("482604","Marie Curie","cirurgiao cardiovascular");
        sala = new Sala("gama", SalaTipo.PEQUENA);
        assertFalse(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest7() {
        medico=new Medico("482604","Marie Curie","dermatologista");
        sala = new Sala("gama", SalaTipo.PEQUENA);
        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest8() {
        medico=new Medico("482604","Marie Curie","dermatologista");
        sala = new Sala("gama", SalaTipo.GRANDE);
        assertFalse(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest9() {
        medico=new Medico("482604","Marie Curie","dermatologista");
        sala = new Sala("gama", SalaTipo.ALTO_RISCO);
        assertFalse(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void toStringTest1() {
        medico=new Medico("482604","Marie Curie","neurologista");
        sala = new Sala("gama", SalaTipo.ALTO_RISCO);
        inicio = new GregorianCalendar(2020, 12, 10, 15, 35);
        fim = new GregorianCalendar(2020, 12, 10, 19, 20);
        alocacao = new Alocacao(medico, sala, inicio, fim);

        assertEquals("ALOCACAO:" + "\n app.Medico responsavel: " + medico+"\n app.Sala: " + sala
                + "\n Data de inicio: " + inicio + "\n Data de termino: "+fim,alocacao.toString());
    }

    @Test
    public void toStringTest2() {
        medico=new Medico("573820","Bruna Ferreira","cirurgiao cardiovascular");
        sala = new Sala("gama", SalaTipo.ALTO_RISCO);
        inicio = new GregorianCalendar(2020, 12, 10, 15, 35);
        fim = new GregorianCalendar(2020, 12, 10, 19, 20);
        alocacao = new Alocacao(medico, sala, inicio, fim);

        assertEquals("ALOCACAO:" + "\n app.Medico responsavel: " + medico+"\n app.Sala: " + sala
                + "\n Data de inicio: " + inicio + "\n Data de termino: "+fim,alocacao.toString());
    }

    @Test
    public void getInicioTest1() {
        sala=new Sala("gama",SalaTipo.ALTO_RISCO);
        medico=new Medico("12345","Harry Potter","neurologista");
        inicio=new GregorianCalendar(2020,10,14,12,30);
        fim=new GregorianCalendar(2020,10,14,20,45);
        alocacao=new Alocacao(medico,sala,inicio,fim);
        assertEquals(inicio,alocacao.getInicio());
    }

    @Test
    public void getFimTest1() {
        sala=new Sala("gama",SalaTipo.ALTO_RISCO);
        medico=new Medico("12345","Harry Potter","neurologista");
        inicio=new GregorianCalendar(2020,10,14,12,30);
        fim=new GregorianCalendar(2020,10,14,20,45);
        alocacao=new Alocacao(medico,sala,inicio,fim);
        assertEquals(fim,alocacao.getFim());
    }

    @Test
    public void getCustoTest1() {
        sala=new Sala("gama", SalaTipo.ALTO_RISCO);
        medico=new Medico("12345","Harry Potter","neurologista");
        inicio=new GregorianCalendar(2020,10,14,12,30);
        fim=new GregorianCalendar(2020,10,14,20,45);
        alocacao=new Alocacao(medico,sala,inicio,fim);
        inicio=new GregorianCalendar(2020,10,14,12,30);
        fim=new GregorianCalendar(2020,10,14,20,45);
        alocacao=new Alocacao(medico,sala,inicio,fim);
        assertEquals(9900.0,alocacao.getCusto(), 0.0);
    }

}