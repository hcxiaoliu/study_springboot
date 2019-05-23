package com.xiaoliu.pojo;

import io.swagger.annotations.ApiModelProperty;

public class Bank {
    @ApiModelProperty(value="银行id",required=false)
    private Integer bankid;

    @ApiModelProperty(value="银行名称",required=false)

    private String bankname;

    public Integer getBankid() {
        return bankid;
    }

    public void setBankid(Integer bankid) {
        this.bankid = bankid;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }
}
