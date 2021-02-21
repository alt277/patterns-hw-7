package ru.geekbrains.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "interior")  //@Table javax.persistence не HIBERNATE

public class Interior implements Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "panel")
    private String panel;

    @Column(name = "seatMaterial")
    private String seatMaterial;

    @Column(name = "seatColor")
    private String seatColor;

    @ManyToMany
    @JoinTable(
            name = "car",
            joinColumns = @JoinColumn(name = "interiorId"),
            inverseJoinColumns = @JoinColumn(name = "exteriorId")
    )

    private List<Exterior> exteriors;
    private List <Picture> pictureList;

    public List<Picture> getPictureList() {
        return pictureList;
    }

    public Interior(Long id, String panel, String seatMaterial, String seatColor) {
        this.id = id;
        this.panel = panel;
        this.seatMaterial = seatMaterial;
        this.seatColor = seatColor;
    }

    public Interior(Long id, String panel, String seatMaterial, String seatColor, List<Exterior> exteriors) {
        this.id = id;
        this.panel = panel;
        this.seatMaterial = seatMaterial;
        this.seatColor = seatColor;
        this.exteriors = exteriors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPanel() {
        return panel;
    }

    public void setPanel(String panel) {
        this.panel = panel;
    }

    public String getSeatMaterial() {
        return seatMaterial;
    }

    public void setSeatMaterial(String seatMaterial) {
        this.seatMaterial = seatMaterial;
    }

    public String getSeatColor() {
        return seatColor;
    }

    public void setSeatColor(String seatColor) {
        this.seatColor = seatColor;
    }

    public List<Exterior> getExteriors() {
        return exteriors;
    }

    public void setExteriors(List<Exterior> exteriors) {
        this.exteriors = exteriors;
    }

    @Override
    public void show() {
        System.out.printf("Your %s interior options:  \n", this.getClass().getSimpleName());
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Interior{" +
                "id=" + id +
                ", panel='" + panel + '\'' +
                ", seatMaterial='" + seatMaterial + '\'' +
                ", seatColorl='" + seatColor + '\'' +
                ", exteriors=" + exteriors +
                '}';
    }


    public static class Builder {
        private Long id;
        private String panel;
        private String seatMaterial;
        private String seatColor;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setPanel(String panel) {
            this.panel = panel;
            return this;
        }

        public Builder setseatMateria(String seatMaterial) {
            this.seatMaterial = seatMaterial;
            return this;
        }

        public Builder setseatMaterial(String seatMaterial) {
            this.seatMaterial = seatMaterial;
            return this;
        }


        public Builder setseatColor(String seatColor) {
            this.seatColor = seatColor;
            return this;
        }


        public Interior build() {
            return new Interior(id,
                    panel,
                    seatColor,
                    seatMaterial

            );
        }
    }
}
