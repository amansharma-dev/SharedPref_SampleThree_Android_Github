package com.example.sharedpref_samplethree_android_github;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class OnBoardImages_PagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private ImageView imageView;
    private int onBoardImages[] = {R.drawable.board_one, R.drawable.board_two,R.drawable.board_three};

    public OnBoardImages_PagerAdapter(Context context){
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return onBoardImages.length;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.onboard_images,container,false);
        imageView = view.findViewById(R.id.imageView_onBoard);
        imageView.setImageResource(onBoardImages[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
