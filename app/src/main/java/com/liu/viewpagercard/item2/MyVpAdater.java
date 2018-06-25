package com.liu.viewpagercard.item2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.liu.viewpagercard.R;

import java.util.List;

import butterknife.BindView;

public class MyVpAdater extends PagerAdapter {


    private List<Drawable> list;
    private Context context;

    public MyVpAdater(Context context, List<Drawable> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //自定义视图
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.viewpager, container, false);
        container.addView(view);
        ImageView image = (ImageView) view.findViewById(R.id.image);
        image.setImageDrawable(list.get(position));
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
