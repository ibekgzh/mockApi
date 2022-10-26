package kz.bekmat.getOrders.models;

import javax.persistence.*;

@Entity
@Table(name = "get_order")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "contract_number")
    private String contractNumber;

    @Column(name = "iin")
    private String iin;

    @Column(name = "is_have_discount")
    private boolean isHaveDiscount;

    @Column(name = "type_discount")
    private String typeOfDiscount;

    public Order() {
    }

    public Order(String contractNumber, String iin, boolean isHaveDiscount, String typeOfDiscount) {
        this.contractNumber = contractNumber;
        this.iin = iin;
        this.isHaveDiscount = isHaveDiscount;
        this.typeOfDiscount = typeOfDiscount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public boolean isHaveDiscount() {
        return isHaveDiscount;
    }

    public void setHaveDiscount(boolean haveDiscount) {
        isHaveDiscount = haveDiscount;
    }

    public String getTypeOfDiscount() {
        return typeOfDiscount;
    }

    public void setTypeOfDiscount(String typeOfDiscount) {
        this.typeOfDiscount = typeOfDiscount;
    }

    @Override
    public String toString() {
        return "ClientTransaction{" +
                "id=" + id +
                ", contractNumber='" + contractNumber + '\'' +
                ", iin='" + iin + '\''+
                ", isHaveDiscount=" + isHaveDiscount +
                ", typeOfDiscount='" + typeOfDiscount + '\'' +
                '}';
    }
}
