package com.jaguarteam.fakebook;

import android.widget.ImageView;

public interface IViewModel {
    public int getId();
    public void setId(int id);
    public int getImagenPerfil();
    public void setImganePerfil(int imagenPerfil);
    public String getNombre();
    public void setNombre(String nombnre);
    public String getApellido();
    public void setApellido(String apellido);
    public float getHora();
    public void setHora(float hora);
    public Object getPublicacion();
    public void setPublicacion(Object Publicacion);
}
