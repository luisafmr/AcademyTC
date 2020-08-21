package com.example.academiaumb.modelo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.academiaumb.model.dao.*;
import com.facebook.stetho.Stetho;

@SuppressWarnings("ALL")
public class DaoApp extends Application {

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);//chrome://inspect/#devices
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "proyectUMB-db", null);
        SQLiteDatabase sqLiteDatabase = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(sqLiteDatabase);
        daoSession = daoMaster.newSession();
    }

    public static AsignaturaDao getAsignaturaDao() {
        return daoSession.getAsignaturaDao();
    }

    public static ActividadDao getActividadDao() {
        return daoSession.getActividadDao();
    }

    public static AnotacionDao getAnotacionDao() {
        return daoSession.getAnotacionDao();
    }

    public static HorarioDao getHorarioDao() {
        return daoSession.getHorarioDao();
    }

    public static AnexoDao getTemaDao() {
        return daoSession.getAnexoDao();
    }

    public static CorteDao getCorteDao() {
        return daoSession.getCorteDao();
    }

    public static ProfesorDao getProfesorDao() {
        return daoSession.getProfesorDao();
    }

    public static UsuarioDao getUsuarioDao() {
        return daoSession.getUsuarioDao();
    }

    public static AnexoDao getAnexoDao() {
        return daoSession.getAnexoDao();
    }

    public static eventoDao getEventoDao() {
        return daoSession.getEventoDao();
    }

}
