package com.discom.springmvc.dao;

import com.discom.springmvc.model.User;
import com.discom.springmvc.pojo.*;

import java.util.List;

public interface ListDao {

    boolean checkUserId(String userid);

    public List<User> getAllAdminList(int i, int j, String sSearch);

    public int getAllAdminListCount(String sSearch);

    public List<Constantslistsdetails> getAllConstantslistsdetailsList(int i, int j, String sSearch);

    public int getAllConstantslistsdetailsListCount(String sSearch);

    public List<User> getAllAdminList(int i, int j, String sSearch, String list[]);

    public int getAllAdminListCount(String sSearch, String list[]);


    List<EmailMaster> getRecordFromEmailMaster(String title, String type);

    public List<Passwordhistorymaster> getPasswordHitory(String userid);

    public Passwordhistorymaster getLastPassword(String userid);

    User getRecordByEmailId(String emailid);

    List<Lossdata> getAllLossdataList(int i, int j, String sSearch, String list[]);

    int getAllLossdataListCount(String sSearch, String list[]);

    public List<Stateloss> getAllStateLossList(String id);

    public List<Newpocloss> getAllPOCLossList(String id);
}
