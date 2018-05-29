/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class mdl_feedbak {

    private Integer id;
    private String content;
    private String posdate;
    private Integer nik;

    Koneksi db = null;

    public mdl_feedbak() {
        db = new Koneksi();
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
        String sql = "DELETE FROM tbl_feedback WHERE ID='" + id + "'";
        db.simpanData(sql);
        System.out.println("");
    }

    public void update() {
        String sql = "UPDATE tbl_feedback SET content='" + content + "',posdate='" + posdate + "',nik='" + nik + "' where id = '" + id + "'";
        db.simpanData(sql);
        System.out.println(sql);
    }

    public void simpan() {
        String sql = "INSERT INTO tbl_feedback values(null,'" + content + "','" + posdate + "','" + nik + "')";
        db.simpanData(sql);
    }

    public List tampil() {
        List<mdl_feedbak> data = new ArrayList<mdl_feedbak>();
        ResultSet rs = null;

        try {
            String sql = "select * from tbl_feedback";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_feedbak um = new mdl_feedbak();
                um.setId(rs.getInt("id"));
                um.setContent(rs.getString("content"));
                um.setPosdate(rs.getString("posdate"));
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
        List<mdl_feedbak> data = new ArrayList<mdl_feedbak>();
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM tbl_feedback WHERE id='" + id + "'";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_feedbak m = new mdl_feedbak();
                m.setId(rs.getInt("id"));
                m.setContent(rs.getString("content"));
                m.setPosdate(rs.getString("posdate"));
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

