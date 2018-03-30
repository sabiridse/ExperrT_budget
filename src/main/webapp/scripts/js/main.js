function load(){
	$.ajaxSetup({ 
	    scriptCharset: "utf-8" , 
	    contentType: "application/json; charset=utf-8"
	});
	loadDataForMainTable();
	loadAllList();
}

$( document ).ready(function() {		    
		
//		    $("#registrationForm").submit(function(event) {
//		    	event.preventDefault();
//		    		if ($('#fild').val()!="" & $('#pass').val()!=""){
//		    			setUser();
//		    		} else {message('Не заполнено поле')}	    	
//		    });
//		    
//		    $("#searchForm").submit(function(event) {
//		    	event.preventDefault();
//		    	if ($('#searchFild').val()!=""){
//		    		searchUser();
//		    		$('#searchFild').val('');
//	    		} else {loadAllList();}
//		    	
//		    });
//		    
//		    $("#searchFild").keyup(function(){
//		    	searchUser();
//		    	
//		    });
//		    
//			   $("#tableUsers").tablesorter();
//		    
//		    $("#newlist").click(
//		    		function(){
//		    		window.open("/", '_blank');
//		    	});
//		    
//		    $("#kind").change(function(){
//		    	  
//		    	var selValue = $('#kind option:selected').html();
//		    	//$('#list').append('')
//		    	document.getElementById('list').innerHTML = 'выбран: '+selValue;
//		    	});
		    
		    $("#addNewCategory").click(
		    		function(){
		    		addCategory();
		    	});
		    $("#addNewSumm").click(
		    		function(){
		    		addNewNoteByDays();
		    	});
		    
		    
});

function addCategory(){
	var inputData = {
		id: 0, 	
		category: $('#newCategory').val()
	}
	$('#newCategory').val('');
		$.ajax({
			url:'newCategory',
	        type:'POST',
	        data : JSON.stringify(inputData),
	        success: function(){
		    	loadAllList();
		    }
		}) 		
}

function addNewNoteByDays(){
	var inputData = {
		id: 0, 	
		date: $('#newDate').val(),
		category: $('#categorySelect option:selected').text(),
		summ: $('#newSumm').val(),
		others: $('#newOther').val()		
	}
	$('#newSumm').val('');
	$('#newOther').val('');
		$.ajax({
			url:'newNoteByDays',
	        type:'POST',
	        data : JSON.stringify(inputData),
	        success: function(){
	        	loadDataForMainTable();
		    }
		}) 		
}

function loadDataForMainTable(){	
	$.ajax({
		url:'updateMainTable',
        type:'GET',
	    success: function(response){
	    	updateMainTable(response);
	    }
	})	
}

function updateMainTable(response){
	$('.tr').remove();
	console.log(response.data.lenght);
    for(i=0; i<response.data.length; i++){                  
        $("#tableMain").append('<tr class="tr"> <td>' 
        		+ response.data[i].date + "</td> <td> "
        		+ response.data[i].prihod + "</td> <td> "
        		+ response.data[i].rashod + "</td> <td> "
        		+ response.data[i].ostatok + "</td> <td> "
        		+ response.data[i].dayOfWeek +" </td> </tr>");
    }
    $("#mainTable").trigger('update');
}

function loadAllList(){	
	$.ajax({
		url:'getCategoryList',
        type:'GET',
	    success: function(response){
	    	updateCategorys(response)
	    }
	})	
}

function updateCategorys(response){
	$('.op').remove();
    for(i=0; i<response.data.length; i++){                  
        $( '#categorySelect' ).append( '<option class="op" value="' + i+1 + '">' + response.data[i].category + '</option>' );
    }
   // $('#categorySelect').trigger("chosen:updated");
    //$("#categoryTable").trigger('update');
}