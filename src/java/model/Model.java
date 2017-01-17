/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.Pool;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Date;
import java.sql.Date;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marco
 */
public class Model {

    public Model() {

    }

    //------------USUARIO----------------
    public Usuario login(String nick, String pass) {
        Connection con = null;
        Usuario user = null;
        try {
            con = Pool.getConnection();
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            if (con != null) {

                String sql = "select privilegio from UsuarioM "
                        + "where UsuarioM.nick='" + nick + "' "
                        + "and UsuarioM.contrasena='" + pass + "' "
                        + "and UsuarioM.estado=1";
                pstmt = con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    user = new Usuario();
                    user.setNick(nick);
                    user.setPrivilegio(rs.getInt("privilegio"));
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            user = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                user = null;
            }
        }
        return user;
    }

    public int guardarUsuario(Usuario usuario) {
        Connection con = null;
        int res = 0;//res =0 cuando hay error en conexion
        try {
            con = Pool.getConnection();
            CallableStatement pstmt = null;

            ResultSet rs = null;
            if (con != null) {

                String sql = "{call prc_ins_user('" + usuario.getContrasena() + "',"
                        + "'1',"//este 1 es temporal mientras se remueve idfuncionario de tabla de usuarios
                        + "'" + usuario.getNick() + "',"
                        + "'" + usuario.getEstado() + "',"
                        + "'" + usuario.getPrivilegio() + "')}";
                pstmt = con.prepareCall(sql);

                pstmt.executeUpdate();
                res = 2;// res = 2 cuando indica exito!
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            res = 1;//res  = 1 cuando hay excepcion, ejemplo: llave primaria repetida
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                res = 1;//res  = 1 cuando hay excepcion, ejemplo: llave primaria repetida
            }
        }
        return res;
    }

