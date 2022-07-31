package com.DC.app.database.Models;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;



@Entity

@SQLDelete(sql = "UPDATE asset_details SET asset_status = 'Deleted' WHERE assetID=?")
@Where(clause = "asset_status!='Deleted'")
public class AssetDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long assetID;
    @OneToMany(targetEntity = VisitDetails.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "av_fk", referencedColumnName = "assetID")
    private List<VisitDetails> visitDetailsSet;
    @Column
    @NotNull
    private String UPRN;
    @Column
    private String addressOne;
    @Column
    private String addressTwo;
    @Column
    private String postcode;
    @Column
    @Enumerated(EnumType.STRING)
    private assetStatus assetStatus;

    public long getAssetID() {
        return assetID;
    }

    public void setAssetID(long assetID) {
        this.assetID = assetID;
    }

    public String getUPRN() {
        return UPRN;
    }


    public void setUPRN(String UPRN) {
            this.UPRN = UPRN;
    }

    public String getAddressOne() {
        return addressOne;
    }

    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }

    public String getPostcode() {
        return postcode;
    }
    //Use regex to validate postcode input
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    public assetStatus getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(assetStatus assetStatus) {
        this.assetStatus = assetStatus;
    }

    public enum assetStatus {
        ACTIVE, DELETED, UNKNOWN
    }


}
