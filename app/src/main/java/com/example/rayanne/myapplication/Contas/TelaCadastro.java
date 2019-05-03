package com.example.rayanne.myapplication.Contas;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
import com.example.rayanne.myapplication.TesteVocacional.Jogo_TV;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rayanne on 22/05/2017.
 */

public class TelaCadastro extends AppCompatActivity {

    private EditText edtName, edtEmail, edtMatricula, edtTelefone, edtCidade, edtSenha;
    private Button ButtonCadastro;

    //TODO Trocar essa variavel com informações do servidor e configurar os arquivos .php com o login dos bancos de dados do servidor do app
    private static String URL_REGIST = "http://127.0.0.1/roleIf/confirmCadastro.php";

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
                if (edtName.getText().toString().trim().equals("") || edtEmail.getText().toString().trim().equals("") || edtMatricula.getText().toString().trim().equals("") || edtTelefone.getText().toString().trim().equals("") || edtCidade.getText().toString().trim().equals("") || edtSenha.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), R.string.branco_cadastro, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Deveria ter cadastrado", Toast.LENGTH_SHORT).show();
                    String nome = edtName.getText().toString().trim();
                    String email = edtEmail.getText().toString().trim();
                    String matricula = edtMatricula.getText().toString().trim();
                    String telefone = edtTelefone.getText().toString().trim();
                    String cidade = edtCidade.getText().toString().trim();
                    String senha = edtSenha.getText().toString().trim();

                    cadastrarUsuario(nome, email, matricula, telefone, cidade, senha);
                }
            }
        });
    }

    private void cadastrarUsuario(final String nome, final String email, final String matricula, final String telefone,  final String cidade, final String senha) {

        // Desativa o botão de cadastro (evitar vários cadastros)
        ButtonCadastro.setVisibility(View.GONE);

        // StringRequest() começa aq
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            if(success.equals("0")){
                                Toast.makeText(getApplicationContext(), R.string.suc_cadastro, Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Erro no cadastro!", Toast.LENGTH_SHORT).show();
                            ButtonCadastro.setVisibility(View.VISIBLE);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Erro no cadastro!", Toast.LENGTH_SHORT).show();
                        ButtonCadastro.setVisibility(View.VISIBLE);
                    }
                }
                ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // Cria um mapa p/ Criptografia utilizando o nome o email e a senha q a pessoa passou para cadastrar.
                Map<String, String> params = new HashMap<>();
                params.put("nome", nome);
                params.put("email", email);
                params.put("senha", senha);
                return super.getParams();
            }
        };
        // StringRequest() acaba aq --------------------------------------------------------------------------

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        /*
        ** TAVA ANTES DOS TESTES COM O CONTEUDO DO VOLLEY **

        ProgressDialog progre = new ProgressDialog(TelaCadastro.this);
        //Configura o título da progress dialog
        //progressDialog.setTitle("Titulo da barra");
        //configura a mensagem de que está sendo feito o carregamento
        progre.setMessage("Cadastrando...por favor aguarde.");
        String url = "https://rolenoifapp.epizy.com";

        Intent intent = new Intent();
        intent.setClass(TelaCadastro.this, PagMenu.class);
        startActivity(intent);
        finish();
        Toast.makeText(getApplicationContext(), R.string.suc_cadastro, Toast.LENGTH_SHORT).show();
        //Toast.makeText(getApplicationContext(), R.string.bem_vindo, Toast.LENGTH_SHORT).show();
        */
    }

    public void entrarConta(){
        //botão entrar
        Button btnEntrar = (Button) findViewById(R.id.btnEntrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(TelaCadastro.this, TelaLogin.class);
                startActivity(intent);

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

