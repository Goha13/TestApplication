package securitysystem.ico.kz.myapplication;

import android.app.Activity;
import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PositionalDataSource;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

class ItemDataSource extends PositionalDataSource<Results> {
    public static final int PAGE_SIZE = 15;
    private  int PAGE = 1;
    String s;
    Context context;
    public ItemDataSource(Context context,String s){
        this.context=context;
        this.s=s;
    }
    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull final LoadInitialCallback<Results> callback) {
        final int page = 1;
        Log.d("pdljflkdsjfkljf", s);
        if (ConnectivityManager.isNetworkAvailable(context)) {
            Log.d("pdljflkdsjfkljf", s);
            if (s.equals("")) {
                HealthBookUtils.getHealthBookService().kinoList("US", "G", "popularity.desc", "71e6028b3b6b4f1992ba950bd3a937c9", page)
                        .enqueue(new Callback<StackApiResponse>() {
                            @Override
                            public void onResponse(Call<StackApiResponse> call, Response<StackApiResponse> response) {
                                if (response.body() != null) {
                                    StackApiResponse stackApiResponse = response.body();
                                    callback.onResult(stackApiResponse.getResults(), 0);
                                } else {
                                    Log.d("something get wrong", "somtheing get wrong");
                                }
                            }

                            @Override
                            public void onFailure(Call<StackApiResponse> call, Throwable t) {
                                Log.d("something get wrong", "somtheing get wrong");
                            }
                        });
            }
        else {
            HealthBookUtils.getHealthBookService().kinoSearch9(s, "71e6028b3b6b4f1992ba950bd3a937c9", page)
                    .enqueue(new Callback<StackApiResponse>() {
                        @Override
                        public void onResponse(Call<StackApiResponse> call, Response<StackApiResponse> response) {
                            if (response.body() != null) {
                                StackApiResponse stackApiResponse = response.body();
                                callback.onResult(stackApiResponse.getResults(), 0);
                            } else {
                                Log.d("something get wrong", "somtheing get wrong");
                            }
                        }

                        @Override
                        public void onFailure(Call<StackApiResponse> call, Throwable t) {
                            Log.d("something get wrong", "somtheing get wrong");
                        }
                    });
        }
    }
        else {
            fgfkg();
        }
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull final LoadRangeCallback<Results> callback) {
        PAGE=PAGE+1;
        if (ConnectivityManager.isNetworkAvailable(context)) {
            if (s.equals("")) {
        HealthBookUtils.getHealthBookService().kinoList("US","G","popularity.desc","71e6028b3b6b4f1992ba950bd3a937c9",PAGE)
                .enqueue(new Callback<StackApiResponse>() {
                    @Override
                    public void onResponse(Call<StackApiResponse> call, Response<StackApiResponse> response) {
                        if (response.body() != null) {
                            StackApiResponse stackApiResponse=response.body();
                            callback.onResult(stackApiResponse.getResults());
                        }
                        else{
                            Log.d("something get wrong","somtheing get wrong");
                        }
                    }

                    @Override
                    public void onFailure(Call<StackApiResponse> call, Throwable t) {
                        Log.d("something get wrong","somtheing get wrong");
                    }
                });}
                else {
                HealthBookUtils.getHealthBookService().kinoSearch9(s, "71e6028b3b6b4f1992ba950bd3a937c9", PAGE)
                        .enqueue(new Callback<StackApiResponse>() {
                            @Override
                            public void onResponse(Call<StackApiResponse> call, Response<StackApiResponse> response) {
                                if (response.body() != null) {
                                    StackApiResponse stackApiResponse = response.body();
                                    callback.onResult(stackApiResponse.getResults());
                                } else {
                                    Log.d("something get wrong", "somtheing get wrong");
                                }
                            }

                            @Override
                            public void onFailure(Call<StackApiResponse> call, Throwable t) {
                                Log.d("something get wrong", "somtheing get wrong");
                            }
                        });
            }
        }
         else {
                fgfkg();
            }
    }

    private void fgfkg() {
        ((Activity) context).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, context.getResources().getString(R.string.connect),Toast.LENGTH_LONG).show();
            }
        });
    }
}
