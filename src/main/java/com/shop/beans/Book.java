package com.shop.beans;
// Generated 2016-10-6 15:56:43 by Hibernate Tools 5.2.0.Beta1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Book generated by hbm2java
 */
@Entity
@Table(name = "book", catalog = "shop")
public class Book implements java.io.Serializable {

	private int bookid;
	private Booktype booktype;//
	private String bookNumber;
	private String bookName;
	private String bookAuthor;
	private String bookPress;
	private String bookPicture;
	private int bookAmount;
	private Date bookShelveTime;
	private double bookPrice;
	private String bookRemark;
	private int bookSales;
	private Set<Recommended> recommendeds = new HashSet<Recommended>(0);
	private Set<Bargain> bargains = new HashSet<Bargain>(0);
	
	private Set<Ordersbook> ordersbooks = new HashSet<Ordersbook>(0);
	
	

	public Book() {
	}

	public Book(int bookid, Booktype booktype, String bookNumber, String bookName, String bookAuthor, String bookPress,
			String bookPicture, int bookAmount, Date bookShelveTime, double bookPrice, int bookSales) {
		this.bookid = bookid;
		this.booktype = booktype;
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPress = bookPress;
		this.bookPicture = bookPicture;
		this.bookAmount = bookAmount;
		this.bookShelveTime = bookShelveTime;
		this.bookPrice = bookPrice;
		this.bookSales = bookSales;
	}

	public Book(int bookid, Booktype booktype, String bookNumber, String bookName, String bookAuthor, String bookPress,
			String bookPicture, int bookAmount, Date bookShelveTime, double bookPrice, String bookRemark, int bookSales,
			Set<Recommended> recommendeds, Set<Bargain> bargains, Set<Ordersbook> ordersbooks) {
		this.bookid = bookid;
		this.booktype = booktype;
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPress = bookPress;
		this.bookPicture = bookPicture;
		this.bookAmount = bookAmount;
		this.bookShelveTime = bookShelveTime;
		this.bookPrice = bookPrice;
		this.bookRemark = bookRemark;
		this.bookSales = bookSales;
		this.recommendeds = recommendeds;
		this.bargains = bargains;
		
		this.ordersbooks = ordersbooks;
		
	}

	@Id

	@Column(name = "bookid", unique = true, nullable = false)
	public int getBookid() {
		return this.bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "typeId", nullable = false)
	public Booktype getBooktype() {
		return this.booktype;
	}

	public void setBooktype(Booktype booktype) {
		this.booktype = booktype;
	}

	@Column(name = "bookNumber", nullable = false, length = 17)
	public String getBookNumber() {
		return this.bookNumber;
	}

	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
	}

	@Column(name = "bookName", nullable = false, length = 20)
	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Column(name = "bookAuthor", nullable = false, length = 20)
	public String getBookAuthor() {
		return this.bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	@Column(name = "bookPress", nullable = false, length = 20)
	public String getBookPress() {
		return this.bookPress;
	}

	public void setBookPress(String bookPress) {
		this.bookPress = bookPress;
	}

	@Column(name = "bookPicture", nullable = false, length = 100)
	public String getBookPicture() {
		return this.bookPicture;
	}

	public void setBookPicture(String bookPicture) {
		this.bookPicture = bookPicture;
	}

	@Column(name = "bookAmount", nullable = false)
	public int getBookAmount() {
		return this.bookAmount;
	}

	public void setBookAmount(int bookAmount) {
		this.bookAmount = bookAmount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "bookShelveTime", nullable = false, length = 19)
	public Date getBookShelveTime() {
		return this.bookShelveTime;
	}

	public void setBookShelveTime(Date bookShelveTime) {
		this.bookShelveTime = bookShelveTime;
	}

	@Column(name = "bookPrice", nullable = false, precision = 10)
	public double getBookPrice() {
		return this.bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	@Column(name = "bookRemark", length = 100)
	public String getBookRemark() {
		return this.bookRemark;
	}

	public void setBookRemark(String bookRemark) {
		this.bookRemark = bookRemark;
	}

	@Column(name = "bookSales", nullable = false)
	public int getBookSales() {
		return this.bookSales;
	}

	public void setBookSales(int bookSales) {
		this.bookSales = bookSales;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
	public Set<Recommended> getRecommendeds() {
		return this.recommendeds;
	}

	public void setRecommendeds(Set<Recommended> recommendeds) {
		this.recommendeds = recommendeds;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
	public Set<Bargain> getBargains() {
		return this.bargains;
	}

	public void setBargains(Set<Bargain> bargains) {
		this.bargains = bargains;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
	public Set<Ordersbook> getOrdersbooks() {
		return this.ordersbooks;
	}

	public void setOrdersbooks(Set<Ordersbook> ordersbooks) {
		this.ordersbooks = ordersbooks;
	}

	
}
