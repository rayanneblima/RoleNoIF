package com.example.rayanne.myapplication.Contas;

import android.content.Intent;
import android.os.Bundle;
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
import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TelaLogin extends AppCompatActivity {

    private EditText edtEmail, edtSenha;
    private Button entrarButton;

    private static String URL_LOGIN = "http://192.168.2.4/teste/login.php";
    //private static String URL_REGIST = "http://rolenoifapp.epizy.com/login.php";
    private CallbackManager callbackManager = CallbackManager.Factory.create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);
        getSupportActionBar().hide();

        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        entrarButton = findViewById(R.id.entrarButton);

        loginFB();
        loginbtnEntrar();
        cadastroUsuario();
    }

    public void loginFB(){

        //botão facebook
        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LoginManager.getInstance().logInWithReadPermissions(TelaLogin.this,Arrays.asList("public_profile","email"));

            }
        });

        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                goMainScreen();

                //ARRUMAR O IF/ELSE
                if (Profile.getCurrentProfile() != null) {
                    /*Profile profile = Profile.getCurrentProfile();
                    String firstName = profile.getName();
                    Toast.makeText(getApplicationContext(), "Bem-vindo(a), " + firstName + "!", Toast.LENGTH_LONG).show();*/
                    Intent intent = new Intent();
                    intent.setClass(TelaLogin.this, PagMenu.class);
                    startActivity(intent);
                } else {
                    ProfileTracker profileTracker = new ProfileTracker() {
                        @Override
                        protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                            stopTracking();
                            Profile.setCurrentProfile(currentProfile);
                            String firstName = currentProfile.getName();
                            Toast.makeText(getApplicationContext(), "Bem-vindo(a), " + firstName + "!", Toast.LENGTH_LONG).show();
                        }
                    };
                    profileTracker.startTracking();
                }
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), R.string.cancel_login, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), R.string.error_login, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void goMainScreen() {
        Intent intent = new Intent(this, PagMenu.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void loginbtnEntrar(){
        //botão entrar
        entrarButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String emailUser = edtEmail.getText().toString().trim();
                String senhaUser = edtSenha.getText().toString().trim();

                if (emailUser.equals("") || senhaUser.equals("")) {
                    Toast.makeText(getApplicationContext(), R.string.branco_cadastro, Toast.LENGTH_SHORT).show();
                } else {
                    logarUsuario(emailUser, senhaUser);
                }
            }
        });
    }

    private void logarUsuario(final String emailUser, final String senhaUser) {
        // StringRequest() começa aqui
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse( String response) {
                        //Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            String code = jsonObject.getString("code");
                            if (code.equals("sucess")){
                                Toast.makeText(getApplicationContext(), "Seja Bem-Vindo(a)!",
                                        Toast.LENGTH_LONG).show();
                                Intent intent = new Intent();
                                intent.setClass(TelaLogin.this, PagMenu.class);
                                startActivity(intent);
                                finish();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Confira os dados inseridos!", Toast.LENGTH_SHORT).show();
                            //Toast.makeText(getApplicationContext(), "ERROR: " + e.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Erro ao logar!", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // Cria um mapa p/ Criptografia
                Map<String, String> params = new HashMap<>();
                params.put("emailUser", emailUser);
                params.put("senhaUser", senhaUser);
                return params;
            }

        };
        // StringRequest() acaba aqui --------------------------------------------------------------------------
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void cadastroUsuario(){
        //botão cadastre-se
        Button btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(TelaLogin.this, TelaCadastro.class);
                startActivity(intent);
            }
        });
    }

}
