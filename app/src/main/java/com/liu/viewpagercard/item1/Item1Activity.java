package com.liu.viewpagercard.item1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.liu.viewpagercard.R;

/**
 * 底部导航栏中中间一个是要比另外四个高的，
 * 这种效果很多人就会想到使用一个RelativeLayout布局来实现，
 * 其实不用那么麻烦，这种效果一个clipChildren属性就能实现
 */
public class Item1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*根节点添加clipChildren属性，然后在第三个ImageView上添加layout_gravity属性即可
        ，layout_gravity属性值为bottom表示控件大小超出后控件底部对齐。*/
        setContentView(R.layout.activity_item1);
    }
}
