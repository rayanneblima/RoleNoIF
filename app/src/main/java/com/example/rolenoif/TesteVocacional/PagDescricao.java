package com.example.rolenoif.TesteVocacional;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rolenoif.ConteudoAgro.MateriasAgro;
import com.example.rolenoif.Menu.PagMenu;
import com.example.rolenoif.Menu.PaginaAgro;
import com.example.rolenoif.Others.SharedPref;
import com.example.rolenoif.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static android.content.Intent.getIntent;

public class PagDescricao extends AppCompatActivity {
    //TODO: conferir o private (segurança) dos campos
    //TODO: permitir que o usuário só vote uma vez
    //TODO: mostrar a nota dada na pagina do curso

    private TextView txtCurso;
    private TextView txtDuracao;
    private TextView txtVagas;
    private TextView txtModalidade;
    private TextView txtQuem;
    private TextView txtDesc;
    private TextView txtEtc;
    private ImageView imgCurso;
    private Button btnAgroMenu;
    private Button btnMaterias;
    private RatingBar rtBar;

    private static String URL_REGIST = "https://rolenoifapp.000webhostapp.com/cadastroNota.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_descricao);
        inicializar();
        pegaCurso();
    }

    private void inicializar() {
        txtCurso = findViewById(R.id.txtCurso);
        txtDuracao = findViewById(R.id.txtDuracao);
        txtVagas = findViewById(R.id.txtVagas);
        txtModalidade = findViewById(R.id.txtModalidade);
        txtQuem = findViewById(R.id.txtQuem);
        txtDesc = findViewById(R.id.txtDesc);
        txtEtc = findViewById(R.id.txtEtc);
        imgCurso = findViewById(R.id.imgCurso);
        btnAgroMenu = findViewById(R.id.btnAgroMenu);
        btnMaterias = findViewById(R.id.btnMaterias);
        rtBar = findViewById(R.id.rtBar);

    }

    private void paraAgro(){
        txtDuracao.setVisibility(View.GONE);
        txtVagas.setVisibility(View.GONE);
        txtModalidade.setVisibility(View.GONE);
        txtQuem.setVisibility(View.GONE);
        txtEtc.setVisibility(View.GONE);
        btnMaterias.setVisibility(View.GONE);
        btnAgroMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String nomeCurso = com.example.rolenoif.TesteVocacional.DescricaoCursos.nomeCursos[0];
                Intent intent = new Intent(PagDescricao.this, PaginaAgro.class);
                intent.putExtra("Curso", nomeCurso);
                startActivity(intent);
            }
        });

    }

    private void pegaCurso(){
        //Pega a intent de outra activity
        final Intent intent = getIntent();
        //Recuperei a string da outra activity
        String nomeCurso = intent.getStringExtra("Curso");
        Toast.makeText(PagDescricao.this, "Info: " + nomeCurso, Toast.LENGTH_SHORT).show();

        if (nomeCurso.equals(com.example.rolenoif.TesteVocacional.DescricaoCursos.getnomeCursos(0))){
            paraAgro();
            darNota(nomeCurso);
        }

        else if (nomeCurso.equals(com.example.rolenoif.TesteVocacional.DescricaoCursos.getnomeCursos(1))){
            txtCurso.setText(com.example.rolenoif.TesteVocacional.DescricaoCursos.getnomeCursos(1));
            txtDesc.setText(com.example.rolenoif.TesteVocacional.DescricaoCursos.getdescricaoCursos(1));
            ocultarCampos();
            darNota(nomeCurso);
            imgCurso.setBackgroundResource(R.drawable.tal);
            btnMaterias.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    String nomeCurso = com.example.rolenoif.TesteVocacional.DescricaoCursos.nomeCursos[1];
                    Intent intent = new Intent(PagDescricao.this, MateriasAgro.class);
                    intent.putExtra("Curso", nomeCurso);
                    startActivity(intent);
                }
            });

        }

        else if (nomeCurso.equals(com.example.rolenoif.TesteVocacional.DescricaoCursos.getnomeCursos(2))){
            txtCurso.setText(com.example.rolenoif.TesteVocacional.DescricaoCursos.getnomeCursos(2));
            txtDesc.setText(com.example.rolenoif.TesteVocacional.DescricaoCursos.getdescricaoCursos(2));
            ocultarCampos();
            darNota(nomeCurso);
            imgCurso.setBackgroundResource(R.drawable.ti);
            btnMaterias.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    String nomeCurso = com.example.rolenoif.TesteVocacional.DescricaoCursos.nomeCursos[2];
                    Intent intent = new Intent(PagDescricao.this, MateriasAgro.class);
                    intent.putExtra("Curso", nomeCurso);
                    startActivity(intent);
                }
            });

        }

        else if (nomeCurso.equals(com.example.rolenoif.TesteVocacional.DescricaoCursos.getnomeCursos(3))){
            txtCurso.setText(com.example.rolenoif.TesteVocacional.DescricaoCursos.getnomeCursos(3));
            txtDesc.setText(com.example.rolenoif.TesteVocacional.DescricaoCursos.getdescricaoCursos(3));
            ocultarCampos();
            darNota(nomeCurso);
            imgCurso.setBackgroundResource(R.drawable.tmb);
            btnMaterias.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    String nomeCurso = com.example.rolenoif.TesteVocacional.DescricaoCursos.nomeCursos[3];
                    Intent intent = new Intent(PagDescricao.this, MateriasAgro.class);
                    intent.putExtra("Curso", nomeCurso);
                    startActivity(intent);
                }
            });

        }

        else if (nomeCurso.equals(com.example.rolenoif.TesteVocacional.DescricaoCursos.getnomeCursos(4))){
            txtCurso.setText(com.example.rolenoif.TesteVocacional.DescricaoCursos.getnomeCursos(4));
            txtDesc.setText(com.example.rolenoif.TesteVocacional.DescricaoCursos.getdescricaoCursos(4));
            ocultarCampos();
            imgCurso.setBackgroundResource(R.drawable.tz);
            darNota(nomeCurso);
            btnMaterias.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    String nomeCurso = com.example.rolenoif.TesteVocacional.DescricaoCursos.nomeCursos[4];
                    Intent intent = new Intent(PagDescricao.this, MateriasAgro.class);
                    intent.putExtra("Curso", nomeCurso);
                    startActivity(intent);
                }
            });

        }else Toast.makeText(PagDescricao.this, "ERRO", Toast.LENGTH_SHORT).show();

    }

    private void darNota(final String nomeCurso) {
        rtBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                String emailUser = SharedPref.readUserEmail(getApplicationContext(), "user email", " ");
                notaBD(emailUser, nomeCurso, rating);
                SharedPref.saveNota(getApplicationContext(), "nota", "true");
            }
        });
    }

    private void notaBD(final String emailUser, final String nomeCurso, final Float notaCurso) {

        // StringRequest() começa aqui
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse( String response) {
                        //Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            String code = jsonObject.getString("code");
                            if (code.equals("sucess")) {
                                Toast.makeText(getApplicationContext(), "Nota cadastrada!", Toast.LENGTH_LONG).show();
                                SharedPref.saveNota(getApplicationContext(), "nota", "true");
                            }
                            else {
                                Toast.makeText(getApplicationContext(), "Erro ao salvar nota!",
                                        Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Erro ao cadastrar!", Toast.LENGTH_SHORT).show();
                            //Toast.makeText(getApplicationContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Erro no cadastro!", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() {
                // Cria um mapa p/ Criptografia
                Map<String, String> params = new HashMap<>();
                params.put("emailUser", emailUser);
                params.put("nomeCurso", nomeCurso);
                params.put("notaCurso", String.valueOf(notaCurso));
                return params;
            }

        };
        // StringRequest() acaba aqui --------------------------------------------------------------------------
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void ocultarCampos(){
        txtDuracao.setVisibility(View.VISIBLE);
        txtVagas.setVisibility(View.VISIBLE);
        txtModalidade.setVisibility(View.VISIBLE);
        txtQuem.setVisibility(View.VISIBLE);
        txtEtc.setVisibility(View.VISIBLE);
        btnAgroMenu.setVisibility(View.GONE);
        btnMaterias.setVisibility(View.VISIBLE);
    }

}
