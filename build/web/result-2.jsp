<%-- 
    Document   : result-2
    Created on : Jul 30, 2020, 6:39:01 PM
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

                <%
                    Primer p = new Primer();
                    //index al bracket 
                    //System.out.println("=====================================");
                    
                %>

            <p style="order:2" class="hints">Forward and Reverse Primers</p>

         <div style="order:2" id="results">

            
            <div class="title" style="text-align: center;margin: auto;">

               <p class="hints" id="forward">Forward</p> 
            </div>
            <%p.get_all_Forward_Primers(start);
            for(int i = 0 ; i <p.All_Forward.size();i++){%>
              <%= p.All_Forward.get(i).Sequence %>
              <br>
            <%}%>
            size : 
            <%=p.All_Forward.size()%> primer
            <br>
            <div class="title" style="text-align: center;">
                    <p class="hints" id="reverse">Reverse</p>
            </div>
            <%p.get_all_Reverse_Primers(end);
            for(int i = 0 ; i <p.All_Reverse.size();i++){%>
              <%= p.All_Reverse.get(i).Sequence %>
              <br>
            <%}%>
            size :  
            <%=p.All_Reverse.size() %> primer
</div>
</div>
</body>
</html>
