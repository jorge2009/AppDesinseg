package com.desinseg.desinseg2app.producto;

import com.desinseg.desinseg2app.cliente.ModeloCliente;

import java.math.BigDecimal;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ProductoInterface {
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("InsertaProductoDST.php")
    Call<List<ModeloProducto>> GuardoProducto(
            @Field("nombre") String nombre,
            @Field("descripcion") String descripcion,
            @Field("ruta") String ruta,
            @Field("ver") String ver,
            @Field("des_corta") String desCorta,
            @Field("valor") double valor,
            @Field("cod_estado") int codEstado,
            @Field("cod_bodega") int codBodega,
            @Field("cantidad") int cantidad,
            @Field("cod_empresa") int  codEmpresa,
            @Field("cod_proveedor") int codProveedor,
            @Field("cod_producto") int codProducto,
            @Field("key") String key
    );
}
