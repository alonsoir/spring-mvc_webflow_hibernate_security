/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.30
 * Generated at: 2013-07-17 15:46:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

private static org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fn:length", org.apache.taglibs.standard.functions.Functions.class, "length", new Class[] {java.lang.Object.class});
}

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/pages/common/footer.jsp", Long.valueOf(1372780661000L));
    _jspx_dependants.put("/WEB-INF/pages/common/header.jsp", Long.valueOf(1374062770000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Login Page</title>\r\n");
      out.write("<style>\r\n");
      out.write(".errorblock {\r\n");
      out.write("\tcolor: #ff0000;\r\n");
      out.write("\tbackground-color: #ffEEEE;\r\n");
      out.write("\tborder: 3px solid #ff0000;\r\n");
      out.write("\tpadding: 8px;\r\n");
      out.write("\tmargin: 16px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload='document.f.j_username.focus();'>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<!-- ojito has cambiado el lenguaje de en a es -->\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"es\" lang=\"es\">\r\n");
      out.write("<head>\r\n");
      out.write("<style>\r\n");
      out.write("body {\r\n");
      out.write("\tmargin: 10;\r\n");
      out.write("\tfont-family: verdana;\r\n");
      out.write("\tbackground-color: #EFF8FB\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("h1 {\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding: 15px;\r\n");
      out.write("\tfont-family: verdana;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("h2 {\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding: 20px 0px 5px 0px;\r\n");
      out.write("\tfont-family: verdana;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".header {\r\n");
      out.write("\ttop: 0px;\r\n");
      out.write("\theight: 65px;\r\n");
      out.write("\tborder-bottom: 1px #ccc solid;\r\n");
      out.write("\tbackground-color: #EFEFFB;\r\n");
      out.write("\tfont-family: verdana;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".footer {\r\n");
      out.write("\tclear: both;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\tborder-top: 1px #ccc solid;\r\n");
      out.write("\tpadding: 10px 0px 0px 0px;\r\n");
      out.write("\tbackground-color: #EFEFFB;\r\n");
      out.write("\tfont-family: verdana;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".footer .text {\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("\tmargin-right: 20px;\r\n");
      out.write("\tfont-family: verdana;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=\"textbox\"] {\r\n");
      out.write("\tdisplay: inline !important;\r\n");
      out.write("\twidth: 35px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=\"checkbox\"] {\r\n");
      out.write("\tdisplay: inline !important;\r\n");
      out.write("\twidth: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("input[type=\"radio\"] {\r\n");
      out.write("\tdisplay: inline !important;\r\n");
      out.write("\twidth: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input {\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\twidth: 340px;\r\n");
      out.write("\tmargin: 3px 0px 20px 0px;\r\n");
      out.write("\tpadding: 5px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("label {\r\n");
      out.write("\tfont-weight: normal;\r\n");
      out.write("\tfont-size: 15px;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("button {\r\n");
      out.write("\tbackground-color: #ccc;\r\n");
      out.write("\tcolor: #000;\r\n");
      out.write("\tborder: 1px #f4f4f4 solid;\r\n");
      out.write("\tmargin: 12px 0px;\r\n");
      out.write("\tbox-shadow: 0 3px 2px #AAA;\r\n");
      out.write("\tmargin-right: 5px;\r\n");
      out.write("\tpadding: 5px 10px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#dialog {\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".ui-dialog {\r\n");
      out.write("\tbox-shadow: 0 20px 10px #AAA;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".error {\r\n");
      out.write("\tborder: 1px solid #FBB3B9;\r\n");
      out.write("\tcolor: #f0051e;\r\n");
      out.write("\tbackground: #FFECED;\r\n");
      out.write("\tpadding: 5px;\r\n");
      out.write("\tmargin-bottom: 10px;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".link {\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("\tpadding: 0px 30px 20px 30px;\r\n");
      out.write("\tbackground-color: #f4f4f4;\r\n");
      out.write("\tborder: 1px solid #ccc;\r\n");
      out.write("\tfont-family: verdana;\r\n");
      out.write("\twidth: 400px;\r\n");
      out.write("\tmargin: 0 auto;\r\n");
      out.write("\tmargin-top: 40px;\r\n");
      out.write("\tmargin-bottom: 40px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".linkComunidades {\r\n");
      out.write("\tpadding: 0px 30px 20px 30px;\r\n");
      out.write("\tbackground-color: #f4f4f4;\r\n");
      out.write("\tborder: 1px solid #ccc;\r\n");
      out.write("\tfont-family: verdana;\r\n");
      out.write("\twidth: 1128px;\r\n");
      out.write("\tmargin: 0 auto;\r\n");
      out.write("\tmargin-left: 40px;\r\n");
      out.write("\tmargin-top: 40px;\r\n");
      out.write("\tmargin-bottom: 90px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".linkMuroComunidades {\r\n");
      out.write("\tpadding: 0px 0px 10px 20px;\r\n");
      out.write("\tbackground-color: #f4f4f4;\r\n");
      out.write("\tborder: 1px solid #ccc;\r\n");
      out.write("\tfont-family: verdana;\r\n");
      out.write("\twidth: 1128px;\r\n");
      out.write("\tmargin: 0 auto;\r\n");
      out.write("\tmargin-left: 40px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login {\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\twidth: 380px;\r\n");
      out.write("\tmargin: 0 auto;\r\n");
      out.write("\tborder: 1px solid #ccc;\r\n");
      out.write("\tpadding: 30px;\r\n");
      out.write("\tmargin-top: 40px;\r\n");
      out.write("\tmargin-bottom: 40px;\r\n");
      out.write("\tmargin-left: 40px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login h2 {\r\n");
      out.write("\tmargin-top: 0px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".success {\r\n");
      out.write("\tborder: 1px solid green;\r\n");
      out.write("\tcolor: green;\r\n");
      out.write("\tbackground: #90EE90;\r\n");
      out.write("\tpadding: 5px;\r\n");
      out.write("\tmargin-bottom: 10px;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".failure {\r\n");
      out.write("\tborder: 1px solid green;\r\n");
      out.write("\tcolor: red;\r\n");
      out.write("\tbackground: #90EE90;\r\n");
      out.write("\tpadding: 5px;\r\n");
      out.write("\tmargin-bottom: 10px;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".currentUser {\r\n");
      out.write("\tborder: 1px solid green;\r\n");
      out.write("\tcolor: green;\r\n");
      out.write("\tbackground: #90EE90;\r\n");
      out.write("\tpadding: 5px;\r\n");
      out.write("\tmargin-bottom: 10px;\r\n");
      out.write("\tfont-size: 6px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".successInfoCertificado {\r\n");
      out.write("\tborder: 1px solid green;\r\n");
      out.write("\tcolor: black;\r\n");
      out.write("\tbackground: #90EE90;\r\n");
      out.write("\tpadding: 5px;\r\n");
      out.write("\tmargin-bottom: 10px;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table {\r\n");
      out.write("\tcolor: #000000;\r\n");
      out.write("\tbackground-color: #F4F4F4;\r\n");
      out.write("\tborder-spacing: 1;\r\n");
      out.write("\tfont: 10px \"Palatino Linotype\", \"Book Antiqua\", Palatino, serif;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("th {\r\n");
      out.write("\tcolor: #000000;\r\n");
      out.write("\tfont-weight: 100;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\ttext-align: left;\r\n");
      out.write("\tvertical-align: top;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("tr {\r\n");
      out.write("\tfont-weight: 100;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("td {\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\ttext-align: left;\r\n");
      out.write("\tvertical-align: top;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table {\r\n");
      out.write("\twidth: 100px;\r\n");
      out.write("\tmargin: 0 auto;\r\n");
      out.write("\tborder: 1px solid #ccc;\r\n");
      out.write("\tmargin-bottom: 40px;\r\n");
      out.write("\tborder-collapse: collapse;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("tr {\r\n");
      out.write("\tmargin: 0px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("th {\r\n");
      out.write("\ttext-align: left;\r\n");
      out.write("\tborder: 1px solid #ccc;\r\n");
      out.write("\tpadding: 5px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("td {\r\n");
      out.write("\tborder: 1px solid #ccc;\r\n");
      out.write("\tpadding: 5px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc='http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js'></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=' http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/jquery-ui.min.js '></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" \r\n");
      out.write("\t  type=\"text/css\"\r\n");
      out.write("\t  href=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/themes/base/jquery-ui.css\"/>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" \r\n");
      out.write("\t  type=\"text/css\"\r\n");
      out.write("\t  href=\"http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css\"/>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" \r\n");
      out.write("\t  type=\"text/css\"\r\n");
      out.write("\t  href=\"http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables_themeroller.css\"/>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"header\">\r\n");
      out.write("\t\t<h1>Juridia</h1>\r\n");
      out.write("\t\t<p class=\"currentUser\">\r\n");
      out.write("\t\t\tUsuario actual:\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</p>\r\n");
      out.write("\t</div>");
      out.write("\r\n");
      out.write("\t<div class=\"login\">\r\n");
      out.write("\t\t<h3>Ingrese usuario y contraseña</h3>\r\n");
      out.write("\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<form name='f' action=\"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\" method='POST'>\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>Usuario:</td>\r\n");
      out.write("\t\t\t\t\t<td><input type='text' name='j_username' value='Introduzca un usuario y contraseña validos'></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>Contraseña:</td>\r\n");
      out.write("\t\t\t\t\t<td><input type='password' name='j_password' /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td colspan='2' valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<input name=\"submit\" type=\"submit\" value=\"Entrar\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td colspan='2' valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<input name=\"reset\" type=\"reset\" value=\"Borrar todo\"/>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");
      out.write("<div class=\"footer\">\r\n");
      out.write(" <div class=\"text\">Diseño e implementación por Alonso Isidoro Román y Jorge Calvo Onsurbe.2013</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("<html>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fout_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent(null);
    // /WEB-INF/pages/common/header.jsp(277,3) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentUser.name}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/pages/common/header.jsp(278,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fn:length(currentUser.name) > 0}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, _jspx_fnmap_0, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t<a href=\"");
        if (_jspx_meth_c_005furl_005f0(_jspx_th_c_005fif_005f0, _jspx_page_context))
          return true;
        out.write("\">Salir del sistema</a>\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
    // /WEB-INF/pages/common/header.jsp(279,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/j_spring_security_logout");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /WEB-INF/pages/common/header.jsp(282,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fn:length(currentUser.name) <= 0}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, _jspx_fnmap_0, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\tninguno\r\n");
        out.write("\t\t\t\t<a href=\"");
        if (_jspx_meth_c_005furl_005f1(_jspx_th_c_005fif_005f1, _jspx_page_context))
          return true;
        out.write("\">Entrar al sistema</a>\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f1, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f1);
    // /WEB-INF/pages/common/header.jsp(284,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/login");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f2.setParent(null);
    // /WEB-INF/pages/login.jsp(20,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty error}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
    if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t<div class=\"errorblock\">\r\n");
        out.write("\t\t\t\tNo has podido entrar en el sistema, intentalo de nuevo.<br /> \r\n");
        out.write("\t\t\t\tCausa : ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope[\"SPRING_SECURITY_LAST_EXCEPTION\"].message}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\r\n");
        out.write("\t\t\t</div>\r\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f2.setParent(null);
    // /WEB-INF/pages/login.jsp(27,25) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f2.setValue("j_spring_security_check");
    int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
    if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
    return false;
  }
}
