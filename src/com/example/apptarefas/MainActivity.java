package com.example.apptarefas;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
Banco meuBanco;

	public void insereTarefa(View v) {
		EditText editText1 = (EditText) findViewById(R.id.editText1);
		EditText editText2 = (EditText) findViewById(R.id.editText2);
		EditText editText3 = (EditText) findViewById(R.id.editText3);
		Tarefa tarefa = new Tarefa();
		tarefa.setDescricao(editText1.getText().toString());
		tarefa.setData(editText2.getText().toString());
		tarefa.setLocal(editText3.getText().toString());
		if (meuBanco.insereTarefa(tarefa)) {
			Toast.makeText(getApplicationContext(), "Tarefa Inserida", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(getApplicationContext(), "Dados Não Inseridos", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void apagaTarefa(View v) {
		EditText editText5 = (EditText) findViewById(R.id.editText5);
		try {
			long id = Long.parseLong(editText5.getText().toString());
			if (meuBanco.apagaTarefa(id)) {
				Toast.makeText(getApplicationContext(), "Dados Apagados", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(getApplicationContext(), "Dados Não Apagados", Toast.LENGTH_SHORT).show();
			}
		} catch(Exception e) {
			Toast.makeText(getApplicationContext(), "Digite id Válido", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void consultaTarefa(View v) {
		ArrayList<Tarefa>  listaTarefa = meuBanco.consultaTodas();
		if (listaTarefa != null) {
			String tarefas="";
			for (int i=0; i < listaTarefa.size(); i++) {
				tarefas+= listaTarefa.get(i).getId() + " ";
				tarefas+= listaTarefa.get(i).getDescricao() + " ";
				tarefas+= listaTarefa.get(i).getLocal() + " ";
				tarefas+= listaTarefa.get(i).getData() + "\n";
			}
			EditText editText4 = (EditText) findViewById(R.id.editText4);
			editText4.setText(tarefas);
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		meuBanco = new Banco(getApplicationContext());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
