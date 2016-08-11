package com.example.vinoth.activitynavigator;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class InstantgramActivity extends AppCompatActivity {


    private ImageView ivResult;

    private Bitmap bitmapOriginal;

    public void startcamera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 100);
    }
     public void insertphoto (View view){
         Intent i = new Intent(Intent.ACTION_PICK,
                 MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
         startActivityForResult(i, 2);
     }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode == RESULT_OK){
            Bitmap bp = (Bitmap) data.getExtras().get("data");
            ivResult.setImageBitmap(bp);

        }

        if (requestCode == 2 && resultCode == RESULT_OK && null != data) {

            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
           Bitmap bitmap = BitmapFactory.decodeFile(picturePath);
            if (bitmap != null) {
                ivResult.setImageBitmap(bitmap);

            }

        }
    }

    public void applyFilter(View view){

         ivResult.buildDrawingCache();
         bitmapOriginal = ivResult.getDrawingCache();
        switch (view.getId()){
            case R.id.btnGrayscale:
                ivResult.setImageBitmap(toGrayscale(bitmapOriginal));
                break;
            case R.id.btnFHB:
                ivResult.setImageBitmap(flipHorizonallyBitmap(bitmapOriginal));
                break;
            case R.id.btnRotat:
                ivResult.setImageBitmap(rotateBitmap(bitmapOriginal,90));
                break;
            case R.id.btnFVB:
                ivResult.setImageBitmap(flipVerticallyBitmap(bitmapOriginal));
                break;
            case R.id.btnred:
                ivResult.setImageBitmap(toSephia(bitmapOriginal));
                break;
            case R.id.btntransp:
                ivResult.setImageBitmap(toBW(bitmapOriginal));
                break;
            case R.id.btnif1:
                ivResult.setImageBitmap(toSat(bitmapOriginal));
                break;
            case R.id.btnif2:
                break;
            case R.id.btnif3:
                break;
            case R.id.btnif4:
            case R.id.btnif5:
                break;
            case R.id.btnif6:
                break;

        }
    }

    public static Bitmap toGrayscale(Bitmap bmpOriginal) {
        Bitmap bmpGrayscale = Bitmap.createBitmap(bmpOriginal.getWidth(), bmpOriginal.getHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(cm);
        paint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(bmpOriginal, 0, 0, paint);

        return bmpGrayscale;
    }


    public static Bitmap rotateBitmap(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
    }


    public static Bitmap flipVerticallyBitmap(Bitmap source) {
        Matrix m = new Matrix();
        m.preScale(1, -1);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), m, false);
    }


    public static Bitmap flipHorizonallyBitmap(Bitmap source) {
        Matrix m = new Matrix();
        m.setScale(-1, 1);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), m, false);
    }

    public Bitmap toBW(Bitmap bitmapOriginal) {
        int width, height;
        height = bitmapOriginal.getHeight();
        width = bitmapOriginal.getWidth();
        Bitmap bmpMonochrome = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bmpMonochrome);
        ColorMatrix ma = new ColorMatrix();
        ma.setSaturation(2);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(ma));
        canvas.drawBitmap(bitmapOriginal,0,0,paint);
        return bmpMonochrome;
    }
    public Bitmap toSat(Bitmap bitmapOriginal) {
        int width, height;
        height = bitmapOriginal.getHeight();
        width = bitmapOriginal.getWidth();
        Bitmap bmpMonochrome = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bmpMonochrome);
        ColorMatrix ma = new ColorMatrix();
        ma.setSaturation(2);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(ma));
        canvas.drawBitmap(bitmapOriginal,0,0,paint);
        return bmpMonochrome;
    }

    public Bitmap toSephia(Bitmap bmpOriginal) {

        float[] sepMat = {
                0.3930000066757202f,
                0.7689999938011169f,
                0.1889999955892563f,
                0,
                0,
                0.3490000069141388f,
                0.6859999895095825f,
                0.1679999977350235f,
                0,
                0,
                0.2720000147819519f,
                0.5339999794960022f,
                0.1309999972581863f,
                0,
                0,
                0,
                0,
                0,
                1,
                0,
                0,
                0,
                0,
                0,
                1,0,0,0,0,1,1,1,1};

        ColorMatrix sepiaMatrix = new ColorMatrix();
        sepiaMatrix.set(sepMat);

        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(sepiaMatrix);
        Bitmap rBitmap = bmpOriginal.copy(Bitmap.Config.ARGB_8888, true);

        Paint paint = new Paint();
        paint.setColorFilter(colorFilter);

        Canvas myCanvas = new Canvas(rBitmap);
        myCanvas.drawBitmap(rBitmap, 0, 0, paint);
        return rBitmap;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instantgram);

        ivResult=(ImageView)findViewById(R.id.ivResult);





    }
}
