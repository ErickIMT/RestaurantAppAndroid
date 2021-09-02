package idat.apprestaurant.Presenter;

import android.view.View;

import idat.apprestaurant.Model.LoginInteractor;
import idat.apprestaurant.View.LoginView;
import idat.apprestaurant.api.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;
    private ApiClient apiClient;

    public LoginPresenterImpl(LoginView loginView, LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;  
    }
    @Override
    public void validateCredentials(String usuario, String password, View v) {

        if(loginView !=null){
            loginView.mostrarBarraProgreso();
        }
        loginInteractor.login(usuario,password, this, v);
    }

    @Override
    public void onDestroy() {

        loginView = null;
    }

    @Override
    public void onUsuarioError() {

        if(loginView != null){
            loginView.setUsuarioError();
            loginView.ocultarBarraProgreso();
        }

    }

    @Override
    public void onPasswordError() {

        if(loginView != null){
            loginView.setPasswordError();
            loginView.ocultarBarraProgreso();
        }
    }

    @Override
    public void onSuccess(View v) {
        if(loginView !=null){
            loginView.login(v);
        }
    }



}
