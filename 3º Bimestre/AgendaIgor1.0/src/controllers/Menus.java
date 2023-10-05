package controllers;
import util.*;

import java.util.Collections;
import java.util.Scanner;

public class Menus {
    private static Dados dado = new Dados();
    private static Scanner scan = new Scanner(System.in);

    public static void telaInicial(){
        char cont ;
        System.out.println("Deseja realizar alguma operação? Se sim digite qualquer tecla, senão digite 0");
        cont = scan.next().charAt(0);
        if(cont!='0') {
            do {
                System.out.println("O que deseja fazer?\n1.Adicionar algo em sua agenda?\n2.Alterar algo em sua agenda?\n3.Cancelar algo?\n4.Visualizar por data?\n5.Visualizar a agenda completa?");
                int op = scan.nextInt();
                if (dado.getAgendamentos().isEmpty() && op != 1 && op<=5) {
                    //testar se lista está vazia e, caso esteja, deverá adicionar algo primeiro
                    System.out.println("Sua agenda está vazia, adicione algo!!");
                    escolha(1);
                } else
                    escolha(op);
                System.out.println("Deseja realizar algo a mais? Se sim digite qualquer tecla, senão digite 0");
                cont = scan.next().charAt(0);
            } while (cont != '0');
        }
    }
    public static void escolha(int op){
        switch (op) {
            case 1: {
                String horarioAgendamento = null;
                String descricaoAgendamento;
                String nomeAgendamento;
                String dataAgendamento;

                System.out.println("O que deseja adicionar em sua agenda? \n1.Tarefa \n2.Evento \n3.Lembrete");
                int tipoAgendamento = scan.nextInt();
                scan.nextLine();

                if (tipoAgendamento >= 1 && tipoAgendamento <= 3) {
                    System.out.println("Digite o nome do agendamento: ");
                    nomeAgendamento = scan.nextLine();

                    System.out.println("Digite a data do agendamento: ");
                    dataAgendamento = scan.nextLine();
                    if (!Validations.validardate(dataAgendamento)) {
                        System.out.println("Esse formato de data é inválido");
                        do {
                            System.out.println("Digite novamente a data do agendamento, a anterior foi inválida: ");
                            dataAgendamento = scan.nextLine();
                        } while (!Validations.validardate(dataAgendamento));
                    }

                    if (tipoAgendamento == 2 || tipoAgendamento == 3) {
                        System.out.println("Qual o horário?");
                        horarioAgendamento = scan.nextLine();
                        if (!Validations.validarhour(horarioAgendamento)) {
                            System.out.println("Esse formato de hora é inválido");
                            do {
                                System.out.println("Digite novamente a hora do agendamento, a anterior foi inválida: ");
                                horarioAgendamento = scan.nextLine();
                            } while (!Validations.validarhour(horarioAgendamento));
                        }
                    }
                    System.out.println("Deseja adicionar descrição? Se sim digite 1, caso contrário 2 ");
                    char desc = scan.next().charAt(0);
                    scan.nextLine();
                    if (desc != '1' && desc != '2') {
                        do {
                            System.out.println("opção inválida! digite 1 para adicionar descrição ou 2 para não adicionar");
                            desc = scan.next().charAt(0);
                        } while (desc != '1' && desc != '2');
                    }

                    if (desc == '1') {
                        //adição de objetos com descrição
                        System.out.println("Descrição: ");
                        descricaoAgendamento = scan.nextLine();

                        if (tipoAgendamento == 1)
                            dado.addAgendamento(new Tarefa(nomeAgendamento, dataAgendamento, descricaoAgendamento));
                        else if (tipoAgendamento == 2)
                            dado.addAgendamento(new Evento(nomeAgendamento, dataAgendamento, descricaoAgendamento, horarioAgendamento));
                        else if (tipoAgendamento == 3)
                            dado.addAgendamento(new Lembrete(nomeAgendamento, dataAgendamento, descricaoAgendamento, horarioAgendamento));
                    } else {
                        if (desc == '2') {
                            //adiciona objetos que ficarão com a descrição vazia
                            if (tipoAgendamento == 1) {
                                dado.addAgendamento(new Tarefa(nomeAgendamento, dataAgendamento));
                            } else {
                                if (tipoAgendamento == 2) {
                                    dado.addAgendamento(new Evento(nomeAgendamento, dataAgendamento, horarioAgendamento));
                                } else {
                                    if (tipoAgendamento == 3) {
                                        dado.addAgendamento(new Lembrete(nomeAgendamento, dataAgendamento, horarioAgendamento));
                                    }
                                }
                            }
                        }
                    }
                } else
                    System.out.println("Opção inválida");
                break;
            }
            case 2: { //alterar
                dado.exibirAgenda();
                System.out.println("Qual o id do agendamento que você deseja alterar?");
                int idd = scan.nextInt();
                System.out.println("O que você deseja alterar em seu agendamento? \n1.Nome\n2.Data\n3.Descrição");
                for (Agendar a : dado.getAgendamentos()) {
                    if(a.getId() == idd){
                        if (a instanceof Evento || a instanceof Lembrete)
                            System.out.println("4.Horário");
                    }

                }
                int alter = scan.nextInt(); //variável que armazena a opção que será alterada
                String intermedia = scan.nextLine(); //variável criada para conseguirmos ler
                for (Agendar ag : dado.getAgendamentos()) {
                    if (ag.getId() == idd) {
                        switch (alter) {
                            case 1: {
                                System.out.println("Digite o novo nome ");
                                ag.setNome(scan.nextLine());
                                break;
                            }
                            case 2: {
                                System.out.println("Digite a nova data ");
                                String newdata = scan.nextLine();
                                if (Validations.validardate(newdata))
                                    ag.setData(newdata);
                                else
                                    System.out.println("Formato de data errado!");
                                break;
                            }
                            case 3: {
                                System.out.println("Digite a nova descrição ");
                                ag.setDescricao(scan.nextLine());
                                break;
                            }

                            case 4: {
                                System.out.println("Digite o novo horario ");
                                String newhour = scan.nextLine();
                                if (ag instanceof Evento) {
                                    if (Validations.validarhour(newhour))
                                        ((Evento) ag).setHorario(newhour);
                                    else
                                        System.out.println("Formato de hora errado!");
                                }

                                if(ag instanceof Lembrete){
                                    if (Validations.validarhour(newhour))
                                        ((Lembrete) ag).setHorario(newhour);
                                    else
                                        System.out.println("Formato de hora errado!");
                                }
                                break;
                            }
                            default:
                                System.out.println("Não existe essa opção");
                                break;
                        }
                    } else {
                        System.out.println("ID NÃO ENCONTRADO!");
                    }
                }
                break;
            }
            case 3:{
                //remover um agendamento
                dado.exibirAgenda();
                System.out.println("Qual o id do agendamento que você deseja remover?");
                int id = scan.nextInt();
                dado.removeAgendamento(id);
                break;
            }
            case 4: {
                //exibição segundo uma data
                System.out.println("Qual data deseja visualizar? ");
                String date = scan.nextLine();
                date = scan.nextLine();
                System.out.println("Como deseja sua exibição? \n1.Completa\n2.Apenas lembretes\n3.Apenas eventos\n4.Apenas tarefas");
                int opcao = scan.nextInt();
                System.out.println("Deseja ver a descrição dos agendamentos também? \n1.Para visualizar com descrição \n2.Para visualizar sem descrição");
                int desc = scan.nextInt();
                String linha = scan.nextLine();
                dado.exibir(date, opcao, desc);
                break;
            }
            case 5:{
                //exibição da agenda completa
                dado.exibirAgenda();
                break;
            }
            default:
                System.out.println("Não existe essa opção");
        }
    }
}

