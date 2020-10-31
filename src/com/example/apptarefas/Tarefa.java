package com.example.apptarefas;

public class Tarefa {
private long id;
private String descricao;
private String local;
private String data;

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
public String getLocal() {
	return local;
}
public void setLocal(String local) {
	this.local = local;
}
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}


}
