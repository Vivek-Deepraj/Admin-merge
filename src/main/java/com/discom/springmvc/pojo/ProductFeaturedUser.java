package com.discom.springmvc.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "productfeatureduser")
public class ProductFeaturedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "name")
    private String name;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "detailed_description")
    private String detailedDescription;

    @Column(name = "from_date")
    private Date fromDate;

    @Column(name = "to_date")
    private Date toDate;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_availability")
    private Boolean isAvailability;

    @Column(name = "general_currently_allSubscribed")
    private Boolean generalCurrentlyAllSubscribed;

    @Column(name = "general_newly_subscribed")
    private Boolean generalNewlySubscribed;

    @Column(name = "onetime_payment")
    private Boolean OneTimePayment;

    @Column(name = "recurring_subscription ")
    private Boolean recurringSubscription;

    @Column(name = "period")
    private Integer period;

    @Column(name = "price")
    private Double price;

    @Column(name = "pricing_allSubscribed")
    private Boolean pricingCurrentlyAllSubscribed;

    @Column(name = "pricing_subscribed")
    private Boolean pricingNewlySubscribed;

    @Column(name = "banner_group")
    private String bannerGroup;

    @Column(name = "required_width")
    private Integer requiredWidth;

    @Column(name = "required_height")
    private Integer requiredHeight;


    @Column(name = "additional_setting_allSubscribed")
    private Boolean additionalSettingCurrentlyAllSubscribed;

    @Column(name = "additional_setting_subscribed")
    private Boolean additionalSettingNewlySubscribed;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "updatedBy")
    private String updatedBy;

    @Column(name = "createdon")
    private Date createdon;

    @Column(name = "updatedon")
    private Date updatedon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsAvailability() {
        return isAvailability;
    }

    public void setIsAvailability(Boolean isAvailability) {
        this.isAvailability = isAvailability;
    }


    public Boolean getRecurringSubscription() {
        return recurringSubscription;
    }

    public void setRecurringSubscription(Boolean recurringSubscription) {
        this.recurringSubscription = recurringSubscription;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getGeneralCurrentlyAllSubscribed() {
        return generalCurrentlyAllSubscribed;
    }

    public void setGeneralCurrentlyAllSubscribed(Boolean generalCurrentlyAllSubscribed) {
        this.generalCurrentlyAllSubscribed = generalCurrentlyAllSubscribed;
    }

    public Boolean getGeneralNewlySubscribed() {
        return generalNewlySubscribed;
    }

    public void setGeneralNewlySubscribed(Boolean generalNewlySubscribed) {
        this.generalNewlySubscribed = generalNewlySubscribed;
    }


    public Boolean getOneTimePayment() {
        return OneTimePayment;
    }

    public void setOneTimePayment(Boolean oneTimePayment) {
        OneTimePayment = oneTimePayment;
    }

    public Boolean getPricingCurrentlyAllSubscribed() {
        return pricingCurrentlyAllSubscribed;
    }

    public void setPricingCurrentlyAllSubscribed(Boolean pricingCurrentlyAllSubscribed) {
        this.pricingCurrentlyAllSubscribed = pricingCurrentlyAllSubscribed;
    }

    public Boolean getPricingNewlySubscribed() {
        return pricingNewlySubscribed;
    }

    public void setPricingNewlySubscribed(Boolean pricingNewlySubscribed) {
        this.pricingNewlySubscribed = pricingNewlySubscribed;
    }

    public String getBannerGroup() {
        return bannerGroup;
    }

    public void setBannerGroup(String bannerGroup) {
        this.bannerGroup = bannerGroup;
    }

    public Integer getRequiredWidth() {
        return requiredWidth;
    }

    public void setRequiredWidth(Integer requiredWidth) {
        this.requiredWidth = requiredWidth;
    }

    public Integer getRequiredHeight() {
        return requiredHeight;
    }

    public void setRequiredHeight(Integer requiredHeight) {
        this.requiredHeight = requiredHeight;
    }

    public Boolean getAdditionalSettingCurrentlyAllSubscribed() {
        return additionalSettingCurrentlyAllSubscribed;
    }

    public void setAdditionalSettingCurrentlyAllSubscribed(Boolean additionalSettingCurrentlyAllSubscribed) {
        this.additionalSettingCurrentlyAllSubscribed = additionalSettingCurrentlyAllSubscribed;
    }

    public Boolean getAdditionalSettingNewlySubscribed() {
        return additionalSettingNewlySubscribed;
    }

    public void setAdditionalSettingNewlySubscribed(Boolean additionalSettingNewlySubscribed) {
        this.additionalSettingNewlySubscribed = additionalSettingNewlySubscribed;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    public Date getUpdatedon() {
        return updatedon;
    }

    public void setUpdatedon(Date updatedon) {
        this.updatedon = updatedon;
    }


}
