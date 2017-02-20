package gumtree.binu.com.myapplication.Advert;

import gumtree.binu.com.myapplication.Models.Advert;
import gumtree.binu.com.myapplication.Service.NetComms;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


/**
 * Created by luckybinu on 18/02/2017.
 */

public class AdvertPresenter {

    private final NetComms mNetComm;
    private final AdvertView mView;
    private CompositeSubscription  mSubscriptions;

    public AdvertPresenter(AdvertView aView, NetComms aNetComm) {
        mNetComm = aNetComm;
        mView = aView;
        mSubscriptions = new CompositeSubscription();

    }

    public void getAdvertDetails () {

        mView.showProgress();
        Subscription aEvent = mNetComm.getAdvertDetails(new NetComms.AdvertDetailListener() {
            @Override
            public void onSuccess(Advert aAdvertDetail) {
                mView.dismissProgress();
                mView.showDetails(aAdvertDetail);
            }

            @Override
            public void onError(String aReason) {
                mView.dismissProgress();
                mView.showError(aReason);
            }
        });

        mSubscriptions.add(aEvent);
    }

    public void onStop() {
        mSubscriptions.unsubscribe();
    }

}
