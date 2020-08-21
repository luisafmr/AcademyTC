package com.example.academiaumb.modelo;


import com.example.academiaumb.model.dao.*;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.Date;
import java.util.List;

public class DaoQueries {

    public static Asignatura getAsignaturaByNombre(String nombre) {
        QueryBuilder<Asignatura> queryBuilder = DaoApp.getAsignaturaDao().queryBuilder();
        queryBuilder.where(AsignaturaDao.Properties.Nombre.eq(nombre));
        return queryBuilder.unique();
    }

    public static Profesor getProfesorByNombre(String nombre) {
        QueryBuilder<Profesor> queryBuilder = DaoApp.getProfesorDao().queryBuilder();
        queryBuilder.where(ProfesorDao.Properties.Nombre.eq(nombre));
        return queryBuilder.unique();
    }

    public static void agregarAsignatura(String nombreAsignatura, String nombreProfesor, String color, String detalles) {
        Asignatura asignatura = new Asignatura();
        Profesor profesor = DaoQueries.getProfesorByNombre(nombreProfesor);
        if (nombreProfesor != null || !nombreProfesor.isEmpty()) {
            if (profesor == null) {
                profesor = new Profesor();
                profesor.setNombre(nombreProfesor);
                DaoApp.getProfesorDao().insert(profesor);
            }
        }
        Corte corte = new Corte();
        corte.setCorte1(0);
        corte.setCorte2(0);
        corte.setCorte3(0);
        DaoApp.getCorteDao().insert(corte);
        asignatura.setCorte(corte);
        asignatura.setProfesor(profesor);
        asignatura.setDetalles(detalles);
        asignatura.setColor(color);
        asignatura.setNombre(nombreAsignatura);
        DaoApp.getAsignaturaDao().insert(asignatura);
    }

    public static void modificarAsignatura(String nombreAsignatura, String nombreProfesor, String color, String detalles, Asignatura asignatura) {
        Profesor profesor = DaoQueries.getProfesorByNombre(nombreProfesor);
        if (nombreProfesor != null || !nombreProfesor.isEmpty()) {
            if (profesor == null) {
                profesor = new Profesor();
                profesor.setNombre(nombreProfesor);
                DaoApp.getProfesorDao().insert(profesor);
            }
        }
        asignatura.setProfesor(profesor);
        asignatura.setDetalles(detalles);
        asignatura.setColor(color);
        asignatura.setNombre(nombreAsignatura);
        DaoApp.getAsignaturaDao().update(asignatura);
    }

    public static void modificarCortes(long asignaturaId, int[] valores) {
        Corte corte = DaoApp.getCorteDao().loadByRowId(asignaturaId);
        for (int i = 0; i < valores.length; i++) {
            switch (i) {
                case 0:
                    corte.setCorte1(valores[i]);
                    break;
                case 1:
                    corte.setCorte2(valores[i]);
                    break;
                case 2:
                    corte.setCorte3(valores[i]);
                    break;
                case 3:
                    corte.setNota1(valores[i]);
                    break;
                case 4:
                    corte.setNota2(valores[i]);
                    break;
                case 5:
                    corte.setNota3(valores[i]);
                    break;
            }
        }
        DaoApp.getCorteDao().update(corte);
    }

    public static void modificarProfesor(long id, String nombre, String correo, String telefono) {
        Profesor profesor = DaoApp.getProfesorDao().loadByRowId(id);
        profesor.setNombre(nombre);
        profesor.setCorreo(correo);
        profesor.setTelefono(telefono);
        DaoApp.getProfesorDao().update(profesor);
    }

    public static void agregarProfesor(String nombre, String correo, String telefono) {
        Profesor profesor = new Profesor();
        profesor.setNombre(nombre);
        profesor.setCorreo(correo);
        profesor.setTelefono(telefono);
        DaoApp.getProfesorDao().insert(profesor);
    }

    public static Horario getHorarioByPosicion(int posicion) {
        Horario horario;
        QueryBuilder<Horario> queryBuilder = DaoApp.getHorarioDao().queryBuilder();
        queryBuilder.where(HorarioDao.Properties.Posicion.eq(posicion));
        horario = queryBuilder.unique();
        return horario;
    }

