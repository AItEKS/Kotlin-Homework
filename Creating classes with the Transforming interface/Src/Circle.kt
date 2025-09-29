class Circle(id: Int, var x: Int, var y: Int, var r: Int) : Movable, Transforming, Figure(id) {
    val pi: Double = 3.1415926
    var color: Int = -1
    lateinit var name: String

    constructor(circle: Circle): this(circle.id, circle.x,  circle.y, circle.r)

    override fun resize(zoom: Int) {
        r *= zoom
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
        return (pi * r * r).toFloat()
    }

    override fun getPos(): Point = Point(x, y)

    override fun toString(): String = "Circle(id=$id, pos=${getPos()}, radius=$r)"
}
