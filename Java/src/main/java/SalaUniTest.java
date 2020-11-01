import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
public class SalaUniTest {

    private static Sala sala;
    @Test
    public void getNomeTest1() {
        sala=new Sala("Gama","Grande");

        assertEquals("Gama",sala.getNome());
    }

    @Test
    public void getTipoTest1() {
        sala=new Sala("Gama","Grande");

        assertEquals("Grande",sala.getTipo());
    }

    @Test
    public void getCustoPorHTest1() {
        sala=new Sala("Gama","Grande");

        assertEquals(650.0,sala.getCustoPorH());
    }

    @Test
    public void getCustoPorHTest2() {
        sala=new Sala("Gama","Pequena");

        assertEquals(400.0,sala.getCustoPorH());
    }

    @Test
    public void getCustoPorHTest3() {
        sala=new Sala("Gama","Alto-risco");

        assertEquals(1200.0,sala.getCustoPorH());
    }

    @Test
    public void getTempoMinimoHTest1() {
        sala=new Sala("Gama","Grande");

        assertEquals(2,sala.getTempoMinimoReservaH());
    }

    @Test
    public void getTempoMinimoHTest2() {
        sala=new Sala("Gama","Pequena");

        assertEquals(sala.getTempoMinimoReservaH(),2);
    }

    @Test
    public void getTempoMinimoHTest3() {
        sala=new Sala("Gama","Alto-risco");

        assertEquals(3,sala.getTempoMinimoReservaH());
    }

    @Test
    public void setCustoPorHPequenaTest1() {
        sala=new Sala("Gama","pequena");
        Sala.setCustoPorHPequena(-15);

        assertEquals(400.0,sala.getCustoPorH());

    }

    @Test
    public void setCustoPorHPequenaTest2() {
        sala=new Sala("Gama","pequena");
        Sala.setCustoPorHPequena(200);

        assertEquals(200.0,sala.getCustoPorH());

    }

    @Test
    public void setCustoPorHGrandeTest1() {
        sala=new Sala("Gama","grande");
        Sala.setCustoPorHGrande(-15);

        assertEquals(650.0,sala.getCustoPorH());

    }

    @Test
    public void setCustoPorHGrandeTest2() {
        sala=new Sala("Gama","grande");
        Sala.setCustoPorHGrande(1500);

        assertEquals(1500.0,sala.getCustoPorH());
    }

    @Test
    public void setCustoPorHAltoRiscoTest1() {
        sala=new Sala("Gama","Alto-risco");
        Sala.setCustoPorHAltoRisco(-15);

        assertEquals(12000,sala.getCustoPorH());

    }

    @Test
    public void setCustoPorHAltoRiscoTest2() {
        sala=new Sala("Gama","Alto-risco");
        Sala.setCustoPorHAltoRisco(3000);

        assertEquals(3000.0,sala.getCustoPorH());

    }

    @Test
    public void toStringTest1() {
        sala=new Sala("Gama","Alto-risco");

        assertEquals("Nome: "+"Gama"+"     Tipo: "+"Alto-risco"+"     Custo por hora: "+1200.0,sala.toString());

    }







}
