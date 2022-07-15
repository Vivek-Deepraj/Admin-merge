package com.discom.springmvc.pojo;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "productmaster")
public class ProductMaster {

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
    @Column(name = "listing_type")
    private String listingType;
    @Column(name = "listing_duration")
    private Integer listingDuration;
    @Column(name = "featured")
    private Integer featured;
    @Column(name = "priority")
    private Integer priority;
    @Column(name = "numberPictures")
    private Integer numberPictures;
    @Column(name = "vidio")
    private Boolean vidio;
    @Column(name = "anonymousJob")
    private Boolean anonymousJob;
    @Column(name = "anonymousResume")
    private Boolean anonymousResume;
    @Column(name = "listing_currently_allSubscribed")
    private Boolean listingPropertiesCurrentlyAllSubscribed;
    @Column(name = "listing_newly_subscribed")
    private Boolean listingPropertiesNewlySubscribed;
    @Column(name = "fixed_pricing")
    private Boolean fixedPricing;
    @Column(name = "price")
    private Integer price;
    @Column(name = "volume_based_pricing")
    private Boolean volumeBasedPricing;
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
    @Column(name = "from_d")
    private Integer fromD;
    @Column(name = "to_d")
    private Integer toD;
    @Column(name = "perUnit_prices")
    private Integer perUnitPrices;
    @Column(name = "renewal_price")
    private Integer renewalPrice;
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

    public Integer getNumberPictures() {
        return numberPictures;
    }

    public void setNumberPictures(Integer numberPictures) {
        this.numberPictures = numberPictures;
    }

    public Boolean isVidio() {
        return vidio;
    }

    public Boolean isAnonymousJob() {
        return anonymousJob;
    }

    public Boolean isAnonymousResume() {
        return anonymousResume;
    }

    public Boolean isListingPropertiesCurrentlyAllSubscribed() {
        return listingPropertiesCurrentlyAllSubscribed;
    }

    public Boolean isListingPropertiesNewlySubscribed() {
        return listingPropertiesNewlySubscribed;
    }

    public Boolean isFixedPricing() {
        return fixedPricing;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean isVolumeBasedPricing() {
        return volumeBasedPricing;
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

    public Boolean isPricingCurrentlyAllSubscribed() {
        return pricingCurrentlyAllSubscribed;
    }

    public Boolean isPricingNewlySubscribed() {
        return pricingNewlySubscribed;
    }

    public Integer getPerUnitPrices() {
        return perUnitPrices;
    }

    public void setPerUnitPrices(Integer perUnitPrices) {
        this.perUnitPrices = perUnitPrices;
    }

    public Integer getRenewalPrice() {
        return renewalPrice;
    }

    public void setRenewalPrice(Integer renewalPrice) {
        this.renewalPrice = renewalPrice;
    }

    public Integer getExpireafterDay() {
        return expireafterDay;
    }

    public void setExpireafterDay(Integer expireafterDay) {
        this.expireafterDay = expireafterDay;
    }

    public Boolean isProductExpirationCurrentlyAllSubscribed() {
        return productExpirationCurrentlyAllSubscribed;
    }

    public Boolean isProductExpirationNewlySubscribed() {
        return productExpirationNewlySubscribed;
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

    public Integer getFromD() {
        return fromD;
    }

    public void setFromD(Integer fromD) {
        this.fromD = fromD;
    }

    public Integer getToD() {
        return toD;
    }

    public void setToD(Integer toD) {
        this.toD = toD;
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

    public Boolean getVidio() {
        return vidio;
    }

    public void setVidio(Boolean vidio) {
        this.vidio = vidio;
    }

    public Boolean getAnonymousJob() {
        return anonymousJob;
    }

    public void setAnonymousJob(Boolean anonymousJob) {
        this.anonymousJob = anonymousJob;
    }

    public Boolean getAnonymousResume() {
        return anonymousResume;
    }

    public void setAnonymousResume(Boolean anonymousResume) {
        this.anonymousResume = anonymousResume;
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

    public Boolean getFixedPricing() {
        return fixedPricing;
    }

    public void setFixedPricing(Boolean fixedPricing) {
        this.fixedPricing = fixedPricing;
    }

    public Boolean getVolumeBasedPricing() {
        return volumeBasedPricing;
    }

    public void setVolumeBasedPricing(Boolean volumeBasedPricing) {
        this.volumeBasedPricing = volumeBasedPricing;
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
