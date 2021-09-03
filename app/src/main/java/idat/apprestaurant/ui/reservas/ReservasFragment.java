package idat.apprestaurant.ui.reservas;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

import idat.apprestaurant.Model.AdapterListaReservas;
import idat.apprestaurant.Model.Reserva;
import idat.apprestaurant.R;
import idat.apprestaurant.api.ReservaApi;
import idat.apprestaurant.api.ReservaService;
import idat.apprestaurant.databinding.FragmentReservasBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReservasFragment extends Fragment {

    private View v;
    private RecyclerView recyclerView;
    private AdapterListaReservas adapter;
    private ReservaService servR;
    private List<Reserva> listaR;
    private Button btnRegistrar;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_reservas,container,false);
        recyclerView = v.findViewById(R.id.rViewListaReserva);

        btnRegistrar = v.findViewById(R.id.btn_registrar_reserva);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Vas a Registrar un Reserva", Toast.LENGTH_LONG).show();
            }
        });
        consultarApi();
        return v;
    }

    public void consultarApi(){
        listaR = new ArrayList<>();

        servR = ReservaApi.getReservaService();
        Call<List<Reserva>> call = servR.getListaReservas();
        call.enqueue(new Callback<List<Reserva>>() {
            @Override
            public void onResponse(Call<List<Reserva>> call, Response<List<Reserva>> response) {
                listaR.addAll(response.body());
                mostrarData();
            }

            @Override
            public void onFailure(Call<List<Reserva>> call, Throwable t) {
                Toast.makeText(getContext(), "Ocurrio Un Error: "+ t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("RetroError", "onFailure: "+t.getMessage());
            }
        });
    }

    public void mostrarData(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new AdapterListaReservas(getContext(),listaR);
        recyclerView.setAdapter(adapter);
    }
}