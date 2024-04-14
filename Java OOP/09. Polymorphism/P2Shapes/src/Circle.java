public class Circle extends Shape{
    private Double radius;
    public Circle(Double radius) {
        this.radius = radius;
    }
    public final Double getRadius() {
        return radius;
    }

    private void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    protected double calculatePerimeter() {
        super.setPerimeter(2 * Math.PI * this.radius);
        return super.getPerimeter();
    }

    @Override
    protected double calculateArea() {
        super.setArea(Math.PI * (this.radius * this.radius));
        return super.getArea();
    }
}
