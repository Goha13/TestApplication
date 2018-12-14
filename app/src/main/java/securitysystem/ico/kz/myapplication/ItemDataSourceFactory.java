package securitysystem.ico.kz.myapplication;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.paging.DataSource;
import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PositionalDataSource;
import android.content.Context;
import android.support.annotation.NonNull;

public class ItemDataSourceFactory extends DataSource.Factory implements ViewModelProvider.Factory{
    private MutableLiveData<PositionalDataSource<Results>> itemLiveDataSource = new MutableLiveData<>();
    String org_id;
    String token;
    String date_from;
    String date_to;
    String s;
    Context context;
    public ItemDataSourceFactory(Context context){
        this.context=context;
    }

    @Override
    public DataSource<Integer,Results> create() {
        ItemDataSource itemDataSource = new ItemDataSource(context);
        itemLiveDataSource.postValue(itemDataSource);
        return itemDataSource;
    }
    public MutableLiveData<PositionalDataSource<Results>> getItemLiveDataSource() {
        return itemLiveDataSource;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ItemViewModel.class)) {
            return (T) new ItemViewModel(context);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
