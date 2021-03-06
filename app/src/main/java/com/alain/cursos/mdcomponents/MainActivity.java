package com.alain.cursos.mdcomponents;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alain.cursos.mdcomponents.Fragments.AppBarFragment;
import com.alain.cursos.mdcomponents.Fragments.BottomNavigationBarFragment;
import com.alain.cursos.mdcomponents.Fragments.CardFragment;
import com.alain.cursos.mdcomponents.Fragments.CheckBoxFragment;
import com.alain.cursos.mdcomponents.Fragments.AlertDialogFragment;
import com.alain.cursos.mdcomponents.Fragments.FloatingActionButtonFragment;
import com.alain.cursos.mdcomponents.Fragments.MenuFragment;
import com.alain.cursos.mdcomponents.Fragments.MotionFragment;
import com.alain.cursos.mdcomponents.Fragments.NavigationDrawerFragment;
import com.alain.cursos.mdcomponents.Fragments.PickerFragment;
import com.alain.cursos.mdcomponents.Fragments.SheetBottomFragment;
import com.alain.cursos.mdcomponents.Fragments.SnackBarFragment;
import com.alain.cursos.mdcomponents.Fragments.TextFieldFragment;
import com.alain.cursos.mdcomponents.adapters.ComponentAdapter;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.alain.cursos.mdcomponents.utils.OnClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private ComponentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        configAdapter();
        configRecyclerView();
    }

    private void configAdapter() {
        mAdapter = new ComponentAdapter(new ArrayList<>(), this);
        mAdapter.add(ButtonFragment.getmInstance());
        mAdapter.add(BottomNavigationBarFragment.getmInstance());
        mAdapter.add(SnackBarFragment.getmInstance());
        mAdapter.add(TextFieldFragment.getmInstance());
        mAdapter.add(FloatingActionButtonFragment.getmInstance());
        mAdapter.add(CheckBoxFragment.getmInstance());
        mAdapter.add(CardFragment.getmInstance());
        mAdapter.add(MenuFragment.getmInstance());
        mAdapter.add(AlertDialogFragment.getmInstance());
        mAdapter.add(AppBarFragment.getmInstance());
        mAdapter.add(PickerFragment.getmInstance());
        mAdapter.add(NavigationDrawerFragment.getmInstance());
        mAdapter.add(MotionFragment.getmInstance());
        mAdapter.add(SheetBottomFragment.getmInstance());
        mAdapter.reverse();
    }

    private void configRecyclerView() {
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(Component component) {
        Intent intent;
        if (component.getType() == Constants.SCROLL){
            intent = new Intent(this, ScrollActivity.class);
        } else { //STATIC
            intent = new Intent(this, StaticActivity.class);
        }
        intent.putExtra(Constants.ARG_NAME, component.getName());
        startActivity(intent);
    }


}
