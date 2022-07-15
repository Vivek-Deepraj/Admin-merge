package com.discom.springmvc.crudapi;

import com.discom.springmvc.dao.MultiActionDao;
import com.discom.springmvc.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class DeleteController {

    @Autowired
    MultiActionDao multiActionDao;

    @PostMapping("delete" + "Countrymaster" + "/{id}")
    public boolean delete(@PathVariable("id") int id, @RequestBody Countrymaster entity) {

        entity.setId(Long.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @PostMapping("delete" + "Jobpostfields" + "/{id}")
    public boolean delete(@PathVariable("id") int id, @RequestBody Jobpostfields entity) {

        entity.setId(Long.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @PostMapping("delete" + "Resumefields" + "/{id}")
    public boolean delete(@PathVariable("id") int id, @RequestBody Resumefields entity) {

        entity.setId(Long.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @PostMapping("delete" + "Templates" + "/{id}")
    public boolean delete(@PathVariable("id") int id, @RequestBody Templates entity) {

        entity.setId(Long.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @PostMapping("delete" + "TemplateGroups" + "/{id}")
    public boolean delete(@PathVariable("id") int id, @RequestBody TemplateGroups entity) {

        entity.setId(Long.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @PostMapping("delete" + "TemplateGroupsFields" + "/{id}")
    public boolean delete(@PathVariable("id") int id, @RequestBody TemplateGroupsFields entity) {

        entity.setId(Long.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @PostMapping("delete" + "TemplateGroupsFieldsChilds" + "/{id}")
    public boolean delete(@PathVariable("id") int id, @RequestBody TemplateGroupsFieldsChilds entity) {

        entity.setId(Long.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @PostMapping("delete" + "TemplateGroupsFieldsValidators" + "/{id}")
    public boolean delete(@PathVariable("id") int id, @RequestBody TemplateGroupsFieldsValidators entity) {

        entity.setId(Long.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @PostMapping("delete" + "CandidateWatchdogPlans" + "/{id}")
    public boolean delete(@PathVariable("id") int id, @RequestBody CandidateWatchdogPlans entity) {

        entity.setId(Integer.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @PostMapping("delete" + "CandidateResumebroadcastPlans" + "/{id}")
    public boolean delete(@PathVariable("id") int id, @RequestBody CandidateResumebroadcastPlans entity) {

        entity.setId(Integer.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @PostMapping("delete" + "CandidateQuickresumebroadcastPlans" + "/{id}")
    public boolean delete(@PathVariable("id") int id, @RequestBody CandidateQuickresumebroadcastPlans entity) {

        entity.setId(Integer.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @PostMapping("delete" + "CandidateEmailTemplates" + "/{id}")
    public boolean delete(@PathVariable("id") int id, @RequestBody CandidateEmailTemplates entity) {

        entity.setId(Integer.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @PostMapping("delete" + "CandidateSmsTemplates" + "/{id}")
    public boolean delete(@PathVariable("id") int id, @RequestBody CandidateSmsTemplates entity) {

        entity.setId(Integer.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @PostMapping("delete" + "CompanyEmailTemplates" + "/{id}")
    public boolean delete(@PathVariable("id") int id, @RequestBody CompanyEmailTemplates entity) {

        entity.setId(Integer.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @PostMapping("delete" + "CompanySmsTemplates" + "/{id}")
    public boolean delete(@PathVariable("id") int id, @RequestBody CompanySmsTemplates entity) {

        entity.setId(Integer.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @PostMapping("delete" + "Instituteregistrations" + "/{id}")
    public boolean delete(@PathVariable("id") int id, @RequestBody Instituteregistrations entity) {

        entity.setId(Integer.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @PostMapping("delete" + "Newscategory" + "/{id}")
    public boolean delete(@PathVariable("id") int id, @RequestBody Newscategory entity) {

        entity.setId(Long.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @PostMapping("delete" + "News" + "/{id}")
    public boolean delete(@PathVariable("id") int id, @RequestBody News entity) {

        entity.setId(Integer.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }
    //schduler

/*
    @PostMapping("delete" + "TemplateGroupsFieldsChilds" + "/{id}")
    public boolean delete(@PathVariable("id") int id, @RequestBody Resumedata entity) {

        entity.setId(Long.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }*/

    @PostMapping("delete" + "Contactjobships" + "/{id}")
    public boolean delete(@PathVariable("id") int id, @RequestBody Contactjobships entity) {

        entity.setId(Integer.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @PostMapping("delete" + "Companyjobposts" + "/{id}")
    public boolean delete(@PathVariable("id") int id, @RequestBody Companyjobposts entity) {

        entity.setId(Integer.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder1(entity);
    }

    @PostMapping("delete" + "Companytemplatejobposts" + "/{id}")
    public boolean delete(@PathVariable("id") int id, @RequestBody Companytemplatejobposts entity) {

        entity.setId(Integer.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @PostMapping("delete" + "Companyusers" + "/{id}")
    public boolean delete(@PathVariable("id") int id, @RequestBody Companyusers entity) {

        entity.setId(Integer.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @PostMapping("delete" + "Greetingrequests" + "/{id}")
    public boolean delete(@PathVariable("id") int id, @RequestBody Greetingrequests entity) {

        entity.setId(Integer.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @DeleteMapping("deleteProductList/{id}")
    public boolean deleteProductList(@PathVariable("id") String id) {
        ProductMaster entity = multiActionDao.getProductListByid(ProductMaster.class, id);
        entity.setId(Integer.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @DeleteMapping("deleteProductBanner/{id}")
    public boolean deleteProductBanner(@PathVariable("id") String id) {
        ProductBanner entity = multiActionDao.getProductBannerByid(ProductBanner.class, id);
        entity.setId(Integer.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @DeleteMapping("deleteProductFetauredUser/{id}")
    public boolean deleteProductFetauredUser(@PathVariable("id") String id) {
        ProductFeaturedUser entity = multiActionDao.getProductFeaturedUserByid(ProductFeaturedUser.class, id);
        entity.setId(Integer.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @DeleteMapping("deleteProductMixedService/{id}")
    public boolean deleteProductMixedService(@PathVariable("id") String id) {
        ProductMixedServices entity = multiActionDao.getProductMixedServiceByid(ProductMixedServices.class, id);
        entity.setId(Integer.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @DeleteMapping("deleteProductAccessList/{id}")
    public boolean deleteProductAccessList(@PathVariable("id") String id) {
        ProductAccessList entity = multiActionDao.getProductAccessListByid(ProductAccessList.class, id);
        entity.setId(Integer.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    java.sql.Timestamp getTimeStampDate() {
        Date saveDate = new Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        return timeStampDate;
    }
}