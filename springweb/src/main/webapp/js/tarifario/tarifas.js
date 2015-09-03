
	function validateForm (){
		var validate = $( "#rutaspricehistory" ).validate();
		$("#ruta").rules("add", {required:true, maxlength:150});
		$("#price").rules("add", {required:true, validaDecimal:true});
        validate.form();
        if( !valid ){            		
                return false;
        }
        return true;
	}
	
	function showDetail(id){
		window.open( $("#url").val()+"/tarifario/showTarifasDetail/"+id, "_blank", "toolbar=yes, scrollbars=yes, resizable=yes, top=250, left=250, width=400, height=400");
	}
	
    $(function(){
    	$("#btnInitRoute").click(function(){
        	if( validateForm() ){        		  		
        		$( "#rutaspricehistory" ).submit();
        	}
    	});	
    	$('.nav #generalInformation-tab').click(function (e) {
    		$("#tab").val("generalInformation");
    	});
    	$('.nav #service-tab').click(function (e) {
    		$("#tab").val("service");
    	});
    	$('.nav #team-tab').click(function (e) {
    		$("#tab").val("team");
    	});  
    	$('.nav #routes-tab').click(function (e) {
    		$("#tab").val("routes");
    	});
    	$('.nav #accessories-tab').click(function (e) {
    		$("#tab").val("generalInformation");
    	});  
    });    	
	
    $(document).ready(function(){
    	dataTableComplete( "tbl_data", null );
		$("#tbl_data").on("init.dt", function(){
			//$('<form style="display:inline"><input type=button value="Refrescar" onClick="history.go()"></form>').appendTo('#divData .dataTables_filter');
			$("#divData").show();
			$("table.dataTable tfoot input").css("width","90px");
		});	
		$.validator.addMethod('decimal', validaDecimal, "Porfavor introduzca un numero correcto, formato xxxx.xxx");
	});