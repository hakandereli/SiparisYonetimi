package com.uniyaz.core.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
@Entity
@Table(name = "URUN")
public class Urun extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "AD", nullable = false , length = 100)
    @NotNull
    private String ad;

    @Size(max = 50)
    @Column(name = "KOD", length = 50)
    private String kod;

    @Column(precision = 15, scale = 2)
    private BigDecimal fiyat;

    private Musteri musteri;


    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public BigDecimal getFiyat() {
        return fiyat;
    }

    public void setFiyat(BigDecimal fiyat) {
        this.fiyat = fiyat;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }
}
