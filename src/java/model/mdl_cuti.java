
package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author faisal
 */
public class mdl_cuti {

    private Integer id;
    private String content;
    private String date;
    private String status;
    private String note;
    private Integer nik;
    //  private Koneksi db = null;
    Koneksi db = null;

    public mdl_cuti() {
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
        String sql = "UPDATE tbl_kelcuti SET status='" + status + "', note = '" + note + "' where id = '" + id + "'";
        db.simpanData(sql);
        System.out.println(sql);
    }

    public void hapus() {
        String sql = "DELETE FROM tbl_kelcuti WHERE ID='" + id + "'";
        db.simpanData(sql);
        System.out.println("");
    }

    public void simpan() {
        String sql = "INSERT INTO tbl_kelcuti values(null,'" + content + "','" + date + "','" + status + "','" + nik + "')";
        db.simpanData(sql);
    } 

    public List tampil() {
        List<mdl_cuti> data = new ArrayList<mdl_cuti>();
        ResultSet rs = null;

        try {
            String sql = "select * from tbl_kelcuti";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_cuti um = new mdl_cuti();
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
       List<mdl_cuti> data = new ArrayList<mdl_cuti>();
        ResultSet rs = null;
        try {
            String sql = "select * from tbl_kelcuti WHERE status = '" + status + "' ";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_cuti um = new mdl_cuti();
                
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
        List<mdl_cuti> data = new ArrayList<mdl_cuti>();
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM tbl_kelcuti WHERE id='" + id + "'";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_cuti m = new mdl_cuti();

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