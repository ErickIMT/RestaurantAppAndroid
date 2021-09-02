package idat.apprestaurant.Model;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(String usuario, String password, OnLoginFinishedListener listener, View v) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(TextUtils.isEmpty(usuario)){
                    listener.onUsuarioError();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    return;
                }

                listener.onSuccess(v);
            }
        },1000);
    }
}
