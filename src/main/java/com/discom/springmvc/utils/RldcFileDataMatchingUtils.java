package com.discom.springmvc.utils;

import com.discom.springmvc.dao.AddDao;
import com.discom.springmvc.dao.SearchDao;
import com.discom.springmvc.pojo.*;
import com.discom.springmvc.service.AdminDataService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.sql.Timestamp;
import java.util.*;

public class RldcFileDataMatchingUtils {

    ConvertDateFormat cdf = new ConvertDateFormat();

    public static String getPath() {
        String path = "";
        URL resource;
        try {
            resource = Class.forName("com.discom.spingmvc.utils.NewScheduleCount").getResource("/");

            path = resource.getPath();
            path = path.replace("WEB-INF/classes/", "");
            path = path.replace("%20", " ");
            path = path.replaceFirst("/", "");

        } catch (ClassNotFoundException e) {

        }
        return path;
    }

    @Transactional
    public boolean matchRLDCFiles(String schedulemasterid, String wpdmasterid, String wpdId, String wpdregions, String scheduledate, String revno, SearchDao searchDao,
                                  AdminDataService adminDataService, HttpServletRequest request) {

        boolean dataMatch = true;
        try {
            Discomschedulemaster schedule = searchDao.findDiscomScheduleById(schedulemasterid);
            Portfoliomaster wpd = adminDataService.getPortfoliomaster(wpdmasterid);
            Wpdregionnames wpdregionnames = searchDao.getWpdregionnamesByWPDMIDRegionShortName(wpdmasterid, wpdregions);
            String sellernameacctoregion = wpdregionnames.getWpdregionname();
            Rldcdownloads rldcdownloads = searchDao.getRldcDownloaddatafileRegionWise(schedulemasterid, cdf.dataBaseFmt(scheduledate), revno, wpdmasterid, wpdregions);
            ServletContext context = request.getServletContext();
            String appPath = context.getRealPath("");
            String downloadFileNameRLDC = scheduledate + "_" + wpdId + "_" + " REV_" + revno + ".xlsx";
            String downloadrouteRLDC = scheduledate + "/" + wpdId + "/" + "R-" + revno + "/" + wpdregions + "/";
            String downloadPathRLDC = appPath + "/static/alldata/schedule/downloadrldcfile/" + downloadrouteRLDC + downloadFileNameRLDC;
            String downloadFileNameWPD = wpdId + "@LTOA@Requisition@" + scheduledate.split("-")[0] + scheduledate.split("-")[1] + scheduledate.split("-")[2].substring(2, 4) + ".csv";
            //String downloadFileNameWPDEX = wpdId+"@LTOA@Requisition@"+scheduledate.split("-")[0]+scheduledate.split("-")[1]+scheduledate.split("-")[2].substring(2, 4)+".xlsx";
            //String downloadFileNameWPDEX = sellernameacctoregion+"@LTOA@Requisition@"+scheduledate.split("-")[0]+scheduledate.split("-")[1]+scheduledate.split("-")[2].substring(2, 4)+".xlsx";
            String downloadFileNameWPDEX = sellernameacctoregion + "@LTOA@Requisition@" + scheduledate.split("-")[0] + scheduledate.split("-")[1] + scheduledate.split("-")[2].substring(2, 4) + "_" + wpdregions + "_R_" + revno + ".xlsx";
            String downloadrouteWPDD = scheduledate + "/" + wpdId + "/" + "R-" + revno + "_" + schedule.getLtoano().replace("/", "_") + "/" + wpdregions + "/";
            String downloadPathWPD = appPath + "/static/alldata/schedule/downloadedfile/" + downloadrouteWPDD + downloadFileNameWPD;
            String downloadPathWPDEX = appPath + "/static/alldata/schedule/downloadedfileexcel/" + downloadrouteWPDD + downloadFileNameWPDEX;
            //System.out.println("in WPD file ");
            List<List<String>> wpddata = getExcelData(downloadPathWPDEX);//CSV
            //System.out.println("WPD: "+wpddata);
            List<List<String>> rldcdata = getExcelDataa(downloadPathRLDC);//EXCEL
            //System.out.println("RLDC: "+rldcdata);
            //	for(int i=0;i<wpddata.size();i++)
            //{
            //System.out.println("WPD: "+wpddata.get(i));
            //}
            //for(int i=0;i<rldcdata.size();i++)
            //{
            //System.out.println("RLDC: "+rldcdata.get(i));
            //	}
            List<String> timedesclist = new ArrayList<String>();
            for (int i = 0; i < 96; i++) {
                timedesclist.add(i, new ConvertDateFormat().calTimePeriodForIndex(i));
            }
            Map<String, String> dataMap = new HashMap<String, String>();
            List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
            for (int j = 2; j < wpddata.get(0).size(); j++) {
                dataMap = new HashMap<String, String>();
                for (int i = 0; i < wpddata.size(); i++) {
                    if (i == 1) {
                        dataMap.put("seller", wpddata.get(i).get(j));
                    }
                    if (i == 3)//if(i==2)
                    {
                        dataMap.put("buyer", wpddata.get(i).get(j));
                    }
                    if (i > 4 && i < 101) {
                        dataMap.put(wpddata.get(i).get(1), wpddata.get(i).get(j));
                    }
                }
                dataList.add(dataMap);
            }
            for (Map<String, String> m : dataList) {
                if (m.containsKey("seller")) {
						/*System.out.println(m.get("seller"));
						System.out.println(m.get("buyer"));
						System.out.println(m.keySet().size());
						System.out.println(m.keySet());
						System.out.println(m.values());*/
                }
            }
            Map<String, String> dataMapp = new HashMap<String, String>();
            List<Map<String, String>> dataListt = new ArrayList<Map<String, String>>();
            for (Map<String, String> m : dataList) {
                for (int j = 2; j < rldcdata.get(0).size(); j++) {
                    dataMapp = new HashMap<String, String>();
                    boolean matchSeller = false, matchBuyer = false;
                    for (int i = 0; i < rldcdata.size(); i++) {
                        if (i == 1) {
                            //	System.out.println("SELLERMATCH: "+m.get("seller")+" || "+rldcdata.get(i).get(j));
                            if (m.get("seller").equals(rldcdata.get(i).get(j))) {
                                matchSeller = true;
                            }
                        }
                        if (i == 3) {
                            //	System.out.println("BUYERMATCH: "+m.get("buyer")+" || "+rldcdata.get(i).get(j));
                            if (m.get("buyer").equals(rldcdata.get(i).get(j))) {
                                matchBuyer = true;
                            }
                            if (m.get("buyer").split("-")[0].equals(rldcdata.get(i).get(j)))//for -ER in totocorin_GIREL
                            {
                                matchBuyer = true;
                            }
                        }
                        if (matchSeller == true && matchBuyer == true) {
                            dataMapp.put("seller", m.get("seller"));
                            dataMapp.put("buyer", m.get("buyer"));
                            if (i > 4 && i < 101) {
                                //System.out.println(rldcdata.get(i).get(1)+" ___ "+rldcdata.get(i).get(j));
                                dataMapp.put(rldcdata.get(i).get(1), rldcdata.get(i).get(j));
                            }
                        }
                    }
                    if (matchSeller == true && matchBuyer == true) {
                        dataListt.add(dataMapp);
                    }
                }
            }
            for (Map<String, String> m : dataListt) {
                if (m.containsKey("seller")) {
						/*System.out.println(m.get("seller"));
						System.out.println(m.get("buyer"));
						System.out.println(m.keySet().size());
						System.out.println(m.keySet());
						System.out.println(m.values());*/
                }
            }
            for (int i = 0; i < dataList.size(); i++) {
                if (dataList.get(i).get("seller").equals(dataListt.get(i).get("seller")) && dataList.get(i).get("buyer").equals(dataListt.get(i).get("buyer"))) {
                    for (int j = 0; j < timedesclist.size(); j++) {
                        //	System.out.println(dataList.get(i).get(timedesclist.get(j))+" || "+dataListt.get(i).get(timedesclist.get(j)));

                        //if(!dataList.get(i).get(timedesclist.get(j)).equals(dataListt.get(i).get(timedesclist.get(j))))
                        BigDecimal aa = new BigDecimal(dataList.get(i).get(timedesclist.get(j))).setScale(2, RoundingMode.HALF_UP);
                        BigDecimal bb = new BigDecimal(dataListt.get(i).get(timedesclist.get(j))).setScale(2, RoundingMode.HALF_UP);
                        if (aa.compareTo(bb) != 0) {
                            dataMatch = false;
                            System.out.println("Data Not matched!");
                            break;
                        }
                    }
                }
            }
            //System.out.println(dataList.size()+" |||| "+dataListt.size());
        } catch (Exception e) {
            e.printStackTrace();
            dataMatch = false;
        }
        return dataMatch;
    }

