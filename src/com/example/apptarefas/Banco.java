package com.example.apptarefas;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {

	public Banco(Context context) {
		super(context, "bdtarefas", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = 	"CREATE TABLE tarefa ( " +
						" id INTEGER PRIMARY KEY AUTOINCREMENT, " +
						" descricao TEXT NOT NULL , " +
						" local     TEXT NOT NULL , " +
						" data      TEXT NOT NULL);";
		
		db.execSQL(sql);
	}
	
	public boolean insereTarefa(Tarefa tarefa) {
		SQLiteDatabase bd = this.getWritableDatabase();
		ContentValues valores = new ContentValues();
		valores.put("descricao",  tarefa.getDescricao());
		valores.put("local",  tarefa.getLocal());
		valores.put("data",  tarefa.getData());
		if (bd.insert("tarefa",  null,  valores) > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<Tarefa> consultaTodas() {
		String sql = "SELECT * FROM tarefa";
		
		SQLiteDatabase bd = this.getReadableDatabase();
		Cursor c = bd.rawQuery(sql, null);
		if (c != null) {
			if (c.moveToFirst()) {
				ArrayList<Tarefa> listaTarefas = new ArrayList<Tarefa>();
				do {
					Tarefa tarefa = new Tarefa();
					tarefa.setId(c.getLong(0));
					tarefa.setDescricao(c.getString(1));
					tarefa.setData(c.getString(2));
					tarefa.setLocal(c.getString(3));
					listaTarefas.add(tarefa);
				}while (c.moveToNext());
				return listaTarefas;
			}
		}
		return null;
	}
	
	public boolean apagaTarefa(long id) {
		SQLiteDatabase bd = this.getWritableDatabase();
		if (bd.delete("tarefa", "id="+id, null) > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
