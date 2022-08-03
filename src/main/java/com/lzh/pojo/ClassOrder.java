package com.lzh.pojo;

/**
 * @author LiuZhiHan [985936872@qq.com]
 * @date 2022/3/22
 */
public class ClassOrder {

    private Integer classOrderId;
    private Integer classId;
    private String className;
    private String coach;
    private String memberName;
    private Integer memberAccount;
    private String classBegin;
    private  Integer coachId;

    public ClassOrder() {
    }

    public ClassOrder(Integer classOrderId, Integer classId, String className, String coach, String memberName, Integer memberAccount, String classBegin, Integer coachId) {
        this.classOrderId = classOrderId;
        this.classId = classId;
        this.className = className;
        this.coach = coach;
        this.memberName = memberName;
        this.memberAccount = memberAccount;
        this.classBegin = classBegin;
        this.coachId = coachId;
    }

    public ClassOrder(Integer classId1, String className, String coach, String memberName, Integer memberAccount, String classBegin, Integer coachId) {
        this.classId = classId1;
        this.className = className;
        this.coach = coach;
        this.memberName = memberName;
        this.memberAccount = memberAccount;
        this.classBegin = classBegin;
        this.coachId = coachId;
    }

    public Integer getClassOrderId() {
        return classOrderId;
    }

    public void setClassOrderId(Integer classOrderId) {
        this.classOrderId = classOrderId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Integer getMemberAccount() {
        return memberAccount;
    }

    public void setMemberAccount(Integer memberAccount) {
        this.memberAccount = memberAccount;
    }

    public String getClassBegin() {
        return classBegin;
    }

    public void setClassBegin(String classBegin) {
        this.classBegin = classBegin;
    }

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    @Override
    public String toString() {
        return "ClassOrder{" +
                "classOrderId=" + classOrderId +
                ", classId=" + classId +
                ", className='" + className + '\'' +
                ", coach='" + coach + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberAccount=" + memberAccount +
                ", classBegin='" + classBegin + '\'' +
                ", coachId=" + coachId +
                '}';
    }
}
