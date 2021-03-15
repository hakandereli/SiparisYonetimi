package com.uniyaz.core.service;

import com.uniyaz.core.data.dao.MusteriDao;
import com.uniyaz.core.domain.Musteri;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class MusteriService {
    MusteriDao musteriDao = new MusteriDao();

    public void saveMusteri(Musteri musteri) {
        musteriDao.saveMusteri(musteri);
    }
}
