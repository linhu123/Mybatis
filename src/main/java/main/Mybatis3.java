package main;

import org.apache.ibatis.session.SqlSession;
import pojo.Role;
import pojo.RoleMapper;
import utils.SqlsessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: linhu
 * @Date: 2019/1/4 19:20
 * @Version 1.0
 */
public class Mybatis3 {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        Role role = new Role();
        role.setRoleName("xiaoming");
        role.setNote("very cool!!");
        int result = 0 ;

        try {
            sqlSession = SqlsessionFactoryUtil.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            result = roleMapper.insertRole(role);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
        System.out.println("Role`s name is "+role.getRoleName());
        System.out.println("result is"+result);

    }
}
