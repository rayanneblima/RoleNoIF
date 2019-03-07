package com.example.rayanne.myapplication.Contas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

import java.util.Arrays;


public class TelaLogin extends AppCompatActivity {

    private CallbackManager callbackManager = CallbackManager.Factory.create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);
        getSupportActionBar().hide();
        loginFB();
        loginEntrar();
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

    public void loginEntrar(){
        //botão entrar
        Button EntrarButton = findViewById(R.id.entrarButton);

        EntrarButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(TelaLogin.this, PagMenu.class);
                startActivity(intent);
                finish();
                Toast.makeText(getApplicationContext(), R.string.bem_vindo, Toast.LENGTH_SHORT).show();
            }
        });
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
