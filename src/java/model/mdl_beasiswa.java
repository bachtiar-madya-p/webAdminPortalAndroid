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
public class mdl_beasiswa {

    private Integer id;
    private String date;
    private String doc;
    private String nm_anak;
    
    private String note;
    
    private String status;
    private String ttl;
    private Integer nik;

    //  private Koneksi db = null;
    Koneksi db = null;

    public mdl_beasiswa() {
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

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getNm_anak() {
        return nm_anak;
    }

    public void setNm_anak(String nm_anak) {
        this.nm_anak = nm_anak;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public Integer getNik() {
        return nik;
    }

    public void setNik(Integer nik) {
        this.nik = nik;
    }

    public void hapus() {
        String sql = "DELETE FROM tbl_beasiswa WHERE ID='" + id + "'";
        db.simpanData(sql);
        System.out.println("");
    }

    public void update() {

        String sql = "UPDATE tbl_beasiswa SET status = '" + status + "', note = '" + note + "' where id = '" + id + "'";
        db.simpanData(sql);
        System.out.println(sql);
    }

    public List tampil() {
        List<mdl_beasiswa> data = new ArrayList<mdl_beasiswa>();
        ResultSet rs = null;

        try {
            String sql = "select * from tbl_beasiswa";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_beasiswa um = new mdl_beasiswa();
                um.setId(rs.getInt("id"));
                um.setDate(rs.getString("date"));
                um.setDoc(rs.getString("doc"));
                um.setNm_anak(rs.getString("nm_anak"));
                um.setStatus(rs.getString("status"));
                
                um.setNote(rs.getString("note"));//NOTE
                
                um.setTtl(rs.getString("ttl"));                
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
        List<mdl_beasiswa> data = new ArrayList<mdl_beasiswa>();
        ResultSet rs = null;

        try {
            String sql = "select * from tbl_beasiswa WHERE status = '" + status + "' ";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_beasiswa um = new mdl_beasiswa();
                um.setId(rs.getInt("id"));
                um.setDate(rs.getString("date"));
                um.setDoc(rs.getString("doc"));
                um.setNm_anak(rs.getString("nm_anak"));
                um.setStatus(rs.getString("status"));
                
                um.setNote(rs.getString("note"));//NOTE
                
                um.setTtl(rs.getString("ttl"));
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
        List<mdl_beasiswa> data = new ArrayList<mdl_beasiswa>();
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM tbl_beasiswa WHERE ID='" + id + "'";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_beasiswa um = new mdl_beasiswa();
                um.setId(rs.getInt("id"));
                um.setDate(rs.getString("date"));
                um.setDoc(rs.getString("doc"));
                um.setNm_anak(rs.getString("nm_anak"));
                um.setStatus(rs.getString("status"));
                
                um.setNote(rs.getString("note"));//NOTE
                
                um.setTtl(rs.getString("ttl"));
                um.setNik(rs.getInt("nik"));
                data.add(um);
            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalah Saat menampilkan Cari ID" + ex);
        }
        return data;

    }
}
