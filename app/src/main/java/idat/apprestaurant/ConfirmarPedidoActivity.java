package idat.apprestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import idat.apprestaurant.Model.AdapterListaConfirmPedido;
import idat.apprestaurant.Model.AdapterListaPedidos;
import idat.apprestaurant.Model.Pedido;
import idat.apprestaurant.Model.PedidoPlato;
import idat.apprestaurant.Model.TipoPedido;

public class ConfirmarPedidoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView total;
    private Switch switchOpc;
    private AdapterListaConfirmPedido adapter;
    private Button btnEnviar;
    private ArrayList<PedidoPlato> listaPlatos;
    private Pedido pedido;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_pedido);

        listaPlatos = getIntent().getParcelableExtra("lista");

        pedido.setPedidoPlatoPed(listaPlatos);

        recyclerView =findViewById(R.id.rViewListaPedidosConfirmacion);
        total = findViewById(R.id.txvTotalConfirmPedido);
        switchOpc = findViewById(R.id.switchTipoPedido);
        btnEnviar = findViewById(R.id.btnEnviarPedido);
        spinner = findViewById(R.id.spinnerMesaConfirm);

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

    }

    public void mostrarData(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterListaConfirmPedido(this,listaPlatos);
        recyclerView.setAdapter(adapter);
    }
}