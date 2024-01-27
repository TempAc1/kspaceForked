package com.example.knowledgespaceapk.CV;



import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

import android.Manifest;
import android.app.Dialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;


import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.knowledgespaceapk.BuildConfig;
import com.example.knowledgespaceapk.R;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.xml.transform.stream.StreamResult;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;


public class CV3rdScF extends Fragment {
    private Gson gson = new Gson();
    private static final String baseUrl = "https://api.docugenerate.com/v1/document";
    private static final String tempResumeTemplateId = "FUKq4klVe42PJ09JYk48";
    private static final String accessKey = "6f5087c075319b17a982801468912d55";
    private final OkHttpClient okHttpClient =  new OkHttpClient.Builder()
                                        .connectTimeout(40,TimeUnit.SECONDS)
                                        .writeTimeout(40, TimeUnit.SECONDS)
                                        .readTimeout(40, TimeUnit.SECONDS)
                                        .build();

    private Bundle bundle;
    private CVPersonalDetails cvPersonalDetails;
    private String jsonUrl;
    private RelativeLayout relativeVCv3rdScF;
    private WebView webVCv3rdScF;
    private ScrollView scrollVCv3rdScF;
    private static final int PERMISSION_REQUEST_CODE = 123;
    private ProgressDialog progressDialog;

    private CharacterCountValidator characterCountValidator = new CharacterCountValidator();
    private Drawable drawable;

    private EditText per1CertAuthorityEditTvCv3rdSc,per1stCertNameEditTvCv3rdSc,per2ndCertAuthorityEditTvCv3rdSc,
            per2ndCertNameEditTvCv3rdSc,per3rdCertAuthorityEditTvCv3rdSc, per3rdCertNameEditTvCv3rdSc,
            per4CertAuthorityEditTvCv3rdSc,per4stCertNameEditTvCv3rdSc,per5thCertAuthorityEditTvCv3rdSc,
            per5thCertNameEditTvCv3rdSc;

    public CV3rdScF() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c_v3rd_sc, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        drawable = ContextCompat.getDrawable(getContext(),R.drawable.ic_baseline_error_outline_24);
        characterCountValidator.setErrorDrawable(drawable);

//        SpinKitView spinnerCv3rdScF = view.findViewById(R.id.spinnerCv3rdScF);
         per1CertAuthorityEditTvCv3rdSc = view.findViewById(R.id.per1CertAuthorityEditTvCv3rdSc);
         characterCountValidator.addEditText(per1CertAuthorityEditTvCv3rdSc,30);
         per1stCertNameEditTvCv3rdSc = view.findViewById(R.id.per1stCertNameEditTvCv3rdSc);
         characterCountValidator.addEditText(per1stCertNameEditTvCv3rdSc,30);
         per2ndCertAuthorityEditTvCv3rdSc = view.findViewById(R.id.per2ndCertAuthorityEditTvCv3rdSc);
         characterCountValidator.addEditText(per2ndCertAuthorityEditTvCv3rdSc,30);
         per2ndCertNameEditTvCv3rdSc = view.findViewById(R.id.per2ndCertNameEditTvCv3rdSc);
         characterCountValidator.addEditText(per2ndCertNameEditTvCv3rdSc,30);
         per3rdCertAuthorityEditTvCv3rdSc = view.findViewById(R.id.per3rdCertAuthorityEditTvCv3rdSc);
         characterCountValidator.addEditText(per3rdCertAuthorityEditTvCv3rdSc,30);
         per3rdCertNameEditTvCv3rdSc = view.findViewById(R.id.per3rdCertNameEditTvCv3rdSc);
         characterCountValidator.addEditText(per3rdCertNameEditTvCv3rdSc,30);
         per4CertAuthorityEditTvCv3rdSc = view.findViewById(R.id.per4CertAuthorityEditTvCv3rdSc);
         characterCountValidator.addEditText(per4CertAuthorityEditTvCv3rdSc,30);
         per4stCertNameEditTvCv3rdSc = view.findViewById(R.id.per4stCertNameEditTvCv3rdSc);
         characterCountValidator.addEditText(per4stCertNameEditTvCv3rdSc,30);
         per5thCertAuthorityEditTvCv3rdSc = view.findViewById(R.id.per5thCertAuthorityEditTvCv3rdSc);
         characterCountValidator.addEditText(per5thCertAuthorityEditTvCv3rdSc,30);
         per5thCertNameEditTvCv3rdSc = view.findViewById(R.id.per5thCertNameEditTvCv3rdSc);
         characterCountValidator.addEditText(per5thCertNameEditTvCv3rdSc,30);