    public List<Funcionario> listadoFuncionarios() {
        Connection con = null;
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        try {
            con = Pool.getConnection();
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            if (con != null) {

                String sql = "select * from FUNCIONARIO ";
                pstmt = con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                int idFuncionario = 0;
                String nombre = "";
                String puesto = "";
                while (rs.next()) {
                    idFuncionario = rs.getInt("IdFuncionario");
                    nombre = rs.getString("nombre");
                    puesto = rs.getString("puesto");
                    funcionarios.add(new Funcionario(idFuncionario, puesto, "", nombre, "", ""));
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            funcionarios = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                funcionarios = null;
            }
        }
        return funcionarios;
    }

    public List<Policia> listadoPolicias() {
        Connection con = null;
        List<Policia> policias = new ArrayList<Policia>();
        try {
            con = Pool.getConnection();
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            if (con != null) {

                String sql = "select * from PoliciaMunicipal ";
                pstmt = con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                int idFuncionario = 0;
                String nombre = "";
                while (rs.next()) {
                    idFuncionario = rs.getInt("IdPolicia");
                    nombre = rs.getString("nombre");
                    policias.add(new Policia(idFuncionario, "", nombre, "", ""));
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            policias = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                policias = null;
            }
        }
        return policias;
    }

    public List<Usuario> listadoUsuarios() {
        Connection con = null;
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            con = Pool.getConnection();
            Statement pstmt = null;
            ResultSet rs = null;
            if (con != null) {

                String sql = "SELECT alias1.iduser,alias2.nombre,alias1.nick,alias1.estado,alias1.privilegio "
                        + "FROM "
                        + "    (SELECT usuariom.iduser,usuariom.nick,usuariom.idfuncionario,usuariom.estado,usuariom.privilegio "
                        + "    FROM usuariom"
                        + "    )alias1 , "
                        + "    (SELECT funcionario.idfuncionario,funcionario.nombre "
                        + "    FROM funcionario"
                        + "    )alias2  "
                        + "WHERE alias2.idfuncionario = alias1.idfuncionario";
                pstmt = con.createStatement();
                rs = pstmt.executeQuery(sql);
                int idUsuario = 0;
                String nombre = "";
                String nick = "";
                int estado = 0;
                int privilegio = 0;
                while (rs.next()) {
                    idUsuario = rs.getInt("iduser");
                    nombre = rs.getString("nombre");
                    nick = rs.getString("nick");
                    estado = rs.getInt("estado");
                    privilegio = rs.getInt("privilegio");
                    usuarios.add(new Usuario(idUsuario, nick, nombre, estado, privilegio));//uso el campo contraseña para almacenar el nombre del funcionario
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            usuarios = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                usuarios = null;
            }
        }
        return usuarios;
    }

    public int guardarActaDecomiso(ActaDecomiso acta) throws SQLException {
        Connection con = null;
        int res = 0;
        try {
            con = Pool.getConnection();
            CallableStatement pstmt = null;
            if (con != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
                String sql = "{call prc_ins_adecomiso('" + acta.getIdDecomiso() + "',"
                        + "'" + 1 + "',"
                        + "'" + acta.getInteresado().getIdInteresado() + "',"
                        + "'1',"
                        + "'" + sdf.format(acta.getFecha()) + "',"
                        + "'111',"
                        + "'" + acta.getObservaciones() + "',"
                        + "'" + acta.getTestigo().getIdTestigo()
                        + "')}";
                pstmt = con.prepareCall(sql);
                pstmt.executeUpdate();
                res = 2;
            }

        } catch (SQLException e) {
            res = 1;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                res = 1;
            }
        }
        return res;
    }

    public int guardarInteresado(Interesado interesado) {
        Connection con = null;
        int res = 0;//res =0 cuando hay error en conexion
        try {
            con = Pool.getConnection();
            CallableStatement pstmt = null;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
            ResultSet rs = null;
            if (con != null) {

                String sql = "{call prc_ins_int('" + interesado.getNombre() + "',"
                        + "'" + interesado.getIdentificacion() + "',"
                        + "'" + interesado.getApellido1() + "',"
                        + "'" + interesado.getApellido2() + "',"
                        + "'" + sdf.format(interesado.getFechaNacimiento()) + "',"
                        + "'" + interesado.getDomicilio().getDireccionExacta() + "')}";
                pstmt = con.prepareCall(sql);

                pstmt.executeUpdate();
                res = 2;// res = 2 cuando indica exito!
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            res = 1;//res  = 1 cuando hay excepcion, ejemplo: llave primaria repetida
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                res = 1;//res  = 1 cuando hay excepcion, ejemplo: llave primaria repetida
            }
        }
        return res;
    }

    public int guardarPolicia(Policia policia) {
        Connection con = null;
        int res = 0;//res =0 cuando hay error en conexion
        try {
            con = Pool.getConnection();
            CallableStatement pstmt = null;

            ResultSet rs = null;
            if (con != null) {

                String sql = "{call prc_ins_pm('"
                        + "1','" + policia.getNombre() + "')}";
                pstmt = con.prepareCall(sql);

                pstmt.executeUpdate();
                res = 2;// res = 2 cuando indica exito!
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            res = 1;//res  = 1 cuando hay excepcion, ejemplo: llave primaria repetida
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                res = 1;//res  = 1 cuando hay excepcion, ejemplo: llave primaria repetida
            }
        }
        return res;
    }

    public int guardarTestigo(Testigo testigo) {
        Connection con = null;
        int res = 0;//res =0 cuando hay error en conexion
        try {
            con = Pool.getConnection();
            CallableStatement pstmt = null;

            ResultSet rs = null;
            if (con != null) {

                String sql = "{call prc_ins_test('" + testigo.getNombre() + "',"
                        + "'" + testigo.getApellido1() + "',"
                        + "'" + testigo.getApellido2()
                        + "')}";
                pstmt = con.prepareCall(sql);

                pstmt.executeUpdate();
                res = 2;// res = 2 cuando indica exito!
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            res = 1;//res  = 1 cuando hay excepcion, ejemplo: llave primaria repetida
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                res = 1;//res  = 1 cuando hay excepcion, ejemplo: llave primaria repetida
            }
        }
        return res;
    }

    public static java.sql.Date convertFromJAVADateToSQLDate(java.util.Date javaDate) {
        java.sql.Date sqlDate = null;
        if (javaDate != null) {
            sqlDate = new Date(javaDate.getTime());
        }
        return sqlDate;
    }

    public int ultimaActaDecomiso() {
        Connection con = null;
        int last = -1;
        try {
            con = Pool.getConnection();
            Statement pstmt = null;
            ResultSet rs = null;
            if (con != null) {

                String sql = "select *  from ( select ActaDecomiso.*, max(IdDecomiso) over () as max_pk from ActaDecomiso) where IdDecomiso = max_pk";
                pstmt = con.createStatement();
                rs = pstmt.executeQuery(sql);
                while (rs.next()) {
                    last = rs.getInt("max_pk");
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return last;

    }

    public int getIdInteresado(String cedula) {
        Connection con = null;
        int id = -1;
        try {
            con = Pool.getConnection();
            Statement pstmt = null;
            ResultSet rs = null;
            if (con != null) {

                String sql = "select idInteresado from Interesado where cedula='" + cedula +"'";
                pstmt = con.createStatement();
                rs = pstmt.executeQuery(sql);
                if (rs.next()) {
                    id = rs.getInt("idinteresado");
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return id;
    }

    public int getIdPolicia(String cedula) {
        Connection con = null;
        int id = -1;
        try {
            con = Pool.getConnection();
            Statement pstmt = null;
            ResultSet rs = null;
            if (con != null) {

                String sql = "select idInteresado from Interesado where PoliciaMunicipal=" + cedula;
                pstmt = con.createStatement();
                rs = pstmt.executeQuery(sql);
                if (rs.next()) {
                    id = rs.getInt("idinteresado");
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return id;
    }


}
