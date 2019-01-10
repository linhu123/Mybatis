package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: linhu
 * @Date: 2019/1/4 18:19
 * @Version 1.2.0
 */
public class SqlsessionFactoryUtil {
    //sqlSessionFactory对象
    private static SqlSessionFactory sqlSessionFactory = null;

    //类线程锁
    private static final Class CLASS_LOCK = SqlsessionFactoryUtil.class;

    /**
     * 私有化构造函数
     * 避免使用者使用new的方式去创建多个对象
     */
    private  SqlsessionFactoryUtil(){}

    /**
     * 构建SqlSessionFactory
     * @return SqlSessionFactory
     */
    public static SqlSessionFactory initSqlSessionFactory(){
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        synchronized (CLASS_LOCK){
            if (sqlSessionFactory == null){
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
        }
        return sqlSessionFactory;
    }

    /**
     * 打开SqlSession
     * @return SqlSession
     */
    public static SqlSession openSqlSession(){
        if(sqlSessionFactory == null){
            initSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }

}
