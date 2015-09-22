package com.ikukusev.commonslibsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.ikukusev.commonslib.notification.ToastUtil;
import com.ikukusev.commonslib.util.ViewUtils;
import com.ikukusev.commonslibsample.models.TestObject;
import com.ikukusev.commonslibsample.util.preferences.PreferenceUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toastUtilButton)
    Button toastUtilButton;
    @Bind(R.id.nameEdit)
    EditText nameEdit;
    @Bind(R.id.setNameButton)
    Button setNameButton;
    @Bind(R.id.objectName)
    EditText objectName;
    @Bind(R.id.objectLastName)
    EditText objectLastName;
    @Bind(R.id.setObjectButton)
    Button setObjectButton;
    private TestObject testObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        nameEdit.setText(PreferenceUtil.namePreference().get());
        testObject = PreferenceUtil.testObject().get();
        if (testObject != null) {
            objectName.setText(testObject.getName());
            objectLastName.setText(testObject.getLastName());
        }
        ViewUtils.applyAlpha(setObjectButton);
    }

    @OnClick(R.id.toastUtilButton)
    public void onToastUtilsClicked() {
        ToastUtil.showToast(R.string.hello_toast_utils);
    }

    @OnClick(R.id.setNameButton)
    public void onSetClicked() {
        PreferenceUtil.namePreference().set(nameEdit.getText().toString());
        ToastUtil.showToast(getString(R.string.name_is_set_to, PreferenceUtil.namePreference().get()));
    }

    @OnClick(R.id.setObjectButton)
    public void onSetObjectClicked() {
        testObject = new TestObject();
        testObject.setName(objectName.getText().toString());
        testObject.setLastName(objectLastName.getText().toString());
        PreferenceUtil.testObject().set(testObject);
        ///Test the saved values
        testObject = PreferenceUtil.testObject().get();
        ToastUtil.showToast(testObject.getName() + " " + testObject.getLastName());
    }


}
