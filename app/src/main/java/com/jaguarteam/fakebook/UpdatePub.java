package com.jaguarteam.fakebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.orhanobut.logger.Logger;

public class UpdatePub extends AppCompatActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Button pubUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pub);

        String myPubid=getIntent().getStringExtra("id");

        pubUpdate= findViewById(R.id.editar);

        pubUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        editarPublicacion(myPubid);
                        finish();
                    }
                }
        );

    }

    private void editarPublicacion(String idPub) {
        TextView publicacion=findViewById(R.id.publicacionInputEdit);
        db.collection("Publicaciones")
                .document(idPub)
                .update("publicacion",publicacion.getText().toString())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Logger.d("Editado", "DocumentSnapshot successfully updated!");
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Logger.w("Error", "Error updating document", e);
                    }
                });
    }
}