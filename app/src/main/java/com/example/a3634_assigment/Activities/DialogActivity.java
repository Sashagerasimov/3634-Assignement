

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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a3634_assigment.Fragments.AchievementsFragment;
import com.example.a3634_assigment.Models.Images;
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
    private ImageView sticker;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_level_unlocked, container, false);

        mActionBack = view.findViewById(R.id.popup_back);
        level = view.findViewById(R.id.levelTextView);
        sticker = view.findViewById(R.id.stickerImageView);

        Bundle bundle = getArguments();

        //grabbing the sticker value to display when badge is clicked on
        if (bundle != null) {
            String stringValue = bundle.getString("key");
            int stickerValue = bundle.getInt("keySticker");
            level.setText(stringValue);
            sticker.setImageResource(Images.stickers[stickerValue]);
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


    //required onAttach method for badge dialog popup with try catch
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
