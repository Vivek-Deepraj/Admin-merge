package com.discom.springmvc.serviceimpl;

import com.discom.springmvc.dao.AddDao;
import com.discom.springmvc.dao.MultiActionDao;
import com.discom.springmvc.dao.SearchDao;
import com.discom.springmvc.model.DateTimeQuantumModel;
import com.discom.springmvc.model.User;
import com.discom.springmvc.pojo.*;
import com.discom.springmvc.service.AddService;
import com.discom.springmvc.service.ListService;
import com.discom.springmvc.utils.ConvertDateFormat;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service("addService")
public class AddServiceImpl implements AddService {
    @Autowired
    MultiActionDao multiActionDao;
    ConvertDateFormat cdf = new ConvertDateFormat();
    @Autowired
    private AddDao addDao;
    @Autowired
    private SearchDao searchDao;
    @Autowired
    private ListService listService;
    //@Autowired
// AuthServiceFeignClient authServiceFeignClient;

    public static double Round(double Rval, int Rpl) {

        double value = Math.round(Rval * 100.0) / 100.0;
        return value;
    }

    public boolean UpdateUser(User user) {
        return addDao.UpdateUser(user);
    }

    public void addPasswordHistory(Passwordhistorymaster passwordhistorymaster) {
        addDao.addPasswordHistory(passwordhistorymaster);
    }

    @Transactional
    public boolean updatePermission(Permissionmaster permissionmaster) {
        return addDao.updatePermission(permissionmaster);
    }

    @Transactional
    public boolean savePermission(Permissionmaster permissionmaster) {
        return addDao.savePermission(permissionmaster);
    }

    @Transactional
    public boolean saveActivitylog(Activitylog logModel, String activity) {
        logModel.setId(null);
        logModel.setDetails(activity);
        System.out.println("User ID: " + logModel.getUserid() + " User Name: " + logModel.getUsername() + " User Type: " + logModel.getUsertype() + " Activity Time: " + logModel.getDatetime() + " OS: " + logModel.getOperatingsystem() + " Browser: " + logModel.getBrowser() + " IP Address: " + logModel.getIpaddress() + " Activity: " + logModel.getDetails());
        return addDao.saveActivitylog(logModel);
    }

