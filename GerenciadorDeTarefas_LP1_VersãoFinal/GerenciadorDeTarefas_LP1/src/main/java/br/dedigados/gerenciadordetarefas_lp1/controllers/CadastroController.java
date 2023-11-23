package br.dedigados.gerenciadordetarefas_lp1.controllers;

import br.dedigados.gerenciadordetarefas_lp1.GerenciadorApplication;
import br.dedigados.gerenciadordetarefas_lp1.model.Usuario;
import br.dedigados.gerenciadordetarefas_lp1.service.UsuarioService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CadastroController {
    @FXML
    private TextField txtnome;
    @FXML
    private TextField txtusuario;
    @FXML
    private PasswordField txtsenha;

    @FXML
    private Label aviso;
    UsuarioService usuarioService = new UsuarioService();


    public void mudaLogin(ActionEvent event) {

        String nome = txtnome.getText();
        String usuario = txtusuario.getText();
        String senha = txtsenha.getText();

        if(nome.isEmpty() && usuario.isEmpty() && senha.isEmpty())
            exibirErro(0);

        else  if(nome.isEmpty())
            exibirErro(1);

        else if(usuario.isEmpty())
            exibirErro(2);

        else if(senha.isEmpty())
            exibirErro(3);

        else {
            Usuario u = new Usuario(nome,usuario,senha);
            salvarUsuario(u);
        }
    }

    public void salvarUsuario(Usuario usuario){
        usuarioService.salvarUsuario(usuario);
        GerenciadorApplication.mudarTela("login");
    }

    public void retornar(ActionEvent event) {
        //método para o novo botão
        GerenciadorApplication.mudarTela("login");
    }


    public void exibirErro(int i) {
        if(i==0)
            aviso.setText("Campos vazios !!");

        else if(i==1)
            aviso.setText("Campo nome vazio !!");

        else if(i==2)
            aviso.setText("Campo usuário vazio !!");

        else if(i==3)
            aviso.setText("Campo Senha vazio !!");

    }


}
