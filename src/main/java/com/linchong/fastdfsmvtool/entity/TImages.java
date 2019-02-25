package com.linchong.fastdfsmvtool.entity;

import java.util.Date;

public class TImages {
    private Long imageId;
    private String imageName;
    private String imageTitile;
    private String imageUrl;
    private Double imageSize;
    private String imageExt;
    private String thumbnailUrl;
    private Double thumbnailSize;
    private Date crationTime;

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageTitile() {
        return imageTitile;
    }

    public void setImageTitile(String imageTitile) {
        this.imageTitile = imageTitile;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getImageSize() {
        return imageSize;
    }

    public void setImageSize(Double imageSize) {
        this.imageSize = imageSize;
    }

    public String getImageExt() {
        return imageExt;
    }

    public void setImageExt(String imageExt) {
        this.imageExt = imageExt;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Double getThumbnailSize() {
        return thumbnailSize;
    }

    public void setThumbnailSize(Double thumbnailSize) {
        this.thumbnailSize = thumbnailSize;
    }

    public Date getCrationTime() {
        return crationTime;
    }

    public void setCrationTime(Date crationTime) {
        this.crationTime = crationTime;
    }
}
