package com.desinseg.desinseg2app.empresa;

public class ModeloEmpresa {
    private int cod_empresa;
    private String nombre;
    private String direccion;
    private String telefono;
    private String ruc;
    private String imagen;

    public int getCod_empresa() {
        return cod_empresa;
    }

    public void setCod_empresa(int cod_empresa) {
        this.cod_empresa = cod_empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
