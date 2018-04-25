package com.xwtech.model.user;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysResource  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4252911211048822529L;

	/**
	 * 
	 */
	private Integer id;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private ResourceType type = ResourceType.menu; //资源类型

	/**
	 * 
	 */
	private String url;

	/**
	 * 
	 */
	private Integer parentId;

	/**
	 * 
	 */
	private String parentIds;

	/**
	 * 
	 */
	private String permission;
	
	/**   
	 * 图标路径  
	 */   
	private String iconCls;
	
	/**
	 * 显示顺序
	 */
	private Integer displayOrder;

    /**
     *
     * 是否有权限访问标志
     */
    private boolean useFlag = false;

	/**
	 * 
	 */
	private Boolean available = Boolean.FALSE;

	public static enum ResourceType {
		menu("菜单"), button("按钮");

		private final String info;

		private ResourceType(String info) {
			this.info = info;
		}

		public String getInfo() {
			return info;
		}
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public String getParentIds() {
		return parentIds==null?"":parentIds;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}

	public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public boolean isRootNode() {
        return parentId == 0;
    }

    public String makeSelfAsParentIds() {
        return getParentIds() + getId() + "/";
    }

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

    public boolean isUseFlag() {
        return useFlag;
    }

    public void setUseFlag(boolean useFlag) {
        this.useFlag = useFlag;
    }

    @Override
    public String toString() {
        return "SysResource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", url='" + url + '\'' +
                ", parentId=" + parentId +
                ", parentIds='" + parentIds + '\'' +
                ", permission='" + permission + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", displayOrder=" + displayOrder +
                ", useFlag=" + useFlag +
                ", available=" + available +
                '}';
    }
}