package com.bean;

import java.util.List;

/*
 * ��ҳ����
 */
public class PageResult {
	private int currentPage;//��ǰҳ
	private int prevPage;//��һҳ
	private int nextPage;//��һҳ
	private int totalSize;//�ܹ���������
	private int pageSize;//ÿҳ��ʾ��������
	private int lastPage;//���һҳ
	
	private String code;//״̬��  0 
	private String message;//������Ϣ
	
	private List dataList;//�����б�
	
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
