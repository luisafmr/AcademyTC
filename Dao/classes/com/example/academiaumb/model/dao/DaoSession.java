package com.example.academiaumb.model.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.academiaumb.model.dao.Profesor;
import com.example.academiaumb.model.dao.Asignatura;
import com.example.academiaumb.model.dao.Anexo;
import com.example.academiaumb.model.dao.Anotacion;
import com.example.academiaumb.model.dao.Actividad;
import com.example.academiaumb.model.dao.Horario;
import com.example.academiaumb.model.dao.Corte;
import com.example.academiaumb.model.dao.Usuario;
import com.example.academiaumb.model.dao.evento;

import com.example.academiaumb.model.dao.ProfesorDao;
import com.example.academiaumb.model.dao.AsignaturaDao;
import com.example.academiaumb.model.dao.AnexoDao;
import com.example.academiaumb.model.dao.AnotacionDao;
import com.example.academiaumb.model.dao.ActividadDao;
import com.example.academiaumb.model.dao.HorarioDao;
import com.example.academiaumb.model.dao.CorteDao;
import com.example.academiaumb.model.dao.UsuarioDao;
import com.example.academiaumb.model.dao.eventoDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig profesorDaoConfig;
    private final DaoConfig asignaturaDaoConfig;
    private final DaoConfig anexoDaoConfig;
    private final DaoConfig anotacionDaoConfig;
    private final DaoConfig actividadDaoConfig;
    private final DaoConfig horarioDaoConfig;
    private final DaoConfig corteDaoConfig;
    private final DaoConfig usuarioDaoConfig;
    private final DaoConfig eventoDaoConfig;

    private final ProfesorDao profesorDao;
    private final AsignaturaDao asignaturaDao;
    private final AnexoDao anexoDao;
    private final AnotacionDao anotacionDao;
    private final ActividadDao actividadDao;
    private final HorarioDao horarioDao;
    private final CorteDao corteDao;
    private final UsuarioDao usuarioDao;
    private final eventoDao eventoDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        profesorDaoConfig = daoConfigMap.get(ProfesorDao.class).clone();
        profesorDaoConfig.initIdentityScope(type);

        asignaturaDaoConfig = daoConfigMap.get(AsignaturaDao.class).clone();
        asignaturaDaoConfig.initIdentityScope(type);

        anexoDaoConfig = daoConfigMap.get(AnexoDao.class).clone();
        anexoDaoConfig.initIdentityScope(type);

        anotacionDaoConfig = daoConfigMap.get(AnotacionDao.class).clone();
        anotacionDaoConfig.initIdentityScope(type);

        actividadDaoConfig = daoConfigMap.get(ActividadDao.class).clone();
        actividadDaoConfig.initIdentityScope(type);

        horarioDaoConfig = daoConfigMap.get(HorarioDao.class).clone();
        horarioDaoConfig.initIdentityScope(type);

        corteDaoConfig = daoConfigMap.get(CorteDao.class).clone();
        corteDaoConfig.initIdentityScope(type);

        usuarioDaoConfig = daoConfigMap.get(UsuarioDao.class).clone();
        usuarioDaoConfig.initIdentityScope(type);

        eventoDaoConfig = daoConfigMap.get(eventoDao.class).clone();
        eventoDaoConfig.initIdentityScope(type);

        profesorDao = new ProfesorDao(profesorDaoConfig, this);
        asignaturaDao = new AsignaturaDao(asignaturaDaoConfig, this);
        anexoDao = new AnexoDao(anexoDaoConfig, this);
        anotacionDao = new AnotacionDao(anotacionDaoConfig, this);
        actividadDao = new ActividadDao(actividadDaoConfig, this);
        horarioDao = new HorarioDao(horarioDaoConfig, this);
        corteDao = new CorteDao(corteDaoConfig, this);
        usuarioDao = new UsuarioDao(usuarioDaoConfig, this);
        eventoDao = new eventoDao(eventoDaoConfig, this);

        registerDao(Profesor.class, profesorDao);
        registerDao(Asignatura.class, asignaturaDao);
        registerDao(Anexo.class, anexoDao);
        registerDao(Anotacion.class, anotacionDao);
        registerDao(Actividad.class, actividadDao);
        registerDao(Horario.class, horarioDao);
        registerDao(Corte.class, corteDao);
        registerDao(Usuario.class, usuarioDao);
        registerDao(evento.class, eventoDao);
    }
    
    public void clear() {
        profesorDaoConfig.clearIdentityScope();
        asignaturaDaoConfig.clearIdentityScope();
        anexoDaoConfig.clearIdentityScope();
        anotacionDaoConfig.clearIdentityScope();
        actividadDaoConfig.clearIdentityScope();
        horarioDaoConfig.clearIdentityScope();
        corteDaoConfig.clearIdentityScope();
        usuarioDaoConfig.clearIdentityScope();
        eventoDaoConfig.clearIdentityScope();
    }

    public ProfesorDao getProfesorDao() {
        return profesorDao;
    }

    public AsignaturaDao getAsignaturaDao() {
        return asignaturaDao;
    }

    public AnexoDao getAnexoDao() {
        return anexoDao;
    }

    public AnotacionDao getAnotacionDao() {
        return anotacionDao;
    }

    public ActividadDao getActividadDao() {
        return actividadDao;
    }

    public HorarioDao getHorarioDao() {
        return horarioDao;
    }

    public CorteDao getCorteDao() {
        return corteDao;
    }

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public eventoDao getEventoDao() {
        return eventoDao;
    }

}
