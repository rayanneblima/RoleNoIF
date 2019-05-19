package com.example.rayanne.myapplication.Menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.rayanne.myapplication.TesteVocacional.Jogo_TV;
import com.example.rayanne.myapplication.R;

public class Teste_Vocacional extends AppCompatActivity {
    //TODO: conferir o private (segurança) dos campos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);
        iniciarTeste();
    }

    //botão "VOLTAR"
    public void onBackPressed(){
        finish();
    }

    private void iniciarTeste(){
        Button btn_Iniciar = findViewById(R.id.btn_Iniciar);

        btn_Iniciar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Teste_Vocacional.this, Jogo_TV.class);
                startActivity(intent);
            }
        });
    }
}
