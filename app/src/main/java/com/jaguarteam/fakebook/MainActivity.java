package com.jaguarteam.fakebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ArrayList<IViewModel> puclicaciones = new ArrayList<IViewModel>();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    MyAdapter adapter;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        iniciar();

        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));

        testPublication();

        adapter = new MyAdapter(puclicaciones);

        recyclerView.setAdapter(adapter);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void testPublication(){
        //puclicaciones.add(new TextPublic(0,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoHYtXTchhspak0O8PNPKAPD9Cf08U6284ng&usqp=CAU", "Nestor", "Rodriguez", (float) 18.04, "Esta es mi primera publicacion"));
        db.collection("Publicaciones").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        switch (Integer.parseInt(document.getData().get("tipo").toString())){
                            case 0:
                                puclicaciones.add(new TextPublic(0,document.getData().get("imgPerfil").toString(),
                                        document.getData().get("nombre").toString(),
                                        document.getData().get("apellido").toString(),
                                        Float.parseFloat(document.getData().get("hora").toString()),
                                        document.getData().get("publicacion").toString()));
                                break;
                            case 1:
                                puclicaciones.add(new ImagePublic(
                                        1,document.getData().get("imgPerfil").toString(),
                                        document.getData().get("nombre").toString(),
                                        document.getData().get("apellido").toString(),
                                        Float.parseFloat(document.getData().get("hora").toString()),
                                        document.getData().get("comentario").toString(),
                                        document.getData().get("img").toString()));
                                break;
                            default:
                                Logger.e("Ocurrio un error");
                        }
                    }
                    adapter.notifyDataSetChanged();
                }
                else {
                    Logger.w("FireError", "Error getting documents.", task.getException());
                }
            }
        });
    }
    public  void iniciar() {
        Logger.addLogAdapter(new AndroidLogAdapter());

    }
}