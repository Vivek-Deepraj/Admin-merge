package com.discom.springmvc.controller;

import com.discom.springmvc.dao.MultiActionDao;
import com.discom.springmvc.model.DataTableModel;
import com.discom.springmvc.model.DateTimeQuantumModel;
import com.discom.springmvc.model.User;
import com.discom.springmvc.pojo.*;
import com.discom.springmvc.service.*;
import com.discom.springmvc.utils.ConvertDateFormat;
import com.discom.springmvc.utils.DataTablesTO;
import com.discom.springmvc.utils.UtilityClass;
import com.discom.springmvc.utils.XlsxWriter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TestMultiActionController {

    @Autowired
    MultiActionDao multiActionDao;
    @Autowired
    ListService listService;
    @Autowired
    AddService addService;
    ConvertDateFormat cdf = new ConvertDateFormat();
    //@Autowired
   // ApiService apiService;
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    RldcFileDownloadService rldcFileDownloadService;
    // Test/Perform all Actions on Studenttestentity entity
    // save update delete actions on pojo object
    @Autowired
    private HttpSession httpSession;

    @PostMapping("saveStudenttestentity")
    public boolean saveStudenttestentity(@RequestBody Studenttestentity entity) {

        entity.setUpdatedon(getTimeStampDate());
        entity.setCreatedon(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("updateStudenttestentity/{id}")
    public boolean updateStudenttestentity(@PathVariable("id") int id, @RequestBody Studenttestentity entity) {

        entity.setId(id);
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("deleteStudenttestentity/{id}")
    public boolean deleteStudenttestentity(@PathVariable("id") int id, @RequestBody Studenttestentity entity) {

        entity.setId(id);
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    // datalist/count of pojo object
    @RequestMapping(value = "/getStudenttestentityDataListJson")
    public @ResponseBody
    String getStudenttestentityDataListJson() throws JsonProcessingException {

        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(Studenttestentity.class);
        return new ObjectMapper().writeValueAsString(dataListObject);
    }

    @RequestMapping(value = "/getStudenttestentityDataListCountJson")
    public @ResponseBody
    String getStudenttestentityDataListCountJson() throws JsonProcessingException {

        int dataListCount = multiActionDao.executeDataListCountObjectBuilder(Studenttestentity.class);
        return new ObjectMapper().writeValueAsString(dataListCount);
    }

    // datalist/count of pojo object with search columns
    @RequestMapping(value = "/getSFStudenttestentityDataListJson")
    public @ResponseBody
    String getSFStudenttestentityDataListJson(@RequestParam("name") String name,
                                              @RequestParam("age") String age, @RequestParam("city") String city) throws JsonProcessingException {

        String cList[] = {"name", "age", "city"};// column name as in pojo not in database
        String vList[] = {name, age, city};// column values
        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(Studenttestentity.class, cList, vList);
        return new ObjectMapper().writeValueAsString(dataListObject);
    }

    @RequestMapping(value = "/getSFStudenttestentityDataListCountJson")
    public @ResponseBody
    String getSFStudenttestentityDataListCountJson(@RequestParam("name") String name,
                                                   @RequestParam("age") String age, @RequestParam("city") String city) throws JsonProcessingException {

        String cList[] = {"name", "age", "city"};// column name as in pojo not in database
        String vList[] = {name, age, city};// column values
        int dataListCount = multiActionDao.executeDataListCountObjectBuilder(Studenttestentity.class, cList, vList);
        return new ObjectMapper().writeValueAsString(dataListCount);
    }

    // pojo object search by columns
    @RequestMapping(value = "/getStudenttestentityPojoObjectJson")
    public @ResponseBody
    String getStudenttestentityPojoObjectJson(@RequestParam("id") String id)
            throws JsonProcessingException {

        String cList[] = {"id"};// column name as in pojo not in database
        String vList[] = {id};// column values
        // Class<?> pojoObject =
        // multiActionDao.executePojoObjectBuilder(Studenttestentity.class,cList,vList);
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Studenttestentity.class, cList, vList);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    // pojo object search by columns
    @RequestMapping(value = "/getStudenttestentityPojoObjectJsonn")
    public @ResponseBody
    String getStudenttestentityPojoObjectJsonn(@RequestParam("name") String name)
            throws JsonProcessingException {

        String cList[] = {"name"};// column name as in pojo not in database
        String vList[] = {name};// column values
        Class<?> pojoObject = multiActionDao.executePojoObjectBuilder(Studenttestentity.class, cList, vList);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    // pojo datalist with start and end globalsearch and specific search for
    // datatables
    @RequestMapping(value = "/getStudenttestentityDataTableJson")
    public @ResponseBody
    String getStudenttestentityDataTableJson(@RequestParam("sSearch") String sSearch,
                                             @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList)
            throws JsonProcessingException {

        String cList[] = {"name", "age", "city"};// column name as in pojo not in database
        String gscList[] = {"name", "age", "city", "pincode"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(Studenttestentity.class, start, length,
                sSearch, sList, cList, gscList);
        System.out.print(new ObjectMapper().writeValueAsString(dataModel));
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/export/getStudenttestentityDataTableJson", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> getStudenttestentityDataTableJsonExcel(HttpServletRequest request,
                                                             HttpServletResponse response, @RequestParam("sSearch") String sSearch,
                                                             @RequestParam("sList") String[] sList) throws Exception {

        String cList[] = {"name", "age", "city"};// column name as in pojo not in database
        String gscList[] = {"name", "age", "city", "pincode"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(Studenttestentity.class, 0, 1000000000,
                sSearch, sList, cList, gscList);
        List<?> dataList = dataModel.getEntities();
        String[] columns = {"Name", "Age", "City", "Pincode"};
        XSSFWorkbook workbook = null;
        byte[] contentReturn = null;
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"StudentTestEntityExport.xlsx\"");
        OutputStream out;
        workbook = (XSSFWorkbook) new XlsxWriter().buildExcelDocument2(new ObjectMapper().writeValueAsString(dataList),
                columns);
        out = response.getOutputStream();
        workbook.write(out);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.write(baos);
        // FileOutputStream outt = new FileOutputStream(new File("D:/excellll.xlsx"));
        // workbook.write(outt);
        // outt.close();
        // workbook.close();
        // ModelAndView modelAndView = new ModelAndView("userListView",
        // "userlist",dataList);
        contentReturn = baos.toByteArray();
        System.out.println(contentReturn);
        out.close();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
        return new ResponseEntity<byte[]>(contentReturn, headers, HttpStatus.OK);
    }

    // Test/Perform all Actions on User entity
    // save update delete actions on pojo object
    @PostMapping("saveUser")
    public boolean saveUser(@RequestBody User entity) {

        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("updateUser/{id}")
    public boolean updateUser(@PathVariable("id") int id, User entity) {

        entity.setId(id);
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @DeleteMapping("deleteUser/{id}")
    public boolean deleteUser(@PathVariable("id") int id, User entity) {

        entity.setId(id);
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    // datalist/count of pojo object
    @RequestMapping(value = "/getUserDataListJson")
    public @ResponseBody
    String getUserDataListJson() throws JsonProcessingException {

        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(Constantslistsdetails.class);
        return new ObjectMapper().writeValueAsString(dataListObject);
    }

    @RequestMapping(value = "/getUserDataListCountJson")
    public @ResponseBody
    String getUserDataListCountJson() throws JsonProcessingException {

        int dataListCount = multiActionDao.executeDataListCountObjectBuilder(Constantslistsdetails.class);
        return new ObjectMapper().writeValueAsString(dataListCount);
    }

    // datalist/count of pojo object with search columns
    @RequestMapping(value = "/getSFUserDataListJson")
    public @ResponseBody
    String getSFUserDataListJson(@RequestParam("userid") String userid,
                                 @RequestParam("email") String email) throws JsonProcessingException {

        String cList[] = {"userid", "email"};// column name as in pojo not in database
        String vList[] = {userid, email};// column values
        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(Constantslistsdetails.class, cList, vList);
        return new ObjectMapper().writeValueAsString(dataListObject);
    }

    @RequestMapping(value = "/getSFUserDataListCountJson")
    public @ResponseBody
    String getSFUserDataListCountJson(@RequestParam("userid") String userid,
                                      @RequestParam("email") String email) throws JsonProcessingException {

        String cList[] = {"userid", "email"};// column name as in pojo not in database
        String vList[] = {userid, email};// column values
        int dataListCount = multiActionDao.executeDataListCountObjectBuilder(Constantslistsdetails.class, cList, vList);
        return new ObjectMapper().writeValueAsString(dataListCount);
    }

    // pojo object search by columns
    @RequestMapping(value = "/getUserPojoObjectJson")
    public @ResponseBody
    String getUserPojoObjectJson(@RequestParam("userid") String userid)
            throws JsonProcessingException {

        String cList[] = {"userid"};// column name as in pojo not in database
        String vList[] = {userid};// column values
        Class<?> pojoObject = multiActionDao.executePojoObjectBuilder(Constantslistsdetails.class, cList, vList);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    // pojo datalist with start and end globalsearch and specific search for
    // datatables
    @RequestMapping(value = "/getUserDataTableJson")
    public @ResponseBody
    String getUserDataTableJson(@RequestParam("sSearch") String sSearch,
                                @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList)
            throws JsonProcessingException {

        String cList[] = {"userid", "email", "contactNo"};// column name as in pojo not in database
        String gscList[] = {"userid", "email", "contactNo"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(User.class, start, length, sSearch,
                sList, cList, gscList);
        System.out.print(new ObjectMapper().writeValueAsString(dataModel));
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    // State Entity

    @PostMapping("save" + "State")
    public boolean saveState(@RequestBody Statemaster entity) throws IOException {

        entity.setCreatedOn(getTimeStampDate());
        entity.setLastUpdated(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("update" + "State" + "/{id}")
    public boolean updateState(@PathVariable("id") int id, @RequestBody Statemaster entity) {

        entity.setStateMasterId(Long.valueOf(id));
        entity.setLastUpdated(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("delete" + "State" + "/{id}")
    public boolean deleteUser(@PathVariable("id") int id, @RequestBody Statemaster entity) {

        entity.setStateMasterId(Long.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    // datalist/count of pojo object
    @RequestMapping(value = "/get" + "State" + "DataListJson")
    public @ResponseBody
    String getStateDataListJson() throws JsonProcessingException {

        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(Statemaster.class);
        return new ObjectMapper().writeValueAsString(dataListObject);
    }

    @RequestMapping(value = "/get" + "State" + "DataListCountJson")
    public @ResponseBody
    String getStateDataListCountJson() throws JsonProcessingException {

        int dataListCount = multiActionDao.executeDataListCountObjectBuilder(Statemaster.class);
        return new ObjectMapper().writeValueAsString(dataListCount);
    }

    // datalist/count of pojo object with search columns
    @RequestMapping(value = "/getSF" + "State" + "DataListJson")
    public @ResponseBody
    String getSFStateDataListJson(@RequestParam("stateName") String stateName,
                                  @RequestParam("mainregionName") String mainregionName, @RequestParam("subRegionName") String subRegionName,
                                  @RequestParam("statecode") String statecode) throws JsonProcessingException {

        String cList[] = {"stateName", "mainregionName", "subRegionName", "statecode"};// column name as in pojo not
        // in database
        String vList[] = {stateName, mainregionName, subRegionName, statecode};// column values
        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(Statemaster.class, cList, vList);
        return new ObjectMapper().writeValueAsString(dataListObject);
    }

    @RequestMapping(value = "/getSF" + "State" + "DataListCountJson")
    public @ResponseBody
    String getSFStateDataListCountJson(@RequestParam("stateName") String stateName,
                                       @RequestParam("mainregionName") String mainregionName, @RequestParam("subRegionName") String subRegionName,
                                       @RequestParam("statecode") String statecode) throws JsonProcessingException {

        String cList[] = {"stateName", "mainregionName", "subRegionName", "statecode"};// column name as in pojo not
        // in database
        String vList[] = {stateName, mainregionName, subRegionName, statecode};// column values
        int dataListCount = multiActionDao.executeDataListCountObjectBuilder(Statemaster.class, cList, vList);
        return new ObjectMapper().writeValueAsString(dataListCount);
    }

    // pojo object search by columns
    @RequestMapping(value = "/get" + "State" + "PojoObjectJson")
    public @ResponseBody
    String getStatePojoObjectJson(@RequestParam("stateMasterId") String stateMasterId)
            throws JsonProcessingException {

        String cList[] = {"stateMasterId"};// column name as in pojo not in database
        String vList[] = {stateMasterId};// column values
        // Class<?> pojoObject =
        // multiActionDao.executePojoObjectBuilder(Studenttestentity.class,cList,vList);
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Statemaster.class, cList, vList);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "State" + "PojoObjectJsonBystateName")
    public @ResponseBody
    String getStatePojoObjectJsonstateName(@RequestParam("stateName") String stateName)
            throws JsonProcessingException {

        String cList[] = {"stateName"};// column name as in pojo not in database
        String vList[] = {stateName};// column values
        // Class<?> pojoObject =
        // multiActionDao.executePojoObjectBuilder(Studenttestentity.class,cList,vList);
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Statemaster.class, cList, vList);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    // pojo datalist with start and end globalsearch and specific search for
    // datatables
    @RequestMapping(value = "/get" + "State" + "DataTableJson")
    public @ResponseBody
    String getStateDataTableJson(@RequestParam("sSearch") String sSearch,
                                 @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList)
            throws JsonProcessingException {

        String cList[] = {"stateName", "mainregionName", "subRegionName", "statecode"};// column name as in pojo not
        // in database
        String gscList[] = {"stateName", "mainregionName", "subRegionName", "statecode"};// column name as in pojo not
        // in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(Statemaster.class, start, length,
                sSearch, sList, cList, gscList);

        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/export/get" + "State" + "DataTableJson", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> getStateDataTableJsonExcel(HttpServletRequest request,
                                                 HttpServletResponse response, @RequestParam("sSearch") String sSearch,
                                                 @RequestParam("sList") String[] sList) throws Exception {

        String cList[] = {"stateName", "mainregionName", "subRegionName", "statecode"};// column name as in pojo not
        // in database
        String gscList[] = {"stateName", "mainregionName", "subRegionName", "statecode"};// column name as in pojo not
        // in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(Statemaster.class, 0, 1000000000,
                sSearch, sList, cList, gscList);
        List<?> dataList = dataModel.getEntities();
        String[] columns = {"State Name", "Main Reagion", "Sub Region", "Active", "State Code", "State GST Code"};
        String[] columnskeys = {"stateName", "mainregionName", "subRegionName", "isActive", "statecode",
                "stategstcode"};
        XSSFWorkbook workbook = null;
        byte[] contentReturn = null;
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"StateEntityExport.xlsx\"");
        OutputStream out;
        workbook = (XSSFWorkbook) new XlsxWriter().buildExcelDocument(new ObjectMapper().writeValueAsString(dataList),
                columns, columnskeys);
        out = response.getOutputStream();
        workbook.write(out);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.write(baos);
        // FileOutputStream outt = new FileOutputStream(new File("D:/excellll.xlsx"));
        // workbook.write(outt);
        // outt.close();
        // workbook.close();
        // ModelAndView modelAndView = new ModelAndView("userListView",
        // "userlist",dataList);
        contentReturn = baos.toByteArray();
        System.out.println(contentReturn);
        out.close();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
        return new ResponseEntity<byte[]>(contentReturn, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/get" + "Company" + "DataTableJson")
    public @ResponseBody
    String getCompanyDataTableJson(@RequestParam("sSearch") String sSearch,
                                   @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList)
            throws JsonProcessingException {

        String cList[] = {"userid", "email", "contactNo"};// column name as in pojo not in database
        String gscList[] = {"userid", "email", "contactNo"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(Companymaster.class, start, length,
                sSearch, sList, cList, gscList);
        System.out.print(new ObjectMapper().writeValueAsString(dataModel));
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    // pojo object search by columns
    @RequestMapping(value = "/getCompanyEntityPojoObjectJson")
    public @ResponseBody
    String getCompanyEntityPojoObjectJson(@RequestParam("id") String id)
            throws JsonProcessingException {

        String cList[] = {"companyMasterId"};// column name as in pojo not in database
        String vList[] = {id};// column values
        // Class<?> pojoObject =
        // multiActionDao.executePojoObjectBuilder(Studenttestentity.class,cList,vList);
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Companymaster.class, cList, vList);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @PostMapping("saveCompany")
    public boolean saveCompany(@RequestBody Companymaster entity) {
        entity.setJoiningDate(cdf.dataBaseFmt(entity.getJoiningDate()));
        entity.setCompanyMasterId(null);
        entity.setCreatedOn(getTimeStampDate());
        entity.setLastUpdatedOn(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("update" + "Company" + "/{id}")
    public boolean updateCompany(@PathVariable("id") int id, @RequestBody Companymaster entity) {
        System.out.println("in update company " + entity.getJoiningDate());
        entity.setCompanyMasterId(Long.valueOf(id));
        entity.setLastUpdatedOn(getTimeStampDate());
        entity.setJoiningDate(cdf.dataBaseFmt(entity.getJoiningDate()));
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @RequestMapping(value = "/get" + "Portfolio" + "DataTableJson")
    public @ResponseBody
    String getPortfolioDataTableJson(@RequestParam("sSearch") String sSearch,
                                     @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList)
            throws JsonProcessingException {

        String cList[] = {"portfolioId", "email", "contactNo"};// column name as in pojo not in database
        String gscList[] = {"portfolioId", "email", "contactNo"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(Portfoliomaster.class, start, length,
                sSearch, sList, cList, gscList);
        System.out.print(new ObjectMapper().writeValueAsString(dataModel));
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    // pojo object search by columns
    @RequestMapping(value = "/getPortfolioEntityPojoObjectJson")
    public @ResponseBody
    String getPortfolioEntityPojoObjectJson(@RequestParam("id") String id)
            throws JsonProcessingException {

        String cList[] = {"portfolioMasterId"};// column name as in pojo not in database
        String vList[] = {id};// column values
        // Class<?> pojoObject =
        // multiActionDao.executePojoObjectBuilder(Studenttestentity.class,cList,vList);
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Portfoliomaster.class, cList, vList);
        Portfoliomaster portfoliomaster = (Portfoliomaster) pojoObject;
        String cList2[] = {"portfolioId"};
        String vList2[] = {id + ""};// column values
        Object pojoObject2 = multiActionDao.executePojoObjectBuilder2(Portfolioline.class, cList2, vList2);
        Portfolioline portfolioline = (Portfolioline) pojoObject2;
        portfoliomaster.setPointOfConnection(portfolioline.getLine());
        String cList1[] = {"portfoliomasterid"};// column name as in pojo not in database
        String vList1[] = {portfoliomaster.getPortfolioMasterId() + ""};// column values
        // Class<?> pojoObject =
        // multiActionDao.executePojoObjectBuilder(Studenttestentity.class,cList,vList);
        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(Portfoliodetails.class, cList1, vList1);
        // System.out.println("dataListObject size "+dataListObject.size());
        for (int i = 0; i < dataListObject.size(); i++) {
            Portfoliodetails portfoliodetails = (Portfoliodetails) dataListObject.get(i);
            // System.out.println("portfoliodetails "+portfoliodetails);
            if (portfoliodetails != null) { // System.out.println("portfoliodetails type "+portfoliodetails);
                if (portfoliodetails.getType().equals("Mobile") && portfoliodetails.getDtype().equals("Billing"))
                    portfoliomaster.setBillingMobile(portfoliodetails.getValue());
                if (portfoliodetails.getType().equals("Phone") && portfoliodetails.getDtype().equals("Billing"))
                    portfoliomaster.setBillingContact(portfoliodetails.getValue());
                if (portfoliodetails.getType().equals("Fax") && portfoliodetails.getDtype().equals("Billing"))
                    portfoliomaster.setBillingFax(portfoliodetails.getValue());
                if (portfoliodetails.getType().equals("Email") && portfoliodetails.getDtype().equals("Billing"))
                    portfoliomaster.setBillingEmail(portfoliodetails.getValue());

                if (portfoliodetails.getType().equals("Mobile") && portfoliodetails.getDtype().equals("Operation"))
                    portfoliomaster.setOperationMobile(portfoliodetails.getValue());
                if (portfoliodetails.getType().equals("Phone") && portfoliodetails.getDtype().equals("Operation"))
                    portfoliomaster.setOperationContact(portfoliodetails.getValue());
                if (portfoliodetails.getType().equals("Fax") && portfoliodetails.getDtype().equals("Operation"))
                    portfoliomaster.setOperationFax(portfoliodetails.getValue());
                if (portfoliodetails.getType().equals("Email") && portfoliodetails.getDtype().equals("Operation"))
                    portfoliomaster.setOperationEmail(portfoliodetails.getValue());

            }
        }
        return new ObjectMapper().writeValueAsString(portfoliomaster);
    }

    @PostMapping("savePortfolio")
    public boolean savePortfolio(@RequestBody Portfoliomaster entity) {

        String operationMobile, operationContact, operationEmail, operationFax;
        String billingMobile, billingContact, billingEmail, billingFax;
        operationMobile = entity.getOperationMobile();
        operationContact = entity.getOperationContact();
        operationEmail = entity.getOperationEmail();
        operationFax = entity.getOperationFax();
        billingMobile = entity.getBillingMobile();
        billingContact = entity.getBillingContact();
        billingEmail = entity.getBillingEmail();
        billingFax = entity.getBillingFax();
        Date saveDate = new Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());

        entity.setJoiningDate(cdf.dataBaseFmt(entity.getJoiningDate()));
        entity.setPortfolioMasterId(null);
        entity.setCreatedBy(getTimeStampDate());
        entity.setLastUpdated(getTimeStampDate());
        multiActionDao.executePojoSaveObjectBuilder(entity);
        long id = entity.getPortfolioMasterId();
        String s_id = id + "";
        String compid = entity.getCompanyName();
        // for(int i=0;i<portfoliolines.length;i++)
        {
            Portfolioline portfolioline = new Portfolioline();
            portfolioline.setPortfolioLineMasterId(null);
            portfolioline.setPortfolioId(s_id);
            portfolioline.setLastUpdated(timeStampDate);
            portfolioline.setLine(entity.getPointOfConnection());
            // portfolioline.setLastUpdatedBy(getUseremail());
            portfolioline.setCreatedOn(timeStampDate);
            // portfolioline.setCreatedBy(getUseremail());
            multiActionDao.executePojoSaveObjectBuilder(portfolioline);
            // addDao.addPortfolioLine(portfolioline);
        }
        // for(int i=0;i<mobile.length;i++)
        {
            Portfoliodetails portfoliodetails = new Portfoliodetails();
            portfoliodetails.setId(null);
            portfoliodetails.setPortfoliomasterid(s_id);
            portfoliodetails.setValue(billingMobile);
            portfoliodetails.setCompanyMasterId((compid));
            portfoliodetails.setType("Mobile");
            portfoliodetails.setDtype("Billing");

            multiActionDao.executePojoSaveObjectBuilder(portfoliodetails);
            // addDao.addBillingMobile(billingmobile);
        }

        // for(int i=0;i<phone.length;i++)
        {
            Portfoliodetails portfoliodetails = new Portfoliodetails();
            portfoliodetails.setId(null);
            portfoliodetails.setPortfoliomasterid(s_id);
            portfoliodetails.setValue(billingContact);
            portfoliodetails.setCompanyMasterId((compid));
            portfoliodetails.setType("Phone");
            portfoliodetails.setDtype("Billing");

            multiActionDao.executePojoSaveObjectBuilder(portfoliodetails);
            // addDao.addBillingPhone(billingphone);
        }
        // for(int i=0;i<fax.length;i++)
        {
            Portfoliodetails portfoliodetails = new Portfoliodetails();
            portfoliodetails.setId(null);
            portfoliodetails.setPortfoliomasterid(s_id);
            portfoliodetails.setValue(billingFax);
            portfoliodetails.setCompanyMasterId((compid));
            portfoliodetails.setType("Fax");
            portfoliodetails.setDtype("Billing");

            multiActionDao.executePojoSaveObjectBuilder(portfoliodetails);
            // addDao.addBillingFax(billingfax);
        }
        // for(int i=0;i<email.length;i++)
        {
            Portfoliodetails portfoliodetails = new Portfoliodetails();
            portfoliodetails.setId(null);
            portfoliodetails.setPortfoliomasterid(s_id);
            portfoliodetails.setValue(billingEmail);
            portfoliodetails.setCompanyMasterId((compid));
            portfoliodetails.setType("Email");
            portfoliodetails.setDtype("Billing");

            multiActionDao.executePojoSaveObjectBuilder(portfoliodetails);
            // addDao.addBillingEmail(billingemail);
        }

        // for(int i=0;i<mobile.length;i++)
        {
            Portfoliodetails portfoliodetails = new Portfoliodetails();
            portfoliodetails.setId(null);
            portfoliodetails.setPortfoliomasterid(s_id);
            portfoliodetails.setValue(operationMobile);
            portfoliodetails.setCompanyMasterId((compid));
            portfoliodetails.setType("Mobile");
            portfoliodetails.setDtype("Operation");

            multiActionDao.executePojoSaveObjectBuilder(portfoliodetails);
            // addDao.addOperationMobile(operationmobile);
        }

        // for(int i=0;i<phone.length;i++)
        {
            Portfoliodetails portfoliodetails = new Portfoliodetails();
            portfoliodetails.setId(null);
            portfoliodetails.setPortfoliomasterid(s_id);
            portfoliodetails.setValue(operationContact);
            portfoliodetails.setCompanyMasterId((compid));
            portfoliodetails.setType("Phone");
            portfoliodetails.setDtype("Operation");

            multiActionDao.executePojoSaveObjectBuilder(portfoliodetails);
            // addDao.addOperationPhone(operationphone);
        }
        // for(int i=0;i<fax.length;i++)
        {
            Portfoliodetails portfoliodetails = new Portfoliodetails();
            portfoliodetails.setId(null);
            portfoliodetails.setPortfoliomasterid(s_id);
            portfoliodetails.setValue(operationFax);
            portfoliodetails.setCompanyMasterId((compid));
            portfoliodetails.setType("Fax");
            portfoliodetails.setDtype("Operation");

            multiActionDao.executePojoSaveObjectBuilder(portfoliodetails);
            // addDao.addOperationFax(operationfax);
        }
        // for(int i=0;i<email.length;i++)
        {
            Portfoliodetails portfoliodetails = new Portfoliodetails();
            portfoliodetails.setId(null);
            portfoliodetails.setPortfoliomasterid(s_id);
            portfoliodetails.setValue(operationEmail);
            portfoliodetails.setCompanyMasterId((compid));
            portfoliodetails.setType("Email");
            portfoliodetails.setDtype("Operation");

            multiActionDao.executePojoSaveObjectBuilder(portfoliodetails);
            // addDao.addOperationEmail(billingemail);
        }

        return true;
    }

    @PostMapping("update" + "Portfolio" + "/{id}")
    public boolean updatePortfolio(@PathVariable("id") int id, @RequestBody Portfoliomaster entity) {
        System.out.println("in update Portfoliomaster " + entity.getJoiningDate());

        Date saveDate = new Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());

        entity.setPortfolioMasterId(Long.valueOf(id));
        entity.setCreatedBy(getTimeStampDate());
        entity.setJoiningDate(cdf.dataBaseFmt(entity.getJoiningDate()));
        String operationMobile, operationContact, operationEmail, operationFax;
        String billingMobile, billingContact, billingEmail, billingFax;
        operationMobile = entity.getOperationMobile();
        operationContact = entity.getOperationContact();
        operationEmail = entity.getOperationEmail();
        operationFax = entity.getOperationFax();
        billingMobile = entity.getBillingMobile();
        billingContact = entity.getBillingContact();
        billingEmail = entity.getBillingEmail();
        billingFax = entity.getBillingFax();
        String compid = entity.getCompanyName();
        multiActionDao.executePojoUpdateObjectBuilder(entity);
        String s_id = entity.getPortfolioMasterId() + "";
        {
            String cList[] = {"portfolioId"};
            String vList[] = {id + ""};// column values
            Object pojoObject = multiActionDao.executePojoObjectBuilder2(Portfolioline.class, cList, vList);
            Portfolioline portfolioline = (Portfolioline) pojoObject;

            portfolioline.setPortfolioId(s_id);
            portfolioline.setLastUpdated(timeStampDate);
            portfolioline.setLine(entity.getPointOfConnection());
            // portfolioline.setLastUpdatedBy(getUseremail());
            portfolioline.setCreatedOn(timeStampDate);
            // portfolioline.setCreatedBy(getUseremail());
            multiActionDao.executePojoUpdateObjectBuilder(portfolioline);
            // addDao.addPortfolioLine(portfolioline);
        }
        // for(int i=0;i<mobile.length;i++)
        {
            String cList[] = {"portfoliomasterid", "type", "dtype"};
            String vList[] = {s_id, "Mobile", "Billing"};// column values
            Object pojoObject = multiActionDao.executePojoObjectBuilder2(Portfoliodetails.class, cList, vList);
            Portfoliodetails portfoliodetails = (Portfoliodetails) pojoObject;

            portfoliodetails.setPortfoliomasterid(s_id);
            portfoliodetails.setValue(billingMobile);
            portfoliodetails.setCompanyMasterId((compid));
            portfoliodetails.setType("Mobile");
            portfoliodetails.setDtype("Billing");

            multiActionDao.executePojoUpdateObjectBuilder(portfoliodetails);
            // addDao.addBillingMobile(billingmobile);
        }

        // for(int i=0;i<phone.length;i++)
        {
            String cList[] = {"portfoliomasterid", "type", "dtype"};
            String vList[] = {s_id, "Phone", "Billing"};// column values
            Object pojoObject = multiActionDao.executePojoObjectBuilder2(Portfoliodetails.class, cList, vList);
            Portfoliodetails portfoliodetails = (Portfoliodetails) pojoObject;

            portfoliodetails.setPortfoliomasterid(s_id);
            portfoliodetails.setValue(billingContact);
            portfoliodetails.setCompanyMasterId((compid));
            portfoliodetails.setType("Phone");
            portfoliodetails.setDtype("Billing");

            multiActionDao.executePojoUpdateObjectBuilder(portfoliodetails);
            // addDao.addBillingPhone(billingphone);
        }
        // for(int i=0;i<fax.length;i++)
        {
            String cList[] = {"portfoliomasterid", "type", "dtype"};
            String vList[] = {s_id, "Fax", "Billing"};// column values
            Object pojoObject = multiActionDao.executePojoObjectBuilder2(Portfoliodetails.class, cList, vList);
            Portfoliodetails portfoliodetails = (Portfoliodetails) pojoObject;

            portfoliodetails.setPortfoliomasterid(s_id);
            portfoliodetails.setValue(billingFax);
            portfoliodetails.setCompanyMasterId((compid));
            portfoliodetails.setType("Fax");
            portfoliodetails.setDtype("Billing");

            multiActionDao.executePojoUpdateObjectBuilder(portfoliodetails);
            // addDao.addBillingFax(billingfax);
        }
        // for(int i=0;i<email.length;i++)
        {
            String cList[] = {"portfoliomasterid", "type", "dtype"};
            String vList[] = {s_id, "Email", "Billing"};// column values
            Object pojoObject = multiActionDao.executePojoObjectBuilder2(Portfoliodetails.class, cList, vList);
            Portfoliodetails portfoliodetails = (Portfoliodetails) pojoObject;

            portfoliodetails.setPortfoliomasterid(s_id);
            portfoliodetails.setValue(billingEmail);
            portfoliodetails.setCompanyMasterId((compid));
            portfoliodetails.setType("Email");
            portfoliodetails.setDtype("Billing");

            multiActionDao.executePojoUpdateObjectBuilder(portfoliodetails);
            // addDao.addBillingEmail(billingemail);
        }

        // for(int i=0;i<mobile.length;i++)
        {
            String cList[] = {"portfoliomasterid", "type", "dtype"};
            String vList[] = {s_id, "Mobile", "Operation"};// column values
            Object pojoObject = multiActionDao.executePojoObjectBuilder2(Portfoliodetails.class, cList, vList);
            Portfoliodetails portfoliodetails = (Portfoliodetails) pojoObject;

            portfoliodetails.setPortfoliomasterid(s_id);
            portfoliodetails.setValue(operationMobile);
            portfoliodetails.setCompanyMasterId((compid));
            portfoliodetails.setType("Mobile");
            portfoliodetails.setDtype("Operation");

            multiActionDao.executePojoUpdateObjectBuilder(portfoliodetails);
            // addDao.addOperationMobile(operationmobile);
        }

        // for(int i=0;i<phone.length;i++)
        {
            String cList[] = {"portfoliomasterid", "type", "dtype"};
            String vList[] = {s_id, "Phone", "Operation"};// column values
            Object pojoObject = multiActionDao.executePojoObjectBuilder2(Portfoliodetails.class, cList, vList);
            Portfoliodetails portfoliodetails = (Portfoliodetails) pojoObject;

            portfoliodetails.setPortfoliomasterid(s_id);
            portfoliodetails.setValue(operationContact);
            portfoliodetails.setCompanyMasterId((compid));
            portfoliodetails.setType("Phone");
            portfoliodetails.setDtype("Operation");

            multiActionDao.executePojoUpdateObjectBuilder(portfoliodetails);
            // addDao.addOperationPhone(operationphone);
        }
        // for(int i=0;i<fax.length;i++)
        {
            String cList[] = {"portfoliomasterid", "type", "dtype"};
            String vList[] = {s_id, "Fax", "Operation"};// column values
            Object pojoObject = multiActionDao.executePojoObjectBuilder2(Portfoliodetails.class, cList, vList);
            Portfoliodetails portfoliodetails = (Portfoliodetails) pojoObject;

            portfoliodetails.setPortfoliomasterid(s_id);
            portfoliodetails.setValue(operationFax);
            portfoliodetails.setCompanyMasterId((compid));
            portfoliodetails.setType("Fax");
            portfoliodetails.setDtype("Operation");

            multiActionDao.executePojoUpdateObjectBuilder(portfoliodetails);
            // addDao.addOperationFax(operationfax);
        }
        // for(int i=0;i<email.length;i++)
        {
            String cList[] = {"portfoliomasterid", "type", "dtype"};
            String vList[] = {s_id, "Email", "Operation"};// column values
            Object pojoObject = multiActionDao.executePojoObjectBuilder2(Portfoliodetails.class, cList, vList);
            Portfoliodetails portfoliodetails = (Portfoliodetails) pojoObject;

            portfoliodetails.setPortfoliomasterid(s_id);
            portfoliodetails.setValue(operationEmail);
            portfoliodetails.setCompanyMasterId((compid));
            portfoliodetails.setType("Email");
            portfoliodetails.setDtype("Operation");

            multiActionDao.executePojoUpdateObjectBuilder(portfoliodetails);
            // addDao.addOperationEmail(billingemail);
        }
        return true;
    }

    @RequestMapping(value = "/get" + "Company" + "DataListJson")
    public @ResponseBody
    String getCompanyDataListJson() throws JsonProcessingException {

        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(Companymaster.class);
        return new ObjectMapper().writeValueAsString(dataListObject);
    }

    // Agreement
    @RequestMapping(value = "/get" + "Agreement" + "DataTableJson")
    public @ResponseBody
    String getAgreementDataTableJson(@RequestParam("sSearch") String sSearch,
                                     @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList)
            throws JsonProcessingException {

        String cList[] = {"portfolioId", "email", "contactNo"};// column name as in pojo not in database
        String gscList[] = {"portfolioId", "email", "contactNo"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableAgreementObjectBuilder(Agreementmaster.class, start,
                length, sSearch, sList, cList, gscList);

        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @PostMapping("saveAgreement")
    public boolean saveAgreement(@RequestBody Agreementmaster entity) {
        System.out.println("In agreement master saving");
        System.out.println("parentId = " + entity.getParentAgreementMasterId());
        try {
            entity.setStratDate(cdf.dataBaseFmt(entity.getStratDate()));
            entity.setEndDate(cdf.dataBaseFmt(entity.getEndDate()));
            entity.setAgreementMasterId(new Long(0));
            entity.setCreatedOn(getTimeStampDate());
            entity.setUpdatedon(getTimeStampDate());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }


    @PostMapping("saveSubAgreement")
    public boolean saveSubAgreement(@RequestBody Agreementmaster entity) {
        System.out.println("In sub agreement master saving");
        System.out.println("parentId = " + entity.getParentAgreementMasterId());
        try {
            entity.setStratDate(cdf.dataBaseFmt(entity.getStratDate()));
            entity.setEndDate(cdf.dataBaseFmt(entity.getEndDate()));
            entity.setCreatedOn(getTimeStampDate());
            entity.setUpdatedon(getTimeStampDate());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("update" + "Agreement" + "/{id}")
    public boolean updateAgreement(@PathVariable("id") int id, @RequestBody Agreementmaster entity) {
        entity.setStratDate(cdf.dataBaseFmt(entity.getStratDate()));
        entity.setEndDate(cdf.dataBaseFmt(entity.getEndDate()));

        entity.setAgreementMasterId(Long.valueOf(id));
        entity.setUpdatedon(getTimeStampDate());

        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @RequestMapping(value = "/get" + "Portfolio" + "DataListJson")
    public @ResponseBody
    String getPortfolioDataListJson() throws JsonProcessingException {

        List<?> dataListObject = multiActionDao.executeDataTablePortfolioObjectBuilder(Portfoliomaster.class);
        System.out.println("" + new ObjectMapper().writeValueAsString(dataListObject));
        return new ObjectMapper().writeValueAsString(dataListObject);
    }

    @RequestMapping(value = "/get" + "IOM" + "DataTableJson")
    public @ResponseBody
    String getIOMDataTableJson(@RequestParam("sSearch") String sSearch,
                               @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList)
            throws JsonProcessingException {

        String cList[] = {"iomNumber"};// column name as in pojo not in database
        String gscList[] = {"iomNumber"};// column name as in pojo not in database

        DataTableModel dataModel = multiActionDao.executeDataTableIOMObjectBuilder(Iommaster.class, start, length,
                sSearch, sList, cList, gscList);
        System.out.print(new ObjectMapper().writeValueAsString(dataModel));
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    // pojo object search by columns
    @RequestMapping(value = "/getIOMEntityPojoObjectJson")
    public @ResponseBody
    String getIOMEntityPojoObjectJson(@RequestParam("id") String id)
            throws JsonProcessingException {

        String cList[] = {"id"};// column name as in pojo not in database
        String vList[] = {id};// column values
        // Class<?> pojoObject =
        // multiActionDao.executePojoObjectBuilder(Studenttestentity.class,cList,vList);
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Iommaster.class, cList, vList);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @PostMapping("saveIOM")
    public boolean saveIOM(@RequestBody Iommaster entity) {
        entity.setFromDate(cdf.dataBaseFmt(entity.getFromDate()));
        entity.setToDate(cdf.dataBaseFmt(entity.getToDate()));
        entity.setId(null);
        entity.setCreatedOn(getTimeStampDate());
        entity.setLastUpdatedOn(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("update" + "IOM" + "/{id}")
    public boolean updateIOM(@PathVariable("id") int id, @RequestBody Iommaster entity) {

        entity.setId(Long.valueOf(id));
        entity.setLastUpdatedOn(getTimeStampDate());
        entity.setFromDate(cdf.dataBaseFmt(entity.getFromDate()));
        entity.setToDate(cdf.dataBaseFmt(entity.getToDate()));
        entity.setId(null);
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("delete" + "Company" + "/{id}")
    public boolean deleteCompany(@PathVariable("id") int id, @RequestBody Companymaster entity) {

        entity.setCompanyMasterId(Long.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @PostMapping("delete" + "Portfolio" + "/{id}")
    public boolean deletePortfolio(@PathVariable("id") int id, @RequestBody Portfoliomaster entity) {

        entity.setPortfolioMasterId(Long.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @PostMapping("delete" + "IOM" + "/{id}")
    public boolean deleteIOM(@PathVariable("id") int id, @RequestBody Iommaster entity) {

        entity.setId(Long.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @PostMapping("delete" + "Agreement" + "/{id}")
    public boolean deleteAgreement(@PathVariable("id") int id, @RequestBody Agreementmaster entity) {

        entity.setAgreementMasterId(Long.valueOf(id));
        return multiActionDao.executePojoDeleteObjectBuilder(entity);
    }

    @RequestMapping(value = "/get" + "IOM" + "DataListJson")
    public @ResponseBody
    String getIOMDataListJson() throws JsonProcessingException {

        List<?> dataListObject = multiActionDao.executeDataTableIOMObjectBuilder(Iommaster.class);
        System.out.println("" + new ObjectMapper().writeValueAsString(dataListObject));
        return new ObjectMapper().writeValueAsString(dataListObject);
    }

    @RequestMapping(value = {"/saveDateTimeQuantum"}, method = RequestMethod.POST)
    @ResponseBody
    public String saveDateTimeQuantum(@RequestBody DateTimeQuantumModel entity) {
        System.out.println("in DateTimeQuantumModel ");

        try {
            System.out.println(" DateTimeQuantumModel " + new ObjectMapper().writeValueAsString(entity));

            addService.saveDateTimeQuantumModel(entity);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String msg = "{\"result\":\"Success\"}";

        // logCreationUtils.Module_Log("genric",1,"msg " + msg);
        return msg;

    }

    @RequestMapping(value = {"/importDateTimeQuantumFile"}, method = RequestMethod.POST)
    @ResponseBody
    public String importDateTimeQuantumFile(@RequestParam(value = "id", required = false) String id,
                                            @RequestParam(value = "file", required = false) MultipartFile bidfile) {
        System.out.println("in importDateTimeQuantumFile " + bidfile);
        System.out.println("in id " + id);
        String msg = "{\"result\":\"Failed\"}", result = "success", message = "";
        String fullfilename = "test", path = "", filepath, buyfile = "", sellfile = "";

        List<String> errorList = new ArrayList<String>();
        if (bidfile != null && bidfile.isEmpty()) {
            System.out.println("in false");
            // return new ResponseEntity<>("You failed to upload " + fullfilename + "
            // because the file was empty.",HttpStatus.BAD_REQUEST);
        } else if (!bidfile.isEmpty()) {
            try {
                System.out.println("in true");
                byte[] bytes = bidfile.getBytes();
                path = UtilityClass.dataPath();
                System.out.println("in path " + path);
                ServletContext context = httpSession.getServletContext();
                path = path + "//Agreement//";
                System.out.println("in path " + path);
                File dir = new File(path);
                if (!dir.exists()) {
                    System.out.println("in dir creation");
                    dir.mkdirs();
                }
                String fileName = new SimpleDateFormat("yyyyMMddHHmmSS").format(new Date());
                fullfilename = fileName + "." + FilenameUtils.getExtension(bidfile.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File(path + File.separator + fullfilename)));
                // agreementmaster.setDocfile(fullfilename);
                fullfilename = path + File.separator + fullfilename;
                System.out.println("in fullfilename " + fullfilename);
                stream.write(bytes);
                stream.flush();
                stream.close();

                msg = addService.getIomDetails(id, fullfilename);
            } catch (Exception e) {
                e.printStackTrace();
                // return new ResponseEntity<>("You failed to Doc File upload " + fullfilename +
                // " => " + e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            // logCreationUtils.Module_Log("genric",1,"Invalid Token");
            msg = "{\"error\":\"UnautherizedX\"}";

        }
        // logCreationUtils.Module_Log("genric",1,"msg " + msg);
        return msg;

    }

    @RequestMapping(value = "/getAgreementEntityPojoObjectJson")
    public @ResponseBody
    String getAgreementEntityPojoObjectJson(@RequestParam("id") String id)
            throws JsonProcessingException {

        String cList[] = {"agreementMasterId"};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Agreementmaster.class, cList, vList);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/getAgreementDetailsJson")
    public @ResponseBody
    String getAgreementDetaisJson(@RequestParam("id") String id) throws JsonProcessingException {

        String cList[] = {"agreementMasterId"};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(AgreementDetails.class, cList, vList);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/getIOMDateTimeDetailsJson")
    public @ResponseBody
    String getIOMDetailJson(@RequestParam("id") String id) throws JsonProcessingException {

        String cList[] = {"id"};// column name as in pojo not in database
        String vList[] = {id};// column values
        // Object pojoObject = executePojoIomDetailsBuilder2(String cList[],String
        // vList[])

        List<?> dataListObject = multiActionDao.executePojoIomDetailsBuilder2(cList, vList);

        List<HashMap<String, String>> listMap = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<String, String>();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String fromHr, fromMin, toHr, toMin, date, fromDate, toDate;
        double value;
        for (int i = 0; i < dataListObject.size(); i++) {
            map = new HashMap<String, String>();
            IomDetails iomDetails = (IomDetails) dataListObject.get(i);
            date = df.format(iomDetails.getFromTime().getTime());
            fromHr = date.split(" ")[1];
            fromDate = date.split(" ")[0];
            fromMin = fromHr.split(":")[1];
            fromHr = fromHr.split(":")[0];

            date = df.format(iomDetails.getToTime().getTime());
            toHr = date.split(" ")[1];
            toDate = date.split(" ")[0];
            toMin = toHr.split(":")[1];
            toHr = toHr.split(":")[0];
            value = iomDetails.getValue();
            map.put("fromDate", fromDate);
            map.put("toDate", toDate);
            map.put("fromHr", fromHr);
            map.put("fromMin", fromMin);
            map.put("toHr", toHr);
            map.put("toMin", toMin);
            map.put("value", value + "");
            listMap.add(map);
        }

        // iomDetails.setId(null);
        return new ObjectMapper().writeValueAsString(listMap);
    }

    @RequestMapping(value = "/getAgreementDateTimeDetailsJson")
    public @ResponseBody
    String getAgreementDetailJson(@RequestParam("id") String id) throws JsonProcessingException {

        String cList[] = {"agreementMasterId"};// column name as in pojo not in database
        String vList[] = {id};// column values
        // Object pojoObject = executePojoIomDetailsBuilder2(String cList[],String
        // vList[])

        List<?> dataListObject = multiActionDao.executePojoAgreementDetailsBuilder2(cList, vList);

        List<HashMap<String, String>> listMap = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<String, String>();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String fromHr, fromMin, toHr, toMin, date, fromDate, toDate;
        double value;
        for (int i = 0; i < dataListObject.size(); i++) {
            map = new HashMap<String, String>();
            AgreementDetails agreementDetails = (AgreementDetails) dataListObject.get(i);
            date = df.format(agreementDetails.getFromTime().getTime());
            fromHr = date.split(" ")[1];
            fromDate = date.split(" ")[0];
            fromMin = fromHr.split(":")[1];
            fromHr = fromHr.split(":")[0];

            date = df.format(agreementDetails.getToTime().getTime());
            toHr = date.split(" ")[1];
            toDate = date.split(" ")[0];
            toMin = toHr.split(":")[1];
            toHr = toHr.split(":")[0];
            value = agreementDetails.getValue();
            map.put("fromDate", fromDate);
            map.put("toDate", toDate);
            map.put("fromHr", fromHr);
            map.put("fromMin", fromMin);
            map.put("toHr", toHr);
            map.put("toMin", toMin);
            map.put("value", value + "");
            listMap.add(map);
        }

        // iomDetails.setId(null);
        return new ObjectMapper().writeValueAsString(listMap);
    }

    @RequestMapping(value = "/getAgreementTariffDetails")
    public @ResponseBody
    String getAgreementTariffDetailJson(@RequestParam("id") String id)
            throws JsonProcessingException {

        String cList[] = {"agreementMasterId"};// column name as in pojo not in database
        String vList[] = {id};// column values
        // Object pojoObject = executePojoIomDetailsBuilder2(String cList[],String
        // vList[])

        List<?> dataListObject = multiActionDao.executePojoAgreementTariffDetailsBuilder2(cList, vList);

        List<HashMap<String, String>> listMap = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<String, String>();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String fromHr, fromMin, toHr, toMin, date, fromDate, toDate;
        double value;
        for (int i = 0; i < dataListObject.size(); i++) {
            map = new HashMap<String, String>();
            AgreementTariffDetails agreementDetails = (AgreementTariffDetails) dataListObject.get(i);
            date = df.format(agreementDetails.getFromTime().getTime());
            fromHr = date.split(" ")[1];
            fromDate = date.split(" ")[0];
            fromMin = fromHr.split(":")[1];
            fromHr = fromHr.split(":")[0];

            date = df.format(agreementDetails.getToTime().getTime());
            toHr = date.split(" ")[1];
            toDate = date.split(" ")[0];
            toMin = toHr.split(":")[1];
            toHr = toHr.split(":")[0];
            value = agreementDetails.getValue();
            map.put("fromDate", fromDate);
            map.put("toDate", toDate);
            map.put("fromHr", fromHr);
            map.put("fromMin", fromMin);
            map.put("toHr", toHr);
            map.put("toMin", toMin);
            map.put("value", value + "");
            listMap.add(map);
        }

        // iomDetails.setId(null);
        return new ObjectMapper().writeValueAsString(listMap);
    }

    @RequestMapping(value = "/getAgreementDetails")
    public @ResponseBody
    String getAgreementDetail(@RequestParam("id") String id) throws JsonProcessingException {

        String cList[] = {"agreementMasterId"};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Agreementmaster.class, cList, vList);
        Agreementmaster agreementmaster = (Agreementmaster) pojoObject;
        String cList1[] = {"portfolioMasterId"};// column name as in pojo not in database
        if (StringUtils.isNoneBlank(agreementmaster.getBuyerportfolio())) {
            String vList1[] = {agreementmaster.getBuyerportfolio()};// column values
            // Class<?> pojoObject =
            // multiActionDao.executePojoObjectBuilder(Studenttestentity.class,cList,vList);
            Object pojoObject1 = multiActionDao.executePojoObjectBuilder2(Portfoliomaster.class, cList1, vList1);
            Portfoliomaster portfoliomaster = (Portfoliomaster) pojoObject1;
            if (portfoliomaster != null) {
                agreementmaster.setBuyerportfolio(portfoliomaster.getPortfolioId());
            }

        }
        if (StringUtils.isNoneBlank(agreementmaster.getSellerportfolio())) {
            String vList1[] = {agreementmaster.getSellerportfolio()};// column values
            // Class<?> pojoObject =
            // multiActionDao.executePojoObjectBuilder(Studenttestentity.class,cList,vList);
            Object pojoObject1 = multiActionDao.executePojoObjectBuilder2(Portfoliomaster.class, cList1, vList1);
            Portfoliomaster portfoliomaster = (Portfoliomaster) pojoObject1;
            if (portfoliomaster != null) {
                agreementmaster.setSellerportfolio(portfoliomaster.getPortfolioId());
            }
        }
        if (StringUtils.isNoneBlank(agreementmaster.getStratDate())) {
            agreementmaster.setStratDate(cdf.dataBaseFmt(agreementmaster.getStratDate()));
        }
        if (StringUtils.isNoneBlank(agreementmaster.getEndDate())) {
            agreementmaster.setEndDate(cdf.dataBaseFmt(agreementmaster.getEndDate()));
        }

        String cList2[] = {"id"};// column name as in pojo not in database

        String vList2[] = {agreementmaster.getIomNumber() + ""};// column values
        // Class<?> pojoObject =
        // multiActionDao.executePojoObjectBuilder(Studenttestentity.class,cList,vList);
        Object pojoObject1 = multiActionDao.executePojoObjectBuilder2(Iommaster.class, cList2, vList2);
        Iommaster iommaster = (Iommaster) pojoObject1;
        if (iommaster != null) {
            agreementmaster.setIomNo(iommaster.getIomNumber());
        }


        return new ObjectMapper().writeValueAsString(agreementmaster);
    }

    @RequestMapping(value = "/getPortfolioDetails")
    public @ResponseBody
    String getPortfolioDetails(@RequestParam("id") String id) throws JsonProcessingException {

        String cList[] = {"portfolioMasterId"};// column name as in pojo not in database
        String vList[] = {id};// column values
        // Class<?> pojoObject =
        // multiActionDao.executePojoObjectBuilder(Studenttestentity.class,cList,vList);
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Portfoliomaster.class, cList, vList);
        Portfoliomaster portfoliomaster = (Portfoliomaster) pojoObject;
        String cList2[] = {"portfolioId"};
        String vList2[] = {id + ""};// column values
        Object pojoObject2 = multiActionDao.executePojoObjectBuilder2(Portfolioline.class, cList2, vList2);
        Portfolioline portfolioline = (Portfolioline) pojoObject2;
        portfoliomaster.setPointOfConnection(portfolioline.getLine());

        String cList4[] = {"companyMasterId"};
        String vList4[] = {portfoliomaster.getCompanyName() + ""};// column values
        Object pojoObject4 = multiActionDao.executePojoObjectBuilder2(Companymaster.class, cList4, vList4);
        Companymaster companymaster = (Companymaster) pojoObject4;
        portfoliomaster.setCompanyName(companymaster.getCompanyName());

        String cList3[] = {"stateMasterId"};
        String vList3[] = {portfoliomaster.getStateName() + ""};// column values
        Object pojoObject3 = multiActionDao.executePojoObjectBuilder2(Statemaster.class, cList3, vList3);
        Statemaster statemaster = (Statemaster) pojoObject3;
        portfoliomaster.setStateName(statemaster.getStateName());

        String cList1[] = {"portfoliomasterid"};// column name as in pojo not in database
        String vList1[] = {portfoliomaster.getPortfolioMasterId() + ""};// column values
        // Class<?> pojoObject =
        // multiActionDao.executePojoObjectBuilder(Studenttestentity.class,cList,vList);
        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(Portfoliodetails.class, cList1, vList1);
        // System.out.println("dataListObject size "+dataListObject.size());
        for (int i = 0; i < dataListObject.size(); i++) {
            Portfoliodetails portfoliodetails = (Portfoliodetails) dataListObject.get(i);
            // System.out.println("portfoliodetails "+portfoliodetails);
            if (portfoliodetails != null) { // System.out.println("portfoliodetails type "+portfoliodetails);
                if (portfoliodetails.getType().equals("Mobile") && portfoliodetails.getDtype().equals("Billing"))
                    portfoliomaster.setBillingMobile(portfoliodetails.getValue());
                if (portfoliodetails.getType().equals("Phone") && portfoliodetails.getDtype().equals("Billing"))
                    portfoliomaster.setBillingContact(portfoliodetails.getValue());
                if (portfoliodetails.getType().equals("Fax") && portfoliodetails.getDtype().equals("Billing"))
                    portfoliomaster.setBillingFax(portfoliodetails.getValue());
                if (portfoliodetails.getType().equals("Email") && portfoliodetails.getDtype().equals("Billing"))
                    portfoliomaster.setBillingEmail(portfoliodetails.getValue());

                if (portfoliodetails.getType().equals("Mobile") && portfoliodetails.getDtype().equals("Operation"))
                    portfoliomaster.setOperationMobile(portfoliodetails.getValue());
                if (portfoliodetails.getType().equals("Phone") && portfoliodetails.getDtype().equals("Operation"))
                    portfoliomaster.setOperationContact(portfoliodetails.getValue());
                if (portfoliodetails.getType().equals("Fax") && portfoliodetails.getDtype().equals("Operation"))
                    portfoliomaster.setOperationFax(portfoliodetails.getValue());
                if (portfoliodetails.getType().equals("Email") && portfoliodetails.getDtype().equals("Operation"))
                    portfoliomaster.setOperationEmail(portfoliodetails.getValue());

            }
        }
        return new ObjectMapper().writeValueAsString(portfoliomaster);
    }

    @RequestMapping(value = {"/saveAgreementTariffDetails"}, method = RequestMethod.POST)
    @ResponseBody
    public String saveAgreementTariffDetails(@RequestBody DateTimeQuantumModel entity) {
        System.out.println("in DateTimeQuantumModel ");

        try {
            System.out.println(" DateTimeQuantumModel " + new ObjectMapper().writeValueAsString(entity));

            addService.saveAgreementTariff(entity);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String msg = "{\"result\":\"Success\"}";

        // logCreationUtils.Module_Log("genric",1,"msg " + msg);
        return msg;

    }

    @RequestMapping(value = "/getSubAgreementsBuAgreementMaster")
    public @ResponseBody
    String getSubAgreementsBuAgreementMaster(@RequestParam("id") String id) throws JsonProcessingException {
        String cList[] = {"parentAgreementMasterId"};
        String vList[] = {id};

        List<?> dataListObject = multiActionDao.executePojoSubAgreementsListBuilder(cList, vList);

        List<HashMap<String, String>> listMap = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;
        String fromDate, toDate;
        for (int i = 0; i < dataListObject.size(); i++) {
            map = new HashMap<String, String>();
            Agreementmaster agreementmaster = (Agreementmaster) dataListObject.get(i);
            fromDate = cdf.dataBaseFmt(agreementmaster.getStratDate());
            toDate = cdf.dataBaseFmt(agreementmaster.getEndDate());
            map.put("agreementMasterId", agreementmaster.getAgreementMasterId() + "");
            map.put("startDate", fromDate);
            map.put("endDate", toDate);
            listMap.add(map);
        }
        return new ObjectMapper().writeValueAsString(listMap);

    }

    @RequestMapping(value = "/getAgreementDetailsByIOM")
    public @ResponseBody
    String getAgreementDetailsByIOM(@RequestParam("id") String id) throws JsonProcessingException {

        String cList[] = {"iomNumber"};// column name as in pojo not in database
        String vList[] = {id};// column values
        // Object pojoObject = executePojoIomDetailsBuilder2(String cList[],String
        // vList[])

        List<?> dataListObject = multiActionDao.executePojoAgreementBuilder2(cList, vList);

        List<HashMap<String, String>> listMap = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<String, String>();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String fromHr, fromMin, toHr, toMin, date, fromDate, toDate;
        double value;
        for (int i = 0; i < dataListObject.size(); i++) {
            map = new HashMap<String, String>();
            Agreementmaster agreementmaster = (Agreementmaster) dataListObject.get(i);
            fromDate = cdf.dataBaseFmt(agreementmaster.getStratDate());
            toDate = cdf.dataBaseFmt(agreementmaster.getEndDate());
            String route = "";
            if (agreementmaster.getFirstRoute() != null && !agreementmaster.getFirstRoute().equals("")) {
                route = agreementmaster.getFirstRoute();
            }
            if (agreementmaster.getSecondRoute() != null && !agreementmaster.getSecondRoute().equals("")) {
                route += "->" + agreementmaster.getSecondRoute();
            }
            if (agreementmaster.getThirdRoute() != null && !agreementmaster.getThirdRoute().equals("")) {
                route += "->" + agreementmaster.getSecondRoute();
            }
            map.put("agreementMasterId", agreementmaster.getAgreementMasterId() + "");
            map.put("startDate", fromDate);
            map.put("endDate", toDate);
            map.put("applicationNo", agreementmaster.getApplicationNo());
            map.put("order", agreementmaster.getAgreementorder());
            map.put("ppaPowerSold", agreementmaster.getPowerSold());
            map.put("psaPowerPurchased", agreementmaster.getPowerPurchased());
            map.put("ppaDiscomName", agreementmaster.getPpadiscomname());
            map.put("ppaSourceDest", agreementmaster.getPpasourcedest());
            map.put("ppaRequisition", agreementmaster.getPparequisition());
            map.put("psaDiscomName", agreementmaster.getPsadiscomname());
            map.put("psaSourceDest", agreementmaster.getPsasourcedest());
            map.put("psaRequisition", agreementmaster.getPsarequisition());
            map.put("total", agreementmaster.getTotal() + "");
            map.put("route", route);
            listMap.add(map);
        }

        // iomDetails.setId(null);
        return new ObjectMapper().writeValueAsString(listMap);
    }

    @RequestMapping(value = {"/saveAgreementDetailsByIOM"}, method = RequestMethod.POST)
    @ResponseBody
    public String saveAgreementDetailsByIOM(@RequestBody String entity) {
        System.out.println("in saveAgreementDetailsByIOM ");
        String cList[] = {"agreementMasterId"};// column name as in pojo not in database

        String id = "";
        try {
            JSONArray jsonArray = new JSONArray(entity);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jSONObject = jsonArray.getJSONObject(i);
                id = jSONObject.optString("agreementMasterId");
                String vList[] = {id};// column values
                Object pojoObject = multiActionDao.executePojoObjectBuilder2(Agreementmaster.class, cList, vList);
                Agreementmaster agreementmaster = (Agreementmaster) pojoObject;
                agreementmaster.setAgreementorder(jSONObject.optString("agreementOrder"));
                agreementmaster.setPowerSold(jSONObject.optString("ppaPowerSold"));
                agreementmaster.setPowerPurchased(jSONObject.optString("psaPowerPurchased"));
                agreementmaster.setPpadiscomname(jSONObject.optString("ppaDiscomName"));
                agreementmaster.setPpasourcedest(jSONObject.optString("ppaSourceDest"));
                agreementmaster.setPparequisition(jSONObject.optString("ppaRequisition"));
                agreementmaster.setPsadiscomname(jSONObject.optString("psaDiscomName"));
                agreementmaster.setPsasourcedest(jSONObject.optString("psaSourceDest"));
                agreementmaster.setPsarequisition(jSONObject.optString("psaRequisition"));
                if (jSONObject.optString("total") != null) {
                    if (jSONObject.optString("total").equals("true"))
                        agreementmaster.setTotal(true);
                    else
                        agreementmaster.setTotal(false);
                }
                agreementmaster.setProportion(jSONObject.optString("proportion"));
                if (jSONObject.optString("status") != null) {
                    if (jSONObject.optString("status").equals("Active"))
                        agreementmaster.setStatus("Active");
                    else
                        agreementmaster.setStatus("Inactive");
                }
                multiActionDao.executePojoUpdateObjectBuilder(agreementmaster);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String msg = "{\"result\":\"Success\"}";

        // logCreationUtils.Module_Log("genric",1,"msg " + msg);
        return msg;

    }

    @PostMapping("save" + "Discom")
    @ResponseBody
    public String saveDiscom(@RequestBody Discommaster entity) throws IOException {
        String msg = "{\"result\":\"Error\"}";
        Statemaster statemaster = listService.findState(entity.getStateName(), "stateMasterId");
        entity.setStateName(statemaster.getStateName());
        entity.setCreatedOn(getTimeStampDate());
        entity.setLastUpdated(getTimeStampDate());
        boolean res = multiActionDao.executePojoSaveObjectBuilder(entity);
        if (res == true) {
            msg = "{\"result\":\"Success\"}";
        }
        return msg;
    }

    @PostMapping("update" + "Discom" + "/{id}")
    public boolean updateDiscom(@PathVariable("id") int id, @RequestBody Discommaster entity) {
        Statemaster statemaster = listService.findState(entity.getStateName(), "stateMasterId");
        entity.setStateName(statemaster.getStateName());
        entity.setDiscomMasterId(Long.valueOf(id));
        entity.setLastUpdated(getTimeStampDate());
        return multiActionDao.executePojoUpdateObjectBuilder(entity);
    }

    @PostMapping("delete" + "Discom" + "/{id}")
    @ResponseBody
    public String deleteDiscom(@PathVariable("id") int id) {
        Discommaster entity = new Discommaster();
        String msg = "{\"result\":\"Error\"}";
        entity.setDiscomMasterId(Long.valueOf(id));
        boolean res = multiActionDao.executePojoDeleteObjectBuilder(entity);
        if (res == true) {
            msg = "{\"result\":\"Success\"}";
        }
        return msg;
    }

    @RequestMapping(value = "/get" + "Discom" + "DataTableJson")
    public @ResponseBody
    String getDiscomDataTableJson(@RequestParam("sSearch") String sSearch,
                                  @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList)
            throws JsonProcessingException {

        String cList[] = {"discomName", "stateName"};// column name as in pojo not in database
        String gscList[] = {"discomName", "stateName"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(Discommaster.class, start, length,
                sSearch, sList, cList, gscList);
        System.out.print(new ObjectMapper().writeValueAsString(dataModel));
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "Discom" + "DropDownData")
    public @ResponseBody
    String getDiscomDropDownData(@RequestParam("stateName") String stateName)
            throws JsonProcessingException {
        String cList[] = {"stateName"};// column name as in pojo not in database
        String vList[] = {stateName};// column values

        List<?> dataListObject = multiActionDao.executeDataTableDiscomObjectBuilder(Discommaster.class, cList, vList);
        System.out.println("" + new ObjectMapper().writeValueAsString(dataListObject));
        return new ObjectMapper().writeValueAsString(dataListObject);
    }

    @RequestMapping(value = {"/uploadLosses"}, method = RequestMethod.POST)
    @ResponseBody
    public String uploadLosses(@RequestParam(value = "issueDate", required = false) String issueDate,
                               @RequestParam(value = "fromDate", required = false) String fromDate,
                               @RequestParam(value = "toDate", required = false) String toDate,
                               @RequestParam(value = "lossType", required = false) String lossType,
                               @RequestParam(value = "file", required = false) MultipartFile bidfile) {
        System.out.println("in uploadLosses ");
        System.out.println("in fromDate " + fromDate);
        String msg = "{\"result\":\"Failed\"}", result = "Success", message = "";
        String fullfilename = "test", path = "", filepath, buyfile = "", sellfile = "";

        List<String> errorList = new ArrayList<String>();
        if (bidfile != null && bidfile.isEmpty()) {
            System.out.println("in false");
            // return new ResponseEntity<>("You failed to upload " + fullfilename + "
            // because the file was empty.",HttpStatus.BAD_REQUEST);
        } else if (!bidfile.isEmpty()) {
            try {
                System.out.println("in true");
                byte[] bytes = bidfile.getBytes();
                path = UtilityClass.dataPath();
                System.out.println("in path " + path);
                ServletContext context = httpSession.getServletContext();
                path = path + "//Losses//";
                System.out.println("in path " + path);
                File dir = new File(path);
                if (!dir.exists()) {
                    System.out.println("in dir creation");
                    dir.mkdirs();
                }
                String fileName = new SimpleDateFormat("yyyyMMddHHmmSS").format(new Date());
                fullfilename = fileName + "." + FilenameUtils.getExtension(bidfile.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File(path + File.separator + fullfilename)));
                // agreementmaster.setDocfile(fullfilename);
                fileName = fullfilename;
                fullfilename = path + File.separator + fullfilename;
                System.out.println("in fullfilename " + fullfilename);
                stream.write(bytes);
                stream.flush();
                stream.close();

                msg = addService.saveLosses(true, null, issueDate, fromDate, toDate, lossType, fullfilename, fileName);
            } catch (Exception e) {
                e.printStackTrace();
                // return new ResponseEntity<>("You failed to Doc File upload " + fullfilename +
                // " => " + e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            // logCreationUtils.Module_Log("genric",1,"Invalid Token");
            msg = "{\"error\":\"UnautherizedX\"}";

        }
        // logCreationUtils.Module_Log("genric",1,"msg " + msg);
        return msg;

    }

    @RequestMapping(value = {"/updateLosses"}, method = RequestMethod.POST)
    @ResponseBody
    public String updateLosses(@RequestParam(value = "id", required = false) String id,
                               @RequestParam(value = "issueDate", required = false) String issueDate,
                               @RequestParam(value = "fromDate", required = false) String fromDate,
                               @RequestParam(value = "toDate", required = false) String toDate,
                               @RequestParam(value = "lossType", required = false) String lossType,
                               @RequestParam(value = "file", required = false) MultipartFile bidfile) {
        System.out.println("in updateLosses ");
        System.out.println("in fromDate " + fromDate);
        String msg = "{\"result\":\"Failed\"}", result = "Success", message = "";
        String fullfilename = "test", path = "", filepath, buyfile = "", sellfile = "";

        List<String> errorList = new ArrayList<String>();
        if (bidfile != null && bidfile.isEmpty()) {
            System.out.println("in false");
            // return new ResponseEntity<>("You failed to upload " + fullfilename + "
            // because the file was empty.",HttpStatus.BAD_REQUEST);
        } else if (!bidfile.isEmpty()) {
            try {
                System.out.println("in true");
                byte[] bytes = bidfile.getBytes();
                path = UtilityClass.dataPath();
                System.out.println("in path " + path);
                ServletContext context = httpSession.getServletContext();
                path = path + "//Losses//";
                System.out.println("in path " + path);
                File dir = new File(path);
                if (!dir.exists()) {
                    System.out.println("in dir creation");
                    dir.mkdirs();
                }
                String fileName = new SimpleDateFormat("yyyyMMddHHmmSS").format(new Date());
                fullfilename = fileName + "." + FilenameUtils.getExtension(bidfile.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File(path + File.separator + fullfilename)));
                // agreementmaster.setDocfile(fullfilename);
                fileName = fullfilename;
                fullfilename = path + File.separator + fullfilename;
                System.out.println("in fullfilename " + fullfilename);
                stream.write(bytes);
                stream.flush();
                stream.close();

                msg = addService.saveLosses(false, id, issueDate, fromDate, toDate, lossType, fullfilename, fileName);
            } catch (Exception e) {
                e.printStackTrace();
                // return new ResponseEntity<>("You failed to Doc File upload " + fullfilename +
                // " => " + e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            // logCreationUtils.Module_Log("genric",1,"Invalid Token");
            msg = "{\"error\":\"UnautherizedX\"}";

        }
        // logCreationUtils.Module_Log("genric",1,"msg " + msg);
        return msg;

    }

    @RequestMapping("/listUploadLosses")
    @ResponseBody
    public String listUploadLosses(@RequestParam int start, @RequestParam int length,

                                   @RequestParam("issue_date") String issue_date, @RequestParam("start_date") String start_date,
                                   @RequestParam("end_date") String end_date, @RequestParam("loss_type") String loss_type) throws Exception {
        String list[] = new String[5];
        list[0] = null;
        list[1] = null;
        list[2] = null;
        list[3] = null;
        list[4] = null;
        // logCreationUtils.Module_Log("genric",1,"issue_date :"+issue_date+" start_date
        // :"+start_date+" end_date :"+end_date+" loss_type :"+loss_type+" file_name
        // :"+file_name+" datat: "+datat);
        if (issue_date != null && !issue_date.equals(""))
            list[0] = issue_date;
        if (start_date != null && !start_date.equals(""))
            list[1] = start_date;
        if (end_date != null && !end_date.equals(""))
            list[2] = end_date;
        String search = "";
        DataTablesTO<Lossdata> dt = new DataTablesTO<Lossdata>();

        Lossdata lossdata = null; // create search methods //searchDao.findLossdataById(id.toString());

        List<Lossdata> accts = listService.getAllLossdataList(start, length, search, list);
        int count = listService.getAllLossdataListCount(search, list);
        // logCreationUtils.Module_Log("genric",1,"accts___ "+accts.size()+" count:
        // "+count);
        dt.setEntities(accts);
        dt.setiTotalDisplayRecords(count);
        dt.setTotalCount(count);
        dt.setsEcho(0);

        // logCreationUtils.Module_Log("genric",1,"toJson(dt)___ "+toJson(dt));
        return toJson(dt);
    }

    private String toJson(DataTablesTO<?> dt) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(dt);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "getStateLossService", method = RequestMethod.POST)
    @ResponseBody
    public String getStateLossService(@RequestParam("lossDataId") String lossDataId) throws Exception {
        String msg = "success", token = "";

        String date1[];
        int i;

        ConvertDateFormat dte = new ConvertDateFormat();

        List<List> listData = new ArrayList<List>();
        List<List> listAllData = new ArrayList<List>();
        List<String> listd = new ArrayList<String>();
        List<Stateloss> list = listService.getAllStateLossList(lossDataId);
        Stateloss stateloss = null;
        Statemaster statemaster;

        try {
            for (i = 0; i < list.size(); i++) {
                stateloss = (Stateloss) list.get(i);
                statemaster = listService.findState(stateloss.getState(), "stateMasterId");
                listd = new ArrayList<String>();

                if (stateloss.getLossType().equals("State")) {
                    if (statemaster != null) {
                        // numbers[i][0] = statemaster.getStateName();
                        listd.add(statemaster.getStateName());
                    } else {
                        // numbers[i][0] = "";
                        listd.add("");
                    }
                    listd.add(stateloss.getLine());
                    listd.add(stateloss.getLossType());
                    listd.add(stateloss.getLossType1());
                    listd.add(stateloss.getLossValue());
                    listData.add(listd);
                    // numbers[i][1] = stateloss.getLine();
                    // numbers[i][2] = stateloss.getLossType();
                    // numbers[i][3] = stateloss.getLossType1();
                    // numbers[i][4] = stateloss.getLossValue();
                }
            }

            String state;
            int totalrow = 0, row = 0, col = 0;

            state = (String) listData.get(0).get(0);

            i = 0;
            for (int ii = 0; ii < 1; ii++) {
                col = 0;
                row = totalrow;
                totalrow++;
                // result[row][col++] = "STATE";
                List<String> listdd = new ArrayList<String>();
                listdd.add("STATE");
                // listData.get(i).set(0, "STATE");

                while (i < listData.size() && state.equals(listData.get(i).get(0))) {
                    // result[row][col++] = listData.get(i).get(1) + " KV";

                    listdd.add(listData.get(i).get(1) + " KV");
                    i++;
                }
                listAllData.add(listdd);
            }
            i = 0;
            totalrow = 1;
            row = 1;
            col = 0;

            state = (String) listData.get(0).get(0);
            for (int ii = 1; ii < 2; ii++) {
                col = 0;
                row = totalrow;
                totalrow++;
                // result[row][col++] = "LOSS TYPE";
                List<String> listdd = new ArrayList<String>();
                listdd.add("LOSS TYPE");
                while (i < listData.size() && state.equals(listData.get(i).get(0))) {
                    // result[row][col++] = numbers[i][3];
                    listdd.add(listData.get(i).get(3) + "");
                    i++;
                }
                listAllData.add(listdd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            int totalrow = 2;
            int row = 2;
            int col = 0;

            String state = "";
            state = (String) listData.get(0).get(0);
            i = 0;

            while (true) // for ( int ii = 0; ii <2; ii++)
            {
                col = 0;
                row = totalrow;
                totalrow++;
                // result[row][col++] = numbers[i][0];
                List<String> listdd = new ArrayList<String>();
                listdd.add(listData.get(i).get(0) + "");
                if (listData.get(i).get(0) != null) {
                    while (i < listData.size() && state.equals(listData.get(i).get(0))) {
                        // result[row][col++] = numbers[i][4];
                        listdd.add(listData.get(i).get(4) + "");
                        i++;
                    }
                    listAllData.add(listdd);
                }
                // state = numbers[i][0];
                state = null;
                if (i < listData.size())
                    state = (String) listData.get(i).get(0);
                if (state == null) {
                    break;
                }
            }


            // request.setAttribute("row", row);

            ObjectMapper mapper = new ObjectMapper();
            try {
                msg = mapper.writeValueAsString(listAllData);
                // System.out.println("msg "+msg);
            } catch (Exception e) {
                e.printStackTrace();
                msg = "{\"error\":\"Unautherized\"}";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return msg;
    }


    @RequestMapping(value = "getPOCLossService", method = RequestMethod.POST)
    @ResponseBody
    public String getPOCLossService(@RequestParam("lossDataId") String lossDataId) throws Exception {
        String msg = "success", token = "";

        try {
            Portfoliomaster portfoliomaster;
            String status = "active";
            {
                // cdf.dataBaseFmt(fromDate));
                List<Newpocloss> list = listService.getAllPOCLossList(lossDataId);
                List<Newpocloss> newpoclosslist = new ArrayList<Newpocloss>();
                // Regionalentity regionalentity;
                List<List> listData = new ArrayList<List>();
                List<List> listAllData = new ArrayList<List>();
                List<String> listd = new ArrayList<String>();
                try {
                    for (Newpocloss newpocloss : list) {
                        listd = new ArrayList<String>();
                        portfoliomaster = (Portfoliomaster) listService.findPortfolio(newpocloss.getPortfolioId(),
                                "portfolioMasterId");
                        if (portfoliomaster != null) {
                            // numbers[i][0] = portfoliomaster.getPortfolioId();
                            listd.add(portfoliomaster.getPortfolioId());
                        } else {
                            // numbers[i][0] = "";
                            listd.add("");
                        }

                        listd.add(newpocloss.getLossType());
                        listd.add(newpocloss.getLossValue());
                        listd.add(newpocloss.getValidityFromDate());
                        listd.add(newpocloss.getValidityToDate());
                        listData.add(listd);
                    }
                    String portfolio;
                } catch (Exception e) {

                }
                ObjectMapper mapper = new ObjectMapper();
                try {
                    msg = mapper.writeValueAsString(listData);
                } catch (Exception e) {
                    e.printStackTrace();
                    msg = "{\"error\":\"Unautherized\"}";
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            msg = "{\"error\":\"Unautherized\"}";
        }

        return msg;
    }

    @RequestMapping(value = "/getDiscomEntityPojoObjectJson")
    public @ResponseBody
    String getDiscomEntityPojoObjectJson(@RequestParam("id") String id)
            throws JsonProcessingException {

        String cList[] = {"discomMasterId"};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Discommaster.class, cList, vList);
        Discommaster discommaster = (Discommaster) pojoObject;
        Statemaster statemaster = listService.findState(discommaster.getStateName(), "stateName");
        discommaster.setStateName(statemaster.getStateMasterId() + "");
        if (discommaster.getLine().contains("11KV"))
            discommaster.setLine1(true);
        if (discommaster.getLine().contains("22KV"))
            discommaster.setLine2(true);
        if (discommaster.getLine().contains("33KV"))
            discommaster.setLine3(true);
        if (discommaster.getLine().contains("66KV"))
            discommaster.setLine4(true);
        if (discommaster.getLine().contains("110KV"))
            discommaster.setLine5(true);
        if (discommaster.getLine().contains("132KV"))
            discommaster.setLine6(true);
        if (discommaster.getLine().contains("210KV"))
            discommaster.setLine7(true);
        if (discommaster.getLine().contains("400KV"))
            discommaster.setLine8(true);
        if (discommaster.getLine().contains("Other"))
            discommaster.setLine9(true);

        return new ObjectMapper().writeValueAsString(discommaster);
    }

    @RequestMapping(value = "/getLossEntityPojoObjectJson")
    public @ResponseBody
    String getLossEntityPojoObjectJson(@RequestParam("id") String id)
            throws JsonProcessingException {
        SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
        String cList[] = {"id"};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Lossdata.class, cList, vList);
        Lossdata lossdata = (Lossdata) pojoObject;
        lossdata.setIssue_date1(sm.format(lossdata.getIssue_date()));
        lossdata.setStart_date1(sm.format(lossdata.getStart_date()));
        lossdata.setEnd_date1(sm.format(lossdata.getEnd_date()));

        return new ObjectMapper().writeValueAsString(lossdata);
    }

    @RequestMapping(value = "/updateRecordStatus")
    public @ResponseBody
    String updateRecordStatus(@RequestParam("id") String id, @RequestParam("type") String type,
                              @RequestParam("status") String status) throws JsonProcessingException {
        SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
        addService.updateRecordStatus(id, type, status);
        String msg = "{\"result\":\"Success\"}";
        return msg;
    }


    java.sql.Timestamp getTimeStampDate() {
        Date saveDate = new Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        return timeStampDate;
    }


    @RequestMapping(value = {"/uploadScheduleFile"}, method = RequestMethod.POST)
    @ResponseBody
    public String uploadScheduleFile(@RequestParam(value = "schedule_date", required = false) String schedule_date, @RequestParam(value = "file", required = false) MultipartFile bidfile) {
        System.out.println("in uploadScheduleFile " + bidfile);
        System.out.println("in schedule_date " + schedule_date);
        String msg = "{\"result\":\"Failed\"}", result = "success", message = "";
        String fullfilename = "test", path = "", filepath, buyfile = "", sellfile = "";

        List<String> errorList = new ArrayList<String>();
        if (bidfile != null && bidfile.isEmpty()) {
            System.out.println("in false");
            // return new ResponseEntity<>("You failed to upload " + fullfilename + " because the file was empty.",HttpStatus.BAD_REQUEST);
        } else if (!bidfile.isEmpty()) {
            try {
                System.out.println("in true");
                byte[] bytes = bidfile.getBytes();
                path = UtilityClass.dataPath();
                System.out.println("in path " + path);
                ServletContext context = httpSession.getServletContext();
                path = path + "//schedule//";
                System.out.println("in path " + path);
                File dir = new File(path);
                if (!dir.exists()) {
                    System.out.println("in dir creation");
                    dir.mkdirs();
                }
                String fileName = new SimpleDateFormat("yyyyMMddHHmmSS").format(new Date());
                fullfilename = fileName + "." + FilenameUtils.getExtension(bidfile.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(path + File.separator + fullfilename)));
                // agreementmaster.setDocfile(fullfilename);
                fullfilename = path + File.separator + fullfilename;

                stream.write(bytes);
                stream.flush();
                stream.close();
                scheduleService.newDiscomScheduleeexcelF(schedule_date, fullfilename);
                //  msg=addService.getIomDetails(id,fullfilename);
            } catch (Exception e) {
                e.printStackTrace();
                //  return new ResponseEntity<>("You failed to Doc File upload " + fullfilename + " => " + e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            //logCreationUtils.Module_Log("genric",1,"Invalid Token");
            msg = "{\"error\":\"UnautherizedX\"}";

        }
        //logCreationUtils.Module_Log("genric",1,"msg " + msg);
        return msg;

    }


    @GetMapping(value = "/downloadAllRLDCSchedule")
    public @ResponseBody
    String downloadAllRLDCSchedule(@RequestParam(value = "schedule_date", required = false) String schedule_date) throws JsonProcessingException {
        rldcFileDownloadService.downloadALLRLDCScedule(schedule_date);
        String msg = "{\"result\":\"Success\"}";
        return msg;
    }

    @GetMapping(value = "/getMatchingSchedule")
    public @ResponseBody
    String getMatchingSchedule(@RequestParam(value = "schedulemasterid", required = false) String schedulemasterid) throws JsonProcessingException {
        String msg = scheduleService.getScheduleMatchingData(schedulemasterid);

        return msg;
    }

    @GetMapping(value = "/testt")
    public @ResponseBody
    String testt() throws JsonProcessingException {

        String msg = "{\"result\":\"Success\"}";
        return msg;
    }


    @RequestMapping(value = "/get" + "Schedule" + "DataTableJson")
    public @ResponseBody
    String getScheduleDataTableJson(@RequestParam("sSearch") String sSearch,
                                    @RequestParam("start") int start, @RequestParam("length") int length,
                                    @RequestParam("sList") String[] sList) throws JsonProcessingException {

        String cList[] = {"scheduleMasterid", "scheduleDate", "revisionno"};// column name as in pojo not in database
        String gscList[] = {"scheduleMasterid", "scheduleDate", "revisionno"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(Discomschedulemaster.class, start, length, sSearch, sList, cList, gscList);
        System.out.print(new ObjectMapper().writeValueAsString(dataModel));
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "RLDC" + "DataTableJson")
    public @ResponseBody
    String getRLDCDataTableJson(@RequestParam("sSearch") String sSearch,
                                @RequestParam("start") int start, @RequestParam("length") int length,
                                @RequestParam("sList") String[] sList) throws JsonProcessingException {

        String cList[] = {"scheduleMasterid", "scheduleDate", "revisionno"};// column name as in pojo not in database
        String gscList[] = {"scheduleMasterid", "scheduleDate", "revisionno"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(Rldcschedulesources.class, start, length, sSearch, sList, cList, gscList);
        System.out.print(new ObjectMapper().writeValueAsString(dataModel));
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @GetMapping(value = "/getScheduleDetailData")
    public @ResponseBody
    String getScheduleDetailData(@RequestParam(value = "schedulemasterid", required = false) String schedulemasterid, @RequestParam("type") String type) throws JsonProcessingException {
        String msg = scheduleService.getScheduleDetailData(schedulemasterid, type);
        return msg;
    }

    /*
     * //create api for
     *
     * @GetMapping(value = "/DataListJson") public @ResponseBody String
     * getSedularListJson(@RequestParam("userid") String userid) throws
     * JsonProcessingException { List<> scheduleService
     *
     * return new ObjectMapper().writeValueAsString(null); }
     */
}