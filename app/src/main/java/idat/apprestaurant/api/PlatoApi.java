package idat.apprestaurant.api;

import okhttp3.OkHttpClient;

public class PlatoApi {

    public static final String BASE_URL_LISTA_PLATOS = "http://192.168.1.35:9323/apiRestaurantApp/api/platos/lista/";

    public static PlatoService getListaPromoService(){
        OkHttpClient okHttpClient = new OkHttpClient();
        return ApiClient.getClient(BASE_URL_LISTA_PLATOS,okHttpClient).create(PlatoService.class);
    }
}
