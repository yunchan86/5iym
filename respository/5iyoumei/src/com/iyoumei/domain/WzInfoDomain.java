package com.iyoumei.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 违章信息
 * @author Jeff
 *
 */
public class WzInfoDomain implements Serializable{
	private static final long serialVersionUID = 5174516652518197950L;
	private String uuid;
	private int id;//违章记录编号,
	private int carId;//汽车编号,
	private String status;//违章记录是否处理（Y:已处理，N:未处理）,
	private int fen;//违章扣分
	private String officer;//执法机关
	private Date occurDate;//违章时间
	private String occurArea;//违章所在地
	private int cityId;//违章所在的城市（与省市配置对应）,
	private int provinceId;//违章所在的省份（与省市配置对应）,
	private String code;//违章代码,
	private String info;//违章内容,
	private int money;//罚款金额,
	private String cityName;//违章所在的城市名称
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getFen() {
		return fen;
	}
	public void setFen(int fen) {
		this.fen = fen;
	}
	public String getOfficer() {
		return officer;
	}
	public void setOfficer(String officer) {
		this.officer = officer;
	}
	public Date getOccurDate() {
		return occurDate;
	}
	public void setOccurDate(Date occurDate) {
		this.occurDate = occurDate;
	}
	public String getOccurArea() {
		return occurArea;
	}
	public void setOccurArea(String occurArea) {
		this.occurArea = occurArea;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
		
		
}
