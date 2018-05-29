package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author faisal
 */
public class mdl_card {

    private Integer id;
    private String content;
    private String date;
    private String doc;
    private String status;
    private String note;
    private Integer nik;

    Koneksi db = null;

    public mdl_card() {
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
        String sql = "UPDATE tbl_ubahidcard SET status='" + status + "', note = '" + note + "' where id = '" + id + "'";
        db.simpanData(sql);
        System.out.println(sql);
    }

    public void hapus() {
        String sql = "DELETE FROM tbl_ubahidcard WHERE ID='" + id + "'";
        db.simpanData(sql);
        System.out.println("");
    }

    public List tampil() {
        List<mdl_card> data = new ArrayList<mdl_card>();
        ResultSet rs = null;

        try {
            String sql = "select * from tbl_ubahidcard";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_card um = new mdl_card();
                um.setId(rs.getInt("id"));
                um.setContent(rs.getString("content"));
                um.setDate(rs.getString("date"));
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
       List<mdl_card> data = new ArrayList<mdl_card>();
        ResultSet rs = null;
        try {
            String sql = "select * from tbl_ubahidcard WHERE status = '" + status + "' ";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_card um = new mdl_card();
                um.setId(rs.getInt("id"));
                um.setContent(rs.getString("content"));
                um.setDate(rs.getString("date"));
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
        List<mdl_card> data = new ArrayList<mdl_card>();
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM tbl_ubahidcard WHERE ID='" + id + "'";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_card um = new mdl_card();
                um.setId(rs.getInt("id"));
                um.setContent(rs.getString("content"));
                um.setDate(rs.getString("date"));
                um.setDoc(rs.getString("doc"));
                um.setStatus(rs.getString("status"));
                um.setNote(rs.getString("note"));//NOTE
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
