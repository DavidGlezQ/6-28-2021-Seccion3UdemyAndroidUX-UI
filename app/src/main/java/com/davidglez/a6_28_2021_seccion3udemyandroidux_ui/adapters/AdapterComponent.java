package com.davidglez.a6_28_2021_seccion3udemyandroidux_ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.davidglez.a6_28_2021_seccion3udemyandroidux_ui.R;
import com.davidglez.a6_28_2021_seccion3udemyandroidux_ui.utils.OnClickListener;
import com.davidglez.a6_28_2021_seccion3udemyandroidux_ui.utils.PojoComponent;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterComponent extends RecyclerView.Adapter<AdapterComponent.ViewHolder> {

    private List<PojoComponent> mPojoComponents;
    private OnClickListener mListener;

    public AdapterComponent(List<PojoComponent> mPojoComponents, OnClickListener mListener) {
        this.mPojoComponents = mPojoComponents;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_component,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterComponent.ViewHolder holder, int position) {
        PojoComponent pojoComponent = mPojoComponents.get(position);
        holder.setClickListener(mListener, pojoComponent);
        holder.tvName.setText(pojoComponent.getName());
        holder.imgPhoto.setImageResource(pojoComponent.getPhotoRes());
    }

    @Override
    public int getItemCount() {
        return mPojoComponents.size();
    }

    public void add(PojoComponent pojoComponent){
        if (!mPojoComponents.contains(pojoComponent)){
            mPojoComponents.add(pojoComponent);
            notifyItemInserted(mPojoComponents.size() -1);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.imagePhoto) AppCompatImageView imgPhoto;
        @BindView(R.id.tvName) TextView tvName;

        View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, itemView);
        }
        void setClickListener(OnClickListener listener, PojoComponent pojoComponent){
            view.setOnClickListener(view1 -> listener.onClick(pojoComponent));
        }
    }
}
