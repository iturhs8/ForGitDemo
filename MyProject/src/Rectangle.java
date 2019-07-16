
public class Rectangle {
	int width;
	int height;
	public Rectangle(int width, int height) {
		this.height=height;
		this.width=width;
	}
	public int computeArea(int height, int radius) {
		int area = height*width;
		return area;
	}
	
	public static void main(String[] args) {
		Rectangle newRec = new Rectangle(10,20);
		System.out.println(newRec.computeArea(10,20));
	}
	

}
