package com.alain.cursos.mdcomponents.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.transition.TransitionManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.transition.MaterialArcMotion;
import com.google.android.material.transition.MaterialContainerTransform;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MotionFragment extends Fragment {

    public static final String TAG = "Motion";
    private static Component mInstance;

    Unbinder unbinder;
    @BindView(R.id.view_end)
    ConstraintLayout view_end;
    @BindView(R.id.view_start)
    FloatingActionButton view_start;
    @BindView(R.id.coordinatorMain)
    CoordinatorLayout container_main;

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_motion);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public MotionFragment() {
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
        View view = inflater.inflate(R.layout.fragment_motion, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_cancel, R.id.view_start})
    public void onMotionClicked(View view){
        MaterialContainerTransform transform = new MaterialContainerTransform();
        transform.setScrimColor(Color.TRANSPARENT);
        transform.setDuration(400L);

        switch (view.getId()){
            case R.id.btn_cancel:
                transform.setStartView(view_end);
                transform.setEndView(view_start);
                transform.addTarget(view_start);
                TransitionManager.beginDelayedTransition(container_main, transform);
                view_end.setVisibility(View.GONE);
                view_start.setVisibility(View.VISIBLE);
                break;
            case R.id.view_start:
                transform.setPathMotion(new MaterialArcMotion());
                transform.setStartView(view_start);
                transform.setEndView(view_end);
                transform.addTarget(view_end);
                TransitionManager.beginDelayedTransition(container_main, transform);
                view_start.setVisibility(View.GONE);
                view_end.setVisibility(View.VISIBLE);
                break;
        }
    }
}