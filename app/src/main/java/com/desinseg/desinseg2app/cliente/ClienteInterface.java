package com.desinseg.desinseg2app.cliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ClienteInterface {
    @FormUrlEncoded
    @POST("ListaClienteDST.php")
    Call<List<ModeloCliente>> ListarCliente(
      @Field("cod_cliente") int codCliente,
      @Field("nombre") String nombre,
      @Field("apellido") String apellido,
      @Field("apellido2") String apellido2,
      @Field("direccion") String direccion,
      @Field("telefono") int telefono,
      @Field("cod_ciudad") int codCiudad,
      @Field("documento") String documento,
      @Field("cod_documento") int codDocumento,
      @Field("correo") String correo,
      @Field("cod_estado") int codEstado,
      @Field("cod_empresa") int codEmpresa

    );

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("InsertaClienteDST.php")
     Call<List<ModeloCliente>> GuardoCliente(
            @Field("nombre") String nombre,
            @Field("apellido") String apellido,
            @Field("apellido2") String apellido2,
            @Field("direccion") String direccion,
            @Field("telefono") int telefono,
            @Field("correo") String correo,
            @Field("cod_ciudad") int codCiudad,
            @Field("documento") String documento,
            @Field("cod_documento") int codDocumento,
            @Field("cod_estado") int codEstado,
            @Field("cod_empresa") int codEmpresa,
            @Field("cod_cliente") int codCliente,
            @Field("key") String key
    );
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("ActualizarClienteDST.php")
    Call<ModeloCliente> ActualizoCliente(
            @Field("nombre") String nombre,
            @Field("apellido") String apellido,
            @Field("apellido2") String apellido2,
            @Field("direccion") String direccion,
            @Field("telefono") int telefono,
            @Field("correo") String correo,
            @Field("cod_ciudad") int codCiudad,
            @Field("documento") String documento,
            @Field("cod_documento") int codDocumento,
            @Field("cod_estado") int codEstado,
            @Field("cod_empresa") int codEmpresa,
            @Field("key") String key
    );

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("EliminoClienteDST.php")
    Call<ModeloCliente> EliminoCliente(
            @Field("cod_cliente") String codCliente,
            @Field("nombre") String nombre,
            @Field("apellido") String apellido,
            @Field("apellido2") String apellido2,
            @Field("direccion") String direccion,
            @Field("telefono") int telefono,
            @Field("correo") String correo,
            @Field("cod_ciudad") int codCiudad,
            @Field("documento") String documento,
            @Field("cod_documento") int codDocumento,
            @Field("cod_estado") int codEstado,
            @Field("cod_empresa") int codEmpresa,
            @Field("key") String key
    );

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("BuscoClientePorDatosDST.php")
    Call<ModeloCliente> BuscoCliente(
            @Field("cod_cliente") String codCliente,
            @Field("nombre") String nombre,
            @Field("apellido") String apellido,
            @Field("apellido2") String apellido2,
            @Field("direccion") String direccion,
            @Field("telefono") int telefono,
            @Field("correo") String correo,
            @Field("cod_ciudad") int codCiudad,
            @Field("documento") String documento,
            @Field("cod_documento") int codDocumento,
            @Field("cod_estado") int codEstado,
            @Field("cod_empresa") int codEmpresa,
            @Field("key") String key
    );

}
