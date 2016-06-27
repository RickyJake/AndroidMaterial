package mshop.com.model;

import java.util.ArrayList;
import java.util.List;

import mshop.com.applymaterial.R;


/**
 * Created by Ricky on 27/06/2016.
 */

public class NavigationDrawerItem {

    private String title;
    private int imageId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public static List<NavigationDrawerItem> getData() {
        List<NavigationDrawerItem> dataList = new ArrayList<>();

        int[] imageIds = getImages();
        String[] titles = getTitles();

        for(int i=0; i<imageIds.length; i++) {
            NavigationDrawerItem navItem = new NavigationDrawerItem();
            navItem.setImageId(imageIds[i]);
            navItem.setTitle(titles[i]);
            dataList.add(navItem);
        }

        return dataList;
    }

    private static int[] getImages() {
        int[] imgs = {R.drawable.ic_directions_bike, R.drawable.ic_directions_railway,
            R.drawable.ic_directions_run, R.drawable.ic_flight};

        return imgs;
    }

    private static String[] getTitles() {
        String[] titles = {"Vélo", "Trains", "Courses à pied", "Avion"};

        return  titles;
    }
}
