package util;

public class Tarefa extends Agendar {


    public Tarefa(String nome, String data,String descricao) {
        super(nome, data,descricao);
    }

    public Tarefa(String nome, String data) {
        super(nome, data);
    }

    @Override
    public void visualizar(int descricao) {
        System.out.println("Tarefa: ");
        if(descricao==1){
            if(super.getDescricao()==null){
                System.out.println("Nome: "+ getNome() + "\nId:"+getId()+"\n");
            } else
            System.out.println("Nome: "+ getNome() + "\nDescrição: "+getDescricao()+ "\nId:"+getId()+"\n");
        }
        else if(descricao==2)
            System.out.println("Nome: "+ getNome()+"\nId:"+getId()+"\n");
        else
            System.out.println("Essa opção de visualização não está disponível");
    }
}//FimTarefa
