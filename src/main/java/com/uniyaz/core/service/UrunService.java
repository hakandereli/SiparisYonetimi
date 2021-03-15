package com.uniyaz.core.service;

import com.uniyaz.core.data.dao.UrunDao;
import com.uniyaz.core.domain.Urun;

import java.util.List;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class UrunService {
    UrunDao urunDao= new UrunDao();

    public void saveUrun(Urun urun){
        validateSaveUrun(urun);
        urunDao.saveUrun(urun);
    }

    private void validateSaveUrun(Urun urun) {
        if (!urun.getKod().startsWith("U")) throw new RuntimeException("Ürün Kodu Büyük U ile başlamak zorunda");
    }

    public List<Urun> findAllHql(String filtre){
        //Filtre Yoksa Normal Kayıtları Getir.
        if (filtre.equals("")){
            return urunDao.findAllHql();
        }//Filtre varsa koduna veya adına göre arayıp getir.
        else {
            return urunDao.findAllFilteredHql(filtre);
        }
    }

    public List<Urun> findAByIdCriteria(Long id){
        return urunDao.findAByIdCriteria(id);
    }

    public void deleteUrun(Urun urun) {
        urunDao.deleteUrun(urun);
    }
}
