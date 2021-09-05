package idat.apprestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import idat.apprestaurant.Model.Pedido;
import idat.apprestaurant.api.PedidoApi;
import idat.apprestaurant.api.PedidoService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MetodosPago extends AppCompatActivity {

    private Button wallet, efectivo, tarjeta;
    private PedidoService servP;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metodos_pago);

        wallet = findViewById(R.id.btnWallet);
        efectivo = findViewById(R.id.btnEfectivo);
        tarjeta = findViewById(R.id.btnTarjeta);

        id = getIntent().getExtras().getInt("id");

        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MetodosPago.this,WalletActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        efectivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPago();
            }
        });

        tarjeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPago();
            }
        });
    }

    private void setPago(){
        servP = PedidoApi.getPedidoService();
        Call<Pedido> call = servP.setPago(this.id);
        call.enqueue(new Callback<Pedido>() {
            @Override
            public void onResponse(Call<Pedido> call, Response<Pedido> response) {
                Pedido pedido = response.body();
                Toast.makeText(MetodosPago.this,"PAGO EXITOSO - MESA: "+pedido.getMesa(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MetodosPago.this,MenuActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Pedido> call, Throwable t) {
                Toast.makeText(MetodosPago.this, "Ha Ocurrido un Error con el Pago", Toast.LENGTH_SHORT).show();
            }
        });
    }
}