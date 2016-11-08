package com.niit.shoppingcart.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity  //it specifies a class as a entity
@Table(name = "Product") //it will create the table with name
@Component  /*@Component annotation marks a java class as a bean 
so the component-scanning mechanism of spring can pick it up and pull it into the application context. 
JavaBeans are classes that encapsulate many objects into a single object (the bean). 
They are serializable, have a zero-argument constructor, and allow access to properties using getter and setter methods*/

public class Product {
	 /*primary key("Primary key enforces the entity integrity of the table.
		Primary key always has unique data.
		A primary key length cannot be exceeded than 900 bytes.
		A primary key cannot have null value.
		There can be no duplicate value for a primary key.
		A table can contain only one primary key constraint.")*/

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id") //which will creates the column name  
	private int id;
	@NotNull
	@Size(min=2,max=30,message="Username Must be more than 2 letters")
	@Column(name="Name",unique=true)
	private String Name;
	@NotNull
	@Size(min=2,max=30)
	@Column(name="Description")
	private String Description;
	@NotNull
	@Size(min=2,max=30)
	@Column(name="primarymaterial")
	private String primarymaterial;
	/*@NotNull
	@Size(min=2,max=30)
	@Column(name="style")
	private String style;*/
	@NotNull
	@Size(min=2,max=30)
	@Column(name="warranty")
	private String warranty;
	/*@NotNull
	@Size(min=2,max=30)
	@Column(name="capacity")
	private String capacity;*/
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="supplier")
	private Supplier supplier;
	private int quantity;
	private double Price;
	@Column(name = "image", columnDefinition = "varchar(255)")
	@Size(min = 3, message = "Please Select the Image")
	private String image;
	@JsonIgnore
	transient private MultipartFile img;
	public Product(int id,String Name,String Description,String primarymaterial,String warranty,Supplier supplier,int supplierid,String suppliername,int quantity,double Price,String image,MultipartFile img) {
	this.id=id;
	this.Name = Name;
	this.Description = Description;
	this.primarymaterial = primarymaterial;
	//this.style = style;	
	this.warranty = warranty;
	//this.capacity = capacity;
	this.supplier = supplier;
	this.quantity = quantity;	
	this.Price = Price;	
	this.image = image;
    this.img = img;	
	}
	 public Product() {
	}
	 
	 /*Getter and setter methods are used to retrieve and manipulate private variables in a different class. 
	 A "getter" method does as it name suggest, retrieves a the attribute of the same name. 
	 A setter method allows you to set the value of the attribute.
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getPrimarymaterial() {
		return primarymaterial;
	}
	public void setPrimarymaterial(String primarymaterial) {
		this.primarymaterial = primarymaterial;
	}
	/*public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}*/
	public String getWarranty() {
		return warranty;
	}
	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}
	/*public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}*/
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public MultipartFile getImg() {
		return img;
	}
	public void setImg(MultipartFile img) {
		this.img = img;
	}
	
}
