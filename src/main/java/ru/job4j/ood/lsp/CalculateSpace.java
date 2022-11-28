package ru.job4j.ood.lsp;

public class CalculateSpace {
    public static int calculate(Rectangle rectangle) {
        return rectangle.getHeight() * rectangle.getHeight();
    }

    public static void main(String[] args) {
        Square square = new Square(14, 15);
        Rectangle rectangle = new Rectangle(12, 15);
        System.out.println(calculate(square));
    }
}
