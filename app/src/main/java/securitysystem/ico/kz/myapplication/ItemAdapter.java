package securitysystem.ico.kz.myapplication;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

class ItemAdapter extends PagedListAdapter<Results, ItemAdapter.ItemViewHolder> {

    private Context mCtx;

    ItemAdapter(Context mCtx) {
        super(DIFF_CALLBACK);
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_users, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Results item = getItem(position);

        if (item != null) {
            holder.textView.setText("Наименование: "+item.getOriginal_title());
            holder.textView4.setText("Дата релиза: "+item.getRelease_date());
            holder.textView5.setText("Средний голос: "+item.getVote_average());

        }else{
            Toast.makeText(mCtx, "Item is null", Toast.LENGTH_LONG).show();
        }
    }
    private static DiffUtil.ItemCallback<Results> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Results>() {
                @Override
                public boolean areItemsTheSame(Results results, Results t1) {
                    return results.getOriginal_title()==t1.getOriginal_title();
                }

                @Override
                public boolean areContentsTheSame( Results results, Results t1) {
                    return results.equals(t1);
                }

            };

    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView textView,textView4,textView5;
        ImageView imgAvatar;
        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewTitle);
            textView4=itemView.findViewById(R.id.date);
            textView5=itemView.findViewById(R.id.vote_avera);
            imgAvatar=itemView.findViewById(R.id.imgAvatar);
        }
    }
}
