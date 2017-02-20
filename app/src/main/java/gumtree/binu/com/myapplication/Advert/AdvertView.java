package gumtree.binu.com.myapplication.Advert;

import gumtree.binu.com.myapplication.Models.Advert;

/**
 * Created by luckybinu on 18/02/2017.
 */

public interface AdvertView {
    void showProgress();
    void dismissProgress();
    void showDetails(Advert aAdvertDetails);
    void showError(String aReason);
}
