/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.mdl_login_sa;

public class ctl_loginSa extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("logout_sa")) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("index.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String proses = request.getParameter("proses");

        if (proses.equals("LoginSa")) {
            String uname = request.getParameter("uname");
            String pwd = request.getParameter("pwd");

            //String tag=request.getParameter("tag");
            if (pwd == null || pwd.equals("")) {   //validasi apabila field belum diisi
                response.sendRedirect("login_sa.jsp");
            } else {
                mdl_login_sa pm = new mdl_login_sa();
                List<mdl_login_sa> datalogin = new ArrayList<mdl_login_sa>();

                datalogin = pm.LoginSa(uname, pwd);
                if (datalogin.isEmpty()) { //validasi apabila username dan password salah
                    response.sendRedirect("login_sa.jsp");
                } else {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("pwd", datalogin.get(0).getPwd());
                    session.setAttribute("uname", datalogin.get(0).getUname());
                    session.setAttribute("id", datalogin.get(0).getId());

                    if (datalogin.get(0).getPwd().equals(uname)) {
                        response.sendRedirect("tabel_admin.jsp");
                    } else {
                        response.sendRedirect("login_sa.jsp");
                    }
                }
            }
        }

    }
}
