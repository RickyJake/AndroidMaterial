package mshop.com.model;

import java.util.ArrayList;

import mshop.com.applymaterial.R;

/**
 * Created by Ricky on 26/06/2016.
 */

public class LandScape {

    private int imageID;
    private String title;
    private String description;

    public static ArrayList<LandScape> getData() {
        ArrayList<LandScape> dataList = new ArrayList<LandScape>();

        int[] images = getImages();
        for(int i = 0; i< images.length; i++) {
            LandScape landScape = new LandScape();
            landScape.setImageID(images[i]);
            landScape.setTitle("LandScape "+i);
            landScape.setDescription("Description "+i);

            dataList.add(landScape);
        }

        return dataList;
    }

    public static int[] getImages() {
        int[] images = {R.drawable.app_photo, R.drawable.beats, R.drawable.de,
                            R.drawable.tablet, R.drawable.shoes, R.drawable.parfum, R.drawable.iwatch,
        R.drawable.watch, R.drawable.samsung};

        return images;
    }


    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
