/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author faisal
 */
public class mdl_bpjs {

    private Integer id;
    private String date;
    private String nokk;
    private String noktp;
    private String doc;
    private Integer nik;
    private String note;
    private String Status;

    Koneksi db = null;

    public mdl_bpjs() {
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

    public String getNokk() {
        return nokk;
    }

    public void setNokk(String nokk) {
        this.nokk = nokk;
    }

    public String getNoktp() {
        return noktp;
    }

    public void setNoktp(String noktp) {
        this.noktp = noktp;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public Integer getNik() {
        return nik;
    }

    public void setNik(Integer nik) {
        this.nik = nik;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
     public void update() {
        String sql = "UPDATE tbl_bpjs SET Status='"+Status+"', note = '" + note + "' where id = '"+id+"'";
        db.simpanData(sql);
        System.out.println(sql);
    }
     public void hapus() {
        String sql = "DELETE FROM tbl_bpjs WHERE ID='" + id + "'";
        db.simpanData(sql);
        System.out.println("");
    }

    public List tampil() {
        List<mdl_bpjs> data = new ArrayList<mdl_bpjs>();
        ResultSet rs = null;

        try {
            String sql = "select * from tbl_bpjs";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_bpjs um = new mdl_bpjs();
                
                um.setId(rs.getInt("id"));
                um.setDate(rs.getString("date"));
                um.setNokk(rs.getString("nokk"));
                um.setNoktp(rs.getString("noktp"));
                um.setDoc(rs.getString("doc"));
                um.setNik(rs.getInt("nik"));
                um.setStatus(rs.getString("status"));
                um.setNote(rs.getString("note"));//NOTE
                data.add(um);
            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalahan Saat menampilkan data User" + ex);
        }
        return data;
    }
    
    public List tampilStat(String status) {
       List<mdl_bpjs> data = new ArrayList<mdl_bpjs>();
        ResultSet rs = null;
        try {
            String sql = "select * from tbl_bpjs WHERE status = '" + status + "' ";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_bpjs um = new mdl_bpjs();
                 um.setId(rs.getInt("id"));
                um.setDate(rs.getString("date"));
                um.setNokk(rs.getString("nokk"));
                um.setNoktp(rs.getString("noktp"));
                um.setDoc(rs.getString("doc"));
                um.setNik(rs.getInt("nik"));
                um.setStatus(rs.getString("status"));
                um.setNote(rs.getString("note"));//NOTE
                data.add(um);
            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalahan Saat menampilkan data User" + ex);
        }
        return data;
    }

    public List cariID() {
        List<mdl_bpjs> data = new ArrayList<mdl_bpjs>();
        ResultSet rs = null;
 
        try {
            String sql = "SELECT * FROM tbl_bpjs WHERE ID='"+id+"'";
            rs = db.ambilData(sql);
            while (rs.next()) {
               mdl_bpjs um = new mdl_bpjs();
               
                um.setId(rs.getInt("id"));
                um.setDate(rs.getString("date"));
                um.setNokk(rs.getString("nokk"));
                um.setNoktp(rs.getString("noktp"));
                um.setDoc(rs.getString("doc"));
                um.setNik(rs.getInt("nik"));
                um.setStatus(rs.getString("status"));
                um.setNote(rs.getString("note"));//NOTE
                data.add(um);
            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalah Saat menampilkan Cari ID" + ex);
        }
        return data;

    }
}

