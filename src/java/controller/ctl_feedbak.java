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
import model.mdl_feedbak;

 
public class ctl_feedbak extends HttpServlet {

     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet feed</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet feed at " + request.getContextPath() + "</h1>");
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
        if (proses.equals("input-feed")) {
            response.sendRedirect("insert_feedback.jsp");
            return;
        } 
        else if (proses.equals("edit-feed")) {
            response.sendRedirect("edit_feedback.jsp?id=" + request.getParameter("id"));
            return;
        } else if (proses.equals("hapus-feed")) {

            mdl_feedbak hm = new mdl_feedbak();
            hm.setId(Integer.parseInt(request.getParameter("id")));
            hm.hapus();
            response.sendRedirect("feedback.jsp");
        }
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String data = request.getParameter("data");
        String proses = request.getParameter("proses");

        if (data != null) {
            if (data.equals("feed")) {
                mdl_feedbak um = new mdl_feedbak();

                //um.setId(Integer.parseInt(request.getParameter("id")));
                um.setContent(request.getParameter("content"));
                um.setPosdate(request.getParameter("posdate"));
                um.setNik(Integer.parseInt(request.getParameter("nik")));

                if (proses.equals("input-feed")) {
                    um.simpan();
                } 
                
                else if (proses.equals("edit-feed")) {
                    um.update();
                } else if (proses.equals("hapus-feed")) {
                    um.hapus();
                }
                response.sendRedirect("feedback.jsp");
            }
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
