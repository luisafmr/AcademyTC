package com.example.academiaumb.model.dao;

import org.greenrobot.greendao.annotation.*;

import java.util.List;
import com.example.academiaumb.model.dao.DaoSession;
import org.greenrobot.greendao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

/**
 * Entity mapped to table "ASIGNATURA".
 */
@Entity(active = true)
public class Asignatura {

    @Id
    private Long id;
    private String nombre;

    @NotNull
    private String color;
    private String detalles;
    private Double nota;
    private Long ProfesorId;
    private Long corteId;

    /** Used to resolve relations */
    @Generated
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated
    private transient AsignaturaDao myDao;

    @ToOne(joinProperty = "ProfesorId")
    private Profesor profesor;

    @Generated
    private transient Long profesor__resolvedKey;

    @ToOne(joinProperty = "corteId")
    private Corte corte;

    @Generated
    private transient Long corte__resolvedKey;

    @ToMany(joinProperties = {
        @JoinProperty(name = "id", referencedName = "asignaturaId")
    })
    private List<Anexo> anexos;

    @ToMany(joinProperties = {
        @JoinProperty(name = "id", referencedName = "AsignaturaId")
    })
    private List<Actividad> actividades;

    @ToMany(joinProperties = {
        @JoinProperty(name = "id", referencedName = "asignaturaId")
    })
    private List<Horario> horarios;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    @Generated
    public Asignatura() {
    }

    public Asignatura(Long id) {
        this.id = id;
    }

    @Generated
    public Asignatura(Long id, String nombre, String color, String detalles, Double nota, Long ProfesorId, Long corteId) {
        this.id = id;
        this.nombre = nombre;
        this.color = color;
        this.detalles = detalles;
        this.nota = nota;
        this.ProfesorId = ProfesorId;
        this.corteId = corteId;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getAsignaturaDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @NotNull
    public String getColor() {
        return color;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setColor(@NotNull String color) {
        this.color = color;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Long getProfesorId() {
        return ProfesorId;
    }

    public void setProfesorId(Long ProfesorId) {
        this.ProfesorId = ProfesorId;
    }

    public Long getCorteId() {
        return corteId;
    }

    public void setCorteId(Long corteId) {
        this.corteId = corteId;
    }

    /** To-one relationship, resolved on first access. */
    @Generated
    public Profesor getProfesor() {
        Long __key = this.ProfesorId;
        if (profesor__resolvedKey == null || !profesor__resolvedKey.equals(__key)) {
            __throwIfDetached();
            ProfesorDao targetDao = daoSession.getProfesorDao();
            Profesor profesorNew = targetDao.load(__key);
            synchronized (this) {
                profesor = profesorNew;
            	profesor__resolvedKey = __key;
            }
        }
        return profesor;
    }

    @Generated
    public void setProfesor(Profesor profesor) {
        synchronized (this) {
            this.profesor = profesor;
            ProfesorId = profesor == null ? null : profesor.getId();
            profesor__resolvedKey = ProfesorId;
        }
    }

    /** To-one relationship, resolved on first access. */
    @Generated
    public Corte getCorte() {
        Long __key = this.corteId;
        if (corte__resolvedKey == null || !corte__resolvedKey.equals(__key)) {
            __throwIfDetached();
            CorteDao targetDao = daoSession.getCorteDao();
            Corte corteNew = targetDao.load(__key);
            synchronized (this) {
                corte = corteNew;
            	corte__resolvedKey = __key;
            }
        }
        return corte;
    }

    @Generated
    public void setCorte(Corte corte) {
        synchronized (this) {
            this.corte = corte;
            corteId = corte == null ? null : corte.getId();
            corte__resolvedKey = corteId;
        }
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    @Generated
    public List<Anexo> getAnexos() {
        if (anexos == null) {
            __throwIfDetached();
            AnexoDao targetDao = daoSession.getAnexoDao();
            List<Anexo> anexosNew = targetDao._queryAsignatura_Anexos(id);
            synchronized (this) {
                if(anexos == null) {
                    anexos = anexosNew;
                }
            }
        }
        return anexos;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated
    public synchronized void resetAnexos() {
        anexos = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    @Generated
    public List<Actividad> getActividades() {
        if (actividades == null) {
            __throwIfDetached();
            ActividadDao targetDao = daoSession.getActividadDao();
            List<Actividad> actividadesNew = targetDao._queryAsignatura_Actividades(id);
            synchronized (this) {
                if(actividades == null) {
                    actividades = actividadesNew;
                }
            }
        }
        return actividades;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated
    public synchronized void resetActividades() {
        actividades = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    @Generated
    public List<Horario> getHorarios() {
        if (horarios == null) {
            __throwIfDetached();
            HorarioDao targetDao = daoSession.getHorarioDao();
            List<Horario> horariosNew = targetDao._queryAsignatura_Horarios(id);
            synchronized (this) {
                if(horarios == null) {
                    horarios = horariosNew;
                }
            }
        }
        return horarios;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated
    public synchronized void resetHorarios() {
        horarios = null;
    }

    /**
    * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
    * Entity must attached to an entity context.
    */
    @Generated
    public void delete() {
        __throwIfDetached();
        myDao.delete(this);
    }

    /**
    * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
    * Entity must attached to an entity context.
    */
    @Generated
    public void update() {
        __throwIfDetached();
        myDao.update(this);
    }

    /**
    * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
    * Entity must attached to an entity context.
    */
    @Generated
    public void refresh() {
        __throwIfDetached();
        myDao.refresh(this);
    }

    @Generated
    private void __throwIfDetached() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
