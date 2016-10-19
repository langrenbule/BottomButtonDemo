package com.deity.bottombuttondemo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ws1688 on 2016/7/8.
 */
public class MyFragment extends Fragment {

    private  String content;
    public static MyFragment newInstance(String pContent){
        MyFragment newFragment=new MyFragment();
        Bundle bundle=new Bundle();
        bundle.putString("content",pContent);

        newFragment.setArguments(bundle);
        return newFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            content = args.getString("content");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content,container,false);
        TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
        txt_content.setText(content);

//        switch (content) {
//            case "第一个Fragment":
//                TextView tab_menu_chat_num = (TextView) getActivity ().findViewById(R.id.tab_menu_chat_num);
//                tab_menu_chat_num.setText("11");
//                tab_menu_chat_num.setVisibility(View.VISIBLE);
//                break;
//            case "第二个Fragment":
//                TextView tab_menu_contact_num = (TextView) getActivity ().findViewById(R.id.tab_menu_contact_num);
//                tab_menu_contact_num.setText("12");
//                tab_menu_contact_num.setVisibility(View.VISIBLE);
//                break;
//            case "第三个Fragment":
//                TextView tab_menu_discover_num = (TextView) getActivity ().findViewById(R.id.tab_menu_discover_num);
//                tab_menu_discover_num.setText("13");
//                tab_menu_discover_num.setVisibility(View.VISIBLE);
//                break;
//            case "第四个Fragment":
//                TextView tab_menu_me_num = (TextView) getActivity ().findViewById(R.id.tab_menu_me_num);
//                tab_menu_me_num.setText("14");
//                tab_menu_me_num.setVisibility(View.VISIBLE);
//                break;
//            default:break;
  //      }

        return view;
    }
}
