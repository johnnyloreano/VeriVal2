import app.Alocacao;
import app.Medico;
import app.Sala;
import app.SalaTipo;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlocacaoSalaTest {
    private static GregorianCalendar inicio,fim;
    private static Medico medico;
    private static Sala sala;

    @Test
    public void checaTempoMinimoTest1() {
        sala= new Sala("gama", SalaTipo.PEQUENA);
        inicio=new GregorianCalendar(2020,10,14,20,30);
        fim=new GregorianCalendar(2020,10,14,21,50);
        assertFalse(Alocacao.checaTempoMinimo(sala,inicio,fim));
    }

    @Test
    public void checaTempoMinimoTest2() {
        sala= new Sala("gama",SalaTipo.PEQUENA);
        inicio=new GregorianCalendar(2020,10,14,19,30);
        fim=new GregorianCalendar(2020,10,14,21,50);
        assertTrue(Alocacao.checaTempoMinimo(sala,inicio,fim));
    }

    @Test
    public void checaTempoMinimoTest3() {
        sala= new Sala("gama",SalaTipo.GRANDE);
        inicio=new GregorianCalendar(2020,10,14,20,30);
        fim=new GregorianCalendar(2020,10,14,21,40);
        assertFalse(Alocacao.checaTempoMinimo(sala,inicio,fim));
    }

    @Test
    public void checaTempoMinimoTest4() {
        sala= new Sala("gama",SalaTipo.GRANDE);
        inicio=new GregorianCalendar(2020,10,14,19,30);
        fim=new GregorianCalendar(2020,10,14,21,40);
        assertTrue(Alocacao.checaTempoMinimo(sala,inicio,fim));
    }

    @Test
    public void checaTempoMinimoTest5() {
        sala= new Sala("gama",SalaTipo.ALTO_RISCO);
        inicio=new GregorianCalendar(2020,10,14,19,30);
        fim=new GregorianCalendar(2020,10,14,21,40);
        assertFalse(Alocacao.checaTempoMinimo(sala,inicio,fim));
    }

    @Test
    public void checaTempoMinimoTest6() {
        sala= new Sala("gama",SalaTipo.ALTO_RISCO);
        inicio=new GregorianCalendar(2020,10,14,18,30);
        fim=new GregorianCalendar(2020,10,14,21,40);
        assertTrue(Alocacao.checaTempoMinimo(sala,inicio,fim));
    }

    @Test
    public void checaMedicoTipoSalaTest1() {
        sala=new Sala("gama",SalaTipo.GRANDE);
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("neurologista");
        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest2() {
        sala=new Sala("gama",SalaTipo.PEQUENA);
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("neurologista");
        assertFalse(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest3() {
        sala=new Sala("gama",SalaTipo.ALTO_RISCO);
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("neurologista");
        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest4() {
        sala=new Sala("gama",SalaTipo.ALTO_RISCO);
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("cirurgiao cardiovascular");
        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest5() {
        sala=new Sala("gama",SalaTipo.GRANDE);
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("cirurgiao cardiovascular");
        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest6() {
        sala=new Sala("gama",SalaTipo.PEQUENA);
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("cirurgiao cardiovascular");
        assertFalse(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest7() {
        sala=new Sala("gama",SalaTipo.PEQUENA);
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("dermatologista");
        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest8() {
        sala=new Sala("gama",SalaTipo.GRANDE);
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("dermatologista");
        assertFalse(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest9() {
        sala=new Sala("gama",SalaTipo.ALTO_RISCO);
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("dermatologista");
        assertFalse(Alocacao.checaMedicoTipoSala(medico,sala));
    }


}
