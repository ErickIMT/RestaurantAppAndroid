package idat.apprestaurant;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import idat.apprestaurant.Model.PedidoPlato;
import idat.apprestaurant.databinding.ActivityMenuBinding;


public class MenuActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMenuBinding binding;
    private ArrayList<PedidoPlato> pedidoPlatosList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Enviar Pedido a confirmarActivity
        setSupportActionBar(binding.appBarMenu.toolbar);
        binding.appBarMenu.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pedidoPlatosList == null){
                    Snackbar.make(v, "Agrega Productos para Enviar", Snackbar.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(MenuActivity.this,ConfirmarPedidoActivity.class);
                    intent.putExtra("lista",pedidoPlatosList);
                    startActivity(intent);
                }
            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_menu, R.id.nav_reservas, R.id.nav_pedidos)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_menu);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_menu);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void aggListaFragment(PedidoPlato plato){
        if(pedidoPlatosList == null){
            pedidoPlatosList = new ArrayList<>();
        }

        pedidoPlatosList.add(plato);

        for(PedidoPlato i:pedidoPlatosList){
            Log.i("Lista:","Menu Activity: "+i.getCantidad()+" y "+i.getPlatoPed().getNombre());
        }

    }

    public void updateListaFragment(PedidoPlato plato){
        if(pedidoPlatosList.contains(plato)){
            int index = pedidoPlatosList.indexOf(plato);
            pedidoPlatosList.remove(index);
            pedidoPlatosList.add(index,plato);
        }
    }

    public void removeListaFragment(PedidoPlato plato){
        if(pedidoPlatosList.contains(plato)){
            pedidoPlatosList.remove(plato);
        }
    }
}