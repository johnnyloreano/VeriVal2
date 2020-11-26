package unitario;

import app.Sala;
import app.SalaTipo;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
public class SalaTest {
    private static Sala sala;
    @Test
    public void getNomeTest() {
        Sala sala = new Sala("Gama",SalaTipo.GRANDE);

        assertEquals("Gama",sala.getNome());
    }

    @Test
    public void getTipoTest() {
        Sala sala = new Sala("Gama",SalaTipo.GRANDE);

        assertEquals(SalaTipo.GRANDE,sala.getTipo());
    }

    @Test
    public void validaTempoMinimoGrandeTest() {
        sala=new Sala("Gama",SalaTipo.GRANDE);

        assertEquals(2,sala.getTempoMinimoReservaH());
    }

    @Test
    public void validaTempoMinimoPequenaTest() {
        sala=new Sala("Gama",SalaTipo.GRANDE);

        assertEquals(2, sala.getTempoMinimoReservaH());
    }

    @Test
    public void validaTempoMinimoAltoRiscoTest() {
        sala=new Sala("Gama",SalaTipo.ALTO_RISCO);

        assertEquals(3,sala.getTempoMinimoReservaH());
    }

    @Test
    public void validaCustoInicialSalaPequenaTest() {
        sala=new Sala("Gama",SalaTipo.PEQUENA);

        assertEquals(400.0, sala.getCustoPorH());
    }

    @Test
    public void validaCustoInicialSalaGrandeTest() {
        sala=new Sala("Gama",SalaTipo.GRANDE);

        assertEquals(650.0, sala.getCustoPorH());
    }

    @Test
    public void validaCustoInicialAltoRiscoTest() {
        sala=new Sala("Gama",SalaTipo.ALTO_RISCO);

        assertEquals(1200.0, sala.getCustoPorH());
    }

    @Test
    public void setCustoPorHPequenaInvalidoTest() {
        Sala sala = new Sala("Gama",SalaTipo.PEQUENA);

        double valorAtual = sala.getCustoPorH();

        Sala.setCustoPorHPequena(-15);

        assertEquals(valorAtual, sala.getCustoPorH());
    }

    @Test
    public void setCustoPorHPequenaValidoTest() {
        Sala sala = new Sala("Gama",SalaTipo.PEQUENA);
        Sala.setCustoPorHPequena(200);

        assertEquals(200.0, sala.getCustoPorH());
    }

    @Test
    public void setCustoPorHGrandeInvalidoTest() {
        Sala sala = new Sala("Gama",SalaTipo.GRANDE);

        double valorAtual = sala.getCustoPorH();

        Sala.setCustoPorHGrande(-15);

        assertEquals(valorAtual, sala.getCustoPorH());
    }

    @Test
    public void setCustoPorHGrandeValidoTest() {
        Sala sala = new Sala("Gama",SalaTipo.GRANDE);
        Sala.setCustoPorHGrande(1500);

        assertEquals(1500.0,sala.getCustoPorH());
    }

    @Test
    public void setCustoPorHAltoRiscoInvalidoTest() {
        Sala sala = new Sala("Gama",SalaTipo.ALTO_RISCO);

        double valorAtual = sala.getCustoPorH();

        Sala.setCustoPorHAltoRisco(-15);

        assertEquals(valorAtual,sala.getCustoPorH());
    }

    @Test
    public void setCustoPorHAltoRiscoValidoTest() {
        Sala sala = new Sala("Gama", SalaTipo.ALTO_RISCO);
        Sala.setCustoPorHAltoRisco(3000);

        assertEquals(3000.0,sala.getCustoPorH());
    }

    @Test
    public void toStringTest() {
        Sala sala = new Sala("Gama",SalaTipo.ALTO_RISCO);

        SalaTipo tipo = sala.getTipo();
        double custo = sala.getCustoPorH();

        assertEquals("Nome: "+"Gama"+"     Tipo: "+tipo+"     Custo por hora: "+custo,sala.toString());
    }
}
