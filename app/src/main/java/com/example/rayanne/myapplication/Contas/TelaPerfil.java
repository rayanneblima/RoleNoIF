package com.example.rayanne.myapplication.Contas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rayanne.myapplication.Menu.PagMenu;
import com.example.rayanne.myapplication.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.ProfilePictureView;

import org.json.JSONException;
import org.json.JSONObject;

public class TelaPerfil extends AppCompatActivity {
    //TODO: conferir o private (segurança) dos campos

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        loginWithFB();
    }

    private void loginWithFB() {
        Intent intent = getIntent();
        String userID = intent.getStringExtra("id");
        String name = intent.getStringExtra("name");
        String surname = intent.getStringExtra("lastname");
        String email = intent.getStringExtra("email");

        TextView id = findViewById(R.id.txtId);
        TextView nameView = findViewById(R.id.txtNome);
        TextView emailView = findViewById(R.id.txtEmail);

        id.setText(userID);
        nameView.setText(" " + name + " " + surname);
        emailView.setText(email);

        ProfilePictureView profilePicture = findViewById(R.id.profileImage);
        profilePicture.setProfileId(userID);

    }

    //Editar Perfil"
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.edit_profile){
            Intent intent = new Intent(TelaPerfil.this, TelaEditPerfil.class);
            startActivity(intent);
        }
        if (id == R.id.logout){
            LoginManager.getInstance().logOut();
            Intent login = new Intent(TelaPerfil.this, TelaLogin.class);
            startActivity(login);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}