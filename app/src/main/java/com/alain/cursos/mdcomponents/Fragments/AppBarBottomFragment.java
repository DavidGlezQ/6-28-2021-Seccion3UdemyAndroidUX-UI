package com.alain.cursos.mdcomponents.Fragments;

import android.os.Bundle;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.BottomAppBarCutCornersTopEdge;
import com.alain.cursos.mdcomponents.utils.Component;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class AppBarBottomFragment extends DialogFragment {

    public static final String TAG = "AppBarBottom";
    Unbinder unbinder;

    private boolean isCentered;
    @BindView(R.id.bottom_app_bar)
    BottomAppBar bottom_app_bar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.container_main)
    CoordinatorLayout container_main;

    public AppBarBottomFragment() {
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
        View view = inflater.inflate(R.layout.fragment_app_bar_bottom, container, false);
        unbinder = ButterKnife.bind(this, view);

        bottom_app_bar.setOnMenuItemClickListener(item -> {
            int resMessage;
            switch (item.getItemId()){
                case R.id.action_favorite:
                    resMessage = R.string.menu_favorites;
                    break;
                case R.id.action_menu:
                    resMessage = R.string.menu_profile;
                    break;
                default:
                    resMessage = R.string.menu_start;
                    break;
            }
            Snackbar.make(container_main, resMessage, Snackbar.LENGTH_SHORT).setAnchorView(fab).show();
            return true;
        });

        bottom_app_bar.setNavigationOnClickListener(v -> {
            Snackbar.make(container_main, R.string.message_action_success, Snackbar.LENGTH_SHORT).setAnchorView(fab).show();
        });

        BottomAppBarCutCornersTopEdge topEdge = new BottomAppBarCutCornersTopEdge(
                bottom_app_bar.getFabCradleMargin(), bottom_app_bar.getFabCradleRoundedCornerRadius(),
                bottom_app_bar.getCradleVerticalOffset());

        MaterialShapeDrawable shapeDrawable = (MaterialShapeDrawable)bottom_app_bar.getBackground();
        shapeDrawable.setShapeAppearanceModel(
                shapeDrawable.getShapeAppearanceModel()
                .toBuilder()
                .setTopEdge(topEdge)
                .build());
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.fab)
    public void onViewClicked(){
        if (isCentered){
            bottom_app_bar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
        } else {
            bottom_app_bar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
        }
        isCentered = !isCentered;
    }
}