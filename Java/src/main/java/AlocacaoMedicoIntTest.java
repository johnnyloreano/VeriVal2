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

        assertEquals("Cleiton Silva",alocacao.getResponsavel().getNome());
    }

    @Test
    public void getResponsavelCrmTest1() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("pequena");
        medico=new Medico("527383","Cleiton Silva","dermatologista");
        inicio=new Date(2020,10,14,19,30);
        fim=new Date(2020,10,14,21,50);
        alocacao=new Alocacao(medico,sala,inicio,fim);

        assertEquals("527383",alocacao.getResponsavel().getCrm());
    }

    @Test
    public void getResponsavelEspecialidadeTest1() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("pequena");
        medico=new Medico("527383","Cleiton Silva","dermatologista");
        inicio=new Date(2020,10,14,19,30);
        fim=new Date(2020,10,14,21,50);
        alocacao=new Alocacao(medico,sala,inicio,fim);

        assertEquals("dermatologista",alocacao.getResponsavel().getEspecialidade());
    }


}
