package edu.tdt.appstudent2.fragments.dialog;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.textfield.TextInputEditText;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import edu.tdt.appstudent2.R;

public class InsertLinkDialogFragment extends AppCompatDialogFragment {

    private OnInsertClickListener listener;

    public static InsertLinkDialogFragment newInstance() {
        return new InsertLinkDialogFragment();
    }

    public void setOnInsertClickListener(@NonNull OnInsertClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        if (manager.findFragmentByTag(tag) == null) {
            super.show(manager, tag);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getDialog().getWindow() != null) {
            getDialog().getWindow().setSoftInputMode(
                    WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_insert_link_dialog, null);
        final TextInputEditText textToDisplayEditText = view.findViewById(R.id.text_to_display);
        final TextInputEditText linkToEditText = view.findViewById(R.id.link_to);

        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle(R.string.title_insert_link);
        dialog.setView(view);
        dialog.setPositiveButton(R.string.insert, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String title = textToDisplayEditText.getText().toString().trim();
                String url = linkToEditText.getText().toString().trim();

                if (listener != null) {
                    listener.onInsertClick(title, url);
                }
            }
        });
        dialog.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        return dialog.create();
    }

    public interface OnInsertClickListener {
        void onInsertClick(@NonNull String title, @NonNull String url);
    }
}