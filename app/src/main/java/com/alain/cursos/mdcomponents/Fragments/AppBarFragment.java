package com.alain.cursos.mdcomponents.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class AppBarFragment extends Fragment {

    public static final String TAG = "AppBar";
    private static Component mInstance;
    Unbinder unbinder;

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_appbar);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public AppBarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_app_bar, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btnAppBarBottom, R.id.btnAppBarTop})
    public void onViewClicked(View view){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        FullScreenDialogFragment dialogFragment = new FullScreenDialogFragment();
        switch (view.getId()){
            case R.id.btnAppBarTop:
                AppBarTopFragment appBarTopFragment = new AppBarTopFragment();
                appBarTopFragment.show(transaction, AppBarTopFragment.TAG);
                break;
            case R.id.btnAppBarBottom:
                AppBarBottomFragment appBarBottomFragment = new AppBarBottomFragment();
                appBarBottomFragment.show(transaction, FullScreenDialogFragment.TAG);
                break;
        }
    }
}