var myIndex = 0;

function carousel() {
  var i;
  var x = document.getElementsByClassName("mySlides");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";
  }
  myIndex++;
  if (myIndex > x.length) {myIndex = 1}
  x[myIndex-1].style.display = "block";
  setTimeout(carousel, 2000); // Change image every 2 seconds
}

var modal = document.getElementById('id01');

window.onclick= function(event){
  if (event.target == modal){
    modal.style.display = 'none';
  }
}

// var _CONTENT = ["Ampara", "Anuradhapura","Badulla","Batticaloa","Colombo","Galle","Gampaha","Hambantota","Jaffna","Kalutara","Kandy","Kilinochchi","Kurunegala","Manner","Matale","Monaragala","Mullaitivu","Nuwara Eliya","Polonnaruwa","Puttalam","Ratnapura","Trincomalee","Vavuniya"];
//
// var _PART = 0;
// var _PART_INDEX = 0;
//
// var _INTERVAL_VAL;
//
// var _ELEMENT = document.querySelector("#text");
//
// function Type() {
//   var text = _CONTENT[_PART].substring(0, _PART_INDEX + 1);
//   _ELEMENT.innerHTML = text;
//   _PART_INDEX++;
//
//   if (text === _CONTENT[_PART]) {
//     clearInterval(_INTERVAL_VAL);
//     setTimeout(function () {
//       _INTERVAL_VAL = setInterval(Delete, 50);
//     }, 1000);
//   }
// }
//
// function Delete() {
//   var text = _CONTENT[_PART].substring(0, _PART_INDEX - 1);
//   _ELEMENT.innerHTML = text;
//   _PART_INDEX--;
//
//   if (text === '') {
//     clearInterval(_INTERVAL_VAL);
//
//     if (_PART == (_CONTENT.length - 1))
//       _PART = 0;
//     else
//       _PART++;
//     _PART_INDEX = 0;
//
//     setTimeout(function () {
//       _INTERVAL_VAL = setInterval(Type, 100);
//     }, 200);
//   }
// }
//
// _INTERVAL_VAL = setInterval(Type, 100);
