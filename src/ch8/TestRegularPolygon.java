public class TestRegularPolygon {
	public static void main(String[] args) {
		System.out.println("Regular Polygon Test");
		System.out.println("Creating default Regular Polygon");
		
		System.out.print("#1 - ");
		displayPoly(new RegularPolygon());

		System.out.print("#2 - ");
		displayPoly(new RegularPolygon(6, 4));

		System.out.print("#3 - ");
		displayPoly(new RegularPolygon(10, 4, 5.6, 7.8));
	}

	public static void displayPoly(RegularPolygon poly) {
		System.out.println("Polygon Summary:");
		System.out.println("Sides:\t\t" + poly.getTotalSides());
		System.out.println("Side Length:\t" + poly.getSideLength());
		System.out.println("Position:\t(" + poly.getX() + "," + 
							poly.getY() + ")");
		System.out.println("Perimeter:\t" + poly.getPerimeter());
		System.out.println("Area:\t\t" + poly.getArea());
	}
}

class RegularPolygon {
	private int totalSides = 3;
	private int sideLength = 1;
	private double xCoordinate = 0.0;
	private double yCoordinate = 0.0;

	public RegularPolygon() {
	}

	public RegularPolygon(int sides, int length) {
		totalSides = sides;
		sideLength = length;
	}

	public RegularPolygon(int sides, int length, double xInput, double yInput) {
		totalSides = sides;
		sideLength = length;
		xCoordinate = xInput;
		yCoordinate = yInput;
	}

	public int getTotalSides() {
		return totalSides;
	}

	public void setTotalSides(int sides) {
		if (sides >= 3) {
			totalSides = sides;
		} else {
			totalSides = 3;
		}
	}

	public int getSideLength() {
		return sideLength;
	}

	public void setSideLength(int length) {
		if (length > 0) {
			sideLength = length;
		} else {
			sideLength = 1;
		}
	}

	public double getX() {
		return xCoordinate;
	}

	public void setX(double x) {
		xCoordinate = x;
	}

	public double getY() {
		return yCoordinate;
	}

	public void setY(double y) {
		yCoordinate = y;
	}

	public int getPerimeter() {
		return totalSides *  sideLength;
	}

	public double getArea() {
		double area = totalSides * sideLength * sideLength;
		area /= 4.0 * Math.tan( Math.PI / totalSides );
		return area;
	}

}