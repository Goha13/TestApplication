package securitysystem.ico.kz.myapplication;

public class HealthBookUtils {
    private HealthBookUtils() {}

    public static final String BASE_URL = "https://api.themoviedb.org/";

    public static HealthBookService getHealthBookService() {

        return RetrofitClient.getClient(BASE_URL).create(HealthBookService.class);
    }
}
