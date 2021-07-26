package com.alain.cursos.mdcomponents.Fragments;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.google.android.material.appbar.MaterialToolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class AppBarTopFragment extends DialogFragment {

    public static final String TAG = "AppBarTop";
    private static Component mInstance;
    Unbinder unbinder;

    @BindView(R.id.toolbarFull)
    MaterialToolbar toolbar;

    public AppBarTopFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_app_bar_top, container, false);
        unbinder = ButterKnife.bind(this, view);
        toolbar.setNavigationOnClickListener(view1 -> dismiss());
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}