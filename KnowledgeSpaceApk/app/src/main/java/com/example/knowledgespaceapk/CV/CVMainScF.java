package com.example.knowledgespaceapk.CV;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.knowledgespaceapk.R;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;

public class CVMainScF extends Fragment implements View.OnClickListener{

    private EditText pNameEditTvCvMainScF,pAddressEditTvCvMainScF,
            pEmailEditTvCVMainScF,pLinkedInLinkEditTvCVMainScF,pPhoneEditTvCVMainScF;
    private Button nextPerDetailsPageButtonCVMainScF;
    private ImageView pImgVCvMainScF;
    CVPersonalDetails cvPersonalDetails = new CVPersonalDetails();

    private CharacterCountValidator characterCountValidator = new CharacterCountValidator();
    private Drawable drawable;
    public CVMainScF() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c_v_main_sc, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);

        drawable = ContextCompat.getDrawable(getContext(),R.drawable.ic_baseline_error_outline_24);
        characterCountValidator.setErrorDrawable(drawable);

        pNameEditTvCvMainScF = view.findViewById(R.id.pNameEditTvCvMainScF);
        characterCountValidator.addEditText(pNameEditTvCvMainScF,22);
        pNameEditTvCvMainScF.setOnClickListener(this);
        pAddressEditTvCvMainScF = view.findViewById(R.id.pAddressEditTvCvMainScF);
        characterCountValidator.addEditText(pAddressEditTvCvMainScF,80);
        pAddressEditTvCvMainScF.setOnClickListener(this);
        pEmailEditTvCVMainScF = view.findViewById(R.id.pEmailEditTvCVMainScF);
        characterCountValidator.addEditText(pEmailEditTvCVMainScF,81);
        pEmailEditTvCVMainScF.setOnClickListener(this);
        pPhoneEditTvCVMainScF = view.findViewById(R.id.pPhoneEditTvCVMainScF);
        characterCountValidator.addEditText(pPhoneEditTvCVMainScF,10);
        pPhoneEditTvCVMainScF.setOnClickListener(this);
        pImgVCvMainScF = view.findViewById(R.id.pImgVCvMainScF);
        pImgVCvMainScF.setOnClickListener(this);
        pLinkedInLinkEditTvCVMainScF = view.findViewById(R.id.pLinkedInLinkEditTvCVMainScF);
        pLinkedInLinkEditTvCVMainScF.setOnClickListener(this);
        nextPerDetailsPageButtonCVMainScF = view.findViewById(R.id.nextPerDetailsPageButtonCVMainScF);
        nextPerDetailsPageButtonCVMainScF.setOnClickListener(this);

        nextPerDetailsPageButtonCVMainScF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validate all EditText views
               if( characterCountValidator.validate()
//                     && validateUserData(pNameEditTvCvMainScF.getText().toString().trim(),
//                               pEmailEditTvCVMainScF.getText().toString().trim(),pAddressEditTvCvMainScF.getText().toString().trim()
//                               ,pPhoneEditTvCVMainScF.getText().toString().trim(),pLinkedInLinkEditTvCVMainScF.getText().toString().trim()
//                               ,pNameEditTvCvMainScF,pEmailEditTvCVMainScF,pPhoneEditTvCVMainScF,pLinkedInLinkEditTvCVMainScF)
                               ) {


                   //Getting Data from editTv and validate further:
                       cvPersonalDetails.setpNameEditTvCvMainScF(pNameEditTvCvMainScF.getText().toString().trim());
                       cvPersonalDetails.setpEmailEditTvCVMainScF(pEmailEditTvCVMainScF.getText().toString().trim());
                       cvPersonalDetails.setpAddressEditTvCvMainScF(pAddressEditTvCvMainScF.getText().toString().trim());
                       cvPersonalDetails.setpLinkedInLinkEditTvCVMainScF(pLinkedInLinkEditTvCVMainScF.getText().toString().trim());
                       cvPersonalDetails.setpPhoneEditTvCVMainScF(Long.parseLong(pPhoneEditTvCVMainScF.getText().toString().trim()));

                        Log.i("userData", cvPersonalDetails.getpNameEditTvCvMainScF());


                       Bundle b = new Bundle();
                       b.putParcelable("userDataSc1", cvPersonalDetails);

                       navController.navigate(R.id.action_CVMainScF_to_CVPerIntroScF, b);

               }
            }//End onClick
        });

    }//End OnCreate

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pImgVCvMainScF:
                int PICKFILE_RESULT_CODE=1;
                Intent acessFilesIntent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                acessFilesIntent.setType("*/*");
                startActivityForResult(acessFilesIntent,PICKFILE_RESULT_CODE);
                break;
        }
    }

    //TODO sahi karna hai image on activity wale if condition ko + edittext ka input null n all sahi kro eg Number time pr

    private boolean validateUserData(String name, String email, String address, String phoneNumber, String linkedInUrl, EditText nameEditText, EditText emailEditText,EditText phoneNumberEditText, EditText linkedInEditText) {
        boolean isValid = true;
        final String NAME_REGEX = "^[\\p{L} .'-]+$";
            final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
            final String LINKEDIN_REGEX = "^https://www.linkedin.com/[A-Za-z0-9-]+$";
            // Check for null inputs
            if (TextUtils.isEmpty(name)  || TextUtils.isEmpty(email)  || TextUtils.isEmpty(address)
                    || TextUtils.isEmpty(phoneNumber)  || TextUtils.isEmpty(linkedInUrl) ) {
                Toast.makeText(getContext(), "All fields are required", Toast.LENGTH_SHORT).show();
                isValid = false;
            }else{

                // Validate name
                if (!name.matches(NAME_REGEX)) {
                    nameEditText.setError("Invalid name format");
                    isValid = false;
                }

                // Validate email
                if (!email.matches(EMAIL_REGEX)) {
                    emailEditText.setError("Invalid email format");
                    characterCountValidator.setErrorDrawable(drawable);
                    isValid = false;
                }

                // Validate phone number
                if (!phoneNumber.matches("\\d{10}")) {
                    phoneNumberEditText.setError("Invalid phone number format");
                    characterCountValidator.setErrorDrawable(drawable);
                    isValid = false;
                }

                // Validate LinkedIn URL
                if (!linkedInUrl.matches(LINKEDIN_REGEX)) {
                    linkedInEditText.setError("Invalid LinkedIn URL format");
                    characterCountValidator.setErrorDrawable(drawable);
                    isValid = false;
                }
            }

            return isValid;
        }



    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK && data != null && data.getData() != null){
                    Uri uri = data.getData();
                    pImgVCvMainScF.setImageURI(uri);

                    String[] filePathColumn = { MediaStore.Images.Media.DATA };
                    Cursor cursor = getActivity().getContentResolver().query(uri, filePathColumn,
                            null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String imagePath = cursor.getString(columnIndex);
                    cursor.close();

                    // Encode image to base64 and compress it
                    String base64Image = encodeImage(imagePath);
                    cvPersonalDetails.setpImgVCvMainScF(base64Image);


                    // Log the encoded image for debugging
                    Log.i("Base64 Image", base64Image);
//                    Log.i("imagepath", imagePath);
//                    Log.i("pImg patth----->", cvPersonalDetails.getpImgVCvMainScF());
                }
        }
    }//End onActivity Result

    private String encodeImage(String imagePath){
        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String encodedImage = Base64.encodeToString(byteArray, Base64.DEFAULT);
        return encodedImage;
    }


}//End Main