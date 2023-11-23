
module br.dedigados.gerenciadordetarefas_lp1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;



    opens br.dedigados.gerenciadordetarefas_lp1 to javafx.fxml;
    opens br.dedigados.gerenciadordetarefas_lp1.controllers to javafx.fxml;
    exports br.dedigados.gerenciadordetarefas_lp1;
    exports br.dedigados.gerenciadordetarefas_lp1.model;
    opens br.dedigados.gerenciadordetarefas_lp1.model to org.hibernate.orm.core;
    exports br.dedigados.gerenciadordetarefas_lp1.controllers;

}
