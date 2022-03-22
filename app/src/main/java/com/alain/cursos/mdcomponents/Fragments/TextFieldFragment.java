package com.alain.cursos.mdcomponents.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TextFieldFragment extends Fragment {

    public static final String TAG = "Text Fields";
    private static Component mInstance;
    Unbinder unbinder;

    @BindView(R.id.etPrice)
    TextInputEditText etPrice;
    @BindView(R.id.etCapitalLetter)
    TextInputEditText etCapitalLetter;
    @BindView(R.id.tilCapitalLetter)
    TextInputLayout tilCapitalLetter;

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_textfields_outlined_active);
        mInstance.setType(Constants.SCROLL);
        return mInstance;
    }

    public TextFieldFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text_field, container, false);
        ButterKnife.bind(this, view);

        tilCapitalLetter.setEndIconOnClickListener(v -> {
            if (etCapitalLetter.getText() != null){
                String contentStr = etCapitalLetter.getText().toString();
                etCapitalLetter.setText(contentStr.toUpperCase());
            }
        });

        etPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty() && Integer.valueOf(s.toString()) < 5){
                    etPrice.setError(getString(R.string.error_price_min));
                }
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}