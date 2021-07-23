package com.alain.cursos.mdcomponents.Fragments;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.chip.Chip;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class CardFragment extends Fragment {

    public static final String TAG = "Card";
    private static Component mInstance;
    Unbinder unbinder;

    @BindView(R.id.imgCardLarge)
    AppCompatImageView imgCardLarge;
    @BindView(R.id.chipSecond)
    Chip chipSecond;
    @BindView(R.id.chipThird)
    Chip chipThird;


    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_cards_template);
        mInstance.setType(Constants.SCROLL);
        return mInstance;
    }

    public CardFragment() {
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
        View view = inflater.inflate(R.layout.fragment_card, container, false);
        unbinder = ButterKnife.bind(this, view);

        RequestOptions option = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL).centerCrop();
        Glide.with(this)
                .load("https://media-exp1.licdn.com/dms/image/C561BAQHnh3Tsc_uBKQ/company-background_10000/0/1561589281326?e=2159024400&v=beta&t=3cfGYoRfVwt5-vQJL_x4W7MrP_uwZB-PRzqqpfBr5Gg")
                .apply(option)
                .into(imgCardLarge);

        chipSecond.setOnCheckedChangeListener((CompoundButton, b) -> {
            if (b){
                Toast.makeText(getActivity(), "Check", Toast.LENGTH_SHORT).show();
            }
        });

        chipThird.setOnCloseIconClickListener(view1 -> chipThird.setVisibility(View.GONE));
    return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.chipFirst)
    public void onViewClicked(){
        Toast.makeText(getActivity(), "First Chip", Toast.LENGTH_SHORT).show();
    }
}