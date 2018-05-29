/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class mdl_overtime {

    private Integer id;
    private String content;
    private String date;
    private String status;
    private String note;
    private Integer nik;
    //  private Koneksi db = null;
    Koneksi db = null;

    public mdl_overtime() {
        db = new Koneksi();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNik() {
        return nik;
    }

    public void setNik(Integer nik) {
        this.nik = nik;
    }

    public void update() {
        String sql = "UPDATE tbl_kelovertime SET status='" + status + "', note = '" + note + "' where id = '" + id + "'";
        db.simpanData(sql);
        System.out.println(sql);
    }

    public void hapus() {
        String sql = "DELETE FROM tbl_kelovertime WHERE ID='" + id + "'";
        db.simpanData(sql);
        System.out.println("");
    }

    public void simpan() {
        String sql = "INSERT INTO tbl_kelovertime values(null,'" + content + "','" + date + "','" + status + "','" + nik + "')";
        db.simpanData(sql);
    }

    public List tampil() {
        List<mdl_overtime> data = new ArrayList<mdl_overtime>();
        ResultSet rs = null;

        try {
            String sql = "select * from tbl_kelovertime";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_overtime um = new mdl_overtime();
                um.setId(rs.getInt("id"));
                um.setContent(rs.getString("content"));
                um.setDate(rs.getString("date"));
                um.setStatus(rs.getString("status"));
                um.setNote(rs.getString("note"));//NOTE
                um.setNik(rs.getInt("nik"));
                data.add(um);

            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalahan Saat menampilkan data User" + ex);
        }
        return data;
    }
    
public List tampilStat(String status) {
       List<mdl_overtime> data = new ArrayList<mdl_overtime>();
        ResultSet rs = null;
        try {
            String sql = "select * from tbl_kelovertime WHERE status = '" + status + "' ";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_overtime um = new mdl_overtime();
                
                um.setId(rs.getInt("id"));
                um.setContent(rs.getString("content"));
                um.setDate(rs.getString("date"));
                um.setStatus(rs.getString("status"));
                
                um.setNote(rs.getString("note"));//NOTE
                um.setNik(rs.getInt("nik"));
                data.add(um);

            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalahan Saat menampilkan data User" + ex);
        }
        return data;
    }

    public List cariID() {
        List<mdl_overtime> data = new ArrayList<mdl_overtime>();
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM tbl_kelovertime WHERE id='" + id + "'";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_overtime m = new mdl_overtime();

                m.setId(rs.getInt("id"));
                m.setContent(rs.getString("content"));
                m.setDate(rs.getString("date"));
                m.setStatus(rs.getString("status"));
                m.setNote(rs.getString("note"));//NOTE
                m.setNik(rs.getInt("nik"));
                data.add(m);

            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalah Saat menampilkan Cari ID" + ex);
        }
        return data;
    }
}
