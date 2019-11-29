package com.example.prototipoblank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Identificacao extends AppCompatActivity {

    private RadioButton rdbEstudante;
    private RadioButton rdbDocente;
    private RadioButton rdbOutro;

    private Button Enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identificacao);

        rdbEstudante = (RadioButton) findViewById(R.id.rdbEstudante);
        rdbDocente = (RadioButton) findViewById(R.id.rdbDocente);
        rdbOutro = (RadioButton) findViewById(R.id.rdbOutro);

        Enviar = (Button) findViewById(R.id.enviar);

        Enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rdbEstudante.isChecked()){
                    Toast.makeText(Identificacao.this, "Estudante", Toast.LENGTH_SHORT).show();

                }
                if (rdbDocente.isChecked()){
                    Toast.makeText(Identificacao.this, "Docente", Toast.LENGTH_SHORT).show();

                }
                if (rdbOutro.isChecked()){
                    Toast.makeText(Identificacao.this, "Outro", Toast.LENGTH_SHORT).show();

                }

                startActivity(new Intent(Identificacao.this, SuasMaterias.class));
            }
        });

    }
}
