package com.jaguarteam.fakebook;

import com.orhanobut.logger.Logger;

public class ImagePublic implements  IViewModel{
    private String id;
    private String imagenPerfil;
    private String nombre;
    private String apellido;
    private float hora;
    private String cometImg;
    private String publicacion;

    ImagePublic(String id,String imagenPerfil,String nombre,String apellido,float hora,String comentImg,String publicacion){
        this.id=id;
        this.imagenPerfil=imagenPerfil;
        this.nombre=nombre;
        this.apellido=apellido;
        this.hora=hora;
        this.cometImg=comentImg;
        this.publicacion=publicacion;
        Logger.e(this.imagenPerfil);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
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

    public String getCometImg() {
        return cometImg;
    }

    public void setCometImg(String cometImg) {
        this.cometImg = cometImg;
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
