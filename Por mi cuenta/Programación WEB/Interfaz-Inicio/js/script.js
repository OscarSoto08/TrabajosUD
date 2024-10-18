function showSection(sectionId){
    document.getElementById('container-home').style.display = "none";
    document.getElementById('container-login').style.display ="none";
    document.getElementById('container-contact').style.display = "none";
    document.getElementById(sectionId).style.display = "block";
}