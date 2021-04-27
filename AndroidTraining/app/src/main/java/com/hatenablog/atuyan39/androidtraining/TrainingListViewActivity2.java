package com.hatenablog.atuyan39.androidtraining;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import com.hatenablog.atuyan39.androidtraining.adapter.ImageTextListAdapter;
import com.hatenablog.atuyan39.androidtraining.view.ImageTextListItem;

import java.util.ArrayList;

public class TrainingListViewActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_list_view_actvity2);

        // ListViewを取得
        ListView listView = findViewById(R.id.list_view_2);

        // リストに表示するアイテムを作成
        ArrayList<ImageTextListItem> listItems = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.gohan);
            String text = "List item " + i;
            ImageTextListItem item = new ImageTextListItem(image, text);
            listItems.add(item);
        }

        // 作成したリストを表示する
        ImageTextListAdapter adapter = new ImageTextListAdapter(this, R.layout.image_text_list_item, listItems);
        listView.setAdapter(adapter);
    }
}