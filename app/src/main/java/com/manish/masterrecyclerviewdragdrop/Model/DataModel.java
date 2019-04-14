package com.manish.masterrecyclerviewdragdrop.Model;


public class DataModel {

    String name;
    String type;
    String version_number;
    String feature;
    int image_uri;

    public DataModel(String name, String type, String version_number, String feature,int image_uri ) {
        this.name=name;
        this.type=type;
        this.version_number=version_number;
        this.feature=feature;
        this.image_uri=image_uri;

    }


    public int getImage_uri(){
        return image_uri;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getVersion_number() {
        return version_number;
    }

    public String getFeature() {
        return feature;
    }

}
