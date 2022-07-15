package com.discom.springmvc.serviceimpl;

import com.discom.springmvc.dao.AddDao;
import com.discom.springmvc.dao.ListDao;
import com.discom.springmvc.dao.MultiActionDao;
import com.discom.springmvc.dao.SearchDao;
import com.discom.springmvc.pojo.*;
import com.discom.springmvc.service.AddService;
import com.discom.springmvc.service.AdminDataService;
import com.discom.springmvc.service.ScheduleService;
import com.discom.springmvc.utils.*;
import com.discom.springmvc.validator.ContactFormValidator;
import com.discom.springmvc.validator.FormValidator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service("scheduleService")

@Transactional
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    AddService addService;
    @Autowired
    MultiActionDao multiActionDao;
    DateDifference dateDifference = new DateDifference();
    ConvertDateFormat cdf = new ConvertDateFormat();
    @Autowired
    private ListDao listDao;
    @Autowired
    private SearchDao searchDao;
    @Autowired
    private AddDao addDao;
    @Autowired
    private AdminDataService adminDataService;
    @Autowired
    private Environment env;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    @Autowired
    private FormValidator formValidator;
    private CurrentDate currentDate = new CurrentDate();
    @Autowired
    private ContactFormValidator validator;

    /*
     * public String newDiscomScheduleeexcelF( String date,String masterid, String
     * ltoano, String imergencySchedule, String lastSchedule, String graceSchedule,
     * Discomschedulemaster discomschedulemaster) throws Exception {
     */
    public String newDiscomScheduleeexcelF(String date, String filepath) {
        try {
            String masterid = "3";
            String ltoano = "INTRA";
            String imergencySchedule = null;
            String lastSchedule = null;
            String graceSchedule = null;
            System.out.println("scheduleDate: " + date + " masterid: " + masterid);
            System.out.println("imergencySchedule: " + imergencySchedule + " graceSchedule: " + graceSchedule);

            Date saveDate = new Date();
            Timestamp timeStampDate = new Timestamp(saveDate.getTime());
            List<String> dates = cdf.getCurrAndNextDate();
            //	User user = searchDao.findUserByUserId(getPrincipal());
            String fileNameToSave = "";
            String role = "";
            String clientwpd = "";
            role = "ADMIN";
            List<Portfoliomaster> wpdlist = new ArrayList<Portfoliomaster>();
            /*
             * for(UserProfile up:user.getUserProfiles()) {
             * if(up.getType().equals("CLIENT")) role="CLIENT";
             * if(up.getType().equals("ADMIN")) role="ADMIN"; }
             */
            Map<String, String> wpds = new LinkedHashMap<String, String>();
            /*
             * if(role.equals("CLIENT")) { String wpdids[] =
             * user.getConsumerno().split(","); for(int i=0;i<wpdids.length;i++) { Wpdmaster
             * wpdmaster = searchDao.findWPDById(wpdids[i]); wpdlist.add(wpdmaster); }
             * if(wpdlist.size()>1) { for(Wpdmaster wm:wpdlist) { wpds.put(wm.getId()+"",
             * wm.getWpdname()); } clientwpd = "multiple"; } else { clientwpd = "single"; }
             * }
             */
            System.out.println(" before data fetch");
            Portfoliomaster wpdmaster = adminDataService.getPortfoliomaster(masterid);

            System.out.println("port : " + wpdmaster.getPortfolioId());


            // List<Agreementmaster> sourcelist = adminDataService.getWpdActiveAgreementsListByWPDIDForSchedule(cdf.dataBaseFmt(date), masterid, ltoano);

            //System.out.println("sourcelist : "+sourcelist.size());
            List<BigDecimal> energylistt = new ArrayList<BigDecimal>();
            List<List<BigDecimal>> allenergylistt = new ArrayList<List<BigDecimal>>();

            List<List<String>> alldata = new ArrayList<List<String>>();
            List<BigDecimal> sourcepercentage = new ArrayList<BigDecimal>();
            BigDecimal totalofsource = BigDecimal.ZERO;
            BigDecimal totalpowerpuchased = BigDecimal.ZERO;
            //	SourceContractDemand scd=listDao.getAllActiveSourceContract(masterid, cdf.dataBaseFmt(date), ltoano);
            BigDecimal condmd = BigDecimal.ZERO;
            //if(scd!=null)
            //	condmd = new BigDecimal(scd.getContractdemand());
            /*
             * for(int i=0;i<sourcelist.size();i++) {
             * //sourcelist.get(i).setTotalpower(condmd+"");
             * totalofsource=totalofsource.add(new
             * BigDecimal(sourcelist.get(i).getPowerPurchased()));
             * sourcelist.get(i).setPowerPurchased(new
             * BigDecimal(sourcelist.get(i).getPowerPurchased()).setScale(2,
             * RoundingMode.HALF_UP)+"");
             * sourcelist.get(i).setSellerportfolio(wpdmaster.getPortfolioId()); }
             * totalpowerpuchased = totalofsource; if(totalofsource.compareTo(condmd)>0) {
             * totalofsource = BigDecimal.ZERO; for(int i=0;i<sourcelist.size();i++) {
             * sourcelist.get(i).setPowerPurchased(new
             * BigDecimal(sourcelist.get(i).getPowerPurchased()).divide(totalpowerpuchased,
             * 2, RoundingMode.HALF_UP).multiply(condmd).setScale(2,
             * RoundingMode.HALF_UP)+"");
             * System.out.println("Ratio: "+sourcelist.get(i).getPowerPurchased());
             * totalofsource=totalofsource.add(new
             * BigDecimal(sourcelist.get(i).getPowerPurchased()));
             * sourcelist.get(i).setSellerportfolio(wpdmaster.getPortfolioId()); } }
             * totalofsource = totalofsource.setScale(2, RoundingMode.HALF_UP);
             */
            totalofsource = BigDecimal.ONE;
            condmd = condmd.setScale(2, RoundingMode.HALF_UP);
            /*
             * for(int i=0;i<sourcelist.size();i++) { sourcepercentage.add(i,new
             * BigDecimal(sourcelist.get(i).getPowerPurchased()).divide(totalofsource, 2,
             * RoundingMode.HALF_UP).multiply(new BigDecimal("100"))); }
             */
            List<String> datelist = new ArrayList<String>();
            List<String> timelist = new ArrayList<String>();
            List<String> sellerlist = new ArrayList<String>();
            List<String> buyerlist = new ArrayList<String>();
            List<String> sourcedestlist = new ArrayList<String>();
            List<String> reqlist = new ArrayList<String>();
            List<String> energylist = new ArrayList<String>();
            List<List<String>> allenergylist = new ArrayList<List<String>>();
            List<String> dataList = new ArrayList<String>();
            List<List<String>> allDataList = new ArrayList<List<String>>();
            String path = UtilityClass.dataPath();
            path = path + "/schedule/tempuploadedfile/";

            String filetype = "EXCEL";
            /*
             * RldcMatchingUtilsNew filesDownload = new RldcMatchingUtilsNew(); List<String>
             * listData = filesDownload.downloadRLDCScheduleFiles(masterid, date, searchDao,
             * apiService);
             *
             * String downloadedFileName = listData.get(0); String downloadedFileRev =
             * listData.get(1); String downloadedFileDtm = listData.get(2);
             * Map<String,String>errorMap=new HashMap<String,String>();
             * if(downloadedFileName.equals("")) { ObjectError errors = new
             * ObjectError("requestDesc", "File not found or RLDC url not found for WPD");
             * errorMap.put("error", "File not found or RLDC url not found for WPD");
             *
             * errorMap.put("filenotfound", "File not found or RLDC url not found for WPD");
             * errorMap.put("wpdmasterid", masterid); errorMap.put("wpdname",
             * wpdmaster.getPortfolioName()); //errorMap.put("wpdLTOAList",
             * getWPDLTOANos(masterid)); errorMap.put("wpdltoano", ltoano);
             * errorMap.put("role", role); errorMap.put("clientwpd", clientwpd);
             * //errorMap.put("clientids", wpds); //errorMap.put("dates", dates);
             * errorMap.put("sdate", ""); //errorMap.put("ids", getWPDs());
             * errorMap.put("imergencySchedule", imergencySchedule);
             * errorMap.put("graceSchedule", graceSchedule); errorMap.put("lastSchedule",
             * lastSchedule);
             *
             * int revv = 0; Discomschedulemaster mostoldschedule =
             * searchDao.getLastRevOfDiscomSchedule(cdf.dataBaseFmt(date), masterid,
             * ltoano); if(mostoldschedule!=null) { revv = mostoldschedule.getRevisionno();
             * } // errorMap.put("revv", revv); //errorMap.put("presdate", false);
             * errorMap.put("loggedinuser", ""); return "discomschedulestep2excel"; }
             */
            //File fileName = new File(path+downloadedFileName);
            //   MultipartFile  fileName = convertFiletoMultiPart(path+downloadedFileName);


            //   String tempfilename = downloadedFileName;//cdf.getFileNameWithCurrentDateTimeMS(timeStampDate+"", fileName);
            /*
             * if (!fileName.isEmpty()) { try { BufferedOutputStream stream = new
             * BufferedOutputStream(new FileOutputStream(new File(path+tempfilename)));
             * stream.write(fileName.getBytes()); stream.close(); } catch (Exception e) {
             * e.printStackTrace(); } }
             */

            if (filetype.equals("EXCEL"))//DownloadFromRLDC
            {
                //String filepath = path+tempfilename;
                HashMap<String, String> result = new HashMap<String, String>();

                /*
                 * validator.validateSchedulesDownloadFromRLDC(ltoano,imergencySchedule,
                 * masterid, date, sourcelist, filepath, role, result); if(result.size()>1) {
                 *
                 * errorMap.put("wpdmasterid", masterid); errorMap.put("wpdname",
                 * wpdmaster.getPortfolioName()); //errorMap.put("wpdLTOAList",
                 * getWPDLTOANos(masterid)); errorMap.put("wpdltoano", ltoano);
                 * errorMap.put("role", role); errorMap.put("clientwpd", clientwpd);
                 * //errorMap.put("clientids", wpds); //errorMap.put("dates", dates);
                 * errorMap.put("sdate", ""); //errorMap.put("ids", getWPDs());
                 * errorMap.put("imergencySchedule", imergencySchedule);
                 * errorMap.put("graceSchedule", graceSchedule); errorMap.put("lastSchedule",
                 * lastSchedule);
                 *
                 * int revv = 0; Discomschedulemaster mostoldschedule =
                 * searchDao.getLastRevOfDiscomSchedule(cdf.dataBaseFmt(date), masterid,
                 * ltoano); if(mostoldschedule!=null) { revv = mostoldschedule.getRevisionno();
                 * } //errorMap.put("revv", revv); //errorMap.put("presdate", false);
                 * errorMap.put("loggedinuser", ""); return "discomschedulestep2excel";
                 *
                 * } else
                 */
				/*{

					String path2 = UtilityClass.dataPath();
				    path2=path2+"/schedule/uploadedfile/";
				    fileNameToSave = cdf.getFileNameWithCurrentDateTime(timeStampDate+"", fileName, masterid);//yyyyMMdd_hhmmss_filename.ext
				    fileNameToSave = fileNameToSave.replaceAll(" ", "_").replaceAll("%", "_");

				    if (!fileName.isEmpty()) {
			            try {
			                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(path2+fileNameToSave)));
			                stream.write(fileName.getBytes());
			                stream.close();

			               File f = new File(filepath);
			 			  //deleteFile
			 			  if(f.exists())
			 			  {
			 				System.out.println("File newpath "+filepath+f.canWrite()+f.canExecute());

			                boolean isDelete = f.delete();
			                if(isDelete==true)
			                {
			                	System.out.println("File Deleted Successfully: "+filepath);
			                }
			 			  }
			            } catch (Exception e) {
			                e.printStackTrace();
			            }
			        }


			        Scheduledatafile scheduledatafile = new Scheduledatafile();
			     	scheduledatafile.setId(null);
			     	scheduledatafile.setWpdid(Integer.parseInt(masterid));
			     	scheduledatafile.setStatus("");
			     	scheduledatafile.setScheduleDate(cdf.dataBaseFmt(date));
			     	scheduledatafile.setFileName(fileNameToSave);
			     	scheduledatafile.setCreatedBy("");
			     	scheduledatafile.setUploadedBy("");
			     	scheduledatafile.setCreatedOn(timeStampDate);
			     	scheduledatafile.setUploadedOn(timeStampDate);
			     	//addDao.addScheduleDataFile(scheduledatafile);
			     	multiActionDao.executePojoSaveObjectBuilder(scheduledatafile);*/

                Workbook wb1 = null;
                Row row;
                Cell cell;
                int rows; // No of rows
                int cols = 0; // No of columns
                try {
                    //  System.out.println("path+tempfilename "+path+" filepath  "+filepath);
                    // wb1 = new XSSFWorkbook(path+tempfilename);//path2+fileNameToSave);
                    wb1 = new XSSFWorkbook(filepath);

                    Sheet sheet = wb1.getSheetAt(0);
                    //  System.out.println(" sheet  "+sheet.getSheetName());
                    rows = sheet.getPhysicalNumberOfRows();
                    //  System.out.println(" rows  "+rows);
                    for (int r1 = 0; r1 <= rows; r1++) {
                        row = sheet.getRow(r1);
                        if (row != null) {
                            cols = sheet.getRow(5).getLastCellNum();//getPhysicalNumberOfCells();
                            dataList = new ArrayList<String>();
                            //for (int c = 0; c < (2+sourcelist.size()); c++) {
                            for (int c = 0; c < (cols); c++) {
                                cell = row.getCell((short) c);

                                if (cell != null) {
                                    System.out.println(" cell val  " + c + "  " + cell.toString() + " type " + cell.getCellType());
                                    if (r1 != 0)
                                        cell.setCellType(Cell.CELL_TYPE_STRING);
                                    if (r1 == 0) {
                                        dataList.add(cell.toString().trim());
                                    } else if (!cell.getStringCellValue().equals("")) {
                                        dataList.add(cell.getStringCellValue().trim());
                                    }
                                }
                            }
                            allDataList.add(dataList);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //  System.out.println(" allDataList  "+allDataList);
                //   System.out.println(" allDataList  "+allDataList.size());
                String wpdname = "";

                Sheet sheet = wb1.getSheetAt(0);
                cols = sheet.getRow(2).getPhysicalNumberOfCells();
                //	System.out.println("cols "+cols);
                //  List<Agreementmaster> sourcelist = new ArrayList<Agreementmaster>();
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (i == 0)
                            if (j >= 0) {
                                datelist.add(allDataList.get(i).get(j));
                            }
                        if (i == 2)
                            if (j >= 0) {
                                sellerlist.add(allDataList.get(i).get(j));
                            }
                        if (i == 3)
                            if (j >= 0) {
                                buyerlist.add(allDataList.get(i).get(j));
                            }
                        if (i == 4)
                            if (j >= 0) {
                                sourcedestlist.add(allDataList.get(i).get(j));
                            }
                    }
                }
                for (int i = 5; i < 101; i++) {

                    timelist.add(allDataList.get(i).get(1));

                }
                for (int i = 0; i < allDataList.size(); i++) {

                    if (i > 4) {
                        energylist = new ArrayList<String>();
                        energylistt = new ArrayList<BigDecimal>();
                    }
                    if (i != 4 && i < 101)
                        // 	for(int ii=0;ii<sourcelist.size();ii++)
                        for (int ii = 0; ii < 1; ii++) {    //System.out.println("allDataList.get(i).size() "+allDataList.get(i).size());
                            for (int j = 2; j < allDataList.get(i).size(); j++) {
                                /*
                                 * System.out.println("allDataList.get(0) "+allDataList.get(0));
                                 * System.out.println("allDataList.get(1) "+allDataList.get(1));
                                 * System.out.println("allDataList.get(2) "+allDataList.get(2).get(0));
                                 * System.out.println("allDataList.get(3) "+allDataList.get(3).get(0));
                                 * System.out.println("allDataList.get(4) "+allDataList.get(4).get(0));
                                 */

                                //System.out.println("Size "+i+" || "+ii+" || "+j+" "+allDataList.get(i).size());
                                //System.out.println("From File "+(allDataList.get(2).get((i>11 && i<108)?(j-1):j))+" | "+(allDataList.get(3).get((i>11 && i<108)?(j-1):j))+" | "+(allDataList.get(4).get((i>11 && i<108)?(j-1):j)));
                                //System.out.println("SourceDD "+sourcelist.get(ii).getSellerportfolioid()+" "+sourcelist.get(ii).getPpadiscomname());
                                //	if((allDataList.get(6).get((i>11 && i<108)?(j-1):j)).equals(sourcelist.get(ii).getSellerportfolio()) && (allDataList.get(8).get((i>11 && i<108)?(j-1):j)).equals(sourcelist.get(ii).getPpadiscomname()) && (allDataList.get(10).get((i>11 && i<108)?(j-1):j)).equals(sourcelist.get(ii).getPpasourcedest()))

                                //	System.out.println("i= "+i+" j= "+j+" psadiscomname "+psadiscomname);
                                //  List<Agreementmaster> sourcelist=;
                                String psadiscomname = "", ppadiscomname = "", approvalno = "";
                                if (i == 0) {
                                    psadiscomname = allDataList.get(2).get((i > 4 && i < 101) ? (j - 2) : j - 2);
                                    ppadiscomname = allDataList.get(3).get((i > 4 && i < 101) ? (j - 2) : j - 2);
                                    approvalno = allDataList.get(4).get((i > 4 && i < 101) ? (j - 2) : j - 2);
                                    // 	sourcelist = adminDataService.getWpdActiveAgreementsListByWPDIDForSchedule(cdf.dataBaseFmt(date), ppadiscomname,  psadiscomname, approvalno);
                                }
                                //System.out.println("sourcelist size new  "+sourcelist.size());
                                //System.out.println("sourcelist.get(ii).getPpadiscomname()) "+sourcelist.get(ii).getPpadiscomname());
                                //System.out.println("sourcelist.get(ii).getApplicationNo()) "+sourcelist.get(ii).getApprovalNo());
                                //	if(psadiscomname.equals(sourcelist.get(0).getPsadiscomname()) && (ppadiscomname.equals(sourcelist.get(0).getPpadiscomname())) && (approvalno.equals(sourcelist.get(0).getApprovalNo())))

                                {
                                    //System.out.println("From File "+(allDataList.get(6).get(j))+" | "+(allDataList.get(8).get(j))+" | "+(allDataList.get(10).get(j)));
                                    //System.out.println("SourceDD "+sourcelist.get(ii).getSellerportfolioid()+" "+sourcelist.get(ii).getPpadiscomname());
                                    if (i == 0) {
                                        //if(j==0)
                                        //wpdname = allDataList.get(i).get(j);
                                        //if(j==1)
                                        //date = allDataList.get(i).get(j);
                                    }
                                    /*
                                     * if(i==2) if(j>0) { sellerlist.add(allDataList.get(i).get(j-2)); } if(i==3)
                                     * if(j>0) { buyerlist.add(allDataList.get(i).get(j-2)); } if(i==4) if(j>0) {
                                     * sourcedestlist.add(allDataList.get(i).get(j-2)); }
                                     */
                                    if (i == 4) {
                                        //if(!allDataList.get(i).get(j).equals("Total"))
                                        //reqlist.add(allDataList.get(i).get(j));
                                    }
                                    if (i > 4) {
                                        if (j == 1 && i < 101) {
                                            energylist.add(allDataList.get(i).get(j));
                                            //	System.out.println("allDataList.get(i).get(j) : "+allDataList.get(i).get(j));
                                        }
                                        if (i < 101) {
                                            if (j > 1) {
                                                energylistt.add(new BigDecimal(allDataList.get(i).get(j)).setScale(2, RoundingMode.HALF_UP));
                                            }
                                        } else {
                                            if (j > 0) {
                                                energylistt.add(new BigDecimal(allDataList.get(i).get(j)).setScale(8, RoundingMode.HALF_UP));
                                            }
                                        }

                                    }
                                }
                            }
                        }
                    if (i > 4 && i < 101 && i != 4) {
                        allenergylist.add(energylist);
                        allenergylistt.add(energylistt);
                    }
                }
                System.out.println(" allenergylist " + allenergylist);
                System.out.println(" allenergylistt " + allenergylistt);
                System.out.println(" datelist " + datelist);
                System.out.println(" buyerlist " + buyerlist);
                System.out.println(" sellerlist " + sellerlist);
                System.out.println(" timelist " + timelist);
                System.out.println(" sourcedestlist " + sourcedestlist);

            } else    //csvfile uploading...
            {
                //String filepath = path+tempfilename;
			    	/*String destinationPath = path+tempfilename.replace(".csv", ".xlsx");
			    	CreateCSVToExcel csvtoEls = new CreateCSVToExcel();
			    	csvtoEls.createCSVTOELs(filepath, destinationPath);
			    	filepath  = destinationPath;*/
                /*
                 * HashMap<String,String> result=new HashMap<String,String>();
                 * validator.validateSchedulesCSVDownloadFromRLDC(ltoano,imergencySchedule,
                 * masterid, date, sourcelist, filepath, role, result); if(result.size()>0) {
                 *
                 * errorMap.put("wpdmasterid", masterid); errorMap.put("wpdname",
                 * wpdmaster.getPortfolioName()); //errorMap.put("wpdLTOAList",
                 * getWPDLTOANos(masterid)); errorMap.put("wpdltoano", ltoano);
                 * errorMap.put("role", role); errorMap.put("clientwpd", clientwpd);
                 * //errorMap.put("clientids", wpds); //errorMap.put("dates", dates);
                 * errorMap.put("sdate", ""); //errorMap.put("ids", getWPDs());
                 * errorMap.put("imergencySchedule", imergencySchedule);
                 * errorMap.put("graceSchedule", graceSchedule); errorMap.put("lastSchedule",
                 * lastSchedule); int revv = 0; Discomschedulemaster mostoldschedule =
                 * searchDao.getLastRevOfDiscomSchedule(cdf.dataBaseFmt(date), masterid,
                 * ltoano); if(mostoldschedule!=null) { revv = mostoldschedule.getRevisionno();
                 * } // errorMap.put("revv", revv); //errorMap.put("presdate", false);
                 * errorMap.put("loggedinuser", ""); return "discomschedulestep2excel";
                 *
                 * } else
                 */
			/*	{

					String path2 =UtilityClass.dataPath();
				    path2=path2+"/static/alldata/schedule/uploadedfile/";
				    fileNameToSave = cdf.getFileNameWithCurrentDateTime(timeStampDate+"", fileName, masterid);//yyyyMMdd_hhmmss_filename.ext
				    fileNameToSave = fileNameToSave.replaceAll(" ", "_").replaceAll("%", "_");
				    if (!fileName.isEmpty()) {
			            try {
			                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(path2+fileNameToSave)));
			                stream.write(fileName.getBytes());
			                stream.close();

			               File f = new File(filepath);
			 			  //deleteFile
			 			  if(f.exists())
			 			  {
			 				System.out.println("File newpath "+filepath+f.canWrite()+f.canExecute());

			                boolean isDelete = f.delete();
			                if(isDelete==true)
			                {
			                	System.out.println("File Deleted Successfully: "+filepath);
			                }
			 			  }
			            } catch (Exception e) {
			                e.printStackTrace();
			            }
			        }


			        Scheduledatafile scheduledatafile = new Scheduledatafile();
			     	scheduledatafile.setId(null);
			     	scheduledatafile.setWpdid(Integer.parseInt(masterid));
			     	scheduledatafile.setStatus("");
			     	scheduledatafile.setScheduleDate(cdf.dataBaseFmt(date));
			     	scheduledatafile.setFileName(fileNameToSave);
			     	scheduledatafile.setCreatedBy("");
			     	scheduledatafile.setUploadedBy("");
			     	scheduledatafile.setCreatedOn(timeStampDate);
			     	scheduledatafile.setUploadedOn(timeStampDate);
			     	//addService.addScheduleDataFile(scheduledatafile);
			     	multiActionDao.executePojoSaveObjectBuilder(scheduledatafile);

		   try {

			   Reader reader = new FileReader(path2+fileNameToSave);//Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
		        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

		        for (CSVRecord csvRecord : csvParser) {
		             if (csvRecord != null) {
		            	 dataList = new ArrayList<String>();
	                     for (int c = 0; c < csvRecord.size(); c++) {
	                         if (csvRecord != null) {
	                         	 if(!csvRecord.get(c).equals(""))
	                         	 {
	                         		 dataList.add(csvRecord.get(c).trim());
	                         	 }
	                         }
	                     }
	                     allDataList.add(dataList);
		             }
				}
		   } catch (IOException e) {
		       e.printStackTrace();
		   }*/

                String wpdname = "";

                //  List<Agreementmaster> sourcelist = new ArrayList<Agreementmaster>();
                for (int i = 0; i < allDataList.size(); i++) {
                    if (i > 4) {
                        energylist = new ArrayList<String>();
                        energylistt = new ArrayList<BigDecimal>();
                    }
                    for (int j = 0; j < allDataList.get(i).size(); j++) {
                        if (i == 0) {
                            if (j == 0)
                                wpdname = allDataList.get(i).get(j);
                            if (j == 1)
                                date = allDataList.get(i).get(j).replace("/", "-");
                        }
                        if (i == 1)
                            if (j > 0) {
                                sellerlist.add(allDataList.get(i).get(j));
                            }
                        if (i == 2)
                            if (j > 0) {
                                buyerlist.add(allDataList.get(i).get(j));
                            }
                        if (i == 3)
                            if (j > 1) {
                                sourcedestlist.add(allDataList.get(i).get(j));
                            }
                        if (i == 4) {
                            if (!allDataList.get(i).get(j).equals("Total"))
                                reqlist.add(allDataList.get(i).get(j));
                        }
                        if (i > 4) {
                            if (j == 1) {
                                energylist.add(allDataList.get(i).get(j));
                            }
                            if (i != 101) {
                                if (j > 1) {
                                    energylistt.add(new BigDecimal(allDataList.get(i).get(j)).setScale(2, RoundingMode.HALF_UP));
                                }
                            } else {
                                if (j > 0) {
                                    energylistt.add(new BigDecimal(allDataList.get(i).get(j)).setScale(8, RoundingMode.HALF_UP));
                                }
                            }

                        }
                    }
                    if (i > 4) {
                        allenergylist.add(energylist);
                        allenergylistt.add(energylistt);
                    }
                }

            }


            ArrayList tempdata = new ArrayList();

            //for(int i=0;i<sourcelist.size();i++)
            for (int i = 0; i < 1; i++) {
                tempdata = new ArrayList();
                for (int cc = 0; cc < 96; cc++) {
                    //System.out.println("Data: "+allenergylistt.get(cc).get(i));
                    tempdata.add(cc, allenergylistt.get(cc).get(i).toString());
                }
                alldata.add(tempdata);
            }

            System.out.println("alldata test1 " + alldata);
            int revv = 0;
            int diffprecent = 0;
            boolean isScheduleAvailable = false;
            List<List<String>> oldalldata = null;
            Discomschedulemaster mostoldschedule = searchDao.getLastRevOfDiscomSchedule(cdf.dataBaseFmt(date), masterid, ltoano);
            System.out.println("oldalldata test1 " + oldalldata + " \n mostoldschedule " + mostoldschedule);
            if (mostoldschedule != null) {
                isScheduleAvailable = true;
                oldalldata = getDiscomSchedule(mostoldschedule.getScheduleMasterid() + "");
                revv = mostoldschedule.getRevisionno();
            }
            Setting percdef = searchDao.getSettingByLabel("SchedulePowerDifference");
            if (percdef != null && percdef.getIsapply() == true) {
                diffprecent = Integer.parseInt(percdef.getValue());
            }

            /*
             * errorMap.put("wpdmasterid", masterid); errorMap.put("wpdname",
             * wpdmaster.getPortfolioName()); //errorMap.put("wpdLTOAList",
             * getWPDLTOANos(masterid)); errorMap.put("wpdltoano", ltoano);
             *
             * errorMap.put("role", role); errorMap.put("clientwpd", clientwpd);
             *
             * //errorMap.put("ids", getWPDs()); // errorMap.put("clientids", wpds);
             * errorMap.put("fileNameToSave", fileNameToSave);
             *
             * //errorMap.put("dates", dates); //errorMap.put("totalsource",
             * sourcelist.size()); //errorMap.put("totalofsource", totalofsource);
             * //errorMap.put("condemand", condmd); errorMap.put("loggedinuser", "");
             * //errorMap.put("sourcelist", sourcelist); //errorMap.put("alldata", alldata);
             */ /*
             * for(int i=0;i<alldata.size();i++) { for(String s:alldata.get(i)) {
             * //System.out.println("alldata : "+s); } }
             */
            /*
             * System.out.println(" oldalldata "+oldalldata); if(oldalldata!=null) for(int
             * i=0;i<oldalldata.size();i++) { for(String s:oldalldata.get(i)) {
             * //System.out.println("oldalldata : "+s); } }
             */
            /*
             * errorMap.put("sdate", date); errorMap.put("timeblocks", getTimeBlocks()+"");
             *
             * errorMap.put("isScheduleAvailable", isScheduleAvailable+"");
             * errorMap.put("oldalldata", oldalldata+""); errorMap.put("diffprecent",
             * diffprecent+""); errorMap.put("revv", revv+"");
             * errorMap.put("imergencySchedule", imergencySchedule+"");
             * errorMap.put("graceSchedule", graceSchedule); errorMap.put("lastSchedule",
             * lastSchedule); errorMap.put("presdate", false+"");
             *
             * errorMap.put("downloadedFileRev", downloadedFileRev);
             * errorMap.put("downloadedFileDtm", downloadedFileDtm);
             * errorMap.put("fetchRLDC", true+"");
             *
             * errorMap.put("loggedinuser", "");
             */
            String scheduledate = "";
            scheduledate = datelist.get(0).toString();
            scheduledate = cdf.getManualReadingDate4(scheduledate);
            String power[] = new String[96];
            String time[] = new String[96];
            String seller = "", buyer = "", approvalno = "";
            String condemand = "100";
            int masterid1 = 0;
            String downloadedFileRev = null;
            String downloadedFileDtm = null;
            for (int i = 0; i < allenergylistt.get(0).size(); i++) {
                for (int j = 0; j < 96; j++) {
                    power[j] = allenergylistt.get(j).get(i).toString();
                    time[j] = timelist.get(j).toString();
                }
                seller = sellerlist.get(i);
                buyer = buyerlist.get(i);
                approvalno = sourcedestlist.get(i);
                System.out.println(cdf.dataBaseFmt(date)+" "+buyer+" "+seller);
                List<Agreementmaster> agrementlist = adminDataService.getWpdActiveAgreementsListByWPDIDForSchedule(cdf.dataBaseFmt(date), buyer, seller, approvalno);
                Agreementmaster agreementmaster = agrementlist.get(0);
                Portfoliomaster portfoliomaster = adminDataService.getPortfoliomasterByNickname(seller);
                masterid1 = portfoliomaster.getPortfolioMasterId().intValue();
                saveScheduleEX(scheduledate, sourcedestlist.get(i), "Test", time, power, imergencySchedule, lastSchedule,
                        downloadedFileRev, downloadedFileDtm, graceSchedule,
                        agreementmaster, masterid1, condemand);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "discomschedulestep2excel";
    }

    public String saveScheduleEX(String date, String ltoano, String fileNameToSave, String time[], String power[],
                                 String imergencySchedule,
                                 String lastSchedule,
                                 String downloadedFileRev,
                                 String downloadedFileDtm,
                                 String graceSchedule, Agreementmaster agreementmaster, int masterid, String condemand) throws Exception {
        Map<String, Object> errorMap = new HashMap<String, Object>();
        System.out.println("imergencySchedule: " + imergencySchedule);
        String title = "";
        String proportion = "";
        Date saveDate = new Date();
        Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        //int totalsource=Integer.parseInt((String)request.getParameter("totalsources"));
        int totalsource = 1;

        //int masterid=Integer.parseInt((String)request.getParameter("masteridd"));
        //String condemand = (String)request.getParameter("condemand");
        System.out.println("Master id: " + masterid + " AgreementConnectedwithMID: " + totalsource);
        Discomschedulemaster schedulemaster = new Discomschedulemaster();
        schedulemaster.setScheduleMasterid(null);
        schedulemaster.setId(masterid);
        schedulemaster.setScheduleDate(cdf.dataBaseFmt(date));
        schedulemaster.setUpdatedBy("");
        schedulemaster.setCreatedBy("");
        schedulemaster.setCreatedOn(timeStampDate);
        schedulemaster.setUpdatedOn(timeStampDate);
        schedulemaster.setRequestDesc("");
        schedulemaster.setSendmail(false);
        schedulemaster.setDownload(false);
        schedulemaster.setDiscomdownload(false);
        schedulemaster.setDiscomcreated(false);
        schedulemaster.setContractdemand(condemand);
        schedulemaster.setRevisionno(0);
        schedulemaster.setFileName(fileNameToSave);
        schedulemaster.setRldcdownload(false);
        schedulemaster.setLtoano(ltoano);
        if (downloadedFileRev != null)
            schedulemaster.setRldcrevno(downloadedFileRev);
        if (downloadedFileRev != null)
            schedulemaster.setRldcdatetime(downloadedFileDtm);

        int rowindexforprevrev = checkScheduleTimeAndGetRowIndex(date, imergencySchedule, graceSchedule);
        Discomschedulemaster mostoldschedule = searchDao.getLastRevOfDiscomSchedule(schedulemaster.getScheduleDate(), schedulemaster.getId() + "", ltoano);
        List<List<String>> oldalldata = null;
        if (mostoldschedule != null) {
            oldalldata = getDiscomSchedulewithpowerandlossandtotal(mostoldschedule.getScheduleMasterid() + "");
        }

        Collection<Discomschedulesources> scheduleSoucesCollection = new ArrayList<Discomschedulesources>();
        for (int ii = 0; ii < totalsource; ii++) {
            BigDecimal totalMus = BigDecimal.ZERO;
            /*
             * String source[]=(String[])request.getParameterValues("source"+ii); String
             * total[]=(String[])request.getParameterValues("total"); String wpdname =
             * (String)request.getParameter("sourcelbl0n"+ii); String psadiscomname =
             * (String)request.getParameter("sourcelbl1n"+ii); String psasourcedest =
             * (String)request.getParameter("sourcelbl2n"+ii); String psarequisition =
             * (String)request.getParameter("sourcelbl3n"+ii); String powerPurchased =
             * (String)request.getParameter("sourcelbl4n"+ii); String agreementMasterId =
             * (String)request.getParameter("sourcelbl5n"+ii);
             */
            String source[] = null;
            String total[] = null;
            String wpdname = null;
            String psadiscomname = null;
            String psasourcedest = null;
            String psarequisition = null;
            String powerPurchased = null;
            String agreementMasterId = null;

            //Agreementmaster agreementmaster = adminDataService.getAgreementmaster(agreementMasterId);
            //Agreementmastersnapshot snapshot = adminDataService.findLastAgreementSnapShotByAgreementId(agreementMasterId);

            proportion = agreementmaster.getProportion();
            Portfoliomaster wpdmaster = adminDataService.getPortfoliomaster(masterid + "");

            //Portfoliomaster wpdmaster =apiService.getPortfoliomaster(agreementmaster.getSellerportfolio());
            //	Discommaster discommaster = adminDataService.getDiscommaster(agreementmaster.getBuyerportfolio());
            if (wpdmaster != null)
                title = wpdmaster.getPortfolioId();
            Discomschedulesources discomschedulesources = new Discomschedulesources();
            discomschedulesources.setId(null);
            discomschedulesources.setSource(agreementMasterId);
            discomschedulesources.setScheduledate(cdf.dataBaseFmt(date));
            discomschedulesources.setPower(powerPurchased);
            discomschedulesources.setPpadiscomname(psadiscomname);
            discomschedulesources.setPpasourcedest(psasourcedest);
            discomschedulesources.setPparequisition(psarequisition);
            discomschedulesources.setWpdname(wpdname);
            discomschedulesources.setSellerportfolio(agreementmaster.getSellerportfolio());
            discomschedulesources.setBuyerportfolio(agreementmaster.getBuyerportfolio());
            //discomschedulesources.setAgreementSnapshotMasterId(snapshot.getAgreementSnapshotMasterId()+"");
            discomschedulesources.setAgreementSnapshotMasterId(agreementmaster.getAgreementMasterId() + "");

            discomschedulesources.setPsadiscomname(agreementmaster.getPsadiscomname());
            discomschedulesources.setPsasourcedest(agreementmaster.getPsasourcedest());
            discomschedulesources.setPsarequisition(agreementmaster.getPsarequisition());
            //discomschedulesources.setSellerregion(wpdmaster.getRegion());
            //	discomschedulesources.setBuyerregion(discommaster.getRegion());
            //discomschedulesources.setRoute(agreementmaster.getRouteId().getRoute());
            discomschedulesources.setSendmail(false);

            discomschedulesources.setScheduleMasterid(null);
            Collection<Discomscheduledetail> scheduleDetailCollection = new ArrayList<Discomscheduledetail>();
            for (int i = 0; i < time.length; i++) {
                Discomscheduledetail scheduledetail = new Discomscheduledetail();
                scheduledetail.setId(null);
                scheduledetail.setTimeslot(time[i]);
                scheduledetail.setScheduleDate(cdf.dataBaseFmt(date));
                schedulemaster.setUpdatedBy("");
//		    if(mostoldschedule!=null && i<rowindexforprevrev)
//		    {
//		    	scheduledetail.setPower(oldalldata.get(ii).get(i).split(",")[0]);
//				scheduledetail.setPowerwithoutloss(oldalldata.get(ii).get(i).split(",")[1]);
//				scheduledetail.setDiscompower(oldalldata.get(ii).get(i).split(",")[2]);
//				scheduledetail.setIsupdated(false);
//		    }
//		    else
                //chnage on 15 june
                {
                    scheduledetail.setPower(power[i]);
                    scheduledetail.setPowerwithoutloss(power[i]);
                    scheduledetail.setDiscompower(power[i]);
                    scheduledetail.setIsupdated(true);
                }
                //if(i<rowindexforprevrev) //18july for saving savedtil
                {
                    schedulemaster.setSavedtill(time[i]);
                }
                List<String> dates = cdf.getCurrAndNextDate();
                //if(date.equals(dates.get(1)) && mostoldschedule==null)
                if (date.equals(dates.get(1))) {
                    Setting NextDayScheduleForR1 = searchDao.getSettingByLabel("NextDayScheduleFor(R_1)");
                    schedulemaster.setSavedtill(cdf.getNectDayScheduleTimeSlabToSave(NextDayScheduleForR1.getValue(), timeStampDate, checkScheduleTimeAndGetRowIndexGapInMinutes(imergencySchedule)));
                }
                totalMus = totalMus.add(new BigDecimal(scheduledetail.getPower()));
                scheduleDetailCollection.add(scheduledetail);
            }
            discomschedulesources.setTotal(totalMus.divide(new BigDecimal(4000), 8, RoundingMode.HALF_UP) + "");
            discomschedulesources.setDiscomscheduledetailCollection(scheduleDetailCollection);
            scheduleSoucesCollection.add(discomschedulesources);
        }
        schedulemaster.setDiscomschedulesourcesCollection(scheduleSoucesCollection);

        String role = "ADMIN";
        /*
         * User user = searchDao.findUserByUserId("");
         *
         *
         * for(UserProfile up:user.getUserProfiles()) {
         * if(up.getType().equals("CLIENT")) role="CLIENT";
         * if(up.getType().equals("ADMIN")) role="ADMIN"; }
         */
        //int rev=searchDao.getLastRevisionOfDiscomSchedule(schedulemaster.getScheduleDate(), schedulemaster.getId()+"");
        //if(rev!=100)
        HashMap<String, String> result = new HashMap<String, String>();
        // validator.validateScheduleBeforeSave(proportion, ltoano, imergencySchedule, graceSchedule, "", schedulemaster, role, result);
        if (result.size() > 0) {

            List<String> dates = cdf.getCurrAndNextDate();

            String clientwpd = "";
            List<Portfoliomaster> wpdlist = new ArrayList<Portfoliomaster>();
            Map<String, String> wpds = new LinkedHashMap<String, String>();
            /*
             * if(role.equals("CLIENT")) { String wpdids[] =
             * user.getConsumerno().split(","); for(int i=0;i<wpdids.length;i++) {
             * Portfoliomaster wpdmaster=adminDataService.getPortfoliomaster(masterid+"");
             *
             * wpdlist.add(wpdmaster); } if(wpdlist.size()>1) { for(Portfoliomaster
             * wm:wpdlist) { wpds.put(wm.getPortfolioId()+"", wm.getPortfolioName()); }
             * clientwpd = "multiple"; } else { clientwpd = "single"; } }
             */
            Portfoliomaster wpdmaster = adminDataService.getPortfoliomaster(masterid + "");



            /*
             * errorMap.put("wpdmasterid", masterid); errorMap.put("wpdname",
             * wpdmaster.getPortfolioName()); errorMap.put("wpdLTOAList",
             * getWPDLTOANos(masterid+"")); errorMap.put("wpdltoano", ltoano);
             *
             * errorMap.put("role", role); errorMap.put("clientwpd", clientwpd);
             * errorMap.put("clientids", wpds); errorMap.put("dates", dates);
             * errorMap.put("sdate", null); errorMap.put("ids", getWPDs());
             * errorMap.put("imergencySchedule", imergencySchedule);
             * errorMap.put("graceSchedule", graceSchedule); errorMap.put("lastSchedule",
             * lastSchedule); errorMap.put("loggedinuser", getPrincipal());
             */
            return "discomschedulestep2excel";
        } else {
            if (mostoldschedule != null) {
				/*Setting timeGapSetting = searchDao.getSettingByLabel("ScheduleTimeGapInMinute");
				if(imergencySchedule!=null)
				{
					timeGapSetting = searchDao.getSettingByLabel("ScheduleTimeGapInMinute_IMGY");
				}
				if(role.equals("CLIENT"))
				{
					timeGapSetting = searchDao.getSettingByLabel("ScheduleTimeGapInMinute_CLIENT");
				}*/
                schedulemaster.setRevisionno(mostoldschedule.getRevisionno() + 1);
                Setting maxrev = searchDao.getSettingByLabel("MaxRevision");
                //if(imergencySchedule==null)
                {
                    Emergencyschedulerevision isExist = searchDao.getEmergencyschedulerevision(schedulemaster.getId() + "", schedulemaster.getScheduleDate(), ltoano);
                    if (isExist != null) {
                        maxrev.setValue(isExist.getRevision());
                    }
                }
                if (lastSchedule != null) {
                    schedulemaster.setRevisionno(Integer.parseInt(maxrev.getValue()));
                }
                //System.out.println(Long.valueOf(timeGapSetting.getValue()));
                int dayToAdd = 0;
                List<String> dates = cdf.getCurrAndNextDate();
                if (date.equals(dates.get(1)) && mostoldschedule.getSavedtill().contains("24:00")) {
                    dayToAdd = 1;
                }
                System.out.println(mostoldschedule.getCreatedOn() + " || " + schedulemaster.getCreatedOn());
                if (cdf.getTimeDiffInMinutesBWTwoDatesNew(mostoldschedule.getCreatedOn(), schedulemaster.getCreatedOn(), mostoldschedule.getSavedtill(), dayToAdd) > 0 && imergencySchedule == null) {
                    long diff = cdf.getTimeDiffInMinutesBWTwoDatesNew(mostoldschedule.getCreatedOn(), schedulemaster.getCreatedOn(), mostoldschedule.getSavedtill(), dayToAdd);
                    System.out.println("diff: " + diff);
                    if (imergencySchedule == null) {
                        errorMap.put("error", "Discom schedule not added. add after " + diff + " Minutes");
                    }
                } else if (mostoldschedule.getRevisionno() == Integer.parseInt(maxrev.getValue())) {
                    errorMap.put("error", "Discom schedule not added. you already added " + maxrev.getValue() + " schedules");
                } else {
                    System.out.println("adding schedule: ");
                    //addService.saveDiscomSchedule(schedulemaster,null);
                    boolean sdl = false;
                    if (imergencySchedule != null) {
                        Emergencyschedulerevision isExist = searchDao.getEmergencyschedulerevision(schedulemaster.getId() + "", schedulemaster.getScheduleDate(), ltoano);
                        if (isExist == null) {
                            Setting maxrevision = searchDao.getSettingByLabel("MaxRevision");
                            Emergencyschedulerevision esr = new Emergencyschedulerevision();
                            esr.setId(null);
                            esr.setWpdmasterid(schedulemaster.getId());
                            esr.setScheduleDate(schedulemaster.getScheduleDate());
                            esr.setRevision("" + (Integer.parseInt(maxrevision.getValue()) + 1));
                            esr.setUpdatedby("");
                            esr.setCreatedby("");
                            esr.setCreatedon(timeStampDate);
                            esr.setUpdatedon(timeStampDate);
                            esr.setLtoano(ltoano);
                            //addService.saveUpdateEmergencyschedulerevision(esr);
                            sdl = addService.saveDiscomSchedule(schedulemaster, null, esr);
                            errorMap.put("schedulemasterGrit", schedulemaster);
                        } else {
                            Integer maxrevision = (Integer.parseInt(isExist.getRevision()) + 1);
                            isExist.setRevision("" + maxrevision);
                            isExist.setUpdatedby("");
                            isExist.setUpdatedon(timeStampDate);
                            //addService.saveUpdateEmergencyschedulerevision(isExist);
                            sdl = addService.saveDiscomSchedule(schedulemaster, null, isExist);
                            errorMap.put("schedulemasterGrit", schedulemaster);
                        }
                    } else {
                        sdl = addService.saveDiscomSchedule(schedulemaster, null, null);
                        errorMap.put("schedulemasterGrit", schedulemaster);
                    }

                    if (sdl == true) {
                        errorMap.put("success", "Discom schedule successfuly added.");

                        //Activitylog logModel = new Activitylog();
                        //	getLogModelDetails(request, logModel);
                        //	logModel.setDatetime(new ConvertDateFormat().getTimeStampForLog2(schedulemaster.getCreatedOn()+""));
                        //	addService.saveActivitylog(logModel, "Discom schedule successfuly added.");

                        /*
                         * Notificationmaster notificationmaster = new Notificationmaster();
                         * notificationmaster.setDate(date);
                         * notificationmaster.setRevno(schedulemaster.getRevisionno()+"");
                         * notificationmaster.setDetails("Schedule Created on "+cdf.getCreationDateTime(
                         * schedulemaster.getCreatedOn())+" with Rev No "+schedulemaster.getRevisionno()
                         * ); notificationmaster.setSrno("");
                         * notificationmaster.setTime(cdf.getCreationDateTime(schedulemaster.
                         * getCreatedOn())); notificationmaster.setTitle(title);
                         * notificationmaster.setLtoano(ltoano); try { ServletContext context =
                         * request.getServletContext(); String bidpath=
                         * context.getRealPath("/static/notification/NewSchedule.ser");
                         * NewSchedules.setNotification(notificationmaster, bidpath); } catch (Exception
                         * e) { System.out.println("ex " + e); }
                         */
                    } else {
                        errorMap.put("error", "Something Wrong! Discom schedule not added.");
                    }

                }
            } else {

                //addService.saveDiscomSchedule(schedulemaster,null);
                boolean sdl = false;
                if (imergencySchedule != null) {
                    Emergencyschedulerevision isExist = searchDao.getEmergencyschedulerevision(schedulemaster.getId() + "", schedulemaster.getScheduleDate(), ltoano);
                    if (isExist == null) {
                        Setting maxrevision = searchDao.getSettingByLabel("MaxRevision");
                        Emergencyschedulerevision esr = new Emergencyschedulerevision();
                        esr.setId(null);
                        esr.setWpdmasterid(schedulemaster.getId());
                        esr.setScheduleDate(schedulemaster.getScheduleDate());
                        esr.setRevision("" + (Integer.parseInt(maxrevision.getValue()) + 1));
                        esr.setUpdatedby("");
                        esr.setCreatedby("");
                        esr.setCreatedon(timeStampDate);
                        esr.setUpdatedon(timeStampDate);
                        esr.setLtoano(ltoano);
                        //addService.saveUpdateEmergencyschedulerevision(esr);
                        sdl = addService.saveDiscomSchedule(schedulemaster, null, esr);
                        errorMap.put("schedulemasterGrit", schedulemaster);
                    } else {
                        Integer maxrevision = (Integer.parseInt(isExist.getRevision()) + 1);
                        isExist.setRevision("" + maxrevision);
                        isExist.setUpdatedby("");
                        isExist.setUpdatedon(timeStampDate);
                        //addService.saveUpdateEmergencyschedulerevision(isExist);
                        sdl = addService.saveDiscomSchedule(schedulemaster, null, isExist);
                        errorMap.put("schedulemasterGrit", schedulemaster);
                    }
                } else {
                    sdl = addService.saveDiscomSchedule(schedulemaster, null, null);
                    errorMap.put("schedulemasterGrit", schedulemaster);
                }

                if (sdl == true) {
                    errorMap.put("success", "Discom schedule successfuly added.");

                    /*
                     * Activitylog logModel = new Activitylog(); getLogModelDetails(request,
                     * logModel); logModel.setDatetime(new
                     * ConvertDateFormat().getTimeStampForLog2(schedulemaster.getCreatedOn()+""));
                     * addService.saveActivitylog(logModel, "Discom schedule successfuly added.");
                     *
                     * Notificationmaster notificationmaster = new Notificationmaster();
                     * notificationmaster.setDate(date);
                     * notificationmaster.setRevno(schedulemaster.getRevisionno()+"");
                     * notificationmaster.setDetails("Schedule Created on "+cdf.getCreationDateTime(
                     * schedulemaster.getCreatedOn())+" with Rev No "+schedulemaster.getRevisionno()
                     * ); notificationmaster.setSrno("");
                     * notificationmaster.setTime(cdf.getCreationDateTime(schedulemaster.
                     * getCreatedOn())); notificationmaster.setTitle(title);
                     * notificationmaster.setLtoano(ltoano); try { ServletContext context =
                     * request.getServletContext(); String bidpath=
                     * context.getRealPath("/static/notification/NewSchedule.ser");
                     * NewSchedules.setNotification(notificationmaster, bidpath); } catch (Exception
                     * e) { System.out.println("ex " + e); }
                     */
                } else {
                    errorMap.put("error", "Something Wrong! Discom schedule not added.");
                }

            }
        }


        errorMap.put("loggedinuser", "");
        return "registrationsuccess";
    }

    public MultipartFile convertFiletoMultiPart(String FILE_PATH) {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                System.out.println("File Exist => " + file.getName() + " :: " + file.getAbsolutePath());
            }
            DiskFileItem fileItem = new DiskFileItem("file", "text/plain", false, file.getName(), (int) file.length(), file.getParentFile());
            fileItem.getOutputStream();
            MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
            System.out.println("multipartFile => " + multipartFile.isEmpty() + " :: "
                    + multipartFile.getOriginalFilename() + " :: " + multipartFile.getName() + " :: "
                    + multipartFile.getSize() + " :: " + multipartFile.getBytes());
            return multipartFile;
        } catch (IOException e) {
            System.out.println("Exception => " + e.getLocalizedMessage());
            return null;
        }
    }

    public List<List<String>> getDiscomSchedule(String scheduleid) {

        List<Discomschedulesources> sourcelist = searchDao.findByScheduleMasterId(scheduleid);
        List<List<String>> alldata = new ArrayList<List<String>>();
        ArrayList tempdata = new ArrayList();
        for (int i = 0; i < sourcelist.size(); i++) {
            Collection<Discomscheduledetail> discomscheduledetail = sourcelist.get(i).getDiscomscheduledetailCollection();
            tempdata = new ArrayList();
            int cc = 0;
            for (Discomscheduledetail dsd : discomscheduledetail) {
                tempdata.add(cc++, dsd.getPower().toString());
            }
            alldata.add(tempdata);
        }
        return alldata;
    }

    public List<List<String>> getDiscomSchedulewithpowerandlossandtotal(String scheduleid) {

        List<Discomschedulesources> sourcelist = searchDao.findByScheduleMasterId(scheduleid);
        List<List<String>> alldata = new ArrayList<List<String>>();
        ArrayList tempdata = new ArrayList();
        for (int i = 0; i < sourcelist.size(); i++) {
            Collection<Discomscheduledetail> discomscheduledetail = sourcelist.get(i).getDiscomscheduledetailCollection();
            tempdata = new ArrayList();
            int cc = 0;
            for (Discomscheduledetail dsd : discomscheduledetail) {
                tempdata.add(cc++, dsd.getPower().toString() + "," + dsd.getPowerwithoutloss().toString() + "," + dsd.getDiscompower().toString());
            }
            alldata.add(tempdata);
        }
        return alldata;
    }

    public int checkScheduleTimeAndGetRowIndex(String scheduledate, String imergencySchedule, String graceSchedule) {
        int rowind = 0;
        DateAndTime dateAndTime = new DateAndTime();
        try {
            String usertype = "admin";

            /*
             * User user = searchDao.findUserByUserId(""); if(user!=null) { for(UserProfile
             * up:user.getUserProfiles()) { if(up.getType().equals("CLIENT")) usertype =
             * up.getType(); } }
             */

            scheduledate = cdf.dataBaseFmt(scheduledate);
            String label = "clientscheduletime";
            if (usertype.equals("admin"))
                label = "adminscheduletime";
            if (imergencySchedule != null)
                label = "adminemergencyscheduletime";

            int gracePeriod = 0;
            if (graceSchedule != null && !graceSchedule.equals("")) {
                Setting gracePeriodSetting = searchDao.getSettingByLabel("Grace Period");
                gracePeriod = Integer.parseInt(gracePeriodSetting.getValue());
            }

            System.out.println("Schedule LabelVal: %%%%%%%%%%%%%%%%%%%% " + label);

            Schedulesetting schedulesetting = searchDao.getScheduleSettingByLabel(label);
            String timeval = schedulesetting.getValue();
            String currtime = dateAndTime.getCurrentTime();
            String times[] = currtime.split(":");
            rowind = (Integer.parseInt(times[0]) * 4) + 1;
            rowind = rowind + (Integer.parseInt(times[1])) / 15;
            rowind += (Integer.parseInt(timeval) - gracePeriod) / 15;
            System.out.println("rowind " + rowind);
            String currdate = currentDate.getCurrentDate1();

            if (!(dateDifference.daysBetween3(scheduledate, currdate) == 0))
                rowind = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowind;
    }

    public int checkScheduleTimeAndGetRowIndexGapInMinutes(String imergencySchedule) {
        int gapMin = 0;
        try {
            String usertype = "admin";
            /*
             * User user = searchDao.findUserByUserId(""); if(user!=null) { for(UserProfile
             * up:user.getUserProfiles()) { if(up.getType().equals("CLIENT")) usertype =
             * up.getType(); } }
             */

            String label = "clientscheduletime";
            if (usertype.equals("admin"))
                label = "adminscheduletime";
            if (imergencySchedule != null)
                label = "adminemergencyscheduletime";

            System.out.println("Schedule LabelVal: %%%%%%%%%%%%%%%%%%%% " + label);

            Schedulesetting schedulesetting = searchDao.getScheduleSettingByLabel(label);
            String timeval = schedulesetting.getValue();
            gapMin = Integer.parseInt(timeval);
            System.out.println("gapMin " + gapMin);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return gapMin;
    }

    public String getScheduleMatchingData(String schedulemasterid) {
        String res = "", agreementmastersnapshotid = "", buyer = "", seller = "", scheduledate = "", approvalno = "", id = "";
        boolean dataMatch = false;
        List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
        Map<String, String> innerMapp = new HashMap<String, String>();
        Map<String, String> scheduleDataMapp = new HashMap<String, String>();
        Map<String, String> rldcDataMapp = new HashMap<String, String>();
        try {
            Discomschedulemaster discomschedulemaster = searchDao.findDiscomScheduleById(schedulemasterid);
            List<Discomschedulesources> discomScheduleSourceslist = searchDao.findByScheduleMasterId(schedulemasterid);
            for (Discomschedulesources discomschedulesources : discomScheduleSourceslist) {
                agreementmastersnapshotid = discomschedulesources.getAgreementSnapshotMasterId();
                System.out.println("agreementmastersnapshotid " + agreementmastersnapshotid);
                Agreementmaster agreementmaster = adminDataService.getAgreementmaster(agreementmastersnapshotid);
                buyer = agreementmaster.getPpadiscomname();
                seller = agreementmaster.getPsadiscomname();
                scheduledate = discomschedulesources.getScheduledate();
                approvalno = agreementmaster.getApprovalNo();
                id = discomschedulesources.getId() + "";
                List<Discomscheduledetail> discomscheduledetaillist = searchDao.findBySourceMasterId(id);
                for (Discomscheduledetail discomscheduledetail : discomscheduledetaillist)
                    scheduleDataMapp.put(discomscheduledetail.getTimeslot(), discomscheduledetail.getPower());
                List<Rldcschedulesources> rldcschedulesourceslist = searchDao.findByRldcScheduleMasterId(scheduledate, buyer, seller, approvalno);
                for (Rldcschedulesources rldcschedulesources : rldcschedulesourceslist) {
                    String rid = rldcschedulesources.getId() + "";
                    List<Rldcscheduledetail> rldcscheduledetaillist = searchDao.findByRldcSourceMasterId(rid);
                    for (Rldcscheduledetail rldcscheduledetail : rldcscheduledetaillist)
                        rldcDataMapp.put(rldcscheduledetail.getTimeslot(), rldcscheduledetail.getPower());
                }
            }
            for (String timeblock : getTimeBlocks()) {
                innerMapp = new HashMap<String, String>();
                innerMapp.put("time", timeblock);
                innerMapp.put("schedulepower", scheduleDataMapp.get(timeblock));
                innerMapp.put("rldcpower", rldcDataMapp.get(timeblock));

                BigDecimal aa = new BigDecimal(scheduleDataMapp.get(timeblock)).setScale(2, RoundingMode.HALF_UP);
                BigDecimal bb = new BigDecimal(rldcDataMapp.get(timeblock)).setScale(2, RoundingMode.HALF_UP);
                dataMatch = true;
                if (aa.compareTo(bb) != 0) {
                    dataMatch = false;
                    //System.out.println("Data Not matched!");
                    //break;
                }
                innerMapp.put("match", dataMatch + "");
                dataList.add(innerMapp);
            }
            try {
                return new ObjectMapper().writeValueAsString(dataList);
            } catch (JsonProcessingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (Exception e) {
        }
        return "";
    }

    public String getScheduleDetailData(String schedulemasterid, String type) {
        String res = "", agreementmastersnapshotid = "", buyer = "", seller = "", scheduledate = "", approvalno = "", id = "";
        boolean dataMatch = false;
        List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
        Map<String, String> innerMapp = new HashMap<String, String>();
        Map<String, String> scheduleDataMapp = new HashMap<String, String>();
        Map<String, String> rldcDataMapp = new HashMap<String, String>();
        try {
            if (type.equals("Schedule")) {
                List<Discomschedulesources> discomScheduleSourceslist = searchDao.findByScheduleMasterId(schedulemasterid);
                for (Discomschedulesources discomschedulesources : discomScheduleSourceslist) {

                    id = discomschedulesources.getId() + "";
                    List<Discomscheduledetail> discomscheduledetaillist = searchDao.findBySourceMasterId(id);
                    for (Discomscheduledetail discomscheduledetail : discomscheduledetaillist)
                        scheduleDataMapp.put(discomscheduledetail.getTimeslot(), discomscheduledetail.getPower());
                }
            }
            if (type.equals("RLDC")) {
                List<Rldcschedulesources> rldcschedulesourceslist = searchDao.findByRldcScheduleMasterId(schedulemasterid);
                for (Rldcschedulesources rldcschedulesources : rldcschedulesourceslist) {
                    String rid = rldcschedulesources.getId() + "";
                    List<Rldcscheduledetail> rldcscheduledetaillist = searchDao.findByRldcSourceMasterId(rid);
                    for (Rldcscheduledetail rldcscheduledetail : rldcscheduledetaillist)
                        rldcDataMapp.put(rldcscheduledetail.getTimeslot(), rldcscheduledetail.getPower());
                }
            }
            for (String timeblock : getTimeBlocks()) {
                innerMapp = new HashMap<String, String>();
                innerMapp.put("time", timeblock);
                if (type.equals("Schedule"))
                    innerMapp.put("power", scheduleDataMapp.get(timeblock));
                if (type.equals("RLDC"))
                    innerMapp.put("power", rldcDataMapp.get(timeblock));

                dataList.add(innerMapp);
            }
            try {
                return new ObjectMapper().writeValueAsString(dataList);
            } catch (JsonProcessingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (Exception e) {
        }
        return "";
    }

    public List<String> getTimeBlocks() {
        List<String> timeblocks = new ArrayList<String>();
        for (int i = 0; i < 96; i++) {
            try {
                timeblocks.add(cdf.calTimePeriodForIndex(i));
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return timeblocks;
    }
    /*
     * public List<Rldcschedulesources> shedularfileList(String schedulemasterid){
     * List<Rldcschedulesources>list=searchDao.findSchedulerList(schedulemasterid)
     *
     * }
     */

}
