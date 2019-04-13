package com.example.android.workout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.ArrayList;

public class Session extends Fragment {

    private ArrayList<Integer> sessionOneList;
    public static final String EMPTY = "empty";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_session, container, false);
    }

    public static Session newInstance(ArrayList<Integer> sOne){
        Session session = new Session();

        Bundle args = new Bundle();
        args.putIntegerArrayList("sessionOneList", sOne);
        session.setArguments(args);

        return session;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionOneList = getArguments().getIntegerArrayList("sessionOneList");

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        updateTextViews();

    }


    private void updateTextViews(){
        ExpandableTextView expTv1 = (ExpandableTextView) getView().findViewById(R.id.expand_text_view);
        expTv1.setText(getString(sessionOneList.get(0)));
        emptyCheck(R.id.special_instructions,1);
        emptyCheck(R.id.first_round,2);
        emptyCheck(R.id.first_instructions,3);
        emptyCheck(R.id.second_round,4);
        emptyCheck(R.id.second_instruction,5);
        emptyCheck(R.id.third_round,6);
        emptyCheck(R.id.third_instruction,7);
        emptyCheck(R.id.fourth_round,8);
        emptyCheck(R.id.fourth_instruction,9);
        emptyCheck(R.id.first_long_round,10);
        emptyCheck(R.id.first_darkinfo,11);
        emptyCheck(R.id.second_long_round,12);
        emptyCheck(R.id.second_long_round_darkinfo,13);
        emptyCheck(R.id.second_darkinfo,14);
        emptyCheck(R.id.third_darkinfo,15);
        emptyCheck(R.id.fourth_darkinfo,16);
    }

    private void emptyCheck(int viewId,int position){
        TextView v = (TextView) getView().findViewById(viewId);
        try{
            if(getString(sessionOneList.get(position)).equals(Session.EMPTY))
                v.setVisibility(View.GONE);
            else
                v.setVisibility(View.VISIBLE);
                v.setText(sessionOneList.get(position));
        }
        catch (Exception e){
            v.setVisibility(View.GONE);
        }
    }
}
