package com.lixiang.updatedata_demo.bean;

/**
 * @author laibaijiang
 * @date 2023/3/28
 */
public class Data {
    private int imgId;
    private String context;

    public Data() {}

    public Data(int imgId, String context) {
        this.imgId = imgId;
        this.context = context;
    }

    public int getImgId() {
        return imgId;
    }

    public String getContext() {
        return context;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
