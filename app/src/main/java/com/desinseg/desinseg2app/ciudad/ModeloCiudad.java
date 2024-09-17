package com.desinseg.desinseg2app.ciudad;

public class ModeloCiudad {
    private int cod_ciudad;
    private String nombre;
    private String descripcion;
    private int cod_pais;
    private int cod_provincia;
    private int cod_estado;

    private String  key;

    public int getCod_ciudad() {
        return cod_ciudad;
    }

    public void setCod_ciudad(int cod_ciudad) {
        this.cod_ciudad = cod_ciudad;
    }

    public String toString() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCod_pais() {
        return cod_pais;
    }

    public void setCod_pais(int cod_pais) {
        this.cod_pais = cod_pais;
    }

    public int getCod_provincia() {
        return cod_provincia;
    }

    public void setCod_provincia(int cod_provincia) {
        this.cod_provincia = cod_provincia;
    }

    public int getCod_estado() {
        return cod_estado;
    }

    public void setCod_estado(int cod_estado) {
        this.cod_estado = cod_estado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
