package shallWe.VO;

public class PagingVO {
	int currentPage = 1;	// 현재 페이지 번호
	int totalData;			// 데이터 수
	int startPage;			// 출력 시작
	int endPage;			// 출력 끝
	int displayData;		// 한 페이지에 보일 데이터 수
	int displayPage;		// 보이는 페이지 수
	boolean prev;			// prev 버튼 보일건지 안보일건지
	boolean next;
	int startRowNum;
	int endRowNum;
	int totalPage;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalData() {
		return totalData;
	}
	public void setTotalData(int totalData) {
		this.totalData = totalData;
		paging();
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getDisplayData() {
		return displayData;
	}
	public void setDisplayData(int displayData) {
		this.displayData = displayData;
	}
	public int getDisplayPage() {
		return displayPage;
	}
	public void setDisplayPage(int displayPage) {
		this.displayPage = displayPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getStartRowNum() {
		return startRowNum;
	}
	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}
	public int getEndRowNum() {
		return endRowNum;
	}
	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
	@Override
	public String toString() {
		return "PagingVO [currentPage=" + currentPage + ", totalData=" + totalData + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", displayData=" + displayData + ", displayPage=" + displayPage + ", prev="
				+ prev + ", next=" + next + ", startRowNum=" + startRowNum + ", endRowNum=" + endRowNum + ", totalPage="
				+ totalPage + "]";
	}
	public void paging() {
		startRowNum = (currentPage - 1) * displayData + 1;
		endRowNum = currentPage * displayData;
		
		endPage = ((currentPage + (displayPage - 1)) / displayPage) * displayPage;
		startPage = endPage - (displayPage - 1);
		
		// 마지막 페이지
		totalPage = totalData / displayData;
		if(totalData % displayData > 0) totalPage++;
		
		if(endPage > totalPage) {
			endPage = totalPage;
			next = false;
		}else {
			next = true;
		}
		
		prev = (startPage == 1) ? false : true;
	}
}
