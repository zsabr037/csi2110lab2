public class Ticket {
	private int id;
	private String requester;
	private String description;
	private int priority;
	
	// static ticket counter increments with every ticket created, so each ticket has unique ID
	private static int ticketCounter = 0;
	
	// constructors, getters, setters, and toString
	
	public Ticket(String requester, String description, int priority){
			this.requester = requester;
			this.description = description;
			this.priority = priority;
			// ticket id based on ticket count, starting at 0. No setter for ID, cannot be changed.
			this.id = ticketCounter;
			ticketCounter++;
	}
	
	public int getId(){
		return id;
	}
	
	public int getPriority(){
		return priority;
	}
	
	public void setPriority(int newPri){
		priority = newPri;
	}
	
	public String getRequester(){
		return requester;
	}
	
	public void setRequester(String newReq){
		requester = newReq;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String newDesc){
		description = newDesc;
	}
	
	public String toString(){
		return "Ticket ID: " + id + "\nRequester: " + requester + "\nDescription: "
		+ description + "\nPriority: " + priority;
	}
}