package com.discom.springmvc.serviceimpl;

import com.discom.springmvc.dao.AddDao;
import com.discom.springmvc.dao.ListDao;
import com.discom.springmvc.dao.MultiActionDao;
import com.discom.springmvc.dao.SearchDao;
import com.discom.springmvc.model.User;
import com.discom.springmvc.pojo.*;
import com.discom.springmvc.service.ListService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service("listService")

@Transactional
public class ListServiceImpl implements ListService {
    @Autowired
    private ListDao listDao;
    @Autowired
    private SearchDao searchDao;
    @Autowired
    private AddDao addDao;
    @Autowired
    private MultiActionDao multiActionDao;
    @Autowired
    private Environment env;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    //FCMMessageSender fCMMessageSender=new FCMMessageSender();
    public List<User> getAllAdminList(int currPosition, int pageSize, String sSearch) {
        return listDao.getAllAdminList(currPosition, pageSize, sSearch);
    }

    public int getAllAdminListCount(String sSearch) {
        return listDao.getAllAdminListCount(sSearch);
    }

    public List<Constantslistsdetails> getAllConstantslistsdetailsList(int currPosition, int pageSize, String sSearch) {
        return listDao.getAllConstantslistsdetailsList(currPosition, pageSize, sSearch);
    }

    public int getAllConstantslistsdetailsListCount(String sSearch) {
        return listDao.getAllConstantslistsdetailsListCount(sSearch);
    }

    public List<User> getAllAdminList(int i, int j, String sSearch, String list[]) {
        return listDao.getAllAdminList(i, j, sSearch, list);
    }

    public int getAllAdminListCount(String sSearch, String list[]) {
        return listDao.getAllAdminListCount(sSearch, list);
    }

    public Portfoliomaster findPortfolio(String id, String filter) {

        String cList[] = {filter};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Portfoliomaster.class, cList, vList);
        Portfoliomaster portfoliomaster = (Portfoliomaster) pojoObject;
        return portfoliomaster;
    }

    public Regionmaster findRegionmaster(String id, String filter) {
        String cList[] = {filter};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Regionmaster.class, cList, vList);
        Regionmaster regionmaster = (Regionmaster) pojoObject;
        return regionmaster;
    }

    public Companymaster findCompanymaster(String id, String filter) {
        String cList[] = {filter};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Companymaster.class, cList, vList);
        Companymaster companymaster = (Companymaster) pojoObject;
        return companymaster;
    }

    public Agreementmaster findAgreementmaster(String id, String filter) {
        String cList[] = {filter};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Agreementmaster.class, cList, vList);
        Agreementmaster agreementmaster = (Agreementmaster) pojoObject;
        return agreementmaster;
    }

    public Statemaster findState(String id, String filter) {
        String cList[] = {filter};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Statemaster.class, cList, vList);
        Statemaster statemaster = (Statemaster) pojoObject;
        return statemaster;
    }

    public Discommaster findDiscom(String id, String filter) {
        String cList[] = {filter};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Discommaster.class, cList, vList);
        Discommaster discommaster = (Discommaster) pojoObject;
        return discommaster;
    }

    public List<Lossdata> getAllLossdataList(int i, int j, String sSearch, String list[]) {
        return listDao.getAllLossdataList(i, j, sSearch, list);
    }

    public int getAllLossdataListCount(String sSearch, String list[]) {
        return listDao.getAllLossdataListCount(sSearch, list);
    }

    public List<Stateloss> getAllStateLossList(String id) {
        return listDao.getAllStateLossList(id);

    }

    public List<Newpocloss> getAllPOCLossList(String id) {
        return listDao.getAllPOCLossList(id);
    }

    public String getAllPortfolioIdandMasterid() {
        String res = "";
        List<?> dataListObject = multiActionDao.executeDataTablePortfolioObjectBuilder(Portfoliomaster.class);
        //	System.out.println(""+new ObjectMapper().writeValueAsString(dataListObject));
        try {
            res = new ObjectMapper().writeValueAsString(dataListObject);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;
    }

    public List<Portfoliomaster> getAllPortfolio() {
        List<Portfoliomaster> list = new ArrayList<Portfoliomaster>();

        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(Portfoliomaster.class);
        for (Object obj : dataListObject)
            list.add((Portfoliomaster) obj);
        return list;
    }

    public List<Statemaster> getAllState() {
        List<Statemaster> list = new ArrayList<Statemaster>();

        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(Statemaster.class);
        for (Object obj : dataListObject)
            list.add((Statemaster) obj);
        return list;
    }

    public List<Discommaster> getAllDiscom() {
        List<Discommaster> list = new ArrayList<Discommaster>();

        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(Discommaster.class);
        for (Object obj : dataListObject)
            list.add((Discommaster) obj);
        return list;
    }

    public List<Regionmaster> getAllRegion() {
        List<Regionmaster> list = new ArrayList<Regionmaster>();

        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(Regionmaster.class);
        for (Object obj : dataListObject)
            list.add((Regionmaster) obj);
        return list;
    }

    public List<Companymaster> getAllCompany() {
        List<Companymaster> list = new ArrayList<Companymaster>();
        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(Companymaster.class);
        for (Object obj : dataListObject)
            list.add((Companymaster) obj);
        return list;
    }


}
