package ru.ifmo.soclosetoheaven.model

import jakarta.enterprise.context.RequestScoped
import jakarta.inject.Inject
import ru.ifmo.soclosetoheaven.model.managers.AreaManager
import ru.ifmo.soclosetoheaven.model.managers.PointManager
import java.util.*


@RequestScoped
class Point(
    var x: Double = 0.0,
    var y: Double = 0.0,
    var r: Double = 0.0,
) {


    @Inject
    private lateinit var pointManager: PointManager

    @Inject
    private lateinit var areaManager: AreaManager

    fun process() {
        val startTime = System.nanoTime();

        val processedPoint = ProcessedPoint(
            x,
            y,
            r,
            areaManager.manage(this),
            System.nanoTime() - startTime,
            Date()
        )

        pointManager.manage(processedPoint)
    }
}
