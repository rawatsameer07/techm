package pojo;

import java.util.Optional;

public class CreateUsersResponse {
	private String name;
	private String job;
	private String id;
	private String createdAt;
	
//	public CreateUsers(String name, String job) {
//		this.name = name;
//		
//	}
	
	public CreateUsersResponse setName(String name) {
		this.name = name;
		return this;
	}
	public String getName() {
		return name;
	}
	
	public CreateUsersResponse setJob(String job) {
		this.job = job;
		return this;
	}
	public String getjob() {
		return job;
	}
	public String getId() {
		return id;
	}
	
	public String getCreatedAt() {
		return createdAt;
	}
	
	public static Optional<String> getValue(CreateUsersResponse createUsers, String parameter) {
		if(parameter.equalsIgnoreCase("name"))
			return Optional.of(createUsers.getName());
		if(parameter.equalsIgnoreCase("id"))
			return Optional.of(createUsers.getId());
		if(parameter.equalsIgnoreCase("job"))
			return Optional.of(createUsers.getjob());
		if(parameter.equalsIgnoreCase("createdAt"))
			return Optional.of(createUsers.getCreatedAt());
		else
			return Optional.empty();
		
	}

}
