/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.mdl_komentar;

public class ctl_komentar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet komentar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet komentar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String proses = request.getParameter("proses");
        String action = request.getParameter("action");
        if (proses.equals("input-komentar")) {
            response.sendRedirect("index.jsp");
            return;
        } else if (proses.equals("edit-komentar")) {
            response.sendRedirect("edit_coment.jsp?id=" + request.getParameter("id"));
            return;
        } else if (proses.equals("hapus-komentar")) {

            mdl_komentar hm = new mdl_komentar();
            hm.setId(Integer.parseInt(request.getParameter("id")));
            hm.hapus();
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String data = request.getParameter("data");
        String proses = request.getParameter("proses");

        if (data != null) {
            if (data.equals("komentar")) {
                mdl_komentar um = new mdl_komentar();

                //um.setId(Integer.parseInt(request.getParameter("id")));
                um.setCmtcontent(request.getParameter("cmtcontent"));
                um.setCmtposdate(request.getParameter("cmtposdate"));
                um.setRoom_id(Integer.parseInt(request.getParameter("room_id")));
                
                Object nik = request.getSession().getAttribute("nik");
                String niikk = nik.toString();
                um.setNik(Integer.parseInt(niikk));

                if (proses.equals("input-komentar")) {
                    um.postCom(Integer.parseInt(request.getParameter("room_id")));
                } else if (proses.equals("edit-komentar")) {
                    um.setId(Integer.parseInt(request.getParameter("id")));
                    um.update();
                } else if (proses.equals("hapus-komentar")) {
                    um.hapus();
                }
                response.sendRedirect("index.jsp");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
