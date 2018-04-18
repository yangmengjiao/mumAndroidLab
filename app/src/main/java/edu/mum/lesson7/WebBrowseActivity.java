package edu.mum.lesson7;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.mum.R;

public class WebBrowseActivity extends AppCompatActivity implements TabListener {

    private static final int MY_SITE = 0 ;
    private static final int FUN_SITE = 1 ;
    private static final int STUDY_SITE = 2 ;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        recyclerView=findViewById(R.id.rv_web);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ActionBar actionBar=getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("My Site").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Fun Site").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Study Site").setTabListener(this));
        loadMYySiteData();
    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        switch (tab.getPosition()){
            case MY_SITE:
                loadMYySiteData();
                break;
            case FUN_SITE:
                loadFunData();
                break;
            case STUDY_SITE:
                loadStudyData();
                break;
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    private void loadMYySiteData(){
        WebInfo webInfo1 = new WebInfo("http://baidu.com",R.mipmap.baidu);
        WebInfo webInfo2 = new WebInfo("http://www.qq.com",R.mipmap.qq);
        WebInfo webInfo3 = new WebInfo("https://leetcode.com",R.mipmap.leetcode);
        WebInfo webInfo4 = new WebInfo("https://youtube.com",R.mipmap.youtube);
        WebInfo webInfo5 = new WebInfo("https://google.com",R.mipmap.google);
        List<WebInfo> webInfos = new ArrayList<>();
        webInfos.add(webInfo1);
        webInfos.add(webInfo2);
        webInfos.add(webInfo3);
        webInfos.add(webInfo4);
        webInfos.add(webInfo5);
        WebItemAdpter webItemAdpter = new WebItemAdpter(webInfos);
        recyclerView.setAdapter(webItemAdpter);
    }

    private void loadFunData(){

        WebInfo webInfo1 = new WebInfo("https://github.com",R.mipmap.github);
        WebInfo webInfo2 = new WebInfo("http://www.lintcode.com",R.mipmap.lintcode);
        WebInfo webInfo3 = new WebInfo("https://view.yahoo.com",R.mipmap.yahoo_screen);
        WebInfo webInfo4 = new WebInfo("https://youtube.com",R.mipmap.youtube);
        WebInfo webInfo5 = new WebInfo("https://youku.com",R.mipmap.youku);
        List<WebInfo> webInfos = new ArrayList<>();
        webInfos.add(webInfo1);
        webInfos.add(webInfo2);
        webInfos.add(webInfo3);
        webInfos.add(webInfo4);
        webInfos.add(webInfo5);
        WebItemAdpter webItemAdpter = new WebItemAdpter(webInfos);
        recyclerView.setAdapter(webItemAdpter);
    }

    private void loadStudyData(){
        WebInfo webInfo1 = new WebInfo("http://www.dailymotion.com/us",R.mipmap.dailymotion);
        WebInfo webInfo2 = new WebInfo("https://netflix.com",R.mipmap.netflix);
        WebInfo webInfo3 = new WebInfo("https://www.udemy.com",R.mipmap.udemy);
        WebInfo webInfo4 = new WebInfo("https://www.codecademy.com",R.mipmap.codecademy);
        WebInfo webInfo5 = new WebInfo("https://www.codeschool.com",R.mipmap.codeschool);

        List<WebInfo> webInfos = new ArrayList<>();
        webInfos.add(webInfo1);
        webInfos.add(webInfo2);
        webInfos.add(webInfo3);
        webInfos.add(webInfo4);
        webInfos.add(webInfo5);
        WebItemAdpter webItemAdpter = new WebItemAdpter(webInfos);
        recyclerView.setAdapter(webItemAdpter);
    }
}
