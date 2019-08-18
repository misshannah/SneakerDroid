package com.olukoye.hannah.sneakerdroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.olukoye.hannah.sneakerdroid.data.RegApi;
import com.olukoye.hannah.sneakerdroid.data.UserPojo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRegistration extends AppCompatActivity {
    UserPojo userRegData;
    EditText f_name, l_name, fcm;
    Button regBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        regBtn = findViewById(R.id.regBtn);
        f_name = findViewById(R.id.f_name);
        l_name = findViewById(R.id.l_name);

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    registerUser();

            }
        });
    }
    private void registerUser() {
        final ProgressDialog progressDialog = new ProgressDialog(UserRegistration.this);
        progressDialog.setMessage("Please Wait as we register the user");
        progressDialog.show();

        (RegApi.getUser().registration(f_name.getText().toString().trim(),
                l_name.getText().toString().trim())).enqueue(new Callback<UserPojo>() {
            @Override
            public void onResponse(Call<UserPojo> call, Response<UserPojo> response) {
                userRegData = response.body();
                //Toast.makeText(getApplicationContext(), response.body().getParticipant_details().toString()), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }

            @Override
            public void onFailure(Call<UserPojo> call, Throwable t) {
                Log.d("response", t.getStackTrace().toString());
                progressDialog.dismiss();

            }
        });
    }
}
