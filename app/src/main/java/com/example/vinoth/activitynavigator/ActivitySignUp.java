package com.example.vinoth.activitynavigator;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vinoth.activitynavigator.ultipro.AgeCalculator;
import com.example.vinoth.activitynavigator.ultipro.SendMail;

public class ActivitySignUp extends AppCompatActivity {
    private static String sname;
    private static String spassword;
    private static String semail;
    private static String sdob;
    private static boolean staus;
    public static final String file="mydata";
    private EditText etname1;
    private EditText etPassword;
    private EditText etemailId;
    private EditText etdob;
    private EditText etConfirmPassword;
    public static int age;

    private SharedPreferences sharePref;

    //shargede data:
    public static String Name="User_Name";
    public static String Password="Password";
    public static String Email="Email";
    public static String Dob="Dob";
    public static String Key="Key";
    public static  String verify="verify";
    private String confiormPassword;


    public void callsign(View view) {

        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

        try {
             sname = etname1.getText().toString();
             spassword = etPassword.getText().toString();
             confiormPassword=etConfirmPassword.getText().toString();
             semail = etemailId.getText().toString();
             sdob = etdob.getText().toString();

        }catch (NullPointerException e){
            e.printStackTrace();
        }
        int i=12345+(int)(Math.random()*99999);

        String Code=Integer.toString(i);

        SharedPreferences.Editor editor=sharePref.edit();

        editor.putString(Name,sname);
        editor.commit();
        editor.putString(Password,spassword);
        editor.commit();
        editor.putString(Email,semail);
        editor.commit();
        editor.putString(Dob,sdob);
        editor.commit();
        editor.putString(Key,Code);
        editor.commit();
        editor.putBoolean(verify,false);
        editor.commit();
        String sub="Your email verification code ";
        String body="account created successful verification Code is:"+Code+"Username:"+sname+"Password"+confiormPassword;

        try {
            age=AgeCalculator.AgeCalc(sdob);
        }
        catch (Exception e){
            e.printStackTrace();
        }


        if (semail.matches(EMAIL_REGEX)){
            if (spassword.equals(confiormPassword)){
                if (age>18){
                    try {
                        Toast.makeText(this,"otp sending",Toast.LENGTH_LONG).show();
                        SendMail sm = new SendMail(this, semail, sub, body);
                        sm.execute();
                    }
                    catch (Exception e){
                        Toast.makeText(this,"check internet connection",Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }
                else {
                    Toast.makeText(this,"your age is less than 18 ",Toast.LENGTH_LONG).show();
                }
            }
            else{
                Toast.makeText(this,"Password not march",Toast.LENGTH_LONG).show();
            }

        }
        else {
            Toast.makeText(this,"Email is in valid",Toast.LENGTH_LONG).show();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etname1=(EditText)findViewById(R.id.etEname1);
         etPassword=(EditText)findViewById(R.id.etEpass1);
         etConfirmPassword=(EditText)findViewById(R.id.etEpass2);
         etemailId=(EditText)findViewById(R.id.etEmailid1);
         etdob=(EditText)findViewById(R.id.etDOB1);
         sharePref=getSharedPreferences(file,MODE_PRIVATE);


    }
}
