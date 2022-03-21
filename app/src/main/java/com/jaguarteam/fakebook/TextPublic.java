package com.jaguarteam.fakebook;

import android.widget.ImageView;

public class TextPublic implements  IViewModel{
    private int id;
    private String imagenPerfil;
    private String nombre;
    private String apellido;
    private float hora;
    private String publicacion;

    TextPublic(int id,String imagenPerfil,String nombre,String apellido,float hora,String publicacion){
        this.id=id;
        this.imagenPerfil=imagenPerfil;
        this.nombre=nombre;
        this.apellido=apellido;
        this.hora=hora;
        this.publicacion=publicacion;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id=id;
    }

    @Override
    public String getImagenPerfil() {
        return this.imagenPerfil;
    }

    @Override
    public void setImganePerfil(String imagenPerfil) {
        this.imagenPerfil=imagenPerfil;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

    @Override
    public String getApellido() {
        return this.apellido;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellido=apellido;
    }

    @Override
    public float getHora() {
        return this.hora;
    }

    @Override
    public void setHora(float hora){
        this.hora=hora;
    }

    @Override
    public Object getPublicacion() {
        return this.publicacion;
    }

    @Override
    public void setPublicacion(Object publicacion){
        this.publicacion=(String) publicacion;
    }
}
