package pojo;

import java.util.Optional;

public class GetUsersResponse {
	private String name;
	private String job;
	SupportPojo supportPojo;
	UserDataPojo userDataPojo;
	
	public GetUsersResponse setName(String name) {
		this.name = name;
		return this;
	}
	public String getName() {
		return name;
	}
	
	public GetUsersResponse setJob(String job) {
		this.job = job;
		return this;
	}
	public String getjob() {
		return job;
	}
	
	public SupportPojo getSupportPojo() {
		return supportPojo;
	}
	
	public void setSupportPojo(SupportPojo supportPojo) {
		this.supportPojo = supportPojo;
	}
	
	public UserDataPojo getUserDataPojo() {
		return userDataPojo;
	}
	
	public void setUserDataPojo(UserDataPojo userDataPojo) {
		this.userDataPojo = userDataPojo;
	}
	


}
