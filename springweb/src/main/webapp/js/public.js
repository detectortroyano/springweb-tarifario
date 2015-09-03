	//var API_KEY 	= 'AIzaSyA4xdGnN9CQ42OON7xHgNrAQEamdzOxHEM';//localhost
	//var API_KEY 	= 'AIzaSyAfTZAquQcEgfScA1z2ZLVXOoobw4GY3cQ';//192.168.56.1
	//var API_KEY 	= 'AIzaSyBT8sDQ2IWG3enH0GBQnAMognxkx8DYyY4';//10.9.25.45
	var API_KEY 	= 'AIzaSyC0cXWjgNL_HEXhvPydEx--UxSAivnqr2Y';//samreportes.solistica.com
	
	function getApiKey(){
		if ( window.location.protocol == "https:"  ){
			return "&key="+API_KEY;
		}else{
			return "";
		}		
	}
	
	function validaDecimal(value, element) {
		return this.optional(element) || /^\d+(\.\d{0,3})?$/.test(value); 	
	}	
	
	var normalize = (function() {
		  var from = "√¿¡ƒ¬»…À ÃÕœŒ“”÷‘Ÿ⁄‹€„‡·‰‚ËÈÎÍÏÌÔÓÚÛˆÙ˘˙¸˚—Ò«Á", 
		      to   = "AAAAAEEEEIIIIOOOOUUUUaaaaaeeeeiiiioooouuuunncc",
		      mapping = {};		 
		  for(var i = 0, j = from.length; i < j; i++ ){
		      mapping[ from.charAt( i ) ] = to.charAt( i );	
		  }
		  return function( str ) {
		      var ret = [];
		      for( var i = 0, j = str.length; i < j; i++ ) {
		          var c = str.charAt( i );
		          if( mapping.hasOwnProperty( str.charAt( i ) ) )
		              ret.push( mapping[ c ] );
		          else
		              ret.push( c );
		      }      
		      return ret.join( '' );
		  };	
	})();	
		
	$.fn.serializeObject = function(){
	    var o = {};
	    var a = this.serializeArray();
	    $.each(a, function() {
	        if (o[this.name] !== undefined) {
	            if (!o[this.name].push) {
	                o[this.name] = [o[this.name]];
	            }
	            o[this.name].push(this.value || '');
	        } else {
	            o[this.name] = this.value || '';
	        }
	    });
	    return o;
	};	

	function esObjetoVacio( obj ){
		if (obj == null || obj == 'undefined' || obj == "" ) {
		    return true;
		}	
		return false;
	}

	function onConfirm( mensaje ){
		var conf = confirm( mensaje );
		if ( conf ){
			return true;
		}else{
			return false;
		}
	}
	
	function scriptGoogleMapsAsynchronous() {
		try{
			  var script = document.createElement('script');
			  script.type = 'text/javascript';
			  script.src = 'https://maps.googleapis.com/maps/api/js?sensor=false'+getApiKey()+'&v=3.exp&libraries=drawing,places&' +
			  'callback=initialize';
			  document.body.appendChild(script);			
		}catch(e){
			alert("Google "+e);
		}
	}
	
	function metrosAMillas(m){
		m = m/1000;
		var mi = m * 0.62137;
		var num = new Number(mi);
		return num.toFixed(3);
	}

	function dataTableComplete(table, aoColumnDefs ){
		 var sUrl = $("#url").val() + "/js/jquery/datatable/oLanguaje/"+$("#languajeSmall").val()+".txt";
		 var oTable = $("#"+table).dataTable({ 
			"sPaginationType"	: "full_numbers", 
			"aaSorting"			: [],  
			"sDom"				: 'TC<"clear">lfrtip',
			"oTableTools"		: {
				"aButtons"				: [
					"copy",
					"print",
					{
						"sExtends"		:	"collection",
						"sButtonText"	: 	"Save",
						"aButtons"		:   [ "csv", "xls", "pdf" ]
					}
				]
			},	
			colVis: {
	            restore: "Restore",
	            showAll: "Show all",
	            showNone: "Show none"
	        },			
			"oLanguage"			: {	"sUrl": sUrl },
			"aoColumnDefs"		: aoColumnDefs
		});		
		try{ oTable.columnFilter(); }catch(	Exception ){ }
		return oTable;
	}	
	
	function dataTableSearchButton(table){
		var sUrl = $("#url").val() + "/js/jquery/datatable/oLanguaje/"+$("#languajeSmall").val()+".txt";
		var oTable = $("#"+table).dataTable({ 
	   		"bPaginate"				: false,
	   		"bInfo"					: false,
			"multipleSelection"		: true,
			"sPaginationType"		: "full_numbers", 
			"aaSorting"				: [],  
			"sDom"					: 'T<"clear">lfrtip',
			"oTableTools"			: {
				"aButtons"				: [
					"copy",
					"print",
					{
						"sExtends"		:    "collection",
						"sButtonText"	: "Save",
						"aButtons"		:    [ "csv", "xls", "pdf" ]
					}
				]
			},	
			"oLanguage"				:{	"sUrl": sUrl	}			
		}).columnFilter();
		return oTable;
	}	
	
	function dataTableSearch(table){
		var sUrl = $("#url").val() + "/js/jquery/datatable/oLanguaje/"+$("#languajeSmall").val()+".txt";
		var oTable = $("#"+table).dataTable({ 
	   		"bPaginate"			: false,
	   		"bInfo"				: false,
			"multipleSelection"	: true,
			"sPaginationType"	: "full_numbers", 
			"aaSorting"			: [],  
			"oLanguage"			: {	"sUrl": sUrl }			
		}).columnFilter();
		return oTable;
	}	

	$(document).keyup(function(e){
		if (e.keyCode == 27){
			$("#divAjaxData").html("");
			$("#divWrap").hide();
			$("#divAjaxData").hide();	
			$("#divFloatData").hide();
			$("#divCloseEdit").click();
		}
	});

	$(document).ajaxStart(function() {
		$("#divCargando").show();
	});
	
	$(document).ajaxStop(function() {
		$("#divCargando").hide();
	});	
	
	$(window).on('beforeunload', function( e ){
		$("#divCargando").show();
	});

    $(document).ready(function(){    
    	$("#divCargando").hide();	/* AL TERMINAR DE CARGAR */
    	$("#divData").show();
    	try{
	    	$("#dtBox").DateTimePicker({    		
	    		dateTimeFormat	: "yyyy-MM-dd HH:mm:ss",
	    		dateFormat		: "yyyy-MM-dd"
	    	});    	
    	}catch(Exception ){}
    	/**
    	 * param = size (en bytes), element = element to validate (<input>), value = value of the element (file name)
    	 */
    	$.validator.addMethod('filesize', function(value, element, param) {
    	    return this.optional(element) || (element.files[0].size <= param) ;
    	});  	
    	jQuery.extend(jQuery.validator.messages,{
    		required: "Es requerido",
    		remote: "Por favor corrija este campo",
    		email: "Por favor introduzca una direccion de correo electronico valida",
    		url: "Por favor introduzca una URL valida",
    		date: "Por favor introduzca una fecha valida",
    		dateISO: "Por favor introduzca una fecha valida (ISO)",
    		number: "Por favor introduzca un numero valido",
    		digits: "Por favor introduzca solo digitos",
    		creditcard: "Por favor introduzca un numero de tarjeta de credito valida",
    		equalTo: "Por favor introduzca algun valor otra vez",
    		acept: "Por favor introduzca un valor con extension valida",
    		maxlength: jQuery.validator.format("Por favor introduzca no mas de {0} caracteres"),
    		minlength: jQuery.validator.format("Por favor introduzca al menos {0} caracteres"),
    		rangelength: jQuery.validator.format("Por favor introduzca un valor entre {0} y {1} caracteres de tamaÒo"),
    		range: jQuery.validator.format("Por favor introduzca un valor entre {0} y {1}"),
    		max: jQuery.validator.format("Por favor introduzca un valor menor que o igual a {0}"),
    		min: jQuery.validator.format("Por favor introduzca un valor mayor que o igual a {0}")
    	}); 
    	jQuery.fn.extend({
    	    param: function( a ) { 
    	        var s = [];   
    	        if ( a.constructor == Array || a.jquery ){	/* If an array was passed in, assume that it is an array of form elements */
    	            jQuery.each( a, function(){				/* Serialize the form elements */ 
    	                s.push(unescape(encodeURIComponent(escape(this.name))) + "=" + unescape(encodeURIComponent(escape(this.value)))); 
    	            }); 
    	        }else{										/* Otherwise, assume that it's an object of key/value pairs */ 
    	            for ( var j in a )						/* Serialize the key/values */
    	                if ( a[j] && a[j].constructor == Array )	/* If the value is an array then the key names need to be repeated */ 
    	                    jQuery.each( a[j], function(){ 
    	                        s.push(unescape(encodeURIComponent(escape(j)) + "=" + encodeURIComponent(escape(this)))); 
    	                    }); 
    	                else 
    	                    s.push(unescape(encodeURIComponent(escape(j)) + "=" + encodeURIComponent(escape(a[j])))); 
    	        } 
    	        return s.join("&").replace(/ /g, "+");		/* Return the resulting serialization */  
    	    },
    	    serialize: function() { 
    	        return this.param(this.serializeArray()); 
    	    }
    	});     
    	$.ajaxSetup ({    	    
    	    cache: false	// Disable caching of AJAX responses
    	});   
	});