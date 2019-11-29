package com.example.prototipoblank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.orm.SchemaGenerator;
import com.orm.SugarContext;
import com.orm.SugarDb;

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

        //RODAR UMA PRIMEIRA VEZ E COMENTAR
        //SugarContext.init(getApplicationContext());
        //SchemaGenerator schemaGenerator = new SchemaGenerator(this);
        //schemaGenerator.createDatabase(new SugarDb(this).getDB());

        Nome = (EditText) findViewById(R.id.nome);
        Email = (EditText) findViewById(R.id.email);
        Senha = (EditText) findViewById(R.id.senha);

        Cadastrar = (Button) findViewById(R.id.cadastrar);

        Entrar = (TextView) findViewById(R.id.entrar);

        Cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Obj de Pessoa + Receber os dados dos campos de texto
                Pessoa p = new Pessoa();
                p.setNome(Nome.getText().toString());
                p.setEmail(Email.getText().toString());

                //Salvar no bd e limpar campos
                p.save();
                Nome.setText("");
                Email.setText("");

                Toast.makeText(Cadastro.this,"Olá, "+p.getNome()+"!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Cadastro.this, Identificacao.class));
            }
        });
    }
}
