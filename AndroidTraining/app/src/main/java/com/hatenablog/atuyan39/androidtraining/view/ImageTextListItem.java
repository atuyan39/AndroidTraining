package com.hatenablog.atuyan39.androidtraining.view;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;

/**
 * ImageViewとTextが配置されたリストに使うアイテム
 */
public class ImageTextListItem {
    private Bitmap mImage;
    private String mText;

    /**
     * Constructor.
     *
     * @param image 画像
     * @param text テキスト
     */
    public ImageTextListItem(@NonNull Bitmap image, @NonNull String text) {
        mImage = image;
        mText = text;
    }

    // alt + insert(Getter and Setter)で自動追加できる
    public Bitmap getImage() {
        return mImage;
    }

    public void setImage(Bitmap mImage) {
        this.mImage = mImage;
    }

    public String getText() {
        return mText;
    }

    public void setText(String mText) {
        this.mText = mText;
    }
}
