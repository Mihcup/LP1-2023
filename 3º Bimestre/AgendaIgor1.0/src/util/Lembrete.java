package util;

public class Lembrete extends Agendar {

    private String horario;
    public Lembrete(String nome, String data,String descricao,String horario) {
        super(nome, data,descricao);
        this.horario = horario;
    }

    public Lembrete(String nome, String data, String horario) {
        super(nome, data);
        this.horario = horario;

    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public void visualizar(int descricao) {
        System.out.println("Lembrete: ");
        if(descricao==1){
            if(super.getDescricao()==null){
                System.out.println("Nome: "+ getNome() + "\nHorário: "+horario+ "\nId:"+getId()+"\n");
            } else
                System.out.println("Nome: "+ getNome() + "\nHorário: "+horario+ "\nDescrição: "+getDescricao()+"\nId:"+getId()+"\n");
        }
        else if(descricao==2)
            System.out.println("Nome: "+ getNome()+ "\nHorário: "+horario+ "\nId: "+getId()+"\n");
        else
            System.out.println("Essa opção de visualização não está disponível");

    }
}//FimLembrete
