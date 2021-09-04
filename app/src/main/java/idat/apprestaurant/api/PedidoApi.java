package idat.apprestaurant.api;

import okhttp3.OkHttpClient;

public class PedidoApi {

    private static final String BASE_URL_LISTA_PEDIDOS = "http://192.168.1.35:9323/apiRestaurantApp/api/pedidos/";

    public static PedidoService getPedidoService(){
        OkHttpClient okHttpClient = new OkHttpClient();
        return ApiClient.getClient(BASE_URL_LISTA_PEDIDOS,okHttpClient).create(PedidoService.class);
    }
}
