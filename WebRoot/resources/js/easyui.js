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
    function openTab(plugin,_url){
		//closeAllTab(plugin);
		var index=$('#tt').tabs('tabs').length;
		var _closable=true;
		if ($('#tt').tabs('exists',plugin)){
			$('#tt').tabs('select', plugin);
		} else {
			var iframeid="centerIfrmae"+index;
	        var content='<iframe id="'+iframeid+'" src="'+_url+'" frameborder="0" style="border:0;width:100%;height:98%" scrolling="no"></iframe>';
	        $('#tt').tabs('add',{
	            title: plugin,
	            content: content,
	            closable: _closable
	        });
		}
	}
    
    
    /*easyui extend begin*/
    $.extend($.fn.validatebox.defaults.rules, {
        minLength: {
            validator: function(value, param){
                return value.length >= param[0];
            },
            message: '请最少输入 {0} 个字符。'
        },
	    maxLength: {
	        validator: function(value, param){
	            return value.length <= param[0];
	        },
	        message: '最多只能输入 {0} 个字符。'
	    },
	    number:{
	    	validator: function(value, param){
	    		var reg=/^-?([1-9]\d*\.?\d*|0\.\d*[1-9]\d*)$/; 
	            return null==value || reg.test(value);
	        },
	        message: '只能输入数字。'
	    },
        digit:{
        	validator: function(value, param){
        		var reg=/^-?[1-9]\d*$/;
	            return null==value || reg.test(value);
	        },
	        message: '只能输入整数。'
        },
        mobile:{
        	validator: function(value, param){
        		//var reg= /^(13[0-9]|15[0|3|6|7|8|9]|18[8|9]|17[0-9])\d{8}$/; //严格的手机号验证
        		var reg=/^1\d{10}$/; //简单的手机号验证，以1开头的11位数字
	            return null==value || reg.test(value);
	        },
	        message: '请输入合法的手机号。'
        }
    });
    /*easyui extend end*/