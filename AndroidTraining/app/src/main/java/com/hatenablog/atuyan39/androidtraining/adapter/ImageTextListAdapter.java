package com.hatenablog.atuyan39.androidtraining.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hatenablog.atuyan39.androidtraining.R;
import com.hatenablog.atuyan39.androidtraining.view.ImageTextListItem;

import java.util.List;

/**
 * {@link ImageTextListItem}のアダプター。
 */
public class ImageTextListAdapter extends ArrayAdapter<ImageTextListItem> {

    private final int mResource;
    private final List<ImageTextListItem> mItems;
    private final LayoutInflater mInflater;

    /**
     * {@inheritDoc}
     */
    public ImageTextListAdapter(@NonNull Context context, int resource, @NonNull List<ImageTextListItem> items) {
        super(context, resource, items);

        mResource = resource;
        mItems = items;
        mInflater = LayoutInflater.from(context);
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;

        if (convertView != null) {
            view = convertView;
        } else {
            view = mInflater.inflate(mResource, null);
        }

        // リストに表示するアイテムを取得
        ImageTextListItem item = mItems.get(position);

        // Imageを設定
        ImageView image = view.findViewById(R.id.list_item_image);
        image.setImageBitmap(item.getImage());

        // Textを設定
        TextView text = view.findViewById(R.id.list_item_text);
        text.setText(item.getText());

        return view;
    }
}
