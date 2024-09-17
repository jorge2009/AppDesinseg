package com.desinseg.desinseg2app.usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UsuarioInterface {

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("UsuarioDSTV.php")
    Call<List<ModeloUsuario>> ValidoUsuario(
            @Field("usuario") String usuario,
            @Field("clave") String clave,
            @Field("key") String key
    );
}
