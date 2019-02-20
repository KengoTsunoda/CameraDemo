package com.example.a12826007.camerademo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class UseCameraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_camera);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        // カメラアプリとの連携からの戻りでかつ撮影成功の場合
        if (requestCode == 200 && resultCode == RESULT_OK){
            // 撮影された画像のビットマップデータを取得
            Bitmap bitmap = data.getParcelableExtra("data");
            // 画像を表示するImageViewを取得
            ImageView ivCamera = findViewById(R.id.ivCamera);
            // 撮影された画像をImageViewに設定
            ivCamera.setImageBitmap(bitmap);
        }
    }

    /**
     * 画像部分がタップされた時の処理メソッド
     */
    public void onCameraImageClick(View view){
        // カメラアプリを起動する暗黙的インテント
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Activityを起動
        startActivityForResult(intent, 200);
    }
}
