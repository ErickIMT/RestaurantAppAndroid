package idat.apprestaurant.ui.pedidos;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import idat.apprestaurant.Model.AdapterListaPedidos;
import idat.apprestaurant.Model.Pedido;
import idat.apprestaurant.Model.PedidoPlato;
import idat.apprestaurant.Model.Producto;
import idat.apprestaurant.Model.TipoPedido;
import idat.apprestaurant.R;
import idat.apprestaurant.api.PedidoApi;
import idat.apprestaurant.api.PedidoService;
import idat.apprestaurant.databinding.FragmentPedidosBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PedidosFragment extends Fragment {

    private View v;
    private PedidosViewModel pedidosViewModel;
    private RecyclerView recyclerView;
    private AdapterListaPedidos adapter;
    private PedidoService servP;
    private List<Pedido> listPed;

    public PedidosFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_pedidos,container,false);
        recyclerView = v.findViewById(R.id.rViewListaPedidos);

        consultarApi();
        return v;
    }

    public void consultarApi() {
        listPed = new ArrayList<>();

        servP = PedidoApi.getPedidoService();
        Call<List<Pedido>> call = servP.getListaPedidos();
        call.enqueue(new Callback<List<Pedido>>() {
            @Override
            public void onResponse(Call<List<Pedido>> call, Response<List<Pedido>> response) {
                listPed.addAll(response.body());
                mostrarData();
            }

            @Override
            public void onFailure(Call<List<Pedido>> call, Throwable t) {
                Toast.makeText(getContext(), "Ocurrio Un Error: "+ t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("RetroError", "onFailure: "+t.getMessage());
            }
        });
    }

    public void mostrarData(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new AdapterListaPedidos(getContext(),listPed);
        recyclerView.setAdapter(adapter);
    }
}