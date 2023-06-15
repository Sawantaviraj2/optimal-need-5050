package entity;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "stock_name", nullable = false, unique = true, length = 50)
	private String stockName;

	@Column(name = "stockestd_year", nullable = false)
	int stockestdYear;

	@Column(name = "stockestd_year", nullable = false)
	int stockPrice;

	@Column(name = "stocksector_type", nullable = false, length = 10)
	private String stocksectorType;

	@ManyToMany(mappedBy = "orderStockSet")
	private Set<Customer> customer;

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stock(String stockName, int stockestdYear, int stockPrice, String stocksectorType, Set<Customer> customer) {
		super();
		this.stockName = stockName;
		this.stockestdYear = stockestdYear;
		this.stockPrice = stockPrice;
		this.stocksectorType = stocksectorType;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getStockestdYear() {
		return stockestdYear;
	}

	public void setStockestdYear(int stockestdYear) {
		this.stockestdYear = stockestdYear;
	}

	public String getStocksectorType() {
		return stocksectorType;
	}

	public void setStocksectorType(String stocksectorType) {
		this.stocksectorType = stocksectorType;
	}

	public Set<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(Set<Customer> customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(stockName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		return Objects.equals(stockName, other.stockName);
	}

	public int getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(int stockPrice) {
		this.stockPrice = stockPrice;
	}

}
