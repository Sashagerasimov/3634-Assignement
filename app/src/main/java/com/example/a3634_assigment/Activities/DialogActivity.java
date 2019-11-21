

package com.example.a3634_assigment.Activities;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.a3634_assigment.Fragments.AchievementsFragment;
import com.example.a3634_assigment.R;


/*

Source: https://github.com/mitchtabian/DialogFragmentToFragment
Year: 2017
Author: Mitch Tabian
 */

public class DialogActivity extends AppCompatDialogFragment {

    private static final String TAG = "MyCustomDialog";

    public interface OnInputSelected{
        void sendInput(String input);
    }
    public OnInputSelected mOnInputSelected;

    //widgets

    private TextView mActionBack;
    private TextView level;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_level_unlocked, container, false);

        mActionBack = view.findViewById(R.id.popup_back);
        level = view.findViewById(R.id.levelTextView);

        Bundle bundle = getArguments();

        if (bundle != null) {
            String value2 = bundle.getString("key");
            level.setText(value2);
        }

        mActionBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: closing dialog");
                getDialog().dismiss();
            }
        });


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mOnInputSelected = (OnInputSelected) getTargetFragment();
        }catch (ClassCastException e){
            Log.e(TAG, "onAttach: ClassCastException : " + e.getMessage() );
        }
    }
}
