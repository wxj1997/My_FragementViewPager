package com.example.wxj.my_fragementviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.wxj.my_fragementviewpager.fragement.CircleFragment;
import com.example.wxj.my_fragementviewpager.fragement.FindFragment;
import com.example.wxj.my_fragementviewpager.fragement.MeFragment;
import com.example.wxj.my_fragementviewpager.CircleFragemrntChild.MessageFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar
        .OnTabSelectedListener {
    private BottomNavigationBar mBottomNavigationBar;
    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDate();
        showBottomNavigationBar();
        setDefaultFragement();
    }
        /*设置默认fragement*/
    private void setDefaultFragement() {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();//开启事务
        ft.replace(R.id.main_container,mFragments.get(0));
        ft.commit();//事物提交
    }

    /*展示底部导航*/
    private void showBottomNavigationBar() {
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.circle_select, "动态"))
                .addItem(new BottomNavigationItem(R.drawable.find_select, "发现"))
                .addItem(new BottomNavigationItem(R.drawable.message_select, "信息"))
                .addItem(new BottomNavigationItem(R.drawable.me_select, "我的"))
                .setMode(BottomNavigationBar.MODE_FIXED)
                .initialise();
        /*注册监听事件与fragement实现联动*/
        mBottomNavigationBar.setTabSelectedListener(this);

    }

    /*初始化数据添加fragement数组*/
    private void initDate() {
        mFragments = new ArrayList<>();
        mFragments.add(new CircleFragment());
        mFragments.add(new FindFragment());
        mFragments.add(new MessageFragment());
        mFragments.add(new MeFragment());
    }

    /*初始化视图获取控件对象*/
    private void initView() {
        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bnb);
    }

    /*重写接口BottomNavigationBar
        .OnTabSelectedListener中的onTabSelected方法*/
    @Override
    public void onTabSelected(int position) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();//开启事务
        ft.replace(R.id.main_container,mFragments.get(position));
        ft.commit();//事物提交
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
