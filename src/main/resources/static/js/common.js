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

// lets user to view his information about his request
function openViewForm(id) {
    window.open("../viewForm?id=" + id, "_self");
}
