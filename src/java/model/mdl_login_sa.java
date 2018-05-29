package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class mdl_login_sa {

    private Integer id;
    private String pwd;
    private String uname;

    Koneksi db = null;

    public mdl_login_sa() {
        db = new Koneksi();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public List LoginSa(String pwd, String uname) {
        List data = new ArrayList();
        ResultSet rs = null;
        try {
            String sql = "select * from tbl_sa where pwd='" + pwd + "' and uname='" + uname + "'";
            rs = db.ambilData(sql);

            while (rs.next()) {
                mdl_login_sa am = new mdl_login_sa();
                am.setId(rs.getInt("id"));
                am.setPwd(rs.getString("pwd"));
                am.setUname(rs.getString("uname"));
                data.add(am);
            }
            db.diskonek(rs);
        } catch (Exception a) {
            System.out.println("Terjadi kesalahaan cari login admin, pada :\n" + a);
        }
        return data;
    }
}
