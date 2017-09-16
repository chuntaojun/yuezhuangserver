package com.yueserver.sql.impl;

import com.yueserver.sql.PrdPicSqlInterface;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.util.Map;

@Service("PrdPicSql")
public class PrdPicSql implements PrdPicSqlInterface {

    @Autowired(required = false)
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public boolean saveBatchPrdPic(Map<String, Object> prdpicMap) {
        String[] prdpiculrs = (String[]) prdpicMap.get("urls");
        int prdNo = (int) prdpicMap.get("prdNo");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.doWork(connection -> {
                String sql = "INSERT INTO PrdPic(PrdPicUrl,PrdNo) VALUES ";
                for (int i = 0; i < prdpiculrs.length; i++) {
                    if (i == prdpiculrs.length - 1)
                        sql += "(?,?)";
                    else
                        sql += "(?,?),";
                }
                sql += " ON DUPLICATE KEY UPDATE PrdPicUrl=VALUES(PrdPicUrl)";
                System.out.println(sql);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                int i = 1;
                for (String url : prdpiculrs) {
                    preparedStatement.setString(i, url);
                    preparedStatement.setInt(++i, prdNo);
                    i++;
                }
                preparedStatement.addBatch();
                preparedStatement.executeUpdate();
                preparedStatement.close();
            });
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean deleBatchPrdPic(Map<String, Object> prdpicMap) {
        return false;
    }
}
