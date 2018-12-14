package securitysystem.ico.kz.myapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;
    private static Retrofit retrofit2=null;
    private static Retrofit retrofit3=null;
    public static Retrofit getClient(String baseUrl) {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static Retrofit getClient2(String baseUrl2) {
        if (retrofit2==null) {
            retrofit2 = new Retrofit.Builder()
                    .baseUrl(baseUrl2)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit2;
    }
    public static Retrofit getClient3(String baseUrl3) {
        if (retrofit3==null) {
            retrofit3 = new Retrofit.Builder()
                    .baseUrl(baseUrl3)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit3;
    }
}
