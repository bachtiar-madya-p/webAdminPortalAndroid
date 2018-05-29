package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.mdl_berita;
import model.mdl_komentar;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.FileLoc;

public class ctl_berita extends HttpServlet {

    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 50 * 1024;
    private int maxMemSize = 4 * 1024;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet berita</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet berita at " + request.getContextPath() + "</h1>");
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

        if (proses.equals("input-berita")) {
            response.sendRedirect("index.jsp");
            return;
        } else if (proses.equals("hapus-berita")) {

            mdl_berita hm = new mdl_berita();
            mdl_komentar dataComm = new mdl_komentar();
            hm.setRoom_id(Integer.parseInt(request.getParameter("room_id")));
            int roomId = Integer.parseInt(request.getParameter("room_id"));
            dataComm.delFeed(roomId);
            hm.hapus();
            response.sendRedirect("index.jsp");
        }
    }
    String tempFile = FileLoc.BASE_FOLDER + "feed/";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String data = request.getParameter("data");
        String proses = request.getParameter("proses");

        String result;
        mdl_berita feedData = new mdl_berita();
        mdl_komentar dataComm = new mdl_komentar();

        String feedContent = "";
        int count1 = 0;

        if (data != null) {
            if (data.equals("berita")) {
                boolean isMultipart = ServletFileUpload.isMultipartContent(request);
                if (!isMultipart) {
                } else {
                    FileItemFactory factory = new DiskFileItemFactory();
                    ServletFileUpload upload = new ServletFileUpload(factory);
                    List items = null;
                    try {
                        items = upload.parseRequest(request);
                    } catch (FileUploadException e) {
                        e.printStackTrace();
                    }
                    Iterator itr = items.iterator();

                    while (itr.hasNext()) {
                        FileItem item = (FileItem) itr.next();
                        if (item.isFormField()) {
                            String name = item.getFieldName();
                            String value = item.getString();
                            if (name.equals("content")) {
                                feedContent = value;
                                count1 = 1;
                            }
                        } else {
                            try {
                                Object nik = request.getSession().getAttribute("nik");
                                String niikk = nik.toString();
                                feedData.setNik(Integer.parseInt(niikk));
                                feedData.setContent(feedContent);
                                String itemName = item.getName();
                                if (item.getName() == "" || item.getName() == null) {
                                    feedData.setImg_content("feed/noImg.png");
                                } else {
                                    feedData.setImg_content("feed/" + itemName);
                                    File fileTemp = new File(tempFile + itemName);
                                    item.write(fileTemp);
                                    String filePath = fileTemp.getAbsolutePath().substring(0, fileTemp.getAbsolutePath().lastIndexOf("\\") + 1);
                                    String fileExt = fileTemp.getName().substring(fileTemp.getName().lastIndexOf('.'));

                                    for (int ix = 0; ix < 7; ix++) {
                                        String newFile = new StringBuffer(String.valueOf("Pic_")).append(ix).toString();
                                        result = new StringBuffer(filePath).append(newFile).append(fileExt).toString();
                                    }
                                }

                                if (proses.equals("input-berita")) {
                                    feedData.simpan();
                                } else if (proses.equals("hapus-berita")) {
                                    int roomId = Integer.parseInt(request.getParameter("room_id"));
                                    dataComm.delFeed(roomId);
                                    feedData.hapus();

                                }
                                response.sendRedirect("index.jsp");

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
