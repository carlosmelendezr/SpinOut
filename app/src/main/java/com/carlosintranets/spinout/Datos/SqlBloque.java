package com.carlosintranets.spinout.Datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract;
import android.util.Log;

import com.carlosintranets.spinout.Constantes;
import com.carlosintranets.spinout.Objetos.Bloque;

import java.util.ArrayList;
import java.util.List;


public class SqlBloque extends SQLiteOpenHelper {
    private static final String tag = Constantes.TAG;
    private static final int DB_VERSION = 1;
    private static final String DATABASE_NAME="spinout.db";
    private static final String TABLE_NAME="bloques";
    private static final String CREATE_DB = "CREATE TABLE "
            +TABLE_NAME+" "
            +"(id INTEGER PRIMARY KEY," +
            "duracion INTEGER," +
            "velocidad INTEGER, " +
            "intensidad INTEGER, " +
            "posdorsal INTEGER, " +
            "posmanubrio INTEGER) " ;
    private static final String LISTA_BLOQUES = "SELECT * FROM bloques";

    public SqlBloque(Context context, String name, SQLiteDatabase.CursorFactory factory,
                     int version) {
        super(context, DATABASE_NAME, factory, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL(CREATE_DB);
    }

    public void crearEvento(Bloque blo) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id",blo.getId());
        values.put("duracion",blo.getDuracion());
        values.put("velocidad",blo.getVelocidad());
        values.put("intensidad",blo.getIntensidad());
        values.put("posdorsal",blo.getPosicionDorsal());
        values.put("posmanubrio",blo.getPosicionManubrio());

        db.insert(TABLE_NAME,null,values);
        Log.i(tag,"Registro creado en DB correcto.");

    }

    public List<Bloque> listaAventos() {
        List<Bloque> lista = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(LISTA_BLOQUES, null);

        if (cursor.moveToFirst()) {
            do {
                Bloque bloque = new Bloque();
                bloque.setId(cursor.getInt(0));
                bloque.setDuracion(cursor.getInt(1));
                bloque.setVelocidad(cursor.getInt(2));
                bloque.setIntensidad(cursor.getInt(3));
                bloque.setPosicionDorsal(cursor.getInt(4));
                bloque.setPosicionManubrio(cursor.getInt(5));

                lista.add(bloque);
            } while (cursor.moveToNext());
        }
        return lista;
    }

}
