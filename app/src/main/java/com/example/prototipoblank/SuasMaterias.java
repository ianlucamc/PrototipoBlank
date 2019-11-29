package com.example.prototipoblank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class SuasMaterias extends AppCompatActivity {

    private TextView textView;
    private Button scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suas_materias);

        textView = (TextView) findViewById(R.id.textView);
        scan = (Button) findViewById(R.id.scan);

        List<Pessoa> listaDePessoas = Pessoa.listAll(Pessoa.class);
        String lista = "";
        for (Pessoa p: listaDePessoas) {
            lista = lista + p.getNome() + " | " + p.getEmail() + "\n";
        }
        textView.setText(lista);

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SuasMaterias.this, Camera.class));
            }
        });
    }
}
