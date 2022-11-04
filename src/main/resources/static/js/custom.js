$('#mainContent').load("/main/dashboard");

function changeContent(name){
    
    $('#mainContent').children().remove();
    $('#mainContent').load("/main/"+name);
}

function changeContentCus(path, name){
    
    $('#mainContent').children().remove();
    $('#mainContent').load("/" + path + "/"+name);
}