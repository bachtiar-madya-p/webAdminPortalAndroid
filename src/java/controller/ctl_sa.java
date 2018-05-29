package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.mdl_sa;

public class ctl_sa extends HttpServlet {

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

        if (proses.equals("edit-admin")) {
            response.sendRedirect("edit_tabelAdmin.jsp?nik=" + request.getParameter("nik"));
            return;
        } else if (proses.equals("hapus-admin")) {

            mdl_sa hm = new mdl_sa();
            hm.setNik(Integer.parseInt(request.getParameter("nik")));
            hm.hapus();
            response.sendRedirect("tabel_admin.jsp");
        } else if (proses.equals("hapus-admin")) {

            mdl_sa hm = new mdl_sa();
            hm.setNik(Integer.parseInt(request.getParameter("nik")));
            hm.hapus();
            response.sendRedirect("tabel_admin.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String data = request.getParameter("data");
        String proses = request.getParameter("proses");

        if (data != null) {
            if (data.equals("admin")) {
                mdl_sa um = new mdl_sa();
                um.setNik(Integer.parseInt(request.getParameter("nik")));
                um.setDept(request.getParameter("dept"));
                um.setEmail(request.getParameter("email"));
                um.setImg_user(request.getParameter("img_user"));
                um.setName(request.getParameter("name"));
                um.setPhone(request.getParameter("phone"));
                um.setPlant(request.getParameter("plant"));
                um.setPwd(request.getParameter("pwd"));
                um.setReg_date(request.getParameter("reg_date"));
                um.setTag(request.getParameter("tag"));

                if (proses.equals("input-admin")) {
                    um.simpan();
                } else if (proses.equals("edit-admin")) {

                    um.update();
                } else if (proses.equals("hapus-admin")) {
                    um.hapus();
                }
                response.sendRedirect("tabel_admin.jsp");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