        scrollVCv3rdScF = view.findViewById(R.id.scrollVCv3rdScF);
        relativeVCv3rdScF = view.findViewById(R.id.relativeVCv3rdScF);
        webVCv3rdScF = view.findViewById(R.id.webVCv3rdScF);
        WebSettings webSettings = webVCv3rdScF.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webVCv3rdScF.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return true;
            }
        });

        Button generateCVButtonCv3rdScF = view.findViewById(R.id.generateCVButtonCv3rdScF);
        generateCVButtonCv3rdScF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (characterCountValidator.validate()
//                    && validateDataFormat(per1CertAuthorityEditTvCv3rdSc.getText().toString().trim(),
//                        per1stCertNameEditTvCv3rdSc.getText().toString().trim(),
//                        per2ndCertAuthorityEditTvCv3rdSc.getText().toString().trim(),
//                        per2ndCertNameEditTvCv3rdSc.getText().toString().trim(),
//                        per3rdCertAuthorityEditTvCv3rdSc.getText().toString().trim(),
//                        per3rdCertNameEditTvCv3rdSc.getText().toString().trim(),
//                        per4CertAuthorityEditTvCv3rdSc.getText().toString().trim(),
//                        per4stCertNameEditTvCv3rdSc.getText().toString().trim(),
//                        per5thCertAuthorityEditTvCv3rdSc.getText().toString().trim(),
//                        per5thCertNameEditTvCv3rdSc.getText().toString().trim(),
//                        per1CertAuthorityEditTvCv3rdSc,per1stCertNameEditTvCv3rdSc,per2ndCertAuthorityEditTvCv3rdSc,
//                        per2ndCertNameEditTvCv3rdSc,per3rdCertAuthorityEditTvCv3rdSc,per3rdCertNameEditTvCv3rdSc,
//                        per4CertAuthorityEditTvCv3rdSc,per4stCertNameEditTvCv3rdSc,per5thCertAuthorityEditTvCv3rdSc,
//                        per5thCertNameEditTvCv3rdSc)
                ){

                    bundle = getArguments();
                    cvPersonalDetails = bundle.getParcelable("userDataSc2");

                    cvPersonalDetails.setPer1stCertNameEditTvCv3rdSc(per1CertAuthorityEditTvCv3rdSc.getText().toString().trim());
                    cvPersonalDetails.setPer1stCertNameEditTvCv3rdSc(per1stCertNameEditTvCv3rdSc.getText().toString().trim());
                    cvPersonalDetails.setPer2ndCertAuthorityEditTvCv3rdSc(per2ndCertAuthorityEditTvCv3rdSc.getText().toString().trim());
                    cvPersonalDetails.setPer2ndCertNameEditTvCv3rdSc(per2ndCertNameEditTvCv3rdSc.getText().toString().trim());
                    cvPersonalDetails.setPer3rdCertAuthorityEditTvCv3rdSc(per3rdCertAuthorityEditTvCv3rdSc.getText().toString().trim());
                    cvPersonalDetails.setPer3rdCertNameEditTvCv3rdSc(per3rdCertNameEditTvCv3rdSc.getText().toString().trim());
                    cvPersonalDetails.setPer4CertAuthorityEditTvCv3rdSc(per4CertAuthorityEditTvCv3rdSc.getText().toString().trim());
                    cvPersonalDetails.setPer4stCertNameEditTvCv3rdSc(per4stCertNameEditTvCv3rdSc.getText().toString().trim());
                    cvPersonalDetails.setPer5thCertAuthorityEditTvCv3rdSc(per5thCertAuthorityEditTvCv3rdSc.getText().toString().trim());
                    cvPersonalDetails.setPer5thCertNameEditTvCv3rdSc(per5thCertNameEditTvCv3rdSc.getText().toString().trim());

//                Toast.makeText(view.getContext(), "No Backend Yet!!!", Toast.LENGTH_SHORT).show();


//                Log.i("pName", (String) getArguments().getString("pName"));
//                Log.i("pHobbies 1", cvPersonalDetails.getPer1stHobbiesEditTvCvPerIntroSc());
//                Log.d("Name","User Name - " + cvPersonalDetails.getpNameEditTvCvMainScF());
//                Log.i("sumarry", cvPersonalDetails.getPerSummaryEditTvCvPerIntroSc());
//                Log.i("java object", cvPersonalDetails.getPer4CertAuthorityEditTvCv3rdSc());


                    // openDialog();


//                Log.i("GSON", cvDetailsJSON);

                    // Check for self storage read and write permission
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                            ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                        // Request permission
                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                PERMISSION_REQUEST_CODE);
                    } else {
                        // Permission already granted, perform necessary tasks
                        generateResume();
                    }


                }
            }
        });//OnClick

    }




    //Todo PDf par owner ka name dal do n necessary edittv ko sahi kro.

    private void generateResume() {

        try {

            // Convert the  java object to a JSON string directly
            String jsonObjectStr = gson.toJson(new CVPersonalDetails[]{cvPersonalDetails});
            Log.i("str containing array of json obj", jsonObjectStr);


            new Thread(new Runnable() {
                @Override
                public void run() {

                    //Build the request
                    RequestBody requestBody = new MultipartBody.Builder()
                            .setType(MultipartBody.FORM)
                            .addFormDataPart("template_id", tempResumeTemplateId)
                            .addFormDataPart("data", jsonObjectStr)
                            .addFormDataPart("file", "")
                            .addFormDataPart("sheet", "Sheet1")
                            .addFormDataPart("name", "resume")
                            .addFormDataPart("output_name", "resume_output")
                            .addFormDataPart("output_format", ".pdf")
                            .addFormDataPart("page_break", "false")
                            .build();

//                    // Log request body
//                    try {
//                        Buffer buffer = new Buffer();
//                        requestBody.writeTo(buffer);
//                        String requestBodyString = buffer.readUtf8();
//                        Log.d("Request Body", requestBodyString);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }

                    //Todo hardcode template selection hata do n resumeNAme auth se name nikl kar resume kr do

                    Request postRequest = new Request.Builder()
                            .url(baseUrl)
                            .post(requestBody)
                            .addHeader("accept","application/json")
                            .addHeader("Authorization",accessKey)
                            .build();

//                    Log.i("postReq", postRequest.toString());
//                    Log.i("postReq", postRequest.body().toString());

                    try {

                        Response postResponse = okHttpClient.newCall(postRequest).execute();
                        if(!postResponse.isSuccessful() && postResponse.body() == null){
//                            throw new IOException("Unexpected code " + postResponse);
                            Toast.makeText(getContext(), "Unexpected server response code", Toast.LENGTH_SHORT).show();
                        }

                        String responseBody = postResponse.body().string();
                        JSONObject responseJson = new JSONObject(responseBody);
                        if (responseJson.has("document_uri")) {
                            jsonUrl = responseJson.getString("document_uri");
                            // Use the url as needed
                            Log.i("url", jsonUrl);
                        }
                    } catch (Exception e) {
                        //Update Ui in main thread with response

                        Log.e("TAG", "An error occurred: " + e.getMessage());
                        e.printStackTrace();
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getContext(), "Network Error. Please try again later.", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }

                    //Update Ui in main thread with response
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
//                                    spinnerCv3rdScF.setVisibility(View.GONE);
                            Toast.makeText(getContext(), "On Ui", Toast.LENGTH_SHORT).show();
//                            relativeVCv3rdScF.setVisibility(View.VISIBLE);
//                            scrollVCv3rdScF.setVisibility(View.GONE);
//                            String docUrl = "https://docs.google.com/gview?embedded=true&url=" + jsonUrl;
//                            webVCv3rdScF.loadUrl(docUrl);
//                            displayPDF(jsonUrl);

                            DownloadPdfTask downloadTask = new DownloadPdfTask(getContext());
                            downloadTask.execute();

                        }
                    });
                }
            }).start();

        }catch (Exception e){
            Toast.makeText(getContext(), "Internal Data Error", Toast.LENGTH_SHORT).show();
        }

    }//GeneratePDf



    private class DownloadPdfTask extends AsyncTask<Void, Integer, File> {
        private ProgressDialog progressDialog;
        private Context context;

        public DownloadPdfTask(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(context);
            progressDialog.setMessage("Downloading PDF...");
            progressDialog.setCancelable(false);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setProgress(0);
            progressDialog.show();
        }

        @Override
        protected File doInBackground(Void... params) {
            try {
                String fileURL = jsonUrl;

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(fileURL)
                        .build();
                Response response = client.newCall(request).execute();

                InputStream inputStream = response.body().byteStream();

                File downloadFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                File outputFile = new File(downloadFolder, "resume.pdf");

                FileOutputStream outputStream = new FileOutputStream(outputFile);

                byte[] buffer = new byte[2048];
                int length;
                while ((length = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, length);
                }

                inputStream.close();
                outputStream.close();
                Log.i("file adr - ", "File downloaded successfully to " + outputFile.getAbsolutePath());

                return outputFile;
            } catch (Exception e) {
                Log.e("DownloadPdfTask", "Error downloading PDF", e);
                return null;
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressDialog.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(File file) {
            super.onPostExecute(file);
            progressDialog.dismiss();
            if (file != null) {
                // Show a toast indicating that the download was successful and the location of the saved file
                Toast.makeText(context, "PDF downloaded and saved to Downloads folder", Toast.LENGTH_SHORT).show();
            } else {
                // Show a toast indicating that the download failed
                Toast.makeText(context, "Failed to download PDF", Toast.LENGTH_SHORT).show();
            }
        }
    }//DownloadPdfTask Class

    //ValidateData Function:
    private boolean validateDataFormat(
            String certiAuthority1,String certiName1,String certiAuthority2, String certiName2,
            String certiAuthority3,String certiName3,String certiAuthority4,String certiName4,
            String certiAuthority5,String certiName5,EditText per1CertAuthorityEditTvCv3rdSc,
            EditText per1stCertNameEditTvCv3rdSc,EditText per2ndCertAuthorityEditTvCv3rdSc,
            EditText per2ndCertNameEditTvCv3rdSc,EditText per3rdCertAuthorityEditTvCv3rdSc,
            EditText per3rdCertNameEditTvCv3rdSc,EditText per4CertAuthorityEditTvCv3rdSc,
            EditText per4stCertNameEditTvCv3rdSc,EditText per5thCertAuthorityEditTvCv3rdSc,
            EditText per5thCertNameEditTvCv3rdSc){

        boolean isValid = true;

        String name = "^[a-zA-Z]+$";

        //validate null
        if(TextUtils.isEmpty(certiAuthority1) || TextUtils.isEmpty(certiName1) ||
                TextUtils.isEmpty(certiAuthority2) || TextUtils.isEmpty(certiName2)
            || TextUtils.isEmpty(certiAuthority3) || TextUtils.isEmpty(certiName3) || TextUtils.isEmpty(certiAuthority4)
                || TextUtils.isEmpty(certiName4) ||TextUtils.isEmpty(certiAuthority5)
                || TextUtils.isEmpty(certiName5)){
            Toast.makeText(getContext(), "All fields are important", Toast.LENGTH_SHORT).show();
            isValid = false;
        }else{
            //validate certi1 Name:
            if (!certiName1.matches(name)) {
                per1stCertNameEditTvCv3rdSc.setError("Invalid Format");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }

            //validate certi1 Authority:
            if (!certiAuthority1.matches(name)) {
                per1CertAuthorityEditTvCv3rdSc.setError("Invalid Format");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }

            //validate certi2 Name:
            if (!certiName2.matches(name)) {
                per2ndCertNameEditTvCv3rdSc.setError("Invalid Format");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }

            //validate certi2 Authority:
            if (!certiAuthority2.matches(name)) {
                per2ndCertAuthorityEditTvCv3rdSc.setError("Invalid Format");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }

            //validate certi3 Name:
            if (!certiName3.matches(name)) {
                per3rdCertNameEditTvCv3rdSc.setError("Invalid Format");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }

            //validate certi1 Name:
            if (!certiAuthority3.matches(name)) {
                per3rdCertAuthorityEditTvCv3rdSc.setError("Invalid Format");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }

            //validate certi4 Name:
            if (!certiName4.matches(name)) {
                per4stCertNameEditTvCv3rdSc.setError("Invalid Format");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }

            //validate certi4 Authority:
            if (!certiAuthority4.matches(name)) {
                per4CertAuthorityEditTvCv3rdSc.setError("Invalid Format");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }

            //validate certi5 Name:
            if (!certiName5.matches(name)) {
                per5thCertNameEditTvCv3rdSc.setError("Invalid Format");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }

            //validate certi5 Authority:
            if (!certiAuthority5.matches(name)) {
                per5thCertAuthorityEditTvCv3rdSc.setError("Invalid Format");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }
        }




        return isValid;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, perform necessary tasks
                generateResume();
            } else {
                // Permission denied, show a message or handle it gracefully
                Toast.makeText(getContext(), "Permission Required To Store Resume", Toast.LENGTH_SHORT).show();
            }
        }
    }
}