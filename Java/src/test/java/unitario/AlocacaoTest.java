import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlocacaoTest {
    private static Date inicio,fim,inicio2,fim2;
    private static Medico medico,medico2;
    private static Sala sala,sala2;
    private static Alocacao alocacao,alocacao2;

    @Test
    public void checaMedicoTipoSalaTest1() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("pequena");
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("Neurologista");

        assertFalse(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest2() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("pequena");
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("cirurgiao cardiovascular");
        assertFalse(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest3() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("grande");
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("dermatologista");
        assertFalse(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest4() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("alto-risco");
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("dermatologista");
        assertFalse(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest5() {
        medico = mock(Medico.class);
        when(medico.getNome()).thenReturn("Testanderson");
        when(medico.getCrm()).thenReturn("789");
        when(medico.getEspecialidade()).thenReturn("dermatologista");

        sala = mock(Sala.class);
        when(sala.getNome()).thenReturn("gama");
        when(sala.getTipo()).thenReturn("pequena");

        assertTrue(Alocacao.checaMedicoTipoSala(medico, sala));
    }

    @Test
    public void checaMedicoTipoSalaTest6() {
        medico=mock(Medico.class);
        when(medico.getNome()).thenReturn("Testanderson");
        when(medico.getCrm()).thenReturn("456");
        when(medico.getEspecialidade()).thenReturn("neurologista");

        sala=mock(Sala.class);
        when(sala.getNome()).thenReturn("gama");
        when(sala.getTipo()).thenReturn("grande");

        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest7() {
        medico = mock(Medico.class);
        when(medico.getNome()).thenReturn("Testanderson");
        when(medico.getCrm()).thenReturn("456");
        when(medico.getEspecialidade()).thenReturn("neurologista");

        sala = mock(Sala.class);
        when(sala.getNome()).thenReturn("gama");
        when(sala.getTipo()).thenReturn("alto-risco");

        assertTrue(Alocacao.checaMedicoTipoSala(medico, sala));
    }

    @Test
    public void checaMedicoTipoSalaTest8() {
        medico=mock(Medico.class);
        when(medico.getNome()).thenReturn("Testanderson");
        when(medico.getCrm()).thenReturn("123");
        when(medico.getEspecialidade()).thenReturn("cirurgiao cardiovascular");

        sala=mock(Sala.class);
        when(sala.getNome()).thenReturn("gama");
        when(sala.getTipo()).thenReturn("alto-risco");

        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaMedicoTipoSalaTest9() {
        medico=mock(Medico.class);
        when(medico.getNome()).thenReturn("Testanderson");
        when(medico.getCrm()).thenReturn("123");
        when(medico.getEspecialidade()).thenReturn("cirurgiao cardiovascular");

        sala=mock(Sala.class);
        when(sala.getNome()).thenReturn("gama");
        when(sala.getTipo()).thenReturn("grande");

        assertTrue(Alocacao.checaMedicoTipoSala(medico,sala));
    }

    @Test
    public void checaTempoMinimoTest1() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("pequena");
        when(sala.getTempoMinimoReservaH()).thenReturn(2);
        inicio=new Date(2020,10,14,20,30);
        fim=new Date(2020,10,14,21,50);
        assertFalse(Alocacao.checaTempoMinimo(sala,inicio,fim));
    }

    @Test
    public void checaTempoMinimoTest2() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("grande");
        when(sala.getTempoMinimoReservaH()).thenReturn(2);
        inicio=new Date(2020,10,14,20,30);
        fim=new Date(2020,10,14,21,40);
        assertFalse(Alocacao.checaTempoMinimo(sala,inicio,fim));
    }

    @Test
    public void checaTempoMinimoTest3() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("alto-risco");
        when(sala.getTempoMinimoReservaH()).thenReturn(3);

        inicio=new Date(2020,10,14,19,30);
        fim=new Date(2020,10,14,21,45);
        assertFalse(Alocacao.checaTempoMinimo(sala,inicio,fim));
    }

    @Test
    public void checaTempoMinimoTest4() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("pequena");
        inicio = new Date(20,5,10,19,30);
        fim = new Date(20,5,10,21,30);

        assertTrue(Alocacao.checaTempoMinimo(sala,inicio,fim));
    }

    @Test
    public void checaTempoMinimoTest5() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("grande");
        inicio = new Date(20,5,10,19,30);
        fim = new Date(20,5,10,21,30);

        assertTrue(Alocacao.checaTempoMinimo(sala,inicio,fim));
    }

    @Test
    public void checaTempoMinimoTest6() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("alto-risco");
        inicio = new Date(20,5,10,18,30);
        fim = new Date(20,5,10,21,30);

        assertTrue(Alocacao.checaTempoMinimo(sala,inicio,fim));
    }

    @Test
    public void checaMesmoDiaTest1() {
        inicio=new Date(2020,10,14,12,30);
        fim=new Date(2020,10,15,20,45);
        assertFalse(Alocacao.checaMesmoDia(inicio,fim));
    }


    @Test
    public void checaMesmoDiaTest2() {
        inicio = new Date(20,5,10,06,00);
        fim = new Date(20,5,10,22,00);

        assertTrue(Alocacao.checaMesmoDia(inicio,fim));
    }

    @Test
    public void checaMesmoDiaTest3() {
        inicio = new Date(20,5,10,10,44);
        fim = new Date(20,5,10,21,43);

        assertTrue(Alocacao.checaMesmoDia(inicio,fim));
    }

    @Test
    public void checaMesmoDiaTest4() {
        inicio=new Date(2020,10,14,12,30);
        fim=new Date(2020,11,14,20,45);
        assertFalse(Alocacao.checaMesmoDia(inicio,fim));
    }

    @Test
    public void checaMesmoDiaTest5() {
        inicio=new Date(2020,10,14,12,30);
        fim=new Date(2021,10,14,20,45);
        assertFalse(Alocacao.checaMesmoDia(inicio,fim));
    }
    @Test
    public void checaHorarioMinMaxTest1() {
        inicio=new Date(2020,10,14,5,30);
        fim=new Date(2020,10,14,21,45);
        assertFalse(Alocacao.checaHorarioMinMax(inicio,fim));

    }

    @Test
    public void checaHorarioMinMaxTest2() {
        inicio=new Date(2020,10,14,18,30);
        fim=new Date(2020,10,14,23,45);
        assertFalse(Alocacao.checaHorarioMinMax(inicio,fim));
    }

    @Test
    public void checaHorarioMinMaxTest3(){
        inicio = new Date(20,12,10,06,00);
        fim = new Date(20,12,10,22,00);

        assertTrue(Alocacao.checaHorarioMinMax(inicio,fim));
    }

    @Test
    public void checaHorarioMinMaxTest4(){
        inicio = new Date(20,12,10,8,0);
        fim = new Date(20,12,10,12,0);

        assertTrue(Alocacao.checaHorarioMinMax(inicio,fim));
    }
}




