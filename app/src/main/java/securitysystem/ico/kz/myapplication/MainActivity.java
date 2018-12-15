package securitysystem.ico.kz.myapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{
    SearchView edSearch;
    private RecyclerView recyclerView;
    ItemViewModel itemViewModel;
    ItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edSearch = findViewById(R.id.edSearch);
        edSearch.setFocusable(false);
        edSearch.setOnQueryTextListener(this);
//        edSearch.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                replaceSubscription(s.toString());
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
        adapter = new ItemAdapter(this);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        replaceSubscription("");
    }
    @Override
    public boolean onQueryTextSubmit(String query) {
//        replaceSubscription(query);
        return false;
    }
    private void replaceSubscription(String query) {
        Log.d("Proverkaaa","proverkaa");
        ViewModelProvider.Factory factory = new ItemDataSourceFactory(MainActivity.this,query );
        itemViewModel = ViewModelProviders.of(this, factory).get(ItemViewModel.class);
        if(!query.equals("")){
            itemViewModel.replaceSubscription(this, query);
        }
        startListening();
    }
    private void startListening() {
        itemViewModel.itemPagedList.observe(this, new Observer<PagedList<Results>>() {
            @Override
            public void onChanged(@Nullable PagedList<Results> items) {
                adapter.submitList(items);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getBaseContext(), DetailedActivity.class);
                intent.putExtra("vote_count", itemViewModel.itemPagedList.getValue().get(position).getVote_count());
                intent.putExtra("id", itemViewModel.itemPagedList.getValue().get(position).getId());
                intent.putExtra("video", itemViewModel.itemPagedList.getValue().get(position).getVideo());
                intent.putExtra("vote_average", itemViewModel.itemPagedList.getValue().get(position).getVote_average());
                intent.putExtra("title", itemViewModel.itemPagedList.getValue().get(position).getTitle());
                intent.putExtra("popularity", itemViewModel.itemPagedList.getValue().get(position).getPopularity());
                intent.putExtra("poster_path", itemViewModel.itemPagedList.getValue().get(position).getPoster_path());
                intent.putExtra("original_language", itemViewModel.itemPagedList.getValue().get(position).getOriginal_language());
                intent.putExtra("original_title", itemViewModel.itemPagedList.getValue().get(position).getOriginal_title());
                intent.putExtra("backdrop_path", itemViewModel.itemPagedList.getValue().get(position).getBackdrop_path());
                intent.putExtra("adult", itemViewModel.itemPagedList.getValue().get(position).getAdult());
                intent.putExtra("overview", itemViewModel.itemPagedList.getValue().get(position).getOverview());
                intent.putExtra("release_date", itemViewModel.itemPagedList.getValue().get(position).getRelease_date());
                startActivity(intent);
            }
            @Override
            public void onLongItemClick(View view, int position) {
            }
        }));
    }
    @Override
    public boolean onQueryTextChange(String newText) {
        replaceSubscription(newText);
        return false;
    }
}
