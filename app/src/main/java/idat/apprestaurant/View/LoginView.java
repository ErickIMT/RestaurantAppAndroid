package idat.apprestaurant.View;

import android.view.View;

public interface LoginView {

    void mostrarBarraProgreso();
    void ocultarBarraProgreso();
    void setUsuarioError();
    void setPasswordError();
    void login(View v);
}
