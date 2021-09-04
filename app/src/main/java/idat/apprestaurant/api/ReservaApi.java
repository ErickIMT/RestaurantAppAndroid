package idat.apprestaurant.api;

import okhttp3.OkHttpClient;

public class ReservaApi {

    private static final String BASE_URL_RESERVA = "http://192.168.1.35:9323/apiRestaurantApp/api/reservas/";

    public static ReservaService getReservaService(){
        OkHttpClient okHttpClient = new OkHttpClient();
        return ApiClient.getClient(BASE_URL_RESERVA,okHttpClient).create(ReservaService.class);
    }
}
