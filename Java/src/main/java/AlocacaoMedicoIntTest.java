import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class AlocacaoMedicoIntTest {
    private static Date inicio,fim;
    private static Medico medico;
    private static Sala sala;
    private static Alocacao alocacao;

    @Test
    public void getResponsavelNomeTest1() {
    sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("pequena");
        medico=new Medico("527383","Cleiton Silva","dermatologista");
        inicio=new Date(2020,10,14,19,30);
        fim=new Date(2020,10,14,21,50);
        alocacao=new Alocacao(medico,sala,inicio,fim);

        assertEquals(alocacao.getResponsavel().getNome(),"Cleiton Silva");
    }

    @Test
    public void getResponsavelCrmTest1() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("pequena");
        medico=new Medico("527383","Cleiton Silva","dermatologista");
        inicio=new Date(2020,10,14,19,30);
        fim=new Date(2020,10,14,21,50);
        alocacao=new Alocacao(medico,sala,inicio,fim);

        assertEquals(alocacao.getResponsavel().getCrm(),"527383");
    }

    @Test
    public void getResponsavelEspecialidadeTest1() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("pequena");
        medico=new Medico("527383","Cleiton Silva","dermatologista");
        inicio=new Date(2020,10,14,19,30);
        fim=new Date(2020,10,14,21,50);
        alocacao=new Alocacao(medico,sala,inicio,fim);

        assertEquals(alocacao.getResponsavel().getEspecialidade(),"dermatologista");
    }

    @Test
    public void checaMedicoTipoSalaTest1() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("pequena");
        medico=new Medico("527383","Cleiton Silva","dermatologista");
        inicio=new Date(2020,10,14,19,30);
        fim=new Date(2020,10,14,21,50);
        alocacao=new Alocacao(medico,sala,inicio,fim);

        assertEquals(alocacao.checaMedicoTipoSala(medico,sala),true);
    }

    @Test
    public void checaMedicoTipoSalaTest2() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("grande");
        medico=new Medico("527383","Cleiton Silva","dermatologista");
        inicio=new Date(2020,10,14,19,30);
        fim=new Date(2020,10,14,21,50);
        alocacao=new Alocacao(medico,sala,inicio,fim);

        assertEquals(alocacao.checaMedicoTipoSala(medico,sala),false);
    }

    @Test
    public void checaMedicoTipoSalaTest3() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("alto-risco");
        medico=new Medico("527383","Cleiton Silva","dermatologista");
        inicio=new Date(2020,10,14,19,30);
        fim=new Date(2020,10,14,21,50);
        alocacao=new Alocacao(medico,sala,inicio,fim);

        assertEquals(alocacao.checaMedicoTipoSala(medico,sala),false);
    }

}
