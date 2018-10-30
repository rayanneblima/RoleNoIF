package com.example.rayanne.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Jogo_TV extends AppCompatActivity {

    private Questoes_TV Questoes_TV = new Questoes_TV();

    private TextView txt_idPerg;
    private TextView txt_Perg;
    private Button btn_respA;
    private Button btn_respB;
    private Button btn_respC;

    private int idPerg = 0;
    private int qntPerg = 4;

    private String[] Cursos = {
            "Exatas", "Humanas", "Biológicas"
    };

    private int Exatas;
    private int Bio;
    private int Humanas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogotv);
        carregarPerg();
    }

    //botão "VOLTAR"
    public void onBackPressed(){
        exemplo_simples();
    }

    public void exemplo_simples() {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        //builder.setTitle("");
        //define a mensagem
        builder.setMessage("Deseja cancelar o teste?");
        //define um botão como positivo
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
                Toast.makeText(getApplicationContext(), "Seu Teste Vocacional foi cancelado!", Toast.LENGTH_LONG).show();            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(Jogo_TV.this, "", Toast.LENGTH_SHORT).show();
            }
        });
        //cria o AlertDialog
        //atributo da classe.
        AlertDialog alerta = builder.create();
        //Exibe
        alerta.show();
    }

    private void carregarPerg() {
        txt_idPerg = findViewById(R.id.txt_idPerg);
        txt_Perg = findViewById(R.id.txt_Perg);
        btn_respA = findViewById(R.id.btn_respA);
        btn_respB = findViewById(R.id.btn_respB);
        btn_respC = findViewById(R.id.btn_respC);

        updateQuestion();

        //Start of Button Listener for ButtonA
        btn_respA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here
                Exatas = Exatas + 1;

                //This line of code is optional
                Toast.makeText(Jogo_TV.this, "Ponto para Exatas!", Toast.LENGTH_SHORT).show();

                updateQuestion();
            }
        });

        //End of Button Listener for ButtonA

        //Start of Button Listener for ButtonB
        btn_respB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here
                Bio = Bio + 1;

                //This line of code is optional
                Toast.makeText(Jogo_TV.this, "Ponto para Biológicas!", Toast.LENGTH_SHORT).show();

                updateQuestion();
            }
        });

        //End of Button Listener for ButtonB


        //Start of Button Listener for ButtonC
        btn_respC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here
                Humanas = Humanas + 1;

                //This line of code is optional
                Toast.makeText(Jogo_TV.this, "Ponto para Humanas!", Toast.LENGTH_SHORT).show();

                updateQuestion();
            }
        });

        //End of Button Listener for ButtonC
    }

    private void updateQuestion(){
        if (qntPerg > 0){
            txt_idPerg.setText(com.example.rayanne.myapplication.Questoes_TV.getidPerg(idPerg));
            txt_Perg.setText(com.example.rayanne.myapplication.Questoes_TV.getPerg(idPerg));
            btn_respA.setText(com.example.rayanne.myapplication.Questoes_TV.getRespA(idPerg));
            btn_respB.setText(com.example.rayanne.myapplication.Questoes_TV.getRespB(idPerg));
            btn_respC.setText(com.example.rayanne.myapplication.Questoes_TV.getRespC(idPerg));
            idPerg++;
            qntPerg--;
        } else{ //acabaram as questões
            //Passando variável para outra tela
            String curso = Resultado();
            Intent intent = new Intent(this, Resultado.class);
            intent.putExtra("Curso", curso);
            startActivity(intent);
            finish();
        }
    }

    private String Resultado(){
        if (Exatas >= 2){
            return Cursos[0];
        }
        else if (Humanas >= 2){
            return Cursos[1];
        }else return Cursos[2];
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        idPerg = idPerg-1;
        carregarPerg();
    }

}
