package securitysystem.ico.kz.myapplication;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.arch.paging.PositionalDataSource;
import android.content.Context;

public class ItemViewModel extends ViewModel {

//    public ItemViewModel(String org_id,String token,String date_from,String date_to,String s ) {
//        this.org_id=org_id;
//        this.token=token;
//        this.date_from=date_from;
//        this.date_to=date_to;
//        this.s=s;
//    }


     LiveData<PagedList<Results>> itemPagedList;
    private LiveData<PositionalDataSource<Results>> liveDataSource;
    String org_id;
    String token;
    String date_to;
    String date_from;
    String s;
    Context context;
    private LiveData<PagedList<Results>> createFilteredUsers(String s){
        ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory(context);
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

    public ItemViewModel(Context context){
        this.context=context;
        itemPagedList=createFilteredUsers(s);
    }
    public void replaceSubscription(LifecycleOwner lifecycleOwner, String s) {
        this.s = s;
        itemPagedList.removeObservers(lifecycleOwner);
        itemPagedList = createFilteredUsers(s);
    }


}