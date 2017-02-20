package gumtree.binu.com.myapplication.Advert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import gumtree.binu.com.myapplication.Models.Advert;
import gumtree.binu.com.myapplication.R;

/**
 * Created by luckybinu on 18/02/2017.
 */

public class AdvertAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_TITLE = 1;
    private static final int TYPE_INFO = 2;

    public class SectionInfo {
        public int mSectionIconId;
        public String mSectionInfo;
        public String mSectionHeader;
        SectionInfo(int aResId,
                    String aInfo,
                    String aHeader) {
            mSectionIconId = aResId;
            mSectionInfo = aInfo;
            mSectionHeader = aHeader;

        }
    }

    private String mTitle;
    private List <SectionInfo> mSectionData;

    public AdvertAdapter() {
        super();
    }

    public void setData(Advert aData) {
        mTitle = aData.mTitle;
        mSectionData = new ArrayList<>();

        mSectionData.add(new SectionInfo(R.drawable.ic_list_black_24dp, aData.mPrice ,aData.mDescription));
        mSectionData.add(new SectionInfo(R.drawable.ic_list_black_24dp, "TODAY" ,"DatePosted"));
        mSectionData.add(new SectionInfo(R.drawable.ic_list_black_24dp, "Petrol", "Fuel Type"));
        notifyDataSetChanged();


    }

    @Override
    public int getItemViewType(int position) {

        switch (position) {
            case 0:
                return TYPE_TITLE;
            default:
                return TYPE_INFO;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_TITLE) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.advert_title, parent, false);
            return new AdvertTitleViewHolder(itemView);
        } else {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.advert_detail_list_item, parent, false);
            return new AdvertInfoItemViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);

        switch (viewType) {
            case TYPE_TITLE:
                AdvertTitleViewHolder aTitleHolder = (AdvertTitleViewHolder) holder;
                if (!TextUtils.isEmpty(mTitle)) {
                    aTitleHolder.mTileTv.setText(mTitle);
                }
                break;

            case TYPE_INFO:
            default:
                AdvertInfoItemViewHolder aItemHolder = (AdvertInfoItemViewHolder) holder;
                if ((mSectionData != null) &&(mSectionData.size() > 1)) {

                    SectionInfo aData = mSectionData.get(position - 1);
                    aItemHolder.mSectionHeaderTv.setText(aData.mSectionHeader);
                    aItemHolder.mDescriptionTv.setText(aData.mSectionInfo);
                    aItemHolder.mSectionHeaderIv.setImageResource(aData.mSectionIconId);
                }
        }

    }

    @Override
    public int getItemCount() {

        int i = 0;
        if (mTitle != null) {
            i++;
        }
        if (mSectionData != null) {
            i+=mSectionData.size();
        }
        return i;
    }

}
