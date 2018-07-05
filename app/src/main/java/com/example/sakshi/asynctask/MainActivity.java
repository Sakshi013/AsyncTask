package com.example.sakshi.asynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button toast,showimage;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        toast = findViewById(R.id.toast);
        showimage = findViewById(R.id.showimage);

        progressBar = findViewById(R.id.progressBar);



        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "i am in toast", Toast.LENGTH_SHORT).show();
            }
        });

        showimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                loadimage();

                new loadIconTask().execute(R.drawable.baaghi);
            }
        });


    }
//1nteger=parameter,2 progress,3 output...........

    class loadIconTask extends AsyncTask<Integer,Integer,Bitmap>{


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(progressBar.VISIBLE);
        }

        @Override
        protected Bitmap doInBackground(Integer... integers) {

            Bitmap bitmap =BitmapFactory.decodeResource(getResources(),R.drawable.baaghi);
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            super.onPostExecute(bitmap);

            imageView.setImageBitmap(bitmap);
            progressBar.setVisibility(progressBar.INVISIBLE);


        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }
    }
//    private void loadimage() {
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                final Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.baaghi);
//
//                MainActivity.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        imageView.setImageBitmap(bitmap);
//
//                    }
//                });
//
//            }
//        }).start();
//    }


}
