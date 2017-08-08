package version1;

public class CourseStudied {
	private String name;
	private String major;
	private String description;
	
	public CourseStudied()
	{
		name = null;
		major=null;
		description=null;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
