package com.example.animation_app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

public class dialogue extends DialogFragment {
    textEditable textEditable;
    public void onAttach(Context context) {
        super.onAttach(context);
        textEditable = (textEditable) context;
    }
    public AlertDialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return builder.setTitle("ура").
                setView(R.layout.dialog).
                setMessage("ахахахахахахахахахахахахахахахахаха").
                setIcon(R.drawable.ic_launcher_foreground).
                setPositiveButton("YASS", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textEditable.editName("кык");
//                        EditText name = getView().findViewById(R.id.etName);
//                        textEditable.editName(name.getText());
                    }
                }).
                setNegativeButton("NAURRR", null).
                create();
    }
}
