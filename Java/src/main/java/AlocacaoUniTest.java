import org.junit.Test;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class AlocacaoUniTest {
    private static Date inicio,fim,inicio2,fim2;
    private static Medico medico,medico2;
    private static Sala sala,sala2;
    private static Alocacao alocacao,alocacao2;

    @Test(expected = IllegalArgumentException.class)
    public void excecaoTest1() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("pequena");
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("Neurologista");
        inicio=new Date(2020,10,14,19,30);
        fim=new Date(2020,10,14,21,50);
        new Alocacao(medico,sala,inicio,fim);
    }

    @Test(expected = IllegalArgumentException.class)
    public void excecaoTest2() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("pequena");
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("cirurgiao cardiovascular");
        inicio=new Date(2020,10,14,19,30);
        fim=new Date(2020,10,14,21,50);
        new Alocacao(medico,sala,inicio,fim);
    }

    @Test(expected = IllegalArgumentException.class)
    public void excecaoTest3() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("grande");
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("dermatologista");
        inicio=new Date(2020,10,14,19,30);
        fim=new Date(2020,10,14,21,50);
        new Alocacao(medico,sala,inicio,fim);
    }

    @Test(expected = IllegalArgumentException.class)
    public void excecaoTest4() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("alto-risco");
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("dermatologista");
        inicio=new Date(2020,10,14,19,30);
        fim=new Date(2020,10,14,21,50);
        new Alocacao(medico,sala,inicio,fim);
    }

    @Test(expected = IllegalArgumentException.class)
    public void excecaoTest5() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("pequena");
        when(sala.getTempoMinimoReservaH()).thenReturn(2);
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("dermatologista");
        inicio=new Date(2020,10,14,20,30);
        fim=new Date(2020,10,14,21,50);
        new Alocacao(medico,sala,inicio,fim);
    }

    @Test(expected = IllegalArgumentException.class)
    public void excecaoTest6() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("grande");
        when(sala.getTempoMinimoReservaH()).thenReturn(2);
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("neurologista");
        inicio=new Date(2020,10,14,20,30);
        fim=new Date(2020,10,14,21,40);
        new Alocacao(medico,sala,inicio,fim);
    }

    @Test(expected = IllegalArgumentException.class)
    public void excecaoTest7() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("alto-risco");
        when(sala.getTempoMinimoReservaH()).thenReturn(3);
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("neurologista");
        inicio=new Date(2020,10,14,19,30);
        fim=new Date(2020,10,14,21,45);
        new Alocacao(medico,sala,inicio,fim);
    }

    @Test(expected = IllegalArgumentException.class)
    public void excecaoTest8() {
        sala=mock(Sala.class);
    when(sala.getTipo()).thenReturn("grande");
    when(sala.getNome()).thenReturn("gama");
    when(sala.getTempoMinimoReservaH()).thenReturn(3);
    medico=mock(Medico.class);
    when(medico.getEspecialidade()).thenReturn("neurologista");
        when(medico.getNome()).thenReturn("Letinho de Mãe");
    inicio=new Date(2020,10,14,19,30);
    fim=new Date(2020,10,14,21,45);
        new Alocacao(medico,sala,inicio,fim);

        sala2=mock(Sala.class);
        when(sala2.getTipo()).thenReturn("grande");
        when(sala2.getNome()).thenReturn("gama");
        when(sala2.getTempoMinimoReservaH()).thenReturn(3);
        medico2=mock(Medico.class);
        when(medico2.getEspecialidade()).thenReturn("neurologista");
        when(medico2.getNome()).thenReturn("Maria Antonietta");
        inicio2=new Date(2020,10,14,10,23);
        fim2=new Date(2020,10,14,20,48);
        new Alocacao(medico,sala,inicio,fim);
    }

  /*  @Test(expected = IllegalArgumentException.class)
    public void excecaoTest9() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("grande");
        when(sala.getNome()).thenReturn("alfa");
        when(sala.getTempoMinimoReservaH()).thenReturn(3);
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("neurologista");
        when(medico.getNome()).thenReturn("Maria Antonietta");
        inicio=new Date(2020,10,14,12,0);
        fim=new Date(2020,10,14,21,45);
        new Alocacao(medico,sala,inicio,fim);

        sala2=mock(Sala.class);
        when(sala2.getTipo()).thenReturn("grande");
        when(sala2.getNome()).thenReturn("gama");
        when(sala2.getTempoMinimoReservaH()).thenReturn(3);
        medico2=mock(Medico.class);
        when(medico2.getEspecialidade()).thenReturn("neurologista");
        when(medico2.getNome()).thenReturn("Maria Antonietta");
        inicio2=new Date(2020,10,14,10,23);
        fim2=new Date(2020,10,14,20,48);
        new Alocacao(medico,sala,inicio,fim);
    }*/

    @Test(expected = IllegalArgumentException.class)
    public void excecaoTest10() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("alto-risco");
        when(sala.getTempoMinimoReservaH()).thenReturn(3);
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("neurologista");
        inicio=new Date(2020,10,14,5,30);
        fim=new Date(2020,10,14,21,45);
        new Alocacao(medico,sala,inicio,fim);
    }

    @Test(expected = IllegalArgumentException.class)
    public void excecaoTest11() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("alto-risco");
        when(sala.getTempoMinimoReservaH()).thenReturn(3);
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("neurologista");
        inicio=new Date(2020,10,14,18,30);
        fim=new Date(2020,10,14,23,45);
        new Alocacao(medico,sala,inicio,fim);
    }

    @Test(expected = IllegalArgumentException.class)
    public void excecaoTest12() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("alto-risco");
        when(sala.getTempoMinimoReservaH()).thenReturn(3);
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("neurologista");
        inicio=new Date(2020,10,14,12,30);
        fim=new Date(2020,10,15,20,45);
        new Alocacao(medico,sala,inicio,fim);
    }

    @Test
    public void getInicioTest1() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("alto-risco");
        when(sala.getTempoMinimoReservaH()).thenReturn(3);
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("neurologista");
        inicio=new Date(2020,10,14,12,30);
        fim=new Date(2020,10,14,20,45);
        alocacao=new Alocacao(medico,sala,inicio,fim);
        assertEquals(inicio,alocacao.getInicio());
    }

    @Test
    public void getFimTest1() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("alto-risco");
        when(sala.getTempoMinimoReservaH()).thenReturn(3);
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("neurologista");
        inicio=new Date(2020,10,14,12,30);
        fim=new Date(2020,10,14,20,45);
        alocacao=new Alocacao(medico,sala,inicio,fim);
        assertEquals(fim,alocacao.getFim());
    }

    @Test
    public void getCustoTest1() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("alto-risco");
        when(sala.getTempoMinimoReservaH()).thenReturn(3);
        when(sala.getCustoPorH()).thenReturn(1200.0);
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("neurologista");
        inicio=new Date(2020,10,14,12,30);
        fim=new Date(2020,10,14,20,45);
        alocacao=new Alocacao(medico,sala,inicio,fim);
        assertEquals(9900,alocacao.getCusto());
    }

    @Test
    public void toStringTest1() {
        sala=mock(Sala.class);
        when(sala.getTipo()).thenReturn("alto-risco");
        when(sala.getTempoMinimoReservaH()).thenReturn(3);
        when(sala.getCustoPorH()).thenReturn(1200.0);
        medico=mock(Medico.class);
        when(medico.getEspecialidade()).thenReturn("neurologista");
        inicio=new Date(2020,10,14,12,30);
        fim=new Date(2020,10,14,20,45);
        alocacao=new Alocacao(medico,sala,inicio,fim);
        assertEquals("ALOCACAO:" + "\n Medico responsavel: " + medico+"\n Sala: " + sala
                + "\n Data de inicio: " + inicio + "\n Data de termino: "+fim, alocacao.toString());
    }
}




