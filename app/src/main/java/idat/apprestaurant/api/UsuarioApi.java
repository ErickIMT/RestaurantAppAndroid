package idat.apprestaurant.api;

import okhttp3.OkHttpClient;

public class UsuarioApi {

    private static final String BASE_URL_USUARIO = "http://192.168.1.35:9323/apiRestaurantApp/api/usuario/";

    public static UsuarioService getUsuarioService(){
        OkHttpClient okHttpClient = new OkHttpClient();
        return ApiClient.getClient(BASE_URL_USUARIO,okHttpClient).create(UsuarioService.class);
    }
}