    @Transactional
    public String getIomDetails(String id, String filePath) {
        List<IomDetails> iomDetails = new ArrayList<IomDetails>();
        List<String> errorList = new ArrayList<String>();
        Workbook wb1 = null;
        int sheetrows = 0;
        Cell celltemp;
        java.util.Date saveDate = new java.util.Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        String filedate = "", readingdate = "";
        List<List<String>> biddatamasterlist_allist = new ArrayList<List<String>>();
        List<String> biddatamasterlist = new ArrayList<String>();
        System.out.println("filePath " + filePath);
        try {
            wb1 = new XSSFWorkbook(filePath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        int portfoliono_index = 0, periphery_index = 0, deliverydate_index = 0;
        for (int sheetindex = 0; sheetindex < 1; sheetindex++) {
            Sheet sheet = wb1.getSheetAt(0);
            // filedate = sheet.getRow(0).getCell(1).getStringCellValue();
            sheetrows = sheet.getPhysicalNumberOfRows();

            DateFormat df_date = new SimpleDateFormat("dd-MMM-yyyy");
            DateFormat df_date2 = new SimpleDateFormat("dd-MM-yyyy");

            //   //logCreationUtils.Module_Log("genric",1,"deliverydate_index "+deliverydate_index);
            portfoliono_index = 0;
            DateFormat old_df = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
            DateFormat df = new SimpleDateFormat("HH:mm");
            String from_date = null, to_date = null;
            for (int st1 = 7; st1 < sheetrows; st1++) {
                biddatamasterlist = new ArrayList<String>();
                Row rowtemp = sheet.getRow(st1);
                if (rowtemp != null) {
                    for (int tc1 = 3; tc1 < 8; tc1++) {
                        celltemp = rowtemp.getCell((short) tc1);
                        if (celltemp != null) {
                            //  celltemp.setCellType(celltemp.CELL_TYPE_STRING);
                            //  if (celltemp.getCellType() == HSSFCell.CELL_TYPE_STRING)
                            {
                                //  System.out.println("tc1 "+tc1+" "+celltemp.getCellType());
                                // if(HSSFDateUtil.isCellDateFormatted(celltemp))
                                // if(celltemp.getDateCellValue()!=null)
                                // celltempvalue = celltemp.getDateCellValue().toString();
                                if (tc1 == 7) {
                                    String celltempvalue = "";
                                    if (celltemp.getCellType() == HSSFCell.CELL_TYPE_STRING)
                                        celltempvalue = celltemp.toString();
                                    else if (celltemp.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
                                        celltempvalue = celltemp.toString();
                                    biddatamasterlist.add(celltempvalue);
                                } else if (tc1 >= 5) {
                                    String celltempvalue = "";
                                    if (celltemp.getCellType() == HSSFCell.CELL_TYPE_STRING)
                                        celltempvalue = celltemp.toString();
                                    else if (celltemp.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                                        //  int time = (int)celltemp.getNumericCellValue();
                                        //celltempvalue=df.parse(time);
                                        java.util.Date time = celltemp.getDateCellValue();
                                        //  System.out.println("date-time: " + time);
                                        //It will print out this message : "date-time: Sun Dec 31 14:29:50 CST 1899"
                                        if (time == null)
                                            break;
                                        old_df.format(time);
                                        celltempvalue = df.format(old_df.getCalendar().getTime());

                                    }
                                    biddatamasterlist.add(celltempvalue);
                                }

                                if (tc1 == 3) {
                                    if (celltemp.getCellType() == HSSFCell.CELL_TYPE_STRING)
                                        from_date = celltemp.toString();
                                    else if (celltemp.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
                                        from_date = celltemp.toString();
                                    if (from_date != null) {
                                        try {
                                            from_date = df_date2.format(df_date.parse(from_date).getTime());
                                        } catch (ParseException e) {
                                            // TODO Auto-generated catch block
                                            //e.printStackTrace();
                                        }
                                        biddatamasterlist.add(from_date);
                                    }
                                }
                                if (tc1 == 4) {
                                    if (celltemp.getCellType() == HSSFCell.CELL_TYPE_STRING)
                                        to_date = celltemp.toString();
                                    else if (celltemp.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
                                        to_date = celltemp.toString();
                                    if (to_date != null) {
                                        try {
                                            to_date = df_date2.format(df_date.parse(to_date).getTime());
                                        } catch (ParseException e) {
                                            // TODO Auto-generated catch block
                                            //e.printStackTrace();
                                        }
                                        biddatamasterlist.add(to_date);
                                    }
                                }

                            }
                        }
                    }
                    biddatamasterlist_allist.add(biddatamasterlist);

                }
            }
        }
        int slno = 0;

        List<String> succslist = new ArrayList<String>();

        String fromdate = "";
        String todate = "";
        String fromtime = "";
        String totime = "";
        String rate = "";
        String quantum = "";
        String fromhr = "";
        String tohr = "";
        String frommin = "";
        String tomin = "";
        int error_sno = 1;
        List<HashMap<String, String>> listMap = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<String, String>();
        try {
            for (int i = 0; i < biddatamasterlist_allist.size(); i++) {
                // for (int i = 5; i < 30; i++) {
                fromtime = "";
                totime = "";
                fromhr = "";
                tohr = "";
                frommin = "";
                tomin = "";
                rate = "";
                quantum = "";
                System.out.println("i= " + i + " biddatamasterlist_allist " + biddatamasterlist_allist);
                //try {
                for (int j = 0; j < 5; j++) {
                    if (j == 0)
                        fromdate = biddatamasterlist_allist.get(i).get(j);
                    if (j == 1)
                        todate = biddatamasterlist_allist.get(i).get(j);
                    if (j == 2)
                        fromtime = biddatamasterlist_allist.get(i).get(j);
                    if (j == 3)
                        totime = biddatamasterlist_allist.get(i).get(j);
                    if (j == 4)
                        quantum = biddatamasterlist_allist.get(i).get(j);
                }
                //  } catch (Exception e) {
                // e.printStackTrace();
                // }
                // //logCreationUtils.Module_Log("genric",1," i= "+i +" val = "+biddatamasterlist_allist.get(i));
                if ((fromtime == null || fromtime.trim().equals("")) && (totime == null || totime.trim().equals("")) && (rate == null || rate.trim().equals(""))
                        && (quantum == null || quantum.trim().equals("")))
                    ;
                else {
                       /*  if (fromtime == null || fromtime.trim().equals("") || !StringUtils.isNumeric(fromtime))
                             errorList.add(error_sno++ + ". " + "From time value should be numeric in row no " + (i + 1) + " and col "
                                             + CellReference.convertNumToColString(deliverydate_index));
                         else if (Integer.parseInt(fromtime) > 2345)
                             errorList.add(error_sno++ + ". " + "From time value should be less than 24:00 in row no " + (i + 1) + " and col "
                                             + CellReference.convertNumToColString(deliverydate_index));

                         if (totime == null || totime.trim().equals("") || !StringUtils.isNumeric(totime))
                             errorList.add(error_sno++ + ". " + "To time value should be numeric in row no " + (i + 1) + " and col "
                                             + CellReference.convertNumToColString(deliverydate_index + 1));
                         else if (Integer.parseInt(totime) > 2400)
                             errorList.add(error_sno++ + ". " + "To time value should be less than or equal to 24:00 in row no " + (i + 1) + " and col "
                                             + CellReference.convertNumToColString(deliverydate_index));
                         if (StringUtils.isNumeric(fromtime) && StringUtils.isNumeric(totime))
                             if (Integer.parseInt(fromtime) >= Integer.parseInt(totime))
                                 errorList.add(error_sno++ + ". " + "From time value should be less than to time value in row no " + (i + 1) + " and col "
                                                 + CellReference.convertNumToColString(deliverydate_index));

                         if (rate == null || rate.trim().equals("") || !StringUtils.isNumeric(rate))
                             errorList.add(error_sno++ + ". " + "Rate value should be numeric row no " + (i + 1) + " and col "
                                             + CellReference.convertNumToColString(deliverydate_index + 2));

                         if (quantum == null || quantum.trim().equals(""))
                             errorList.add(error_sno++ + ". " + "Quantum value should not be blank in row no " + (i + 1) + " and col "
                                             + CellReference.convertNumToColString(deliverydate_index + 3));
                       */
                    if ((quantum != null && !quantum.trim().equals(""))) {
                        BigDecimal d = BigDecimal.ZERO;
                        try {
                            d = new BigDecimal(quantum);
                            if (d.compareTo(BigDecimal.ZERO) < 0)
                                errorList.add(error_sno++ + ". " + "Quantum value should be greater than 0 in row no " + (i + 1) + " and col "
                                        + CellReference.convertNumToColString(deliverydate_index + 3));
                        } catch (Exception e) {
                            errorList.add(error_sno++ + ". " + "Quantum value should be numeric in row no " + (i + 1) + " and col "
                                    + CellReference.convertNumToColString(deliverydate_index + 3));
                        }

                        String text = d.abs().setScale(1, RoundingMode.HALF_UP).toString();

                        int integerPlaces = text.indexOf('.');

                        int decimalPlaces = text.length() - integerPlaces - 1;
                        if (decimalPlaces > 1)
                            errorList.add(error_sno++ + ". " + "Quantum value decimal place should not be more than 1 in row no " + (i + 1) + " and col "
                                    + CellReference.convertNumToColString(deliverydate_index + 3));
                    }

                    // //logCreationUtils.Module_Log("genric",1,"from time1 "+fromtime);
                    // //logCreationUtils.Module_Log("genric",1,"to time1 "+totime);
                    if (fromtime.length() == 1)
                        fromtime = "000" + fromtime;
                    if (fromtime.length() == 2)
                        fromtime = "00" + fromtime;
                    if (fromtime.length() == 3)
                        fromtime = "0" + fromtime;
                    if (totime.length() == 1)
                        totime = "000" + totime;
                    if (totime.length() == 2)
                        totime = "00" + totime;
                    if (totime.length() == 3)
                        totime = "0" + totime;

                    // //logCreationUtils.Module_Log("genric",1,"from time "+fromtime);
                    // //logCreationUtils.Module_Log("genric",1,"to time "+totime);
                    map = new HashMap<String, String>();
                    /*
                     * map.put("fromDate", fromdate.substring(0, 2)); map.put("toDate",
                     * todate.substring(0, 2));
                     *
                     * map.put("fromTime", fromtime.substring(0, 2)); map.put("toTime",
                     * totime.substring(0, 2));
                     */

                    fromhr = fromtime.split(":")[0];
                    tohr = totime.split(":")[0];
                    frommin = fromtime.split(":")[1];
                    tomin = totime.split(":")[1];

                    map.put("fromDate", fromdate);
                    map.put("toDate", todate);
                    map.put("fromhr", fromhr);
                    map.put("frommin", frommin);
                    map.put("tohr", tohr);
                    map.put("tomin", tomin);
                    //  map.put("quantum", new Double(quantum)+"");
                    if (quantum == null || quantum.isEmpty())
                        quantum = "0";
                    double value1 = new BigDecimal(new Double(quantum)).setScale(8,
                            RoundingMode.HALF_UP).doubleValue();
                    double value = new
                            BigDecimal(value1 + "").setScale(2, RoundingMode.DOWN).doubleValue();
                    map.put("quantum", value + "");
                    listMap.add(map);
                }
            }


        } catch (Exception e) {
            // e.printStackTrace();
        }

        // Reading basic information

        String listt = "", result = "", msg = "", buylistt = "", biddata = "", errorlist = "", filebiddata = "";
        ObjectMapper mapper = new ObjectMapper();
        try {

            listt = mapper.writeValueAsString(listMap);

            errorlist = mapper.writeValueAsString(errorList);

        } catch (Exception e) {
            // e.printStackTrace();
        }

        if (errorList.size() > 0)
            result = "error";
        msg = "{\"result\":\"" + result + "\",\"errorList\":"
                + errorlist + ",\"details\":" + listt + "}";

        System.out.println("msg= " + msg);
        //logCreationUtils.Module_Log("genric",1,"msg " + msg);
        return msg;
        //return addDao.saveIomDetails(iomDetails);
    }

    public boolean saveDateTimeQuantumModel(DateTimeQuantumModel obj) {
        boolean res = false;
        String id = obj.getId();
        System.out.println("id " + id);

        DateFormat df_date = new SimpleDateFormat("dd-MM-yyyy HH mm");
        DateFormat df_date1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fromMinDate = null, toMaxdate = null;
            if (obj.getType().equals("IOM")) {
                String cList[] = {"id"};// column name as in pojo not in database
                String vList[] = {id};// column values
                Object pojoObject = multiActionDao.executePojoObjectBuilder2(Iommaster.class, cList, vList);
                Iommaster iommaster = (Iommaster) pojoObject;
                System.out.println("iommaster " + iommaster);
                IomDetails iomDetails = new IomDetails();
                iomDetails.setId(iommaster);

                List<?> dataListObject = multiActionDao.executePojoIomDetailsBuilder2(cList, vList);

                for (int i = 0; i < dataListObject.size(); i++) {

                    IomDetails iomDetails1 = (IomDetails) dataListObject.get(i);
                    multiActionDao.executePojoDeleteObjectBuilder(iomDetails1);
                }
                IomDetails iomdetails = new IomDetails();

                int count = 0;
                List<Map<String, String>> list = obj.getDetails();
                String fromdate, todate, fromhr, frommin, tohr, tomin;
                for (Map<String, String> map : list) {
                    iomdetails = new IomDetails();
                    fromdate = map.get("fromDate");
                    todate = map.get("toDate");
                    fromhr = map.get("fromHr");
                    frommin = map.get("fromMin");
                    tohr = map.get("toHr");
                    tomin = map.get("toMin");
                    try {
                        iomdetails.setFromTime(df_date.parse(fromdate + " " + fromhr + " " + frommin));
                        iomdetails.setToTime(df_date.parse(todate + " " + tohr + " " + tomin));
                        if (count == 0) {
                            fromMinDate = iomdetails.getFromTime();
                            toMaxdate = iomdetails.getToTime();
                        } else {
                            if (fromMinDate.compareTo(iomdetails.getFromTime()) > 0) {
                                fromMinDate = iomdetails.getFromTime();
                            }
                            if (toMaxdate.compareTo(iomdetails.getFromTime()) < 0) {
                                toMaxdate = iomdetails.getToTime();
                            }
                        }
                        count++;
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    iomdetails.setValue(Double.parseDouble(map.get("quantum")));
                    iomdetails.setId(iommaster);
                    iomdetails.setIomDetailsId(null);
                    iomdetails.setCreatedBy("");
                    iomdetails.setLastUpdatedBy("");
                    iomdetails.setCreatedOn(getTimeStampDate());
                    iomdetails.setLastUpdated(getTimeStampDate());
                    multiActionDao.executePojoSaveObjectBuilder(iomdetails);


                }
                iommaster.setFromDate(df_date1.format(fromMinDate));
                iommaster.setToDate(df_date1.format(toMaxdate));
                multiActionDao.executePojoUpdateObjectBuilder(iommaster);
            }
            if (obj.getType().equals("Agreement")) {
                String cList[] = {"agreementMasterId"};// column name as in pojo not in database
                String vList[] = {id};// column values
                Object pojoObject = multiActionDao.executePojoObjectBuilder2(Agreementmaster.class, cList, vList);
                Agreementmaster agreementmaster = (Agreementmaster) pojoObject;
                AgreementDetails agreementDetails = new AgreementDetails();
                agreementDetails.setAgreementMasterId(agreementmaster);

                List<?> dataListObject = multiActionDao.executePojoAgreementDetailsBuilder2(cList, vList);
                for (int i = 0; i < dataListObject.size(); i++) {

                    AgreementDetails agreementDetails1 = (AgreementDetails) dataListObject.get(i);
                    multiActionDao.executePojoDeleteObjectBuilder(agreementDetails1);
                }

                AgreementDetails agreementdetails = new AgreementDetails();
                List<Map<String, String>> list = obj.getDetails();
                String fromdate, todate, fromhr, frommin, tohr, tomin;
                int count = 0;
                for (Map<String, String> map : list) {
                    fromdate = map.get("fromDate");
                    todate = map.get("toDate");
                    fromhr = map.get("fromHr");
                    frommin = map.get("fromMin");
                    tohr = map.get("toHr");
                    tomin = map.get("toMin");
                    try {
                        agreementdetails.setFromTime(df_date.parse(fromdate + " " + fromhr + " " + frommin));
                        agreementdetails.setToTime(df_date.parse(todate + " " + tohr + " " + tomin));
                        if (count == 0) {
                            fromMinDate = agreementdetails.getFromTime();
                            toMaxdate = agreementdetails.getToTime();
                        } else {
                            if (fromMinDate.compareTo(agreementdetails.getFromTime()) > 0) {
                                fromMinDate = agreementdetails.getFromTime();
                            }
                            if (toMaxdate.compareTo(agreementdetails.getFromTime()) < 0) {
                                toMaxdate = agreementdetails.getToTime();
                            }
                        }
                        count++;
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    agreementdetails.setCreatedOn(getTimeStampDate());
                    agreementdetails.setLastUpdated(getTimeStampDate());
                    agreementdetails.setCreatedBy("");
                    agreementdetails.setLastUpdatedBy("");
                    agreementdetails.setValue(Double.parseDouble(map.get("quantum")));
                    agreementdetails.setAgreementMasterId(agreementmaster);
                    agreementdetails.setAgreementDetailsId(null);
                    multiActionDao.executePojoSaveObjectBuilder(agreementdetails);

                }
                agreementmaster.setStratDate(df_date1.format(fromMinDate));
                agreementmaster.setEndDate(df_date1.format(toMaxdate));
                multiActionDao.executePojoUpdateObjectBuilder(agreementmaster);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    public boolean saveAgreementTariff(DateTimeQuantumModel obj) {
        boolean res = false;
        String id = obj.getId();
        System.out.println("id " + id);

        DateFormat df_date = new SimpleDateFormat("dd-MM-yyyy HH mm");
        try {

            if (obj.getType().equals("Agreement")) {
                String cList[] = {"agreementMasterId"};// column name as in pojo not in database
                String vList[] = {id};// column values
                Object pojoObject = multiActionDao.executePojoObjectBuilder2(Agreementmaster.class, cList, vList);
                Agreementmaster agreementmaster = (Agreementmaster) pojoObject;
                AgreementTariffDetails agreementDetails = new AgreementTariffDetails();
                agreementDetails.setAgreementMasterId(agreementmaster);
                multiActionDao.executePojoDeleteObjectBuilder(agreementDetails);
                AgreementTariffDetails agreementdetails = new AgreementTariffDetails();
                List<Map<String, String>> list = obj.getDetails();
                String fromdate, todate, fromhr, frommin, tohr, tomin;
                for (Map<String, String> map : list) {
                    fromdate = map.get("fromDate");
                    todate = map.get("toDate");
                    fromhr = map.get("fromHr");
                    frommin = map.get("fromMin");
                    tohr = map.get("toHr");
                    tomin = map.get("toMin");
                    try {
                        agreementdetails.setFromTime(df_date.parse(fromdate + " " + fromhr + " " + frommin));
                        agreementdetails.setToTime(df_date.parse(todate + " " + tohr + " " + tomin));
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    agreementdetails.setCreatedOn(getTimeStampDate());
                    agreementdetails.setLastUpdated(getTimeStampDate());
                    agreementdetails.setCreatedBy("");
                    agreementdetails.setLastUpdatedBy("");
                    agreementdetails.setValue(Double.parseDouble(map.get("quantum")));
                    agreementdetails.setAgreementMasterId(agreementmaster);
                    agreementdetails.setAgreementTariffDetailsId(null);
                    multiActionDao.executePojoSaveObjectBuilder(agreementdetails);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    public String saveLosses(boolean newloss, String id, String issueDate, String fromDate, String toDate, String losstype, String filePath, String fileName) {
        String POC, State, Other, fromdate, todate, injection, withdrawl, issuedate, periodfrom, periodto;
        String msg = "{\"result\":\"Error\"}";
        ConvertDateFormat dte = new ConvertDateFormat();
        Newpocloss newpocloss = new Newpocloss();
        Stateloss stateloss = new Stateloss();
        try {

            SimpleDateFormat dat = new SimpleDateFormat("dd-MM-yyyy");
            Date saveDate = new Date();
            Timestamp timeStampDate = new Timestamp(saveDate.getTime());
            Lossdata lossdata = new Lossdata();
            lossdata.setId(null);
            lossdata.setIssue_date(dat.parse(issueDate));
            lossdata.setStart_date(dat.parse(fromDate));
            lossdata.setEnd_date(dat.parse(toDate));
            lossdata.setLoss_type(losstype);
            lossdata.setFile_name(fileName);
            lossdata.setStatus("New");
            if (newloss == false) {
                lossdata.setId(Long.parseLong(id));
                multiActionDao.executePojoUpdateObjectBuilder(lossdata);
                if (losstype.equals("State"))
                    deleteRecords("Stateloss", "lossDataId", id);
                if (losstype.equals("POC"))
                    deleteRecords("newpocloss", "lossDataId", id);
            } else
                multiActionDao.executePojoSaveObjectBuilder(lossdata);


            if (losstype.equals("POC")) {
                String fromdbe = null;
                String todbe = null;
                String date1[], date2[];

                Portfoliomaster portfoliomaster;

                File newFile = new File(filePath);
                //   FileUtils.copyFile(getFilename(), newFile);
                String path = filePath;
                fileName = newFile.getName();
                String[][] numbers = new String[1500][100];
                File file = new File(filePath);


                Workbook wb1 = null;

                int i = 0, j = 0;
                int row1 = 0;
                int col1 = 0;
                Row row;
                Cell cell;


                int rows; // No of rows


                int cols = 0; // No of columns
                int tmp = 0;


                try {


                    wb1 = new XSSFWorkbook(path);

                    Sheet sheet = wb1.getSheetAt(0);
                    rows = sheet.getPhysicalNumberOfRows();


                    for (i = 0; i < 10 || i < rows; i++) {

                        row = sheet.getRow(i);
                        if (row != null) {
                            tmp = sheet.getRow(i).getPhysicalNumberOfCells();

                            if (tmp > cols) {
                                cols = tmp;
                            }

                        }
                    }
                    int count = 0;
                    for (int r1 = 0; r1 < rows; r1++) {
                        row = sheet.getRow(r1);
                        if (row != null) {
                            for (int c = 0; c < cols; c++) {
                                cell = row.getCell((short) c);
                                if (cell != null) {

                                    numbers[r1][col1] = cell.toString();
                                    // log.info("The numbers is:"+numbers[r1][col1]);
                                    col1++;
                                    count++;
                                }
                            }
                        }
                        col1 = 0;
                        row1++;
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }


                date1 = numbers[0][1].split("-");

                date2 = numbers[0][3].split("-");


                String month = "";
                if (date1[1].equalsIgnoreCase("jan")) {
                    month = "01";
                }

                if (date1[1].equalsIgnoreCase("feb")) {
                    month = "02";
                }
                if (date1[1].equalsIgnoreCase("mar")) {
                    month = "03";
                }
                if (date1[1].equalsIgnoreCase("apr")) {
                    month = "04";
                }
                if (date1[1].equalsIgnoreCase("may")) {
                    month = "05";
                }
                if (date1[1].equalsIgnoreCase("jun")) {
                    month = "06";
                }
                if (date1[1].equalsIgnoreCase("jul")) {
                    month = "07";
                }
                if (date1[1].equalsIgnoreCase("aug")) {
                    month = "08";
                }
                if (date1[1].equalsIgnoreCase("sep")) {
                    month = "09";
                }
                if (date1[1].equalsIgnoreCase("oct")) {
                    month = "10";
                }
                if (date1[1].equalsIgnoreCase("nov")) {
                    month = "11";
                }
                if (date1[1].equalsIgnoreCase("dec")) {
                    month = "12";
                }
                fromdate = date1[0] + "-" + month + "-" + date1[2];

                if (date2[1].equalsIgnoreCase("jan")) {
                    month = "01";
                }
                if (date2[1].equalsIgnoreCase("feb")) {
                    month = "02";
                }
                if (date2[1].equalsIgnoreCase("mar")) {
                    month = "03";
                }
                if (date2[1].equalsIgnoreCase("apr")) {
                    month = "04";
                }
                if (date2[1].equalsIgnoreCase("may")) {
                    month = "05";
                }
                if (date2[1].equalsIgnoreCase("jun")) {
                    month = "06";
                }
                if (date2[1].equalsIgnoreCase("jul")) {
                    month = "07";
                }
                if (date2[1].equalsIgnoreCase("aug")) {
                    month = "08";
                }
                if (date2[1].equalsIgnoreCase("sep")) {
                    month = "09";
                }
                if (date2[1].equalsIgnoreCase("oct")) {
                    month = "10";
                }
                if (date2[1].equalsIgnoreCase("nov")) {
                    month = "11";
                }
                if (date2[1].equalsIgnoreCase("dec")) {
                    month = "12";
                }
                //log.info("The file in poc---------");
                todate = date2[0] + "-" + month + "-" + date2[2];

                String lostype[];

                for (i = 2; i < row1; i++) {
                    // log.info(""+i+numbers[i][2]+"hh");
                }


                for (i = 2; i < row1; i++) {
                    numbers[i][2] = numbers[i][2].trim();

                    if (numbers[i][2].trim() != null) {


                        portfoliomaster = listService.findPortfolio(numbers[i][2].trim(), "portfolioId");
                        //log.info(portfoliomaster);
                        if (portfoliomaster != null) {
                            id = String.valueOf(portfoliomaster.getPortfolioMasterId());
                            for (j = 0; j < 2; j++) {
                                if (j == 0) {
                                    newpocloss.setPortfolioId(id);

                                    newpocloss.setValidityFromDate(dte.dataBaseFmt(fromdate));
                                    newpocloss.setValidityToDate(dte.dataBaseFmt(todate));


                                    injection = String.valueOf(Round(((Double.parseDouble(String.valueOf(numbers[i][3])) * 10000) / 100), 2));
                                    newpocloss.setIssuedate(dte.dataBaseFmt(issueDate));
                                    newpocloss.setLossType("Injection");
                                    newpocloss.setLossValue(injection);
                                    newpocloss.setStatus("New");
                                    newpocloss.setFileName(fileName);
                                    //  newpocloss.setUploadedBy((String) session.getAttribute("uname"));
                                    newpocloss.setCreatedOn(timeStampDate);
                                    newpocloss.setLossType1("POC");

                                }
                                if (j == 1) {
                                    newpocloss.setPortfolioId(id);
                                    newpocloss.setValidityFromDate(dte.dataBaseFmt(fromdate));
                                    newpocloss.setValidityToDate(dte.dataBaseFmt(todate));

                                    withdrawl = String.valueOf(Round(((Double.parseDouble(String.valueOf(numbers[i][4])) * 10000) / 100), 2));
                                    newpocloss.setIssuedate(dte.dataBaseFmt(issueDate));


                                    newpocloss.setLossType("Withdrawl");
                                    newpocloss.setLossValue(withdrawl);
                                    newpocloss.setStatus("New");
                                    newpocloss.setFileName(fileName);
                                    //  newpocloss.setUploadedBy((String) session.getAttribute("uname"));
                                    newpocloss.setCreatedOn(timeStampDate);
                                    newpocloss.setLossType1("POC");
                                }
                                newpocloss.setLossDataId(lossdata.getId().intValue());
                                multiActionDao.executePojoSaveObjectBuilder(newpocloss);

                            }
                        }
                    }


                }
                msg = "{\"result\":\"Success\"}";

                //log.info("at d end f poc");
            } else if (losstype.equals("State")) {


                Statemaster statemaster;
                Discommaster discommaster;


                File newFile = new File(filePath);
                String path = filePath;
                fileName = newFile.getName();
                String[][] numbers = new String[1500][100];
                String[][] numbers2 = new String[1500][100];
                File file = new File(path);
                Workbook wb1 = null;
                InputStream inputStream = null;
                int i = 0, j = 0;
                int row1 = 0;
                int row2 = 0;
                Row row;
                Cell cell;
                int rows; // No of rows
                boolean discomdatafound = false;
                int discomfoundindex = 0;
                try {
                    wb1 = new XSSFWorkbook(path);
                    Sheet sheet = wb1.getSheetAt(0);
                    rows = sheet.getPhysicalNumberOfRows();
                    System.out.println("no of rows: " + rows);
                    for (int r1 = 0; r1 <= rows; r1++) {
                        if (r1 >= 5) {
                            row = sheet.getRow(r1);
                            if (row != null && (row.getCell((short) 0) != null && row.getCell((short) 0).getCellType() != row.getCell((short) 0).CELL_TYPE_BLANK)) {
                                for (int c = 0; c <= 3; c++) {
                                    cell = row.getCell((short) c);
                                    if (cell != null) {
                                        if (c == 0 && cell.getCellType() == cell.CELL_TYPE_STRING) {
                                            if (cell.getStringCellValue().equals("Sr. No")) {
                                                discomdatafound = true;
                                                discomfoundindex = r1;
                                            }
                                        }
                                    }
                                }
                                System.out.println("DISCOMFOUND:" + discomdatafound);
                                if (discomdatafound == false) {
                                    //for (int c = 0; c <= 13; c++) {
                                    for (int c = 0; c <= 19; c++) {
                                        cell = row.getCell((short) c);
                                        if (cell != null) {
                                            numbers[row1][c] = cell.toString();
                                        }
                                    }
                                    row1++;
                                }
                                if (discomdatafound == true) {
                                    if (r1 > discomfoundindex) {
                                        for (int c = 0; c <= 19; c++) {
                                            cell = row.getCell((short) c);
                                            if (cell != null) {
                                                numbers2[row2][c] = cell.toString();
                                            }
                                        }
                                        row2++;
                                    }
                                }
                            }
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

                for (i = 0; i < row1; i++) {
                    if (numbers[i][1] != null) {
                        try {
                            statemaster = listService.findState(numbers[i][1].trim(), "stateName");
                            if (statemaster != null) {
                                id = String.valueOf(statemaster.getStateMasterId());
                                //for (j = 2; j <= 17; j++) {
                                //for (j = 2; j <= 19; j++) {
                                for (j = 2; j <= 21; j++) {
                                    if (j % 2 == 0) {
                                        stateloss.setState(id);
                                        stateloss.setLossType("State");
                                        if (j == 2) {
                                            stateloss.setLine("400");
                                        }
                                        if (j == 4) {
                                            stateloss.setLine("220");
                                        }
                                        if (j == 6) {
                                            stateloss.setLine("132");
                                        }
                                        if (j == 8) {
                                            stateloss.setLine("110");
                                        }
                                        if (j == 10) {
                                            stateloss.setLine("66");
                                        }

                                        if (j == 12) {
                                            stateloss.setLine("33");
                                        }
                                        if (j == 14) {
                                            stateloss.setLine("22");
                                        }

                                        if (j == 16) {
                                            stateloss.setLine("11");
                                        }

                                        if (j == 18) {
                                            stateloss.setLine("Other");
                                        }
                                        if (j == 20) {
                                            stateloss.setLine("NA");
                                        }

                                        stateloss.setLossType1("Injection");
                                        if (j == 20)
                                            stateloss.setLossValue("0");
                                        else if (j <= 18)
                                            stateloss.setLossValue(numbers[i][j]);

                                        stateloss.setIssuedate(dte.dataBaseFmt(issueDate));
                                        stateloss.setPeriodfrom(dte.dataBaseFmt(fromDate));
                                        stateloss.setPeriodto(dte.dataBaseFmt(toDate));
                                        stateloss.setCreatedOn(timeStampDate);
                                        stateloss.setArchive("New");
                                    } else if (j % 2 == 1) {
                                        stateloss.setState(id);
                                        stateloss.setLossType("State");
                                        if (j == 3) {
                                            stateloss.setLine("400");
                                        }
                                        if (j == 5) {
                                            stateloss.setLine("220");
                                        }
                                        if (j == 7) {
                                            stateloss.setLine("132");
                                        }
                                        if (j == 9) {
                                            stateloss.setLine("110");
                                        }
                                        if (j == 11) {
                                            stateloss.setLine("66");
                                        }

                                        if (j == 13) {
                                            stateloss.setLine("33");
                                        }
                                        if (j == 15) {
                                            stateloss.setLine("22");
                                        }

                                        if (j == 17) {
                                            stateloss.setLine("11");
                                        }

                                        if (j == 19) {
                                            stateloss.setLine("Other");
                                        }
                                        if (j == 21) {
                                            stateloss.setLine("NA");
                                        }
                                        stateloss.setLossType1("Withdrawl");
                                        if (j == 21)
                                            stateloss.setLossValue("0");
                                        else if (j <= 19)
                                            stateloss.setLossValue(numbers[i][j]);

                                        stateloss.setIssuedate(dte.dataBaseFmt(issueDate));
                                        stateloss.setPeriodfrom(dte.dataBaseFmt(fromDate));
                                        stateloss.setPeriodto(dte.dataBaseFmt(toDate));

                                        stateloss.setCreatedOn(timeStampDate);
                                        stateloss.setArchive("New");
                                    }
                                    stateloss.setLossDataId(lossdata.getId().intValue());
                                    multiActionDao.executePojoSaveObjectBuilder(stateloss);

                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
                System.out.println("rowq " + row2);

                for (i = 0; i < row2; i++) {
                    if (numbers2[i][1] != null) {
                        try {
                            discommaster = listService.findDiscom(numbers[i][1].trim(), "discomName");

                            System.out.println("numbers2[i][1].trim() " + numbers2[i][1].trim() + "  " + discommaster);
                            if (discommaster != null) {
                                id = String.valueOf(discommaster.getDiscomMasterId());
                                for (j = 2; j <= 19; j++) {
                                    if (j % 2 == 0) {
                                        stateloss.setState(id);
                                        stateloss.setLossType("Discom");
                                        if (j == 2) {
                                            stateloss.setLine("400");
                                        }
                                        if (j == 4) {
                                            stateloss.setLine("220");
                                        }
                                        if (j == 6) {
                                            stateloss.setLine("132");
                                        }
                                        if (j == 8) {
                                            stateloss.setLine("110");
                                        }
                                        if (j == 10) {
                                            stateloss.setLine("66");
                                        }

                                        if (j == 12) {
                                            stateloss.setLine("33");
                                        }
                                        if (j == 14) {
                                            stateloss.setLine("22");
                                        }

                                        if (j == 16) {
                                            stateloss.setLine("11");
                                        }

                                        if (j == 18) {
                                            stateloss.setLine("Other");
                                        }


                                        stateloss.setLossType1("Injection");
                                        stateloss.setLossValue(numbers2[i][j]);
                                        stateloss.setIssuedate(dte.dataBaseFmt(issueDate));
                                        stateloss.setPeriodfrom(dte.dataBaseFmt(fromDate));
                                        stateloss.setPeriodto(dte.dataBaseFmt(toDate));
                                        stateloss.setCreatedOn(timeStampDate);
                                        stateloss.setArchive("New");
                                    } else if (j % 2 == 1) {
                                        stateloss.setState(id);
                                        stateloss.setLossType("Discom");
                                        if (j == 3) {
                                            stateloss.setLine("400");
                                        }
                                        if (j == 5) {
                                            stateloss.setLine("220");
                                        }
                                        if (j == 7) {
                                            stateloss.setLine("132");
                                        }
                                        if (j == 9) {
                                            stateloss.setLine("110");
                                        }
                                        if (j == 11) {
                                            stateloss.setLine("66");
                                        }

                                        if (j == 13) {
                                            stateloss.setLine("33");
                                        }
                                        if (j == 15) {
                                            stateloss.setLine("22");
                                        }

                                        if (j == 17) {
                                            stateloss.setLine("11");
                                        }

                                        if (j == 19) {
                                            stateloss.setLine("Other");
                                        }

                                        stateloss.setLossType1("Withdrawl");
                                        stateloss.setLossValue(numbers2[i][j]);
                                        stateloss.setIssuedate(dte.dataBaseFmt(issueDate));
                                        stateloss.setPeriodfrom(dte.dataBaseFmt(fromDate));
                                        stateloss.setPeriodto(dte.dataBaseFmt(toDate));

                                        stateloss.setCreatedOn(timeStampDate);
                                        stateloss.setArchive("New");
                                    }
                                    stateloss.setLossDataId(lossdata.getId().intValue());
                                    multiActionDao.executePojoSaveObjectBuilder(stateloss);


                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
                msg = "{\"result\":\"Success\"}";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    public boolean deleteRecords(String tablename, String field, String id) {
        boolean res = false;
        res = addDao.deleteRecords("delete from " + tablename + " where " + field + " = '" + id + "'");
        return res;
    }

    public boolean updateRecordStatus(String id, String type, String status) {
        boolean res = false;
        String tableName = "", field = "", updateField = "";
        if (type.equals("Stateloss")) {
            tableName = "Lossdata";
            updateField = "status";
            field = "id";
            res = addDao.updateRecordsStaus("update " + tableName + " set " + updateField + "='" + status + "' where " + field + " = '" + id + "'");
            tableName = "Stateloss";
            updateField = "archive";
            field = "lossDataId";
            res = addDao.updateRecordsStaus("update " + tableName + " set " + updateField + "='" + status + "' where " + field + " = '" + id + "'");
        }
        if (type.equals("POCloss")) {
            tableName = "Lossdata";
            updateField = "status";
            field = "id";
            res = addDao.updateRecordsStaus("update " + tableName + " set " + updateField + "='" + status + "' where " + field + " = '" + id + "'");
            tableName = "Newpocloss";
            field = "lossDataId";
            res = addDao.updateRecordsStaus("update " + tableName + " set " + updateField + "='" + status + "' where " + field + " = '" + id + "'");
        }
        return res;
    }

    java.sql.Timestamp getTimeStampDate() {
        Date saveDate = new Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        return timeStampDate;
    }

    @Transactional
    public String hello() {
        return "Hello fiegn";
        //return authServiceFeignClient.getHello();
    }

    //scheduling

    @Transactional
    public boolean saveDiscomScheduleee(Discomschedulemaster schedulemaster, Collection<Discomschedulesources> scheduleSoucesCollection) {
        return addDao.saveDiscomScheduleee(schedulemaster, scheduleSoucesCollection);
    }

    @Transactional
    public boolean saveDiscomSchedule(Discomschedulemaster schedulemaster, Collection<Discomschedulesources> scheduleSoucesCollection, Emergencyschedulerevision emergencyschedulerevision) {
        return addDao.saveDiscomSchedule(schedulemaster, scheduleSoucesCollection, emergencyschedulerevision);
    }


}