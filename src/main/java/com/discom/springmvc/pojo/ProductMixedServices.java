package com.discom.springmvc.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "productmixedservice")
public class ProductMixedServices {

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

    @Column(name = "listing_type")
    private String listingType;

    @Column(name = "listing_duration")
    private Integer listingDuration;

    @Column(name = "featured")
    private Integer featured;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "featured_status")
    private Boolean featuredStatus;

    @Column(name = "priority_status")
    private Boolean priorityStatus;

    @Column(name = "numberPictures")
    private Integer numberPictures;

    @Column(name = "vidio")
    private Boolean vidio;


    @Column(name = "listing_currently_allSubscribed")
    private Boolean listingPropertiesCurrentlyAllSubscribed;

    @Column(name = "listing_newly_subscribed")
    private Boolean listingPropertiesNewlySubscribed;


    @Column(name = "open_resume_numberofview")
    private Integer openResumeNumberOfView;

    @Column(name = "view_resume_numberofview")
    private Integer viewResumeNumberOfView;

    @Column(name = "open_resume_details_numberofview")
    private Integer viewResumeDetailsNumberOfView;

    @Column(name = "open_resume_contact_numberofview")
    private Integer viewResumeContactNumberOfView;

    @Column(name = "listing_access_settings_currently_allSubscribed")
    private Boolean listingsAccessSettingsCurrentlyAllSubscribed;

    @Column(name = "listing_access_settings_newly_subscribed")
    private Boolean listingsAccessSettingsNewlySubscribed;


    @Column(name = "price")
    private Double price;

    @Column(name = "number_listing")
    private Integer numberListing;

    @Column(name = "renewal_prices")
    private Integer renewalPrices;

    @Column(name = "upgrade_featured_listing_price")
    private Integer upgradeFeaturedListingPrice;

    @Column(name = "upgrade_priority_listing_price")
    private Integer upgradePriorityListingPrice;

    @Column(name = "pricing_currently_allSubscribed")
    private Boolean pricingCurrentlyAllSubscribed;

    @Column(name = "pricing_newly_subscribed")
    private Boolean pricingNewlySubscribed;


    @Column(name = "expire_after_day")
    private Integer expireafterDay;

    @Column(name = "productExpiration_currently_allSubscribed")
    private Boolean productExpirationCurrentlyAllSubscribed;

    @Column(name = "productExpiration_newly_subscribed")
    private Boolean productExpirationNewlySubscribed;

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

    public String getListingType() {
        return listingType;
    }

    public void setListingType(String listingType) {
        this.listingType = listingType;
    }

    public Integer getListingDuration() {
        return listingDuration;
    }

    public void setListingDuration(Integer listingDuration) {
        this.listingDuration = listingDuration;
    }

    public Integer getFeatured() {
        return featured;
    }

    public void setFeatured(Integer featured) {
        this.featured = featured;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }


    public Boolean getVidio() {
        return vidio;
    }

    public void setVidio(Boolean vidio) {
        this.vidio = vidio;
    }


    public Boolean getListingPropertiesCurrentlyAllSubscribed() {
        return listingPropertiesCurrentlyAllSubscribed;
    }

    public void setListingPropertiesCurrentlyAllSubscribed(Boolean listingPropertiesCurrentlyAllSubscribed) {
        this.listingPropertiesCurrentlyAllSubscribed = listingPropertiesCurrentlyAllSubscribed;
    }

    public Boolean getListingPropertiesNewlySubscribed() {
        return listingPropertiesNewlySubscribed;
    }

    public void setListingPropertiesNewlySubscribed(Boolean listingPropertiesNewlySubscribed) {
        this.listingPropertiesNewlySubscribed = listingPropertiesNewlySubscribed;
    }

    public Integer getNumberListing() {
        return numberListing;
    }

    public void setNumberListing(Integer numberListing) {
        this.numberListing = numberListing;
    }

    public Integer getRenewalPrices() {
        return renewalPrices;
    }

    public void setRenewalPrices(Integer renewalPrices) {
        this.renewalPrices = renewalPrices;
    }

    public Integer getUpgradeFeaturedListingPrice() {
        return upgradeFeaturedListingPrice;
    }

    public void setUpgradeFeaturedListingPrice(Integer upgradeFeaturedListingPrice) {
        this.upgradeFeaturedListingPrice = upgradeFeaturedListingPrice;
    }

    public Integer getUpgradePriorityListingPrice() {
        return upgradePriorityListingPrice;
    }

    public void setUpgradePriorityListingPrice(Integer upgradePriorityListingPrice) {
        this.upgradePriorityListingPrice = upgradePriorityListingPrice;
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

    public Integer getExpireafterDay() {
        return expireafterDay;
    }

    public void setExpireafterDay(Integer expireafterDay) {
        this.expireafterDay = expireafterDay;
    }

    public Boolean getProductExpirationCurrentlyAllSubscribed() {
        return productExpirationCurrentlyAllSubscribed;
    }

    public void setProductExpirationCurrentlyAllSubscribed(Boolean productExpirationCurrentlyAllSubscribed) {
        this.productExpirationCurrentlyAllSubscribed = productExpirationCurrentlyAllSubscribed;
    }

    public Boolean getProductExpirationNewlySubscribed() {
        return productExpirationNewlySubscribed;
    }

    public void setProductExpirationNewlySubscribed(Boolean productExpirationNewlySubscribed) {
        this.productExpirationNewlySubscribed = productExpirationNewlySubscribed;
    }

    public Boolean getUserScreeningOption() {
        return userScreeningOption;
    }

    public void setUserScreeningOption(Boolean userScreeningOption) {
        this.userScreeningOption = userScreeningOption;
    }

    public String getQuestionnaires() {
        return questionnaires;
    }

    public void setQuestionnaires(String questionnaires) {
        this.questionnaires = questionnaires;
    }

    public Boolean getCreateSubAccountOption() {
        return createSubAccountOption;
    }

    public void setCreateSubAccountOption(Boolean createSubAccountOption) {
        this.createSubAccountOption = createSubAccountOption;
    }

    public String getCreateSubQuestionnaires() {
        return createSubQuestionnaires;
    }

    public void setCreateSubQuestionnaires(String createSubQuestionnaires) {
        this.createSubQuestionnaires = createSubQuestionnaires;
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


    public Boolean getFeaturedStatus() {
        return featuredStatus;
    }

    public void setFeaturedStatus(Boolean featuredStatus) {
        this.featuredStatus = featuredStatus;
    }

    public Boolean getPriorityStatus() {
        return priorityStatus;
    }

    public void setPriorityStatus(Boolean priorityStatus) {
        this.priorityStatus = priorityStatus;
    }


    public Integer getNumberPictures() {
        return numberPictures;
    }

    public void setNumberPictures(Integer numberPictures) {
        this.numberPictures = numberPictures;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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
