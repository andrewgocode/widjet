package ru.sb.statistics;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;

public interface HasId  extends Serializable {
    Integer getId();

    void setId(Integer id);

    @JsonIgnore
    default boolean isNew() { return getId() == null; }
}