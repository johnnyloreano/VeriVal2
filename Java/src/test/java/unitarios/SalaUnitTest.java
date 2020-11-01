import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertEquals;
public class SalaUnitTest {

    @Test
    public void getNome() {
        Sala sala = new Sala("Gama","Grande");

        assertEquals("Gama",sala.getNome());
    }

    @Test
    public void getTipo() {
        Sala sala = new Sala("Gama","Grande");

        assertEquals("Grande",sala.getTipo());
    }

    @Test
    public void getCustoPorH() {
        Sala sala;
        sala=new Sala("Gama","Grande");
        assertTrue( sala.getCustoPorH() > 0.0);

        sala=new Sala("Gama","Pequena");
        assertTrue( sala.getCustoPorH() > 0.0);

        sala=new Sala("Gama","Alto-risco");
        assertTrue( sala.getCustoPorH() > 0.0);

        sala=new Sala("Gama","Teste");
        assertEquals(0.0, sala.getCustoPorH());
    }

    @Test
    public void setCustoPorHPequenaInvalido() {
        Sala sala = new Sala("Gama","pequena");

        double valorAtual = sala.getCustoPorH();

        Sala.setCustoPorHPequena(-15);

        assertEquals(valorAtual, sala.getCustoPorH());
    }

    @Test
    public void setCustoPorHPequenaValido() {
        Sala sala = new Sala("Gama","pequena");
        Sala.setCustoPorHPequena(200);

        assertEquals(200.0, sala.getCustoPorH());
    }

    @Test
    public void setCustoPorHGrandeInvalido() {
        Sala sala = new Sala("Gama","grande");

        double valorAtual = sala.getCustoPorH();

        Sala.setCustoPorHGrande(-15);

        assertEquals(valorAtual, sala.getCustoPorH());
    }

    @Test
    public void setCustoPorHGrandeValido() {
        Sala sala = new Sala("Gama","grande");
        Sala.setCustoPorHGrande(1500);

        assertEquals(1500.0,sala.getCustoPorH());
    }

    @Test
    public void setCustoPorHAltoRiscoInvalido() {
        Sala sala = new Sala("Gama","Alto-risco");

        double valorAtual = sala.getCustoPorH();

        Sala.setCustoPorHAltoRisco(-15);

        assertEquals(valorAtual,sala.getCustoPorH());
    }

    @Test
    public void setCustoPorHAltoRiscoValido() {
        Sala sala = new Sala("Gama","Alto-risco");
        Sala.setCustoPorHAltoRisco(3000);

        assertEquals(3000.0,sala.getCustoPorH());
    }

    @Test
    public void toStringTest() {
        Sala sala = new Sala("Gama","Alto-risco");

        String tipo = sala.getTipo();
        double custo = sala.getCustoPorH();

        assertEquals("Nome: "+"Gama"+"     Tipo: "+tipo+"     Custo por hora: "+custo,sala.toString());
    }
}
