package idat.apprestaurant.api;

import java.util.List;

import idat.apprestaurant.Model.Pedido;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PedidoService {

    @GET("lista")
    Call<List<Pedido>> getListaPedidos();

    @PUT("pago/{id}")
    Call<Pedido> setPago(@Path("id") int id);

    @POST("guardar")
    Call<Pedido> guardarPedido(@Body Pedido pedido);
}
