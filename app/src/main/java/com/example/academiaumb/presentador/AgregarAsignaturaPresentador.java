package com.example.academiaumb.presentador;

import com.example.academiaumb.R;
import com.example.academiaumb.modelo.DaoQueries;
import com.example.academiaumb.vista.AgregarAsignatura;

public class AgregarAsignaturaPresentador {

    AgregarAsignatura agregarAsignatura;

    public AgregarAsignaturaPresentador(AgregarAsignatura agregarAsignatura) {
        this.agregarAsignatura = agregarAsignatura;
    }

    public void agregarAsignatura(String nombreAsignatura, String nombreProfesor, String color, String detalles){
        if (DaoQueries.getAsignaturaByNombre(nombreAsignatura) == null){
            DaoQueries.agregarAsignatura(nombreAsignatura, nombreProfesor, color, detalles);
            agregarAsignatura.cambiarVista();
        }else{
            agregarAsignatura.mostrarMensaje(R.string.errorAsignaturaRepetida);
        }
    }

}
