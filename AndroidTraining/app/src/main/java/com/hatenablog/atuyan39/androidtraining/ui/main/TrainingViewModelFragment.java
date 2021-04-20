package com.hatenablog.atuyan39.androidtraining.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hatenablog.atuyan39.androidtraining.R;

public class TrainingViewModelFragment extends Fragment {

    private TrainingViewModel mViewModel;

    public static TrainingViewModelFragment newInstance() {
        return new TrainingViewModelFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // テンプレートだとonActivityCreatedでViewModelの生成をしているが、
        // 再描画されても同じViewModelを使えるようにonCreateへ移動（公式もonCreate推奨）
        mViewModel = new ViewModelProvider(this).get(TrainingViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.vm1_main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Viewを取得
        TextView textView = view.findViewById(R.id.vm1_text_view);
        Button mButton = view.findViewById(R.id.vm1_button);

        // Buttonの押下時の処理を追加
        mButton.setOnClickListener(v -> mViewModel.onClickButton());

        // LiveDataの取得と監視
        mViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                // LiveDataに変更があった時の処理を追加
                textView.setText(s);
            }
        });
    }
}