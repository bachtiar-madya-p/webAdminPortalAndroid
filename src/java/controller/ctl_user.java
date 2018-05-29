package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.mdl_user;

public class ctl_user extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet user_Controller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet user_Controller at " + request.getContextPath() + "</h1>");
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

        if (proses.equals("input-user")) {
            response.sendRedirect("insert_user.jsp");
            return;
        } 
        else if (proses.equals("edit-user")) {
            response.sendRedirect("edit_user.jsp?nik=" + request.getParameter("nik"));
            return;
        }
         else if (proses.equals("cari-user")) {
            response.sendRedirect("cari_user.jsp?nik=" + request.getParameter("nik"));
            return;
        }
        else if (proses.equals("hapus-user")) {

            mdl_user hm = new mdl_user();
            hm.setNik(Integer.parseInt(request.getParameter("nik")));
            hm.hapus();
            response.sendRedirect("User.jsp");
        }
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String data = request.getParameter("data");
        String proses = request.getParameter("proses");

        if (data != null) {
            if (data.equals("user")) {
                mdl_user um = new mdl_user();
                um.setNik(Integer.parseInt(request.getParameter("nik")));
                um.setDept(request.getParameter("dept"));
                um.setEmail(request.getParameter("email"));
                um.setImg_user(request.getParameter("img_user"));
                um.setName(request.getParameter("name"));
                um.setPhone(request.getParameter("phone"));
                um.setPlant(request.getParameter("plant"));
                um.setPwd(request.getParameter("pwd"));
                um.setReg_date(request.getParameter("reg_date"));
                um.setGcmToken(request.getParameter("gcm_token"));
                um.setTag(request.getParameter("tag"));

                if (proses.equals("input-user")) {
                    um.simpan();
                } 
                else if (proses.equals("edit-user")) {

                        um.update();
                    
                } 
                else if (proses.equals("cari-user")) {
                    um.cariNik();
                } 
                else if (proses.equals("hapus-user")) {
                    um.hapus();
                }
                response.sendRedirect("User.jsp");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
