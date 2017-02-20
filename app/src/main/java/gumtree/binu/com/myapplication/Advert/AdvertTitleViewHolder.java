package gumtree.binu.com.myapplication.Advert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import gumtree.binu.com.myapplication.R;

/**
 * Created by luckybinu on 19/02/2017.
 */

public class AdvertTitleViewHolder extends RecyclerView.ViewHolder{

    public TextView mTileTv;

    public AdvertTitleViewHolder(View itemView) {
        super(itemView);
        mTileTv = (TextView) itemView.findViewById(R.id.advert_item_title_tv);
    }
}
