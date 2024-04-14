public class Rectangle extends Shape{
    private Double height;
    private Double width;
    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }
    @Override
    protected double calculatePerimeter() {
        super.setPerimeter(this.height * 2 + this.width * 2);
        return super.getPerimeter();
    }

    @Override
    protected double calculateArea() {
        super.setArea(this.height * this.width);
        return  super.getArea();
    }
}
