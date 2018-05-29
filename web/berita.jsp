<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.mdl_berita"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>IDOCEMENT</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="viewport" content="width=device-width">        
        <link rel="stylesheet" href="css/templatemo_main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" language="JavaScript">
            function konfirmasi()
            {
                tanya = confirm("Anda Yakin Akan Menghapus Data ?");
                if (tanya == true)
                    return true;
                else
                    return false;
            }//filter broh
            (function (document) {
                'use strict';

                var LightTableFilter = (function (Arr) {

                    var _input;

                    function _onInputEvent(e) {
                        _input = e.target;
                        var tables = document.getElementsByClassName(_input.getAttribute('data-table'));
                        Arr.forEach.call(tables, function (table) {
                            Arr.forEach.call(table.tBodies, function (tbody) {
                                Arr.forEach.call(tbody.rows, _filter);
                            });
                        });
                    }

                    function _filter(row) {
                        var text = row.textContent.toLowerCase(), val = _input.value.toLowerCase();
                        row.style.display = text.indexOf(val) === -1 ? 'none' : 'table-row';
                    }

                    return {
                        init: function () {
                            var inputs = document.getElementsByClassName('light-table-filter');
                            Arr.forEach.call(inputs, function (input) {
                                input.oninput = _onInputEvent;
                            });
                        }
                    };
                })(Array.prototype);

                document.addEventListener('readystatechange', function () {
                    if (document.readyState === 'complete') {
                        LightTableFilter.init();
                    }
                });

            })(document);
        </script>
    </head>
    <body onLoad="buildHtmlTable('#excelDataTable')">
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
                                <input type="text" class="form-control" id="templatemo_search_box" placeholder="Cari...">
                                <span class="btn btn-default">Ok</span>
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
                        <div class="row">
                            <div class="col-md-12">
                                <div class="btn-group pull-right" id="templatemo_sort_btn">
                                    <form class="navbar-form" action="berita.jsp">
                                        <input type="search" class="light-table-filter" data-table="order-table" placeholder="Filter">
                                    </form>
                                </div>
                                <div class="table-responsive">
                                    <h3 class="margin-bottom-15">Tabel Berita Karyawan</h3>
                                    <table id="myTable" class="order-table table table-striped table-hover table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Isi Berita</th>
                                                <th>Tanggal Berita</th>
                                                <th>Gambar</th>
                                                <th>NIK</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                mdl_berita km = new mdl_berita();
                                                List<mdl_berita> data = new ArrayList<mdl_berita>();
                                                String ket = request.getParameter("ket");
                                                if (ket == null) {
                                                    data = km.tampil();
                                                }
                                                for (int x = 0; x < data.size(); x++) {
                                            %>
                                            <tr>
                                                <td><%=data.get(x).getContent()%></td>
                                                <td><%=data.get(x).getPosdate()%></td>
                                                <td><img SRC="<%=data.get(x).getImg_content()%>" width="100" height="100"></td>

                                                <td><%=data.get(x).getNik()%></td>
                                                <td>
                                        <center>
                                            <span class="btn btn-success"><a onclick="return konfirmasi()" href="berita?proses=hapus-berita&room_id=<%=data.get(x).getRoom_id()%>">Hapus</a></span>
                                        </center>
                                        </td>
                                        </tr>
                                        <%}%>
                                        </tbody>
                                    </table>
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
                                        <a href="login.jsp" class="btn btn-primary">Iya</a>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Tidak</button>
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
                </html>
