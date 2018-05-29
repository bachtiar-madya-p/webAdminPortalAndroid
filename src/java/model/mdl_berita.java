/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import service.FileLoc;

/**
 *
 * @author ilham
 */
public class mdl_berita {
    private Integer room_id;
    private String content;
    private String img_content;
    private String posdate;
    private Integer nik;
    
    Koneksi db = null;

    public mdl_berita() {
        db = new Koneksi();
    }


    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg_content() {
        return img_content;
    }

    public void setImg_content(String img_content) {
        this.img_content = img_content;
    }

    public String getPosdate() {
        return posdate;
    }

    public void setPosdate(String posdate) {
        this.posdate = posdate;
    }

    public Integer getNik() {
        return nik;
    }

    public void setNik(Integer nik) {
        this.nik = nik;
    }
     public void hapus() {
        String sql = "DELETE FROM tbl_newsfeed WHERE ROOM_ID='" + room_id + "'";
        db.simpanData(sql);
        System.out.println("");
    }
    
    public void simpan() {
        DateFormat dateFormat = new SimpleDateFormat("dd  MMM  yyyy");
	Date date = new Date();
        String regDate = dateFormat.format(date);
        String sql = "INSERT INTO tbl_newsfeed values(null,'" + content + "','" + img_content + "','" + regDate + "','" + nik + "')";
        db.simpanData(sql);
    }
    public List tampil() {
        List<mdl_berita> data = new ArrayList<mdl_berita>();
        ResultSet rs = null;
        try {
            String sql = "select * from tbl_newsfeed order by room_id desc";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_berita um = new mdl_berita();
                
                um.setRoom_id(rs.getInt("room_id"));
                um.setContent(rs.getString("content"));
                um.setPosdate(rs.getString("posdate"));
                um.setImg_content(rs.getString("img_content"));
                um.setNik(rs.getInt("nik"));;
                data.add(um);
            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalahan Saat menampilkan data User" + ex);
        }
        return data;
    }
}
