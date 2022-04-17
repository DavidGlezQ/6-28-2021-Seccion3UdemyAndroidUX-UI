package com.alain.cursos.mdcomponents.utils;

/* *
 * Project: MD Components from com.alain.cursos.mdcomponents.utils
 * Created by Alain Nicolás Tello on 13/09/2019 at 06:03 PM
 * All rights reserved 2019.
 * Course Material Design and Theming for Android
 * More info: https://www.udemy.com/especialidad-en-firebase-para-android-con-mvp-profesional/
 */

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.alain.cursos.mdcomponents.ButtonFragment;
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

public class CommonUtils {

    public static void setFragment(AppCompatActivity activity, String nameFragment, int contentRes){
        Fragment fragment = getFragmentById(nameFragment);
        activity.getSupportFragmentManager().beginTransaction()
                .add(contentRes, fragment)
                .commit();
    }

    private static Fragment getFragmentById(String nameFragment) {
        Fragment fragment = null;

        switch (nameFragment){
            //SCROLL
            case ButtonFragment.TAG:
                fragment = new ButtonFragment();
                break;
            case TextFieldFragment.TAG:
                fragment = new TextFieldFragment();
                break;
            case CheckBoxFragment.TAG:
                fragment = new CheckBoxFragment();
                break;
            case CardFragment.TAG:
                fragment = new CardFragment();
                break;

            //STATIC
            case BottomNavigationBarFragment.TAG:
                fragment = new BottomNavigationBarFragment();
                break;
            case SnackBarFragment.TAG:
                fragment = new SnackBarFragment();
                break;
            case FloatingActionButtonFragment.TAG:
                fragment = new FloatingActionButtonFragment();
                break;
            case MenuFragment.TAG:
                fragment = new MenuFragment();
                break;
            case AlertDialogFragment.TAG:
                fragment = new AlertDialogFragment();
                break;
            case AppBarFragment.TAG:
                fragment = new AppBarFragment();
                break;
            case PickerFragment.TAG:
                fragment = new PickerFragment();
                break;
            case NavigationDrawerFragment.TAG:
                fragment = new NavigationDrawerFragment();
                break;
            case MotionFragment.TAG:
                fragment = new MotionFragment();
                break;
            case SheetBottomFragment.TAG:
                fragment = new SheetBottomFragment();
                break;

        }
        return fragment;
    }
}
