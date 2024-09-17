package com.desinseg.desinseg2app.ciudad;

import com.desinseg.desinseg2app.cliente.ModeloCliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CiudadInterface {
    @FormUrlEncoded
    @POST("ListaCiudadDST.php")
    Call<List<ModeloCiudad>> ListarCiudad(
            @Field("cod_ciudad") int codCiudad,
            @Field("nombre") String nombre,
            @Field("descripcion") String descripcion,
            @Field("cod_pais") int codPais,
            @Field("cod_provincia") int codProvincia,
            @Field("cod_estado") int codEstado,
            @Field("key") String key
    );
}
