package com.xwtech.model.user;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysRole  {
	/**   
	 *   
	 */   
	private static final long serialVersionUID = -6390500944399513554L;

	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 
	 */
	private String roleName;
	
	/**
	 * 
	 */
	private String description;
	
	/**
	 * 拥有的资源
	 */
	private List<SysResource> resourceList;
	
	/**
	 * 
	 */
	private String available;
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId () {
		return id;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public String getRoleName () {
		return roleName;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription () {
		return description;
	}
	
	public List<SysResource> getResourceList() {
        if(resourceList == null) {
        	resourceList = new ArrayList<SysResource>();
        }
        return resourceList;
    }

    public void setResourceList(List<SysResource> resourceList) {
        this.resourceList = resourceList;
    }
    
	public void setAvailable(String available) {
		this.available = available;
	}
	
	public String getAvailable () {
		return available;
	}
	
}