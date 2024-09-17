package com.desinseg.desinseg2app.cliente;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModeloCliente {

    private int cod_cliente;

    private String nombre;

    private String apellido;

    private String apellido2;

    private String direccion;

    private int telefono;

    private  int cod_ciudad;


    private String documento;


    private int cod_documento;

    private String correo;


    private int cod_estado;


    private int cod_empresa;


    private String key;

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCod_ciudad() {
        return cod_ciudad;
    }

    public void setCod_ciudad(int cod_ciudad) {
        this.cod_ciudad = cod_ciudad;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getCod_documento() {
        return cod_documento;
    }

    public void setCod_documento(int cod_documento) {
        this.cod_documento = cod_documento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getCod_estado() {
        return cod_estado;
    }

    public void setCod_estado(int cod_estado) {
        this.cod_estado = cod_estado;
    }

    public int getCod_empresa() {
        return cod_empresa;
    }

    public void setCod_empresa(int cod_empresa) {
        this.cod_empresa = cod_empresa;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


}
