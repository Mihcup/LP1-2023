package br.dedigados.gerenciadordetarefas_lp1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GerenciadorApplication extends Application {

    private static Stage stage;
    private static Scene cadastroScene;
    private static Scene loginScene;
    private static Scene telaPrincipalScene;



    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(GerenciadorApplication.class.getResource("login.fxml"));
        FXMLLoader fxmlLoader2 = new FXMLLoader(GerenciadorApplication.class.getResource("cadastro.fxml"));
        FXMLLoader fxmlLoader3 = new FXMLLoader(GerenciadorApplication.class.getResource("telaPrincipal.fxml"));
        cadastroScene = new Scene(fxmlLoader2.load());
        loginScene = new Scene(fxmlLoader.load());
        telaPrincipalScene = new Scene(fxmlLoader3.load());


        stage.setTitle("Gerenciador de Tarefas!");
        stage.setScene(loginScene);
        stage.show();
    }

    public static void mudarTela(String src) {
        switch(src) {
            case "login":
                stage.setScene(loginScene);
                break;
            case "cadastro":
                stage.setScene(cadastroScene);
                break;
            case "telaPrincipal":
                stage.setScene(telaPrincipalScene);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
