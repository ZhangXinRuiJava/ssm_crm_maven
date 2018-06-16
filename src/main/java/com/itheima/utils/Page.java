package com.itheima.utils;

import java.util.List;

public class Page<T> {
	/*// 1 当前页，前台传入
		private Integer currentPage;
		// 2 当前页显示条数，前台传入
		private Integer currentCount;
		// 3 总条数，dao查询
		private Integer totalCount;
		// 4 总页数，总页数=(int)Math.ceil(总条数/每页数量); 或 总页数=(总条数+每页数量-1)/每页数量;
		private Integer totalPage;
		// 5 每页数据，dao查询
		private List<T> list = new ArrayList<>();*/
	
	// 1 总条数，dao查询
	private Integer total;
	// 2 当前页，前台传入
	private Integer page;
	// 3 当前页显示条数，前台传入
	private Integer size;
	// 4 每页数据，dao查询
	private List<T> rows;
	
	public Page(Integer page, Integer size,Integer total) {
		super();
		this.page = page;
		this.size = size;
		this.total = total;
		
		//没指定当前页默认就是第一页
		if(this.page == null){
			this.page = 1;
		}
		//没指定每页数量默认就是3条
		if(this.size == null){
			this.size = 3;
		}
	}
	//计算起始索引
	public int getStartIndex(){
		return (this.page-1)*this.size;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
