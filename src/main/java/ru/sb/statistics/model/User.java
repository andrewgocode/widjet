package ru.sb.statistics.model;

import org.springframework.security.core.GrantedAuthority;
import ru.sb.statistics.model.base.AbstractNamedEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User extends AbstractNamedEntity  implements GrantedAuthority {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "password")
    private String password;

    @Column(name = "irps_id")
    private Integer irpsId;

    public User(){
    }

    public User(Integer id, String name, Role roleId, String password,Integer irpsId) {
        super(id, name);
        this.role = roleId;
        this.password = password;
        this.irpsId = irpsId;
    }

    public User(String name, Role roleId, String password, Integer irpsId) {
        super(name);
        this.role = roleId;
        this.password = password;
        this.irpsId = irpsId;
    }

    public Role getRole() {
        return role;
    }

    public void setRoleId(Role roleId) {
        this.role = roleId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIrpsId() {
        return irpsId;
    }

    public void setIrpsId(Integer irpsId) {
        this.irpsId = irpsId;
    }

    @Override
    public String getAuthority() {
        return getRole().getName();
    }
}