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

public class WalletActivity extends AppCompatActivity {

    private Button btnFinalizar;
    private int id;
    private PedidoService servP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        btnFinalizar = findViewById(R.id.btnFinalizarWallet);

        id = getIntent().getExtras().getInt("id");
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
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
                Toast.makeText(WalletActivity.this,"PAGO EXITOSO - MESA: "+pedido.getMesa(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(WalletActivity.this,MenuActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Pedido> call, Throwable t) {
                Toast.makeText(WalletActivity.this, "Ha Ocurrido un Error con el Pago", Toast.LENGTH_SHORT).show();
            }
        });
    }
}