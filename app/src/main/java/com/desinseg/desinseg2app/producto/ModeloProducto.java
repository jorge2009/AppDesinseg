package com.desinseg.desinseg2app.producto;

public class ModeloProducto {
    private int cod_producto;
    private String nombre;
    private Double valor;
    private String descripcion;
    private String ruta;
    private String ver;
    private int cod_estado;
    private String des_corta;
    private int cod_bodega;
    private int cantidad;
    private int cod_proveedor;
    private int cod_empresa;

    public int getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public int getCod_estado() {
        return cod_estado;
    }

    public void setCod_estado(int cod_estado) {
        this.cod_estado = cod_estado;
    }

    public String getDes_corta() {
        return des_corta;
    }

    public void setDes_corta(String des_corta) {
        this.des_corta = des_corta;
    }

    public int getCod_bodega() {
        return cod_bodega;
    }

    public void setCod_bodega(int cod_bodega) {
        this.cod_bodega = cod_bodega;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCod_proveedor() {
        return cod_proveedor;
    }

    public void setCod_proveedor(int cod_proveedor) {
        this.cod_proveedor = cod_proveedor;
    }

    public int getCod_empresa() {
        return cod_empresa;
    }

    public void setCod_empresa(int cod_empresa) {
        this.cod_empresa = cod_empresa;
    }
}
