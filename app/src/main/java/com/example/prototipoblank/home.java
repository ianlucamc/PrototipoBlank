package com.example.prototipoblank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class home extends AppCompatActivity {

    private EditText Nome;
    private EditText Email;
    private EditText Senha;

    private Button alterar;
    private Button deletar;

    private Pessoa p;

    //private long userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        alterar = findViewById(R.id.alterar);
        deletar = findViewById(R.id.deletar);

        //Bundle bundle = getIntent().getBundleExtra("tela_cadastro");
        //pessoa = (Pessoa) bundle.getSerializable("user");
        //userId = bundle.getLong("id");

        //Nome.setText(pessoa.getNome());
        //Email.setText(pessoa.getEmail());
        //Senha.setText(pessoa.getSenha());

        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.idpessoa), Context.MODE_PRIVATE);
        String result = sharedPreferences.getString(getString(R.string.idpessoa), "");

        p = Pessoa.findById(Pessoa.class, Long.parseLong(result));

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Obj de Pessoa + Receber os dados dos campos de texto
                p.setNome(Nome.getText().toString());
                p.setEmail(Email.getText().toString());

                //Salvar no bd e limpar campos
                p.save();
                Nome.setText("");
                Email.setText("");
                Senha.setText("");

                Toast.makeText(home.this, "ALTERADO COM SUCESSO!", Toast.LENGTH_SHORT).show();
            }
        });

        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.delete();

                Toast.makeText(home.this, "EXCLUÍDO COM SUCESSO!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
