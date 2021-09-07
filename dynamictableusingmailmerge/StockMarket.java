import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "StockMarket")
public class StockMarket 
{
	private List<StockDetails> StockDetails;

	@XmlElement(name = "StockDetails")
	/**
	 * Gets the list of stock details.
	 */
	public List<StockDetails> getStockDetails() {
		return StockDetails;
	}

	/**
	 * Sets the list of stock details.
	 * 
	 * @param stockDetails List of stock details.
	 */
	public void setStockDetails(List<StockDetails> listStockDetails) {
		this.StockDetails = listStockDetails;
	}

	/**
	 * Initializes a new instance of the StockMarket class.
	 */
	public StockMarket() {
	}

	/**
	 * Initializes a new instance of the StockMarket class with specified list of
	 * stock details.
	 * 
	 * @param stockDetails List of stock details.
	 */
	public StockMarket(List<StockDetails> stockDetails) {
		this.StockDetails = stockDetails;
	}
}
