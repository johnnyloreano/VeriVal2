import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlocacaoSalaIntTest {
    private static Date inicio,fim;
    private static Medico medico;
    private static Sala sala;
    private static Alocacao alocacao;

    @Test
    public void getSalaTest1() {
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("neurologista");
        sala= new Sala("gama","Grande");
        inicio=new Date(2020,9,11,11,40);
        fim=new Date(2020,9,11,20,20);
        alocacao=new Alocacao(medico,sala,inicio,fim);

        assertEquals(alocacao.getSala().getNome(),"gama");
    }

    @Test
    public void getSalaTest2() {
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("neurologista");
        sala= new Sala("gama","Grande");
        inicio=new Date(2020,9,11,11,40);
        fim=new Date(2020,9,11,20,20);
        alocacao=new Alocacao(medico,sala,inicio,fim);

        assertEquals(alocacao.getSala().getTipo(),"Grande");
    }

    @Test
    public void checaMedicoTipoSalaTest1() {
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("neurologista");
        sala= new Sala("gama","Grande");
        inicio=new Date(2020,9,11,11,40);
        fim=new Date(2020,9,11,20,20);
        alocacao=new Alocacao(medico,sala,inicio,fim);

        assertEquals(alocacao.checaMedicoTipoSala(medico,sala),true);
    }

    @Test
    public void checaMedicoTipoSalaTest2() {
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("neurologista");
        sala= new Sala("gama","alto-risco");
        inicio=new Date(2020,9,11,11,40);
        fim=new Date(2020,9,11,20,20);
        alocacao=new Alocacao(medico,sala,inicio,fim);

        assertEquals(alocacao.checaMedicoTipoSala(medico,sala),true);
    }

    @Test
    public void checaMedicoTipoSalaTest3() {
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("neurologista");
        sala= new Sala("gama","pequena");
        inicio=new Date(2020,9,11,11,40);
        fim=new Date(2020,9,11,20,20);
        alocacao=new Alocacao(medico,sala,inicio,fim);

        assertEquals(alocacao.checaMedicoTipoSala(medico,sala),false);
    }

    @Test
    public void checaTempoMinimoTest1() {
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("neurologista");
        sala= new Sala("gama","alto-risco");
        inicio=new Date(2020,9,11,11,40);
        fim=new Date(2020,9,11,20,20);
        alocacao=new Alocacao(medico,sala,inicio,fim);

        assertEquals(alocacao.checaTempoMinimo(sala,inicio,fim),true);
    }

    @Test
    public void checaTempoMinimoTest2() {
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("neurologista");
        sala= new Sala("gama","alto-risco");
        inicio=new Date(2020,9,11,11,40);
        fim=new Date(2020,9,11,13,42);
        alocacao=new Alocacao(medico,sala,inicio,fim);

        assertEquals(alocacao.checaTempoMinimo(sala,inicio,fim),false);
    }

}
