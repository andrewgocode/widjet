package ru.sb.statistics.model;

import org.springframework.security.core.GrantedAuthority;
import ru.sb.statistics.model.base.AbstractNamedEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends AbstractNamedEntity {
    public Role(){

    }
}