package com.discom.springmvc.crudapi;

import com.discom.springmvc.dao.MultiActionDao;
import com.discom.springmvc.model.DataTableModel;
import com.discom.springmvc.model.DataTableModelSch;
import com.discom.springmvc.pojo.*;
import com.discom.springmvc.utils.XlsxWriter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DataTableExportController {

    @Autowired
    MultiActionDao multiActionDao;

    @RequestMapping(value = "/export/get" + "Countrymaster" + "DataTableJson", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> getDataTableJsonExcelCountrymaster(HttpServletRequest request, HttpServletResponse response,
                                                         @RequestParam("sSearch") String sSearch, @RequestParam("sList") String[] sList) throws Exception {

        String cList[] = {"countrycode", "countryname"};// column name as in pojo not in database
        String gscList[] = {"countrycode", "countryname"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(Countrymaster.class, 0, 1000000000, sSearch, sList, cList, gscList);
        List<?> dataList = dataModel.getEntities();
        String[] columns = {"Country Code", "Country Name", "Country Service"};
        String[] columnskeys = {"countrycode", "countryname", "countryservice"};
        XSSFWorkbook workbook = null;
        byte[] contentReturn = null;
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"CountrymasterExport.xlsx\"");
        OutputStream out;
        workbook = (XSSFWorkbook) new XlsxWriter().buildExcelDocument(new ObjectMapper().writeValueAsString(dataList), columns, columnskeys);
        out = response.getOutputStream();
        workbook.write(out);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.write(baos);
        contentReturn = baos.toByteArray();
        out.close();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
        return new ResponseEntity<byte[]>(contentReturn, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/export/get" + "Jobpostfields" + "DataTableJson", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> getDataTableJsonExcelJobpostfields(HttpServletRequest request, HttpServletResponse response,
                                                         @RequestParam("sSearch") String sSearch, @RequestParam("sList") String[] sList) throws Exception {

        String cList[] = {"labelName", "fieldName"};// column name as in pojo not in database
        String gscList[] = {"labelName", "fieldName"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(Jobpostfields.class, 0, 1000000000, sSearch, sList, cList, gscList);
        List<?> dataList = dataModel.getEntities();
        String[] columns = {"Label Name", "Field Name", "Field Type", "Field Required", "CS Values"};
        String[] columnskeys = {"labelName", "fieldName", "fieldType", "fieldReq", "csValues"};
        XSSFWorkbook workbook = null;
        byte[] contentReturn = null;
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"JobpostfieldsExport.xlsx\"");
        OutputStream out;
        workbook = (XSSFWorkbook) new XlsxWriter().buildExcelDocument(new ObjectMapper().writeValueAsString(dataList), columns, columnskeys);
        out = response.getOutputStream();
        workbook.write(out);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.write(baos);
        contentReturn = baos.toByteArray();
        out.close();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
        return new ResponseEntity<byte[]>(contentReturn, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/export/get" + "Resumefields" + "DataTableJson", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> getDataTableJsonExcelResumefields(HttpServletRequest request, HttpServletResponse response,
                                                        @RequestParam("sSearch") String sSearch, @RequestParam("sList") String[] sList) throws Exception {

        String cList[] = {"labelName", "fieldName"};// column name as in pojo not in database
        String gscList[] = {"labelName", "fieldName"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(Resumefields.class, 0, 1000000000, sSearch, sList, cList, gscList);
        List<?> dataList = dataModel.getEntities();
        String[] columns = {"Label Name", "Field Name", "Field Type", "Field Required", "CS Values"};
        String[] columnskeys = {"labelName", "fieldName", "fieldType", "fieldReq", "csValues"};
        XSSFWorkbook workbook = null;
        byte[] contentReturn = null;
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"ResumefieldsExport.xlsx\"");
        OutputStream out;
        workbook = (XSSFWorkbook) new XlsxWriter().buildExcelDocument(new ObjectMapper().writeValueAsString(dataList), columns, columnskeys);
        out = response.getOutputStream();
        workbook.write(out);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.write(baos);
        contentReturn = baos.toByteArray();
        out.close();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
        return new ResponseEntity<byte[]>(contentReturn, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/export/get" + "Activitylog" + "DataTableJson", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> getDataTableJsonExcelActivitylog(HttpServletRequest request, HttpServletResponse response,
                                                       @RequestParam("sSearch") String sSearch, @RequestParam("sList") String[] sList) throws Exception {

        String cList[] = {"userid", "datetime", "operatingsystem"};// column name as in pojo not in database
        String gscList[] = {"userid", "datetime", "operatingsystem"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(Activitylog.class, 0, 1000000000, sSearch, sList, cList, gscList);
        List<?> dataList = dataModel.getEntities();
        String[] columns = {"User Id", "User Name", "User Type", "Date Time", "Operating Syatem", "Browser", "IP Address", "Details", "Country", "City", "Entry Time"};
        String[] columnskeys = {"userid", "username", "usertype", "datetime", "operatingsystem", "browser", "ipaddress", "details", "country", "city", "entrytime"};
        XSSFWorkbook workbook = null;
        byte[] contentReturn = null;
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"ActivitylogExport.xlsx\"");
        OutputStream out;
        workbook = (XSSFWorkbook) new XlsxWriter().buildExcelDocument(new ObjectMapper().writeValueAsString(dataList), columns, columnskeys);
        out = response.getOutputStream();
        workbook.write(out);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.write(baos);
        contentReturn = baos.toByteArray();
        out.close();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
        return new ResponseEntity<byte[]>(contentReturn, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/export/get" + "TemplateGroupsFields" + "DataTableJson", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> getDataTableJsonExcelTemplateGroupsFields(HttpServletRequest request, HttpServletResponse response,
                                                                @RequestParam("sSearch") String sSearch, @RequestParam("sList") String[] sList) throws Exception {


        String cList[] = {"fieldcode", "fieldlabel", "fielddisplaytype"};// column name as in pojo not in database
        String gscList[] = {"fieldcode", "fieldlabel", "fielddisplaytype"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(TemplateGroupsFields.class, 0, 1000000000, sSearch, sList, cList, gscList);
        List<?> dataList = dataModel.getEntities();
        String[] columns = {"Field Code", "Field Label", "Field Display Type"};
        String[] columnskeys = {"fieldcode", "fieldlabel", "fielddisplaytype"};
        XSSFWorkbook workbook = null;
        byte[] contentReturn = null;
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"TemplateGroupsFieldsExport.xlsx\"");
        OutputStream out;
        workbook = (XSSFWorkbook) new XlsxWriter().buildExcelDocument(new ObjectMapper().writeValueAsString(dataList), columns, columnskeys);
        out = response.getOutputStream();
        workbook.write(out);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.write(baos);
        contentReturn = baos.toByteArray();
        out.close();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
        return new ResponseEntity<byte[]>(contentReturn, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/export/get" + "CandidateWatchdogPlans" + "DataTableJson", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> getDataTableJsonExcelCandidateWatchdogPlans(HttpServletRequest request, HttpServletResponse response,
                                                                  @RequestParam("sSearch") String sSearch, @RequestParam("sList") String[] sList) throws Exception {


        String cList[] = {"planname"};// column name as in pojo not in database
        String gscList[] = {"planname"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(CandidateWatchdogPlans.class, 0, 1000000000, sSearch, sList, cList, gscList);
        List<?> dataList = dataModel.getEntities();
        String[] columns = {"Plan Name", "Service Fee", "Processing Rate", "CGST Rate", "SGST Rate", "IGST Rate", "Total", "Duration"};
        String[] columnskeys = {"planname", "servicefee", "processingrate", "cgstrate", "sgstrate", "igstrate", "total", "duration"};
        XSSFWorkbook workbook = null;
        byte[] contentReturn = null;
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"CandidateWatchdogPlansExport.xlsx\"");
        OutputStream out;
        workbook = (XSSFWorkbook) new XlsxWriter().buildExcelDocument(new ObjectMapper().writeValueAsString(dataList), columns, columnskeys);
        out = response.getOutputStream();
        workbook.write(out);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.write(baos);
        contentReturn = baos.toByteArray();
        out.close();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
        return new ResponseEntity<byte[]>(contentReturn, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/export/get" + "CandidateResumebroadcastPlans" + "DataTableJson", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> getDataTableJsonExcelCandidateResumebroadcastPlans(HttpServletRequest request, HttpServletResponse response,
                                                                         @RequestParam("sSearch") String sSearch, @RequestParam("sList") String[] sList) throws Exception {


        String cList[] = {"planname"};// column name as in pojo not in database
        String gscList[] = {"planname"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(CandidateResumebroadcastPlans.class, 0, 1000000000, sSearch, sList, cList, gscList);
        List<?> dataList = dataModel.getEntities();
        String[] columns = {"Plan Name", "Service Fee", "Processing Rate", "CGST Rate", "SGST Rate", "IGST Rate", "Total", "Duration"};
        String[] columnskeys = {"planname", "servicefee", "processingrate", "cgstrate", "sgstrate", "igstrate", "total", "duration"};
        XSSFWorkbook workbook = null;
        byte[] contentReturn = null;
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"CandidateResumebroadcastPlansExport.xlsx\"");
        OutputStream out;
        workbook = (XSSFWorkbook) new XlsxWriter().buildExcelDocument(new ObjectMapper().writeValueAsString(dataList), columns, columnskeys);
        out = response.getOutputStream();
        workbook.write(out);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.write(baos);
        contentReturn = baos.toByteArray();
        out.close();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
        return new ResponseEntity<byte[]>(contentReturn, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/export/get" + "CandidateQuickresumebroadcastPlans" + "DataTableJson", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> getDataTableJsonExcel(HttpServletRequest request, HttpServletResponse response,
                                            @RequestParam("sSearch") String sSearch, @RequestParam("sList") String[] sList) throws Exception {


        String cList[] = {"planname"};// column name as in pojo not in database
        String gscList[] = {"planname"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(CandidateQuickresumebroadcastPlans.class, 0, 1000000000, sSearch, sList, cList, gscList);
        List<?> dataList = dataModel.getEntities();
        String[] columns = {"Plan Name", "Service Fee", "Processing Rate", "CGST Rate", "SGST Rate", "IGST Rate", "Total", "Duration"};
        String[] columnskeys = {"planname", "servicefee", "processingrate", "cgstrate", "sgstrate", "igstrate", "total", "duration"};
        XSSFWorkbook workbook = null;
        byte[] contentReturn = null;
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"CandidateQuickresumebroadcastPlansExport.xlsx\"");
        OutputStream out;
        workbook = (XSSFWorkbook) new XlsxWriter().buildExcelDocument(new ObjectMapper().writeValueAsString(dataList), columns, columnskeys);
        out = response.getOutputStream();
        workbook.write(out);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.write(baos);
        contentReturn = baos.toByteArray();
        out.close();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
        return new ResponseEntity<byte[]>(contentReturn, headers, HttpStatus.OK);
    }

    //********************  Scheduling start

    /*@RequestMapping(value = "/get" + "Activitylog" + "DataTableJson")
    public @ResponseBody
    String getDataTableJsonActivitylog(@RequestParam("sSearch") String sSearch,
                                       @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList) throws JsonProcessingException {

        String cList[] = {"userid", "datetime", "operatingsystem"};// column name as in pojo not in database
        String gscList[] = {"userid", "datetime", "operatingsystem"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(Activitylog.class, start, length, sSearch, sList, cList, gscList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }
*/
    @RequestMapping(value = "/get" + "Resumedata" + "DataTableJson")
    public @ResponseBody
    String getDataTableJsonResumedata(@RequestParam("sSearch") String sSearch,
                                      @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList) throws JsonProcessingException {

        String cList[] = {"fieldcode", "fieldlabel", "fielddisplaytype"};// column name as in pojo not in database
        String gscList[] = {"fieldcode", "fieldlabel", "fielddisplaytype"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(Resumedata.class, start, length, sSearch, sList, cList, gscList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "Companyprofiles" + "DataTableJson")
    public @ResponseBody
    String getDataTableJsonCompanyprofiles(@RequestParam("sSearch") String sSearch,
                                           @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList, @RequestParam("fList") String[] fList) throws Exception {

        String cList[] = {"cp_company_name", "cp_email"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilderJSON("companyprofiles", start, length, sSearch, sList, cList, fList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "Contactjobships" + "DataTableJson")
    public @ResponseBody
    String getDataTableJsoncontactjobships(@RequestParam("sSearch") String sSearch,
                                           @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList, @RequestParam("fList") String[] fList) throws Exception {

        String cList[] = {"addressing_to", "subject"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilderJSON("contactjobships", start, length, sSearch, sList, cList, fList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "Companylist" + "DataTableJson")
    public @ResponseBody
    String getDataTableJsonCompany(@RequestParam("sSearch") String sSearch,
                                   @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList, @RequestParam("fList") String[] fList) throws Exception {
        System.out.println("in Companylist");
        String cList[] = {"jp_department", "jp_rank"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilderJSON("company", start, length, sSearch, sList, cList, fList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "Company" + "ByCompanyId")
    public @ResponseBody
    String getCompanyjobpostsByCompanyid(@RequestParam("id") String id)
            throws JsonProcessingException, ParseException {
        Object pojoObject = (Object) multiActionDao
                .executePojoObjectCompany(Company.class, id);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/getAll" + "Company")
    public @ResponseBody
    String getAllCompany()
            throws JsonProcessingException, ParseException {
        System.out.println("in all Companylist");
        List<Company> pojoObject = (List<Company>) multiActionDao.getAllCompany();
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

//	@RequestMapping(value = "/get"+"Companyjobposts"+"DataTableJson")
//	public @ResponseBody String getDataTableJsonCompanyjobposts(@RequestParam("sSearch") String sSearch,
//			@RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList, @RequestParam("fList") String[] fList,
//			@RequestParam("subFList") String[] subFList, @RequestParam("subLList") String[] subLList) throws Exception {
//
//		String cList[] = {"name","address"};// column name as in pojo not in database
//		DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilderJSON("companyjobposts", start, length, sSearch, sList, cList, fList);
//		return new ObjectMapper().writeValueAsString(dataModel);
//	}

    @RequestMapping(value = "/get" + "AdminCompanyjobposts" + "DataTableJson")
    public @ResponseBody
    String getDataTableJsonCompanyjobposts(@RequestParam("sSearch") String sSearch,
                                           @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList, @RequestParam("fList") String[] fList,
                                           @RequestParam("subFList") String[] subFList, @RequestParam("subLList") String[] subLList,
                                           @RequestParam(name = "companyName", required = false) String companyName, @RequestParam("status") String status,
                                           @RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) throws Exception {

        String cList[] = {"name", "address"};// column name as in pojo not in database
        DataTableModelSch dataModel = multiActionDao.executeDataTableObjectBuilderJSON2("companyjobposts", start,
                length, sSearch, sList, cList, fList, subFList, companyName, status, fromDate, toDate);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "Companyjobposts" + "DataTableJson")
    public @ResponseBody
    String getDataTableJsonCompanyjobposts(@RequestParam("sSearch") String sSearch,
                                           @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("companyId") int companyId, @RequestParam("sList") String[] sList, @RequestParam("fList") String[] fList,
                                           @RequestParam("subFList") String[] subFList, @RequestParam("subLList") String[] subLList,
                                           @RequestParam("status") String status,
                                           @RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) throws Exception {

        String cList[] = {"name", "address"};// column name as in pojo not in database
        DataTableModelSch dataModel = multiActionDao.executeDataTableObjectBuilderJSON3("companyjobposts", start,
                length, companyId, sSearch, sList, cList, fList, subFList, status, fromDate, toDate);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "Companytemplatejobposts" + "DataTableJson")
    public @ResponseBody
    String getDataTableJsosan(@RequestParam("sSearch") String sSearch,
                              @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList, @RequestParam("fList") String[] fList) throws Exception {

        String cList[] = {};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilderJSON("companytemplatejobposts", start, length, sSearch, sList, cList, fList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "Companyusers" + "DataTableJsonn")
    public @ResponseBody
    String getDataTableJsoncompanyusers(@RequestParam("sSearch") String sSearch,
                                        @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList, @RequestParam("fList") String[] fList) throws Exception {

        String cList[] = {"user_name", "email"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilderJSON("companyusers", start, length, sSearch, sList, cList, fList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "Greetingrequests" + "DataTableJsonn")
    public @ResponseBody
    String getDataTableJson(@RequestParam("sSearch") String sSearch,
                            @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList, @RequestParam("fList") String[] fList) throws Exception {

        String cList[] = {"greetings_for"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilderJSON("greetingrequests", start, length, sSearch, sList, cList, fList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }


    @RequestMapping(value = "/getAllProductList")
    public @ResponseBody
    String getDataTableJsonproduct(@RequestParam("sSearch") String sSearch,
                                   @RequestParam("start") int start, @RequestParam("length") int length,
                                   @RequestParam("dbList") String[] dbList) throws Exception {

        //String cList[] = {"name"};// column name as in pojo not in database
        DataTableModelSch dataModel = multiActionDao.getAllBillingProduct("ProductMaster", start, length, sSearch, dbList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/getAllProductBanner")
    public @ResponseBody
    String getAllProductBanner(@RequestParam("sSearch") String sSearch,
                               @RequestParam("start") int start, @RequestParam("length") int length,
                               @RequestParam("dbList") String[] dbList) throws Exception {
        //String cList[] = {"name"};// column name as in pojo not in database
        DataTableModelSch dataModel = multiActionDao.getAllBillingProduct("ProductBanner", start, length, sSearch, dbList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/getAllProductFeaturedUser")
    public @ResponseBody
    String getAllProductFeaturedUser(@RequestParam("sSearch") String sSearch,
                                     @RequestParam("start") int start, @RequestParam("length") int length,
                                     @RequestParam("dbList") String[] dbList) throws Exception {

        //String cList[] = {"name"};// column name as in pojo not in database
        DataTableModelSch dataModel = multiActionDao.getAllBillingProduct("ProductFeaturedUser", start, length, sSearch, dbList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/getAllProductMixedService")
    public @ResponseBody
    String getAllProductMixedService(@RequestParam("sSearch") String sSearch,
                                     @RequestParam("start") int start, @RequestParam("length") int length,
                                     @RequestParam("dbList") String[] dbList) throws Exception {
        //String cList[] = {"name"};// column name as in pojo not in database
        DataTableModelSch dataModel = multiActionDao.getAllBillingProduct("productMixedService", start, length, sSearch, dbList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/getAllProductAccessList")
    public @ResponseBody
    String getAllProductAccessList(@RequestParam("sSearch") String sSearch,
                                   @RequestParam("start") int start, @RequestParam("length") int length,
                                   @RequestParam("dbList") String[] dbList) throws Exception {
        //String cList[] = {"name"};// column name as in pojo not in database
        DataTableModelSch dataModel = multiActionDao.getAllBillingProduct("ProductAccessList", start, length, sSearch, dbList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/getProductList" + "/{id}")
    public @ResponseBody
    ProductMaster getProductList(@PathVariable("id") String id) {
        return multiActionDao.getProductListByid(ProductMaster.class, id);
    }

    @RequestMapping(value = "/getProductBanner" + "/{id}")
    public @ResponseBody
    ProductBanner getProductBanner(@PathVariable("id") String id) {
        return multiActionDao.getProductBannerByid(ProductBanner.class, id);
    }

    @RequestMapping(value = "/getProductFeaturedUser" + "/{id}")
    public @ResponseBody
    ProductFeaturedUser getProductFeaturedUser(@PathVariable("id") String id) {
        return multiActionDao.getProductFeaturedUserByid(ProductFeaturedUser.class, id);
    }

    @RequestMapping(value = "/getProductMixedService" + "/{id}")
    public @ResponseBody
    ProductMixedServices getProductMixedService(@PathVariable("id") String id) {
        return multiActionDao.getProductMixedServiceByid(ProductMixedServices.class, id);
    }

    @RequestMapping(value = "/getProductAccessList" + "/{id}")
    public @ResponseBody
    ProductAccessList getProductAccessList(@PathVariable("id") String id) {
        return multiActionDao.getProductAccessListByid(ProductAccessList.class, id);
    }

    java.sql.Timestamp getTimeStampDate() {
        Date saveDate = new Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        return timeStampDate;
    }
}