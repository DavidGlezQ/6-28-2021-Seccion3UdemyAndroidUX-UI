package com.alain.cursos.mdcomponents.Fragments;

import android.os.Bundle;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class PickerFragment extends Fragment {

    public static final String TAG = "Picker";
    private static Component mInstance;
    Unbinder unbinder;
    @BindView(R.id.container_main)
    LinearLayout container_main;

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_picker);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public PickerFragment() {
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
        View view = inflater.inflate(R.layout.fragment_picker, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btnDialog, R.id.btnFullScreen})
    public void onViewClicked(View view){
        MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText(R.string.picker_title);
        builder.setSelection(System.currentTimeMillis());
        switch (view.getId()){
            case R.id.btnDialog:
                builder.setTheme(R.style.ThemeOverlay_MaterialComponents_MaterialCalendar);
                break;
            case R.id.btnFullScreen:
                //builder.setTheme(R.style.ThemeOverlay_MaterialComponents_MaterialCalendar_Fullscreen);
                builder.setTheme(R.style.fullScreenPicker);
                break;
        }
        MaterialDatePicker<?> picker = builder.build();
        picker.addOnPositiveButtonClickListener(selection ->
                //Snackbar.make(container_main, R.string.message_action_success, Snackbar.LENGTH_SHORT).show());
                Snackbar.make(container_main, picker.getHeaderText(), Snackbar.LENGTH_SHORT).show());
        picker.addOnNegativeButtonClickListener(selection ->
                Snackbar.make(container_main, R.string.dialog_negative, Snackbar.LENGTH_SHORT).show());
        picker.addOnCancelListener(selection ->
                Snackbar.make(container_main, R.string.dialog_cancel, Snackbar.LENGTH_SHORT).show());
        picker.show(getFragmentManager(), picker.toString());
    }
}