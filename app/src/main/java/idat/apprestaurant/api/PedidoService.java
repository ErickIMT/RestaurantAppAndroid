package idat.apprestaurant.api;

import java.util.List;

import idat.apprestaurant.Model.Pedido;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PedidoService {

    @GET("lista")
    Call<List<Pedido>> getListaPedidos();
}
