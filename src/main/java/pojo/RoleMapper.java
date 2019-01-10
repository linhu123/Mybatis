package pojo;


import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    public Role getRole(Long id);

    public List<Role> findRoleByAnnotation(@Param("roleName") String rolename,
                                           @Param("note") String note);
    public int insertRole(Role role);
}

