package com.example.victor.projetofinalappandroid;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;

//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Victor Hugo Billi de Oliveira Dias
//******************************************************
/**
 * Created by Victor on 22/06/2017.
 */
public class DBHelper {
    private static final String DATABASE_NAME = "teste.db"; //Nome do banco de dados
    private static final int DATABASE_VERSION = 1; //Versão do banco de dados
    private static final String TABLE_NAME = "contato"; //Nome da tabela do banco de dados

    private Context context;
    private SQLiteDatabase db;
    private SQLiteStatement insertStnt;
    private static final String INSERT = "INSERT INTO " + TABLE_NAME +" (nome,cpf,ida,tel,email) VALUES (?,?,?,?,?)";


    public DBHelper(Context context) {
        this.context = context;
        OpenHelper openHelper = new OpenHelper(this.context);
        this.db = openHelper.getWritableDatabase();
        this.insertStnt = this.db.compileStatement(INSERT);
    }

    //código para inserir as informações no banco de dados
    public long insert(String nome, String cpf, String ida, String tel, String email) {
        this.insertStnt.bindString(1, nome);
        this.insertStnt.bindString(2, cpf);
        this.insertStnt.bindString(3, ida);
        this.insertStnt.bindString(4, tel);
        this.insertStnt.bindString(5, email);

        return this.insertStnt.executeInsert();
    }

    //código para deletar as informações do banco de ados
    public void deleteAll() {
        this.db.delete(TABLE_NAME, null, null);
    }

    //código para listar as informações no banco de dados
    public List<Contato> queryGetAll() {

        List<Contato> list = new ArrayList<Contato>();

        try {
            Cursor cursor = this.db.query(TABLE_NAME, new String[]{"nome", "cpf", "ida", "tel", "email"},
                    null, null, null, null, null, null);

            int nregistros = cursor.getCount();

            if (nregistros != 0) {
                cursor.moveToFirst();
                do {
                    Contato contato = new Contato(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
                    list.add(contato);

                } while (cursor.moveToNext());
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                    return list;
                } else {
                    return null;
                }
            }
        } catch (Exception err) {
            return null;
        }
        return list;
    }


    private static class OpenHelper extends SQLiteOpenHelper {

        OpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +" (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, cpf TEXT, ida TEXT, tel TEXT, email TEXT);";
            db.execSQL(sql);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
            onCreate(db);
        }
    }
}
