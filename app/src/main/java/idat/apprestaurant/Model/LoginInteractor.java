package idat.apprestaurant.Model;

import android.view.View;

public interface LoginInteractor {

    interface OnLoginFinishedListener{
        void onUsuarioError();
        void onPasswordError();
        void onSuccess(View v);
    }

    void login(String usuario, String password, OnLoginFinishedListener listener, View v);
}
