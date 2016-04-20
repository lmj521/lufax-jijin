package com.lufax.jijin.fundation.dto;

import com.lufax.jijin.base.dto.BaseDTO;

import java.math.BigDecimal;
import java.util.Date;

public class JijinUserBalanceDTO extends BaseDTO {

    /* 陆金所用户id */
    private Long userId;
    /* 基金产品代码 */
    private String fundCode;
    /* 帐号资金（可赎回部分） */
    private BigDecimal balance;
    /* 冻结资金 （赎回冻结） */
    private BigDecimal frozenAmount;
    /* 基金份额（可赎回部分） */
    private BigDecimal shareBalance;
    /* 冻结份额 */
    private BigDecimal frozenShare;
    /* 申购在途资金  */
    private BigDecimal applyingAmount;

    private String dividendType;
    private String dividendStatus; //分红状态


    /* 乐观锁 */
    private Long version;
    /* 创建时间 */
    private Date createdAt;
    /* 更新时间 */
    private Date updatedAt;
    /* 创建人 */
    private String createdBy;
    /* 更新人 */
    private String updatedBy;

    private Integer isShow;  //1显示 2不显示

    public JijinUserBalanceDTO() {
    }

    public void addShare(BigDecimal increase) {
        if (this.shareBalance == null) {
            this.shareBalance = new BigDecimal(0);
        }
        this.shareBalance = this.shareBalance.add(increase);
    }

    public void addBalance(BigDecimal increase) {
        this.balance = this.balance.add(increase);
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getFrozenAmount() {
        return frozenAmount;
    }

    public void setFrozenAmount(BigDecimal frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    public BigDecimal getShareBalance() {
        return shareBalance;
    }

    public void setShareBalance(BigDecimal shareBalance) {
        this.shareBalance = shareBalance;
    }

    public BigDecimal getFrozenShare() {
        return frozenShare;
    }

    public void setFrozenShare(BigDecimal frozenShare) {
        this.frozenShare = frozenShare;
    }

    public String getDividendType() {
        return dividendType;
    }

    public void setDividendType(String dividendType) {
        this.dividendType = dividendType;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public BigDecimal getApplyingAmount() {
        return applyingAmount;
    }

    public void setApplyingAmount(BigDecimal applyingAmount) {
        this.applyingAmount = applyingAmount;
    }

    public String getDividendStatus() {
        return dividendStatus;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public void setDividendStatus(String dividendStatus) {
        this.dividendStatus = dividendStatus;
    }
}
