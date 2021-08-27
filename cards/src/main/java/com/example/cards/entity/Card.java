package com.example.cards.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Persistent Class DTO 
 * 
 * @author Daniel Phillips
 *
 */
@Entity
@Table(name="card")
public class Card {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cardid")
	private Long cardid;
	@Column(name="marca")
	private String marca;
	@Column(name="modelo")
	private String modelo;
	@Column(name="maximokmh")
	private int maixmokmh;
	@Column(name="cv")
	private int cv;
	@Column(name="tmin")
	private int tmin;
	@Column(name="cc")
	private int cc;
	@Column(name="cilindros")
	private int clilindros;
	@Column(name="kg")
	private int kg;
	@Column(name="image")
	private String image;
	@Column(name="createdate")
	private Date createdate;
	
	public Card() { 
		// Default Constructorr
	}

	public Long getCardid() {
		return cardid;
	}

	public void setCardid(Long cardid) {
		this.cardid = cardid;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getMaixmokmh() {
		return maixmokmh;
	}

	public void setMaixmokmh(int maixmokmh) {
		this.maixmokmh = maixmokmh;
	}

	public int getCv() {
		return cv;
	}

	public void setCv(int cv) {
		this.cv = cv;
	}

	public int getTmin() {
		return tmin;
	}

	public void setTmin(int tmin) {
		this.tmin = tmin;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public int getClilindros() {
		return clilindros;
	}

	public void setClilindros(int clilindros) {
		this.clilindros = clilindros;
	}

	public int getKg() {
		return kg;
	}

	public void setKg(int kg) {
		this.kg = kg;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

}
