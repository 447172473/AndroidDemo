package com.littlejie.android.demo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.littlejie.android.demo.R;
import com.littlejie.ui.image.BaseImageView;

import java.util.List;

/**
 * Created by Lion on 2016/6/23.
 */
public class ImageGridAdapter extends BaseAdapter {

    private Context context;
    private List<String> lstImg;

    public ImageGridAdapter(Context context) {
        this.context = context;
    }

    public void setLstImg(List<String> lstImg) {
        this.lstImg = lstImg;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return lstImg == null ? 0 : lstImg.size();
    }

    @Override
    public Object getItem(int position) {
        return lstImg == null ? null : lstImg.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            ViewHolder vh = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_grid_view, null);
            vh.ivGridItem = (BaseImageView) convertView.findViewById(R.id.iv_grid_item);
            convertView.setTag(vh);
        }
        ViewHolder vh = (ViewHolder) convertView.getTag();
        String url = getItem(position).toString();
        vh.ivGridItem.setImage(url);
        //代码中重新设置一遍，xml中设置无效
        vh.ivGridItem.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return convertView;
    }

    private class ViewHolder {
        BaseImageView ivGridItem;
    }

}
