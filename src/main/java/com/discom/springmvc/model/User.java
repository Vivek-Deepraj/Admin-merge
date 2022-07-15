package com.discom.springmvc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "app_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "userid", unique = true, nullable = false)
    private String userid;


    @Column(name = "password", nullable = false)
    private String password;


    @Column(name = "first_name", nullable = false)
    private String firstName;


    @Column(name = "last_name", nullable = false)
    private String lastName;


    @Column(name = "email", nullable = false)
    private String email;


    @Column(name = "joining_date", nullable = false)
    private String joiningDate;


    @Column(name = "contact_no", nullable = false)
    private String contactNo;

    @Column(name = "status", nullable = false)
    private boolean status;

    @Column(name = "moduleno")
    private String moduleno;
    @Column(name = "lastlogin_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastloginDate;
    @Column(name = "invalid_pass_count")
    private Integer invalidPassCount;
    @Column(name = "isActive")
    private Boolean isActive;
    @Column(name = "isLocked")
    private Boolean isLocked;
    @Column(name = "isResetPassword")
    private Boolean isResetPassword;
    @Lob
    @Column(name = "profilepicture")
    private byte[] profilepicture;
    @Column(name = "extension")
    private String extension;
    @Column(name = "client")
    private String client;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "app_user_user_profile",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_profile_id")})
    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();
    @Transient
    private String status1;
    @Transient
    private String newpassword;
    @Transient
    private String oldpassword;
    @Transient
    private String conpassword;
    @Transient
    private String lastlogin;
    @Transient
    private String consumerno;
    @Transient
    private String urole;

    public String getModuleno() {
        return moduleno;
    }

    public void setModuleno(String moduleno) {
        this.moduleno = moduleno;
    }

    public Integer getInvalidPassCount() {
        return invalidPassCount;
    }

    public void setInvalidPassCount(Integer invalidPassCount) {
        this.invalidPassCount = invalidPassCount;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsResetPassword() {
        return isResetPassword;
    }

    public void setIsResetPassword(Boolean isResetPassword) {
        this.isResetPassword = isResetPassword;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(String lastlogin) {
        this.lastlogin = lastlogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<UserProfile> getUserProfiles() {
        System.out.println(" userProfiles egt " + userProfiles);
        return userProfiles;
    }

    public void setUserProfiles(Set<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((userid == null) ? 0 : userid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (userid == null) {
            if (other.userid != null)
                return false;
        } else if (!userid.equals(other.userid))
            return false;
        return true;
    }

    /*
     * DO-NOT-INCLUDE passwords in toString function.
     * It is done here just for convenience purpose.
     */
    @Override
    public String toString() {
        return "User [id=" + id + ", userid=" + userid + ", password=" + password
                + ", firstName=" + firstName + ", lastName=" + lastName
                + ", email=" + email + "]";
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getStatus1() {
        return status1;
    }

    public void setStatus1(String status1) {
        this.status1 = status1;
    }

    public String getConsumerno() {
        return consumerno;
    }

    public void setConsumerno(String consumerno) {
        this.consumerno = consumerno;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    public String getConpassword() {
        return conpassword;
    }

    public void setConpassword(String conpassword) {
        this.conpassword = conpassword;
    }

    public Date getLastloginDate() {
        return lastloginDate;
    }

    public void setLastloginDate(Date lastloginDate) {
        this.lastloginDate = lastloginDate;
    }

    public String getUrole() {
        return urole;
    }

    public void setUrole(String urole) {
        this.urole = urole;
    }

    public byte[] getProfilepicture() {
        return profilepicture;
    }

    public void setProfilepicture(byte[] profilepicture) {
        this.profilepicture = profilepicture;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
