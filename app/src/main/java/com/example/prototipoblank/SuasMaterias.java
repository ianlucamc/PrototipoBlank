package com.example.prototipoblank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SuasMaterias extends AppCompatActivity {

    private ListView usuarios;
    private Button scan;
    private Button dados;

    //private long idPessoa;
    private Pessoa pessoa;

    private List<Pessoa> listaDePessoas = Pessoa.listAll(Pessoa.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suas_materias);

        usuarios = (ListView) findViewById(R.id.usuarios);
        scan = (Button) findViewById(R.id.deletar);
        dados = (Button) findViewById(R.id.dados);

        final ArrayList<String> pessoas = preencherDados();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pessoas);
        usuarios.setAdapter(arrayAdapter);

        usuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //id = idPessoa;
                //Intent intent = new Intent(SuasMaterias.this, home.class);
                //Bundle bundle = new Bundle();
                //bundle.putSerializable("user", pessoa);
                //bundle.putLong("id", idPessoa);
                //intent.putExtra("home", bundle);

                long idpessoa = listaDePessoas.get(position).getId();

                SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.idpessoa), Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(getString(R.string.idpessoa), ""+idpessoa);
                editor.apply();

                //startActivity(intent);
                Toast.makeText(getApplicationContext(), "Buscando: "+listaDePessoas.get(position).getNome(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SuasMaterias.this, home.class));
            }
        });

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SuasMaterias.this, Camera.class));
            }
        });

        dados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SuasMaterias.this, home.class));
            }
        });

    }

    private ArrayList<String> preencherDados() {
        ArrayList<String> dados = new ArrayList<String>();
        for (Pessoa p: listaDePessoas) {
            dados.add(p.getNome() + " | " + p.getEmail());
        }
        return dados;
    }

}
