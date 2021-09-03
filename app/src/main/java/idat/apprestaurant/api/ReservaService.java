package idat.apprestaurant.api;

import java.util.List;

import idat.apprestaurant.Model.Reserva;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ReservaService {

    @GET("lista")
    Call<List<Reserva>> getListaReservas();

    @POST("grabar")
    Call<Reserva> guardarReserva(@Body Reserva reserva);
}
