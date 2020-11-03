import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlocacaoMedicoTest {
    private static Date inicio,fim;
    private static Medico medico;
    private static Sala sala;
    private static Alocacao alocacao;

    @Test
    public void checaMedicoTipoSalaTest1() {
        medico=new Medico("482604","Marie Curie","neurologista");
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("grande");
        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest2() {
        medico=new Medico("482604","Marie Curie","neurologista");
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("pequena");
        assertFalse(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest3() {
        medico=new Medico("482604","Marie Curie","neurologista");
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("alto-risco");
        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest4() {
        medico=new Medico("482604","Marie Curie","cirurgiao cardiovascular");
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("alto-risco");
        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest5() {
        medico=new Medico("482604","Marie Curie","cirurgiao cardiovascular");
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("grande");
        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest6() {
        medico=new Medico("482604","Marie Curie","cirurgiao cardiovascular");
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("pequena");
        assertFalse(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest7() {
        medico=new Medico("482604","Marie Curie","dermatologista");
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("pequena");
        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest8() {
        medico=new Medico("482604","Marie Curie","dermatologista");
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("grande");
        assertFalse(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest9() {
        medico=new Medico("482604","Marie Curie","dermatologista");
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("alto-risco");
        assertFalse(Alocacao.checaMedicoTipoSala(medico,sala));
    }


}
