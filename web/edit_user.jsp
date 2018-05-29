<%@page import="model.mdl_user"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
        <link href="./bootstrap/css/bootstrap.min_1.css" rel="stylesheet" media="screen">
        <link href="../css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
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
                    <div class="logo"><h1>Selamat Datang di Web Admin</h1></div>
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
                        <li>
                            <form class="navbar-form">
                                <h5>Selamat Datang: <% out.print(name); %></h5>
                            </form>
                        </li>
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
                                <div class="table-responsive">
                                    <table class="table table-striped table-hover table-bordered">
                                        <h1>Update Data Karyawan</h1>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <form role="form" id="templatemo-preferences-form" action="user_Controller?data=user&proses=edit-user" method="post">

                                                    <%
                                                        String nik = request.getParameter("nik");
                                                        if (nik != null) {
                                                            int nikInt = Integer.parseInt(nik.trim());
                                                            mdl_user km = new mdl_user();
                                                            km.setNik(nikInt);
                                                            List<mdl_user> data = new ArrayList<mdl_user>();
                                                            data = km.cariNik();
                                                    %>
                                                    <div class="row">
                                                        <div class="col-md-3 margin-bottom-15">
                                                            <label for="notes">Departemen</label>

                                                            <select class="form-control margin-bottom-15" id="singleSelect" type="text" name="dept" value="<%=data.get(0).getDept()%>">
                                                                <option><%=data.get(0).getDept()%></option>
                                                                <option disabled="true">---- Pilih ----</option>
                                                                <option>D 1</option>
                                                                <option>D 2</option>
                                                                <option>D 3</option>
                                                                <option>D 4</option>
                                                                <option>D 5</option>
                                                                <option>D 6</option>
                                                                <option>D 7</option>
                                                                <option>D 8</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-3 margin-bottom-15">
                                                            <label  for="notes">Email</label>
                                                            <input  class="form-control" type="text" name="email" value="<%=data.get(0).getEmail()%>">
                                                        </div>
                                                    </div>

                                                    <div class="row">
                                                        <div class="col-md-3 margin-bottom-15">
                                                            <label for="notes">Nama</label>
                                                            <input  class="form-control" type="text" name="name" value="<%=data.get(0).getName()%>">
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-3 margin-bottom-15">
                                                            <label for="notes">nomer HP</label>
                                                            <input  class="form-control" rows="3"  type="text" name="phone" value="<%=data.get(0).getPhone()%>">
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-3 margin-bottom-15">
                                                            <label for="notes">Plant</label>
                                                            <select class="form-control margin-bottom-15" id="singleSelect" type="text" name="plant" value="<%=data.get(0).getPlant()%>">
                                                                <option><%=data.get(0).getPlant()%></option>
                                                                <option disabled="true">---- Pilih ----</option>
                                                                <option>P 1</option>
                                                                <option>P 2</option>
                                                                <option>P 3</option>
                                                                <option>P 4</option>
                                                                <option>P 5</option>
                                                                <option>P 6</option>
                                                                <option>P 7</option>
                                                                <option>P 8</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-3 margin-bottom-15">
                                                            <label for="notes">Password</label>
                                                            <input  class="form-control" type="text"  name="pwd" value="<%=data.get(0).getPwd()%>">
                                                        </div>
                                                    </div>

                                                    <div class="row">
                                                        <div class="col-md-3 margin-bottom-15">
                                                            <label for="singleSelect">Tag</label>
                                                            <select class="form-control margin-bottom-15" id="singleSelect" type="text" name="tag" value="<%=data.get(0).getTag()%>">
                                                                <option><%=data.get(0).getTag()%></option>
                                                                <option disabled="true">---- Pilih ----</option>
                                                                <option value="user">accept</option>
                                                                <option>waiting</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-3 margin-bottom-15">
                                                            <input type="hidden"  name="nik" value="<%=data.get(0).getNik()%>">
                                                        </div>
                                                    </div>  
                                                    <div class="row templatemo-form-buttons">
                                                        <div class="col-md-12">
                                                            <input type="submit" value="Update" class="btn btn-primary">
                                                        </div>
                                                    </div>
                                            </div>
                                        </div>     
                                        <%}%>
                                </div> 
                                </table>
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
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer class="templatemo-footer">
        <div class="templatemo-copyright">
            <p>Copyright &copy; 2018 PT Indocement Prakarsa Tunggal Tbk.</p>
        </div>
    </footer>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/templatemo_script.js"></script>
</body>
<table id="excelDataTable" border="1"> </table>
</div>
</div>
</div>
</div>
</body>
</html>
