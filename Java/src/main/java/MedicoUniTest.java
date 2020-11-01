import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
public class MedicoUniTest {

    private static Medico medico;
    @Test
    public void getNomeTest1() {
        medico=new Medico("12345","Julio Cesar","Neurologista");

        assertEquals("Julio Cesar",medico.getNome());
    }

    @Test
    public void getCrmTest1() {
        medico=new Medico("12345","Julio Cesar","Neurologista");

        assertEquals("12345",medico.getCrm());
    }

    @Test
    public void getEspecialidadeTest1() {
        medico=new Medico("12345","Julio Cesar","Neurologista");

        assertEquals("Neurologista",medico.getEspecialidade());
    }

    @Test
    public void toStringTest1() {
        medico=new Medico("12345","Julio Cesar","Neurologista");

        assertEquals("Nome: "+"Julio Cesar"+"     especialidade: "+"Neurologista"+"     CRM: "+"12345",medico.toString());
    }

}
