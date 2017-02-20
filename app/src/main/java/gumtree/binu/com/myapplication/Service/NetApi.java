package gumtree.binu.com.myapplication.Service;

import android.location.Location;
import android.location.LocationManager;
import java.util.ArrayList;
import java.util.Date;

import gumtree.binu.com.myapplication.Models.Advert;

/**
 * Created by luckybinu on 19/02/2017.
 */

public class NetApi {

    /* GET Advertisement details
     *
     */
    Advert getFromApi() {
        Advert aAdvert = new Advert();
        aAdvert.mIsFavorite = false;
        aAdvert.mCreateDate = new Date(System.currentTimeMillis());
        aAdvert.mTitle = "Classic car Cupra 240 TFSI Low Mileage";
        aAdvert.mDescription = "Been in the family, owned myself for last 40 years ! " +
                "Always gaaged only reason to sell it because we are moving over seas and cannnot take it with us. " +
                "she is a beast with top spec , all luxuries, rare gold edition with purple rear lights and last of its shape, runs and drives great." +
                "\n Ready to drive away today ! Please welcome, based in Church Crookham";
        aAdvert.mPrice = "£ 2999.89";
        aAdvert.mLocation = new Location(LocationManager.NETWORK_PROVIDER);
        aAdvert.mImageList = new ArrayList<>();
        aAdvert.mImageList.add("https://static.pexels.com/photos/189454/pexels-photo-189454.jpeg");
        aAdvert.mImageList.add("https://static.pexels.com/photos/175688/pexels-photo-175688.jpeg");
        aAdvert.mImageList.add("https://static.pexels.com/photos/175713/pexels-photo-175713.jpeg");
        aAdvert.mImageList.add("https://static.pexels.com/photos/103290/pexels-photo-103290.jpeg");
        return aAdvert;
    }
}
