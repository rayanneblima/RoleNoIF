package com.example.rolenoif.TesteVocacional;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rolenoif.R;

public class Jogo_TV extends AppCompatActivity {
    //TODO: conferir o private (segurança) dos campos
    //TODO: verifcar se placares sao iguais -- erro

    private Questoes_TV Questoes_TV = new Questoes_TV();

    private TextView txt_idPerg;
    private TextView txt_Perg;
    private Button btn_respA;
    private Button btn_respB;
    private Button btn_respC;

    private int idPerg = 0;
    private int qntPerg = 13;

    private int Agro;
    private int Alim;
    private int Info;
    private int MeiB;
    private int Zoo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogotv);
        carregarPerg();
    }

    //botão "VOLTAR"
    public void onBackPressed(){
        popup_Cancel();
    }

    public void popup_Cancel() {
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
                switch (idPerg) {
                    case 1:
                        Agro = Agro + 2;
                        Alim = Alim + 2;
                        updateQuestion();
                        break;
                    case 2:
                        Agro = Agro + 2;
                        MeiB = MeiB + 2;
                        updateQuestion();
                        break;
                    case 3:
                        Agro = Agro + 1;
                        MeiB = MeiB + 1;
                        Alim = Alim + 1;
                        updateQuestion();
                        break;
                    case 4:
                        Agro = Agro + 1;
                        Alim = Alim + 2;
                        updateQuestion();
                        break;
                    case 5:
                        Info = Info + 1;
                        Zoo = Zoo + 1;
                        updateQuestion();
                        break;
                    case 6:
                        Agro = Agro + 1;
                        Info = Info + 1;
                        updateQuestion();
                        break;
                    case 7:
                        Info = Info + 2;
                        MeiB = MeiB + 2;
                        Alim = Alim + 2;
                        updateQuestion();
                        break;
                    case 8:
                        MeiB = MeiB + 2;
                        updateQuestion();
                        break;
                    case 9:
                        Info = Info + 2;
                        updateQuestion();
                        break;
                    case 10:
                        Agro = Agro + 1;
                        Zoo = Zoo + 2;
                        updateQuestion();
                        break;
                    case 11:
                        Alim = Alim +2;
                        updateQuestion();
                        break;
                    case 12:
                        Info = Info + 2;
                        updateQuestion();
                        break;
                    case 13:
                        Agro = Agro + 1;
                        updateQuestion();
                        break;
                    default:
                        Toast.makeText(Jogo_TV.this, "ERRO!", Toast.LENGTH_SHORT).show();
                        updateQuestion();
                        break;
                }
            }
        });

        //End of Button Listener for ButtonA

        //Start of Button Listener for ButtonB
        btn_respB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here
                switch (idPerg) {
                    case 1:
                        Info = Info + 1;
                        updateQuestion();
                        break;
                    case 2:
                        Info = Info + 1;
                        Alim = Alim + 1;
                        updateQuestion();
                        break;
                    case 3:
                        Zoo = Zoo + 1;
                        Info = Info + 1;
                        updateQuestion();
                        break;
                    case 4:
                        MeiB = MeiB + 2;
                        Zoo = Zoo + 2;
                        Agro = Agro + 1;
                        Alim = Alim + 1;
                        updateQuestion();
                        break;
                    case 5:
                        Agro = Agro + 1;
                        MeiB = MeiB + 1;
                        Alim = Alim + 1;
                        updateQuestion();
                        break;
                    case 6:
                        MeiB = MeiB + 1;
                        Alim = Alim + 1;
                        Zoo = Zoo + 1;
                        updateQuestion();
                        break;
                    case 7:
                        Zoo = Zoo + 1;
                        Agro = Agro + 1;
                        updateQuestion();
                        break;
                    case 8:
                        updateQuestion();
                        break;
                    case 9:
                        updateQuestion();
                        break;
                    case 10:
                        Agro = Agro + 2;
                        updateQuestion();
                        break;
                    case 11:
                        updateQuestion();
                        break;
                    case 12:
                        updateQuestion();
                        break;
                    case 13:
                        updateQuestion();
                        break;
                    default:
                        Toast.makeText(Jogo_TV.this, "ERRO!", Toast.LENGTH_SHORT).show();
                        updateQuestion();
                        break;
                }
            }
        });

        //End of Button Listener for ButtonB


        //Start of Button Listener for ButtonC
        btn_respC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here
                switch (idPerg) {
                    case 1:
                        Agro = Agro + 1;
                        Alim = Alim + 1;
                        updateQuestion();
                        break;
                    case 2:
                        Zoo = Zoo + 1;
                        MeiB = MeiB + 1;
                        Agro = Agro + 1;
                        updateQuestion();
                        break;
                    case 4:
                        Info = Info + 2;
                        updateQuestion();
                        break;
                    case 10:
                        MeiB = MeiB + 2;
                        Agro = Agro + 1;
                        updateQuestion();
                        break;
                    case 11:
                        updateQuestion();
                        break;
                    default:
                        Toast.makeText(Jogo_TV.this, "ERRO!", Toast.LENGTH_SHORT).show();
                        updateQuestion();
                        break;
                }
            }
        });

        //End of Button Listener for ButtonC
    }

    private void updateQuestion(){
        if (qntPerg > 0){
            txt_idPerg.setText(com.example.rolenoif.TesteVocacional.Questoes_TV.getidPerg(idPerg));
            txt_Perg.setText(com.example.rolenoif.TesteVocacional.Questoes_TV.getPerg(idPerg));
            btn_respA.setText(com.example.rolenoif.TesteVocacional.Questoes_TV.getRespA(idPerg));
            btn_respB.setText(com.example.rolenoif.TesteVocacional.Questoes_TV.getRespB(idPerg));
            String respC = com.example.rolenoif.TesteVocacional.Questoes_TV.getRespC(idPerg);
            if (respC.equals("")){
                btn_respC.setVisibility(View.GONE);
            } else{
                btn_respC.setVisibility(View.VISIBLE);
                btn_respC.setText(com.example.rolenoif.TesteVocacional.Questoes_TV.getRespC(idPerg));
            }
            idPerg++;
            qntPerg--;
        } else{
            //acabaram as questões
            //Passando variável para outra tela
            String curso1 = Curso1();
            String curso2 = Curso2();
            Intent intent = new Intent(this, Resultado.class);
            intent.putExtra("Curso 1", curso1);
            intent.putExtra("Curso 2", curso2);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        }
    }

    private String Curso1(){
        if (Agro >= 6){
            return Questoes_TV.Cursos[0];
        }
        else if (Alim >= 6){
            return Questoes_TV.Cursos[1];
        }
        else if (Info >= 6){
            return Questoes_TV.Cursos[2];
        }
        else if (MeiB >= 6){
            return Questoes_TV.Cursos[3];
        }else return Questoes_TV.Cursos[4];
    }

    //SUPOSIÇÃO - ATENTA!!! SE PLACAR IGUAL - CURSO QUE VEM PRIMEIRO É FAVORECIDO (ORDEM ALFABETICA)
    private String Curso2(){
        if ((!Curso1().equals(Questoes_TV.Cursos[0])) && (Agro >= 6)){
            return Questoes_TV.Cursos[0];
        }
        else if ((!Curso1().equals(Questoes_TV.Cursos[1])) && Alim >= 6){
            return Questoes_TV.Cursos[1];
        }
        else if ((!Curso1().equals(Questoes_TV.Cursos[2])) && Info >= 6){
            return Questoes_TV.Cursos[2];
        }
        else if ((!Curso1().equals(Questoes_TV.Cursos[3])) && MeiB >= 6){
            return Questoes_TV.Cursos[3];
        }else return Questoes_TV.Cursos[4];
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        idPerg = idPerg-1;
        carregarPerg();
    }

}
