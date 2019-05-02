package com.example.rayanne.myapplication.Contas;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rayanne.myapplication.Menu.PagMenu;
import com.example.rayanne.myapplication.R;
import com.example.rayanne.myapplication.TesteVocacional.Jogo_TV;

/**
 * Created by Rayanne on 22/05/2017.
 */

public class TelaCadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);
        efetuarCadastro();
        entrarConta();
    }

    public void efetuarCadastro(){
        //botão cadastrar
        Button ButtonCadastro = findViewById(R.id.buttonCadastro);

        ButtonCadastro.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                EditText edtName = findViewById(R.id.edtName);
                EditText edtEmail = findViewById(R.id.edtEmail);
                EditText edtMatricula = findViewById(R.id.edtMatricula);
                EditText edtTelefone = findViewById(R.id.edtTelefone);
                EditText edtCidade = findViewById(R.id.edtCidade);
                EditText edtSenha = findViewById(R.id.edtSenha);

                if (edtName.getText().toString().trim().equals("") || edtEmail.getText().toString().trim().equals("") || edtMatricula.getText().toString().trim().equals("")
                        || edtTelefone.getText().toString().trim().equals("") || edtCidade.getText().toString().trim().equals("") || edtSenha.getText().toString().trim().equals("")) {

                    Toast.makeText(getApplicationContext(), R.string.branco_cadastro, Toast.LENGTH_SHORT).show();

                    } else {
                    cadastrarUsuario();
                    }
            }
        });
    }

    private void cadastrarUsuario() {
        // TODO take the form data and send to an .php page with the sql query...

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

