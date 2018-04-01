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
		    		addNewNoteByDays(1);
		    	});
		    $("#addShablon").click(
		    		function(){
		    		addNewNoteByDays(6);
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

function addNewNoteByDays(shablon){
	var inputData = {
		id: 0, 	
		date: $('#newDate').val(),
		category: $('#categorySelect option:selected').text(),
		summ: $('#newSumm').val(),
		others: $('#newOther').val(),
		shablon: shablon
	}
	$('#newSumm').val('');
	$('#newOther').val('');
	
	if(shablon==1)	{
			$.ajax({
				url:'newNoteByDays',
		        type:'POST',
		        data : JSON.stringify(inputData),
		        success: function(){
		        	loadDataForMainTable();
			    }
			})
	}
	if(shablon==6)	{
		var choosedCategory = $('#categorySelect option:selected').text();
		var defoultCategory1 = "продукты";
		var defoultCategory2 = "алкоголь";
		if(choosedCategory == defoultCategory1 || choosedCategory == defoultCategory2){
			$.ajax({
				url:'listNotesEvrDay',
		        type:'POST',
		        data : JSON.stringify(inputData),
		        success: function(){
		        	loadDataForMainTable();
		       	}
			})			
		} else {
			$.ajax({
				url:'listNotesByDays',
		        type:'POST',
		        data : JSON.stringify(inputData),
		        success: function(){
		        	loadDataForMainTable();
		        }
			})
		}			
	}
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

function hotPointsLoad(){
	$.ajax({
		url:'updateHotPointsTable',
        type:'GET',
	    success: function(response){
	    	updateHotPointsTable(response);
	    }
	})	
	
}

function updateHotPointsTable(response){
	$('.tr').remove();
    for(i=0; i<response.data.length; i++){ 
    	var ostatok = response.data[i].ostatok;
    	if(ostatok < 1000){
    		$("#tableHot").append('<tr class="tr" style="background: #FF0000"> <td>' 
            		+ response.data[i].date + "</td> <td> "
            		+ response.data[i].ostatok +" </td> </tr>");
    	} else {
    	$("#tableHot").append('<tr class="tr"> <td>' 
        		+ response.data[i].date + "</td> <td> "
        		+ response.data[i].ostatok +" </td> </tr>");
    	}
    }
    $("#hotPointsTable").trigger('update');
}

function updateMainTable(response){
	$('.tr').remove();
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