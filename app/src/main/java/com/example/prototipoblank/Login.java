package com.example.prototipoblank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText Email;
    private EditText Senha;

    private Button Entrar;

    private TextView RecuperarSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = (EditText) findViewById(R.id.email);
        Senha = (EditText) findViewById(R.id.senha);

        Entrar = (Button) findViewById(R.id.entrar);

        RecuperarSenha = (TextView) findViewById(R.id.recuperarSenha);

        Entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(Login.this,"OLÁ!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Login.this, SuasMaterias.class));
            }
        });
    }
}
