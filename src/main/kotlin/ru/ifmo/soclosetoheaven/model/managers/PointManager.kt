package ru.ifmo.soclosetoheaven.model.managers


import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import jakarta.enterprise.context.SessionScoped
import jakarta.inject.Named
import org.hibernate.Session

import ru.ifmo.soclosetoheaven.model.ProcessedPoint
import ru.ifmo.soclosetoheaven.util.HibernateUtils
import ru.ifmo.soclosetoheaven.util.Manager
import java.io.Serializable
import kotlin.collections.ArrayList


@SessionScoped
@Named
class PointManager : Manager<ProcessedPoint, Unit>, Serializable {

    private val session: Session = HibernateUtils.getSession()

    val data = ArrayList<ProcessedPoint>()

    override fun manage(arg: ProcessedPoint) {
        val transaction = session.beginTransaction()
        session.persist(arg)
        transaction.commit()
        data.add(arg)
    }


    fun clear() {
        val transaction = session.beginTransaction()
        session.createQuery("DELETE FROM POINTS").executeUpdate()
        transaction.commit()
        data.clear()
    }

    @PostConstruct
    fun init() {
        try {
            data.addAll(
                session.createQuery("SELECT a FROM POINTS a", ProcessedPoint::class.java).resultList
            )
        } catch (ex: Throwable) {
            ex.printStackTrace()
        }
    }

    @PreDestroy
    fun destroy() {
        session.close()
    }
}