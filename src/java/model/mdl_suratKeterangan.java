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

/**
 *
 * @author faisal
 */
public class mdl_suratKeterangan {

    private Integer id;
    private String date;
    private String jnssurat;
    private String doc;
    private String status;
    private String note;
    private Integer nik;

    Koneksi db = null;

    public mdl_suratKeterangan() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getJnssurat() {
        return jnssurat;
    }

    public void setJnssurat(String jnssurat) {
        this.jnssurat = jnssurat;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
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
        String sql = "UPDATE tbl_sketerangan SET status='" + status + "', note = '" + note + "' where id = '" + id + "'";
        db.simpanData(sql);
        System.out.println(sql);
    }

    public void hapus() {
        String sql = "DELETE FROM tbl_sketerangan WHERE ID='" + id + "'";
        db.simpanData(sql);
        System.out.println("");
    }

    public void simpan() {
        DateFormat dateFormat = new SimpleDateFormat("dd  MMM  yyyy");
        Date date = new Date();
        String regDate = dateFormat.format(date);
        String sql = "INSERT INTO tbl_sketerangan values(null,'" + regDate + "','" + jnssurat + "','" + doc + "','" + status + "','" + nik + "')";
        db.simpanData(sql);
    }

    public List tampil() {
        List<mdl_suratKeterangan> data = new ArrayList<mdl_suratKeterangan>();
        ResultSet rs = null;

        try {
            String sql = "select * from tbl_sketerangan";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_suratKeterangan um = new mdl_suratKeterangan();
                um.setId(rs.getInt("id"));
                um.setDate(rs.getString("date"));
                um.setJnssurat(rs.getString("jnssurat"));
                um.setDoc(rs.getString("doc"));
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
       List<mdl_suratKeterangan> data = new ArrayList<mdl_suratKeterangan>();
        ResultSet rs = null;
        try {
            String sql = "select * from tbl_sketerangan WHERE status = '" + status + "' ";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_suratKeterangan um = new mdl_suratKeterangan();
                um.setId(rs.getInt("id"));
                um.setDate(rs.getString("date"));
                um.setJnssurat(rs.getString("jnssurat"));
                um.setDoc(rs.getString("doc"));
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
        List<mdl_suratKeterangan> data = new ArrayList<mdl_suratKeterangan>();
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM tbl_sketerangan WHERE id='" + id + "'";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_suratKeterangan m = new mdl_suratKeterangan();

                m.setId(rs.getInt("id"));
                m.setDate(rs.getString("date"));
                m.setJnssurat(rs.getString("jnssurat"));
                m.setDoc(rs.getString("doc"));
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
