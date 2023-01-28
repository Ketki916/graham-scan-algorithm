import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GrahamScan {
	
	static Point p0;

	public static void main(String[] args) {
		ArrayList<Point> points = new ArrayList<Point>();
		
		Scanner inputobj = new Scanner(System.in);
		System.out.println("java MyGS ");
		
		String input = inputobj.nextLine();
		
		int minpoint = -1;
		
		double ymin = 0;
		double xmin = 0;
		for (int i = 0; i < input.length(); i = i + 4) {
			Point newPoint;
			double x = 0;
			double y = 0;
			String sx = "";
			String sy = "";
			if ((input.substring(i,i+1)).equals("-")) {
				i++;
				sx += "-";
			}
			if ((input.substring(i,i+3)).contains(".")) {
				x = Double.parseDouble(sx + input.substring(i,i+3));
				i = i+2;
			}
			if ((input.substring(i+2, i+3)).equals("-")) {
				i++;
				sy += "-";
			}
			if (i+5 < input.length() && (input.substring(i+2, i+5)).contains(".")) {
				y = Double.parseDouble(sy + input.substring(i+2, i+5));
				i = i+2;
			}
			if (x == 0 && y == 0) {
				newPoint = new Point(Double.parseDouble(sx + input.substring(i,i+1)), Double.parseDouble(sy + input.substring(i+2,i+3)));
			}
			else {
				if (x == 0 && y != 0) {
					newPoint = new Point(Double.parseDouble(sx + input.substring(i,i+1)), y);
				}
				else if (x != 0 && y == 0) {
					newPoint = new Point(x, Double.parseDouble(sy + input.substring(i+2,i+3)));
				}
				else {
					newPoint = new Point(x, y);
				}
			}
			if (minpoint == -1) {
				ymin = newPoint.y;
				xmin = newPoint.x;
				minpoint = points.size();
			}
			else {
				if (newPoint.y < ymin) {
					ymin = newPoint.y;
					minpoint = points.size();
				}
				else if (newPoint.y == ymin) {
					if (newPoint.x < xmin) {
						xmin = newPoint.x;
						minpoint = points.size();
					}
				}
			}
			points.add(newPoint);
		}
		
		
		p0 = points.get(minpoint);
		
		Collections.sort(points);
		
		
		
		for (int i = 0; i < points.size() - 1; i++) { 
			Point p1;
			Point p2;
			Point p3;
			if (i == points.size() - 2) {
				p1 = points.get(i);
				p2 = points.get(i+1);
				p3 = points.get(0);
			}
			else {
				p1 = points.get(i);
				p2 = points.get(i+1);
				p3 = points.get(i+2);
			}
			
			double crossproduct = (p2.x - p1.x)*(p3.y - p1.y) - (p2.y - p1.y)*(p3.x - p1.x);
			
			while (Math.round(crossproduct) <= 0) {
				points.remove(p2);
				if (i == points.size() - 2) {
					break;	
				}
				p2 = points.get(i+1);
				p3 = points.get(i+2);
				crossproduct = (p2.x - p1.x)*(p3.y - p1.y) - (p2.y - p1.y)*(p3.x - p1.x);
			}
			
		}
		
		for (int i = 0; i < points.size(); i++) {
			System.out.print(points.get(i));
		}
		


	}

}
