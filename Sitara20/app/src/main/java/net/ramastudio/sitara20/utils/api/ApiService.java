package net.ramastudio.sitara20.utils.api;

import net.ramastudio.sitara20.model.ResponseBerita;
import net.ramastudio.sitara20.model.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> loginRequest(@Field("email") String email,
                                    @Field("password") String password);

    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseBody> registerRequest(@Field("IDperkara") String idperkara,
                                       @Field("nama") String nama,
                                       @Field("email") String email,
                                       @Field("password") String password);

    @GET("index.php/berita")
    Call<ResponseBerita> request_show_all_berita();

    @GET("index.php/user/{idperkara}")
    Call<User> getUser(@Path("idperkara") int dataId);
}