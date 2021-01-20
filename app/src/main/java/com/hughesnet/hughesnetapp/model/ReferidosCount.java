package com.hughesnet.hughesnetapp.model;

import com.google.gson.annotations.SerializedName;

public class ReferidosCount {

    @SerializedName("total")
    private String total;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @SerializedName("contactados")
    private String contactados;

    @SerializedName("propuestos")
    private String propuestos;

    public String getContactados() {
        return contactados;
    }

    public void setContactados(String contactados) {
        this.contactados = contactados;
    }

    public String getPropuestos() {
        return propuestos;
    }

    public void setPropuestos(String propuestos) {
        this.propuestos = propuestos;
    }

    public String getConfirmados() {
        return confirmados;
    }

    public void setConfirmados(String confirmados) {
        this.confirmados = confirmados;
    }

    public String getVendidos() {
        return vendidos;
    }

    public void setVendidos(String vendidos) {
        this.vendidos = vendidos;
    }

    public String getInstalados() {
        return instalados;
    }

    public void setInstalados(String instalados) {
        this.instalados = instalados;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @SerializedName("confirmados")
    private String confirmados;

    @SerializedName("vendidos")
    private String vendidos;

    @SerializedName("instalados")
    private String instalados;

    @SerializedName("no")
    private String no;

}
