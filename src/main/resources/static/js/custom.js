$('#mainContent').load("/main/dashboard");

function changeContent(name){
    
    $('#mainContent').children().remove();
    $('#mainContent').load("/main/"+name);
}

function changeContentCus(path, name){
    
    $('#mainContent').children().remove();
    $('#mainContent').load("/" + path + "/"+name);
}

function changeContentCusdelete(path, name) {
    const $faqNo = $('#faqNo');

    console.log(name);

    $('#mainContent').children().remove();
    $('#mainContent').load("/" + path + "/" + name + "?faqno=" + $faqNo.val());

}

function changeContentCusmodify(path, name) {

    const $faqTtile = $('#faqTitle');
    const $faqContent = $('#faqContent');
    const $faqNo = $('#faqNo');

    $('#mainContent').children().remove();
    $('#mainContent').load("/" + path + "/" + name + "?faqTitle=" + $faqTtile.val() + "&faqContent=" + $faqContent.val() + "&faqNo=" + $faqNo.val());
}

function changeContentN(name){
    console.log(name)
    alert(name);
    $('#mainContent').children().remove();
    $('#mainContent').load("/notice/" + name);
}