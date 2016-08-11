package com.example.vinoth.activitynavigator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity {


    private EditText etUsername;
    private EditText etPasswort;
    private SharedPreferences sharePref;
    public static String login_Username;
    public static String login_Password;

    public void signin(View view){
        SharedPreferences.Editor editor=sharePref.edit();
        String User_Name=sharePref.getString(ActivitySignUp.Name,"");
        String Password=sharePref.getString(ActivitySignUp.Password,"");
        String Key=sharePref.getString(ActivitySignUp.Key,"");
        boolean verify=sharePref.getBoolean(ActivitySignUp.verify,false);


    try {

         login_Username=etUsername.getText().toString();
         login_Password=etPasswort.getText().toString();
    }
    catch (NullPointerException e){
        Toast.makeText(this, "Enter the Username password", Toast.LENGTH_LONG).show();

    }
        if(!verify) {
            if ((login_Username.equals(User_Name) && (login_Password.equals(Key)))) {
                Intent intent1 = new Intent(getBaseContext(), MainAllActivity.class);
                finish();
                startActivity(intent1);
                Toast.makeText(this, "Wellcome this fist ", Toast.LENGTH_LONG).show();
                // wrirte file
                editor.putBoolean(ActivitySignUp.verify,true);
                editor.commit();

            } else {
                Toast.makeText(this, "Invaild username or Password", Toast.LENGTH_LONG).show();
            }
        }
        else {
            if ((login_Username.equals(User_Name) && (login_Password.equals(Password)))) {
                Intent intent1 = new Intent(getBaseContext(), MainAllActivity.class);
                finish();
                startActivity(intent1);
                Toast.makeText(this, "Wellcome ", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Invaild username", Toast.LENGTH_LONG).show();
            }
        }

        }



    public void signup(View view){


        Intent intent=new Intent(getBaseContext(),ActivitySignUp.class);
        startActivity(intent);

   }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPasswort=(EditText)findViewById(R.id.etPasswort);
        sharePref=getSharedPreferences(ActivitySignUp.file,MODE_PRIVATE);
        etUsername.setText(sharePref.getString(ActivitySignUp.Name,"No data fount "));


    }
}
