package idat.apprestaurant.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Date;

public class Reserva {

    @SerializedName("idReserva")
    @Expose
    private Integer idReserva;
    @SerializedName("mesa")
    @Expose
    private Integer mesa;
    @SerializedName("fecha")
    @Expose
    private Date fecha;
    @SerializedName("hora")
    @Expose
    private String hora;
    @SerializedName("nombreCliente")
    @Expose
    private String nombreCliente;

    public Reserva(Integer idReserva, Integer mesa, Date fecha, String hora, String nombreCliente) {
        this.idReserva = idReserva;
        this.mesa = mesa;
        this.fecha = fecha;
        this.hora = hora;
        this.nombreCliente = nombreCliente;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Integer getMesa() {
        return mesa;
    }

    public void setMesa(Integer mesa) {
        this.mesa = mesa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
}
