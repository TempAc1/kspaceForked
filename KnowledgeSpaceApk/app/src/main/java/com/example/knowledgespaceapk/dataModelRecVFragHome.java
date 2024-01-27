package com.example.knowledgespaceapk;

public class dataModelRecVFragHome {
    int image,likeImg,commentImg;
    String title,description;

    public dataModelRecVFragHome(int image, String title, String description,int likeImg, int commentImg) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.likeImg = likeImg;
        this.commentImg = commentImg;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLikeImg(int likeImg) {
        this.likeImg = likeImg;
    }

    public void setCommentImg(int commentImg) {
        this.commentImg = commentImg;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


    public int getLikeImg() {
        return likeImg;
    }

    public int getCommentImg() { return  commentImg;}
}
