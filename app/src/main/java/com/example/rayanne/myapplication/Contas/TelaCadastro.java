package com.example.rayanne.myapplication.Contas;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rayanne.myapplication.Menu.PagMenu;
import com.example.rayanne.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rayanne on 22/05/2017.
 */

public class TelaCadastro extends AppCompatActivity {
    //TODO: dar a opçao de cadastro com o fb, pegando os dados e facilitando o cadastro.
    //TODO: verificar se a matricula corresponde a um aluno do IF
    //TODO: verificar se telefone ja foi cadastrado (PHP)
    //TODO: melhorar os toast de mensagem
    //TODO: conferir o private (segurança) dos campos

    private EditText edtName, edtEmail, edtMatricula, edtTelefone, edtCidade, edtSenha;
    private Button ButtonCadastro;

    //private static String URL_REGIST = "http://192.168.2.4/teste/confirmCadastro.php";
    //private static String URL_REGIST = "http://rolenoifapp.epizy.com/confirmCadastro.php";
    private static String URL_CADASTRO = "http://rolenoifapp.000webhostapp.com/cadastro.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);

        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtMatricula = findViewById(R.id.edtMatricula);
        edtTelefone = findViewById(R.id.edtTelefone);
        edtCidade = findViewById(R.id.edtCidade);
        edtSenha = findViewById(R.id.edtSenha);
        ButtonCadastro = findViewById(R.id.buttonCadastro);

        efetuarCadastro();
        entrarConta();
    }

    public void efetuarCadastro(){
        //botão cadastrar
        Button ButtonCadastro = findViewById(R.id.buttonCadastro);

        ButtonCadastro.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String nomeUser = edtName.getText().toString().trim();
                String emailUser = edtEmail.getText().toString().trim();
                String matriculaUser = edtMatricula.getText().toString().trim();
                String telefoneUser = edtTelefone.getText().toString().trim();
                String cidadeUser = edtCidade.getText().toString().trim();
                String senhaUser = edtSenha.getText().toString().trim();

                if (!(nomeUser.equals("") || emailUser.equals("") || matriculaUser.equals("") || telefoneUser.equals("") ||cidadeUser.equals("") || senhaUser.equals(""))) {
                    cadastrarUsuario(nomeUser, emailUser, matriculaUser, telefoneUser, cidadeUser, senhaUser);
                } else {
                    Toast.makeText(getApplicationContext(), R.string.branco_cadastro, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void cadastrarUsuario(final String nomeUser, final String emailUser, final String matriculaUser, final String telefoneUser, final String cidadeUser, final String senhaUser) {

        // Desativa o botão de cadastro (evitar vários cadastros)
        ButtonCadastro.setVisibility(View.GONE);

        // StringRequest() começa aqui
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_CADASTRO,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse( String response) {
                        //Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            String code = jsonObject.getString("code");
                            if (code.equals("cadastrado")){
                                Toast.makeText(getApplicationContext(), "E-mail já cadastrado! Verifique ou refaça seu cadastro.",
                                        Toast.LENGTH_LONG).show();
                            }
                            else if (code.equals("sucess")){
                                Toast.makeText(getApplicationContext(), "Seja Bem-Vindo, " + nomeUser + "!",
                                        Toast.LENGTH_LONG).show();
                                Intent intent = new Intent();
                                intent.setClass(TelaCadastro.this, PagMenu.class);
                                startActivity(intent);
                                finish();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Erro ao cadastrar!", Toast.LENGTH_SHORT).show();
                            //Toast.makeText(getApplicationContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
                            ButtonCadastro.setVisibility(View.VISIBLE);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Erro no cadastro!", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                        ButtonCadastro.setVisibility(View.VISIBLE);
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() {
                // Cria um mapa p/ Criptografia
                Map<String, String> params = new HashMap<>();
                params.put("nomeUser", nomeUser);
                params.put("emailUser", emailUser);
                params.put("matriculaUser", matriculaUser);
                params.put("telefoneUser", telefoneUser);
                params.put("cidadeUser", cidadeUser);
                params.put("senhaUser", senhaUser);
                return params;
            }

        };
        // StringRequest() acaba aqui --------------------------------------------------------------------------
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void entrarConta(){
        //botão entrar
        Button btnEntrar = findViewById(R.id.btnEntrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                popup_Cancel();
            }
        });
    }

    public void onBackPressed(){
        popup_Cancel();
    }

    public void popup_Cancel() {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        //builder.setTitle("");
        //define a mensagem
        builder.setMessage("Deseja cancelar o cadastro?");
        //define um botão como positivo
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
                Toast.makeText(getApplicationContext(), "Seu cadastro foi cancelado!", Toast.LENGTH_LONG).show();            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });
        //cria o AlertDialog
        //atributo da classe.
        AlertDialog alerta = builder.create();
        //Exibe
        alerta.show();
    }

}

