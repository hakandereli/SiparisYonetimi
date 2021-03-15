package com.uniyaz.core.data.dao;

import com.uniyaz.core.data.utils.HibernateUtil;
import com.uniyaz.core.domain.Musteri;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class MusteriDao {
    public void saveMusteri(Musteri musteri) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(musteri);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
