package com.ikukusev.commonslib.notification;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Ivan on 13-Jul-15.
 */
public class ProgressDialogFragment extends DialogFragment {

    private String message;

    @Override
    public Dialog getDialog() {
        ProgressDialog dialog = new ProgressDialog(getActivity());
        dialog.setMessage(message);
        return dialog;
    }

    public static void show(FragmentActivity fragmentActivity, String message) {
        ProgressDialogFragment progresDialogFragment = new ProgressDialogFragment();
        progresDialogFragment.message = message;
        progresDialogFragment.show(fragmentActivity.getSupportFragmentManager(), ProgressDialogFragment.class.getSimpleName());
    }

    public static void show(FragmentActivity activity, int messageResId) {
        show(activity, activity.getString(messageResId));
    }

    public static void dismiss(FragmentActivity fragmentActivity) {
        if (fragmentActivity.getSupportFragmentManager().findFragmentByTag(ProgressDialogFragment.class.getSimpleName()) != null) {
            ProgressDialogFragment progressDialogFragment = (ProgressDialogFragment) fragmentActivity.getSupportFragmentManager().findFragmentByTag(ProgressDialogFragment.class.getSimpleName());
            if (progressDialogFragment.isAdded()) {
                progressDialogFragment.dismiss();
            }
        }
    }
}
