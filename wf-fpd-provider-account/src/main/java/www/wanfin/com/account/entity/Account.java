package www.wanfin.com.account.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String AccId;
	
	@Column
	private BigDecimal amount;

	public String getAccId() {
		return AccId;
	}

	public void setAccId(String accId) {
		AccId = accId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
