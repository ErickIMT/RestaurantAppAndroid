package idat.apprestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Date;

import idat.apprestaurant.Model.Reserva;
import idat.apprestaurant.api.ReservaApi;
import idat.apprestaurant.api.ReservaService;
import idat.apprestaurant.ui.dialog.DatePickerFragment;
import idat.apprestaurant.ui.dialog.TimePickerFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroReservaActivity extends AppCompatActivity {

    private ReservaService servR;
    private EditText fecha, hora, cliente;
    private Spinner mesa;
    private Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_reserva);

        fecha = findViewById(R.id.edtFecha);
        hora = findViewById(R.id.edtHora);
        mesa = findViewById(R.id.edtMesa);
        cliente = findViewById(R.id.edtCliente);
        btnRegistrar = findViewById(R.id.btn_grabar_reserva);

        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.edtFecha:
                        showDatePickerDialog();
                        break;
                }
            }
        });

        hora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.edtHora:
                        showTimePickerDialog();
                        break;
                }
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarReserva();
            }
        });
    }

    private void showDatePickerDialog(){
        DatePickerFragment dateFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                //Al mes se le suma 1 porque Enero empieza en 0
                final String selectFecha = year + "-"+twoDigits(month+1)+"-"+twoDigits(dayOfMonth);
                fecha.setText(selectFecha);
            }
        });

        dateFragment.show(getSupportFragmentManager(), "datePicker");
    }

    private void showTimePickerDialog(){
        TimePickerFragment timeFragment = TimePickerFragment.newInstance(new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                final String selectHora = hourOfDay+":"+minute+":"+"00";
                hora.setText(selectHora);
            }
        });

        timeFragment.show(getSupportFragmentManager(),"timePicker");
    }

    private String twoDigits(int n){
        return (n <= 9) ? ("0"+n) : String.valueOf(n);
    }

    private void registrarReserva(){
        Reserva reserva =  new Reserva();
        reserva.setFecha(fecha.getText().toString());
        reserva.setHora(hora.getText().toString());
        reserva.setMesa(Integer.parseInt(mesa.getSelectedItem().toString()));
        reserva.setNombreCliente(cliente.getText().toString());

        servR = ReservaApi.getReservaService();
        Call<Reserva> call = servR.guardarReserva(reserva);
        call.enqueue(new Callback<Reserva>() {
            @Override
            public void onResponse(Call<Reserva> call, Response<Reserva> response) {

                Reserva reservaR = response.body();

                if(reservaR.getIdReserva() != null){
                    Toast.makeText(RegistroReservaActivity.this,"Reserva Registrada con ID: "+reservaR.getIdReserva(),Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegistroReservaActivity.this,MenuActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<Reserva> call, Throwable t) {
                Toast.makeText(RegistroReservaActivity.this,"Ocurrio un error al registrar: "+t.getMessage(),Toast.LENGTH_LONG).show();
                Log.e("Error-Retrofit: Registro Reserva", "Mensaje: "+t.getMessage());
            }
        });
    }


}