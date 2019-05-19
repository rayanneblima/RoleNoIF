package com.example.rayanne.myapplication.Contas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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

    private CallbackManager callbackManager;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_perfil);
        callbackManager = CallbackManager.Factory.create();
        loginWithFB();
    }

    private void loginWithFB(){
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        try {

                            String name = object.getString("name");
                            String email = object.getString("email");
                            String id = object.getString("id");

                            TextView txtName, txtEmail, txtId;
                            ProfilePictureView profileImage;

                            txtName = findViewById(R.id.txtNome);
                            txtEmail = findViewById(R.id.txtEmail);
                            txtId = findViewById(R.id.txtId);
                            profileImage = findViewById(R.id.profileImage);


                            txtName.setText("Nome: " + name);
                            txtEmail.setText("E-mail: " + email);
                            txtId.setText("ID: " + id);
                            profileImage.setProfileId(id);

                            Toast.makeText(getApplicationContext(), "Bem-vindo(a), " + name + "!", Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });

                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender, birthday");
                request.setParameters(parameters);
                request.executeAsync();
            }

            @Override
            public void onCancel() {
                Log.i("TAG", "onCancel");
            }

            @Override
            public void onError(FacebookException error) {
                Log.i("TAG", "onError");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
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
        return super.onOptionsItemSelected(item);
    }

}