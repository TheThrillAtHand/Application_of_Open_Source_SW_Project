// 작성자 : 2016039002 박성진
// 설  명 : 갤러리 퍼미션 및 갤러리 가져오기

package com.nestnet.thethrillathand;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.nestnet.thethrillathand.Util.GALLERY_IMAGE;
import static com.nestnet.thethrillathand.Util.GALLERY_VIDEO;
import static com.nestnet.thethrillathand.Util.INTENT_MEDIA;
import static com.nestnet.thethrillathand.Util.showToast;

public class GalleryActivity extends BasicActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        setToolbarTitle("갤러리");

        if (ContextCompat.checkSelfPermission(GalleryActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(GalleryActivity.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    1);
            if (ActivityCompat.shouldShowRequestPermissionRationale(GalleryActivity.this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {

            } else {
                showToast(GalleryActivity.this, getResources().getString(R.string.please_grant_permission));
            }
        } else {
            recyclerInit();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    recyclerInit();
                } else {
                    finish();
                    showToast(GalleryActivity.this, getResources().getString(R.string.please_grant_permission));
                }
            }
        }
    }

    private void recyclerInit() {
        final int numberOfColumns = 3;

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));

        RecyclerView.Adapter mAdapter = new GalleryAdapter(this, getImagesPath(this));
        recyclerView.setAdapter(mAdapter);
    }

    public ArrayList<String> getImagesPath(Activity activity) {
        Uri uri;
        ArrayList<String> listOfAllImages = new ArrayList<String>();
        Cursor cursor;
        int column_index_data;
        String PathOfImage = null;
        String[] projection;

        Intent intent = getIntent();
        final int media = intent.getIntExtra(INTENT_MEDIA, GALLERY_IMAGE);
        if (media == GALLERY_VIDEO) {
            uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            projection = new String[]{MediaStore.MediaColumns.DATA, MediaStore.Video.Media.BUCKET_DISPLAY_NAME};
        } else {
            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            projection = new String[]{MediaStore.MediaColumns.DATA, MediaStore.Images.Media.BUCKET_DISPLAY_NAME};
        }

        cursor = activity.getContentResolver().query(uri, projection, null, null, null);
        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);

        while (cursor.moveToNext()) {
            PathOfImage = cursor.getString(column_index_data);

            listOfAllImages.add(PathOfImage);
        }
        return listOfAllImages;
    }
}


//    ImageView iv;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_gallery);
//        checkSelfPermission();
//
//    iv = findViewById(R.id.iv);
//    iv.setOnClickListener(new View.OnClickListener() {
//        @Override public void onClick(View v) {
//            Intent intent = new Intent();
//            //기기 기본 갤러리 접근
//            intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
//            // 구글 갤러리 접근
//            // intent.setType("image/*");
//            intent.setAction(Intent.ACTION_GET_CONTENT);
//            startActivityForResult(intent,101); } }); }
//
//
//            //권한에 대한 응답이 있을때 작동하는 함수
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        //권한을 허용 했을 경우
//        if(requestCode == 1){
//            int length = permissions.length;
//            for (int i = 0; i < length; i++) {
//                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
//                    // 동의
//                    Log.d("MainActivity","권한 허용 : " + permissions[i]);
//                }
//            }
//        }
//    }
//
//    public void checkSelfPermission() {
//
//        String temp = "";
//
//        //파일 읽기 권한 확인
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//            temp += Manifest.permission.READ_EXTERNAL_STORAGE + " "; }
//        //파일 쓰기 권한 확인
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//            temp += Manifest.permission.WRITE_EXTERNAL_STORAGE + " "; }
//        if (TextUtils.isEmpty(temp) == false) {
//            // 권한 요청
//            ActivityCompat.requestPermissions(this, temp.trim().split(" "),1);
//        }else {
//            // 모두 허용 상태
//            Toast.makeText(this, "권한을 모두 허용", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 101 && resultCode == RESULT_OK) {
//            try {
//                InputStream is = getContentResolver().openInputStream(data.getData());
//                Bitmap bm = BitmapFactory.decodeStream(is);
//                is.close();
//                iv.setImageBitmap(bm);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else if (requestCode == 101 && resultCode == RESULT_CANCELED) {
//            Toast.makeText(this, "취소", Toast.LENGTH_SHORT).show();
//        }
//    }
//}



