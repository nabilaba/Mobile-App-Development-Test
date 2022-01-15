package com.nabilaba.MADTTest;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;
import android.content.Intent;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Data> dataItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomListAdapter(Activity activity, List<Data> dataItems) {
        this.activity = activity;
        this.dataItems = dataItems;
    }

    @Override
    public int getCount() {
        return dataItems.size();
    }

    @Override
    public Object getItem(int location) {
        return dataItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.kontak_list, null);

        if (imageLoader == null) imageLoader = AppController.getInstance().getImageLoader();
        
        NetworkImageView avatar = (NetworkImageView) convertView.findViewById(R.id.thumbnail);
        final TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView email = (TextView) convertView.findViewById(R.id.email);
        
        final Data m = dataItems.get(position);

        avatar.setImageUrl(m.getAvatarUrl(), imageLoader);
        name.setText(m.getName());
        email.setText(String.valueOf(m.getEmail()));
        
        convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View p1) {
                    Intent data = new Intent();
                    data.putExtra("FULL_NAME", m.getName());
                    activity.setResult(activity.RESULT_OK, data);
                    activity.finish();
                }
        });
        return convertView;
    }

}
