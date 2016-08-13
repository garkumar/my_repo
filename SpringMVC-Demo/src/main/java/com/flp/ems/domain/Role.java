package com.flp.ems.domain;

import java.util.HashSet;
import java.util.Iterator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role 
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
	private int Role_id;
	@Column(name = "name")
    private String Name;
	@Column(name = "description")
    private String Description;
    static HashSet hs_role=new HashSet();
    public Role()
    {
    	Role r1=new Role(1,"software engineer","software engineer");
    	Role r2=new Role(2,"software analyst","software analyst");
    	Role r3=new Role(3,"software consultant","software consultant");
    	hs_role.add(r1);
    	hs_role.add(r2);
    	hs_role.add(r3);
    }
    public Role(int rollid,String name,String description)
    {
    	setRole_id(rollid);
    	setName(name);
    	setDescription(description);
    }
	public int getRole_id() {
		return Role_id;
	}
	public void setRole_id(int role_id) {
		Role_id = role_id;
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
	public static Role Search_role(int roleid)
	{
		Iterator it=hs_role.iterator();
		Role r=null;
		while(it.hasNext())
		{
			r=(Role)it.next();
			
			if (r.getRole_id()==roleid)
				return r;
		}
		if(r==null)
			System.out.println("dept not found");
		return r;
	}
	
}
