package ru.ifmo.soclosetoheaven.model

import jakarta.persistence.*
import ru.ifmo.soclosetoheaven.model.Point
import java.util.Date
import java.util.UUID


@Entity(name = "POINTS")
@Table(name = "POINTS")
data class ProcessedPoint(
    val x: Double,
    val y: Double,
    val r: Double,
    val hit: Boolean,
    val processingTime: Long,
    val creationDate: Date,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    lateinit var id: UUID
}
