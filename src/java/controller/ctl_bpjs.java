/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.mdl_bpjs;
import model.mdl_user;

/**
 *
 * @author faisal
 */
public class ctl_bpjs extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet cobpjs</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cobpjs at " + request.getContextPath() + "</h1>");
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
        if (proses.equals("input-bpjs")) {
            response.sendRedirect("bpjs.jsp");
            return;
        } else if (proses.equals("view-bpjs")) {
            response.sendRedirect("view_bpjs.jsp?id=" + request.getParameter("id"));
            return;
        } else if (proses.equals("edit-bpjs")) {
            response.sendRedirect("edit_bpjs.jsp?id=" + request.getParameter("id"));
            return;
        } else if (proses.equals("hapus-bpjs")) {

            mdl_bpjs hm = new mdl_bpjs();
            hm.setId(Integer.parseInt(request.getParameter("id")));
            hm.hapus();
            response.sendRedirect("bpjs.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String data = request.getParameter("data");
        String proses = request.getParameter("proses");
        String xStats = null;

        if (data != null) {
            if (data.equals("bpjs")) {
                mdl_bpjs um = new mdl_bpjs();

                um.setId(Integer.parseInt(request.getParameter("id")));

                um.setDate(request.getParameter("date"));
                um.setNokk(request.getParameter("nokk"));
                um.setNoktp(request.getParameter("noktp"));
                um.setDoc(request.getParameter("doc"));
                //um.setNik(Integer.parseInt(request.getParameter("nik")));
                um.setStatus(request.getParameter("status"));
                um.setNote(request.getParameter("note"));
                
                if (proses.equals("edit-bpjs")) {
                    String stats = um.getStatus();
                    xStats = um.getNote();
                    DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy - hh:mm a");
                    Date date = new Date();
                    String created = dateFormat.format(date);
                    if (stats.equals("Menunggu")) {
                        String xyz = created + " <br/> Kiriman anda sedang menunggu proses validasi";
                        um.setNote(xyz);
                        um.update();
                    } else if (stats.equals("Proses")) {
                        String xyz = created + " <br/>  Kiriman anda sedang dalam proses validasi <br/> " + xStats;
                        um.setNote(xyz);
                        um.update();
                    } else if (stats.equals("Gagal")) {
                        String alasan = request.getParameter("alasan");
                        String xyz = created + " <br/> Kiriman tidak dapat diproses, " + alasan
                                + ". Pastikan dokumen lampiran lengkap sesuai dengan syarat dan ketentuan <br/>" + xStats;
                        um.setNote(xyz);
                        um.update();
                    } else if (stats.equals("Selesai")) {
                        String xyz = created + " <br/> Kiriman anda selesai diproses, "
                                + "silahkan tunggu pemberitahuan selanjutnya <br/>" + xStats;
                        um.setNote(xyz);
                        um.update();
                    }
                    // TEKAN KENE
                }
                response.sendRedirect("bpjs.jsp");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
