   /*关闭所有tab*/
   function closeAllTab(tab){	
    	$('.tabs-inner span').each(function(i,n){
    		var t = $(n).text();
    		if(t!=tab){
    			$('#tt').tabs('close',t);
    		}
    	});	
    }
    
    /*打开新的tab*/
    function openTab(plugin){
		closeAllTab(plugin);
		var index=$('#tt').tabs('tabs').length;
		var _closable=false;
		if ($('#tt').tabs('exists',plugin)){
			$('#tt').tabs('select', plugin);
		} else {
			var iframeid="centerIfrmae"+index;
	        var _url=contextPath+'/admin/user/list.htm';
	        var content='<iframe id="'+iframeid+'" src="'+_url+'" frameborder="0" style="border:0;width:100%;height:100%" scrolling="auto"></iframe>';
	        $('#tt').tabs('add',{
	            title: plugin,
	            content: content,
	            closable: _closable
	        });
		}
	}