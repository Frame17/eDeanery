function dropdownExtras() {
    document.getElementById("extrasDropdown").classList.toggle("show");
}

function openReplyForm(id) {
    window.open("../replyForm?id=" + id,"_self");
}

function openAddRequestForm(){
    window.open("../add", "_self");
}

function openUserPage(){
    window.open("../userPage", "_self");
}
