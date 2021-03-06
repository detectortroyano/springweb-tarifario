/*
 * Datepicker for Jeditable
 *
 * Copyright (c) 2011 Piotr 'Qertoip' WÅ‚odarek
 *
 * Licensed under the MIT license:
 *   http://www.opensource.org/licenses/mit-license.php
 *
 * Depends on jQuery UI Datepicker
 *
 * Project home:
 *   http://github.com/qertoip/jeditable-datepicker
 *
 */

// add :focus selector
jQuery.expr[':'].focus = function( elem ) {
  return elem === document.activeElement && ( elem.type || elem.href );
};

$.editable.addInputType( 'datepicker', {
    /* create input element */
    element: function( settings, original ) {
      var form = $( this ),
          input = $( '<input />' );
      input.attr( 'autocomplete','off' );
      form.append( input );
      return input;
    },    
    /* attach jquery.ui.datepicker to the input element */
    plugin: function( settings, original ) {
      var form = this,
          input = form.find( "input" );
      // Don't cancel inline editing onblur to allow clicking datepicker
      settings.onblur = 'nothing';
      datepicker = {
        onSelect: function() {
          // clicking specific day in the calendar should
          // submit the form and close the input field
          form.submit();
        },        
        onClose: function() {
          setTimeout( function() {
            if ( !input.is( ':focus' ) ) {
              // input has NO focus after 150ms which means
              // calendar was closed due to click outside of it
              // so let's close the input field without saving
              original.reset( form );
            } else {
              // input still HAS focus after 150ms which means
              // calendar was closed due to Enter in the input field
              // so lets submit the form and close the input field
              form.submit();
            }            
            // the delay is necessary; calendar must be already
            // closed for the above :focus checking to work properly;
            // without a delay the form is submitted in all scenarios, which is wrong
          }, 150 );
        }
      };    
      if (settings.datepicker) {
        jQuery.extend(datepicker, settings.datepicker);
      }
      input.datepicker(datepicker);
    }
} );

$.editable.addInputType( 'datetimepicker', {
    /* create input element */
    element: function( settings, original ) {
      var form = $( this ),
          input = $( '<input />' );
      input.attr( 'autocomplete','off' );
      form.append( input );
      return input;
    },    
    /* attach jquery.ui.datepicker to the input element */
    plugin: function( settings, original ) {
      var form = this,
          input = form.find( "input" );
      // Don't cancel inline editing onblur to allow clicking datepicker
      settings.onblur = 'nothing';
      datetimepicker = {    	
        onSelectDate: function() {
        	$(this).hide(); 
        	$(form).trigger("submit"); 
        },     
        onSelectTime: function() {
        	$(this).hide(); 
        	$(form).trigger("submit"); 
        },        
        onClose: function() {
          setTimeout( function() {
            if ( !input.is( ':focus' ) ) {
              // input has NO focus after 150ms which means
              // calendar was closed due to click outside of it
              // so let's close the input field without saving
              original.reset( form );
            } else {
              // input still HAS focus after 150ms which means
              // calendar was closed due to Enter in the input field
              // so lets submit the form and close the input field
              form.submit();
            }            
            // the delay is necessary; calendar must be already
            // closed for the above :focus checking to work properly;
            // without a delay the form is submitted in all scenarios, which is wrong
          }, 150 );
        }
      };    
      if (settings.datetimepicker) {
        jQuery.extend(datetimepicker, settings.datetimepicker);
      }
      input.datetimepicker(datetimepicker);
    }
} );

$.editable.addInputType('autocomplete', {
	/* create input element */
	element: function( settings, original ) {
	  var form = $( this ),
	      input = $( '<input />' );
	  input.attr( 'autocomplete','off' );
	  form.append( input );
	  return input;
	},    
	/* attach jquery.ui.datepicker to the input element */
	plugin: function( settings, original ) {
	  var form = this,
	      input = form.find( "input" );
	  // Don't cancel inline editing onblur to allow clicking datepicker
	  settings.onblur = 'nothing';
	  autocomplete = {    	
	    source : settings.autocomplete.url,
	    /*source: function( request, response ) {
	        $.ajax({
	          url: settings.autocomplete.url,
	          dataType: "json",
	          data: {
	            term: request.term
	          },
	          success: function( data ) {	 
		          response (data);		          
	          },
	        });
	     }, */       
        dataType:'json',
        minLength: 2,	
        select: function( event, ui ) {
        	input.val( ui.item.value );
        	$(this).hide(); 
        	$(form).trigger("submit"); 
        },        
	    onClose: function() {
	      setTimeout( function() {
	        if ( !input.is( ':focus' ) ) {
	          // input has NO focus after 150ms which means
	          // calendar was closed due to click outside of it
	          // so let's close the input field without saving
	          original.reset( form );
	        } else {
	          // input still HAS focus after 150ms which means
	          // calendar was closed due to Enter in the input field
	          // so lets submit the form and close the input field
	          form.submit();
	        }            
	        // the delay is necessary; calendar must be already
	        // closed for the above :focus checking to work properly;
	        // without a delay the form is submitted in all scenarios, which is wrong
	      }, 150 );
	    }
	  };    
	  if (settings.autocomplete) {
	    jQuery.extend(autocomplete, settings.autocomplete);
	  }
	  input.autocomplete(autocomplete);
	}
});    
