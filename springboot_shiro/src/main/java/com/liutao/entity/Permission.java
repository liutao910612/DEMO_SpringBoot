package com.liutao.entity;

import javax.persistence.*;

/**
 * 权限实体类
 *
 * @author LIUTAO
 * @version 2017/5/10
 * @see
 * @since
 */
@Entity
@Table(name = "t_permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String permissionname;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public Permission() {
    }

    public Permission(String permissionname, Role role) {
        this.permissionname = permissionname;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionname() {
        return permissionname;
    }

    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permissionname='" + permissionname + '\'' +
                ", role=" + role +
                '}';
    }
}
