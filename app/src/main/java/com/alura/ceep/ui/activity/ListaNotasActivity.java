package com.alura.ceep.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.alura.ceep.R;
import com.alura.ceep.dao.NotaDAO;
import com.alura.ceep.model.Nota;
import com.alura.ceep.ui.adapter.ListaNotasAdapter;

import java.util.List;

public class ListaNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        ListView listaNotas = findViewById(R.id.listView);

        NotaDAO dao = new NotaDAO();
        for (int i = 1; i <= 10000; i++){
            dao.insere(new Nota("Titulo " + i,
                    i + "a Descrição"));
        }
        List<Nota> todasNotas = dao.todos();
        
        listaNotas.setAdapter(new ListaNotasAdapter(this, todasNotas));
        
    }
}