package securitysystem.ico.kz.myapplication;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HealthBookService {
    @GET("3/discover/movie")
    Call<StackApiResponse> kinoList(@Query("certification_country") String certification_country,@Query("sort_by") String sort_by,@Query("certification.lte") String certificationlte,@Query("api_key") String api_key,@Query("page") int page);
    @GET("3/search/movie")
    Call<StackApiResponse> kinoSearch9(@Query("query") String query,@Query("api_key") String api_key,@Query("page") int page);
}
