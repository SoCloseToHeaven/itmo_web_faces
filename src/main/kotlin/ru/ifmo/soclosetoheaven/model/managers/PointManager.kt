package ru.ifmo.soclosetoheaven.model.managers


import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.context.SessionScoped
import org.hibernate.Session

import ru.ifmo.soclosetoheaven.model.ProcessedPoint
import ru.ifmo.soclosetoheaven.util.HibernateUtils
import ru.ifmo.soclosetoheaven.util.Manager
import java.io.Serializable
import kotlin.collections.ArrayList


@SessionScoped
class PointManager : Manager<ProcessedPoint, Unit>, Serializable {

    private val session: Session = HibernateUtils.getSession()

    private val data = ArrayList<ProcessedPoint>()

    override fun manage(arg: ProcessedPoint) {
        session.transaction.begin()
        session.persist(arg)
        session.transaction.commit()
        data.add(arg)
    }

    @PostConstruct
    fun init() {
        data.addAll(
            session.createQuery("SELECT a FROM POINTS a", ProcessedPoint::class.java).resultList
        )
    }

    @PreDestroy
    fun destroy() {
        session.close()
    }
}