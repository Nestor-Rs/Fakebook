package com.jaguarteam.fakebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<IViewModel> puclicaciones = new ArrayList<IViewModel>();

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        testPublication();
        MyAdapter adapter = new MyAdapter(puclicaciones);
        recyclerView.setAdapter(adapter);
    }

    public void testPublication(){
        puclicaciones.add(new TextPublic(0,R.drawable.ic_android_1, "Nestor", "Rodriguez", (float) 18.04, "Esta es mi primera publicacion"));
        puclicaciones.add(new TextPublic(1,R.drawable.ic_android_3, "Sofia", "Espindola", (float) 18.04, "Hola Mundo!"));
        puclicaciones.add(new ImagePublic(5,R.drawable.ic_android_2, "Sebastian", "Ortegon", (float) 18.04, "Mira esta imgage",R.drawable.ic_banner_foreground));
        for (int i = 0; i < 3; i++) {
            puclicaciones.add(new ImagePublic(i+5,R.drawable.ic_android_2, "Sebastian", "Ortegon", (float) 18.04, "Que pro!!!",R.drawable.ic_baseline_image_24));
        }
        for (int i = 0; i < 2; i++) {
            puclicaciones.add(new TextPublic(i+8,R.drawable.ic_android_1, "Nestor", "Rodriguez", (float) 18.04, "Hola Mundo!"));
        }
    }

}