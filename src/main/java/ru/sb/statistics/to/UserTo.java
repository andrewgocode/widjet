package ru.sb.statistics.to;

public class UserTo extends BaseTo {
    private String name;

    private Integer role;

    private String password;

    private Integer irpsId;

    public UserTo(){
    }

    public UserTo(String name, Integer role, String password, Integer irpsId) {
        this.name = name;
        this.role = role;
        this.password = password;
        this.irpsId = irpsId;
    }

    public UserTo(Integer id, String name, Integer role, String password, Integer irpsId) {
        super(id);
        this.name = name;
        this.role = role;
        this.password = password;
        this.irpsId = irpsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
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
}
