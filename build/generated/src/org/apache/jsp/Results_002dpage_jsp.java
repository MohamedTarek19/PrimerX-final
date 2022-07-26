package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import primerDesigning.DeoxyRibose_NA;
import primerDesigning.MainPrimer;
import primerDesigning.Nucleic_Acid;
import primerDesigning.Nucleotide;
import primerDesigning.Primer;

public final class Results_002dpage_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <link href=\"Css/Results-style.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("<title>Results</title>\n");
      out.write("<link href=\"Css/Results-style.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\t<header>\n");
      out.write("\t\t<h1>The Results</h1>\n");
      out.write("\t</header>\n");
      out.write("\n");
      out.write("\t<div id=\"all\">\n");
      out.write("\n");
      out.write("            <p class=\"hints\">Source Sequence</p>\n");
      out.write("\n");
      out.write("            <div style=\"order:1\" id = \"SequenceDiv\">\n");
      out.write("                <p  id=\"SequenceP\">\n");
      out.write("                   ");
int start = Integer.parseInt(request.getParameter("Startindex")); 
      out.write("\n");
      out.write("                   ");
int end = Integer.parseInt(request.getParameter("Endindex")); 
      out.write("\n");
      out.write("                   ");
String sequence = (String)request.getParameter("input-sequenceRaw");
                    boolean DNA_flag = true;
        DeoxyRibose_NA DNA;
        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == 'U') {
                DNA_flag = false;
            }
        }
        if (DNA_flag == true) {
            DNA = new DeoxyRibose_NA(sequence);
        } else {
            String newSequence = null;
            for (int i = 0; i < sequence.length(); i++) {
                if (sequence.charAt(i) == 'U') {
                    newSequence = sequence.substring(0, i) + 'T' + sequence.substring(i + 1);
                }
            }
            DNA = new DeoxyRibose_NA(newSequence);
        }
                        for(int i = 0 ; i< sequence.length();i++){
                            if(i == start){
      out.write("\n");
      out.write("                            <mark title=\"gene sequence\">\n");
      out.write("                                ");
      out.print(sequence.charAt(i));
      out.write("\n");
      out.write("                            ");
}else if (i == end){
      out.write("\n");
      out.write("                            </mark>\n");
      out.write("                                ");
      out.print(sequence.charAt(i));
      out.write("\n");
      out.write("                            ");
}else {
      out.write("\n");
      out.write("                                ");
      out.print(sequence.charAt(i));
      out.write("\n");
      out.write("                            ");
}
                        }
      out.write("\n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("                ");

                    Primer p = new Primer();
                    p.get_all_Forward_Primers(start); //index al bracket 
                    //System.out.println("=====================================");
                    p.get_all_Reverse_Primers(end);
                    p.Getting_Top_Primers();
                    //p.DisplayingPrimers(p.All_Forward);
                    //System.out.println("=====================================");
                    //p.DisplayingPrimers(p.All_Reverse);
                    //System.out.println("=====================================");
                
      out.write("\n");
      out.write("\n");
      out.write("            <p style=\"order:2\" class=\"hints\">Forward and Reverse Primers</p>\n");
      out.write("\n");
      out.write("            <div style=\"order:2\" id=\"results\">\n");
      out.write("\n");
      out.write("            \n");
      out.write("         <div class=\"title\">\n");
      out.write("\n");
      out.write("            <p class=\"hints\" id=\"forward\">Forward</p> \n");
      out.write("         </div>\n");
for (int j = 0 ; j<p.All_Forward.size();j++){
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"node\">\n");
      out.write("\n");
      out.write("                    <p class=\"hints\">Forward ");
      out.print( j+1);
      out.write("</p>\n");
      out.write("\n");
      out.write("                    <p class=\"Primer\" id=\"Forward1\"> ");
      out.print( p.All_Forward.get(j).Sequence);
      out.write(" </p>\n");
      out.write("\n");
      out.write("                    <div class=\"card\">\n");
      out.write("\n");
      out.write("                        <p class=\"cg\" id=\"cg1\"> CG(%) : ");
      out.print( p.All_Forward.get(j).CGPercentage);
      out.write("% </p>\n");
      out.write("                        <p class=\"temp\" id=\"temp1\"> Tm : ");
      out.print( p.All_Forward.get(j).Temperature);
      out.write("°C </p>\n");
      out.write("                        <p class=\"len\" id=\"len1\"> Length : ");
      out.print( p.All_Forward.get(j).size);
      out.write("bp </p>\n");
      out.write("                    </div>\n");
      out.write("            </div>\n");
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"title\">\n");
      out.write("                    <p class=\"hints\" id=\"reverse\">Reverse</p>\n");
      out.write("            </div>\n");
      out.write("\n");
for (int i = 0 ; i<p.All_Reverse.size();i++){
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"node\" id =\"node2\">\n");
      out.write("                    <p class=\"hints\">Reverse ");
      out.print( i+1);
      out.write("</p>\n");
      out.write("\n");
      out.write("                    <p class=\"Primer\" id=\"Reverse1\"> ");
      out.print(p.All_Reverse.get(i).Sequence);
      out.write(" </p>\n");
      out.write("\n");
      out.write("                    <div class=\"card\">\n");
      out.write("\n");
      out.write("                        <p class=\"cg\" id=\"cg2\"> CG(%) : ");
      out.print(p.All_Reverse.get(i).CGPercentage);
      out.write("%</p>\n");
      out.write("                        <p class=\"temp\" id=\"temp2\"> Tm : ");
      out.print(p.All_Reverse.get(i).Temperature);
      out.write("°C</p>\n");
      out.write("                        <p class=\"len\" id=\"len2\"> Length : ");
      out.print(p.All_Reverse.get(i).size);
      out.write("bp</p>\n");
      out.write("                    </div>\n");
      out.write("             </div>\n");
      out.write("          ");
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
