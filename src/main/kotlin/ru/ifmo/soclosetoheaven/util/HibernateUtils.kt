package ru.ifmo.soclosetoheaven.util

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.cfg.Configuration
import ru.ifmo.soclosetoheaven.model.ProcessedPoint

object HibernateUtils {

    private lateinit var sessionFactory: SessionFactory

    init {
        configure()
    }


    private fun configure() {
        try {
            val configuration = Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(ProcessedPoint::class.java)
            sessionFactory = configuration.buildSessionFactory()
        } catch (ex: Throwable) {
            throw ExceptionInInitializerError(ex)
        }
    }


    fun getSession(): Session {
        return sessionFactory.openSession()
    }
}