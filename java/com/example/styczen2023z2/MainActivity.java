package com.example.styczen2023z2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    String tekstZadanie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button dodajZadanie = findViewById(R.id.button4);
        ListView listaZadan = findViewById(R.id.listView);
        EditText poleZadanie = findViewById(R.id.editTextText3);

        String startZadania[] = {"Zakupy: chleb, masło, ser",
                "Do zrobienia: obiad, umyć podłogi",
                "weekend: kino, spacer z psem"};


        ArrayList<String> zadania = new ArrayList<String>();
        zadania.addAll(Arrays.asList(startZadania));

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, zadania);

        listaZadan.setAdapter(adapter);

        dodajZadanie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tekstZadanie = poleZadanie.getText().toString();

                if (!tekstZadanie.isEmpty()) {
                    zadania.add(tekstZadanie);

                    adapter.notifyDataSetChanged();

                    poleZadanie.setText("");
                }
            }
        });
    }
}