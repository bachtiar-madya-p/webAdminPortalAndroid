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
import model.mdl_absensi;

public class ctl_absensi extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet absensi</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet absensi at " + request.getContextPath() + "</h1>");
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
        if (proses.equals("input-absensi")) {
            response.sendRedirect("insert_absensi.jsp");
            return;
        } else if (proses.equals("edit-absensi")) {
            response.sendRedirect("edit_absen.jsp?id=" + request.getParameter("id"));
            return;
        } else if (proses.equals("view-absensi")) {
            response.sendRedirect("view_absensi.jsp?id=" + request.getParameter("id"));
            return;
        } else if (proses.equals("hapus-absensi")) {

            mdl_absensi hm = new mdl_absensi();
            hm.setId(Integer.parseInt(request.getParameter("id")));
            hm.hapus();
            response.sendRedirect("keluAbsensi.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String data = request.getParameter("data");
        String proses = request.getParameter("proses");
        String xStats = null;

        if (data != null) {
            if (data.equals("absensi")) {
                mdl_absensi um = new mdl_absensi();

                um.setId(Integer.parseInt(request.getParameter("id")));
                
                um.setContent(request.getParameter("content"));
                um.setDate(request.getParameter("date"));
                um.setStatus(request.getParameter("status"));
                um.setNote(request.getParameter("note"));
                // um.setNik(Integer.parseInt(request.getParameter("nik")));

                if (proses.equals("edit-absensi")) {
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
                response.sendRedirect("keluAbsensi.jsp");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
