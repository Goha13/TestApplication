package securitysystem.ico.kz.myapplication;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.arch.paging.PositionalDataSource;
import android.content.Context;

public class ItemViewModel extends ViewModel {
     LiveData<PagedList<Results>> itemPagedList;
    private LiveData<PositionalDataSource<Results>> liveDataSource;
    String s;
    Context context;
    private LiveData<PagedList<Results>> createFilteredUsers(String s){
        ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory(context,s);
        liveDataSource = itemDataSourceFactory.getItemLiveDataSource();
        itemPagedList= new LivePagedListBuilder(itemDataSourceFactory,
                new PagedList.Config.Builder() //
                        .setPageSize(20) //
                        .setPrefetchDistance(20) //
                        .setEnablePlaceholders(false) //
                        .build())
                .setInitialLoadKey(0)
                .build();
        return itemPagedList;
    }
    public ItemViewModel(Context context,String s){
        this.context=context;
        itemPagedList=createFilteredUsers(s);
    }
    public void replaceSubscription(LifecycleOwner lifecycleOwner, String s) {
        this.s = s;
        itemPagedList.removeObservers(lifecycleOwner);
        itemPagedList = createFilteredUsers(s);
    }
}