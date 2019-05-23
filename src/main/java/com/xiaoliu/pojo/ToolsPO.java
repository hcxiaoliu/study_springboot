package com.xiaoliu.pojo;

import java.math.BigDecimal;


/**
 * 收大米工具实体类
 *
 * @author
 */

@TableName("r_tool")
public class ToolsPO {
 
	@ApiModelProperty("装大米工具Id")
    private Integer toolid;
   
	@ApiModelProperty("工具名称")
    private String name;
   
	@ApiModelProperty("单件工具兑换大米数量（不收手续费）")
    private BigDecimal price;
   
	@ApiModelProperty("会员持有工具有效期")
    private Integer validitytime;
   
	@ApiModelProperty("工具每次收集大米数量（克）")
    private BigDecimal harvestpd;
  
	@ApiModelProperty(" 限制个人可以拥有多少个该工具")
    private Integer limitnumber;
	
	@ApiModelProperty("总共奖励")
    private BigDecimal sumReward;

	public Integer getToolid() {
		return toolid;
	}

	public void setToolid(Integer toolid) {
		this.toolid = toolid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}



	public Integer getValiditytime() {
		return validitytime;
	}

	public void setValiditytime(Integer validitytime) {
		this.validitytime = validitytime;
	}

	public BigDecimal getHarvestpd() {
		return harvestpd;
	}

	public void setHarvestpd(BigDecimal harvestpd) {
		this.harvestpd = harvestpd;
	}

	public Integer getLimitnumber() {
		return limitnumber;
	}

	public void setLimitnumber(Integer limitnumber) {
		this.limitnumber = limitnumber;
	}

	

	public BigDecimal getSumReward() {
		return sumReward;
	}

	public void setSumReward(BigDecimal sumReward) {
		this.sumReward = sumReward;
	}

	@Override
	public String toString() {
		return "RTool [toolid=" + toolid + ", name=" + name + ", price=" + price + ", validitytime=" + validitytime
				+ ", harvestpd=" + harvestpd + ", limitnumber=" + limitnumber + ", sumReward=" + sumReward + "]";
	}
	
	
  


}
