import java.sql.Date;

public class Titles {
	int titleId;
	String titleName;
	Date purchaseDate;
	int publisherId;
	int subjectId;

	/**
	 * @return the titleId
	 */
	public int getTitleId() {
		return titleId;
	}

	/**
	 * @param titleId
	 *  the titleId to set
	 */
	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}

	/**
	 * @return the titleName
	 */
	public String getTitleName() {
		return titleName;
	}

	/**
	 * @param titleName
	 *the titleName to set
	 */
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	/**
	 * @return the purchaseDate
	 */
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	/**
	 * @param purchaseDate
	 *            the purchaseDate to set
	 */
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	
	@Override
	public String toString() {
		return "Titles [titleId=" + titleId + ", titleName=" + titleName
				+ ", purchaseDate=" + purchaseDate + ", publisherId="
				+ publisherId + ", subjectId=" + subjectId + "]";
	}

	/**
	 * @return the publisherId
	 */
	public int getPublisherId() {
		return publisherId;
	}

	/**
	 * @param publisherId
	 *            the publisherId to set
	 */
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	/**
	 * @return the subjectId
	 */
	public int getSubjectId() {
		return subjectId;
	}

	/**
	 * @param subjectId
	 *            the subjectId to set
	 */
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

}
