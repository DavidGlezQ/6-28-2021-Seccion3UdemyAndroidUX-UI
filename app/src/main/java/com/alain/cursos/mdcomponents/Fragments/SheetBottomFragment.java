package com.alain.cursos.mdcomponents.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class SheetBottomFragment extends Fragment {

    public static final String TAG = "Sheet Bottom";
    private static Component mInstance;

    Unbinder unbinder;
    @BindView(R.id.btnStandard)
    MaterialButton btnStandard;
    @BindView(R.id.bottom_sheet)
    ConstraintLayout bottomSheet;
    @BindView(R.id.btnResize)
    ImageButton btnResize;


    private BottomSheetBehavior mBottomSheetBehavior;
    private boolean mIsExpanded;

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_sheets_bottom);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public SheetBottomFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sheet_bottom, container, false);
        unbinder = ButterKnife.bind(this, view);

        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        mBottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState){
                    case BottomSheetBehavior.STATE_EXPANDED:
                        mIsExpanded = true;
                        btnResize.setImageDrawable(ContextCompat.getDrawable(getActivity(),
                                R.drawable.ic__expand_more));
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        mIsExpanded = false;
                        btnResize.setImageDrawable(ContextCompat.getDrawable(getActivity(),
                                R.drawable.ic_expand_less));
                        break;
                }

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {}
        });

        btnStandard.setOnLongClickListener(view1 ->  {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
            return true;
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @OnClick({R.id.btnStandard, R.id.btnModal})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.btnModal:
                ModalBottomSheetFullScreenFragment fragment = new ModalBottomSheetFullScreenFragment();
                fragment.show(getFragmentManager().beginTransaction(), ModalBottomSheetFragment.TAG);
                break;
            case R.id.btnStandard:
                if (mBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_HIDDEN){
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                } else {
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                }
                break;

        }
    }

    @OnClick(R.id.btnResize)
    public void onResizedClicked(View view){
        if (mIsExpanded){
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }
}