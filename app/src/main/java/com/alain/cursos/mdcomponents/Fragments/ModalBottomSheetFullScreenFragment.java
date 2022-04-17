package com.alain.cursos.mdcomponents.Fragments;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alain.cursos.mdcomponents.R;
import com.bumptech.glide.load.engine.Resource;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ModalBottomSheetFullScreenFragment extends BottomSheetDialogFragment {

    public static final String TAG = "Modal BottomSheet FullScreen";
    private BottomSheetBehavior mBottomSheetBehavior;
    Unbinder mUndinder;

    @BindView(R.id.btnCancel)
    ImageButton btnCancel;
    @BindView(R.id.appBar)
    AppBarLayout appBar;
    /*@BindView(R.id.llBar)
    LinearLayout llBar;*/
    @BindView(R.id.tvBar)
    TextView tvBar;
    @BindView(R.id.containerBar)
    FrameLayout containerBar;
    @BindView(R.id.vExtraSpace)
    View vExtraSpace;

    public ModalBottomSheetFullScreenFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = View.inflate(getContext(), R.layout.fragment_modal_bottom_sheet_full_screen, null);
        mUndinder = ButterKnife.bind(this, view);

        bottomSheetDialog.setContentView(view);

        vExtraSpace.setMinimumHeight((Resources.getSystem().getDisplayMetrics().heightPixels) / 4); //Division de pantalla, depende del activity
        mBottomSheetBehavior = BottomSheetBehavior.from((View)view.getParent());
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
        mBottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                int statusBarColor = ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark);

                if (BottomSheetBehavior.STATE_EXPANDED == newState){
                    appBar.setVisibility(View.VISIBLE);
                    tvBar.setVisibility(View.GONE);
                    //llBar.setVisibility(View.GONE);
                    statusBarColor = ContextCompat.getColor(getActivity(), R.color.colorAccent);
                } else if (BottomSheetBehavior.STATE_COLLAPSED == newState){
                    appBar.setVisibility(View.GONE);
                    tvBar.setVisibility(View.VISIBLE);
                    //llBar.setVisibility(View.VISIBLE);
                }
                getActivity().getWindow().setStatusBarColor(statusBarColor);
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        btnCancel.setOnClickListener(view1 -> mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN));

        return bottomSheetDialog;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUndinder.unbind();
    }
}