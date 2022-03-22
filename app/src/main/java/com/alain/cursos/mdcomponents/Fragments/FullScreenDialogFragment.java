package com.alain.cursos.mdcomponents.Fragments;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import com.alain.cursos.mdcomponents.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class FullScreenDialogFragment extends DialogFragment {

    public static final String TAG = "FullScreenDialogFragment";

    /*@BindView(R.id.toolbarFull)
    Toolbar toolbar;*/

    Unbinder unbinder;

    public FullScreenDialogFragment() {
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
        View view = inflater.inflate(R.layout.fragment_full_screen_dialog, container, false);
        unbinder = ButterKnife.bind(this, view);

        /*toolbar.setNavigationIcon(R.drawable.ic_close);
        toolbar.setNavigationOnClickListener(view1 -> dismiss());
        toolbar.setTitle(R.string.dialog_full_screen);*/

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btnSave)
    public void onSaveClicked(){
        Toast.makeText(getActivity(), R.string.message_action_success, Toast.LENGTH_SHORT).show();
        dismiss();
    }
}