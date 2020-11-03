import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
public class MedicoTest {

    private static String NOME = "Julio Cesar";
    private static String CRM = "12345";
    private static String ESPECIALIDADE = "Neurologista";

    private static Medico medico;

    @Test
    public void getNome() {
        medico=new Medico(CRM,NOME,ESPECIALIDADE);

        assertEquals(NOME,medico.getNome());
    }

    @Test
    public void getCrm() {
        medico=new Medico(CRM,NOME,ESPECIALIDADE);

        assertEquals(CRM,medico.getCrm());
    }

    @Test
    public void getEspecialidade() {
        medico=new Medico(CRM,NOME,ESPECIALIDADE);

        assertEquals(ESPECIALIDADE,medico.getEspecialidade());
    }

    @Test
    public void toStringTest() {
        medico=new Medico(CRM,NOME,ESPECIALIDADE);

        System.out.println(medico.toString());
        assertEquals("Nome: "+NOME+"     especialidade: "+ESPECIALIDADE+"     CRM: "+CRM,medico.toString());
    }

}
