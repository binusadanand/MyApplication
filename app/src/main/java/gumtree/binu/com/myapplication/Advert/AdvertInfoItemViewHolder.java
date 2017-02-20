package gumtree.binu.com.myapplication.Advert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import gumtree.binu.com.myapplication.R;

/**
 * Created by luckybinu on 19/02/2017.
 */

public class AdvertInfoItemViewHolder extends RecyclerView.ViewHolder {

    public TextView mDescriptionTv;
    public TextView mSectionHeaderTv;
    public ImageView mSectionHeaderIv;

    public AdvertInfoItemViewHolder(View itemView) {
        super(itemView);

        mSectionHeaderIv = (ImageView) itemView.findViewById(R.id.advert_item_type_iv);
        mSectionHeaderTv = (TextView) itemView.findViewById(R.id.advert_item_details_tv);
        mDescriptionTv = (TextView) itemView.findViewById(R.id.advert_item_type_tv);

    }
}
