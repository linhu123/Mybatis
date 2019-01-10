package main;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
public class Mybatis2 {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
//        Role role = null;
        List<Role> roleList = new ArrayList<Role>();
        try {
            sqlSession = SqlsessionFactoryUtil.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            /*
            查询单个文件
             */
            //role = roleMapper.getRole((long) 1);
            roleList = roleMapper.findRoleByAnnotation("linhu","1adhfjkh");
        }finally {
            sqlSession.close();
        }
        //System.out.println("Role`s name is "+role.getRoleName());
        for (Role role:roleList ) {
            System.out.println("Role is "+role.toString());

        }

    }
}
