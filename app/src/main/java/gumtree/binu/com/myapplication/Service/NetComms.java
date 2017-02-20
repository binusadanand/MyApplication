package gumtree.binu.com.myapplication.Service;

import gumtree.binu.com.myapplication.Models.Advert;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by luckybinu on 19/02/2017.
 */

public class NetComms {
    NetApi mApi;
    public NetComms() {
        mApi =  new NetApi();
    }

    public interface AdvertDetailListener {
        void onSuccess(Advert aAdvertDetail);
        void onError(String  aCause);
    }

    public Subscription getAdvertDetails(final AdvertDetailListener aListener) {

        return Observable.just(mApi.getFromApi() )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Advert>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        aListener.onError(e.getMessage());

                    }

                    @Override
                    public void onNext(Advert aAdvertDetails) {
                        aListener.onSuccess(aAdvertDetails);

                    }
                });
    }


}
