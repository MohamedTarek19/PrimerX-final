package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!doctype html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>Primerx</title>\n");
      out.write("    <link href=\"Css/Style-index.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("\n");
      out.write("    <script lang=\"javascript\">\n");
      out.write("        function getSelectedText(idoftextarea){\n");
      out.write("\t\tvar textArea = document.getElementById(idoftextarea);\n");
      out.write("                document.getElementById(\"103\").value = document.getElementById(\"100\").value;\n");
      out.write("\t\tvar indexStart=textArea.selectionStart;\n");
      out.write("\t\tvar indexEnd=textArea.selectionEnd;\n");
      out.write("                var str =\"\";\n");
      out.write("                document.getElementById(\"101\").value = indexStart;\n");
      out.write("                document.getElementById(\"102\").value = indexEnd;\n");
      out.write("                document.getElementById(\"101\").setAttribute('readonly');\n");
      out.write("                document.getElementById(\"102\").setAttribute('readonly');\n");
      out.write("                if(indexStart === indexEnd){\n");
      out.write("                    return;\n");
      out.write("                }\n");
      out.write("                for(var i = 0;i<= textArea.value.length;i++){\n");
      out.write("                    if(i === indexStart){\n");
      out.write("                        str = str.concat('[');\n");
      out.write("                        str = str.concat(textArea.value[i]);\n");
      out.write("                    }else if(i === indexEnd && i === textArea.value.length){\n");
      out.write("                        str = str.concat(']');\n");
      out.write("                        break;\n");
      out.write("                    }else if (i === indexEnd){\n");
      out.write("                        str = str.concat(']');\n");
      out.write("                        str = str.concat(textArea.value[i]);                        \n");
      out.write("                    }else{\n");
      out.write("                        if(i === textArea.value.length){\n");
      out.write("                            break;\n");
      out.write("                        }\n");
      out.write("                        str =str.concat(textArea.value[i]);\n");
      out.write("                    }\n");
      out.write("                    \n");
      out.write("                }\n");
      out.write("                textArea.value = str;\n");
      out.write("\t}\n");
      out.write("        function clearSP(idOfTxArea){\n");
      out.write("            var textArea = document.getElementById(idOfTxArea);\n");
      out.write("            var str =\"\";\n");
      out.write("            document.getElementById(\"101\").value = \"\";\n");
      out.write("            document.getElementById(\"102\").value = \"\";\n");
      out.write("            document.getElementById(\"101\").removeAttribute('readonly');\n");
      out.write("            document.getElementById(\"102\").removeAttribute('readonly');\n");
      out.write("            for(var i = 0;i< textArea.value.length;i++){\n");
      out.write("                    if(textArea.value[i] === '[' || textArea.value[i] === ']'){\n");
      out.write("                        \n");
      out.write("                    }else{\n");
      out.write("                        str = str.concat(textArea.value[i]);\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                textArea.value = str;\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<header>\n");
      out.write("\t\t<h1>Primerx</h1>\n");
      out.write("\t\t<h3> (Pick Primers From A DNA Sequence) </h3>\n");
      out.write("\t</header>\n");
      out.write("    <form action=\"Results-page.jsp\">\n");
      out.write("\t<div class=\"Program\">\n");
      out.write("                <h2>Paste Source Sequence Below:</h2>\t\n");
      out.write("                <textarea name=\"input-sequence\" class=\"input-sequence\" id=\"100\" placeholder=\"Put The DNA Sequence...\"></textarea>\n");
      out.write("\t\t<div class=\"choice-1\">\n");
      out.write("                    <h2 >Mark Selected Region </h2>\n");
      out.write("                    <button type=\"button\" class=\"button\"  onclick=\"getSelectedText(100)\" title=\"specifying gene\">[  ] </button>\n");
      out.write("                    <button type=\"button\" class=\"button\" onclick=\"clearSP(100)\" title=\"clear all marks\" > Clear </button>\n");
      out.write("\t\t</div>\n");
      out.write("                \n");
      out.write("                <textarea name=\"input-sequenceRaw\" id=\"103\" hidden=\"\"></textarea>\n");
      out.write("\t\t<div class=\"choice-2\">\n");
      out.write("                    <h2 >Target Genes  &nbsp;&nbsp;[</h2>\n");
      out.write("                    <input type=\"text\" class=\"geneIndex\" name=\"Startindex\" id=\"101\" placeholder=\"start index..\"/>\n");
      out.write("                    <input type=\"text\" class=\"geneIndex\" name=\"Endindex\" id=\"102\" placeholder=\"end index..\"/>\n");
      out.write("                    &nbsp;&nbsp; <h2>]</h2>\n");
      out.write("                </div>\n");
      out.write("\t\t<div class=\"choice-2\">\n");
      out.write("                    <h2 >max size &nbsp;&nbsp;:</h2>\n");
      out.write("                    <br>\n");
      out.write("                    <input type=\"text\" class=\"primersettings\" name=\"maxs\" value=\"27\"/>\n");
      out.write("                </div>\n");
      out.write("\t\t<div class=\"choice-2\">\n");
      out.write("                    <h2 >minimum size &nbsp;&nbsp;:</h2>\n");
      out.write("                    <br>\n");
      out.write("                    <input type=\"text\" class=\"primersettings\" name=\"mins\" value=\"18\"/>\n");
      out.write("                </div>\n");
      out.write("\t\t<div class=\"choice-2\">\n");
      out.write("                    <h2 >max temperature &nbsp;&nbsp:</h2>\n");
      out.write("                    <br>\n");
      out.write("                    <input type=\"text\" class=\"primersettings\" name=\"maxt\" value=\"57\"/>  \n");
      out.write("                </div>\n");
      out.write("\t\t<div class=\"choice-2\">\n");
      out.write("                    <h2 >minimum temperature &nbsp;&nbsp;:</h2>\n");
      out.write("                    <br>\n");
      out.write("                    <input type=\"text\" class=\"primersettings\" name=\"mint\" value=\"63\"/>\n");
      out.write("                </div>\n");
      out.write("\t\t<div class=\"choice-2\">\n");
      out.write("                    <h2 >max CG% &nbsp;&nbsp;:</h2>\n");
      out.write("                    <br>\n");
      out.write("                    <input type=\"text\" class=\"primersettings\" name=\"maxcg\" value=\"60\"/>\n");
      out.write("                </div>\n");
      out.write("\t\t<div class=\"choice-2\">\n");
      out.write("                    <h2 >minimum CG%&nbsp;&nbsp;:</h2>\n");
      out.write("                    <br>\n");
      out.write("                    <input type=\"text\" class=\"primersettings\" name=\"mincg\" value=\"20\"/>\n");
      out.write("                </div>                \n");
      out.write("                <div class=\"final\">\n");
      out.write("                    <button name=\"PickPrimers\" type=\"submit\" class=\"button\">Pick Primers</button>\n");
      out.write("                    <button name=\"PickPrimers\" type=\"submit\" class=\"button\" formaction=\"result-2.jsp\">show all Primers</button>\n");
      out.write("                    <button type=\"reset\" class=\"button\">Reset Form</button>\n");
      out.write("                </div>\t\t\n");
      out.write("\t</div>\n");
      out.write("    </form>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
