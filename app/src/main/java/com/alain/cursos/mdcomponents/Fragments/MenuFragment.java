package com.alain.cursos.mdcomponents.Fragments;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MenuFragment extends Fragment {

    public static final String TAG = "Menu";
    private static Component mInstance;
    Unbinder unbinder;

    @BindView(R.id.btnMenuPopup)
    MaterialButton btnMenuPopup;
    @BindView(R.id.actvCourses)
    AutoCompleteTextView actvCourses;

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_menu);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public MenuFragment() {
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
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        unbinder = ButterKnife.bind(this, view);

        btnMenuPopup.setOnClickListener(view1 -> {
            PopupMenu popupMenu = new PopupMenu(getActivity(), view1);
            popupMenu.getMenuInflater().inflate(R.menu.menu_bottom_nav, popupMenu.getMenu());
            popupMenu.show();
        });

        String[] courses = new String[]{
                "Me quiero morir version 1.0.0 :D",
                "Tengo sueño jeje",
                "Esto tiene que ser un texto largo asi que eso intento hacer, tengo algo de hambre la verdad xc",
                "Programando ando :$"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.item_menu_dropdown, courses);
        actvCourses.setAdapter(adapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}