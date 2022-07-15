package com.discom.springmvc.controller;

import com.discom.springmvc.dao.ListDao;
import com.discom.springmvc.dao.SearchDao;
import com.discom.springmvc.model.DataTablesTO;
import com.discom.springmvc.model.User;
import com.discom.springmvc.model.UserProfile;
import com.discom.springmvc.pojo.Activitylog;
import com.discom.springmvc.pojo.Passwordhistorymaster;
import com.discom.springmvc.service.AddService;
import com.discom.springmvc.service.ListService;
import com.discom.springmvc.service.UserProfileService;
import com.discom.springmvc.service.UserService;
import com.discom.springmvc.validator.ContactFormValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {

    @Autowired
    UserService userService;

    @Autowired
    UserProfileService userProfileService;
    @Autowired
    ListService listService;
    @Autowired
    AddService addService;
    @Autowired
    MessageSource messageSource;
    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    HttpServletRequest request;
    @Autowired
    SearchDao searchDao;
    java.util.Date saveDate = new java.util.Date();
    java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
    String userListExportSearch;
    // @Autowired
    // MongoOperations mongoOperations;
    @Autowired
    private ListDao listDao;
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private ContactFormValidator validator;

    public static CellRangeAddress getMergedRegionForCell(Cell c) {
        Sheet s = c.getRow().getSheet();

        final int num = s.getNumMergedRegions();
        for (int i = 0; i < num; i++) {
            final CellRangeAddress range = s.getMergedRegion(i);
            if (range.isInRange(c.getRowIndex(), c.getColumnIndex())) {
                return range;
            }
        }
        // Not in any
        return null;
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    //@PreAuthorize(value="@securityService1.userHasPermissionForURL(authentication, '/list')")
    public String setSession(ModelMap model) throws Exception {


        OAuth2AuthenticationToken oauthentication = (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        if (oauthentication == null) {
            return "redirect:/sso/login";
        }


        System.out.println("In Home..." + getPrincipal());
        User user = searchDao.findUserByUserId(getPrincipal());
        HttpSession session = request.getSession(false);
        session.setMaxInactiveInterval(30 * 60);
        System.out.println("id " + session.getId());
        HashMap<String, Boolean> permList = new HashMap<String, Boolean>();
        permList.put("/list", true);
        session.setAttribute("permList", permList);
        session.setAttribute("getPrincipal", getPrincipal());
        session.setAttribute("getPrincipalName", user.getFirstName() + " " + user.getLastName());
        session.setAttribute("staticResouce", "http://localhost:8087/AuthApp/");


        System.out.println("Now about to looged in...SSS");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        boolean isResetPassword = false;
        boolean adminpassexpired = false;


        if (isResetPassword == true || adminpassexpired == true) {

            String uid = user.getUserid();
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            session.invalidate();
            if (auth != null) {
                SecurityContextHolder.getContext().setAuthentication(null);
            }
            model.addAttribute("uid", uid);

            return "resetPasswordF45D";
        } else {


            if (user == null) {
                return "login";
            } else if (user.getConsumerno() != null) {

                BigDecimal invoiceAmount = BigDecimal.ZERO, paymentAmount = BigDecimal.ZERO, outstandingAmount = BigDecimal.ZERO;
                Date fromdate = null;

                System.out.println("outstandingAmount////" + outstandingAmount + ",,,,,,,,,,,,,paymentAmount//" + paymentAmount);

                model.addAttribute("invoiceAmount", invoiceAmount);
                model.addAttribute("paymentAmount", paymentAmount);
                model.addAttribute("outstandingAmount", outstandingAmount);
                model.addAttribute("consumerno", user.getConsumerno());

                Date saveDate = new Date();
                java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
                User usr = searchDao.findUserByUserId(getPrincipal());
                usr.setLastloginDate(timeStampDate);
                addService.UpdateUser(usr);

                String wpdids = user.getConsumerno();


                return "clientlist";   //"redirect:/clientApprovedBills";
            } else {
                return "redirect:/list";
            }
        }

    }
	
	/*@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	@PreAuthorize(value="@securityService1.userHasPermissionForURL(authentication, '/list')")
	public String listUsers(ModelMap model) {

		List<User> users = userService.findAllUsers();
		
		//model.addAttribute("users "+users.size());
		model.addAttribute("users", users);
				
		
		return "list";
	}*/

    /**
     * This method will list all existing users.
     */
    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    @PreAuthorize(value = "@securityService1.userHasPermissionForURL(authentication, '/list')")
    public String listUsers(ModelMap model) throws Exception {

        List<User> users = userService.findAllUsers();

        System.out.println("Now about to looged in...INLIST");

        Date saveDate = new Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        User usr = searchDao.findUserByUserId(getPrincipal());
        usr.setLastloginDate(timeStampDate);
        addService.UpdateUser(usr);

        OAuth2AuthenticationToken oauth = (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();//
        String registrationid = oauth.getAuthorizedClientRegistrationId();

        System.out.println(oauth.toString());
        System.out.println(registrationid);
        System.out.println("Name: " + oauth.getName());
        System.out.println("Authority: " + oauth.getAuthorities());
        System.out.println("Credential: " + oauth.getCredentials());
        System.out.println("Principal: " + oauth.getPrincipal());
        System.out.println("Details: " + oauth.getDetails());
        System.out.println("Authenticated: " + oauth.isAuthenticated());
        System.out.println("Principal:Name: " + oauth.getPrincipal().getName());
        System.out.println("Principal:Attr: " + oauth.getPrincipal().getAttributes());
        System.out.println("Principal:Auth: " + oauth.getPrincipal().getAuthorities());
        System.out.println("Principal.tostring: " + oauth.getPrincipal().toString());

        model.addAttribute("oauth", oauth.toString());
        model.addAttribute("registrationid", registrationid);
        model.addAttribute("Name", oauth.getName());
        model.addAttribute("Authority", oauth.getAuthorities());
        model.addAttribute("Credential", oauth.getCredentials());
        model.addAttribute("Principal", oauth.getPrincipal());
        model.addAttribute("Details", oauth.getDetails());
        model.addAttribute("Authenticated", oauth.isAuthenticated());
        model.addAttribute("PrincipalName", oauth.getPrincipal().getName());
        model.addAttribute("PrincipalAttr", oauth.getPrincipal().getAttributes());
        model.addAttribute("PrincipalAuth", oauth.getPrincipal().getAuthorities());
        model.addAttribute("Principaltostring", oauth.getPrincipal().toString());

        model.addAttribute("users", users);

        return "list";
    }

    /**
     * This method will provide the medium to add a new user.
     */
    @RequestMapping(value = {"/newuser"}, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        User user = new User();
        List<UserProfile> userProfile = userProfileService.findAll();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        model.addAttribute("userProfile", userProfile);
        return "registration";
    }

    @RequestMapping(value = {"/newuser"}, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result,
                           ModelMap model) {

        if (!userService.isUserSSOUnique(user.getId(), user.getUserid())) {
            FieldError ssoError = new FieldError("user", "userid", messageSource.getMessage("non.unique.userid", new String[]{user.getUserid()}, Locale.getDefault()));
            result.addError(ssoError);
            return "registration";
        }

        userService.saveUser(user);

        model.addAttribute("success", "User " + user.getFirstName() + " " + user.getLastName() + " registered successfully");
        //return "success";
        return "registrationsuccess";
    }

    @RequestMapping(value = {"/saveuser"}, method = RequestMethod.POST)
    public String saveNewUser(@Valid User user, BindingResult result,
                              ModelMap model) {

        //	if (result.hasErrors()) {
        //	return "registration";
        //}

        /*
         * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation
         * and applying it on field [sso] of Model class [User].
         *
         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
         * framework as well while still using internationalized messages.
         *
         */


        if (!userService.isUserSSOUnique(user.getId(), user.getUserid())) {
            FieldError ssoError = new FieldError("user", "userid", messageSource.getMessage("non.unique.userid", new String[]{user.getUserid()}, Locale.getDefault()));
            result.addError(ssoError);
            return "registration";
        }
        userService.saveUser(user);

        model.addAttribute("success", "User " + user.getFirstName() + " " + user.getLastName() + " registered successfully");

        //return "success";
        return "registrationsuccess";
    }

    @RequestMapping(value = {"/edit-user-{ssoId}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable String ssoId, ModelMap model) {
        User user = userService.findBySSO(ssoId);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);

        return "registration";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     */
    @RequestMapping(value = {"/edit-user-{ssoId}"}, method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result,
                             ModelMap model, @PathVariable String ssoId) {

        if (result.hasErrors()) {
            return "registration";
        }

        userService.updateUser(user);

        model.addAttribute("success", "User " + user.getFirstName() + " " + user.getLastName() + " updated successfully");

        return "registrationsuccess";
    }

    @RequestMapping(value = {"/myProfileAdmin"}, method = RequestMethod.GET)
    public String myProfileAdmin(ModelMap model) {

        System.out.println(getPrincipal());
        User user = userService.findBySSO(getPrincipal());
        System.out.println(user.getContactNo());
        model.addAttribute("logindetails", user);

        System.out.println("MY Prof Admin......");
        return "myprofileadmin";
    }

    @RequestMapping(value = {"/setChangedPasswordAdmin"}, method = RequestMethod.POST)
    public String setChangePasswordAdmin(@RequestParam("oldpassword") String oldpassword, @RequestParam("newpassword") String newpassword, @RequestParam("conpassword") String conpassword, @Valid User user, BindingResult result, ModelMap model) throws IOException, ParseException {
        System.out.println("oldpassword//" + oldpassword + "..newpassword//" + newpassword + "..conpassword//" + conpassword);
        //print objects...
        ModelAndView mav = new ModelAndView("../content/ResetPassSucc");
        try {
            User existeduser = userService.findBySSO(getPrincipal());
            existeduser.setNewpassword(newpassword);
            existeduser.setOldpassword(oldpassword);
            existeduser.setConpassword(conpassword);

            Passwordhistorymaster passwordhistorymaster = new Passwordhistorymaster();
            boolean status = false;
            String msg = "Note Done";

            if (result.hasErrors()) {
                System.out.println("..................errors found");
				/*model.addAttribute("user", existeduser);
				model.addAttribute("msg", msg);
				return "changepwdadmin";*/

                mav.addObject("user", existeduser);

                model.addAttribute("msg", msg);
                return "changepwdadmin";
            } else {
                System.out.println("..................errors not found");
                status = addService.UpdateUser(existeduser);
                if (status == true) {
                    Activitylog logModel = new Activitylog();
                    addService.saveActivitylog(logModel, "User password changed");

                    Date saveDate = new Date();
                    java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
                    passwordhistorymaster.setPassMasterId(null);
                    passwordhistorymaster.setCreatedOn(timeStampDate);
                    passwordhistorymaster.setLastUpdatedBy(getPrincipal());
                    passwordhistorymaster.setIsActive(true);
                    passwordhistorymaster.setPassword((existeduser.getPassword()));
                    passwordhistorymaster.setUserMasterId(existeduser.getUserid());
                    addService.addPasswordHistory(passwordhistorymaster);
                    mav.addObject("user", existeduser);

                    model.addAttribute("msg", "Done");
                } else {
                    mav.addObject("user", existeduser);

                    model.addAttribute("msg", "Not Done");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "changepwdadmin";
    }

    /**
     * This method will delete an user by it's SSOID value.
     */
    @RequestMapping(value = {"/delete-user-{ssoId}"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String ssoId) {
        userService.deleteUserBySSO(ssoId);
        return "redirect:/list";
    }

    @RequestMapping(value = {"/adminViewList"}, method = RequestMethod.GET)
    public String adminViewList(ModelMap model) {


        List<UserProfile> userProfile = userProfileService.findAll();
        model.addAttribute("userProfile", userProfile);

        return "viewuserlist";
    }

    @RequestMapping(value = "/adminList")
    public @ResponseBody
    String adminList(@RequestParam int iDisplayStart,
                     @RequestParam int iDisplayLength, @RequestParam int sEcho,
                     @RequestParam int iColumns, @RequestParam String sSearch,
                     @RequestParam int iSortCol_0, @RequestParam boolean bSortable_0,
                     @RequestParam int iSortingCols, @RequestParam("datat") String datat) {
        userListExportSearch = sSearch;
        DataTablesTO<User> dt = new DataTablesTO<User>();
        String sessid = (String) httpSession.getId();
        if (sessid != null) {
            String token = (String) httpSession.getAttribute("token");
            if (token.equals(datat)) {
                List<User> accts = listService.getAllAdminList(iDisplayStart, iDisplayLength, sSearch);
                for (int i = 0; i < accts.size(); i++) {
                    if (accts.get(i).isStatus() == true)
                        accts.get(i).setStatus1("Active");
                    else
                        accts.get(i).setStatus1("Inactive");
                }
                int count = listService.getAllAdminListCount(sSearch);
                dt.setAaData(accts);
                dt.setiTotalDisplayRecords(count);
                dt.setiTotalRecords(count);
                dt.setsEcho(sEcho);
            }
        }
        return toJson(dt);
    }

    @RequestMapping(value = "/adminListt")
    //@PreAuthorize(value="@securityService1.userHasPermissionForURL(authentication, '/adminList')")
    public @ResponseBody
    String adminListt(@RequestParam int start,
                      @RequestParam int length, @RequestParam("search[value]") String search, @RequestParam("userid") String userid,
                      @RequestParam("email") String email, @RequestParam("urole") String urole,
                      @RequestParam("joiningDate") String joiningDate, @RequestParam("datat") String datat) throws ParseException {


        String list[] = new String[4];
        list[0] = null;
        list[1] = null;
        list[2] = null;
        list[3] = null;

        System.out.println("userid " + userid + " email " + email + " urole " + urole + " joiningDate " + joiningDate + " datat: " + datat);

        if (userid != null && !userid.equals(""))
            list[0] = userid;
        if (email != null && !email.equals(""))
            list[1] = email;
        if (urole != null && !urole.equals(""))
            list[2] = urole;
        if (joiningDate != null && !joiningDate.equals(""))
            list[3] = (joiningDate);

        userListExportSearch = search;
        DataTablesTO<User> dt = new DataTablesTO<User>();
        String sessid = (String) httpSession.getId();
        if (sessid != null) {
            String token = (String) httpSession.getAttribute("token");
            if (token.equals(datat)) {
                List<User> accts = listService.getAllAdminList(start, length, search, list);
                int count = listService.getAllAdminListCount(search, list);
                System.out.println("accts___ " + accts.size() + " count: " + count);
                dt.setAaData(accts);
                dt.setiTotalDisplayRecords(count);
                dt.setiTotalRecords(count);
                dt.setsEcho(0);
            }
        }
        System.out.println("toJson(dt)___ " + toJson(dt));
        return toJson(dt);
    }

    @RequestMapping(value = "/generate/userlistexport", method = RequestMethod.GET)
    ModelAndView portfolioListExport(HttpServletRequest request,
                                     HttpServletResponse response) throws Exception {
        List<User> accts = listService.getAllAdminList(0, 0, userListExportSearch);
        for (int i = 0; i < accts.size(); i++) {
            if (accts.get(i).isStatus() == true)
                accts.get(i).setStatus1("Active");
            else
                accts.get(i).setStatus1("Inactive");
        }

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"User_List.xls\"");
        ModelAndView modelAndView = new ModelAndView("userListView", "userlist", accts);

        return modelAndView;
    }

    @RequestMapping(value = "/updateUserDetails", method = RequestMethod.POST)
    public ResponseEntity<String> uploadDocument(@RequestParam(value = "id") String id,
                                                 @RequestParam(value = "firstName", required = false) String firstName,
                                                 @RequestParam(value = "lastName", required = false) String lastName,
                                                 @RequestParam(value = "email", required = false) String email,
                                                 @RequestParam(value = "contactNo", required = false) String contactNo,
                                                 @RequestParam(value = "status", required = false) String status,
                                                 @RequestParam(value = "userrole", required = false) String userrole) throws IOException, ParseException {

        java.util.Date saveDate = new java.util.Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());

        User existeduser = userService.findById(Integer.parseInt(id));

        existeduser.setFirstName(firstName.trim());
        existeduser.setLastName(lastName.trim());
        existeduser.setEmail(email.trim());
        existeduser.setContactNo(contactNo.trim());
        existeduser.setStatus(status.trim().equals("yes") ? true : false);
        UserProfile upr = new UserProfile();
        List<UserProfile> prof = userProfileService.findAll();
        for (UserProfile u : prof) {
            System.out.println(u);
            if (u.getId().toString().equals(userrole))
                upr = u;
        }
        Set<UserProfile> userProfiles = new HashSet<UserProfile>();
        userProfiles.add(upr);
        existeduser.setUserProfiles(userProfiles);

        boolean statuss = false;

        statuss = addService.UpdateUser(existeduser);

        if (statuss == false) {
            return new ResponseEntity<>("User not updated.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("User Successfully updated.", HttpStatus.OK);
    }

    @RequestMapping(value = "/updateUserPasswordDetails", method = RequestMethod.POST)
    public ResponseEntity<String> updateUserPasswordDetails(@RequestParam(value = "id") String id,
                                                            @RequestParam(value = "password") String password) throws Exception {

        java.util.Date saveDate = new java.util.Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());

        User existeduser = userService.findById(Integer.parseInt(id));

        List<Passwordhistorymaster> passHishoryList = listDao.getPasswordHitory(existeduser.getUserid());

        for (Passwordhistorymaster s : passHishoryList) {
            try {

            } catch (Exception e) {
                // TODO Auto-generated catch
            }
        }

        boolean statuss = false;

        statuss = addService.UpdateUser(existeduser);

        if (statuss == true) {
            Activitylog logModel = new Activitylog();
            addService.saveActivitylog(logModel, "User password reset done");
            try {

                List<User> user1 = searchDao.checkEmail(existeduser.getEmail());
                String userid = user1.get(0).getUserid();

                String dataPass = "";
                boolean flag = false;
                String decDataPass = "";
                String ContextPath = request.getScheme() + "://"
                        + request.getServerName()

                        + request.getContextPath();
                if (user1 != null) {
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return new ResponseEntity<>("User password not updated.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("User Password Successfully updated.", HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/executeScript", method = RequestMethod.POST)
    public ResponseEntity<String> executeScript(@RequestParam(value = "scriptTextarea") String scriptTextarea) throws IOException, ParseException, SQLException {

        java.util.Date saveDate = new java.util.Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());

        StringWriter outWriter = new StringWriter();
        PrintWriter logWriter = new PrintWriter(outWriter);
        StringWriter errorWriter = new StringWriter();
        PrintWriter errorLogWriter = new PrintWriter(errorWriter);
        Connection con = ((SessionImpl) sessionFactory.getCurrentSession()).connection();

        try {
            ScriptRunner sr = new ScriptRunner(con);
            Reader reader = new StringReader(scriptTextarea.trim());
            System.out.println("Script: " + scriptTextarea.trim());
            sr.setStopOnError(false);
            sr.setLogWriter(logWriter);
            sr.setErrorLogWriter(errorLogWriter);
            sr.runScript(reader);

            String errorMsg = errorWriter.toString().trim();
            if (!errorMsg.equals("")) {
                System.out.println(errorWriter.toString());
                return new ResponseEntity<>("[" + timeStampDate + ": ] " + errorWriter.toString(), HttpStatus.BAD_REQUEST);
            } else {
                System.out.println(outWriter.toString());

                return new ResponseEntity<>("[" + timeStampDate + ": ] " + "Command Successfully executed. splitR " + outWriter.toString(), HttpStatus.OK);
            }

        } catch (Exception e) {
            System.err.println("Failed to Execute" + scriptTextarea.trim() + " The error is " + e.getMessage());
            return new ResponseEntity<>("[" + timeStampDate + ": ] " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } finally {
            con.close();
        }
    }

    @RequestMapping(value = "/updateHeaderDetails", method = RequestMethod.POST)
    public ResponseEntity<String> updateHeaderDetails(@RequestParam("logo") MultipartFile file) throws IOException, ParseException {

        if (file.isEmpty()) {
            return new ResponseEntity<>("Invalid or empty file.", HttpStatus.BAD_REQUEST);
        }
        if (!FilenameUtils.getExtension(file.getOriginalFilename()).equalsIgnoreCase("png")) {
            return new ResponseEntity<>("Invalid file only png file accepted.", HttpStatus.BAD_REQUEST);
        }
        boolean statuss = false;
        try {
            ServletContext context = request.getServletContext();
            String appPath = context.getRealPath("");
            System.out.println("appPath = " + appPath);
            appPath = appPath + "/assets/media/logos/";
            System.out.println("appPath = " + appPath + file.getOriginalFilename());
            byte[] bytes = file.getBytes();
            Path path = Paths.get(appPath + file.getOriginalFilename());
            //Files.write(path, bytes);

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(appPath + "jobships.png")));
            stream.write(bytes);
            stream.close();

            statuss = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (statuss == false) {
            return new ResponseEntity<>("Header not updated.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Header Successfully updated.", HttpStatus.OK);
    }

    // end member list

    @RequestMapping(value = {"/getActive"}, method = RequestMethod.POST)
    public ResponseEntity getActive(@RequestBody String content) {
        content = content.trim();

        ResponseEntity r = null;
        String msg = "No";
        try {

            JSONObject jsonObject;
            jsonObject = new JSONObject(content);
            int id = jsonObject.getInt("id");
            String datat = jsonObject.getString("datat");
            String sessid = (String) httpSession.getId();

            if (sessid != null) {
                String token = (String) httpSession.getAttribute("token");
                if (token.equals(datat)) {
                    User user = searchDao.findUserByMasterId(id);
                    user.setStatus(!user.isStatus());
                    addService.UpdateUser(user);
                    msg = "Yes";
                    JSONObject jsonParams = new JSONObject();
                    jsonParams.put("result", msg);
                    r = new ResponseEntity(jsonParams.toString(), HttpStatus.OK);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    private String toJson(DataTablesTO<?> dt) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(dt);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    /**
     * This method will provide UserProfile list to views
     */
    @ModelAttribute("roles")
    public List<UserProfile> initializeProfiles() {
        return userProfileService.findAll();
    }

    /**
     * This method handles Access-Denied redirect.
     */
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        System.out.println("access den");

        return "accessDenied";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload(ModelMap model) {


        return "upload";
    }

    /**
     * This method handles login GET requests.
     * If users is already logged-in and tries to goto login page again, will be redirected to list page.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        if (isCurrentAuthenticationAnonymous()) {
            return "redirect:/sso/login";
        } else {
            return "redirect:/list";
        }
    }

    @RequestMapping(value = "/sso/login", method = RequestMethod.GET)
    public String ssoPage() {

        return "sso";
    }

    /**
     * This method handles logout requests.
     * Toggle the handlers if you are RememberMe functionality is useless in your app.
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthenticationToken oauth = (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        oauth.setAuthenticated(false);
        oauth.eraseCredentials();
        HttpSession session = request.getSession(false);
        session.invalidate();
        if (auth != null) {
            //new SecurityContextLogoutHandler().logout(request, response, auth);
            //persistentTokenBasedRememberMeServices.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/sso/login?logout";
    }

    private String getPrincipal() {
        String userName = null;
        OAuth2AuthenticationToken oauth = (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();//
        String registrationid = oauth.getAuthorizedClientRegistrationId();

        System.out.println(oauth.toString());
        System.out.println(registrationid);
        System.out.println("Name: " + oauth.getName());
        System.out.println("Authority: " + oauth.getAuthorities());
        System.out.println("Credential: " + oauth.getCredentials());
        System.out.println("Principal: " + oauth.getPrincipal());
        System.out.println("Details: " + oauth.getDetails());
        System.out.println("Authenticated: " + oauth.isAuthenticated());
        System.out.println("Principal:Name: " + oauth.getPrincipal().getName());
        System.out.println("Principal:Attr: " + oauth.getPrincipal().getAttributes());
        System.out.println("Principal:Auth: " + oauth.getPrincipal().getAuthorities());
        System.out.println("Principal.tostring: " + oauth.getPrincipal().toString());
        if (oauth instanceof UserDetails) {
            userName = ((UserDetails) oauth).getUsername();
        } else {
            userName = oauth.getPrincipal().getName();
        }
        return userName;
    }

    private boolean isCurrentAuthenticationAnonymous() {
        //final OAuth2AuthenticationToken oauthentication = (OAuth2AuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
        final Object oauthentication = SecurityContextHolder.getContext().getAuthentication();
        //Authentication authentication = oauthentication.getUserAuthentication();
        System.out.println(" oauthentication " + (oauthentication));
        if (oauthentication == null) {
            return true;
        } else if (oauthentication instanceof AnonymousAuthenticationToken) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * private boolean isCurrentAuthenticationAnonymous() { final Authentication
     * authentication = SecurityContextHolder.getContext().getAuthentication();
     * //return authenticationTrustResolver.isAnonymous(authentication);
     * System.out.println(" authentication "+(authentication));
     * if(authentication!=null) return true; else return false; }
     */

    public List<List<String>> transpose(List<List<String>> table) {
        List<List<String>> ret = new ArrayList<List<String>>();
        final int N = table.get(0).size();
        for (int i = 0; i < N; i++) {
            List<String> col = new ArrayList<String>();
            for (List<String> row : table) {
                col.add(row.get(i));
            }
            ret.add(col);
        }
        return ret;
    }


}