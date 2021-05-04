package com.jump.jump.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;



@Entity
public class Estate {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
	    private long  id;
	    private String tradingName;
	    private String companyName;
	    private String cnpj;
	    private String telephone;


	public String getCnpj() {
	        return cnpj;
	    }

	    public void setCnpj(String cnpj) {
	        this.cnpj = cnpj;
	    }

	    public String getTelephone() {
	        return telephone;
	    }

	    public void setTelephone(String telephone) {
	        this.telephone = telephone;
	    }



	    public String getTradingName() {
	        return tradingName;
	    }

	    public void setTradingName(String tradingName) {
	        this.tradingName = tradingName;
	    }

	    public String getCompanyName() {
	        return companyName;
	    }

	    public void setCompanyName(String companyName) {
	        this.companyName = companyName;
	    }

	    public long  getId() {
	        return id;
	    }

	    public void setId(long  id) {
	        this.id = id;
	    }


}
