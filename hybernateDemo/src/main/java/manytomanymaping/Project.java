package manytomanymaping;


import java.util.List;

import javax.persistence.*;
@Entity
public class Project {

	@Id
	private int pId;
	@Column(name = "project_name")
	private String projectName;
	
	@ManyToMany(mappedBy = "projects")
	private List<employee> employees;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int pId, String projectName, List<employee> emps) {
		super();
		this.pId = pId;
		this.projectName = projectName;
		this.employees = employees;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<employee> getEmps() {
		return employees;
	}

	public void setEmps(List<employee> employees) {
		this.employees = employees;
	}
	
}
