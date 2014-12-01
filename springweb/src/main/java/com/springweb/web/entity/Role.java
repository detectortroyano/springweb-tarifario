package com.springweb.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import java.util.Set;

import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROLES")
public class Role implements java.io.Serializable{
	
		private static final long serialVersionUID = 1L;
	
	 	@Id
	    @GeneratedValue
	 	@Column(name="ID", unique=true, nullable=false, precision=22, scale=0)
	    private Integer id;
	     
	    @Column(name="DESCRIPTION")
	    private String description;
	    
	    @OneToMany(cascade=CascadeType.ALL)  
	    @JoinTable(name="USERROLES",   
	        joinColumns = {@JoinColumn(name="IDROLE", referencedColumnName="ID")},  
	        inverseJoinColumns = {@JoinColumn(name="IDUSER", referencedColumnName="ID")}  
	    )
	    private Set<User> userRoles;
	    
	    public Integer getId() {
	        return id;
	    }
	    public void setId(Integer id) {
	        this.id = id;
	    }
	    
	    public String getDescription() {
	        return description;
	    }
	    
	    public void setDescription(String description) {
	        this.description = description;
	    }
	    
	   public Set<User> getUserRoles(){
		   return userRoles;
	   }
	   
	   public void setUserRoles(Set<User> userRoles){
		   this.userRoles=userRoles;
	   }
}