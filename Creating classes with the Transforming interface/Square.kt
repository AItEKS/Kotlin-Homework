class Square(id: Int, var x: Int, var y: Int, var width: Int) : Movable, Transforming, Figure(id) {
    var color: Int = -1
    lateinit var name: String

    constructor(square: Square): this(square.id, square.x,  square.y, square.width)

    override fun resize(zoom: Int) {
        width *= zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        val oldX = x
        val oldY = y

        when (direction) {
            RotateDirection.Clockwise -> {
                // Поворот точки на 90 градусов по часовой стрелке вокруг (centerX, centerY)
                x = centerX + (oldY - centerY)
                y = centerY - (oldX - centerX)
            }
            RotateDirection.CounterClockwise -> {
                // Поворот точки на 90 градусов против часовой стрелки
                x = centerX - (oldY - centerY)
                y = centerY + (oldX - centerX)
            }
        }
    }

    override fun move(dx: Int, dy: Int) {
        x += dx
        y += dy
    }

    override fun area(): Float {
        return (width * width).toFloat()
    }

    override fun getPos(): Point = Point(x, y)

    override fun toString(): String = "Square(id=$id, pos=${getPos()}, side=$width)"
}