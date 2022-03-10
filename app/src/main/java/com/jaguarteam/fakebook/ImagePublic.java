package com.jaguarteam.fakebook;

public class ImagePublic implements  IViewModel{
    private int id;
    private int imagenPerfil;
    private String nombre;
    private String apellido;
    private float hora;
    private String cometImg;
    private int publicacion;

    ImagePublic(int id,int imagenPerfil,String nombre,String apellido,float hora,String comentImg,int publicacion){
        this.id=id;
        this.imagenPerfil=imagenPerfil;
        this.nombre=nombre;
        this.apellido=apellido;
        this.hora=hora;
        this.cometImg=comentImg;
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
    public int getImagenPerfil() {
        return this.imagenPerfil;
    }

    @Override
    public void setImganePerfil(int imagenPerfil) {
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
        this.publicacion=(Integer) publicacion;
    }
}
