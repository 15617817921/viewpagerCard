package com.liu.viewpagercard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.liu.viewpagercard.item1.Item1Activity;
import com.liu.viewpagercard.item2.Item2Activity;
import com.liu.viewpagercard.item3.Item3Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_up)
    TextView tvUp;
    @BindView(R.id.tv_moreviewoager)
    TextView tvMoreviewoager;
    @BindView(R.id.tv_PagerTransformer)
    TextView tvPagerTransformer;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_up, R.id.tv_moreviewoager, R.id.tv_PagerTransformer})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_up:
                intent = new Intent(this, Item1Activity.class);
                startActivity(intent);
                break;
                /*如何在一个页面上显示ViewPager的多个item，
                一共有两种解决方案，第一种就是我们上文所说的clipChildren属性，第二种是clipToPadding属性*/
            case R.id.tv_moreviewoager://1  透明度 clipChildren
                intent = new Intent(this, Item2Activity.class);
                startActivity(intent);
                break;
            case R.id.tv_PagerTransformer:////1  缩放 clipChildren
                intent = new Intent(this, Item3Activity.class);
                startActivity(intent);
                break;
        }
    }

}
