package ThirdProgram;
public class MainClass {
	static void printShape(Shape shape){
		System.out.print(shape.getArea());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape circleShape=new Circle(10);
		Shape squareArea=new Square(5);
		printShape(circleShape);
		System.out.println("\n");
		printShape(squareArea);
	}
}
