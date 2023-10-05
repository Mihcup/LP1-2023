package util;
import java.util.*;

public  class  Dados {
    private  List<Agendar> agendamentos = new ArrayList<>();
    private static int definidordeid = 1;

    //método para adicionar um agendamento na agenda
    public void addAgendamento(Agendar ag)  {

        if (ag instanceof Evento) {
            boolean intermedia = false;
                for (Agendar a : agendamentos) {
                    if (a instanceof Evento) {
                        //verificação da existência de eventos no mesmo dia e horário
                        if (a.getData().equals(ag.getData())) {
                            if (((Evento) a).getHorario().equals(((Evento) ag).getHorario())) {
                                System.out.println("Conflito de Horário! Já temos um evento com essa mesma data e horário");
                                a.visualizar(2);
                                intermedia = true; 
                            }
                        }
                    }
                }

                if(!intermedia){
                    agendamentos.add(ag);
                    ag.setId(definidordeid++);
                    System.out.println("Novo evento adicionado");
                }
        }


        if (ag instanceof Tarefa) {
            //adiciona uma tarefa na lista "agendamentos"
            agendamentos.add(ag);
            ag.setId(definidordeid++);
            System.out.println("Nova tarefa adicionada!");

        }
        if (ag instanceof Lembrete) {
            //adiciona um lembrete na lista "agendamentos"
            agendamentos.add(ag);
            ag.setId(definidordeid++);
            System.out.println("Novo lembrete adicionado!");
        }
        }


    public void exibir(String data, int escolha, int descricao) {
        //exibição de acordo com uma data
        switch (escolha) {
            //geral
            case 1: {
                System.out.println("====Agendamentos do dia " +data+ " ==== ");
                for (Agendar ag : agendamentos) {
                    if (ag.getData().equals(data)) {
                       ag.visualizar(descricao);
                    }

                }
            }
            break;
            //lembrete
            case 2: {
                System.out.println("====Lista de lembretes do dia " + data+" ====");
                for (Agendar ag : agendamentos) {
                    if (ag.getClass() == Lembrete.class && ag.getData().equals(data)) {
                        ag.visualizar(descricao);
                    }
                }
            }
            break;

            //Evento
            case 3: {
                System.out.println("====Lista de Eventos do dia " +data+" =====");
                for (Agendar ag : agendamentos) {
                    if (ag.getClass() == Evento.class && ag.getData().equals(data)) {
                        ag.visualizar(descricao);
                    }
                }
            }
            break;

            //Tarefa
            case 4: {
                System.out.println("====Lista de Tarefas do "+ data+" =====");
                for (Agendar ag : agendamentos) {
                    if (ag.getClass() == Tarefa.class && ag.getData().equals(data)) {
                        ag.visualizar(descricao);
                    }
                }
            }
            break;
            default:
                System.out.println("Opção de exibição inválida!");
        }
    }
    public void exibirAgenda(){
        //exibição da agenda completa
        List<DateItem> datas = new ArrayList<>();
        for (Agendar ag: agendamentos) {
            datas.add(new DateItem(ag.getData()));
        }
        Collections.sort(datas, new SortByDate());
        //ordena a lista de datas dos agendamentos
        for (DateItem d: datas){
            for(Agendar ag: agendamentos) {
                if(ag.getData()==d.getDate()){
                    System.out.println(ag.getData());
                    ag.visualizar(1);
                }
            }
        }
    }

    //SortByDate e DateItem são classes utilizadas para ordenar os agendamentos em ordem cronológica :)
    public static class SortByDate implements Comparator<DateItem> {
        @Override
        public int compare(DateItem a, DateItem b) {
            return a.date.compareTo(b.date);
        }
    }
    public class DateItem {
        String date;

        DateItem(String date) {
            this.date = date;
        }

        public String getDate() {
            return date;
        }
    }

    public void removeAgendamento(int id){
        boolean found = true;
        for (Agendar ag : agendamentos) {
            if (ag.getId() == id) {
                agendamentos.remove(ag);
                found = true;
                System.out.println("removido");
                break;
            } else found = false;
        }
        if (!found)
            System.out.println("Id não existe");
    }


    public List<Agendar> getAgendamentos() {
        return agendamentos;
    }



}//end