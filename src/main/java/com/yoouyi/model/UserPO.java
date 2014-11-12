package com.yoouyi.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.bson.types.ObjectId;

@Entity
@Table(name = "t_user")
public class UserPO {
    private ObjectId id;
    
    private String username;
    private String password;
    private RolePO role;

    private String lastLoginIP;
    private Long lastLoginDate;

    private Long createdDate;
    private Long modifiedDate;

    private boolean enable = true;

    @Id
    @GeneratedValue
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public RolePO getRole() {
        return role;
    }

    public void setRole(RolePO role) {
        this.role = role;
    }

    public String getLastLoginIP() {
        return lastLoginIP;
    }

    public void setLastLoginIP(String lastLoginIP) {
        this.lastLoginIP = lastLoginIP;
    }

    public Long getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Long lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public Long getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Long modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
