import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.*;

public class AlocacaoMedicoSalaTest {
    private static Date inicio, fim;
    private static Medico medico;
    private static Sala sala;
    private static Alocacao alocacao;

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