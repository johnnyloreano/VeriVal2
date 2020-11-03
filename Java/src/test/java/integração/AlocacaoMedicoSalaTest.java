import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.*;

public class AlocacaoMedicoSalaTest {
    private static Date inicio, fim,inicio2,fim2;
    private static Medico medico,medico2;
    private static Sala sala,sala2;
    private static Alocacao alocacao,alocacao2;

    @Test
    public void checaMedicoTipoSalaTest1() {
        medico=new Medico("482604","Marie Curie","neurologista");
        sala = new Sala("gama", "alto-risco");
        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest2() {
        medico=new Medico("482604","Marie Curie","neurologista");
        sala = new Sala("gama", "pequena");
        assertFalse(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest3() {
        medico=new Medico("482604","Marie Curie","neurologista");
        sala = new Sala("gama", "alto-risco");
        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest4() {
        medico=new Medico("482604","Marie Curie","cirurgiao cardiovascular");
        sala = new Sala("gama", "alto-risco");
        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest5() {
        medico=new Medico("482604","Marie Curie","cirurgiao cardiovascular");
        sala = new Sala("gama", "grande");
        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest6() {
        medico=new Medico("482604","Marie Curie","cirurgiao cardiovascular");
        sala = new Sala("gama", "pequena");
        assertFalse(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest7() {
        medico=new Medico("482604","Marie Curie","dermatologista");
        sala = new Sala("gama", "pequena");
        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest8() {
        medico=new Medico("482604","Marie Curie","dermatologista");
        sala = new Sala("gama", "grande");
        assertFalse(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest9() {
        medico=new Medico("482604","Marie Curie","dermatologista");
        sala = new Sala("gama", "alto-risco");
        assertFalse(Alocacao.checaMedicoTipoSala(medico,sala));
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
        medico=new Medico("573820","Bruna Ferreira","cirurgiao cardiovascular");
        sala = new Sala("gama", "alto-risco");
        inicio = new Date(2020, 12, 10, 15, 35);
        fim = new Date(2020, 12, 10, 19, 20);
        alocacao = new Alocacao(medico, sala, inicio, fim);

        assertEquals("ALOCACAO:" + "\n Medico responsavel: " + medico+"\n Sala: " + sala
                + "\n Data de inicio: " + inicio + "\n Data de termino: "+fim,alocacao.toString());
    }

    @Test
    public void getInicioTest1() {
        sala=new Sala("gama","alto-risco");
        medico=new Medico("12345","Harry Potter","neurologista");
        inicio=new Date(2020,10,14,12,30);
        fim=new Date(2020,10,14,20,45);
        alocacao=new Alocacao(medico,sala,inicio,fim);
        assertEquals(inicio,alocacao.getInicio());
    }

    @Test
    public void getFimTest1() {
        sala=new Sala("gama","alto-risco");
        medico=new Medico("12345","Harry Potter","neurologista");
        inicio=new Date(2020,10,14,12,30);
        fim=new Date(2020,10,14,20,45);
        alocacao=new Alocacao(medico,sala,inicio,fim);
        assertEquals(fim,alocacao.getFim());
    }

    @Test
    public void getCustoTest1() {
        sala=new Sala("gama","alto-risco");
        medico=new Medico("12345","Harry Potter","neurologista");
        inicio=new Date(2020,10,14,12,30);
        fim=new Date(2020,10,14,20,45);
        alocacao=new Alocacao(medico,sala,inicio,fim);
        inicio=new Date(2020,10,14,12,30);
        fim=new Date(2020,10,14,20,45);
        alocacao=new Alocacao(medico,sala,inicio,fim);
        assertEquals(9900.0,alocacao.getCusto());
    }

}