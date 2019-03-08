package cn.wolfcode.accountbook.base.domain;

import cn.wolfcode.accountbook.util.BitStatesUtils;

public class UserInfo extends BaseDomain{


    //用户实名值（冗余数据）
    private String realName;

    // 用户身份证号（冗余数据）
    private String idNumber;

    // 版本号，用作乐观锁
    private int version;
    // 用户状态值
    private Long bitstate = 0L;
    // 用户电话
    private String phoneNumber;
    // 收入
    private SystemDictionaryItem incomeGrade;
    // 婚姻情况
    private SystemDictionaryItem marriage;
    //子女情况
    private SystemDictionaryItem kidCount;
    // 学历
    private SystemDictionaryItem educationBackground;
    // 住房条件
    private SystemDictionaryItem houseCondition;
    //邮箱
    private String email;

    //实名认证Id
    private Long realAuthId;

    //视屏认证Id
    private Long videoAuthId;


    //是否已经完成基本资料的填写
    public boolean isBasicInfo(){

        return BitStatesUtils.hasState(bitstate,BitStatesUtils.OP_BASIC_INFO);
    }

    /*
       给bitState 添加一个状态值
    */
    public void addBitState(Long state){
        long addState = BitStatesUtils.addState(bitstate, state);
        bitstate = addState;
    }



    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Long getBitstate() {
        return bitstate;
    }

    public void setBitstate(Long bitstate) {
        this.bitstate = bitstate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public SystemDictionaryItem getIncomeGrade() {
        return incomeGrade;
    }

    public void setIncomeGrade(SystemDictionaryItem incomeGrade) {
        this.incomeGrade = incomeGrade;
    }

    public SystemDictionaryItem getMarriage() {
        return marriage;
    }

    public void setMarriage(SystemDictionaryItem marriage) {
        this.marriage = marriage;
    }

    public SystemDictionaryItem getKidCount() {
        return kidCount;
    }

    public void setKidCount(SystemDictionaryItem kidCount) {
        this.kidCount = kidCount;
    }

    public SystemDictionaryItem getEducationBackground() {
        return educationBackground;
    }

    public void setEducationBackground(SystemDictionaryItem educationBackground) {
        this.educationBackground = educationBackground;
    }

    public SystemDictionaryItem getHouseCondition() {
        return houseCondition;
    }

    public void setHouseCondition(SystemDictionaryItem houseCondition) {
        this.houseCondition = houseCondition;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getRealAuthId() {
        return realAuthId;
    }

    public void setRealAuthId(Long realAuthId) {
        this.realAuthId = realAuthId;
    }

    public Long getVideoAuthId() {
        return videoAuthId;
    }

    public void setVideoAuthId(Long videoAuthId) {
        this.videoAuthId = videoAuthId;
    }
}