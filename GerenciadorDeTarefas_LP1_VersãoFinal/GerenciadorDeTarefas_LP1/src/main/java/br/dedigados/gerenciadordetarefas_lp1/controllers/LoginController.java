package br.dedigados.gerenciadordetarefas_lp1.controllers;

import br.dedigados.gerenciadordetarefas_lp1.GerenciadorApplication;
import br.dedigados.gerenciadordetarefas_lp1.model.Usuario;
import br.dedigados.gerenciadordetarefas_lp1.util.HibernateUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import org.hibernate.query.Query;

public class LoginController {

    @FXML
    private TextField user;
    @FXML
    private TextField senha;
    @FXML
    private Label aviso;
    @FXML
    private Button idCadastreSe;
    private static Usuario usuario = new Usuario();


    public void initialize() {
        // Adiciona um efeito de sombra quando o mouse entra no botão
        idCadastreSe.setOnMouseEntered((MouseEvent e) -> {
            idCadastreSe.setEffect(new DropShadow());
        });

        // Remove o efeito de sombra quando o mouse sai do botão
        idCadastreSe.setOnMouseExited((MouseEvent e) -> {
            idCadastreSe.setEffect(null);
        });
    }


    public void entrar(ActionEvent actionEvent) {
        String login = user.getText();
        String senha1 = senha.getText();

        if(login.isEmpty() && senha1.isEmpty())
            exibirErro(0);

        else  if(login.isEmpty())
            exibirErro(1);

        else if(senha1.isEmpty())
            exibirErro(2);

        else{
            //consulta
            String hql = "FROM Usuario u WHERE u.login = :login AND u.senha = :senha";//consulta se as info digitadas correspondem às info de algum usuario do banco
            Query<Usuario> query = HibernateUtil.getSessionFactory().openSession().createQuery(hql, Usuario.class);
            query.setParameter("login", user.getText());
            query.setParameter("senha", senha.getText());
            this.usuario = query.getSingleResult();//adiciona o usuario encontrado (o usuário cujas info que correspondem às info digitadas) em uma lista
            if (usuario!=null) {//verifico se a lista não está vazia
                //como a lista não está vazia, então significa que o usuário foi encontrado no banco (ele já possuia cadastrado)
                GerenciadorApplication.mudarTela("telaPrincipal"); //pode prosseguir pra próx pg
            } else {
                exibirErro(3); //chama o método que printa um erro
            }
        }
    }



    public void exibirErro(int i) {
        // vai jogar essa mensagem lá no label encoberto de acordo com o numero recebido
        if(i==0)
            aviso.setText("Campos  vazios !!");

        else if(i==1)
            aviso.setText("Campo nome vazio !!");

        else if(i==2)
            aviso.setText("Campo Senha vazio !!");
        else
            aviso.setText("inválido!!");


    }
    public void mudaCadastro() {

        GerenciadorApplication.mudarTela("cadastro");
    }

    public static Usuario getUsuario() {
        return usuario;
    }

}