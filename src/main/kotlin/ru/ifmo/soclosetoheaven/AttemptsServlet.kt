package ru.ifmo.soclosetoheaven

import jakarta.inject.Inject
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import ru.ifmo.soclosetoheaven.model.json.JsonParserBean
import ru.ifmo.soclosetoheaven.model.managers.PointManager


@WebServlet(urlPatterns = ["/attempts"])
class AttemptsServlet : HttpServlet() {


    @Inject
    private lateinit var jsonParserBean: JsonParserBean

    @Inject
    private lateinit var pointManager: PointManager

    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
        resp.writer.println(jsonParserBean.stringify(pointManager.data))
        resp.writer.close()
    }
}