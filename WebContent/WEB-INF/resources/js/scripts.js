jQuery(document).ready(function($){
	//console.log(jQuery('a.btn-warning'));
	
	//show hide file upload handle
	/*$("a.fileUploadHandler").click(function(e){
		e.preventDefault();
		
		$(".fileUploadHandle").toggleClass("show");
	});*/
	
	//smart links
	jQuery('a[href="#"]').on('click', function(e){ 
		e.preventDefault();
		$(this).toggleClass("btn-success");
	});
	
});