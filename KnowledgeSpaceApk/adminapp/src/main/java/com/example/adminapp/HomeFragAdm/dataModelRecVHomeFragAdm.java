package com.example.adminapp.HomeFragAdm;

public class dataModelRecVHomeFragAdm {
    int image,likeImg,commentImg;
    String title,description;

    public dataModelRecVHomeFragAdm(int image, String title, String description,int likeImg, int commentImg) {
        this.image = image;
        this.likeImg = likeImg;
        this.commentImg = commentImg;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getLikeImg() {
        return likeImg;
    }

    public void setLikeImg(int likeImg) {
        this.likeImg = likeImg;
    }

    public int getCommentImg() {
        return commentImg;
    }

    public void setCommentImg(int commentImg) {
        this.commentImg = commentImg;
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
