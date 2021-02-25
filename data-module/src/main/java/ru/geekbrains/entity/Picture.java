package ru.geekbrains.entity;

import javax.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "pictures")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "content_type", nullable = false)
    private String contentType;

    @OneToOne(fetch = FetchType.LAZY, cascade= CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name="picture_data_id")
    private PictureData pictureData;

    @ManyToOne
    private Interior interior;
    @ManyToOne
    private Interior exterior;

    public Picture() {
    }

    public Picture(Long id, String name, String contentType, PictureData pictureData, Interior interior, Interior exterior) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
        this.pictureData = pictureData;
        this.interior = interior;
        this.exterior = exterior;
    }


}
