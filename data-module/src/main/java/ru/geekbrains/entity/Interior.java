package ru.geekbrains.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
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

    public Interior() {
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


    @Override
    public void show() {
        System.out.printf("Your %s interior options:  \n", this.getClass().getSimpleName());
        System.out.println(this.toString());
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
