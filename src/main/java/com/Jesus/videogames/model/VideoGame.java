package com.Jesus.videogames.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VideoGame {

    @Id
    private Long id;
    private String title;
    private Double price;
    private Boolean recommended;

    public VideoGame() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getRecommended() {
        return recommended;
    }

    public void setRecommended(Boolean recommended) {
        this.recommended = recommended;
    }

    @Override
    public String toString() {
        return "VideoGame{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", recommended=" + recommended +
                '}';
    }
}
