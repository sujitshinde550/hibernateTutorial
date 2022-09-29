package manytomanymaping;

import java.util.List;

import javax.persistence.*;
@Entity
public class employee {

	@Id
	private int eId;
	//@Column(name = "employee_name")
	private String employeeName;
	
	@ManyToMany
	@JoinTable(name = "emp_joinpro", 
	joinColumns = { @JoinColumn(name = "eid") },
	inverseJoinColumns = {@JoinColumn(referencedColumnName = "pid")}
	)
	private List<Project> projects;

	public employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public employee(int eId, String employeeName, List<Project> project, List<Project> projects) {
		super();
		this.eId = eId;
		this.employeeName = employeeName;
		this.projects = projects;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public List<Project> getProject() {
		return projects;
	}

	public void setProject(List<Project> project) {
		this.projects = project;
	}
	
	
}