    public static void AgregarHorario(String asignatura, String horaInicio, String horaSalida, String salon, int posicion) {
        Horario horario = new Horario();
        horario.setAsignatura(getAsignaturaByNombre(asignatura));
        horario.setHoraEntrada(horaInicio);
        horario.setHoraSalida(horaSalida);
        horario.setSalon(salon);
        horario.setPosicion(posicion);
        while (posicion >= 6) {
            posicion= posicion-6;
        }
        posicion+=1;
        horario.setDia(""+posicion);
        DaoApp.getHorarioDao().insert(horario);
    }

    public static void ModificarHorario(Horario horario, String asignatura, String horaInicio, String horaSalida, String salon) {
        horario.setAsignatura(getAsignaturaByNombre(asignatura));
        horario.setHoraEntrada(horaInicio);
        horario.setHoraSalida(horaSalida);
        horario.setSalon(salon);
        DaoApp.getHorarioDao().update(horario);
    }

    public static List<Actividad> getActividadesByCategoria(String categoria) {
        QueryBuilder<Actividad> queryBuilder = DaoApp.getActividadDao().queryBuilder();
        queryBuilder.where(ActividadDao.Properties.Categaria.eq(categoria));
        return queryBuilder.list();
    }

    public static void agregarActividad(String nombre, Date fecha, String tipo, String categoria, String asignatura) {
        Actividad actividad = new Actividad();
        actividad.setNombre(nombre);
        actividad.setFechaEntrega(fecha);
        actividad.setTipo(tipo);
        actividad.setCategaria(categoria);
        actividad.setAsignatura(getAsignaturaByNombre(asignatura));
        DaoApp.getActividadDao().insert(actividad);
    }

    public static void modificarActividad(Actividad actividad, String nombre, Date fecha, String tipo, String categoria, String asignatura) {
        actividad.setNombre(nombre);
        actividad.setFechaEntrega(fecha);
        actividad.setTipo(tipo);
        actividad.setCategaria(categoria);
        actividad.setAsignatura(getAsignaturaByNombre(asignatura));
        DaoApp.getActividadDao().update(actividad);
    }

    public static List getAnexosByAsignaturaId(Long id) {
        QueryBuilder<Anexo> queryBuilder = DaoApp.getAnexoDao().queryBuilder();
        queryBuilder.where(AnexoDao.Properties.AsignaturaId.eq(id));
        return queryBuilder.list();
    }

    public static List getAnotacionesByAnexoId(Long id) {
        QueryBuilder<Anotacion> queryBuilder = DaoApp.getAnotacionDao().queryBuilder();
        queryBuilder.where(AnotacionDao.Properties.AnexoId.eq(id));
        return queryBuilder.list();
    }

    public static Anexo getAnexoByTitulo(String titulo, long asigntaturaId) {
        QueryBuilder<Anexo> queryBuilder = DaoApp.getAnexoDao().queryBuilder();
        queryBuilder.where(AnexoDao.Properties.Titulo.eq(titulo), AnexoDao.Properties.AsignaturaId.eq(asigntaturaId));
        return queryBuilder.unique();
    }

    public static void agregarAnotacion(String detalle, String urlImagen, String tituloAnexo, long asignaturaId) {
        Anotacion anotacion = new Anotacion();
        anotacion.setDetalle(detalle);
        anotacion.setUrlImagen(urlImagen);
        Anexo anexo = getAnexoByTitulo(tituloAnexo, asignaturaId);
        if (anexo != null && !anexo.equals(null)) {
            anotacion.setAnexoId(anexo.getId());
        } else {
            anexo = new Anexo();
            anexo.setTitulo(tituloAnexo);
            anexo.setAsignaturaId(asignaturaId);
            anotacion.setAnexoId(DaoApp.getAnexoDao().insert(anexo));
        }
        DaoApp.getAnotacionDao().insert(anotacion);
    }
}
