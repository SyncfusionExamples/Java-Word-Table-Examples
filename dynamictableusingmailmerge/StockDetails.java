import javax.xml.bind.annotation.XmlElement;
public class StockDetails 
{
	private String TradeNo;
	private String CompanyName;
	private String CostPrice;
	private String SharesCount;
	private String SalesPrice;
	@XmlElement(name = "TradeNo")
	/**
	 * Gets the trade number of the share.
	 */
	public String getTradeNo() 
	{
		return TradeNo;
	}
	/**
	 * Sets the trade number of the share.
	 * 
	 * @param tradeNo Trade number of the share.
	 */
	public void setTradeNo(String tradeNo) 
	{
		this.TradeNo = tradeNo;
	}
	@XmlElement(name = "CompanyName")
	/**
	 * Gets the company name of the share.
	 */
	public String getCompanyName() 
	{
		return CompanyName;
	}
	/**
	 * Sets company name of the share.
	 * 
	 * @param companyName Company name of the share.
	 */
	public void setCompanyName(String companyName) 
	{
		this.CompanyName = companyName;
	}
	@XmlElement(name = "SharesCount")
	/**
	 * Gets the total shares count.
	 */
	public String getSharesCount() 
	{
		return SharesCount;
	}
	/**
	 * Sets the total shares count.
	 * 
	 * @param sharesCount Total shares count.
	 */
	public void setSharesCount(String sharesCount) 
	{
		this.SharesCount = sharesCount;
	}
	@XmlElement(name = "CostPrice")
	/**
	 * Gets the cost price of the share.
	 */
	public String getCostPrice() 
	{
		return CostPrice;
	}
	/**
	 * Sets the cost price of the share.
	 * 
	 * @param costPrice Cost price of the share.
	 */
	public void setCostPrice(String costPrice) 
	{
		this.CostPrice = costPrice;
	}
	@XmlElement(name = "SalesPrice")
	/**
	 * Gets the sales price of the share.
	 */
	public String getSalesPrice() 
	{
		return SalesPrice;
	}
	/**
	 * Sets the sales price of the share.
	 * 
	 * @param salesPrice Sales price of the share.
	 */
	public void setSalesPrice(String salesPrice) 
	{
		this.SalesPrice = salesPrice;
	}
	/**
	 * Initializes a new instance of the StockDetails class.
	 */
	public StockDetails() 
	{
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
	{
		this.TradeNo = tradeNo;
		this.CompanyName = companyName;
		this.CostPrice = costPrice;
		this.SharesCount = sharesCount;
		this.SalesPrice = salesPrice;
	}
}
