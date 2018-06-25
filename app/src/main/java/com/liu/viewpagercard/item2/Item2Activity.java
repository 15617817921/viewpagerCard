package com.liu.viewpagercard.item2;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.liu.viewpagercard.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Item2Activity extends AppCompatActivity {

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.viewpager2)
    ViewPager viewpager2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*只需要在父容器和ViewPager中都添加上clipChildren属性，
        然后给ViewPager设置左右两个margin，使其不致于把整个屏幕占满*/
        setContentView(R.layout.activity_item2);
        ButterKnife.bind(this);
        init();
        init2();
    }



    private void init() {
        /*设置ViewPager中两页之间的距离*/
        viewpager.setPageMargin(20);
        /*j加上这句  中间正常显示，两边有点透明度  不加为正常显示*/
        viewpager.setPageTransformer(false, new AlphaTransformer());
        /*设置预加载的页数，默认情况下这个参数为1，
        也就是左右各预加载一页，但是我们这里要让左右各预加载两页*/
        viewpager.setOffscreenPageLimit(3);

        TypedArray pagers = getResources().obtainTypedArray(R.array.pagers);
        List<Drawable> list = new ArrayList<>();
        for (int i = 0; i < pagers.length(); i++) {
            list.add(pagers.getDrawable(i));
        }
        MyVpAdater adater = new MyVpAdater(this, list);
        viewpager.setAdapter(adater);
    }
    private void init2() {
        /*设置ViewPager中两页之间的距离  可以为负数*/
        viewpager2.setPageMargin(-40);
        /*j加上这句  中间缩放，两边正常显示  不加为正常显示*/
        viewpager2.setPageTransformer(false, new ScaleTransformer());
        /*设置预加载的页数，默认情况下这个参数为1，
        也就是左右各预加载一页，但是我们这里要让左右各预加载两页*/
        viewpager2.setOffscreenPageLimit(3);

        TypedArray pagers = getResources().obtainTypedArray(R.array.pagers);
        List<Drawable> list = new ArrayList<>();
        for (int i = 0; i < pagers.length(); i++) {
            list.add(pagers.getDrawable(i));
        }
        MyVpAdater adater = new MyVpAdater(this, list);
        viewpager2.setAdapter(adater);
    }
}
