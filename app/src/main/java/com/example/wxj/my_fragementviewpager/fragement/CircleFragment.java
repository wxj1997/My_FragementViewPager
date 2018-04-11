package com.example.wxj.my_fragementviewpager.fragement;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wxj.my_fragementviewpager.R;
import com.example.wxj.my_fragementviewpager.CircleFragemrntChild.ImageFragment;
import com.example.wxj.my_fragementviewpager.CircleFragemrntChild.NewsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CircleFragment extends Fragment {
    /*声明控件对象*/
    private View mView;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> mFragements;

    public CircleFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        /*将fragment_circle.xml文件转化为对象，并用mView接收*/
        mView = inflater.inflate(R.layout.fragment_circle, container, false);
        initView();
        initDate();
        showViewPager();
        return mView;
    }
/*展示ViewPager*/
    private void showViewPager() {
        mViewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setText("新闻");
        mTabLayout.getTabAt(1).setText("图片");
        mTabLayout.getTabAt(2).setText("视频");
    }

    /*添加fragement数组*/
    private void initDate() {
        mFragements=new ArrayList<>();
        mFragements.add(new NewsFragment());
        mFragements.add(new ImageFragment());
        mFragements.add(new VideoFragment());
    }

    /*初始化view获取控件对象*/
    private void initView() {
        /*因fragment_circle.xml文件对象在mView中故需加mView获取控件对象*/
        mTabLayout = (TabLayout) mView.findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) mView.findViewById(R.id.view_pager);
    }
private class MyAdapter extends FragmentPagerAdapter{

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragements.get(position);
    }

    @Override
    public int getCount() {
        return mFragements.size();
    }
}
}
