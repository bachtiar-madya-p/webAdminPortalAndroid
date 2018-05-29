/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.mdl_user;

public class ctl_login extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action.equals("logout")) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("index.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String proses = request.getParameter("proses");

        if (proses.equals("Login")) {
            String nik = request.getParameter("nik");
            String pwd = request.getParameter("pwd");

            //String tag=request.getParameter("tag");
            if (pwd == null || pwd.equals("")) {   //validasi apabila field belum diisi
                response.sendRedirect("login.jsp");
            } else {
                mdl_user pm = new mdl_user();
                List<mdl_user> datalogin = new ArrayList<mdl_user>();

                datalogin = pm.LoginAdmin(nik, pwd);
                if (datalogin.isEmpty()) { //validasi apabila username dan password salah
                    response.sendRedirect("login.jsp");
                    PrintWriter out = response.getWriter();
                    request.getRequestDispatcher("login.jsp").include(request, response);

                } else if (datalogin.get(0).getTag().equals("Admin") |datalogin.get(0).getTag().equals("admin")) {
                    //if (datalogin.get(0).getPwd().equals(nik)) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("name", datalogin.get(0).getName());
                    session.setAttribute("pwd", datalogin.get(0).getPwd());
                    session.setAttribute("nik", datalogin.get(0).getNik());
                    session.setAttribute("tag", datalogin.get(0).getTag());
                    session.setAttribute("dept", datalogin.get(0).getDept());
                    session.setAttribute("email", datalogin.get(0).getEmail());
                    session.setAttribute("img_user", datalogin.get(0).getImg_user());
                    session.setAttribute("phone", datalogin.get(0).getPhone());
                    session.setAttribute("plant", datalogin.get(0).getPlant());
                    session.setAttribute("reg_date", datalogin.get(0).getReg_date());
                    session.setAttribute("gcm_token",datalogin.get(0).getGcmToken());
                    String name = request.getParameter("name");
                    session.getAttribute(name);
                    response.sendRedirect("index.jsp");
                } else {
                    response.sendRedirect("login.jsp");
                }
            }
        }

    }
}
