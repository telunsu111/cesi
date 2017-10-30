package com.fictions.assist.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 类说明: 分页对象
 * <br />
 * Author: Huyihui
 * <br />
 * Date: 2016-11-29
 * <br />
 * Copyright (c) 2006-2015.Beijing WenHua Online Sci-Tech Development Co. Ltd
 * All rights reserved.
 */
public abstract class PageableDTO<T> implements Serializable {
	private static final long serialVersionUID = 2367850261193739630L;
	private int pn;//页码，从1开始
	private int ps;//每页容量
	private int total;//数据总数量
	private List<T> list;//当前页的数据
	
	public int getPn() {
		return pn;
	}
	public void setPn(int pn) {
		this.pn = pn;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
