
function calcularTotal(event) {
	var inputSubTotal = document.getElementById('subtotal');
	var subtotal = parseFloat(inputSubTotal.value);
	var total = document.getElementById('total');
	total.setAttribute("value",subtotal*0.82);
}


document.addEventListener('DOMContentLoaded',function(){
	
	var inputSubTotal = document.getElementById('subtotal');
	
	
	console.log('Hello world');
	
	inputSubTotal.onchange = calcularTotal;
	
	
},false);
