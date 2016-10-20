package com.deity.bottombuttondemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity  implements View.OnClickListener,ViewPager.OnPageChangeListener {

    private TextView txt_chat_num;
    private TextView txt_contract_num;
    private TextView txt_discover_num;
    private TextView txt_me_num;
    private TextView txt_chat;
    private TextView txt_contract;
    private TextView txt_discover;
    private TextView txt_me;

    private ViewPager ly_content;

    private MyFragment fg1,fg2,fg3,fg4;
    private List<Fragment> mListFragment;
    private FragmentManager fManeger;
    private MainPageAdapter mainPageAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        fManeger=getSupportFragmentManager();
        bindViews();
        txt_chat.performClick();
    }

    private void bindViews(){

        txt_chat_num=(TextView)findViewById(R.id.tab_menu_chat_num) ;
        txt_contract_num=(TextView)findViewById(R.id.tab_menu_contact_num) ;
        txt_discover_num=(TextView)findViewById(R.id.tab_menu_discover_num) ;
        txt_me_num=(TextView)findViewById(R.id.tab_menu_me_num) ;
        txt_chat=(TextView)findViewById(R.id.tab_menu_chat);
        txt_contract=(TextView)findViewById(R.id.tab_menu_contact);
        txt_discover=(TextView)findViewById(R.id.tab_menu_discover);
        txt_me=(TextView)findViewById(R.id.tab_menu_me);
        ly_content= (ViewPager) findViewById(R.id.ly_content);
        mListFragment = new ArrayList<>();
        fg1= MyFragment.newInstance("第1个Fragment");
        fg2= MyFragment.newInstance("第2个Fragment");
        fg3= MyFragment.newInstance("第3个Fragment");
        fg4= MyFragment.newInstance("第4个Fragment");

        mListFragment.add(fg1);
        mListFragment.add(fg2);
        mListFragment.add(fg3);
        mListFragment.add(fg4);
        mainPageAdapter = new MainPageAdapter(getSupportFragmentManager());
        mainPageAdapter.setData(mListFragment);
        ly_content.setAdapter(mainPageAdapter);
        ly_content.addOnPageChangeListener(this);

        txt_chat.setOnClickListener(this);
        txt_contract.setOnClickListener(this);
        txt_discover.setOnClickListener(this);
        txt_me.setOnClickListener(this);
    }

    private void setSelected(){
        txt_chat.setSelected(false);
        txt_contract.setSelected(false);
        txt_discover.setSelected(false);
        txt_me.setSelected(false);
        txt_chat_num.setVisibility(View.INVISIBLE);
        txt_contract_num.setVisibility(View.INVISIBLE);
        txt_discover_num.setVisibility(View.INVISIBLE);
        txt_me_num.setVisibility(View.INVISIBLE);
    }
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg1!=null) fragmentTransaction.hide(fg1);
        if(fg2!=null) fragmentTransaction.hide(fg2);
        if(fg3!=null) fragmentTransaction.hide(fg3);
        if(fg4!=null) fragmentTransaction.hide(fg4);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tab_menu_chat:
                setSelected();
                txt_chat.setSelected(true);
//                txt_chat_num.setText("16");
//                txt_chat_num.setVisibility(View.VISIBLE);
//                fTransaction.show(fg1);
                ly_content.setCurrentItem(0);
                break;
            case R.id.tab_menu_contact:
                setSelected();
                txt_contract.setSelected(true);

//                txt_contract_num.setText("13");
//                txt_contract_num.setVisibility(View.VISIBLE);

                ly_content.setCurrentItem(1);
                break;
            case R.id.tab_menu_discover:
                setSelected();
                txt_discover.setSelected(true);

//                txt_discover_num.setText("11");
//                txt_discover_num.setVisibility(View.VISIBLE);

                ly_content.setCurrentItem(2);
                break;
            case R.id.tab_menu_me:
                setSelected();
                txt_me.setSelected(true);

                txt_me_num.setText("15");
                txt_me_num.setVisibility(View.VISIBLE);
                ly_content.setCurrentItem(3);
                break;
        }
    }

    public void initBottom(){
        txt_chat.setSelected(false);
        txt_contract.setSelected(false);
        txt_discover.setSelected(false);
        txt_me.setSelected(false);
    }

    /**
     * This method will be invoked when the current page is scrolled, either as part
     * of a programmatically initiated smooth scroll or a user initiated touch scroll.
     *
     * @param position             Position index of the first page currently being displayed.
     *                             Page position+1 will be visible if positionOffset is nonzero.
     * @param positionOffset       Value from [0, 1) indicating the offset from the page at position.
     * @param positionOffsetPixels Value in pixels indicating the offset from position.
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * This method will be invoked when a new page becomes selected. Animation is not
     * necessarily complete.
     *
     * @param position Position index of the new selected page.
     */
    @Override
    public void onPageSelected(int position) {

    }

    /**
     * Called when the scroll state changes. Useful for discovering when the user
     * begins dragging, when the pager is automatically settling to the current page,
     * or when it is fully stopped/idle.
     *
     * @param state The new scroll state.
     * @see ViewPager#SCROLL_STATE_IDLE
     * @see ViewPager#SCROLL_STATE_DRAGGING
     * @see ViewPager#SCROLL_STATE_SETTLING
     */
    @Override
    public void onPageScrollStateChanged(int state) {
        if (ViewPager.SCROLL_STATE_SETTLING==state){
            System.out.println(">>>>>>>>>>>"+ly_content.getCurrentItem());
            initBottom();
            switch (ly_content.getCurrentItem()){
                case 0:
                    txt_chat.setSelected(true);
                    break;
                case 1:
                    txt_contract.setSelected(true);
                    break;
                case 2:
                    txt_discover.setSelected(true);
                    break;
                case 3:
                    txt_me.setSelected(true);
                    break;
            }
        }
    }
}
