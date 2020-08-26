package com.example.learnandroid.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.example.learnandroid.R;
import com.example.learnandroid.models.Post;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder> {

    private List<Post> dataList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<Post> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.txtTitle.setText(dataList.get(position).getName());
        holder.txtBody.setText(dataList.get(position).getCreatedAt());
        Glide.with(holder.mView.getContext())
                .asBitmap()
                .load(dataList.get(position).getAvatar())
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .into(new BitmapImageViewTarget(holder.profileImage) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        //Play with bitmap
                        super.setResource(resource);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{

        public final View mView;
        TextView txtTitle,txtBody;
        ImageView profileImage;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mView = itemView;
            txtTitle = mView.findViewById(R.id.title);
            txtBody = mView.findViewById(R.id.description);
            profileImage = mView.findViewById(R.id.profileImage);
        }
    }
}
