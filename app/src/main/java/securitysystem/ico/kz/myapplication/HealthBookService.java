package securitysystem.ico.kz.myapplication;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HealthBookService {
    @GET("3/discover/movie")
    Call<StackApiResponse> kinoList(@Query("certification_country") String certification_country,@Query("sort_by") String sort_by,@Query("certification.lte") String certificationlte,@Query("api_key") String api_key,@Query("page") int page);
}
