public class Medico {
    private String crm;
    private String nome;
    private String especialidade;

    public Medico(String crm, String nome, String especialidade){
        this.crm = crm;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public String getCrm(){
        return this.crm;
    }

    public String getNome(){
        return this.nome;
    }

    public String getEspecialidade(){
        return this.especialidade;
    }

    @Override
    public String toString(){
        return "Nome: "+this.nome+"     especialidade: "+this.especialidade+"     CRM: "+this.crm;
    }
}