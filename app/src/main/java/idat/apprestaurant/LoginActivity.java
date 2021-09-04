package idat.apprestaurant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import idat.apprestaurant.Model.LoginInteractorImpl;
import idat.apprestaurant.Model.Usuario;
import idat.apprestaurant.Presenter.LoginPresenter;
import idat.apprestaurant.Presenter.LoginPresenterImpl;
import idat.apprestaurant.View.LoginView;
import idat.apprestaurant.api.UsuarioApi;
import idat.apprestaurant.api.UsuarioService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends Activity implements LoginView, View.OnClickListener {

    private UsuarioService servU;

    private ProgressBar progressBar;
    private EditText usuario;
    private EditText password;
    private Button btnLogin;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = findViewById(R.id.progressBar);
        usuario = findViewById(R.id.edtUsuario);
        password = findViewById(R.id.edtContrasena);
        btnLogin = findViewById(R.id.btnIngresar);

        btnLogin.setOnClickListener(this);
        presenter = new LoginPresenterImpl(this, new LoginInteractorImpl());

    }


    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {

        presenter.validateCredentials(usuario.getText().toString(),password.getText().toString(), v);
    }

    @Override
    public void mostrarBarraProgreso() {

        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void ocultarBarraProgreso() {

        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsuarioError() {

        usuario.setError("Error Usuario");

    }

    @Override
    public void setPasswordError() {

        password.setError("Error Password");
    }

    @Override
    public void login(View v) {
        Usuario usuarioL = new Usuario();
        usuarioL.setUsuario(usuario.getText().toString());
        usuarioL.setPassword(password.getText().toString());

        servU = UsuarioApi.getUsuarioService();
        Call<String> call = servU.getLogin(usuarioL);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.body().equals("EXITOSO")){
                    Toast.makeText(getApplicationContext(), "Haz Ingresado al Sistema", Toast.LENGTH_LONG).show();
                    ocultarBarraProgreso();
                    Intent intent = new Intent(v.getContext(), MenuActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this, "Usuario o Password Incorrectos", Toast.LENGTH_LONG).show();
                    ocultarBarraProgreso();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error en el Login", Toast.LENGTH_LONG).show();
                Log.e("Ocurrio un Error", t.getMessage());
                ocultarBarraProgreso();

            }
        });
    }
}