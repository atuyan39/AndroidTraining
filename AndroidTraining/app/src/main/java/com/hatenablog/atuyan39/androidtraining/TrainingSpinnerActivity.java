package com.hatenablog.atuyan39.androidtraining;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class TrainingSpinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_spinner);

        // Viewを取得
        TextView textView = findViewById(R.id.spinner_1_text_view);
        Spinner spinner = findViewById(R.id.spinner_1_spinner);

        // SpinnerにセットするAdapterを作成する
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_1_array, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Spinnerの項目が選択された際のリスナーを登録する
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CharSequence selected = (CharSequence) parent.getItemAtPosition(position);
                textView.setText(selected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // nop
            }
        });

        // SpinnerにAdapterをセットする
        spinner.setAdapter(adapter);
    }
}