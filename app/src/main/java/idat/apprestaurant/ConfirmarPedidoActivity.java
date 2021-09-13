package idat.apprestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import idat.apprestaurant.Model.AdapterListaConfirmPedido;
import idat.apprestaurant.Model.AdapterListaPedidos;
import idat.apprestaurant.Model.Pedido;
import idat.apprestaurant.Model.PedidoPlato;
import idat.apprestaurant.Model.TipoPedido;
import idat.apprestaurant.api.PedidoApi;
import idat.apprestaurant.api.PedidoService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfirmarPedidoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView total;
    private Switch switchOpc;
    private AdapterListaConfirmPedido adapter;
    private Button btnEnviar;
    private ArrayList<PedidoPlato> listaPlatos = new ArrayList<>();
    private Pedido pedido;
    private Spinner spinner;
    private PedidoService servP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_pedido);

        recyclerView =findViewById(R.id.rViewListaPedidosConfirmacion);
        total = findViewById(R.id.txvTotalConfirmPedido);
        switchOpc = findViewById(R.id.switchTipoPedido);
        btnEnviar = findViewById(R.id.btnEnviarPedido);
        spinner = findViewById(R.id.spinnerMesaConfirm);

        listaPlatos = (ArrayList<PedidoPlato>) getIntent().getSerializableExtra("lista");

        float totalP = 0;
        for(PedidoPlato i : listaPlatos){

            float precio = i.getPlatoPed().getPrecio();
            int cant = i.getCantidad();
            totalP += precio*cant;
        }

        pedido = new Pedido();
        pedido.setPedidoPlatoPed(listaPlatos);

        total.setText(String.valueOf(totalP));

        switchOpc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TipoPedido tipoPedido = new TipoPedido();
                if(!isChecked) {
                    tipoPedido.setIdTipoPedido(1);
                    pedido.setTipoPedido(tipoPedido);
                }else{
                    tipoPedido.setIdTipoPedido(2);
                    pedido.setTipoPedido(tipoPedido);
                }
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postApi();
            }
        });
        mostrarData();
    }

    public void postApi(){
        servP = PedidoApi.getPedidoService();
        pedido.setNumDoc("B-Android");
        pedido.setMesa(Integer.parseInt(spinner.getSelectedItem().toString()));
        Call<Pedido> call = servP.guardarPedido(pedido);
        call.enqueue(new Callback<Pedido>() {
            @Override
            public void onResponse(Call<Pedido> call, Response<Pedido> response) {
                Toast.makeText(getApplicationContext(), "Pedido creado : "+response.body().getIdPedido().toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Pedido> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"ocurrio un error: "+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    public void mostrarData(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterListaConfirmPedido(this,listaPlatos);
        recyclerView.setAdapter(adapter);
    }
}