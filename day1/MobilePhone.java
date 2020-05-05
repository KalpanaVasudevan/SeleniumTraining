package week1.day1;

public class MobilePhone {
	
	public void makeCall() {
		System.out.println("Open contacts and call to a number");
	}
	public void sendMessage() {
		System.out.println("Open contacts and send message to a number");
	}
	public void takePicture() {
		System.out.println("Open Camera and take a picture");
	}

	public static void main(String[] args) {
		
		MobilePhone myphone = new MobilePhone();
		
		myphone.makeCall();
		myphone.sendMessage();
		myphone.takePicture();
	}
	/*
	 * public static void main(string[] args) { // TODO Auto-generated method stub
	 * 
	 * MobilePhone myphone = new MobilePhone();
	 * 
	 * myphone.makeCall(); myphone.sendMessage(); myphone.takePicture();
	 * 
	 * }
	 */

}
