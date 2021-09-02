package idat.apprestaurant.Presenter;

import android.content.Context;
import android.view.View;

public interface LoginPresenter {

    void validateCredentials(String usuario, String password, View v);
    void onDestroy();
}
