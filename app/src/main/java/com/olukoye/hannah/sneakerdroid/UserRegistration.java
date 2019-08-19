package com.olukoye.hannah.sneakerdroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.olukoye.hannah.sneakerdroid.data.RegApi;
import com.olukoye.hannah.sneakerdroid.data.UserPojo;
import com.olukoye.hannah.sneakerdroid.data.UserRegInterface;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRegistration extends AppCompatActivity {
    ProgressDialog progressDialog;
    EditText f_name, l_name, p_number;
    Button regBtn;
    String phone_number,app_v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        regBtn = findViewById(R.id.regBtn);
        f_name = findViewById(R.id.f_name);
        l_name = findViewById(R.id.l_name);
        p_number = findViewById(R.id.p_number);
        phone_number = PhoneNumberUtils.formatNumber(p_number.getText().toString());
        getAppVersion();

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    registerUser();

            }
        });
    }

    private void getAppVersion() {
        PackageManager packageManager = getApplicationContext().getPackageManager();
        String packageName = getApplicationContext().getPackageName();

        app_v = "not available";

        try {
            app_v = packageManager.getPackageInfo(packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void registerUser() {
        progressDialog = new ProgressDialog(UserRegistration.this);
        progressDialog.setMessage("Registering User...");
        progressDialog.show();


        UserRegInterface userRegInterface = RegApi.getUser().create(UserRegInterface.class);

        Map<String, Object> data = new HashMap<>();
        data.put("first_name", f_name.getText().toString());
        data.put("last_name", f_name.getText().toString());
        data.put("phone_number", phone_number);
        data.put("device_details", "");
        data.put("app_version", app_v);
        data.put("project_code", getResources().getString(R.string.project_code));



        Call<UserPojo> call = userRegInterface.registration(data);
        call.enqueue(new Callback<UserPojo>() {
            @Override
            public void onResponse(Call<UserPojo> call,
                                   Response<UserPojo> response) {
                progressDialog.dismiss();
                String responseBody = String.valueOf(response.body());

                Toast.makeText(UserRegistration.this, "Data uploaded!" + responseBody, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<UserPojo> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(UserRegistration.this, "Please try later!", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
