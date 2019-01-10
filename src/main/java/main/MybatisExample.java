package main;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Role;
import pojo.RoleMapper;
import utils.MybatisUtils;

public class MybatisExample {
    public static void main(String[] args) throws NullPointerException {
        SqlSession sqlSession = null;
        try {
            System.out.println("in try  ");
            sqlSession = MybatisUtils.getSqlSessionFactory().openSession();
            RoleMapper roloMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roloMapper.getRole(1L);
            System.out.println("Role_name"+role.toString());
        }finally {
            sqlSession.close();
        }

    }
}
