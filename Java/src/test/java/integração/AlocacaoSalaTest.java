import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlocacaoSalaTest {
    private static Date inicio,fim;
    private static Medico medico;
    private static Sala sala;
    private static Alocacao alocacao;

    @Test
    public void checaTempoMinimoTest1() {
        sala= new Sala("gama","pequena");
        inicio=new Date(2020,10,14,20,30);
        fim=new Date(2020,10,14,21,50);
        assertFalse(Alocacao.checaTempoMinimo(sala,inicio,fim));
    }

    @Test
    public void checaTempoMinimoTest2() {
        sala= new Sala("gama","pequena");
        inicio=new Date(2020,10,14,19,30);
        fim=new Date(2020,10,14,21,50);
        assertTrue(Alocacao.checaTempoMinimo(sala,inicio,fim));
    }

    @Test
    public void checaTempoMinimoTest3() {
        sala= new Sala("gama","grande");
        inicio=new Date(2020,10,14,20,30);
        fim=new Date(2020,10,14,21,40);
        assertFalse(Alocacao.checaTempoMinimo(sala,inicio,fim));
    }

    @Test
    public void checaTempoMinimoTest4() {
        sala= new Sala("gama","grande");
        inicio=new Date(2020,10,14,19,30);
        fim=new Date(2020,10,14,21,40);
        assertTrue(Alocacao.checaTempoMinimo(sala,inicio,fim));
    }

    @Test
    public void checaTempoMinimoTest5() {
        sala= new Sala("gama","alto-risco");
        inicio=new Date(2020,10,14,19,30);
        fim=new Date(2020,10,14,21,40);
        assertFalse(Alocacao.checaTempoMinimo(sala,inicio,fim));
    }

    @Test
    public void checaTempoMinimoTest6() {
        sala= new Sala("gama","alto-risco");
        inicio=new Date(2020,10,14,18,30);
        fim=new Date(2020,10,14,21,40);
        assertTrue(Alocacao.checaTempoMinimo(sala,inicio,fim));
    }

    @Test
    public void checaMedicoTipoSalaTest1() {
        sala=new Sala("gama","grande");
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("neurologista");
        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest2() {
        sala=new Sala("gama","pequena");
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("neurologista");
        assertFalse(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest3() {
        sala=new Sala("gama","alto-risco");
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("neurologista");
        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest4() {
        sala=new Sala("gama","alto-risco");
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("cirurgiao cardiovascular");
        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest5() {
        sala=new Sala("gama","grande");
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("cirurgiao cardiovascular");
        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest6() {
        sala=new Sala("gama","pequena");
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("cirurgiao cardiovascular");
        assertFalse(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest7() {
        sala=new Sala("gama","pequena");
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("dermatologista");
        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest8() {
        sala=new Sala("gama","grande");
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("dermatologista");
        assertFalse(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest9() {
        sala=new Sala("gama","alto-risco");
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("dermatologista");
        assertFalse(Alocacao.checaMedicoTipoSala(medico,sala));
    }


}
