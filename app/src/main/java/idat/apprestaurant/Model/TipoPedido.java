package idat.apprestaurant.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TipoPedido {

    @SerializedName("idTipoPedido")
    @Expose
    private Integer idTipoPedido;
    @SerializedName("nombre")
    @Expose
    private String nombre;

    public TipoPedido(){}

    public TipoPedido(Integer idTipoPedido){
        this.idTipoPedido = idTipoPedido;
    }

    public TipoPedido(Integer idTipoPedido, String nombre) {
        this.idTipoPedido = idTipoPedido;
        this.nombre = nombre;
    }

    public Integer getIdTipoPedido() {
        return idTipoPedido;
    }

    public void setIdTipoPedido(Integer idTipoPedido) {
        this.idTipoPedido = idTipoPedido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
