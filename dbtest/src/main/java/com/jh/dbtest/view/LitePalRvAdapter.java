package com.jh.dbtest.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jh.dbtest.R;
import com.jh.dbtest.model.TopItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lsy on 2017/10/17.
 * RecyclerView 对应的Adapter
 */

public class LitePalRvAdapter extends RecyclerView.Adapter {
    /**
     * Adapter维护的集合
     *
     * @param parent
     * @param viewType
     * @return
     */
    private List<TopItemBean> topListContainer;
    private Context mContext;

    public LitePalRvAdapter() {
        //懒加载思想
        topListContainer = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return new TopViewHolder(View.inflate(mContext, R.layout.item_layout, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TopViewHolder topViewHolder = (TopViewHolder) holder;
        topViewHolder.setTopData(position);
    }

    @Override
    public int getItemCount() {
        return topListContainer == null ? 0 : topListContainer.size();
    }

    /**
     * 对外提供的一个更新数据，刷新数据的方法
     */
    public void updateTopData(List<TopItemBean> topList) {
        if (topList != null) {
            topListContainer.clear();
            topListContainer.addAll(topList);
            notifyDataSetChanged();
        }
    }

    class TopViewHolder extends RecyclerView.ViewHolder {
        private ImageView picture;
        private TextView title;
        private TextView date;

        public TopViewHolder(View itemView) {
            super(itemView);
            picture = (ImageView) itemView.findViewById(R.id.picture);
            title = (TextView) itemView.findViewById(R.id.title);
            date = (TextView) itemView.findViewById(R.id.date);
        }

        public void setTopData(int position) {
            Glide.with(mContext).load(topListContainer.get(position).getThumbnail_pic_s()).into(picture);
            title.setText(topListContainer.get(position).getTitle());
            date.setText(topListContainer.get(position).getDate());
        }
    }
}
