package com.hatenablog.atuyan39.androidtraining;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TrainingRadioActivity extends AppCompatActivity {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_radio);

        // Viewを取得
        mTextView = findViewById(R.id.radio_1_text_view);
    }

    /**
     * Called when a radio button has been clicked.
     *
     * @param view the view that was clicked
     */
    public void onRadioButtonClicked(View view) {
        switch (view.getId()) {
            case R.id.radio_1_radio_a:
                mTextView.setText(R.string.radio_1_blood_type_a);
                break;
            case R.id.radio_1_radio_b:
                mTextView.setText(R.string.radio_1_blood_type_b);
                break;
            case R.id.radio_1_radio_o:
                mTextView.setText(R.string.radio_1_blood_type_o);
                break;
            case R.id.radio_1_radio_ab:
                mTextView.setText(R.string.radio_1_blood_type_ab);
                break;
            default:
                break;
        }
    }
}