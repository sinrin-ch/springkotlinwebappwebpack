package xyz.sinrin.demo.servlet

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

//@WebServlet("/kotlin")
class Hello2Servlet : HttpServlet() {
    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
//        super.doGet(req, resp)
        resp.writer.write("Hello kotlin servlet")
    }
}