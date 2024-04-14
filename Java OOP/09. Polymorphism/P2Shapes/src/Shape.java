public abstract class Shape {
    private Double perimeter;
    private Double area;
    public Double getPerimeter() {
        return perimeter;
    }

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }
    public Double getArea() {
        return area;
    }

    protected void setArea(double area) {
        this.area = area;
    }
    protected abstract double calculatePerimeter();
    protected abstract double calculateArea();
}
