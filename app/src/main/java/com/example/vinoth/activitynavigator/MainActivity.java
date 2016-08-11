package com.example.vinoth.activitynavigator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.vinoth.activitynavigator.tasks.Bubblesort;
import com.example.vinoth.activitynavigator.tasks.Insertionsort;
import com.example.vinoth.activitynavigator.tasks.Mergesort;
import com.example.vinoth.activitynavigator.tasks.Quicksort;
import com.example.vinoth.activitynavigator.tasks.Selectionsort;
import com.example.vinoth.activitynavigator.ultipro.Calc;


public class MainActivity extends AppCompatActivity {
    private EditText Arraysize;
    private TextView tvBubblesort;
    private TextView tvSelectionsort;
    private TextView tvinsertion;
    private TextView tvQuickssort;
    private TextView tvMergesort;
    private TextView tvStatus;



    public  int size;
    public  int[] array;

    public static long start, stop;
    public void GenraArry(View view) {

        try {
            size = Integer.parseInt(Arraysize.getText().toString());
               array = new int[size];
        } catch (Exception e) {
            tvStatus.setText("Enter the array size");
        }

        RadioGroup rbcaseGroup = (RadioGroup) findViewById(R.id.rbgComp1);

        switch (rbcaseGroup.getCheckedRadioButtonId()) {

            case R.id.rbBest:
                // Toast.makeText(this,"best",Toast.LENGTH_SHORT).show();
                array = Calc.naturalNumer(size);
                break;

            case R.id.rbAvg:
                //Toast.makeText(this,"avfg",Toast.LENGTH_SHORT).show();
                array = Calc.randomNumber(size);
                break;

            case R.id.rbWorst:
                //Toast.makeText(this,"wors",Toast.LENGTH_SHORT).show();
                array = Calc.naturalNumer(size);
                array = Calc.reverseNumber(array);
                break;

        }
        if (size == 0) {
            tvStatus.setText("Enter the array size");
        } else {
            Log.i("size", String.valueOf(array.length));

            tvStatus.setText("Array " + size + " Generated");
        }
    }
    //algo
    public void doAlgori(View view) {
        switch (view.getId()) {
            case R.id.btnBubble:
                bubblesort();
                break;
            case R.id.btnSelectin:
                selectionsort();
                break;
            case R.id.btnInsertion:
                insertion();
                break;
            case R.id.btnMerge:
                MergeSort();
                break;
            case R.id.btnQuick:
                QuickSort();
                break;
            case R.id.btnBeanchall:
                tvStatus.setText("Loading.....");
                tvBubblesort.setText("");
                tvinsertion.setText("");
                tvMergesort.setText("");
                tvSelectionsort.setText("");
                tvQuickssort.setText("");
                bubblesort();
                selectionsort();
                insertion();
                MergeSort();
                QuickSort();

                break;

        }
    }

    public Integer[] convert(){


        Integer[] s1=new Integer[size];

       for(int i=0;i<array.length;i++){

           s1[i]=array[i];
       }
        Log.i("sizedddd", String.valueOf(array.length));

        return s1;
    }


    public Integer[] clonearray() {

        Integer[] clonearray = new Integer[size];
        for (int i = 0; i < size; i++) {
            clonearray[i] = array[i];
        }
        return clonearray;
    }

    public void bubblesort() {
        new Bubblesort(this).execute(convert());
    }

    public void selectionsort() {
        new Selectionsort(this).execute(clonearray());
    }

    public void insertion() {

        new Insertionsort(this).execute(convert());

    }

    public void MergeSort() {
        new Mergesort(this).execute(convert());

    }

    public void QuickSort() {
        new Quicksort(this).execute(convert());

    }
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Arraysize=(EditText)findViewById(R.id.etArraysize);
        tvStatus=(TextView)findViewById(R.id.tvSta);
        tvBubblesort=(TextView)findViewById(R.id.tvBubblesort);
        tvSelectionsort=(TextView)findViewById(R.id.tvSelectionsort);
        tvinsertion=(TextView)findViewById(R.id.tvinsertion);
        tvQuickssort=(TextView)findViewById(R.id.tvQuickssort);
        tvMergesort=(TextView)findViewById(R.id.tvMergesort);

    }


}
