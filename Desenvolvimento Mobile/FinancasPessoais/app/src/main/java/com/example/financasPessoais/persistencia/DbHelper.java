package com.example.financasPessoais.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "financeiro.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TB_DESPESAS = "despesas";
    public static final String  TB_RECEITAS =   "receitas";

    private static final String SQL_CREATE_DESPESAS =
            "CREATE TABLE IF NOT EXISTS "+ TB_DESPESAS+ "("+
                    "id_despesa INTEGER PRIMARY KEY AUTOiNCREMENT, "+
                    "descricao_despesa TEXT "+
                    "valor_despesa DOUBLE "+
                    "data_despesa TEXT);";
    private static final String SQL_CREATE_RECEITAS =
            "CREATE TABLE IF NOT EXISTS "+ TB_RECEITAS+ "("+
                    "id_receita INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    "descricao_receita TEXT "+
                    "valor_receita DOUBLE "+
                    "data_receita TEXT);";

    private static final String SQL_DELETE_DESPESAS = "DROP TABLE IF EXIST"+ TB_DESPESAS;
    private static final String SQL_DELETE_RECEITAS = "DROP TABLE IF EXIST"+ TB_RECEITAS;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        executeSql(db,SQL_CREATE_DESPESAS, "DESPESAS");
        executeSql(db,SQL_CREATE_DESPESAS, "RECEITAS");

    }


    private void executeSql(SQLiteDatabase db, String sql, String tableName){
        try{
            db.execSQL(sql);
            Log.i("INFO DB","SUCESSO AO CRIAR A TABELA" + tableName);
        }catch(Exception e){
            Log.i("INFO DB", "ERRO AO CRIAR A TABELA"+tableName);
        }
   }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        executeSql(db, SQL_DELETE_DESPESAS, "DESPESAS");
        executeSql(db, SQL_DELETE_DESPESAS, "DESPESAS");
        onCreate(db);
    }
}


