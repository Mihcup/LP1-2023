package br.dedigados.gerenciadordetarefas_lp1.controllers;

import br.dedigados.gerenciadordetarefas_lp1.GerenciadorApplication;
import br.dedigados.gerenciadordetarefas_lp1.model.Categoria;
import br.dedigados.gerenciadordetarefas_lp1.model.Tarefa;
import br.dedigados.gerenciadordetarefas_lp1.model.Usuario;
import br.dedigados.gerenciadordetarefas_lp1.service.CategoriaService;
import br.dedigados.gerenciadordetarefas_lp1.service.TarefaService;
import br.dedigados.gerenciadordetarefas_lp1.service.UsuarioService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

    public class TelaPrincipalController implements Initializable {

        @FXML
        private Label aviso;

        @FXML
        private TableColumn<Tarefa, String> titulo;
        @FXML
        private TableColumn<Tarefa, Integer> colid;

        @FXML
        private TableColumn<Tarefa, String> datee;

        @FXML
        private TableColumn<Tarefa, String> descri;

        @FXML
        private TableColumn<Tarefa, Boolean> checkBoxCol;

        @FXML
        private TableView<Tarefa> tabela;
        @FXML
        private TextField tituloTarefa;
        @FXML
        private TextField descricaoTarefa;
        @FXML
        private DatePicker dataTarefa;
        @FXML
        private Button btnsalvar;
        @FXML
        private MenuButton btnCategoria;
        @FXML
        private TextField categoria;

        @FXML
        private MenuButton btnCategorias;
        @FXML
        private Label mensagemProgresso;
        Integer id = null;
        CategoriaService categoriaService = new CategoriaService();

        TarefaService tarefaService = new TarefaService();

        List<Tarefa> tarefinhas = new ArrayList<>();
        List<Categoria> categorias = new ArrayList<>();
        private Usuario usuario = new Usuario();
        private CadastroController cadastroController = new CadastroController();
        private UsuarioService usuarioService = new UsuarioService();
        Integer idCategoria = null;
        private String nomeCategoria;
        @FXML
        private ProgressBar progressBar;



        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            mostrarTarefinhas();
            mostrarCategorias();
            usuario = LoginController.getUsuario();
            selecionarCategorias();
            categorias = categoriaService.listaCategoria();
        }

        private void mostrarTarefinhas() {
            tarefinhas = tarefaService.listaTarefas();
            tabela.setItems(FXCollections.observableList(tarefinhas));
            colid.setCellValueFactory(new PropertyValueFactory<>("id"));
            titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
            descri.setCellValueFactory(new PropertyValueFactory<>("descricao"));
            checkBoxCol.setCellValueFactory(new PropertyValueFactory<>("status"));
            datee.setCellValueFactory(new PropertyValueFactory<>("dataDeVencimento")); //métodos para atribuir as colunas aos campos da classe tarefa


            checkBoxCol.setCellFactory(tc -> new CheckBoxTableCell<Tarefa, Boolean>() {
                @Override
                public void updateItem(Boolean item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                        CheckBox checkBox = new CheckBox(); // cria a nova check box
                        checkBox.setSelected(item); //atribuição do status dela
                        setGraphic(checkBox); // seta ela graficamente

                        checkBox.setOnAction(event -> {
                            Tarefa tarefa = getTableView().getItems().get(getIndex());
                            tarefa.setStatus(checkBox.isSelected());
                            editarStatus(tarefa);
                        });
                    }
                }
            });
        }

        @FXML
        public void salvarTarefa() {
            Categoria cat = new Categoria(nomeCategoria,idCategoria);
            String nome = tituloTarefa.getText();
            String descricao = descricaoTarefa.getText();
            String data = String.valueOf(dataTarefa.getValue());

            // Obtém o nome da categoria selecionada no botão
            String nomeCategoria = btnCategorias.getText();
            System.out.println(nomeCategoria);
            // Verifica se a categoria já existe
            Categoria categoriaExistente = null;
            for (Categoria c : categorias) {
                System.out.println(c.getNome());
                if (c.getNome()==nomeCategoria) {
                    categoriaExistente = c;
                    break;
                }
            }

            // Se a categoria não existir, cria uma nova
            if (categoriaExistente == null) {
                Categoria novaCategoria = new Categoria(nomeCategoria);
                categoriaService.salvarCategoria(novaCategoria);
                cat.setId(novaCategoria.getId());
                cat.setNome(novaCategoria.getNome());
                System.out.println("erro"+cat.getNome());
            } else {
                cat.setId(categoriaExistente.getId());
                cat.setNome(categoriaExistente.getNome());
                System.out.println("deu"+cat.getNome());
            }

            Tarefa t = new Tarefa(nome, descricao, data, false, cat);
            usuario.addTarefa(t);
            usuarioService.editarUsuario(usuario);
            mostrarTarefinhas();
        }


        @FXML
        void deletarTarefa(ActionEvent event) {
            tarefaService.deletarTarefa(id);
            mostrarTarefinhas();
        }

        @FXML
        void editarTarefa(ActionEvent event) {
            Tarefa tarefa = tarefaService.buscarTarefa(id);
            tarefa.setTitulo(tituloTarefa.getText());
            tarefa.setDescricao(descricaoTarefa.getText());
            tarefa.setDataDeVencimento(String.valueOf(dataTarefa.getValue()));
            tarefaService.salvarTarefa(tarefa);
            mostrarTarefinhas();
        }

        void editarStatus(Tarefa tarefa) {
            tarefaService.editarTarefa(tarefa);
            mostrarTarefinhas();
        }

        @FXML
        void getData(MouseEvent event) {
            Tarefa tarefa = tabela.getSelectionModel().getSelectedItem();
            id = tarefa.getId();
            tituloTarefa.setText(tarefa.getTitulo());
            descricaoTarefa.setText(tarefa.getDescricao());
            dataTarefa.setValue(LocalDate.parse(tarefa.getDataDeVencimento()));
            btnsalvar.setDisable(true);
        }

        void clear(){
            mostrarTarefinhas();
            id = null;
            tituloTarefa.setText(null);
            descricaoTarefa.setText(null);
            dataTarefa.setValue(null);
            btnsalvar.setDisable(false);
        }

        @FXML
        void limparTarefa(ActionEvent event) {
            clear();
        }

        @FXML
        public void selecionarCategorias() {
            System.out.println("teste");
            categorias = categoriaService.listaCategoria();
            btnCategorias.getItems().clear();
            for (Categoria categoria : categorias) {
                MenuItem menuItem = new MenuItem(categoria.getNome());
                menuItem.setOnAction(event -> {
                    btnCategorias.setText(categoria.getNome());
                });
                btnCategorias.getItems().add(menuItem);
            }
        }

        public void mostrarCategorias() {
            categorias = categoriaService.listaCategoria();
            btnCategoria.getItems().clear();
            for (Categoria categoria : categorias) {
                MenuItem menuItem = new MenuItem(categoria.getNome());
                menuItem.setOnAction(event -> {
                    btnCategoria.setText(categoria.getNome());
                });
                btnCategoria.getItems().add(menuItem);
            }
        }

        @FXML
        public void retornar(ActionEvent event) {
            GerenciadorApplication.mudarTela("login");
        }
        @FXML
        public void getDataCategoria(MouseEvent event){
            String categoria1 = btnCategoria.getText();
            List<Categoria> categorias = categoriaService.listaCategoria();
            for(Categoria c: categorias){
                if(c!=null){
                    if(c.getNome().equals(categoria1)){
                        categoria.setText(c.getNome());
                        idCategoria = c.getId();
                    }
                }
            }
        }

        @FXML
        public void getCategoria(MouseEvent event){
            String categoria1 = btnCategorias.getText();
            List<Categoria> categorias = categoriaService.listaCategoria();
            for(Categoria c: categorias){
                if(c!=null){
                    if(c.getNome().equals(categoria1)){
                        nomeCategoria= categoria1;
                        idCategoria = c.getId();
                    }
                }
            }
        }

        @FXML
        public void adicionarMenuItem(ActionEvent actionEvent) {
            MenuItem novoItem = new MenuItem(categoria.getText());
            novoItem.setOnAction(event -> btnCategoria.setText(categoria.getText())); // Ação ao clicar no novo item
            categoriaService.salvarCategoria(new Categoria(categoria.getText()));
            mostrarCategorias();
            selecionarCategorias();
        }
        @FXML
        public void excluirMenuItem(ActionEvent actionEvent) {
            for(Categoria c: categorias){
                if(c.getNome().equals(categoria.getText())){
                    categoriaService.deletarCategoria(c.getId());
                    mostrarCategorias();
                    selecionarCategorias();
                }
            }
        }

        @FXML
        void editarCategoria(ActionEvent event) {
            System.out.println(idCategoria);
            Categoria cat = categoriaService.buscarCategoria(idCategoria);
            cat.setNome(categoria.getText());
            categoriaService.editarCategoria(cat);
            mostrarCategorias();
            selecionarCategorias();
        }

        public void atualizarProgressBar() {
            double progresso =0;
            progressBar.setProgress(progresso);
            int qtdFeito = 0;
            tarefinhas = tarefaService.listaTarefas();
            for(Tarefa tarefa: tarefinhas){
                if(tarefa.isStatus()){
                    qtdFeito++;
                }
            }
            progresso = (100*qtdFeito)/tarefinhas.size();
            progressBar.setProgress(progresso/100);

            if (progresso>50){
                mensagemProgresso.setText("Ótimo desempenho");
            }else {
                if(progresso==50){
                    mensagemProgresso.setText("Médio desempenho");
                }else {
                    mensagemProgresso.setText("Péssimo desempenho");
                }
            }
        }
    }
