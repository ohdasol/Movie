package moviedto;

import java.util.ArrayList;

public class ActorDTO {

	private String actorName;
	
	private int actorAge;
	
	private int actorHeight;

	
	
	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public int getActorAge() {
		return actorAge;
	}

	public void setActorAge(int actorAge) {
		this.actorAge = actorAge;
	}

	public int getActorHeight() {
		return actorHeight;
	}

	public void setActorHeight(int actorHeight) {
		this.actorHeight = actorHeight;
	}

	public ActorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ActorDTO(String actorName, int actorAge, int actorHeight) {
		super();
		this.actorName = actorName;
		this.actorAge = actorAge;
		this.actorHeight = actorHeight;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" [ ");
		builder.append(actorName);
		builder.append(", ���� : ");
		builder.append(actorAge);
		builder.append(", Ű :");
		builder.append(actorHeight);
		builder.append(" ] ");
		return builder.toString();
	}
	
	


}
