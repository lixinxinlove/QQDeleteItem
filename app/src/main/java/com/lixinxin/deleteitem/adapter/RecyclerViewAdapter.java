package com.lixinxin.deleteitem.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lixinxin.deleteitem.R;
import com.lixinxin.deleteitem.widgit.LXXSwipeItemLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixinxin on 2016/6/14.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    List<LXXSwipeItemLayout> lists = new ArrayList<>();


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(parent.getContext(), R.layout.item, null);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv.setText("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
        holder.del.setText("删除");
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        LXXSwipeItemLayout lxx;
        TextView tv;
        TextView del;

        public ViewHolder(View itemView) {
            super(itemView);
            lxx = (LXXSwipeItemLayout) itemView.findViewById(R.id.lxx);
            tv = (TextView) itemView.findViewById(R.id.tv);
            del = (TextView) itemView.findViewById(R.id.delete);

            lxx.setDelegate(new LXXSwipeItemLayout.BGASwipeItemLayoutDelegate() {
                @Override
                public void onBGASwipeItemLayoutOpened(LXXSwipeItemLayout swipeItemLayout) {
                    closeAllItem();
                    lists.add(swipeItemLayout);
                }

                @Override
                public void onBGASwipeItemLayoutClosed(LXXSwipeItemLayout swipeItemLayout) {
                    lists.remove(swipeItemLayout);
                }

                @Override
                public void onBGASwipeItemLayoutStartOpen(LXXSwipeItemLayout swipeItemLayout) {
                    closeAllItem();
                }
            });


        }
    }


    public void closeAllItem() {

        for (LXXSwipeItemLayout v : lists) {
            v.close();
        }
    }


}
