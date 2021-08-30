public class StockDetails 
{
	private String m_tradeNo;
	private String m_companyName;
	private String m_costPrice;
	private String m_sharesCount;
	private String m_salesPrice;

	/**
	 * Gets the trade number of the share.
	 */
	public String getTradeNo() throws Exception {
		return m_tradeNo;
	}
	/**
	 * Sets the trade number of the share.
	 */
	public String setTradeNo(String value) throws Exception {
		m_tradeNo = value;
		return value;
	}
	/**
	 * Gets the company name of the share.
	 */
	public String getCompanyName() throws Exception {
		return m_companyName;
	}
	/**
	 * Sets the company name of the share.
	 */
	public String setCompanyName(String value) throws Exception {
		m_companyName = value;
		return value;
	}
	/**
	 * Gets the cost price of the share.
	 */
	public String getCostPrice() throws Exception {
		return m_costPrice;
	}
	/**
	 * Sets the cost price of the share.
	 */
	public String setCostPrice(String value) throws Exception {
		m_costPrice = value;
		return value;
	}
	/**
	 * Gets the total number of the share.
	 */
	public String getSharesCount() throws Exception {
		return m_sharesCount;
	}
	/**
	 * Sets the total number of the share.
	 */
	public String setSharesCount(String value) throws Exception {
		m_sharesCount = value;
		return value;
	}
	/**
	 * Gets the sales price of the share.
	 */
	public String getSalesPrice() throws Exception {
		return m_salesPrice;
	}
	/**
	 * Sets the sales price of the share.
	 */
	public String setSalesPrice(String value) throws Exception {
		m_salesPrice = value;
		return value;
	}
	/**
	 * Initializes a new instance of the StockDetails class with the specified trade
	 * number, company name, cost price, share count and sales price.
	 * 
	 * @param tradeNo     Trade number of the share.
	 * @param companyName Company name of the share.
	 * @param costPrice   Cost price of the share.
	 * @param sharesCount Total share count.
	 * @param salesPrice  Sales price of the share.
	 */
	public StockDetails(String tradeNo, String companyName, String costPrice, String sharesCount, String salesPrice)
			throws Exception {
		m_tradeNo = tradeNo;
		m_companyName = companyName;
		m_costPrice = costPrice;
		m_sharesCount = sharesCount;
		m_salesPrice = salesPrice;
	}
	/**
	 * Initializes a new instance of the StockDetails class.
	 */
	public StockDetails() throws Exception {
	}
}
