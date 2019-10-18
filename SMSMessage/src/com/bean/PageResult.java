package com.bean;

import java.util.List;

/*
 * 分页对象
 */
public class PageResult {
	private int currentPage;//当前页
	private int prevPage;//上一页
	private int nextPage;//下一页
	private int totalSize;//总共数据行数
	private int pageSize;//每页显示数据行数
	private int lastPage;//最后一页
	
	private String code;//状态码  0 
	private String message;//描述信息
	
	private List dataList;//数据列表
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



	
	public PageResult() {
		super();
	}

	public PageResult(int currentPage, int prevPage, int nextPage, int totalSize, int pageSize, int lastPage,
			List dataList) {
		super();
		this.currentPage = currentPage;
		if(currentPage > 1) {
			this.prevPage = currentPage - 1;
		}else {
			this.prevPage = currentPage;
		}
		
		this.pageSize = pageSize; //5
		
		this.totalSize = totalSize;  //13
		
		this.lastPage = (totalSize%pageSize==0) ? (totalSize/pageSize) : (totalSize/pageSize+1);
		
		if(currentPage < lastPage) {
			this.nextPage = currentPage + 1;
		}else {
			this.nextPage = lastPage;
		}
		
		this.dataList = dataList;
	}

	public PageResult(int currentPage, int totalSize, int pageSize,List dataList) {
		super();
		this.currentPage = currentPage;
		if(currentPage > 1) {
			this.prevPage = currentPage - 1;
		}else {
			this.prevPage = currentPage;
		}
		
		this.pageSize = pageSize; //5
		
		this.totalSize = totalSize;  //13
		
		this.lastPage = (totalSize%pageSize==0) ? (totalSize/pageSize) : (totalSize/pageSize+1);
		
		if(currentPage < lastPage) {
			this.nextPage = currentPage + 1;
		}else {
			this.nextPage = lastPage;
		}
		
		this.dataList = dataList;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public List getDataList() {
		return dataList;
	}

	public void setDataList(List dataList) {
		this.dataList = dataList;
	}
	
	
	
	
}
