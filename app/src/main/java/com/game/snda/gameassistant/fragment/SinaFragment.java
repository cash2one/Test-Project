package com.game.snda.gameassistant.fragment;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.game.snda.gameassistant.BaseFragment;
import com.game.snda.gameassistant.R;
import com.game.snda.gameassistant.Utils.NumberUtils;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;


/**
 * Created by zoubaolin on 15/10/9.
 */
@EFragment(R.layout.sina_frag_layout)
public class SinaFragment extends BaseFragment {

    private static final String TAG = SinaFragment.class.getSimpleName();

    @ViewById(R.id.textInputLayout_amount)
    TextInputLayout textInputLayoutAmount;
    @ViewById(R.id.textInputLayout_phone)
    TextInputLayout textInputLayoutPhone;
    @ViewById(R.id.toolBar)
    Toolbar toolBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate()...");
        super.onCreate(savedInstanceState);
    }

    private void initToolBar() {
        toolBar.setNavigationIcon(R.drawable.new_user_icon);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "ToolBar Navigation Click...");
            }
        });
        toolBar.setTitle(getString(R.string.app_name));
        toolBar.setSubtitle(getString(R.string.sub_title));
    }

    @AfterViews
    void init() {
        initToolBar();
        textInputLayoutAmount.getEditText().addTextChangedListener(new MyTextWatcher(textInputLayoutAmount, "isNumeric"));
        textInputLayoutPhone.getEditText().addTextChangedListener(new MyTextWatcher(textInputLayoutPhone, "isPhoneNo"));
    }

    public class MyTextWatcher implements TextWatcher {

        private TextInputLayout textInputLayout;
        private String method;

        public MyTextWatcher(TextInputLayout textInputLayout, String method) {
            this.textInputLayout = textInputLayout;
            this.method = method;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            EditText editText = textInputLayout.getEditText();
            if (method.equals("isNumeric")) {
                if (!NumberUtils.isNumeric(editText.getText().toString())) {
                    textInputLayout.setErrorEnabled(true);
                    textInputLayout.setError(getString(R.string.error_input_numericl));
                } else {
                    textInputLayout.setErrorEnabled(false);
                }
            } else if (method.equals("isPhoneNo")) {
                if (!NumberUtils.isPhoneNo(editText.getText().toString())) {
                    textInputLayout.setErrorEnabled(true);
                    textInputLayout.setError(getString(R.string.error_input_phone));
                } else {
                    textInputLayout.setErrorEnabled(false);
                }
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}
