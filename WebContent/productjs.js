$(document).ready(function() {
	$("#topform").validate
	({
		rules : {
			productId : "required",
			productname:"required",
				brandname:"required",
				category:"required",
				modelyear:"required",
				listprice:"required",
				orderid:"required",
		},
		messages : {
			productid : "enter",
			productname:"enter name"
		},
	});
});