    public List<List<String>> getExcelData(String filepath) {
        //System.out.println(filepath);
        List<String> data = new ArrayList<String>();
        List<List<String>> alldata = new ArrayList<List<String>>();
        Workbook wb1 = null;
        Row row;
        Cell cell;
        int rows; // No of rows
        int cols = 0; // No of columns
        try {
            //System.out.println(" in reading file");

            //System.out.println(filepath);
            wb1 = new XSSFWorkbook(filepath);

            Sheet sheet = wb1.getSheetAt(0);
            rows = sheet.getPhysicalNumberOfRows();
            //System.out.println("rows "+rows);
            int coll = 0;
            for (int r1 = 0; r1 <= rows; r1++) {
                row = sheet.getRow(r1);
                if (row != null)
                    if (sheet.getRow(r1).getPhysicalNumberOfCells() >= coll) {
                        coll = sheet.getRow(r1).getPhysicalNumberOfCells();
                        //System.out.println("coll "+coll);
                    }
            }
            // System.out.println("total rows "+rows);
            for (int r1 = 0; r1 <= rows; r1++) {
                row = sheet.getRow(r1);
                if (row != null) {
                    cols = sheet.getRow(r1).getPhysicalNumberOfCells();//sheet.getRow(r1).getLastCellNum();//getPhysicalNumberOfCells();
                    data = new ArrayList<String>();
                    for (int c = 0; c < coll; c++) {
                        cell = row.getCell((short) c);
                        if (cell != null) {
                            if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
                                data.add(cell.getNumericCellValue() + "");
                                //System.out.println(cell.getNumericCellValue()+"");
                            } else if (cell.getCellType() == cell.CELL_TYPE_STRING) {
                                String val = cell.getStringCellValue() + "";
                                if (val.equals("null"))
                                    val = "";
                                data.add(val);
                                //System.out.println(cell.getStringCellValue()+"");
                            } else {
                                //System.out.println("(cell.toString(): "+cell.getCellType()+" VAL: "+(cell.toString()));
                            }
                        } else {
                            data.add("");
                        }
                    }
                    // System.out.println("in end data "+data);
                    alldata.add(data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alldata;
    }

    public List<List<String>> getExcelDataa(String filepath) {
        //System.out.println(filepath);
        List<String> data = new ArrayList<String>();
        List<List<String>> alldata = new ArrayList<List<String>>();
        Workbook wb1 = null;
        Row row;
        Cell cell;
        int rows; // No of rows
        int cols = 0; // No of columns
        try {
            wb1 = new XSSFWorkbook(filepath);
            Sheet sheet = wb1.getSheetAt(0);
            rows = sheet.getPhysicalNumberOfRows();
            int coll = 0;
            for (int r1 = 0; r1 <= rows; r1++) {
                row = sheet.getRow(r1);
                if (row != null)
                    if (sheet.getRow(r1).getPhysicalNumberOfCells() >= coll) {
                        coll = sheet.getRow(r1).getPhysicalNumberOfCells();
                    }
            }
            for (int r1 = 0; r1 <= rows; r1++) {
                row = sheet.getRow(r1);
                if (row != null) {
                    if (r1 == 1 || r1 == 6 || r1 == 7 || r1 == 10 || r1 > 10)//if(r1==1 || r1==6 || r1==7 || r1==8 || r1>10)
                    {
                        cols = sheet.getRow(r1).getPhysicalNumberOfCells();//sheet.getRow(r1).getLastCellNum();//getPhysicalNumberOfCells();
                        data = new ArrayList<String>();
                        for (int c = 0; c < coll; c++) {
                            cell = row.getCell((short) c);
                            if (cell != null) {
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                //if(!cell.getStringCellValue().equals(""))
                                {
                                    data.add(cell.getStringCellValue().trim().replace("'", ""));
                                }
                            } else {
                                data.add("");
                            }
                        }
                        alldata.add(data);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alldata;
    }

    @Transactional
    public void downloadRLDCFiles1(String schedulemasterid, String wpdregions, AddDao addDao, SearchDao searchDao, AdminDataService adminDataService) {
        try {
            System.out.println("schedulemasterid: " + schedulemasterid + " wpdregions: " + wpdregions);
            java.util.Date saveDate = new java.util.Date();
            Timestamp timeStampDate = new Timestamp(saveDate.getTime());
            Discomschedulemaster schedule = searchDao.findDiscomScheduleById(schedulemasterid);
            schedule.setScheduleDate(cdf.dataBaseFmt(schedule.getScheduleDate()));
            Portfoliomaster wpd = adminDataService.getPortfoliomaster(schedule.getId() + "");

            int rldcrevno = 0;
            String rldcsellerid = "ALL";
            String parameters = "";
            String urlPath = getRldcMap(searchDao).get(wpdregions + "LDC") + parameters;
            System.out.println("Downoad PATH: " + urlPath);
            String downloadFileName = schedule.getScheduleDate() + "_" + wpd.getPortfolioId() + "_" + " REV_" + schedule.getRevisionno() + ".xlsx";
            String downloadroute = schedule.getScheduleDate() + "/" + wpd.getPortfolioId() + "/" + "R-" + schedule.getRevisionno() + "/" + wpdregions + "/";
            File dir = new File(getPath() + "static/alldata/schedule/downloadrldcfile/" + downloadroute);
            if (!dir.exists())
                dir.mkdirs();

            String downloadPath = getPath() + "static/alldata/schedule/downloadrldcfile/" + downloadroute + downloadFileName;
            boolean download = false;
            if (download == true) {
                Rldcdownloads rldcdownloads = new Rldcdownloads();
                rldcdownloads.setMasterid(null);
                rldcdownloads.setDownloadby("System");
                rldcdownloads.setIsdownloaded(download);
                rldcdownloads.setDownloaddate(timeStampDate);
                rldcdownloads.setFilename(downloadFileName);
                rldcdownloads.setSchedulemasterid(schedule.getScheduleMasterid());
                rldcdownloads.setRldc(schedule.getRegion() + "LDC");
                rldcdownloads.setScheduledate(cdf.dataBaseFmt(schedule.getScheduleDate()));
                rldcdownloads.setWpdid(schedule.getWpdid());
                rldcdownloads.setWpdname(schedule.getWpdname());
                rldcdownloads.setRevno(schedule.getRevisionno());
                rldcdownloads.setRldcrevno(rldcrevno);
                rldcdownloads.setWpdmasterid(schedule.getId());
                rldcdownloads.setRegionfor(wpdregions);
                /// addDao.saveRldcdownloads(rldcdownloads);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> getRldcMap(SearchDao searchDao) {
        Map<String, String> map = new HashMap<String, String>();
        List<Rldcsetting> rldcS = searchDao.getRldcList();
        for (Rldcsetting rldc : rldcS) {
            map.put(rldc.getRldc(), rldc.getUrl());
        }
        return map;
    }

    public void createCSVTOExcel(String sourcePath, String destinationPath) throws Exception {
        Workbook wb = new HSSFWorkbook();
        CreationHelper helper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("new sheet");

        BufferedReader reader = new BufferedReader(new FileReader(sourcePath));
        String line = null;
        Scanner scanner = null;
        int r = 0;
        int indexx = 0;
        while ((line = reader.readLine()) != null) {
            Row row = sheet.createRow((short) r++);
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                String dataa = scanner.next();
                row.createCell(indexx).setCellValue(helper.createRichTextString(dataa));
                indexx++;
            }
            indexx = 0;
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream(destinationPath);
        wb.write(fileOut);
        fileOut.close();

    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

}