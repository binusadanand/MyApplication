package gumtree.binu.com.myapplication.Advert;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import gumtree.binu.com.myapplication.Models.Advert;

import gumtree.binu.com.myapplication.R;
import gumtree.binu.com.myapplication.Service.NetComms;

/**
 * Created by luckybinu on 18/02/2017.
 */

public class AdvertActivity extends Activity implements AdvertView {

    private RecyclerView mRecyclerView;
    private AdvertAdapter mAdapter;

    private ProgressBar mProgressBar;
    private TextView mPageCountTv;
    private TextView mErrorTv;

    private ViewPager mPager;
    private AdvertImageAdapter mPageAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        renderView();
        init();
    }

    @Override
    protected void  onResume() {
        super.onResume();
        AdvertPresenter presenter = new AdvertPresenter(this, new NetComms());
        presenter.getAdvertDetails();

    }

    public  void renderView(){
        setContentView(R.layout.advert_detail_layout);

        mRecyclerView = (RecyclerView) findViewById(R.id.advert_details_view_list);
        mPageCountTv = (TextView) findViewById(R.id.advert_detailed_image_page_count);
        mProgressBar = (ProgressBar) findViewById(R.id.advert_details_view_pb);

        mErrorTv = (TextView) findViewById(R.id.advert_details_view_info_tv);
        mPager = (ViewPager) findViewById(R.id.advert_detailed_image_pager);

    }

    public void init(){
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new AdvertAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mPageAdapter = new AdvertImageAdapter(this);
        mPager.setAdapter(mPageAdapter);
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showDetails (Advert aAdvertDetails) {
        mAdapter.setData(aAdvertDetails);
        mPageAdapter.setData(aAdvertDetails.mImageList);
        mPageCountTv.setText(String.valueOf(aAdvertDetails.mImageList.size()));
        mErrorTv.setVisibility(View.GONE);
    }

    @Override
    public void showError(String aReason) {
        mErrorTv.setText(aReason);
        mErrorTv.setVisibility(View.VISIBLE);

    }
}
