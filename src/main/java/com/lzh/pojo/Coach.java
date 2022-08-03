package com.lzh.pojo;

/**
 * @author LiuZhiHan [985936872@qq.com]
 * @date 2022/3/22
 */
public class Coach {

    private Integer coachID;
    private String coachPassword;
    private String coachName;
    private String coachGender;
    private Integer coachAge;
    private String coachnumber;
    private String coachphone;
    private Float coachsalary;



    public Integer getCoachID() {
        return coachID;
    }

    public void setCoachID(Integer coachID) {
        this.coachID = coachID;
    }

    public String getCoachPassword() {
        return coachPassword;
    }

    public void setCoachPassword(String coachPassword) {
        this.coachPassword = coachPassword;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getCoachGender() {
        return coachGender;
    }

    public void setCoachGender(String coachGender) {
        this.coachGender = coachGender;
    }

    public Integer getCoachAge() {
        return coachAge;
    }

    public void setCoachAge(Integer coachAge) {
        this.coachAge = coachAge;
    }

    public String getCoachnumber() {
        return coachnumber;
    }

    public void setCoachnumber(String coachnumber) {
        this.coachnumber = coachnumber;
    }

    public String getCoachphone() {
        return coachphone;
    }

    public void setCoachphone(String coachphone) {
        this.coachphone = coachphone;
    }

    public Float getCoachsalary() {
        return coachsalary;
    }

    public void setCoachsalary(Float coachsalary) {
        this.coachsalary = coachsalary;
    }

    @Override
    public String toString() {
        return "Coach{" +
                ", coachID=" + coachID +
                ", coachPassword='" + coachPassword + '\'' +
                ", coachName='" + coachName + '\'' +
                ", coachGender='" + coachGender + '\'' +
                ", coachAge=" + coachAge +
                ", coachnumber=" + coachnumber +
                ", coachphone=" + coachphone +
                ", coachsalary=" + coachsalary +
                '}';
    }
}
