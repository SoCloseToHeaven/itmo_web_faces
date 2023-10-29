package ru.ifmo.soclosetoheaven.areas

import ru.ifmo.soclosetoheaven.model.Point

class Triangle : Area {



    override fun checkHit(point: Point): Boolean {
        val inFourthQuarter = point.x >= 0 && point.y <= 0
        val inTriangle = point.y >= 2 * point.x - point.r
        return inFourthQuarter && inTriangle
    }
}