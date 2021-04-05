package com.hatenablog.atuyan39.androidtraining;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TrainingListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_list_view);

        // ListViewに表示するリストを用意します。
        List<String> list = new ArrayList<>();
        list.add("月曜日");
        list.add("火曜日");
        list.add("水曜日");
        list.add("木曜日");
        list.add("金曜日");
        list.add("土曜日");
        list.add("日曜日");

        // ListViewのViewを取得します。
        ListView listView = findViewById(R.id.list_view);
        // ListViewにリストをセットするために、Adapterを用意します。
        // android.R.layout.simple_list_item_1は、Androidがすでに用意しているリソースになります。
        // →TextViewがあるLayoutというシンプルなレイアウト。
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);

        // ListViewに作成したAdapterをセットして完了。
        listView.setAdapter(adapter);
    }
}