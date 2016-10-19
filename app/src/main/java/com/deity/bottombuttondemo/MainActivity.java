package com.deity.bottombuttondemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private TextView txt_chat_num;
    private TextView txt_contract_num;
    private TextView txt_discover_num;
    private TextView txt_me_num;
    private TextView txt_chat;
    private TextView txt_contract;
    private TextView txt_discover;
    private TextView txt_me;
    private FrameLayout ly_content;

    private MyFragment fg1,fg2,fg3,fg4;
    private FragmentManager fManeger;

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
        ly_content=(FrameLayout)findViewById(R.id.ly_content);

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
        FragmentTransaction fTransaction=fManeger.beginTransaction();
        hideAllFragment(fTransaction);
        switch (view.getId()){
            case R.id.tab_menu_chat:
                setSelected();
                txt_chat.setSelected(true);

                txt_chat_num.setText("16");
                txt_chat_num.setVisibility(View.VISIBLE);

                if(fg1==null){
                    fg1= MyFragment.newInstance("第一个Fragment");
                    fTransaction.add(R.id.ly_content,fg1);
                }else {
                    fTransaction.show(fg1);
                }
                break;
            case R.id.tab_menu_contact:
                setSelected();
                txt_contract.setSelected(true);

                txt_contract_num.setText("13");
                txt_contract_num.setVisibility(View.VISIBLE);

                if(fg2==null){
                    fg2= MyFragment.newInstance("第二个Fragment");
                    fTransaction.add(R.id.ly_content,fg2);
                }else {
                    fTransaction.show(fg2);
                }
                break;
            case R.id.tab_menu_discover:
                setSelected();
                txt_discover.setSelected(true);

                txt_discover_num.setText("11");
                txt_discover_num.setVisibility(View.VISIBLE);

                if(fg3==null){
                    fg3=MyFragment.newInstance("第三个Fragment");
                    fTransaction.add(R.id.ly_content,fg3);
                }else {
                    fTransaction.show(fg3);
                }
                break;
            case R.id.tab_menu_me:
                setSelected();
                txt_me.setSelected(true);

                txt_me_num.setText("15");
                txt_me_num.setVisibility(View.VISIBLE);

                if(fg4==null){
                    fg4= MyFragment.newInstance("第四个Fragment");
                    fTransaction.add(R.id.ly_content,fg4);
                }else {
                    fTransaction.show(fg4);
                }
                break;
        }
        fTransaction.commit();
    }
}
