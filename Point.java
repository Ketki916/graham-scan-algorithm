
public class Point implements Comparable<Point> {
	
	double x;
	double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public int compareTo(Point p2) {
		if ((this.x - GrahamScan.p0.x)*(p2.y - GrahamScan.p0.y) - (this.y - GrahamScan.p0.x)*(p2.x - GrahamScan.p0.y) < 0) {
			return 1;
		}
		else if ((this.x - GrahamScan.p0.x)*(p2.y - GrahamScan.p0.y) - (this.y - GrahamScan.p0.x)*(p2.x - GrahamScan.p0.y) > 0) {
			return -1;
		}
		else if (Math.sqrt(Math.pow(this.x - GrahamScan.p0.x, 2) + Math.pow(this.y - GrahamScan.p0.y, 2)) < Math.sqrt(Math.pow(p2.x - GrahamScan.p0.x, 2) + Math.pow(p2.y - GrahamScan.p0.y, 2))) {
			return -1;
		}
		else if (Math.sqrt(Math.pow(this.x - GrahamScan.p0.x, 2) + Math.pow(this.y - GrahamScan.p0.y, 2)) > Math.sqrt(Math.pow(p2.x - GrahamScan.p0.x, 2) + Math.pow(p2.y - GrahamScan.p0.y, 2))) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public String toString() {
		return this.x + " " + this.y + " ";
	}

}
