<%@page import="model.mdl_user"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.mdl_absensi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <meta charset="utf-8">
        <!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
        <title>INDOCEMENT</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="viewport" content="width=device-width">        
        <link rel="stylesheet" href="css/templatemo_main.css">
        <link href="../bootstrap/css/bootstrap.min_1.css" rel="stylesheet" media="screen">        
        <link href="../css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/templatemo_script.js"></script>

        <script>
            function yesnoCheck(that) {
                if (that.value == "Gagal") {
                    document.getElementById("ifYes").style.display = "block";
                } else {
                    document.getElementById("ifYes").style.display = "none";
                }
            }
        </script>


    </head>
    <body>   
        <%
            Object name = request.getSession().getAttribute("name");
            if ((session.getAttribute("name") == null) || (session.getAttribute("name") == "")) {
                response.sendRedirect("login.jsp");
            }
        %>
        <div id="main-wrapper">
            <div class="navbar navbar-inverse" role="navigation">
                <div class="navbar-header">
                    <div class="logo"><h1>Selamat Datang <% out.print(name); %> </h1></div>
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button> 
                </div>   
            </div>
            <div class="template-page-wrapper">
                <div class="navbar-collapse collapse templatemo-sidebar">
                    <ul class="templatemo-sidebar-menu">
                        <li><a href="index.jsp"><i class="fa fa-home"></i>Index</a></li>
                        <li class="sub">
                            <a href="javascript:;">
                                <i class="fa fa-users"></i> Keluhan <div class="pull-right"><span class="caret"></span></div>
                            </a>
                            <ul class="templatemo-submenu">
                                <li><a href="keluAbsensi.jsp">Keluhan Absensi</a></li>
                                <li><a href="keluhanCuti.jsp">Keluhan Cuti</a></li>
                                <li><a href="keluOver.jsp">Keluhan Overtime</a></li>
                            </ul>
                        </li>
                        <li class="sub">
                            <a href="javascript:;">
                                <i class="fa fa-users"></i> Pendaftaran <div class="pull-right"><span class="caret"></span></div>
                            </a>
                            <ul class="templatemo-submenu">
                                <li><a href="bpjs.jsp">Pendaftaran BPJS</a></li>
                                <li><a href="beasiswa.jsp">Pendaftaran Beasiswa</a></li>
                            </ul>
                        </li>
                        <li class="sub">
                            <a href="javascript:;">
                                <i class="fa fa-users"></i> Pengajuan <div class="pull-right"><span class="caret"></span></div>
                            </a>
                            <ul class="templatemo-submenu">
                                <li><a href="ubahIdCard.jsp">Perubahan Id Card</a></li>
                                <li><a href="SuKeterangan.jsp">Pengajuan Surat Keterangan</a></li>
                            </ul>
                        </li>
                        <li class="sub">
                            <a href="javascript:;">
                                <i class="fa fa-users"></i> Data Karyawan <div class="pull-right"><span class="caret"></span></div>
                            </a>
                            <ul class="templatemo-submenu">
                                <li><a href="User.jsp">Tabel Karyawan</a></li>
                                <li><a href="insert_user.jsp">Tambah Karyawan</a></li>
                            </ul>
                        </li>
                        <li class="sub">
                            <a href="javascript:;">
                                <i class="fa fa-users"></i> Feedback<div class="pull-right"><span class="caret"></span></div>
                            </a>
                            <ul class="templatemo-submenu">
                                <li><a href="feedback.jsp">Feedback</a></li>
                            </ul>
                        </li>
                        <li><a href="javascript:;" data-toggle="modal" data-target="#confirmModal"><i class="fa fa-sign-out"></i>Log Out</a></li>
                    </ul>
                </div><!--/.navbar-collapse -->
                <div class="templatemo-content-wrapper">
                    <div class="templatemo-content">
                        <div class="row">
                            <div class="col-md-12">
                                <%
                                    String id = request.getParameter("id");
                                    if (id != null) {
                                        int idInt = Integer.parseInt(id.trim());
                                        mdl_absensi km = new mdl_absensi();
                                        km.setId(idInt);
                                        List<mdl_absensi> data = new ArrayList<mdl_absensi>();
                                        data = km.cariID();
                                        mdl_user user = new mdl_user();
                                        List<mdl_user> dataUser = new ArrayList<mdl_user>();
                                        dataUser = user.showUser(data.get(0).getNik());
                                %>
                                <div class="table-responsive">
                                    <h1>Detail :  <%=dataUser.get(0).getName()%> / <%=data.get(0).getNik()%></h1>

                                    <form role="form" id="templatemo-preferences-form" action="absensi?data=absensi&proses=edit-absensi" method="post">
                                        <div class="row">
                                            <div class="col-md-10 margin-bottom-1">    
                                                <table>
                                                    <tr>
                                                        <td>
                                                            <table>
                                                                <label>Keluhan Absensi,tanggal <%=data.get(0).getDate()%></label>
                                                                <tr>
                                                                    <td><p class="form-control-static"><label>Keluhan/label></p></td>
                                                                    <td>&emsp; : &emsp;</td>
                                                                    <td><%=data.get(0).getContent()%></td>
                                                                </tr>                                                                    
                                                                <tr>
                                                                    <td><p class="form-control-static"><label>Tanggal</label></p></td>
                                                                    <td>&emsp; : &emsp;</td>
                                                                    <td><%=data.get(0).getDate()%></td>
                                                                </tr>
                                                                <tr>
                                                                    <td><p class="form-control-static"><label>NIK</label></p></td>
                                                                    <td>&emsp; : &emsp;</td>
                                                                    <td><%=data.get(0).getNik()%></td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                        <td>&emsp; &emsp;&emsp; &emsp;&emsp;&emsp; &emsp;</td>
                                                        <td><p class="form-control-static"><label>Note</label></p></td>
                                                        <td>&emsp; : &emsp;</td>
                                                        <td><%=data.get(0).getNote()%><input type="hidden"  name="note" value="<%=data.get(0).getNote()%>"></td>
                                                    </tr>
                                                </table>
                                                <div class="row">
                                                    <div class="col-md-3 margin-bottom-15">
                                                        <label for="singleSelect">Status</label>
                                                        <select onchange="yesnoCheck(this);" class="form-control margin-bottom-15" id="singleSelect" type="text" name="status" value="<%=data.get(0).getStatus()%>">
                                                            <option><%=data.get(0).getStatus()%></option>
                                                            <option disabled="true">---- Proses ----</option>
                                                            <option value="Menunggu">Menunggu</option>
                                                            <option value="Proses">Proses</option>
                                                            <option disabled="true">---- konfirmasi ----</option>
                                                            <option value="Gagal" id="6">Gagal</option>
                                                            <option value="Selesai">Selesai</option>
                                                        </select>
                                                        <div id="ifYes" style="display: none;">
                                                            <label> Alasan Gagal </label> 
                                                            <textarea type="text" class="form-control" name="alasan" style="width: 200px; height: 100px;"  resize="none"placeholder="Tulis alasan .."></textarea>                                                            
                                                            <br />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-3 margin-bottom-15">
                                                        <input type="hidden"  name="id" value="<%=data.get(0).getId()%>">

                                                    </div>
                                                </div>  
                                                <div class="row templatemo-form-buttons">
                                                    <div class="col-md-12">
                                                        <input type="submit" value="Update" class="btn btn-primary">
                                                    </div>
                                                </div>                                                
                                            </div>
                                        </div>
                                    </form>
                                </div><%}%>                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">Apakah anda yakin untuk keluar?</h4>
                </div>
                <div class="modal-footer">
                    <a href="logout.jsp" class="btn btn-primary">Iya</a>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Tidak</button>
                </div>
            </div>
        </div>
    </div>
    <footer class="templatemo-footer">
        <div class="templatemo-copyright">
            <p>Copyright &copy; 2018 PT Indocement Prakarsa Tunggal Tbk.</p>
        </div>
    </footer>

</body>
</html>
