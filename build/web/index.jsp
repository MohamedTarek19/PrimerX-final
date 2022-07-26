<!doctype html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

<head>
    <meta charset="utf-8">
    <title>Primerx</title>
    <link href="Css/Style-index.css" rel="stylesheet" type="text/css">

    <script lang="javascript">
        function getSelectedText(idoftextarea){
		var textArea = document.getElementById(idoftextarea);
                document.getElementById("103").value = document.getElementById("100").value;
		var indexStart=textArea.selectionStart;
		var indexEnd=textArea.selectionEnd;
                var str ="";
                document.getElementById("101").value = indexStart;
                document.getElementById("102").value = indexEnd;
                document.getElementById("101").setAttribute('readonly');
                document.getElementById("102").setAttribute('readonly');
                if(indexStart === indexEnd){
                    return;
                }
                for(var i = 0;i<= textArea.value.length;i++){
                    if(i === indexStart){
                        str = str.concat('[');
                        str = str.concat(textArea.value[i]);
                    }else if(i === indexEnd && i === textArea.value.length){
                        str = str.concat(']');
                        break;
                    }else if (i === indexEnd){
                        str = str.concat(']');
                        str = str.concat(textArea.value[i]);                        
                    }else{
                        if(i === textArea.value.length){
                            break;
                        }
                        str =str.concat(textArea.value[i]);
                    }
                    
                }
                textArea.value = str;
	}
        function clearSP(idOfTxArea){
            var textArea = document.getElementById(idOfTxArea);
            var str ="";
            document.getElementById("101").value = "";
            document.getElementById("102").value = "";
            document.getElementById("101").removeAttribute('readonly');
            document.getElementById("102").removeAttribute('readonly');
            for(var i = 0;i< textArea.value.length;i++){
                    if(textArea.value[i] === '[' || textArea.value[i] === ']'){
                        
                    }else{
                        str = str.concat(textArea.value[i]);
                    }
                }
                textArea.value = str;
        }
    </script>
</head>
<body>
	<header>
		<h1>Primerx</h1>
		<h3> (Pick Primers From A DNA Sequence) </h3>
	</header>
    <form action="Results-page.jsp">
	<div class="Program">
                <h2>Paste Source Sequence Below:</h2>	
                <textarea name="input-sequence" class="input-sequence" id="100" placeholder="Put The DNA Sequence..."></textarea>
		<div class="choice-1">
                    <h2 >Mark Selected Region </h2>
                    <button type="button" class="button"  onclick="getSelectedText(100)" title="specifying gene">[  ] </button>
                    <button type="button" class="button" onclick="clearSP(100)" title="clear all marks" > Clear </button>
		</div>
                
                <textarea name="input-sequenceRaw" id="103" hidden=""></textarea>
		<div class="choice-2">
                    <h2 >Target Genes  &nbsp;&nbsp;[</h2>
                    <input type="text" class="geneIndex" name="Startindex" id="101" placeholder="start index.."/>
                    <input type="text" class="geneIndex" name="Endindex" id="102" placeholder="end index.."/>
                    &nbsp;&nbsp; <h2>]</h2>
                </div>
		<div class="choice-2">
                    <h2 >max size &nbsp;&nbsp;:</h2>
                    <br>
                    <input type="text" class="primersettings" name="maxs" value="27"/>
                </div>
		<div class="choice-2">
                    <h2 >minimum size &nbsp;&nbsp;:</h2>
                    <br>
                    <input type="text" class="primersettings" name="mins" value="18"/>
                </div>
		<div class="choice-2">
                    <h2 >max temperature &nbsp;&nbsp:</h2>
                    <br>
                    <input type="text" class="primersettings" name="maxt" value="57"/>  
                </div>
		<div class="choice-2">
                    <h2 >minimum temperature &nbsp;&nbsp;:</h2>
                    <br>
                    <input type="text" class="primersettings" name="mint" value="63"/>
                </div>
		<div class="choice-2">
                    <h2 >max CG% &nbsp;&nbsp;:</h2>
                    <br>
                    <input type="text" class="primersettings" name="maxcg" value="60"/>
                </div>
		<div class="choice-2">
                    <h2 >minimum CG%&nbsp;&nbsp;:</h2>
                    <br>
                    <input type="text" class="primersettings" name="mincg" value="20"/>
                </div>                
                <div class="final">
                    <button name="PickPrimers" type="submit" class="button">Pick Primers</button>
                    <button name="PickPrimers" type="submit" class="button" formaction="result-2.jsp">show all Primers</button>
                    <button type="reset" class="button">Reset Form</button>
                </div>		
	</div>
    </form>
</body>
</html>