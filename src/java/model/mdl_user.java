/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mdl_user {

    private Integer nik;
    private String dept;
    private String email;
    private String img_user;
    private String name;
    private String phone;
    private String plant;
    private String pwd;
    private String reg_date;
    private String tag;
    private String gcmToken;

    Koneksi db = null;

    public mdl_user() {
        db = new Koneksi();
    }

    public Integer getNik() {
        return nik;
    }

    public void setNik(Integer nik) {
        this.nik = nik;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg_user() {
        return img_user;
    }

    public void setImg_user(String img_user) {
        this.img_user = img_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getGcmToken()
    {
        return gcmToken;
    }
    public void setGcmToken (String gcmToken)
    {
        this.gcmToken = gcmToken;
    }
    

    public void hapus() {
        //String sql = "DELETE FROM tbl_user WHERE NIK ='" + nik + "'";
        String sql = "DELETE FROM tbl_user WHERE nik='" + nik + "'";
        db.simpanData(sql);
        System.out.println("");
    }

    public void update() {
        String sql = "UPDATE tbl_user SET dept='" + dept + "',email='" + email + "',name='" + name + "',phone='" + phone + "',plant='" + plant + "',pwd='" + pwd + "', tag='" + tag + "' where nik = '" + nik + "'";
        db.simpanData(sql);
        System.out.println(sql);
    }

    public void simpan() {
        DateFormat dateFormat = new SimpleDateFormat("dd  MMM  yyyy");
	Date date = new Date();
        String regDate = dateFormat.format(date);
        String photo = "client/add_photo.png";
        String tag = "waiting";
        String gcmToken = "";
        String sql = "INSERT INTO tbl_user values('" + nik + "','" + dept + "','" + email + "','" + photo + "','" + name + "','" + phone + "','" + plant + "','" + pwd + "','" + regDate + "','" + gcmToken + "','" + tag + "')";
        db.simpanData(sql);
    }

    public List tampil() {
        List<mdl_user> data = new ArrayList<mdl_user>();
        ResultSet rs = null;

        try {
            String sql = "select * from tbl_user order by nik asc";//buat urutin dari kecil ke besar
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_user um = new mdl_user();

                um.setNik(rs.getInt("nik"));
                um.setDept(rs.getString("dept"));
                um.setEmail(rs.getString("email"));
                um.setImg_user(rs.getString("img_user"));
                um.setName(rs.getString("name"));
                um.setPhone(rs.getString("phone"));
                um.setPlant(rs.getString("plant"));
                um.setPwd(rs.getString("pwd"));
                um.setReg_date(rs.getString("reg_date"));
                um.setTag(rs.getString("tag"));
                um.setGcmToken(rs.getString("gcm_token"));
                data.add(um);

            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalahan Saat menampilkan data User" + ex);
        }
        return data;
    }

    public List cariNik() {
        List<mdl_user> data = new ArrayList<mdl_user>();
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM tbl_user WHERE nik='" + nik + "'";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_user m = new mdl_user();

                m.setNik(rs.getInt("nik"));
                m.setDept(rs.getString("dept"));
                m.setEmail(rs.getString("email"));
                m.setImg_user(rs.getString("img_user"));
                m.setName(rs.getString("name"));
                m.setPhone(rs.getString("phone"));
                m.setPlant(rs.getString("plant"));
                m.setPwd(rs.getString("pwd"));
                m.setReg_date(rs.getString("reg_date"));
                m.setTag(rs.getString("tag"));
                m.setGcmToken(rs.getString("gcm_token"));
                data.add(m);

            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalah Saat menampilkan Cari ID" + ex);
        }
        return data;
    }
    public List showUser(int nik) {
        List<mdl_user> data = new ArrayList<mdl_user>();
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM tbl_user WHERE nik='" + nik + "'";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_user m = new mdl_user();

                m.setNik(rs.getInt("nik"));
                m.setDept(rs.getString("dept"));
                m.setEmail(rs.getString("email"));
                m.setImg_user(rs.getString("img_user"));
                m.setName(rs.getString("name"));
                m.setPhone(rs.getString("phone"));
                m.setPlant(rs.getString("plant"));
                m.setPwd(rs.getString("pwd"));
                m.setReg_date(rs.getString("reg_date"));
                m.setTag(rs.getString("tag"));
                m.setGcmToken(rs.getString("gcm_token"));
                data.add(m);

            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalah Saat menampilkan Cari ID" + ex);
        }
        return data;
    }
    String hasil;
    public String count()
    {
        hasil = "";
         ResultSet rs = null;
        try
        {
            String query = "SELECT COUNT(*) FROM tbl_user WHERE tag = 'waiting'";
            rs=db.ambilData(query);
             while (rs.next()) {
                hasil = String.valueOf(rs.getInt(1));
            }
            
        }
        catch(Exception x)
        {
            
        }
        return hasil;
    } 
    public List LoginAdmin(String nik, String pwd) {
        List data = new ArrayList();
        ResultSet rs = null;
         try {
            String sql = "SELECT * FROM tbl_user WHERE nik = " + nik + " AND pwd = '" + pwd + "'";
            rs = db.ambilData(sql);
            while (rs.next()) {
                mdl_user m = new mdl_user();
                m.setNik(rs.getInt("nik"));
                m.setDept(rs.getString("dept"));
                m.setEmail(rs.getString("email"));
                m.setImg_user(rs.getString("img_user"));
                m.setName(rs.getString("name"));
                m.setPhone(rs.getString("phone"));
                m.setPlant(rs.getString("plant"));
                m.setPwd(rs.getString("pwd"));
                m.setReg_date(rs.getString("reg_date"));
                m.setTag(rs.getString("tag"));
                m.setGcmToken(rs.getString("gcm_token"));
                data.add(m);

            }
            db.diskonek(rs);
        } catch (Exception a) {
            System.out.println("Terjadi kesalahaan cari login admin, pada :\n" + a);
        }
        return data;
    }
}
