package com.example.android.mymovieapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends ArrayAdapter {

    private List<String> imageUrl;
    private Context ctx;
    private LayoutInflater inflater;

    public ImageAdapter(Context context,List<String> images)
    {

        super(context, R.layout.image_grid);

        this.ctx = context;
        this.imageUrl=images;

        for (String i:images) {
            Log.v("LOG_TAG","result from adapter " + i);

        }
        inflater = LayoutInflater.from(context);
    }

    // Call this method whenever new data is to be added to existing list.
//    public void updateImageList(List<String> newImagelist) {
//
//        if(this.imageUrl != null){
//            this.imageUrl.addAll(newImagelist);
//        }else{
//            this.imageUrl = newImagelist;
//        }
//
//        notifyDataSetChanged();
//    }

    @Override
    public Object getItem(int position)
    {
      return null;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;

        Log.v("LOG","calling getview for picasso"+position);

        if (null == convertView) {
            convertView = inflater.inflate(R.layout.image_grid, parent, false);
            holder=new ViewHolder();
            holder.imageView=(ImageView)convertView.findViewById(R.id.movieImage);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
            }
        Picasso
                .with(ctx)
                .load(imageUrl.get(position))
                .fit()
                .into(holder.imageView);

        return convertView;
    }
    static class ViewHolder {
        ImageView imageView;
    }
}
