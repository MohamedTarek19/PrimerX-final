<%-- 
    Document   : Results-page
    Created on : Jul 24, 2020, 5:45:05 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import= "primerDesigning.DeoxyRibose_NA, primerDesigning.MainPrimer, primerDesigning.Nucleic_Acid, primerDesigning.Nucleotide ,primerDesigning.Primer" %>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Css/Results-style.css" rel="stylesheet" type="text/css">
    <title>Results</title>
    <link href="Css/Results-style.css" rel="stylesheet" type="text/css">
</head>

<body>
	<header>
		<h1>The Results</h1>
	</header>

	<div id="all">

            <p class="hints">Source Sequence</p>

            <div style="order:1" id = "SequenceDiv">
                <p  id="SequenceP">
                   <%int start = Integer.parseInt(request.getParameter("Startindex")); %>
                   <%int end = Integer.parseInt(request.getParameter("Endindex")); %>
                   <%String sequence = (String)request.getParameter("input-sequenceRaw");
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
                            if(i == start){%>
                            <mark title="gene sequence">
                                <%=sequence.charAt(i)%>
                            <%}else if (i == end){%>
                            </mark>
                                <%=sequence.charAt(i)%>
                            <%}else {%>
                                <%=sequence.charAt(i)%>
                            <%}
                        }%>
                </p>
            </div>
                <%int maxs = Integer.parseInt(request.getParameter("maxs"));
                  int mins = Integer.parseInt(request.getParameter("mins"));
                  int maxt = Integer.parseInt(request.getParameter("maxt"));
                  int mint = Integer.parseInt(request.getParameter("mint"));
                  int maxcg = Integer.parseInt(request.getParameter("maxcg"));
                  int mincg = Integer.parseInt(request.getParameter("mincg"));
                %>
                <%
                    Primer p = new Primer();
                    p.get_all_Forward_Primers(start); //index al bracket 
                    //System.out.println("=====================================");
                    p.get_all_Reverse_Primers(end);
                    p.Getting_Top_Primers(maxs,mins,maxt,mint,maxcg,mincg);
                    //p.DisplayingPrimers(p.All_Forward);
                    //System.out.println("=====================================");
                    //p.DisplayingPrimers(p.All_Reverse);
                    //System.out.println("=====================================");
                %>

            <p style="order:2" class="hints">Forward and Reverse Primers</p>

            <div style="order:2" id="results">

            
         <div class="title" style="text-align: center;margin: auto;">

            <p class="hints" id="forward">Forward</p> 
         </div>
<%for (int j = 0 ; j<p.All_Forward.size();j++){%>

            <div class="node">

                    <p class="hints">Forward <%= j+1%></p>

                    <p class="Primer" id="Forward1"> <%= p.All_Forward.get(j).Sequence%> </p>

                    <div class="card">

                        <p class="cg" id="cg1"> CG(%) : <%= p.All_Forward.get(j).CGPercentage%>% </p>
                        <p class="temp" id="temp1"> Tm : <%= p.All_Forward.get(j).Temperature%>°C </p>
                        <p class="len" id="len1"> Length : <%= p.All_Forward.get(j).size%>bp </p>
                    </div>
            </div>
<%}%>



<div class="title" style="text-align: center;">
                    <p class="hints" id="reverse">Reverse</p>
            </div>

<%for (int i = 0 ; i<p.All_Reverse.size();i++){%>

            <div class="node" id ="node2">
                    <p class="hints">Reverse <%= i+1%></p>

                    <p class="Primer" id="Reverse1"> <%=p.All_Reverse.get(i).Sequence%> </p>

                    <div class="card">

                        <p class="cg" id="cg2"> CG(%) : <%=p.All_Reverse.get(i).CGPercentage%>%</p>
                        <p class="temp" id="temp2"> Tm : <%=p.All_Reverse.get(i).Temperature%>°C</p>
                        <p class="len" id="len2"> Length : <%=p.All_Reverse.get(i).size%>bp</p>
                    </div>
             </div>
          <%}%>


</div>
</div>
</body>
</html>
