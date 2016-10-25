package com.example.kenguyen.codernews.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kenguyen.codernews.Model.Article;
import com.example.kenguyen.codernews.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by KeNguyen on 21/10/2016.
 */

public class ArticleArrayAdapter extends ArrayAdapter<Article> {

    public ArticleArrayAdapter(Context context, List<Article> articles) {
        super(context, android.R.layout.simple_list_item_1,articles);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the data from the position
        Article article = this.getItem(position);

        //check to see if existing view being reused
        //not using a recycle view -> inflate layout
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_article_result,parent,false);

        }

        //find the image view
        ImageView imageView = (ImageView) convertView.findViewById(R.id.ivImage);

        //clear out recycle image from Convertview from the last time
        imageView.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);

        tvTitle.setText(article.getHeadLine());

        //populate the thumbnail image
        //remote download the image in background
        String thumbnail = article.getThumbNail();

        if(!TextUtils.isEmpty(thumbnail)){
            Picasso.with(getContext()).load(thumbnail).into(imageView);
        }
        return convertView;
    }
}
