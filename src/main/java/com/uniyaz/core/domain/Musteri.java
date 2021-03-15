package com.uniyaz.core.domain;

import com.uniyaz.core.enums.EnumCinsiyet;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
@Entity
@Table(name = "MUSTERI")
public class Musteri extends BaseEntity{

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="AD", nullable = false, length = 120)
    @NotNull
    private String ad;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private EnumCinsiyet cinsiyet;

    @Transient
    private String unvan;

    @Column(length = 350)
    private String adres;

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

    public EnumCinsiyet getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(EnumCinsiyet cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getUnvan() {
        if (EnumCinsiyet.ERKEK.equals(cinsiyet)) return "Erkek " + getAd();
        else if(EnumCinsiyet.KADIN.equals(cinsiyet)) return "Kadın " + getAd();
        else return getAd();
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
