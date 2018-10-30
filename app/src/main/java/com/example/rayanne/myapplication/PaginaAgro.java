package com.example.rayanne.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class PaginaAgro extends AppCompatActivity {

    private LinearLayout lyt_btnPerg1;
    private Button btn_Perg1;
    private LinearLayout lyt_btnPerg2;
    private Button btn_Perg2;
    private LinearLayout lyt_btnPerg3;
    private Button btn_Perg3;
    private LinearLayout lyt_btnPerg4;
    private Button btn_Perg4;

    private boolean show1;
    private boolean show2;
    private boolean show3;
    private boolean show4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agro);
        mostraConteudo();
    }

    private void mostraConteudo() {
        btn_Perg1 = (Button) findViewById(R.id.btn_Perg1);

        btn_Perg1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                lyt_btnPerg1 = (LinearLayout) findViewById(R.id.lyt_btnPerg1);
                if(show1){
                    lyt_btnPerg1.setVisibility(View.GONE);
                    show1 = false;
                }else{
                    lyt_btnPerg1.setVisibility(View.VISIBLE);
                    show1 = true;
                }
            }
         });

        btn_Perg2 = (Button) findViewById(R.id.btn_Perg2);

        btn_Perg2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                lyt_btnPerg2 = (LinearLayout) findViewById(R.id.lyt_btnPerg2);
                if(show2){
                    lyt_btnPerg2.setVisibility(View.GONE);
                    show2 = false;
                }else{
                    lyt_btnPerg2.setVisibility(View.VISIBLE);
                    show2 = true;
                }
            }
        });

        btn_Perg3 = (Button) findViewById(R.id.btn_Perg3);

        btn_Perg3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                lyt_btnPerg3 = (LinearLayout) findViewById(R.id.lyt_btnPerg3);
                if(show3){
                    lyt_btnPerg3.setVisibility(View.GONE);
                    show3 = false;
                }else{
                    lyt_btnPerg3.setVisibility(View.VISIBLE);
                    show3 = true;
                }
            }
        });

        btn_Perg4 = (Button) findViewById(R.id.btn_Perg4);

        btn_Perg4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                lyt_btnPerg4 = (LinearLayout) findViewById(R.id.lyt_btnPerg4);
                if(show4){
                    lyt_btnPerg4.setVisibility(View.GONE);
                    show4 = false;
                }else{
                    lyt_btnPerg4.setVisibility(View.VISIBLE);
                    show4 = true;
                }
            }
        });
    }

}
