package util;

public class Evento extends Agendar {
 private int id;

    private String horario;
    public Evento(String nome, String data,String descricao,String horario) {
        super(nome, data, descricao);
        this.horario = horario;

    }

    public Evento(String nome, String data, String horario) {
        super(nome, data);
        this.horario = horario;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }


    @Override
    public void visualizar(int descricao) {
        System.out.println("Evento: ");
        if(descricao==1){
            if(super.getDescricao()==null){
                System.out.println("Nome: "+ getNome() + "\nHorário: "+horario+ "\nId:"+getId()+"\n");
            } else
            System.out.println("Nome: "+ getNome() + "\nHorário: "+horario+ "\nDescrição: "+getDescricao()+"\nId:"+getId()+"\n");
    } else if(descricao==2)
            System.out.println("Nome: "+ getNome()+ "\nHorário: "+horario+ "\nId:"+getId()+"\n");
        else
            System.out.println("Essa opção de visualização não está disponível");
}

}//FimEvento
