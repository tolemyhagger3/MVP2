package com.example.mvptwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainActivityView.view{

    private EditText email,password;
    private Button CheckerButton;

    MainActivityView.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        CheckerButton = (Button) findViewById(R.id.email_sign_in_button);

        presenter = new MainActivityPresenter(this);

        CheckerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //validate input
                String input_email = email.getText().toString();
                String input_password = password.getText().toString();

                if(TextUtils.isEmpty(input_email) || TextUtils.isEmpty(input_password)){
                    onFailure("Flieds Required");
                }else{
                    presenter.doLogin(input_email,input_password);
                }
            }
        });


    }

    @Override
    public void onSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
}