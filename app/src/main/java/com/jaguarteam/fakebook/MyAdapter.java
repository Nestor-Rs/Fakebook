package com.jaguarteam.fakebook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.logging.Logger;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    ArrayList<IViewModel> publicacionList;

    MyAdapter(ArrayList<IViewModel> publicacionList){
        super();
        this.publicacionList=publicacionList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.publicacion,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindItems(publicacionList.get(position));
    }

    @Override
    public int getItemCount() {
        return publicacionList.size();
    }

    class  ViewHolder extends RecyclerView.ViewHolder{

        private TextView countLike,countComent,countShare;
        Popularity popularity;

        ViewHolder(View itemView){
            super(itemView);
        }
        public  void bindItems(IViewModel publicacion){
            //Tomar todos los item view
            ImageView imgPerfil = itemView.findViewById(R.id.userimg);
            TextView nombre=itemView.findViewById(R.id.nombre);
            TextView apellido=itemView.findViewById(R.id.apellido);
            TextView hora=itemView.findViewById(R.id.hora);
            TextView pub=itemView.findViewById(R.id.publicacion);
            ImageView pubimg=itemView.findViewById(R.id.pubimg);
            //Likes y coments
            countLike =itemView.findViewById(R.id.contadorLike);
            countComent=itemView.findViewById(R.id.contadorComent);
            countShare=itemView.findViewById(R.id.contadorShare);

            popularity=new Popularity();

            countLike.setText("Likes "+popularity.getLikes());
            countComent.setText("Comentarios: "+popularity.getComents());
            countShare.setText(popularity.getLikes()+" veces compartido ");

            //Cambiar los elementos de las imganes
            Picasso.get().load(publicacion.getImagenPerfil()).error(R.mipmap.ic_launcher_round).into(imgPerfil);
            nombre.setText(publicacion.getNombre());
            apellido.setText(publicacion.getApellido());
            hora.setText("publicado hace: "+String.valueOf(publicacion.getHora()));
            if(publicacion instanceof TextPublic){
                pub.setText(publicacion.getPublicacion().toString());
                pubimg.setLayoutParams(new LinearLayout.LayoutParams(0,0));
                pubimg.setVisibility(View.INVISIBLE);
            }
            else {
                ImagePublic miPublicacion =(ImagePublic) publicacion;
                pub.setText(miPublicacion.getCometImg());
                Picasso.get().load((String) miPublicacion.getPublicacion()).error(R.mipmap.ic_launcher_round).into(pubimg);

            }
        }

        public Popularity getPopularity() {
            return popularity;
        }
    }
}
