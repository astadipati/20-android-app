package net.ramastudio.sitara20.utils.api;

public class UtilsApi {

    // 10.0.2.2 ini adalah localhost.
//    public static final String BASE_URL_API = "http://192.168.2.8/API-mahasiswa/";
//    public static final String BASE_URL_API = "http://192.168.2.8/sippAPI/";
    public static final String BASE_URL_API = "http://iix.pa-tuban.go.id/";

    // Mendeklarasikan Interface BaseApiService
    public static ApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(ApiService.class);
    }
}
