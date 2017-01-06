package com.practice.android.muliwork;

/**
 * Created by tao on 6/1/2017.
 */

public class Words {
    private String mDefaultTranslation;
    private String mMultiworkTranslation;

    public Words(String defaultTranslation, String multiworkTranslation){
        mDefaultTranslation = defaultTranslation;
        mMultiworkTranslation = multiworkTranslation;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public String getMultiWorkTranslation(){
        return mMultiworkTranslation;
    }
}
