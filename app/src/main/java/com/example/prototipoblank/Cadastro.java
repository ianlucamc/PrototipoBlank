package com.example.prototipoblank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity {

    private EditText Nome;
    private EditText Email;
    private EditText Senha;

    private Button Cadastrar;

    private TextView Entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Nome = (EditText) findViewById(R.id.nome);
        Email = (EditText) findViewById(R.id.email);
        Senha = (EditText) findViewById(R.id.senha);

        Cadastrar = (Button) findViewById(R.id.cadastrar);

        Entrar = (TextView) findViewById(R.id.entrar);

        Cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Cadastro.this,"BEM VIND@!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Cadastro.this, Identificacao.class));
            }
        });
    }
}
