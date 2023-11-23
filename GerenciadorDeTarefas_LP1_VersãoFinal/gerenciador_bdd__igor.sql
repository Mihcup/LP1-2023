create database gerenciadordetarefas;
ALTER TABLE usuario_tarefa DROP FOREIGN KEY FKrct0ruh5wta5h50l950ff7r4a;
ALTER TABLE usuario_tarefa ADD CONSTRAINT FKrct0ruh5wta5h50l950ff7r4a FOREIGN KEY (tarefas_id) REFERENCES tarefa(id) ON DELETE CASCADE;
insert into Categoria(nome) values("Projeto"); 