package com.discom.springmvc.service;

import com.discom.springmvc.model.User;
import com.discom.springmvc.pojo.*;

import java.util.List;


public interface ListService {
    public List<User> getAllAdminList(int i, int j, String sSearch);

    public int getAllAdminListCount(String sSearch);

    public List<Constantslistsdetails> getAllConstantslistsdetailsList(int i, int j, String sSearch);

    public int getAllConstantslistsdetailsListCount(String sSearch);

    public List<User> getAllAdminList(int i, int j, String sSearch, String list[]);

    public int getAllAdminListCount(String sSearch, String list[]);

    public Portfoliomaster findPortfolio(String id, String filter);

    public Statemaster findState(String id, String filter);

    public Discommaster findDiscom(String id, String filter);

    public List<Lossdata> getAllLossdataList(int i, int j, String sSearch, String list[]);

    public int getAllLossdataListCount(String sSearch, String list[]);

    public List<Stateloss> getAllStateLossList(String id);

    public List<Newpocloss> getAllPOCLossList(String id);

    public String getAllPortfolioIdandMasterid();

    public List<Portfoliomaster> getAllPortfolio();

    public List<Statemaster> getAllState();

    public List<Discommaster> getAllDiscom();

    public List<Regionmaster> getAllRegion();

    public List<Companymaster> getAllCompany();

    public Regionmaster findRegionmaster(String id, String filter);

    public Companymaster findCompanymaster(String id, String filter);

    public Agreementmaster findAgreementmaster(String id, String filter);


}
