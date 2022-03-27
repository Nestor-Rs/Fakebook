package com.jaguarteam.fakebook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.logging.Logger;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

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
        //Dar eventos
        holder.setOnclikLiseners();
    }

    @Override
    public int getItemCount() {
        return publicacionList.size();
    }


    class  ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView countLike,countComent,countShare;
        Popularity popularity;
        Button BLike,BComent,BShare;

        ViewHolder(View itemView){
            super(itemView);
            BLike=itemView.findViewById(R.id.like);
            BComent=itemView.findViewById(R.id.coment);
            BShare=itemView.findViewById(R.id.share);
        }
        void setOnclikLiseners(){
            BLike.setOnClickListener(this);
            BComent.setOnClickListener(this);
            BShare.setOnClickListener(this);
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

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.like:
                    this.popularity.oneLike();
                    countLike.setText("Likes "+popularity.getLikes());
                    break;
                case R.id.coment:
                    this.popularity.oneComent();
                    countComent.setText("Comentarios: "+popularity.getComents());
                    break;
                case R.id.share:
                    this.popularity.oneShare();
                    countShare.setText(popularity.getShares()+" veces compartido ");
            }
        }
    }
}
