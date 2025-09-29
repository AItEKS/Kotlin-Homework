fun main() {
    val figures: List<Figure> = listOf(
        Rect(id = 1, x = 10, y = 20, width = 8, height = 4),
        Circle(id = 2, x = -10, y = -5, r = 5),
        Square(id = 3, x = 0, y = 0, width = 6)
    )

    for (figure in figures) {
        println("\n--- ${figure.javaClass.simpleName} (id=${figure.id}) ---")
        println("Начальное состояние: $figure")
        println("Площадь: ${figure.area()}")

        if (figure is Movable) {
            println("Начальная позиция: ${figure.getPos()}")
            figure.move(10, 5)
            println("Позиция после перемещения: ${figure.getPos()}")
        }

        if (figure is Transforming) {
            figure.resize(2)
            println("Состояние после масштабирования: $figure")
            figure.rotate(RotateDirection.Clockwise, 0, 0)
            println("Состояние после вращения: $figure")
        }
    }
}