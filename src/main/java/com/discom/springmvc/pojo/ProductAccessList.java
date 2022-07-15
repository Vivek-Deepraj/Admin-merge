package com.discom.springmvc.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "productaccesslist")
public class ProductAccessList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    //@Column(name = "id")
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

    @Column(name = "createdon")
    private Date createdon;

    @Column(name = "updatedon")
    private Date updatedon;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "is_availability")
    private Boolean isAvailability;
    @Column(name = "general_currently_allSubscribed")
    private Boolean generalCurrentlyAllSubscribed;
    @Column(name = "general_newly_subscribed")
    private Boolean generalNewlySubscribed;
    @Column(name = "open_resume_numberofview")
    private Integer openResumeNumberOfView;
    @Column(name = "view_resume_numberofview")
    private Integer viewResumeNumberOfView;
    @Column(name = "open_resume_details_numberofview")
    private Integer viewResumeDetailsNumberOfView;
    @Column(name = "open_resume_contact_numberofview")
    private Integer viewResumeContactNumberOfView;
    @Column(name = "listing_currently_allSubscribed")
    private Boolean listingsAccessSettingsCurrentlyAllSubscribed;
    @Column(name = "listing_newly_subscribed")
    private Boolean listingsAccessSettingsNewlySubscribed;
    @Column(name = "oneTime_payment")
    private Boolean oneTimePayment;
    @Column(name = "recurring_subscription")
    private Boolean recurringSubscription;
    @Column(name = "priority")
    private Integer priority;
    @Column(name = "price")
    private Integer price;
    @Column(name = "pricing_currently_allSubscribed")
    private Boolean pricingCurrentlyAllSubscribed;
    @Column(name = "pricing_newly_subscribed")
    private Boolean pricingNewlySubscribed;
    @Column(name = "user_screening_option")
    private Boolean userScreeningOption;
    @Column(name = "questionnaires")
    private String questionnaires;
    @Column(name = "create_sub_account_option")
    private Boolean createSubAccountOption;
    @Column(name = "create_sub_questionnaires")
    private String createSubQuestionnaires;
    @Column(name = "additionalPermissions_currently_allSubscribed")
    private Boolean additionalPermissionsCurrentlyAllSubscribed;
    @Column(name = "additionalPermissions_newly_subscribed")
    private Boolean additionalPermissionsNewlySubscribed;
    @Column(name = "createdBy")
    private String createdBy;
    @Column(name = "updatedBy")
    private String updatedBy;

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

    public Integer getOpenResumeNumberOfView() {
        return openResumeNumberOfView;
    }

    public void setOpenResumeNumberOfView(Integer openResumeNumberOfView) {
        this.openResumeNumberOfView = openResumeNumberOfView;
    }

    public Integer getViewResumeNumberOfView() {
        return viewResumeNumberOfView;
    }

    public void setViewResumeNumberOfView(Integer viewResumeNumberOfView) {
        this.viewResumeNumberOfView = viewResumeNumberOfView;
    }

    public Integer getViewResumeDetailsNumberOfView() {
        return viewResumeDetailsNumberOfView;
    }

    public void setViewResumeDetailsNumberOfView(Integer viewResumeDetailsNumberOfView) {
        this.viewResumeDetailsNumberOfView = viewResumeDetailsNumberOfView;
    }

    public Integer getViewResumeContactNumberOfView() {
        return viewResumeContactNumberOfView;
    }

    public void setViewResumeContactNumberOfView(Integer viewResumeContactNumberOfView) {
        this.viewResumeContactNumberOfView = viewResumeContactNumberOfView;
    }

    public Boolean getListingsAccessSettingsCurrentlyAllSubscribed() {
        return listingsAccessSettingsCurrentlyAllSubscribed;
    }

    public void setListingsAccessSettingsCurrentlyAllSubscribed(Boolean listingsAccessSettingsCurrentlyAllSubscribed) {
        this.listingsAccessSettingsCurrentlyAllSubscribed = listingsAccessSettingsCurrentlyAllSubscribed;
    }

    public Boolean getListingsAccessSettingsNewlySubscribed() {
        return listingsAccessSettingsNewlySubscribed;
    }

    public void setListingsAccessSettingsNewlySubscribed(Boolean listingsAccessSettingsNewlySubscribed) {
        this.listingsAccessSettingsNewlySubscribed = listingsAccessSettingsNewlySubscribed;
    }

    public Boolean getOneTimePayment() {
        return oneTimePayment;
    }

    public void setOneTimePayment(Boolean oneTimePayment) {
        this.oneTimePayment = oneTimePayment;
    }

    public Boolean getRecurringSubscription() {
        return recurringSubscription;
    }

    public void setRecurringSubscription(Boolean recurringSubscription) {
        this.recurringSubscription = recurringSubscription;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean isAvailability() {
        return isAvailability;
    }

    public void setAvailability(Boolean isAvailability) {
        this.isAvailability = isAvailability;
    }

    public Boolean isGeneralCurrentlyAllSubscribed() {
        return generalCurrentlyAllSubscribed;
    }

    public Boolean isGeneralNewlySubscribed() {
        return generalNewlySubscribed;
    }

    public Boolean isPricingNewlySubscribed() {
        return pricingNewlySubscribed;
    }

    public Boolean isUserScreeningOption() {
        return userScreeningOption;
    }

    public String getQuestionnaires() {
        return questionnaires;
    }

    public void setQuestionnaires(String questionnaires) {
        this.questionnaires = questionnaires;
    }

    public Boolean isCreateSubAccountOption() {
        return createSubAccountOption;
    }

    public String getCreateSubQuestionnaires() {
        return createSubQuestionnaires;
    }

    public void setCreateSubQuestionnaires(String createSubQuestionnaires) {
        this.createSubQuestionnaires = createSubQuestionnaires;
    }

    public Boolean isAdditionalPermissionsCurrentlyAllSubscribed() {
        return additionalPermissionsCurrentlyAllSubscribed;
    }

    public Boolean isAdditionalPermissionsNewlySubscribed() {
        return additionalPermissionsNewlySubscribed;
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

    public Boolean getUserScreeningOption() {
        return userScreeningOption;
    }

    public void setUserScreeningOption(Boolean userScreeningOption) {
        this.userScreeningOption = userScreeningOption;
    }

    public Boolean getCreateSubAccountOption() {
        return createSubAccountOption;
    }

    public void setCreateSubAccountOption(Boolean createSubAccountOption) {
        this.createSubAccountOption = createSubAccountOption;
    }

    public Boolean getAdditionalPermissionsCurrentlyAllSubscribed() {
        return additionalPermissionsCurrentlyAllSubscribed;
    }

    public void setAdditionalPermissionsCurrentlyAllSubscribed(Boolean additionalPermissionsCurrentlyAllSubscribed) {
        this.additionalPermissionsCurrentlyAllSubscribed = additionalPermissionsCurrentlyAllSubscribed;
    }

    public Boolean getAdditionalPermissionsNewlySubscribed() {
        return additionalPermissionsNewlySubscribed;
    }

    public void setAdditionalPermissionsNewlySubscribed(Boolean additionalPermissionsNewlySubscribed) {
        this.additionalPermissionsNewlySubscribed = additionalPermissionsNewlySubscribed;
    }


}
