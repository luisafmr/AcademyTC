package com.example.dao;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Property;
import org.greenrobot.greendao.generator.Schema;
import org.greenrobot.greendao.generator.ToMany;

public class MyClass {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1,"com.example.academiaumb.model.dao");
        schema.enableKeepSectionsByDefault();
        createDatabase(schema,args[0]);
        DaoGenerator daoGenerator = new DaoGenerator();
        daoGenerator.generateAll(schema,args[0]);
    }

    private static void createDatabase(Schema schema,String args) throws Exception {
        Entity Profesor = schema.addEntity("Profesor");
        Profesor.addIdProperty();
        Profesor.addStringProperty("nombre").notNull();
        Profesor.addStringProperty("correo");
        Profesor.addStringProperty("telefono");

        Entity Asignatura = schema.addEntity("Asignatura");
        Asignatura.addIdProperty();
        Asignatura.addStringProperty("nombre");
        Asignatura.addStringProperty("color").notNull();
        Asignatura.addStringProperty("detalles");
        Asignatura.addDoubleProperty("nota");
        Property ProfesorId = Asignatura.addLongProperty("ProfesorId").getProperty();
        ToMany ProfesorToAsignaturas = Profesor.addToMany(Asignatura,ProfesorId);
        ProfesorToAsignaturas.setName("asignaturas");
        Asignatura.addToOne(Profesor,ProfesorId);

        Entity Anexo = schema.addEntity("Anexo");
        Anexo.addIdProperty();
        Anexo.addStringProperty("titulo");
        Property AsignaturaId = Anexo.addLongProperty("asignaturaId").getProperty();
        ToMany AsignaturaToTemas = Asignatura.addToMany(Anexo, AsignaturaId);
        AsignaturaToTemas.setName("anexos");
        Anexo.addToOne(Asignatura, AsignaturaId);

        Entity Anotacion = schema.addEntity("Anotacion");
        Anotacion.addIdProperty();
        Anotacion.addStringProperty("detalle");
        Anotacion.addStringProperty("urlImagen");
        Anotacion.addStringProperty("urlVoz");
        Anotacion.addStringProperty("urlVideo");
        Property AnexoId = Anotacion.addLongProperty("anexoId").getProperty();
        ToMany AnexoToAnotaciones = Anexo.addToMany(Anotacion,AnexoId);
        AnexoToAnotaciones.setName("anotaciones");
        Anotacion.addToOne(Anexo,AnexoId);

        Entity Activiad = schema.addEntity("Actividad");
        Activiad.addIdProperty();
        Activiad.addStringProperty("Nombre");
        Activiad.addDateProperty("FechaEntrega");
        Activiad.addDoubleProperty("Nota");
        Activiad.addStringProperty("tipo").notNull();
        Activiad.addStringProperty("categaria").notNull();
        AsignaturaId = Activiad.addLongProperty("AsignaturaId").getProperty();
        ToMany AsignatiraToActividades = Asignatura.addToMany(Activiad, AsignaturaId);
        AsignatiraToActividades.setName("actividades");
        Activiad.addToOne(Asignatura, AsignaturaId);

        Entity Horario = schema.addEntity("Horario");
        Horario.addIdProperty();
        Horario.addStringProperty("dia").notNull();
        Horario.addStringProperty("horaEntrada").notNull();
        Horario.addStringProperty("horaSalida").notNull();
        Horario.addStringProperty("salon");
        Horario.addIntProperty("posicion");
        AsignaturaId = Horario.addLongProperty("asignaturaId").getProperty();
        ToMany AsignaturaToHorarios = Asignatura.addToMany(Horario, AsignaturaId);
        AsignaturaToHorarios.setName("horarios");
        Horario.addToOne(Asignatura,AsignaturaId);

        Entity Corte = schema.addEntity("Corte");
        Corte.addIdProperty();
        Corte.addIntProperty("corte1");
        Corte.addIntProperty("corte2");
        Corte.addIntProperty("corte3");
        Corte.addIntProperty("nota1");
        Corte.addIntProperty("nota2");
        Corte.addIntProperty("nota3");
        AsignaturaId = Corte.addLongProperty("asignaturaId").getProperty();
        Property CorteId = Asignatura.addLongProperty("corteId").getProperty();
        Corte.addToOne(Asignatura,AsignaturaId);
        Asignatura.addToOne(Corte,CorteId);

        Entity Usuario = schema.addEntity("Usuario");
        Usuario.addIdProperty().notNull();
        Usuario.addStringProperty("nickName").notNull();
        Usuario.addStringProperty("password").notNull();

        Entity Evento = schema.addEntity("evento");
        Evento.addIdProperty();
        Evento.addStringProperty("titulo");
        Evento.addStringProperty("descripcion");
        Evento.addStringProperty("direccion");
        Evento.addStringProperty("longitud");
        Evento.addStringProperty("latitud");
        Evento.addStringProperty("nombre");
    }

}
