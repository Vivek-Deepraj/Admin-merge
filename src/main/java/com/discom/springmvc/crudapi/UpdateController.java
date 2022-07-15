package com.discom.springmvc.crudapi;

import com.discom.springmvc.dao.MultiActionDao;
import com.discom.springmvc.pojo.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class UpdateController {

    @Autowired
    MultiActionDao multiActionDao;

    @PostMapping("update" + "Countrymaster" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody Countrymaster entity) {

        entity.setId(Long.valueOf(id));
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("update" + "Jobpostfields" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody Jobpostfields entity) {

        entity.setId(Long.valueOf(id));
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("update" + "Resumefields" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody Resumefields entity) {

        entity.setId(Long.valueOf(id));
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("update" + "Templates" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody Templates entity) {

        entity.setId(Long.valueOf(id));
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("update" + "TemplateGroups" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody TemplateGroups entity) {

        entity.setId(Long.valueOf(id));
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("update" + "TemplateGroupsFields" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody TemplateGroupsFields entity) {

        entity.setId(Long.valueOf(id));
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("update" + "TemplateGroupsFieldsChilds" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody TemplateGroupsFieldsChilds entity) {

        entity.setId(Long.valueOf(id));
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("update" + "CandidateWatchdogPlans" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody CandidateWatchdogPlans entity) {

        entity.setId(Integer.valueOf(id));
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("update" + "CandidateResumebroadcastPlans" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody CandidateResumebroadcastPlans entity) {

        entity.setId(Integer.valueOf(id));
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("update" + "CandidateQuickresumebroadcastPlans" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody CandidateQuickresumebroadcastPlans entity) {

        entity.setId(Integer.valueOf(id));
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("update" + "CandidateEmailTemplates" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody CandidateEmailTemplates entity) {

        entity.setId(Integer.valueOf(id));
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("update" + "CandidateSmsTemplates" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody CandidateSmsTemplates entity) {

        entity.setId(Integer.valueOf(id));
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("update" + "CompanyEmailTemplates" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody CompanyEmailTemplates entity) {

        entity.setId(Integer.valueOf(id));
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("update" + "CompanySmsTemplates" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody CompanySmsTemplates entity) {

        entity.setId(Integer.valueOf(id));
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("update" + "Instituteregistrations" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody Instituteregistrations entity) {

        entity.setId(Integer.valueOf(id));
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("update" + "Newscategory" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody Newscategory entity) {

        entity.setId(Long.valueOf(id));
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("update" + "News" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody News entity) {

        entity.setId(Integer.valueOf(id));
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    java.sql.Timestamp getTimeStampDate() {
        Date saveDate = new Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        return timeStampDate;
    }

    //schedule


    @PostMapping("update" + "EmailMaster" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody EmailMaster entity) {

        //entity.setId(Long.valueOf(id));
        //entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("update" + "Resumedata" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody Resumedata entity) {

        entity.setId(Long.valueOf(id));
        //entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("update" + "Companyprofiles" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody Companyprofiles entity) {

        entity.setId(Integer.valueOf(id));
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("update" + "Contactjobships" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody Contactjobships entity) {

        entity.setId(Integer.valueOf(id));
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("update" + "Companyjobposts" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody JobPost entity) throws ParseException {
        Integer jobPostId = Integer.valueOf(id);
        entity.setId(Integer.valueOf(id));
        entity.setUpdatedon(getTimeStampDate());

        if (entity.isIsactive() == true) {
            entity.setIsactive(true);
        } else {
            entity.setIsactive(false);
        }

        //Parent table data insertion
        ObjectMapper oMapper = new ObjectMapper();
        Map<String, Object> mainObj = oMapper.convertValue(entity, Map.class);
        Object obj = mainObj.get("data");

        Map<String, Object> dataJobPosts = oMapper.convertValue(obj, Map.class);
        dataJobPosts.remove("jobDetails");

        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = inputFormat.parse(dataJobPosts.get("job_post_start_date").toString());
        String startDate = outputFormat.format(date);

        Date endDate = inputFormat.parse(dataJobPosts.get("job_post_end_date").toString());
        String formattedEndDate = outputFormat.format(endDate);

        mainObj.put("com_name", dataJobPosts.get("com_name"));
        mainObj.put("job_post_start_date", startDate);
        mainObj.put("job_post_end_date", formattedEndDate);
        mainObj.remove("data");
        Companyjobposts anotherBean = oMapper.convertValue(mainObj, Companyjobposts.class);
        boolean mainDataUpdate = multiActionDao.executePojoUpdateObject(anotherBean);

        boolean updateData = multiActionDao.executePojoDeleteObjectBuilder2(anotherBean);

        //Child table record insertion
        if (updateData) {
            Map<String, Object> childObj = oMapper.convertValue(entity, Map.class);
            Object childJobPostObj = childObj.get("data");

            Map<String, Object> dataObject = oMapper.convertValue(childJobPostObj, Map.class);
            //dataObject.put("companyjobpostid", jobPostId);
            dataObject.remove("com_name");
            dataObject.remove("job_post_start_date");
            dataObject.remove("job_post_end_date");

            Object JobPostDetails = dataObject.get("jobDetails");
            int flag = 0;
            List<Map<String, Object>> jobObj = oMapper.convertValue(JobPostDetails, new TypeReference<List<Map<String, Object>>>() {
            });
            for (Map<String, Object> jobPostMap : jobObj) {
                Set set = jobPostMap.entrySet();
                for (Object objSet : set) {
                    Map.Entry<String, Object> m = (Map.Entry<String, Object>) objSet;
                    CompanyjobpostsDetails comJobPost = new CompanyjobpostsDetails();
                    comJobPost.setCompanyjobpostid(jobPostId);
                    comJobPost.setTemplatecode(entity.getTemplatecode());
                    comJobPost.setTemplatetype(entity.getTemplatetype());
                    comJobPost.setCreatedby(entity.getCreatedby());
                    comJobPost.setUpdatedby(entity.getUpdatedby());
                    comJobPost.setJobPostkey(m.getKey());
                    comJobPost.setFlag(flag);
                    comJobPost.setJobPostvalue(m.getValue().toString());
                    comJobPost.setUserid(entity.getUserid());
                    comJobPost.setId(entity.getId());
                    comJobPost.setCreatedon(getTimeStampDate());
                    comJobPost.setUpdatedon(getTimeStampDate());
                    comJobPost.setIsactive(true);
                    multiActionDao.executePojoSaveObjectBuilder(comJobPost);
                }
                flag = flag + 1;
            }
            return true;
        }
        return false;


    }

    @PostMapping("changeStatusOf" + "Companyjobposts" + "/{id}/{status}")
    public boolean enableCompanyJobPost(@PathVariable("id") String id, @PathVariable("status") boolean status) {
        Companyjobposts entity = (Companyjobposts) multiActionDao.getCompanyjobpostByid(Companyjobposts.class, id);
        entity.setIsactive(status);
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("update" + "Companytemplatejobposts" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody Companytemplatejobposts entity) {

        entity.setId(Integer.valueOf(id));
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("update" + "Companyletter" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody Companyletter entity) {

        entity.setId(Integer.valueOf(id));
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("update" + "Companyusers" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody Companyusers entity) {

        entity.setId(Integer.valueOf(id));
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("update" + "Greetingrequests" + "/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody Greetingrequests entity) {

        entity.setId(Integer.valueOf(id));
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }
}