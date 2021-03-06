package com.example.academiaumb.model.dao;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

/**
 * Entity mapped to table "EVENTO".
 */
@Entity
public class evento {

    @Id
    private Long id;
    private String titulo;
    private String descripcion;
    private String direccion;
    private String longitud;
    private String latitud;
    private String nombre;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    @Generated
    public evento() {
    }

    public evento(Long id) {
        this.id = id;
    }

    @Generated
    public evento(Long id, String titulo, String descripcion, String direccion, String longitud, String latitud, String nombre) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.longitud = longitud;
        this.latitud = latitud;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
