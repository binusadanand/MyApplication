package gumtree.binu.com.myapplication.Advert;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import gumtree.binu.com.myapplication.R;

/**
 * Created by luckybinu on 20/02/2017.
 */

public class AdvertImageAdapter extends PagerAdapter {


    Context mContext;
    LayoutInflater mLayoutInflater;
    List<String> mImageUrlList;

    public AdvertImageAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        if (mImageUrlList == null) {
            return 0;
        } else {
            return mImageUrlList.size();
        }
    }

    public void setData(List<String> aUrlList) {
        mImageUrlList = aUrlList;
        notifyDataSetChanged();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = mLayoutInflater.inflate(R.layout.advert_detail_image_page_item, container, false);

        final ImageView aImageView = (ImageView) itemView.findViewById(R.id.advert_imageView);
        container.addView(itemView);
        Glide.with(mContext)
                .load(mImageUrlList.get(position))
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(aImageView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
