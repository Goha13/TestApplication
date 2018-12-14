package securitysystem.ico.kz.myapplication;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

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
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(getResources().getString(R.string.kininf));

        vote_count.setText(String.valueOf(getIntent().getIntExtra("vote_count", 999999999)));
        idd.setText(String.valueOf(getIntent().getIntExtra("id",999999999)));
        video.setText(String.valueOf(getIntent().getBooleanExtra("video",false)));
        vote_average.setText(String.valueOf(getIntent().getDoubleExtra("vote_average",99999.999999)));
        title.setText(getIntent().getStringExtra("title")!=null?getIntent().getStringExtra("title"):"data available");
        popularity.setText(String.valueOf(getIntent().getDoubleExtra("popularity",9999.9999)));
        poster_path.setText(getIntent().getStringExtra("poster_path")!=null?getIntent().getStringExtra("poster_path"):"data available");
        original_language.setText(getIntent().getStringExtra("original_language")!=null?getIntent().getStringExtra("original_language"):"data available");
        original_title.setText(getIntent().getStringExtra("original_title")!=null?getIntent().getStringExtra("original_title"):"data available");
        backdrop_path.setText(getIntent().getStringExtra("backdrop_path")!=null?getIntent().getStringExtra("backdrop_path"):"data available");
        adult.setText(String.valueOf(getIntent().getBooleanExtra("adult",false)));
        overview.setText(getIntent().getStringExtra("overview")!=null?getIntent().getStringExtra("overview"):"data available");
        release_date.setText(getIntent().getStringExtra("release_date")!=null?getIntent().getStringExtra("release_date"):"data available");
    }
}
