var info1 = document.getElementById("info1");
var info2 = document.getElementById("info2");

var contain_courant = document.getElementById("contain_courant");
var contain_simple = document.getElementById("contain_simple");
var contain_bloque = document.getElementById("contain_bloque");

    var courant = document.getElementById("courant");
    var simple = document.getElementById("simple");
    var bloque = document.getElementById("bloque");

var niveau1 =  document.getElementById("niveau1");
var niveau2 =  document.getElementById("niveau2");

window.onload = function() {
    info2.style.display = "none";
}

function suivant(){
    info1.style.display = "none";
    info2.style.display = "block";
    contain_courant.style.display = "none";
    contain_simple.style.display = "none";
    contain_bloque.style.display = "none";
    niveau2.setAttribute("class","active etape");
    niveau1.setAttribute("class","etape");

}

function precedent(){
    info1.style.display = "block";
    info2.style.display = "none";
    niveau2.setAttribute("class","etape");
    niveau1.setAttribute("class","etape active");

}

function typeCompte() {

    if (courant.checked == true){
      contain_courant.style.display = "block";
      contain_simple.style.display = "none";
      contain_bloque.style.display = "none";
    } else {

        if (simple.checked == true){
            contain_courant.style.display = "none";
            contain_simple.style.display = "block";
            contain_bloque.style.display = "none";
          }else{
                contain_courant.style.display = "none";
                contain_simple.style.display = "none";
                contain_bloque.style.display = "block";
          }
    }
}


