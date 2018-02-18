package com.example.android.azkyaresto;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by Azkya Telisha Harton on 2/18/2018.
 */

public class menu_adapter extends
        RecyclerView.Adapter<menu_adapter.WordViewHolder> {

    private final LinkedList<String> mFoodList;
    private final LinkedList<Integer> mPriceList;
    private final LinkedList<Integer> mPhotoList;
    private LayoutInflater mInflater;

    public menu_adapter(Context context, LinkedList<String> FoodList, LinkedList<Integer> priceList, LinkedList<Integer> photoList) {
        mInflater = LayoutInflater.from(context);
        this.mFoodList = FoodList;
        this.mPriceList = priceList;
        this.mPhotoList = photoList;
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.activity_menu_adapter, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        String mCurrent = mFoodList.get(position);
        Integer mCurrentPrice = mPriceList.get(position);
        Integer mCurrentPhoto = mPhotoList.get(position);
        holder.foodItemView.setText(mCurrent);
        holder.priceItemView.setText("Rp."+mCurrentPrice.toString());
        holder.photoItemView.setImageResource(mCurrentPhoto);
    }

    @Override
    public int getItemCount() {
        return mFoodList.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder {
        public final TextView foodItemView;
        public final TextView priceItemView;
        public final ImageView photoItemView;
        final menu_adapter mAdapter;

        public WordViewHolder(final View itemView, menu_adapter adapter) {
            super(itemView);
            foodItemView = (TextView) itemView.findViewById(R.id.tv_food);
            priceItemView = (TextView)itemView.findViewById(R.id.tv_price);
            photoItemView = (ImageView)itemView.findViewById(R.id.iv_photo);
            photoItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int mPosition = getLayoutPosition();
                    String food = mFoodList.get(mPosition);
                    Integer price = mPriceList.get(mPosition);
                    Integer photo = mPhotoList.get(mPosition);
                    Intent intent = new Intent(itemView.getContext(), review_menu.class);
                    intent.putExtra("food",food);
                    intent.putExtra("price",price);
                    intent.putExtra("photo",photo);
                    itemView.getContext().startActivity(intent);
                }
            });
            this.mAdapter = adapter;
        }
    }


}