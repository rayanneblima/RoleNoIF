package com.example.rolenoif.TesteVocacional;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.rolenoif.Menu.PagMenu;
import com.example.rolenoif.R;

public class Resultado extends AppCompatActivity {
    //TODO: conferir o private (segurança) dos campos
    //TODO usar o conteudo de agro como unico, mudando de acordo com o curso escolhido

    //REDUZIR CODIGO

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        respostaCurso();
        paginaCurso();
    }

    //Mostra o Curso pelo resultado do Teste Vocacional
    private void respostaCurso() {
        Button btn1 = findViewById(R.id.btn1);
        TextView btn2 = findViewById(R.id.btn2);

        //Pega a intent de outra activity
        Intent intent = getIntent();
        //Recuperei a string da outra activity
        String curso1 = intent.getStringExtra("Curso 1");
        String curso2 = intent.getStringExtra("Curso 2");
        btn2.setText("" + curso2 + "!");

        switch (curso1){
            case "Agropecuária":
                btn1.setBackgroundResource(R.drawable.ta);
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nomeCurso = DescricaoCursos.nomeCursos[0];
                        Intent intent = new Intent(Resultado.this, PagDescricao.class);
                        intent.putExtra("Curso", nomeCurso);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                    }
                });
                break;
            case "Alimentos":
                btn1.setBackgroundResource(R.drawable.tal);
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nomeCurso = DescricaoCursos.nomeCursos[1];
                        Intent intent = new Intent(Resultado.this, PagDescricao.class);
                        intent.putExtra("Curso", nomeCurso);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                    }
                });
                break;
            case "Informática":
                btn1.setBackgroundResource(R.drawable.ti);
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nomeCurso = DescricaoCursos.nomeCursos[2];
                        Intent intent = new Intent(Resultado.this, PagDescricao.class);
                        intent.putExtra("Curso", nomeCurso);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                    }
                });
                break;
            case "Meio Ambiente":
                btn1.setBackgroundResource(R.drawable.tmb);
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nomeCurso = DescricaoCursos.nomeCursos[3];
                        Intent intent = new Intent(Resultado.this, PagDescricao.class);
                        intent.putExtra("Curso", nomeCurso);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                    }
                });
                break;
            case "Zootecnia":
                btn1.setBackgroundResource(R.drawable.tz);
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nomeCurso = DescricaoCursos.nomeCursos[4];
                        Intent intent = new Intent(Resultado.this, PagDescricao.class);
                        intent.putExtra("Curso", nomeCurso);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                    }
                });
                break;
            default:

        }

        //ARRUMAR
        switch (curso2){
            case "Agropecuária":
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nomeCurso = DescricaoCursos.nomeCursos[0];
                        Intent intent = new Intent(Resultado.this, PagDescricao.class);
                        intent.putExtra("Curso", nomeCurso);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                    }
                });
                break;
            case "Alimentos":
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nomeCurso = DescricaoCursos.nomeCursos[1];
                        Intent intent = new Intent(Resultado.this, PagDescricao.class);
                        intent.putExtra("Curso", nomeCurso);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                    }
                });
                break;
            case "Informática":
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nomeCurso = DescricaoCursos.nomeCursos[2];
                        Intent intent = new Intent(Resultado.this, PagDescricao.class);
                        intent.putExtra("Curso", nomeCurso);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                    }
                });
                break;
            case "Meio Ambiente":
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nomeCurso = DescricaoCursos.nomeCursos[3];
                        Intent intent = new Intent(Resultado.this, PagDescricao.class);
                        intent.putExtra("Curso", nomeCurso);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                    }
                });
                break;
            case "Zootecnia":
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nomeCurso = DescricaoCursos.nomeCursos[4];
                        Intent intent = new Intent(Resultado.this, PagDescricao.class);
                        intent.putExtra("Curso", nomeCurso);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                    }
                });
                break;
            default:

        }


    }

    //Botões que direcionam o usuário para a área do curso
    private void paginaCurso() {
        //Curso Tec. em Agropecuária
        Button btnAgro = findViewById(R.id.btnAgro);
        btnAgro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeCurso = DescricaoCursos.nomeCursos[0];
                Intent intent = new Intent(Resultado.this, PagDescricao.class);
                intent.putExtra("Curso", nomeCurso);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        //Curso Tec. em Alimentos
        Button btnAlim = findViewById(R.id.btnAlim);
        btnAlim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeCurso = DescricaoCursos.nomeCursos[1];
                Intent intent = new Intent(Resultado.this, PagDescricao.class);
                intent.putExtra("Curso", nomeCurso);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        //Curso Tec. em Info
        Button btnInf = findViewById(R.id.btnInf);
        btnInf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeCurso = DescricaoCursos.nomeCursos[2];
                Intent intent = new Intent(Resultado.this, PagDescricao.class);
                intent.putExtra("Curso", nomeCurso);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        //Curso Tec. em MeiB
        Button btnMeiB = findViewById(R.id.btnMeiB);
        btnMeiB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeCurso = DescricaoCursos.nomeCursos[3];
                Intent intent = new Intent(Resultado.this, PagDescricao.class);
                intent.putExtra("Curso", nomeCurso);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        //Curso Tec. em Zoo
        Button btnZoo = findViewById(R.id.btnZoo);
        btnZoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeCurso = DescricaoCursos.nomeCursos[4];
                Intent intent = new Intent(Resultado.this, PagDescricao.class);
                intent.putExtra("Curso", nomeCurso);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
    }

    public void onBackPressed(){
        Intent intent = new Intent(Resultado.this, PagMenu.class);
        startActivity(intent);
        finish();
    }
}