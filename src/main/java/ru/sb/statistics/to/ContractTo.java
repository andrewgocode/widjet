package ru.sb.statistics.to;

public class ContractTo extends BaseTo {
    private String name;

    private String inn;

    private String epsIds;

    private String epsIdIn;

    private String quantityEpsId;

    private Long sum;

    private Long quantity;

    private String reestrMask;

    private Integer user;

    public ContractTo() {
    }

    public ContractTo(String name, String inn, String epsIds, String epsIdIn, String quantityEpsId, Long sum, Long quantity, String reestrMask, Integer user) {
        this.name = name;
        this.inn = inn;
        this.epsIds = epsIds;
        this.epsIdIn = epsIdIn;
        this.quantityEpsId = quantityEpsId;
        this.sum = sum;
        this.quantity = quantity;
        this.reestrMask = reestrMask;
        this.user = user;
    }

    public ContractTo(Integer id, String name, String inn, String epsIds, String epsIdIn, String quantityEpsId, Long sum, Long quantity, String reestrMask, Integer user) {
        super(id);
        this.name = name;
        this.inn = inn;
        this.epsIds = epsIds;
        this.epsIdIn = epsIdIn;
        this.quantityEpsId = quantityEpsId;
        this.sum = sum;
        this.quantity = quantity;
        this.reestrMask = reestrMask;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }
}
