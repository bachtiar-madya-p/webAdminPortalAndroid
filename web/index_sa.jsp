<%@page import="model.mdl_komentar"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.mdl_berita"%>
<%@page import="model.mdl_user"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            Object name = request.getSession().getAttribute("uname");
            if ((session.getAttribute("uname") == null) || (session.getAttribute("uname") == "")) {
                response.sendRedirect("login_sa.jsp");
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
                        <li><a href="index_sa.jsp"><i class="fa fa-home"></i>Index</a></li>
                       <li class="sub">
                            <a href="javascript:;">
                                <i class="fa fa-users"></i> Data Karyawan <div class="pull-right"><span class="caret"></span></div>
                            </a>
                            <ul class="templatemo-submenu">
                                <li><a href="tabel_admin.jsp">Tabel Karyawan</a></li>
                            </ul>
                        </li>
                        <li><a href="javascript:;" data-toggle="modal" data-target="#confirmModal"><i class="fa fa-sign-out"></i>Log Out</a></li>
                    </ul>
                </div><!--/.navbar-collapse -->
                <div class="templatemo-content-wrapper">
                    <div class="templatemo-content">
                        <h1>Berita Indocement</h1>
                        <div class="margin-bottom-20">
                            <div class="row">
                                <div class="col-md-12">
                                    <ul class="nav nav-pills">
                                        <ul class="templatemo-sidebar-menu col-md-12">     
                                            
                                        </ul>
                                    </ul>          
                                </div>
                            </div>
                        </div>
                        <%
                            mdl_berita km = new mdl_berita();
                            List<mdl_berita> dataFeed = new ArrayList<mdl_berita>();
                            mdl_komentar comm = new mdl_komentar();
                            List<mdl_komentar> dataComm = new ArrayList<mdl_komentar>();
                            mdl_user user = new mdl_user();
                            List<mdl_user> dataUser = new ArrayList<mdl_user>();
                            String ket = request.getParameter("ket");
                            if (ket == null) {
                                dataFeed = km.tampil();
                            }
                            for (int x = 0; x < dataFeed.size(); x++) {
                                dataComm = comm.showCmt(dataFeed.get(x).getRoom_id());
                                dataUser = user.showUser(dataFeed.get(x).getNik());
                                for (int a = 0; a < dataUser.size(); a++) {
                        %>

                        <div >
                            <h4 class="list-group-item active"><%=dataUser.get(a).getName()%>, <%=dataFeed.get(x).getPosdate()%>&emsp;&emsp;<span class="btn btn-success"><a onclick="return konfirmasi()" href="berita?proses=hapus-berita&room_id=<%=dataFeed.get(x).getRoom_id()%>">Hapus</a></span></h4>
                            <p class="list-group-item" align="justify"><strong><%=dataFeed.get(x).getContent()%></strong></p>
                            <p class="list-group-item"><img SRC="<%=dataFeed.get(x).getImg_content()%>" width="75%"></p>
                            <ul class="templatemo-sidebar-menu"> 
                                <li class="sub">
                                    <a href="javascript:;">
                                        <h4 class="list-group-item">Komentar</h4> 
                                        <div class="pull-right">
                                            <span class="caret"></span>
                                        </div>
                                    </a>
                                    <ul class="templatemo-submenu">
                                        <%

                                            }

                                            for (int c = 0; c < dataComm.size(); c++) {
                                                dataUser = user.showUser(dataComm.get(c).getNik());
                                                for (int u = 0; u < dataUser.size(); u++) {

                                        %>
                                        <span class="btn btn-success"><a onclick="return konfirmasi()" href="komentar?proses=hapus-komentar&id=<%=dataComm.get(c).getId()%>">Hapus</a></span>
                                        <a class="list-group-item" href="javascript:;">
                                            <i class="fa fa-users"></i> <%=dataUser.get(u).getName()%>, <%=dataComm.get(c).getCmtposdate()%> 
                                        </a>
                                        <ul class="templatemo-submenu">
                                            <li>&emsp;&emsp;<%=dataComm.get(c).getCmtcontent()%></li>
                                        </ul>
                                        <% }
                                            }%>
                                    </ul>
                                </li>
                            </ul>
                            <%}%>
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
                        <h4 class="modal-title" id="myModalLabel">Are you sure you want to sign out?</h4>
                    </div>
                    <div class="modal-footer">
                        <a href="logout_sa.jsp" class="btn btn-primary">Yes</a>
                        <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
                    </div>
                </div>
            </div>
        </div>

    <footer class="templatemo-footer">
        <div class="templatemo-copyright">
            <p>Copyright &copy; 2084 Your Company Name <!-- Credit: www.templatemo.com --></p>
        </div>
    </footer>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/templatemo_script.js"></script>
</body>
</html>