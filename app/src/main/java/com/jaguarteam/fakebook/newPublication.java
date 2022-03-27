package com.jaguarteam.fakebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.type.DateTime;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class newPublication extends AppCompatActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Button pubSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_publication);

        pubSend= findViewById(R.id.publicar);
        pubSend.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        nuevaPublicacion();
                        finish();
                    }
                }
        );

    }

     public void nuevaPublicacion() {

         TextView nombre=findViewById(R.id.nombreInput);
         TextView apellido=findViewById(R.id.apellidoInput);
         TextView publicacion=findViewById(R.id.publicacionInput);

         Map<String, Object> data = new HashMap<>();
         data.put("nombre",nombre.getText().toString());
         data.put("apellido",apellido.getText().toString());
         data.put("imgPerfil","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoHYtXTchhspak0O8PNPKAPD9Cf08U6284ng&usqp=CAU");
         data.put("hora", 10.5);
         data.put("tipo", 0);
         data.put("publicacion", publicacion.getText().toString());

         DocumentReference newCityRef = db.collection("Publicaciones").document();
         newCityRef.set(data)
                 .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Logger.d("Publicado", "DocumentSnapshot successfully written!");
                    }
                })
                 .addOnFailureListener(new OnFailureListener() {
                     @Override
                     public void onFailure(@NonNull Exception e) {
                         Logger.w("Error al publicar", "Error writing document", e);
                     }
                 });
     }
}