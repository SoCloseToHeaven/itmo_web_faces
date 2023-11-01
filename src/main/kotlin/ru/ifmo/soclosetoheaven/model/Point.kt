package ru.ifmo.soclosetoheaven.model

import jakarta.enterprise.context.RequestScoped
import jakarta.faces.event.ValueChangeEvent
import jakarta.inject.Inject
import jakarta.inject.Named
import ru.ifmo.soclosetoheaven.model.managers.AreaManager
import ru.ifmo.soclosetoheaven.model.managers.PointManager
import java.io.Serializable
import java.util.*


@Named
@RequestScoped
class Point(
    var x: Double = 0.0,
    var y: Double = 0.0,
    var r: Double = 1.0,
) : Serializable {

    @Transient
    @Inject
    private lateinit var pointManager: PointManager

    @Transient
    @Inject
    private lateinit var areaManager: AreaManager


    fun process() {
        val startTime = System.nanoTime()
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