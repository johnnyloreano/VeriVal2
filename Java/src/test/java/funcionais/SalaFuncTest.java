import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class SalaFuncTest {

    private static Sala sala;

    private static int TEMPO_MINIMO_PEQUENA = 2;
    private static int TEMPO_MINIMO_GRANDE = 2;
    private static int TEMPO_MINIMO_ALTO_RISCO = 3;

    private static double CUSTO_INICIAL_PEQUENA = 400;
    private static double CUSTO_INICIAL_GRANDE = 650;
    private static double CUSTO_INICIAL_ALTO_RISCO = 1200;

    @Test
    public void validaTempoMinimoGrande() {
        sala=new Sala("Gama","Grande");

        assertEquals(TEMPO_MINIMO_GRANDE,sala.getTempoMinimoReservaH());
    }

    @Test
    public void validaTempoMinimoPequena() {
        sala=new Sala("Gama","Pequena");

        assertEquals(TEMPO_MINIMO_PEQUENA, sala.getTempoMinimoReservaH());
    }

    @Test
    public void validaTempoMinimoAltoRisco() {
        sala=new Sala("Gama","Alto-risco");

        assertEquals(TEMPO_MINIMO_ALTO_RISCO,sala.getTempoMinimoReservaH());
    }

    @Test
    public void validaCustoInicialSalaPequena() {
        sala=new Sala("Gama","pequena");

        assertEquals(CUSTO_INICIAL_PEQUENA, sala.getCustoPorH());
    }

    @Test
    public void validaCustoInicialSalaGrande() {
        sala=new Sala("Gama","grande");

        assertEquals(CUSTO_INICIAL_GRANDE, sala.getCustoPorH());
    }

    @Test
    public void validaCustoInicialAltoRisco() {
        sala=new Sala("Gama","Alto-risco");

        assertEquals(CUSTO_INICIAL_ALTO_RISCO, sala.getCustoPorH());
    }
}
