package com.example.rolenoif.Menu;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.transition.Slide;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rolenoif.ConteudoAgro.CarreiraAgro;
import com.example.rolenoif.ConteudoAgro.ConverseAgro;
import com.example.rolenoif.ConteudoAgro.DepoimentosAgro;
import com.example.rolenoif.ConteudoAgro.MateriasAgro;
import com.example.rolenoif.ConteudoAgro.SeisCoisasAgro;
import com.example.rolenoif.Others.OnSwipeTouchListener;
import com.example.rolenoif.R;
import com.example.rolenoif.TesteVocacional.DescricaoCursos;
import com.example.rolenoif.TesteVocacional.PagDescricao;

import java.text.Normalizer;

public class PaginaAgro extends AppCompatActivity {
    //TODO: conferir o private (segurança) dos campos
    //TODO: usar todo o conteúdo de agro como pagina unica pros demais cursos, só passando o nome do curso e modificando onde necessario


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agro);

        iniciarSeisCoisasAgro();
        iniciarCarreiraAgro();
        iniciarMateriasAgro();
        iniciarDepoimentosAgro();
        iniciarRotinaAgro();
        iniciarConverseAgro();
    }

    private void iniciarCarreiraAgro(){
        Button btn_CarreiraAgro = findViewById(R.id.btn_CarreiraAgro);

        btn_CarreiraAgro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaginaAgro.this, CarreiraAgro.class);
                startActivity(intent);
            }
        });
    }

    private void iniciarMateriasAgro(){
        final Intent intent = getIntent();
        //Recuperei a string da outra activity
        String nomeCurso = intent.getStringExtra("Curso");
        Toast.makeText(PaginaAgro.this, "Info: " + nomeCurso, Toast.LENGTH_SHORT).show();
        Button btn_materiasAgro = findViewById(R.id.btn_materiasAgro);

        btn_materiasAgro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String nomeCurso = DescricaoCursos.nomeCursos[0];
                Intent intent = new Intent(PaginaAgro.this, MateriasAgro.class);
                intent.putExtra("Curso", nomeCurso);
                startActivity(intent);
            }
        });

    }

    private void iniciarDepoimentosAgro(){
        Button btnDepoimentos = findViewById(R.id.btnDepoimentos);

        btnDepoimentos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaginaAgro.this, DepoimentosAgro.class);
                startActivity(intent);
            }
        });
    }

    private void iniciarSeisCoisasAgro(){
        Button btn6Coisas = findViewById(R.id.btn6Coisas);

        btn6Coisas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaginaAgro.this, SeisCoisasAgro.class);
                startActivity(intent);
            }
        });
    }

    private void iniciarRotinaAgro(){
        Button btnRotina = findViewById(R.id.btnRotina);

        btnRotina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Popup customizado na mesma pagina
                MyCustomAlertDialog();
            }
        });
    }

    private void iniciarConverseAgro(){
        Button btnConverse = findViewById(R.id.btnConverse);

        btnConverse.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaginaAgro.this, ConverseAgro.class);
                startActivity(intent);
            }
        });
    }

    //TODO: este codigo deve ser feito separado para ser possivel incrementar com k numeros de fotos

    @SuppressLint("ClickableViewAccessibility")
    public void MyCustomAlertDialog(){
        final Dialog MyDialog = new Dialog(this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.activity_rotinagro);

        final TextView qnt = MyDialog.findViewById(R.id.qnt);
        final ImageView foto = MyDialog.findViewById(R.id.foto);
        final TextView descricao = MyDialog.findViewById(R.id.descricao);
        final View viewGroup = MyDialog.findViewById(R.id.viewGroup);
        final int[] img = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5,
                R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9};

        final String[] desc = {"1 Alunos participando da I Mostra de Cursos e Profissões", "2 Aula de Fruticultura (3º ano)",
                "3 Disciplina de Agricultura I (a turma estava cursando o 1º ano", "4 Disciplina de Introdução aos Estudos e Práticas em Agropecuária (IEPA) do 1º ano de curso",
                "5 Disciplina de Zootecnia I (matéria do 2º ano)", "6 Equipe Agro3B recebendo medalha na Olimpíada Brasileira de Agropecuária",
                "7 Evento GeAgro - palestra sobre tangerina Ponkan", "8 Medalha de bronze conquistada na Olimpíada Brasileira de Agropecuária",
                "9 Prova prática da Olimpíada - Inseminação Artificial"};

        final int[] posicao = {0};
        final int[] cont = {1};

        qnt.setText("1/9");
        foto.setImageResource(img[posicao[0]]);
        descricao.setText(desc[posicao[0]]);

        // Na view da foto, ativa "SwipeTouchListener" permitindo detecção do deslize.
        viewGroup.setOnTouchListener(new OnSwipeTouchListener(PaginaAgro.this) {
            @Override
            public void onSwipeLeft() {
                // Se desliza da direta pra esquerda
                posicao[0]++;
                cont[0]++;
                if(posicao[0] > 8) posicao[0] = 0;
                if(cont[0] > 9) cont[0] = 1;
                qnt.setText(" " + cont[0] + "/9");
                foto.setImageResource(img[posicao[0]]);
                descricao.setText(desc[posicao[0]]);
            }
            public void onSwipeRight() {
                // Se desliza da esquerda pra direita
                posicao[0]--;
                cont[0]--;
                if(posicao[0] < 0) posicao[0] = 8;
                if(cont[0] < 1) cont[0] = 9;
                qnt.setText(" " + cont[0] + "/9");
                foto.setImageResource(img[posicao[0]]);
                descricao.setText(desc[posicao[0]]);
            }
        });

        MyDialog.show();
    }

}