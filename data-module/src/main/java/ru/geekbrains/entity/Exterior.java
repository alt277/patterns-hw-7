package ru.geekbrains.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "exterior")

public class Exterior  implements Component{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "color")
    private String color;

    @Column(name = "chromMoldings")
    private boolean chromMoldings;

    @Column (name = "tintedWindows")
    private boolean tintedWindows;

    @Column  (name = "wheelDesign")
    private String wheelDesign;

    @Column  (name = "wheelSize")
    private double wheelSize;

    @Column(name = "grillDesign")
    private String grillDesign;

    public Exterior() {
    }

    public Exterior(Long id, String color,
                    boolean chromMoldings, boolean tintedWindows,
                    String wheelDesign, double wheelSize, String grillDesign,
                    List<Interior> interiors) {
        this.id = id;
        this.color = color;
        this.chromMoldings = chromMoldings;
        this.tintedWindows = tintedWindows;
        this.wheelDesign = wheelDesign;
        this.wheelSize = wheelSize;
        this.grillDesign = grillDesign;
        this.interiors = interiors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isChromMoldings() {
        return chromMoldings;
    }

    public void setChromMoldings(boolean chromMoldings) {
        this.chromMoldings = chromMoldings;
    }

    public boolean isTintedWindows() {
        return tintedWindows;
    }

    public void setTintedWindows(boolean tintedWindows) {
        this.tintedWindows = tintedWindows;
    }

    public String getWheelDesign() {
        return wheelDesign;
    }

    public void setWheelDesign(String wheelDesign) {
        this.wheelDesign = wheelDesign;
    }

    public double getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(double wheelSize) {
        this.wheelSize = wheelSize;
    }

    public String getGrillDesign() {
        return grillDesign;
    }

    public void setGrillDesign(String grillDesign) {
        this.grillDesign = grillDesign;
    }

    public List<Interior> getInteriors() {
        return interiors;
    }

    public void setInteriors(List<Interior> interiors) {
        this.interiors = interiors;
    }


    @ManyToMany
    @JoinTable(
            name = "car",
            joinColumns=@JoinColumn(name = "exteriorId"),
            inverseJoinColumns = @JoinColumn(name = "interiorId")

)
    private List<Interior> interiors;
    private List <Picture> pictureList;

    public List<Picture> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<Picture> pictureList) {
        this.pictureList = pictureList;
    }

    @Override
    public void show() {
        System.out.printf("Your %s exterior options:  \n", this.getClass().getSimpleName());
        System.out.println(this.toString());
    }

    public Exterior(Long id, String color, boolean chromMoldings, boolean tintedWindows, String wheelDesign, double wheelSize, String grillDesign) {
        this.id = id;
        this.color = color;
        this.chromMoldings = chromMoldings;
        this.tintedWindows = tintedWindows;
        this.wheelDesign = wheelDesign;
        this.wheelSize = wheelSize;
        this.grillDesign = grillDesign;
        this.interiors = interiors;
    }

    @Override
    public String toString() {
        return "Exterior{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", chromMoldings=" + chromMoldings +
                ", tintedWindows=" + tintedWindows +
                ", wheelDesign='" + wheelDesign + '\'' +
                ", wheelSize=" + wheelSize +
                ", grillDesign='" + grillDesign + '\'' +
                ", interiors=" + interiors +
                '}';
    }

    public static class Builder {
        private Long id;
        private String color;
        private boolean chromMoldings;
        private boolean tintedWindows;
        private String wheelDesign;
        private Long wheelSize;
        private String grillDesign;
        private List<Picture> picturelist;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setChromMoldings(boolean chromMoldings) {
            this.chromMoldings = chromMoldings;
            return this;
        }

        public Builder setTintedWindows(boolean tintedWindows) {
            this.tintedWindows = tintedWindows;
            return this;
        }

        public Builder setWheelDesign(String wheelDesign) {
            this.wheelDesign = wheelDesign;
            return this;
        }

        public Builder setWheelSize(Long wheelSize) {
            this.wheelSize = wheelSize;
            return this;
        }

        public Builder setGrillDesign(String grillDesign) {
            this.grillDesign = grillDesign;
            return this;
        }

        public Builder setPicturelist(List<Picture> picturelist) {
            this.picturelist = picturelist;
            return this;
        }

        public Exterior build() {
            return new Exterior(id,
                    color,
                    chromMoldings,
                    tintedWindows,
                    wheelDesign,
                    wheelSize,
                    grillDesign
            );
        }
    }
}

