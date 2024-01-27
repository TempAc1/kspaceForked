package com.example.knowledgespaceapk.CV;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterCountValidator {
    private Map<EditText, Integer> mMaxAllowedCharactersMap = new HashMap<>();
    private Drawable mErrorDrawable;
    private Context context;

    public CharacterCountValidator() {
    }
    public void addEditText(EditText editText, int maxAllowedCharacters) {
        if (maxAllowedCharacters <= 0) {
            Toast.makeText(editText.getContext(), "Maximum allowed characters can't be less than zero", Toast.LENGTH_SHORT).show();
            throw new IllegalArgumentException("Maximum allowed characters cannot be negative.");
        }
        mMaxAllowedCharactersMap.put(editText, maxAllowedCharacters);
    }

    public void setErrorDrawable(Drawable errorDrawable) {
        mErrorDrawable = errorDrawable;
    }

    public boolean validate() {
        boolean isValid = true;
        for (Map.Entry<EditText, Integer> entry : mMaxAllowedCharactersMap.entrySet()) {
            EditText editText = entry.getKey();
            int maxAllowedCharacters = entry.getValue();

            int characterCount = editText.getText().toString().length();
            if (characterCount > maxAllowedCharacters) {
                isValid = false;
                editText.setError("Maximum allowed characters exceeded : "+maxAllowedCharacters);
                if (mErrorDrawable != null) {
                    mErrorDrawable.setBounds(0, 0, mErrorDrawable.getIntrinsicWidth(), mErrorDrawable.getIntrinsicHeight());
                    editText.setCompoundDrawables(null, null, mErrorDrawable, null);
                }
            } else {
                editText.setError(null);
                editText.setCompoundDrawables(null, null, null, null);
            }
        }
        return isValid;
    }
}