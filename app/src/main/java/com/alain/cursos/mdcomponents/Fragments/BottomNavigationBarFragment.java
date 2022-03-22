package com.alain.cursos.mdcomponents.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BottomNavigationBarFragment extends Fragment {

    public static final String TAG = "Bottom Navigation";
    private static Component mInstance;
    Unbinder unbinder;
    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_bottomnav_mobile_portrait);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public BottomNavigationBarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_bottom_navigation_bar, container, false);
        ButterKnife.bind(this, view);

        bottomNavigationView.getOrCreateBadge(R.id.action_home);
        //bottomNavigationView.removeBadge(R.id.action_home);

        BadgeDrawable favoriteBadge = bottomNavigationView.getOrCreateBadge(R.id.action_favorite);
        favoriteBadge.setNumber(21);

        BadgeDrawable profileBadge = bottomNavigationView.getOrCreateBadge(R.id.action_menu);
        profileBadge.setNumber(1000);
        profileBadge.setMaxCharacterCount(3);
        profileBadge.setBackgroundColor(Color.CYAN);
        profileBadge.setBadgeTextColor(Color.MAGENTA);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}