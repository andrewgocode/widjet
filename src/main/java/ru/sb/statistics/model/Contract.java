package ru.sb.statistics.model;

import ru.sb.statistics.model.base.AbstractNamedEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "contracts")
public class Contract extends AbstractNamedEntity {
    @Column(name = "inn")
    private String inn;

    @Column(name = "eps_ids")
    private String epsIds;

    @Column(name = "eps_id_in")
    private String epsIdIn;

    @Column(name = "quantity_eps_id")
    private String quantityEpsId;

    @Column(name = "sum")
    private Long sum;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "reestr_mask")
    private String reestrMask;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Contract() {
    }

    public Contract(Integer id, String name, String inn, String epsIds, String epsIdIn, String quantityEpsId, Long sum, Long quantity, String reestrMask, User user) {
        super(id, name);
        this.inn = inn;
        this.epsIds = epsIds;
        this.epsIdIn = epsIdIn;
        this.quantityEpsId = quantityEpsId;
        this.sum = sum;
        this.quantity = quantity;
        this.reestrMask = reestrMask;
        this.user = user;
    }

    public Contract(String name, String inn, String epsIds, String epsIdIn, String quantityEpsId, Long sum, Long quantity, String reestrMask, User user) {
        super(name);
        this.inn = inn;
        this.epsIds = epsIds;
        this.epsIdIn = epsIdIn;
        this.quantityEpsId = quantityEpsId;
        this.sum = sum;
        this.quantity = quantity;
        this.reestrMask = reestrMask;
        this.user = user;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getEpsIds() {
        return epsIds;
    }

    public void setEpsIds(String epsIds) {
        this.epsIds = epsIds;
    }

    public String getEpsIdIn() {
        return epsIdIn;
    }

    public void setEpsIdIn(String epsIdIn) {
        this.epsIdIn = epsIdIn;
    }

    public String getQuantityEpsId() {
        return quantityEpsId;
    }

    public void setQuantityEpsId(String quantityEpsId) {
        this.quantityEpsId = quantityEpsId;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getReestrMask() {
        return reestrMask;
    }

    public void setReestrMask(String reestrMask) {
        this.reestrMask = reestrMask;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
