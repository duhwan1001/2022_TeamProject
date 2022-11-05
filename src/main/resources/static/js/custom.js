$('#mainContent').load("/main/dashboard");

function changeContent(name){
    console.log(name)
    alert(name);
    $('#mainContent').children().remove();
    $('#mainContent').load("/main/"+name);
}

function changeContentCus(path, name){
    console.log(name)
    alert(name);
    $('#mainContent').children().remove();
    $('#mainContent').load("/" + path + "/"+name);
}

function changeContentN(name){
    console.log(name)
    alert(name);
    $('#mainContent').children().remove();
    $('#mainContent').load("/notice/" + name);
}