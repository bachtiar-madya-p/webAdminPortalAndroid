<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
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
        <script>
            function isNumberKey(evt) {
                var charCode = (evt.which) ? evt.which : event.keyCode;
                if (charCode != 46 && charCode > 31 &&
                        (charCode < 48 || charCode > 57)) {
                    alert("Enter Number");
                    return false;
                }
                return true;
            }

        </script>
    </head>
    <%
        Object name = request.getSession().getAttribute("name");
        if ((session.getAttribute("name") == null) || (session.getAttribute("name") == "")) {
            response.sendRedirect("login.jsp");
        }
    %>
    <body>
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
                                <input type="text" class="form-control" id="templatemo_search_box" placeholder="Search...">
                                <span class="btn btn-default">Go</span>
                            </form>
                        </li>
                        <li><a href="index.html"><i class="fa fa-home"></i>Index</a></li>
                        <li class="sub">
                            <a href="javascript:;">
                                <i class="fa fa-users"></i> Keluhan <div class="pull-right"><span class="caret"></span></div>
                            </a>
                            <ul class="templatemo-submenu">
                                <li><a href="kelAbsensi.html">Keluhan Absensi</a></li>
                                <li><a href="kelCuti.html">Keluhan Cuti</a></li>
                                <li><a href="kelOvertime.html">Keluhan Overtime</a></li>
                            </ul>
                        </li>
                        <li class="sub">
                            <a href="javascript:;">
                                <i class="fa fa-users"></i> Pendaftaran <div class="pull-right"><span class="caret"></span></div>
                            </a>
                            <ul class="templatemo-submenu">
                                <li><a href="bpjs.html">Pendaftaran BPJS</a></li>
                                <li><a href="beasiswa.html">Pendaftaran Beasiswa</a></li>
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
                                <li><a href="insert_user.jsp">TambahKaryawan</a></li>
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
                        <h1>Form Balas Komentar </h1>
                        <div class="row">
                            <div class="col-md-12">
                                <form role="form" id="templatemo-preferences-form" action="komentar?data=komentar&proses=input-komentar" method="post">
                                    <div class="row">
                                        <div class="col-md-3 margin-bottom-15">
                                            <label for="notes">Komentar</label>
                                            <input class="form-control" rows="3" id="notes" type="text" name="cmtcontent" required>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-3 margin-bottom-15">
                                            <label for="notes">Nik</label>
                                            <input input type="text" name="nik" class="form-control" rows="1" id="notes"onkeypress="return isNumberKey(event)" maxlength="7" required>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-3 margin-bottom-15">
                                            <label for="notes">Room Id</label>
                                            <input input type="text" name="room_id" class="form-control" rows="1" id="notes" onkeypress="return isNumberKey(event)" required>
                                        </div>
                                    </div>
                                    <div class="row templatemo-form-buttons">
                                        <div class="col-md-12">
                                            <button type="submit" class="btn btn-primary">Tambah</button>
                                            <button type="reset" class="btn btn-primary">Reset</button>    
                                        </div>
                                    </div>

                                    <script type="text/javascript" src="./jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
                                    <script type="text/javascript" src="./bootstrap/js/bootstrap.min_1.js"></script>
                                    <script type="text/javascript" src="../js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
                                    <script type="text/javascript" src="../js/locales/bootstrap-datetimepicker.id.js" charset="UTF-8"></script>
                                    <script type="text/javascript">

                                                $('.form_date').datetimepicker({
                                                    language: 'id',
                                                    weekStart: 1,
                                                    todayBtn: 1,
                                                    autoclose: 1,
                                                    todayHighlight: 1,
                                                    startView: 2,
                                                    minView: 2,
                                                    forceParse: 0
                                                });
                                    </script>
                            </div>
                        </div>               
                    </div> 
                </div>
            </div>
        </div>
        <!-- Modal -->
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
<footer class="templatemo-footer">
    <div class="templatemo-copyright">
        <p>Copyright &copy; 2018 PT Indocement Prakarsa Tunggal Tbk.</p>
    </div>
</footer>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/templatemo_script.js"></script>
</body>
</html>