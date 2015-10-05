package ThirdProgram;

public class Square implements Shape {
	private int side;
	/**
	 * @param side of square
	 */
	public Square(int side){
		this.side=side;
	}
	public String draw() {
		return "Sqaure is drawn";
	}

	@Override
	public double getArea() {
		double area=side*side;
		return area;
	}

}
