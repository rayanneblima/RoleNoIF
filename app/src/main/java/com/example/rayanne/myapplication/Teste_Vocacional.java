package com.example.rayanne.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Teste_Vocacional extends AppCompatActivity {

    private Button btn_Iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);
        iniciarTeste();
    }

    private void iniciarTeste(){
        Button btn_Iniciar = (Button) findViewById(R.id.btn_Iniciar);

        btn_Iniciar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Teste_Vocacional.this, Jogo_TV.class);
                startActivity(intent);
            }
        });
    }
}
