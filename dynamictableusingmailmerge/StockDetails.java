public class StockDetails 
{
	private String m_tradeNo;
	private String m_companyName;
	private String m_costPrice;
	private String m_sharesCount;
	private String m_salesPrice;

	public String getTradeNo() throws Exception {
		return m_tradeNo;
	}

	public String setTradeNo(String value) throws Exception {
		m_tradeNo = value;
		return value;
	}

	public String getCompanyName() throws Exception {
		return m_companyName;
	}

	public String setCompanyName(String value) throws Exception {
		m_companyName = value;
		return value;
	}

	public String getCostPrice() throws Exception {
		return m_costPrice;
	}

	public String setCostPrice(String value) throws Exception {
		m_costPrice = value;
		return value;
	}

	public String getSharesCount() throws Exception {
		return m_sharesCount;
	}

	public String setSharesCount(String value) throws Exception {
		m_sharesCount = value;
		return value;
	}

	public String getSalesPrice() throws Exception {
		return m_salesPrice;
	}

	public String setSalesPrice(String value) throws Exception {
		m_salesPrice = value;
		return value;
	}

	public StockDetails(String tradeNo, String companyName, String costPrice, String sharesCount, String salesPrice)
			throws Exception {
		m_tradeNo = tradeNo;
		m_companyName = companyName;
		m_costPrice = costPrice;
		m_sharesCount = sharesCount;
		m_salesPrice = salesPrice;
	}

	public StockDetails() throws Exception {
	}
}
