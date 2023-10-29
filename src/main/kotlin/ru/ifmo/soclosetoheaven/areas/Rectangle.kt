package ru.ifmo.soclosetoheaven.areas

import ru.ifmo.soclosetoheaven.model.Point

class Rectangle : Area {

    companion object {
        private const val Y_DIVISION = 2
    }

    override fun checkHit(point: Point): Boolean {
        val inSecondQuarter = point.x <= 0 && point.y >= 0
        val inRectangle = point.x >= -point.r && point.y <= point.r / Y_DIVISION
        return inSecondQuarter && inRectangle
    }
}