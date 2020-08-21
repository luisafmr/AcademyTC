package com.example.academiaumb.model.dao;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

/**
 * Entity mapped to table "USUARIO".
 */
@Entity
public class Usuario {

    @Id
    private long id;

    @NotNull
    private String nickName;

    @NotNull
    private String password;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    @Generated
    public Usuario() {
    }

    public Usuario(long id) {
        this.id = id;
    }

    @Generated
    public Usuario(long id, String nickName, String password) {
        this.id = id;
        this.nickName = nickName;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NotNull
    public String getNickName() {
        return nickName;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setNickName(@NotNull String nickName) {
        this.nickName = nickName;
    }

    @NotNull
    public String getPassword() {
        return password;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}