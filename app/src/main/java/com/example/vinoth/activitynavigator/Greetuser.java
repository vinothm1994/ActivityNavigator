package com.example.vinoth.activitynavigator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Greetuser extends AppCompatActivity {

    private EditText etfn;
    private  EditText etln;
    private TextView tvres;
    String fn,ln;
    public void greetUser(View view){
try {
    fn = etfn.getText().toString();
    ln = etln.getText().toString();
}
catch (Exception e){
    tvres.setText( "Enter Name");
}

    tvres.setText( "Wellcome "+fn+" "+ln);
    Toast.makeText(this,"Wellcome "+fn+" "+ln,Toast.LENGTH_LONG).show();


}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetuser);
        etfn =(EditText)findViewById(R.id.etFn);
        etln=(EditText)findViewById(R.id.etLn);
        tvres=(TextView)findViewById(R.id.tvGreetresult);


    }
}
