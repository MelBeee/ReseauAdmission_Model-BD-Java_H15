function GestionCheckBox(className){
 var checkBoxArray =  document.getElementsByClassName("chk_group");

 var checkedValues = '?';

 alert('List length: ' + checkBoxArray.length);
var nb = 0;
 for (var i=0; i<checkBoxArray.length; i++) 
 { 
  var checkBoxRef = checkBoxArray[i];
   
  if ( checkBoxRef.checked == true ) 
  {
    if ( checkedValues.length > 0 ){  
     checkedValues += 'cat'+nb +'=';
     checkedValues += checkBoxRef.value + '&';
     nb++;
   }
  }
}
checkedValues = checkedValues.slice(0,checkedValues.length -1);
 alert('Items checked: ' + checkedValues);

  window.location.href = 'http://localhost:8084/App_Web_2.0/Acceuil' + checkedValues;
}