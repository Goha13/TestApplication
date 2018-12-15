package securitysystem.ico.kz.myapplication;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailedActivity extends AppCompatActivity {
TextView vote_count,idd,video,vote_average,title,popularity,poster_path,original_language,original_title,backdrop_path,adult,overview,release_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        vote_count=findViewById(R.id.vote_count);
        idd=findViewById(R.id.idd);
        video=findViewById(R.id.video);
        vote_average=findViewById(R.id.vote_average);
        title=findViewById(R.id.title);
        popularity=findViewById(R.id.popularity);
        poster_path=findViewById(R.id.poster_path);
        original_language=findViewById(R.id.original_language);
        original_title=findViewById(R.id.original_title);
        backdrop_path=findViewById(R.id.backdrop_path);
        adult=findViewById(R.id.adult);
        overview=findViewById(R.id.overview);
        release_date=findViewById(R.id.release_date);
//        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(getResources().getString(R.string.kininf));

        vote_count.setText(String.valueOf(getIntent().getIntExtra("vote_count", 999999999)));
        idd.setText(String.valueOf(getIntent().getIntExtra("id",999999999)));
        video.setText(String.valueOf(getIntent().getBooleanExtra("video",false)));
        vote_average.setText(String.valueOf(getIntent().getDoubleExtra("vote_average",99999.999999)));
        title.setText(getIntent().getStringExtra("title")!=null?getIntent().getStringExtra("title"):"need data available");
        popularity.setText(String.valueOf(getIntent().getDoubleExtra("popularity",9999.9999)));
        poster_path.setText(getIntent().getStringExtra("poster_path")!=null?getIntent().getStringExtra("poster_path"):"need data available");
        original_language.setText(getIntent().getStringExtra("original_language")!=null?getIntent().getStringExtra("original_language"):"need data available");
        original_title.setText(getIntent().getStringExtra("original_title")!=null?getIntent().getStringExtra("original_title"):"need data available");
        backdrop_path.setText(getIntent().getStringExtra("backdrop_path")!=null?getIntent().getStringExtra("backdrop_path"):"need data available");
        adult.setText(String.valueOf(getIntent().getBooleanExtra("adult",false)));
        overview.setText(getIntent().getStringExtra("overview")!=null?getIntent().getStringExtra("overview"):"need data available");
        release_date.setText(getIntent().getStringExtra("release_date")!=null?getIntent().getStringExtra("release_date"):"need data available");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        MenuItem add_to_fav = menu.findItem(R.id.add_to_fav);
        if(new ShaaredPreferences(this).load(original_title.getText().toString()).equals("true")){
            add_to_fav.setTitle("Удалить с избранных");
        }
        else if(new ShaaredPreferences(this).load(original_title.getText().toString()).equals("")){
            add_to_fav.setTitle("Добавить в избранное");
        }
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        MenuItem add_to_fav = menu.findItem(R.id.add_to_fav);
        if(new ShaaredPreferences(this).load(original_title.getText().toString()).equals("true")){
            add_to_fav.setTitle("Удалить с избранных");
        }
        else if (new ShaaredPreferences(this).load(original_title.getText().toString()).equals("")){
            add_to_fav.setTitle("Добавить в избранное");
        }
        return super.onPrepareOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_to_fav:
                Log.d("idd",original_title.getText().toString());
                if(new ShaaredPreferences(this).load(original_title.getText().toString()).equals("true")){
                    new ShaaredPreferences(this).save(original_title.getText().toString(),"");
                    Toast.makeText(this, "You successfully deleted this film from favorites", Toast.LENGTH_SHORT).show();
                }
                else if(new ShaaredPreferences(this).load(original_title.getText().toString()).equals("")){
                    new ShaaredPreferences(this).save(original_title.getText().toString(),"true");
                    Toast.makeText(this, "You successfully added this film to favorites", Toast.LENGTH_SHORT).show();
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Log.d("OnBackPressed","OnBackPressed");
        startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));

    }
}
