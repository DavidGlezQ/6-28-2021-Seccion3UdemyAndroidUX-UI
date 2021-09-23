package com.alain.cursos.mdcomponents.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.google.android.material.button.MaterialButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class NavigationDrawerFragment extends Fragment {

    public static final String TAG = "Navigation Drawer";
    private static Component mInstance;
    Unbinder unbinder;
    @BindView(R.id.btnModal)
    MaterialButton btnModal;
    @BindView(R.id.btnBottom)
    MaterialButton btnBottom;

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_navigation_drawer);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btnModal, R.id.btnBottom})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.btnModal:
                ModalNavigationDrawerFragment modalNavigationDrawerFragment = new ModalNavigationDrawerFragment();
                modalNavigationDrawerFragment.show(getFragmentManager().beginTransaction(), ModalNavigationDrawerFragment.TAG);
                break;
            case R.id.btnBottom:
                break;

        }
    }
}