class Rect(id: Int, var x: Int, var y: Int,
           var width: Int, var height: Int) : Movable, Transforming, Figure(id) {

    var color: Int = -1
    lateinit var name: String

    constructor(rect: Rect): this(rect.id, rect.x,  rect.y, rect.width, rect.height)

    override fun resize(zoom: Int) {
        width *= zoom
        height *= zoom
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

        val temp = width
        width = height
        height = temp
    }

    override fun move(dx: Int, dy: Int) {
        x += dx
        y += dy
    }

    override fun area(): Float {
        return (width * height).toFloat()
    }

    override fun getPos(): Point = Point(x, y)

    override fun toString(): String = "Rect(id=$id, pos=${getPos()}, size=${width}x$height)"
}