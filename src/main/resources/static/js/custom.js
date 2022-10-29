$('#mainContent').load("/main/dashboard");

function changeContent(name){
    console.log(name)
    alert(name);
    $('#mainContent').children().remove();
    $('#mainContent').load("/main/"+name);
}