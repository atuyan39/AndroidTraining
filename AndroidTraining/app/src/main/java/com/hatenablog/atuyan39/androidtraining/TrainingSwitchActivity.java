package com.hatenablog.atuyan39.androidtraining;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class TrainingSwitchActivity extends AppCompatActivity {
    boolean isToggleA = false;
    boolean isToggleB = false;

    Switch mToggleButtonAnd;
    Switch mToggleButtonOr;
    Switch mToggleButtonXor;
    Switch mToggleButtonNand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_switch);
        Switch toggleButtonA = findViewById(R.id.switch_1_switch_a);
        toggleButtonA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isToggleA = isChecked;
                updateView(isToggleA, isToggleB);
            }
        });
        Switch toggleButtonB = findViewById(R.id.switch_1_switch_b);
        toggleButtonB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isToggleB = isChecked;
                updateView(isToggleA, isToggleB);
            }
        });

        mToggleButtonAnd = findViewById(R.id.switch_1_switch_and);
        mToggleButtonOr = findViewById(R.id.switch_1_switch_or);
        mToggleButtonXor = findViewById(R.id.switch_1_switch_xor);
        mToggleButtonNand = findViewById(R.id.switch_1_switch_nand);

        updateView(toggleButtonA.isChecked(), toggleButtonB.isChecked());
    }

    private void updateView(boolean a, boolean b) {
        mToggleButtonAnd.setChecked(and(a, b));
        mToggleButtonOr.setChecked(or(a, b));
        mToggleButtonXor.setChecked(xor(a, b));
        mToggleButtonNand.setChecked(nand(a, b));
    }

    // 論理積
    private boolean and(boolean a, boolean b) {
        return a & b;
    }

    // 論理和
    private boolean or(boolean a, boolean b) {
        return a | b;
    }

    // 排他的論理和
    private boolean xor(boolean a, boolean b) {
        return (a & !b) | (!a & b);
    }

    // 否定論理積
    private boolean nand(boolean a, boolean b) {
        return !and(a, b);
    }
}