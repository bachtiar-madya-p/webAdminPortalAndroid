package model;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class mdl_komentar {

    private Integer id;
    private String cmtcontent;
    private String cmtposdate;
    private Integer nik;
    private Integer room_id;

    Koneksi db = null;

    public mdl_komentar() {
        db = new Koneksi();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCmtcontent() {
        return cmtcontent;
    }

    public void setCmtcontent(String cmtcontent) {
        this.cmtcontent = cmtcontent;
    }

    public String getCmtposdate() {
        return cmtposdate;
    }

    public void setCmtposdate(String cmtposdate) {
        this.cmtposdate = cmtposdate;
    }

    public Integer getNik() {
        return nik;
    }

    public void setNik(Integer nik) {
        this.nik = nik;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public void hapus() {
        String sql = "DELETE FROM tbl_feedcmt WHERE ID='" + id + "'";
        db.simpanData(sql);
        System.out.println("");
    }
    public void delFeed(int roomId) {
        String sql = "DELETE FROM tbl_feedcmt WHERE room_id=" + roomId + "";
        db.simpanData(sql);
        System.out.println("");
    }

    public void update() {
       String sql = "UPDATE tbl_feedcmt SET cmtcontent='"+cmtcontent+"',nik='"+nik+"',room_id='"+room_id+"' where id = '"+id+"'";
        db.simpanData(sql);
        System.out.println(sql);
    }

    public void simpan() {
        DateFormat dateFormat = new SimpleDateFormat("dd  MMM  yyyy");
	Date date = new Date();
        String regDate = dateFormat.format(date);
        String sql = "INSERT INTO tbl_feedcmt values(null,'" + cmtcontent + "','" + regDate + "','" + nik + "','" + room_id + "')";
        db.simpanData(sql);
    }
    public void postCom(int roomid) {
        DateFormat dateFormat = new SimpleDateFormat("dd  MMM  yyyy");
	Date date = new Date();
        String regDate = dateFormat.format(date);
        String sql = "INSERT INTO tbl_feedcmt values(null,'" + cmtcontent + "','" + regDate + "','" + nik + "','" + roomid + "')";
        db.simpanData(sql);
    }

    public List tampil() {
        List<mdl_komentar> data = new ArrayList<mdl_komentar>();
        ResultSet rs = null;

        try {
            String sql = "select * from tbl_feedcmt";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_komentar um = new mdl_komentar();
                um.setId(rs.getInt("id"));
                um.setCmtcontent(rs.getString("cmtcontent"));
                um.setCmtposdate(rs.getString("cmtposdate"));
                um.setNik(rs.getInt("nik"));
                um.setRoom_id(rs.getInt("room_id"));
                data.add(um);

            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalahan Saat menampilkan data User" + ex);
        }
        return data;
    }
    
    public List showCmt(int roomId) {
        List<mdl_komentar> data = new ArrayList<mdl_komentar>();
        ResultSet rs = null;

        try {
            String sql = "select * from tbl_feedcmt where room_id = "+ roomId +" order by id desc";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_komentar um = new mdl_komentar();
                um.setId(rs.getInt("id"));
                um.setCmtcontent(rs.getString("cmtcontent"));
                um.setCmtposdate(rs.getString("cmtposdate"));
                um.setNik(rs.getInt("nik"));
                um.setRoom_id(rs.getInt("room_id"));
                data.add(um);

            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalahan Saat menampilkan data User" + ex);
        }
        return data;
    }
    public List cariID() {
        List<mdl_komentar> data = new ArrayList<mdl_komentar>();
        ResultSet rs = null;
 
        try {
            String sql = "SELECT * FROM tbl_feedcmt WHERE id='"+id+"'";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_komentar m = new mdl_komentar();
                m.setId(rs.getInt("id"));
                m.setCmtcontent(rs.getString("cmtcontent"));
                m.setCmtposdate(rs.getString("cmtposdate"));
                m.setNik(rs.getInt("nik"));
                m.setRoom_id(rs.getInt("room_id"));
                data.add(m);
 
            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalah Saat menampilkan Cari ID" + ex);
        }
        return data;
    }
}