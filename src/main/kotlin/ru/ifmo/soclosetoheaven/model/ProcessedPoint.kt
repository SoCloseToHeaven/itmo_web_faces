package ru.ifmo.soclosetoheaven.model

import jakarta.persistence.*
import java.io.Serializable
import java.util.Date


@Entity(name = "POINTS")
data class ProcessedPoint(
    val x: Double,
    val y: Double,
    val r: Double,
    val hit: Boolean,
    val processingTime: Long,
    val creationDate: Date,
) : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}
